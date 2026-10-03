# Deobfuscating the Aristois client

This documents the obfuscation scheme found in the recovered client
(`aristois-452.jar`, and identically in the last build, v546), and the concrete
steps needed to turn the recovered source into something that compiles.

## 1. What the obfuscator did

1. **Blanked ZIP entry names.** 693 classes are stored with empty entry names.
   The real class name is still in the constant pool (`this_class`).
   `scripts/recover_client.py` reads it back.
2. **Renamed classes/fields/methods to invalid Java identifiers.** Examples:
   * packages made of keywords: `nunyaboolean/catch/for/finally/...`
   * a leading `U+0000` (written as modified UTF-8 `C0 80`)
   * emoji in names: `...float/m/⛔`
   * method names like `!!`
   `tools/Remap.java` maps all of these to valid, deterministic names
   (`me/deftware/aristois/recovered/C####`, `m_<hash>`, `f_<hash>`).
3. **Replaced calls with `invokedynamic`.** This is the part that stops the
   decompiled source from compiling.

## 2. The invokedynamic dispatcher

Two bootstrap classes are used.

### `C0252` — static MethodHandle tables

```java
private static Object[] a = new Object[15][];
public static CallSite bootstrap(Lookup l, String name, MethodType t, long packed) {
    int table = (int)((packed & 0xFFFFFFFF00000000L) >>> 32);
    int slot  = (int)(packed & 0xFFFFFFFFL);
    Object[] arr = (Object[]) a[table];
    if (arr == null) { /* switch(table) -> b0..b14 builds arr */ }
    return new ConstantCallSite((MethodHandle) arr[slot]);
}
```

Each `bN` fills the table with real targets:

```java
var0[0] = var1.findStatic(C0257.class, "class", var2);
var0[1] = var1.findVirtual(C0123.class, "int", var2);
...
```

Because the target (owner class, member name, member type) is a **constant** in
the `bN` body, every `C0252.bootstrap` call site can be resolved **statically** —
no Minecraft classpath and no runtime needed.

### `C0114` / `C0115$anonymous0` — encrypted table resolver

`C0114.bootstrap(Lookup, String, MethodType, long, int)` untuples `(long, int)`
into `(table, slot)` and delegates to `C0115$anonymous0.m_d8a597a9(...)`, which
decrypts `String[][]` entries with `byte ^ 0xAA` and resolves the member
reflectively. The encrypted blob is embedded in the class. It is decryptable
offline with the same XOR.

## 3. Resolution (implemented)

`tools/ResolveIndy.java` performs steps 1–3 below and **resolves all 6203 of the
obfuscator's call sites** (the remaining 827 `invokedynamic` instructions in the
jar are ordinary Java lambdas and are left alone).

1. **Resolve call sites.** Using ASM, walk every class:
   * For `InvokeDynamicInsnNode` with BSM `C0252.bootstrap`:
     read the `long` bootstrap argument, locate the `bN` builder for that table,
     and map `slot -> (owner, name, descriptor, kind)`.
   * For BSM `C0114.bootstrap`: decrypt the `C0115` table and resolve.
2. **Rewrite each call site** into a direct instruction matching the
   indy descriptor:
   * `findStatic`   -> `INVOKESTATIC`
   * `findVirtual`  -> `INVOKEVIRTUAL` / `INVOKEINTERFACE`
   * `findSpecial`  -> `INVOKESPECIAL`
   * `findGetter/Setter` -> `GETFIELD`/`PUTFIELD`/`GETSTATIC`/`PUTSTATIC`
3. **Rename** with `tools/Remap.java` (member names mapped globally by
   name + descriptor so interface methods and their implementations stay
   linked), then re-run Vineflower. The output is ordinary Java.

> Order matters: `ResolveIndy` must run **before** `Remap`, because the
> encrypted dispatcher keys its table by a hash of the *original* caller class
> and method name. `scripts/deobfuscate.py` enforces this order.

## 4. Why this is safe to run offline

Resolving `C0252` call sites needs only the client jar itself — the targets are
encoded as constants in the dispatcher, not looked up against Minecraft at
deobfuscation time. The `C0114` table is AES/XOR-free (single-byte `0xAA` XOR),
so it is trivially decryptable.
