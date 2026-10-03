#!/usr/bin/env python3
"""
Aristois client recovery pipeline — stage 1.

The recovered `libs/aristois-452.jar` contains the real Aristois client, but:
  * 693 of its classes have *blank* ZIP entry names, and
  * every obfuscated class/field/method name is invalid Java
    (keyword packages like `catch/for/finally`, emoji class names, `!!` methods).

This script:
  1. Reads every class in the jar (including blank-named entries).
  2. Recovers the real internal name from the constant pool `this_class`.
  3. Builds a deterministic mapping of every invalid name to a valid Java name:
        class  : me/deftware/aristois/recovered/C0001
        method : method_<n>
        field  : field_<n>
  4. Writes the mapping to mappings/ and a staging jar-ready class tree.

The actual bytecode renaming is done by tools/Remap.java using this mapping's
JSON output. Decompilation is then a plain Vineflower run over the remapped jar.
"""

import argparse
import json
import os
import struct
import sys
import zipfile

# Java keywords + literals that cannot be used as identifiers.
KEYWORDS = {
    "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
    "class", "const", "continue", "default", "do", "double", "else", "enum",
    "extends", "final", "finally", "float", "for", "goto", "if", "implements",
    "import", "instanceof", "int", "interface", "long", "native", "new",
    "package", "private", "protected", "public", "return", "short", "static",
    "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
    "transient", "try", "void", "volatile", "while", "true", "false", "null",
    "var", "record", "yield", "sealed", "permits", "non-sealed",
}


def valid_ident(name: str) -> bool:
    """Return True if `name` is a legal, non-keyword Java identifier."""
    if not name or name in KEYWORDS:
        return False
    first = name[0]
    if not (first.isalpha() or first in "_$"):
        return False
    for ch in name[1:]:
        if not (ch.isalnum() or ch in "_$"):
            return False
    return True


def valid_fqn(name: str) -> bool:
    return all(valid_ident(p) for p in name.split("/") if p != "")


def decode_mutf8(raw: bytes) -> str:
    """Decode JVM 'modified UTF-8', mapping the 2-byte NUL (C0 80) to U+0000.

    The obfuscator prefixes class names with a NUL written as modified UTF-8.
    Plain UTF-8 decoding turns it into U+FFFD, so ASM (which follows the JVM
    spec) and Python would disagree — breaking exact name matching.
    """
    return raw.replace(b"\xc0\x80", b"\x00").decode("utf-8", "replace")


def parse_constant_pool(data: bytes):
    """Return (this_class_name, utf8_entries) for a class file."""
    if data[:4] != b"\xca\xfe\xba\xbe":
        return None, {}
    count = struct.unpack(">H", data[8:10])[0]
    i, idx = 10, 1
    utf8, classes = {}, {}
    while idx < count:
        tag = data[i]
        i += 1
        if tag == 1:  # Utf8
            ln = struct.unpack(">H", data[i:i + 2])[0]
            i += 2
            utf8[idx] = decode_mutf8(data[i:i + ln])
            i += ln
        elif tag == 7:  # Class
            classes[idx] = struct.unpack(">H", data[i:i + 2])[0]
            i += 2
        elif tag in (3, 4, 9, 10, 11, 12, 17, 18):
            i += 4
        elif tag in (5, 6):
            i += 8
            idx += 1
        elif tag in (8, 16, 19, 20):
            i += 2
        elif tag == 15:
            i += 3
        else:
            raise ValueError(f"unknown constant pool tag {tag}")
        idx += 1
    this_idx = struct.unpack(">H", data[i + 2:i + 4])[0]
    return utf8.get(classes.get(this_idx)), utf8


def build_class_map(internal_names):
    """Map invalid internal names -> valid synthetic names, inner-aware."""
    mapping = {}
    counter = 0
    # Pass 1: top-level classes (no '$').
    for name in sorted(internal_names):
        if "$" in name:
            continue
        if valid_fqn(name) and name not in mapping.values():
            mapping[name] = name
        else:
            counter += 1
            mapping[name] = f"me/deftware/aristois/recovered/C{counter:04d}"
    # Pass 2: inner classes, keep them attached to their remapped outer class.
    for name in sorted(internal_names):
        if "$" not in name or name in mapping:
            continue
        outer, _, inner = name.partition("$")
        outer_mapped = mapping.get(outer)
        if outer_mapped is None:
            counter += 1
            outer_mapped = f"me/deftware/aristois/recovered/C{counter:04d}"
            mapping[outer] = outer_mapped
        inner_suffix = inner if valid_ident(inner) else f"anonymous{inner or '0'}"
        mapping[name] = f"{outer_mapped}${inner_suffix}"
    return mapping


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--jar", default="libs/aristois-452.jar")
    ap.add_argument("--out-classes", default="/root/aristois-work/staging/classes")
    ap.add_argument("--out-map", default="mappings/aristois-class-map.json")
    ap.add_argument("--out-map-txt", default="mappings/aristois-class-map.txt",
                    help="raw (control-char safe) old<TAB>new map for the ASM remapper")
    args = ap.parse_args()

    if not os.path.exists(args.jar):
        print(f"[!] jar not found: {args.jar}")
        sys.exit(1)

    os.makedirs(args.out_classes, exist_ok=True)

    zf = zipfile.ZipFile(args.jar)
    class_entries = []
    for info in zf.infolist():
        try:
            data = zf.read(info)
        except Exception:
            continue
        if data[:4] != b"\xca\xfe\xba\xbe":
            continue
        internal, _ = parse_constant_pool(data)
        if internal is None:
            continue
        class_entries.append((info.filename, internal, data))

    print(f"[+] {len(class_entries)} class files in {args.jar}")

    internal_names = [n for (_e, n, _d) in class_entries]
    mapping = build_class_map(internal_names)

    named = sum(1 for n in mapping if mapping[n] == n)
    synthetic = len(mapping) - named
    print(f"[+] name map: {len(mapping)} entries "
          f"({named} already valid, {synthetic} synthesised)")

    # Extract with new paths so the tree is directly usable.
    for entry_name, internal, data in class_entries:
        new_name = mapping[internal]
        dest = os.path.join(args.out_classes, *new_name.split("/")) + ".class"
        os.makedirs(os.path.dirname(dest), exist_ok=True)
        with open(dest, "wb") as fh:
            fh.write(data)

    os.makedirs(os.path.dirname(args.out_map), exist_ok=True)
    with open(args.out_map, "w") as fh:
        json.dump({k: v for k, v in sorted(mapping.items())}, fh, indent=1)

    # Raw map for the ASM remapper: obfuscated names contain leading NUL bytes,
    # which JSON would escape into text and break exact matching.
    with open(args.out_map_txt, "w", encoding="utf-8") as fh:
        for old, new in sorted(mapping.items()):
            fh.write(f"{old}\t{new}\n")

    print(f"[+] classes  -> {args.out_classes}")
    print(f"[+] mapping  -> {args.out_map}")
    print(f"[+] raw map  -> {args.out_map_txt}")


if __name__ == "__main__":
    main()
