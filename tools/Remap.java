import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.Remapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Stream;

/**
 * Stage 2 of the Aristois recovery pipeline.
 *
 * Renames every invalid class/field/method name in the recovered client classes
 * to a valid, deterministic Java name so the result can be decompiled and
 * compiled. Class names come from mappings/aristois-class-map.json (produced by
 * scripts/recover_client.py); member names are hashed deterministically.
 *
 * Usage:
 *   java -cp tools/asm-9.7.1.jar:...:tools Remap <in-dir> <out-dir> <map.json>
 */
public final class Remap {

    private static final Set<String> KEYWORDS = Set.of(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
            "class", "const", "continue", "default", "do", "double", "else", "enum",
            "extends", "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native", "new",
            "package", "private", "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while", "true", "false", "null",
            "var", "record", "yield", "sealed", "permits", "non-sealed");

    private static boolean validIdent(String s) {
        if (s == null || s.isEmpty() || KEYWORDS.contains(s)) return false;
        if (!Character.isJavaIdentifierStart(s.charAt(0))) return false;
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isJavaIdentifierPart(s.charAt(i))) return false;
        }
        return true;
    }

    private static String hash(String s) {
        try {
            byte[] d = MessageDigest.getInstance("MD5")
                    .digest(s.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) sb.append(String.format("%02x", d[i]));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Path inDir = Path.of(args[0]);
        Path outDir = Path.of(args[1]);
        Path mapFile = Path.of(args[2]);

        final Map<String, String> classMap = loadMap(mapFile);
        System.out.println("[+] class name map entries: " + classMap.size());

        Remapper remapper = new Remapper() {
            @Override
            public String map(String internalName) {
                return classMap.getOrDefault(internalName, internalName);
            }

            @Override
            public String mapMethodName(String owner, String name, String descriptor) {
                if (validIdent(name) || name.startsWith("<")) return name;
                return "m_" + hash(owner + "#" + name + descriptor);
            }

            @Override
            public String mapFieldName(String owner, String name, String descriptor) {
                if (validIdent(name)) return name;
                return "f_" + hash(owner + "#" + name + ":" + descriptor);
            }
        };

        int[] count = {0};
        try (Stream<Path> walk = Files.walk(inDir)) {
            walk.filter(p -> p.toString().endsWith(".class")).forEach(p -> {
                try {
                    byte[] data = Files.readAllBytes(p);
                    ClassReader cr = new ClassReader(data);
                    ClassWriter cw = new ClassWriter(0);
                    cr.accept(new ClassRemapper(cw, remapper), 0);
                    String internalName = cr.getClassName();
                    String newName = classMap.getOrDefault(internalName, internalName);
                    Path dest = outDir.resolve(newName + ".class");
                    Files.createDirectories(dest.getParent());
                    Files.write(dest, cw.toByteArray());
                    count[0]++;
                } catch (Exception e) {
                    System.err.println("[!] failed: " + p + " -> " + e);
                }
            });
        }
        System.out.println("[+] remapped " + count[0] + " classes -> " + outDir);
    }

    private static Map<String, String> loadMap(Path mapFile) throws IOException {
        // Raw <old>\t<new> lines. We deliberately avoid JSON here: the
        // obfuscated names start with NUL, which JSON escaping would mangle.
        Map<String, String> map = new HashMap<>();
        for (String line : Files.readAllLines(mapFile, StandardCharsets.UTF_8)) {
            if (line.isEmpty()) continue;
            int tab = line.indexOf('\t');
            if (tab < 0) continue;
            map.put(line.substring(0, tab), line.substring(tab + 1));
        }
        return map;
    }

    private Remap() {}
}
