import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Stage 1.5 of the Aristois recovery pipeline: resolve the obfuscator's
 * invokedynamic method-handle dispatcher into direct invocations.
 *
 * MUST run on the ORIGINAL (pre-rename) classes: the encrypted dispatcher keys
 * its table off a hash of the caller's class + method name, so renaming first
 * would break lookups.
 *
 * Dispatchers:
 *   A) static tables
 *      bootstrap(Lookup, String, MethodType, long packed)
 *      packed = (table << 32) | slot; tables built by bN() via Lookup.findStatic.
 *   B) encrypted table
 *      bootstrap(Lookup, String, MethodType, long packed, int kind)
 *      slot = low 32 bits; key = callerClass.hashCode()*31 + callerMethod.hashCode();
 *      table decoded from a Base64 blob (bytes XOR 0xAA).
 *
 * Usage:
 *   java -cp asm...:tools ResolveIndy <in-classes-dir> <out-classes-dir> [--stats]
 */
public final class ResolveIndy {

    private static final class Member {
        final String kind;   // findStatic, findVirtual, findSpecial, findGetter...
        final String owner;  // internal name
        final String name;

        Member(String kind, String owner, String name) {
            this.kind = kind;
            this.owner = owner;
            this.name = name;
        }
    }

    private static final class Resolver {
        // dispatcher internal name -> style
        final Map<String, String> style = new HashMap<>();          // "static" | "encrypted"
        final Map<Integer, Map<Integer, Member>> staticTables = new HashMap<>();
        final Map<Integer, List<String[]>> encrypted = new HashMap<>();
        final Set<String> knownClasses = new HashSet<>();
        final Map<String, Boolean> isInterface = new HashMap<>();

        long dynCount = 0, resolved = 0, unresolved = 0;
        long unresolvedStatic = 0, unresolvedEncrypted = 0, unresolvedUnknown = 0;
        final List<String> samples = new ArrayList<>();
        String staticOwner, encryptedOwner;
    }

    public static void main(String[] args) throws IOException {
        Path inDir = Path.of(args[0]);
        Path outDir = Path.of(args[1]);
        boolean statsOnly = args.length > 2 && args[2].equals("--stats");

        Resolver r = new Resolver();
        Map<String, ClassNode> classes = new LinkedHashMap<>();
        try (Stream<Path> walk = Files.walk(inDir)) {
            walk.filter(p -> p.toString().endsWith(".class")).sorted().forEach(p -> {
                try {
                    ClassNode cn = new ClassNode();
                    new ClassReader(Files.readAllBytes(p)).accept(cn, 0);
                    classes.put(cn.name, cn);
                } catch (Exception e) {
                    System.err.println("[!] read fail " + p + ": " + e);
                }
            });
        }
        for (ClassNode cn : classes.values()) {
            r.knownClasses.add(cn.name);
            r.isInterface.put(cn.name, (cn.access & Opcodes.ACC_INTERFACE) != 0);
        }
        System.out.println("[+] loaded " + classes.size() + " classes");

        discoverDispatchers(r, classes);
        System.out.println("[+] static dispatcher:    " + r.staticOwner);
        System.out.println("[+] encrypted dispatcher: " + r.encryptedOwner);

        if (r.staticOwner != null) parseStaticTables(r, classes.get(r.staticOwner));
        if (r.encryptedOwner != null) parseEncryptedTable(r, classes);

        int changed = 0;
        for (ClassNode cn : classes.values()) {
            for (MethodNode mn : cn.methods) {
                for (AbstractInsnNode insn = mn.instructions.getFirst(); insn != null; ) {
                    AbstractInsnNode next = insn.getNext();
                    if (insn instanceof InvokeDynamicInsnNode) {
                        InvokeDynamicInsnNode indy = (InvokeDynamicInsnNode) insn;
                        r.dynCount++;
                        AbstractInsnNode direct = resolve(r, cn, mn, indy);
                        if (direct != null) {
                            mn.instructions.set(indy, direct);
                            r.resolved++;
                            changed++;
                        } else {
                            r.unresolved++;
                            String st = r.style.get(indy.bsm.getOwner());
                            if ("static".equals(st)) r.unresolvedStatic++;
                            else if ("encrypted".equals(st)) r.unresolvedEncrypted++;
                            else r.unresolvedUnknown++;
                            if (r.samples.size() < 12) {
                                r.samples.add(cn.name + "::" + mn.name
                                        + " bsm=" + indy.bsm.getOwner()
                                        + " args=" + Arrays.toString(indy.bsmArgs));
                            }
                        }
                    }
                    insn = next;
                }
            }
        }

        System.out.println("[+] invokedynamic sites: " + r.dynCount);
        System.out.println("[+] resolved:            " + r.resolved);
        System.out.println("[+] unresolved:          " + r.unresolved
                + " (static=" + r.unresolvedStatic
                + ", encrypted=" + r.unresolvedEncrypted
                + ", unknown=" + r.unresolvedUnknown + ")");
        for (String s : r.samples) System.out.println("      " + s);
        if (statsOnly) return;

        int written = 0;
        for (ClassNode cn : classes.values()) {
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            // Internal names may contain NUL/emoji and are illegal as file paths,
            // so use an opaque filename; the name is read back from the bytes.
            Path dest = outDir.resolve("c" + written + ".class");
            Files.createDirectories(outDir);
            Files.write(dest, cw.toByteArray());
            written++;
        }
        System.out.println("[+] wrote " + written + " classes -> " + outDir);
    }

    // ---- dispatcher discovery -------------------------------------------------

    private static void discoverDispatchers(Resolver r, Map<String, ClassNode> classes) {
        for (ClassNode cn : classes.values()) {
            for (MethodNode mn : cn.methods) {
                if (!mn.name.equals("bootstrap")) continue;
                Type[] a = Type.getArgumentTypes(mn.desc);
                if (a.length < 4
                        || !a[0].getDescriptor().equals("Ljava/lang/invoke/MethodHandles$Lookup;")
                        || !a[1].getDescriptor().equals("Ljava/lang/String;")
                        || !a[2].getDescriptor().equals("Ljava/lang/invoke/MethodType;")) {
                    continue;
                }
                if (a.length == 4 && a[3].getDescriptor().equals("J")) {
                    r.style.put(cn.name, "static");
                    r.staticOwner = cn.name;
                } else if (a.length == 5 && a[3].getDescriptor().equals("J")
                        && a[4].getDescriptor().equals("I")) {
                    r.style.put(cn.name, "encrypted");
                    r.encryptedOwner = cn.name;
                }
            }
        }
    }

    // ---- static tables (C0252-style) -----------------------------------------

    private static void parseStaticTables(Resolver r, ClassNode dispatcher) {
        if (dispatcher == null) return;
        for (MethodNode mn : dispatcher.methods) {
            if (!mn.name.matches("b\\d+")) continue;
            int table = Integer.parseInt(mn.name.substring(1));
            Map<Integer, Member> slots = r.staticTables.computeIfAbsent(table, k -> new HashMap<>());
            Integer slot = null;
            Type lastClass = null;
            String lastName = null;
            for (AbstractInsnNode insn = mn.instructions.getFirst(); insn != null; insn = insn.getNext()) {
                if (insn.getOpcode() == Opcodes.ALOAD
                        && ((VarInsnNode) insn).var == 0) {
                    Integer pushed = intConst(insn.getNext());
                    if (pushed != null) slot = pushed;
                }
                if (insn instanceof LdcInsnNode) {
                    Object c = ((LdcInsnNode) insn).cst;
                    if (c instanceof Type && ((Type) c).getSort() == Type.OBJECT) lastClass = (Type) c;
                    else if (c instanceof String) lastName = (String) c;
                }
                if (insn instanceof MethodInsnNode) {
                    MethodInsnNode mi = (MethodInsnNode) insn;
                    if (mi.owner.endsWith("MethodHandles$Lookup") && mi.name.startsWith("find")
                            && mi.desc.endsWith(")Ljava/lang/invoke/MethodHandle;")) {
                        if (slot != null && lastClass != null && lastName != null) {
                            slots.put(slot, new Member(mi.name, lastClass.getInternalName(), lastName));
                        }
                        slot = null;
                    }
                }
            }
        }
        int n = r.staticTables.values().stream().mapToInt(Map::size).sum();
        System.out.println("[+] static table entries: " + n + " across " + r.staticTables.size() + " tables");
    }

    private static Integer intConst(AbstractInsnNode insn) {
        if (insn instanceof InsnNode && insn.getOpcode() >= Opcodes.ICONST_0
                && insn.getOpcode() <= Opcodes.ICONST_5) {
            return insn.getOpcode() - Opcodes.ICONST_0;
        }
        if (insn instanceof IntInsnNode) return ((IntInsnNode) insn).operand;
        if (insn instanceof LdcInsnNode && ((LdcInsnNode) insn).cst instanceof Integer) {
            return (Integer) ((LdcInsnNode) insn).cst;
        }
        return null;
    }

    // ---- encrypted table (C0114/C0115-style) ---------------------------------

    private static void parseEncryptedTable(Resolver r, Map<String, ClassNode> classes) {
        ClassNode dispatcher = classes.get(r.encryptedOwner);
        if (dispatcher == null) return;

        String implOwner = null;
        for (MethodNode mn : dispatcher.methods) {
            for (AbstractInsnNode insn : mn.instructions) {
                if (insn.getOpcode() == Opcodes.NEW) {
                    implOwner = ((TypeInsnNode) insn).desc;
                }
            }
        }
        if (implOwner == null) {
            System.err.println("[!] no encrypted impl class found");
            return;
        }
        System.out.println("[+] encrypted impl: " + implOwner);
        ClassNode impl = classes.get(implOwner);
        if (impl == null) return;

        StringBuilder b64 = new StringBuilder();
        for (MethodNode mn : impl.methods) {
            for (AbstractInsnNode insn : mn.instructions) {
                if (insn instanceof LdcInsnNode && ((LdcInsnNode) insn).cst instanceof String) {
                    String s = (String) ((LdcInsnNode) insn).cst;
                    if (s.length() > 40 && s.matches("[A-Za-z0-9+/=]+")) b64.append(s);
                }
            }
        }
        if (b64.length() == 0) {
            System.err.println("[!] no Base64 blob found");
            return;
        }
        byte[] raw = Base64.getDecoder().decode(b64.toString());
        int i = 0;
        int tables = readInt(raw, i); i += 4;
        for (int t = 0; t < tables; t++) {
            int key = readInt(raw, i); i += 4;
            int rows = readInt(raw, i); i += 4;
            List<String[]> list = new ArrayList<>();
            for (int row = 0; row < rows; row++) {
                String a = xorString(raw, i); i += 2 + lastLen;
                String b = xorString(raw, i); i += 2 + lastLen;
                list.add(new String[]{a, b});
            }
            r.encrypted.put(key, list);
        }
        int n = r.encrypted.values().stream().mapToInt(List::size).sum();
        System.out.println("[+] encrypted table: " + n + " entries across " + tables + " keys");
    }

    private static int lastLen;

    private static String xorString(byte[] raw, int off) {
        int n = ((raw[off] & 0xFF) << 8) | (raw[off + 1] & 0xFF);
        lastLen = n;
        byte[] out = new byte[n];
        for (int k = 0; k < n; k++) out[k] = (byte) (raw[off + 2 + k] ^ 0xAA);
        return new String(out, StandardCharsets.UTF_8);
    }

    private static int readInt(byte[] b, int o) {
        return ((b[o] & 0xFF) << 24) | ((b[o + 1] & 0xFF) << 16)
                | ((b[o + 2] & 0xFF) << 8) | (b[o + 3] & 0xFF);
    }

    // ---- resolution -----------------------------------------------------------

    private static AbstractInsnNode resolve(Resolver r, ClassNode cn, MethodNode mn,
                                                InvokeDynamicInsnNode indy) {
        String style = r.style.get(indy.bsm.getOwner());
        if (style == null) return null;

        if (style.equals("static")) {
            if (!(indy.bsmArgs.length >= 1 && indy.bsmArgs[0] instanceof Long)) return null;
            long packed = (Long) indy.bsmArgs[0];
            int table = (int) (packed >>> 32);
            int slot = (int) (packed & 0xFFFFFFFFL);
            Map<Integer, Member> slots = r.staticTables.get(table);
            if (slots == null) return null;
            Member m = slots.get(slot);
            if (m == null) return null;
            return toInsn(m, indy.desc, r, false);
        }

        // encrypted
        if (!(indy.bsmArgs.length >= 2 && indy.bsmArgs[0] instanceof Long
                && indy.bsmArgs[1] instanceof Integer)) return null;
        long packed = (Long) indy.bsmArgs[0];
        int kind = (Integer) indy.bsmArgs[1];
        int slot = (int) (packed & 0xFFFFFFFFL);
        int key = cn.name.replace('/', '.').hashCode() * 31 + mn.name.hashCode();
        List<String[]> rows = r.encrypted.get(key);
        if (rows == null || slot < 0 || slot >= rows.size()) return null;
        String[] entry = rows.get(slot);
        String owner = entry[0].replace('.', '/');
        String name = entry[1];
        String kindName = switch (kind) {
            case 1 -> "findStatic";
            case 2 -> "findVirtual";
            case 3 -> "findSpecial";
            default -> null;
        };
        if (kindName == null) return null;
        boolean itf = Boolean.TRUE.equals(r.isInterface.get(owner));
        return toInsn(new Member(kindName, owner, name), indy.desc, r, itf);
    }

    private static AbstractInsnNode toInsn(Member m, String indyDesc, Resolver r, boolean itf) {
        Type mt = Type.getMethodType(indyDesc);
        switch (m.kind) {
            case "findStatic":
                return new MethodInsnNode(Opcodes.INVOKESTATIC, m.owner, m.name, indyDesc, itf);
            case "findVirtual":
                return new MethodInsnNode(Opcodes.INVOKEVIRTUAL, m.owner, m.name,
                        withoutReceiver(mt), itf);
            case "findSpecial":
                return new MethodInsnNode(Opcodes.INVOKESPECIAL, m.owner, m.name,
                        withoutReceiver(mt), itf);
            case "findGetter":
                return new FieldInsnNode(Opcodes.GETFIELD, m.owner, m.name,
                        withoutReceiver(mt));
            case "findStaticGetter":
                return new FieldInsnNode(Opcodes.GETSTATIC, m.owner, m.name, mt.getReturnType().getDescriptor());
            case "findSetter":
                return new FieldInsnNode(Opcodes.PUTFIELD, m.owner, m.name,
                        mt.getArgumentTypes()[1].getDescriptor());
            case "findStaticSetter":
                return new FieldInsnNode(Opcodes.PUTSTATIC, m.owner, m.name,
                        mt.getArgumentTypes()[0].getDescriptor());
            default:
                return null;
        }
    }

    private static String withoutReceiver(Type mt) {
        Type[] args = mt.getArgumentTypes();
        if (args.length == 0) return mt.getDescriptor();
        Type[] rest = Arrays.copyOfRange(args, 1, args.length);
        return Type.getMethodDescriptor(mt.getReturnType(), rest);
    }

    private ResolveIndy() {}
}
