# Recovered Aristois client source

This directory holds a **recovered / decompiled** copy of the Aristois client,
produced by `scripts/deobfuscate.py`. It is published for study, mapping and
reference.

> **Rights notice:** the original client is proprietary
> (`Copyright (C) Aristois 2018 - 2023, All Rights Reserved`). This recovered
> source is **not** MIT-licensed and must not be redistributed as if it were
> your own work. See `../LICENSE` and `../NOTICE`.

## What is here

| Path | Origin |
|------|--------|
| `java/me/deftware/aristois/main`, `menu`, `marketplace`, `services`, `modules` | Non-obfuscated client classes (readable) |
| `java/me/deftware/aristois/recovered/C####.java` | Obfuscated classes renamed to synthetic names by `tools/Remap.java` |

The obfuscated classes are **~693 classes**, of which roughly 172 extend
`me/deftware/aristois/modules/AbstractMod` (the actual modules: hacks, render
utilities, GUI logic).

## Why it does not compile yet

The recovered modules do not call each other directly. The obfuscator replaced
every call with an `invokedynamic` instruction whose bootstrap method resolves a
`java.lang.invoke.MethodHandle` at runtime:

```java
// C0252.bootstrap(Lookup, String, MethodType, long packed)
//   packed = (tableIndex << 32) | slotIndex
//   C0252.b0..b14 populate Object[tableIndex][slotIndex] with
//   lookup.findStatic / findVirtual / findGetter(...) handles.
```

Vineflower renders these as pseudo-syntax that is not valid Java, e.g.:

```java
C0114.bootstrap<"call", 0, 1>(var0, DefaultColors.YELLOW)
C0252.bootstrap<"get", 70>()
```

There are two dispatchers:

* `C0252` — direct `MethodHandle` tables built by `b0..b14`.
* `C0114` / `C0115$anonymous0` — a generic resolver backed by an XOR-0xAA
  encrypted `String[][]` lookup table.

To make the tree compile, an `invokedynamic -> direct invocation` pass is
required (resolve each call site's `MethodHandle` target and rewrite it as
`INVOKESTATIC` / `INVOKEVIRTUAL` / `GETFIELD` / …). See `docs/DEOBFUSCATION.md`.

## Regenerating

```bash
python3 scripts/deobfuscate.py --jar libs/aristois-452.jar --out recovered/java
# or the real last version (v546), if you have it locally:
python3 scripts/deobfuscate.py --jar /path/to/aristois-latest-1.21.4.jar --out recovered/java
```
