#!/usr/bin/env python3
"""
Aristois client recovery pipeline (orchestrator).

The old version of this script expected a `tools/tiny-remapper-*.jar` and a
hand-written `mappings/aristois-mappings.tiny`, neither of which ever existed in
this repository, so it could never run. This rewrite drives the pipeline that
actually works against the recovered client jar:

    recover_client.py   recover real class names + build a name map
    tools/Remap.java    rename every invalid class/field/method (ASM)
    tools/vineflower.jar decompile the remapped classes to Java

Usage:
    python3 scripts/deobfuscate.py --jar libs/aristois-452.jar \
        --out recovered/java --work /root/aristois-work

Prerequisites (downloaded automatically if absent):
    tools/vineflower.jar
    tools/asm-*.jar
"""

import argparse
import os
import shutil
import subprocess
import sys
import urllib.request

REPO = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
TOOLS = os.path.join(REPO, "tools")
VINEFLOWER = os.path.join(TOOLS, "vineflower.jar")
VINEFLOWER_URL = ("https://github.com/Vineflower/vineflower/releases/download/"
                  "1.10.1/vineflower-1.10.1.jar")
ASM_VERSION = "9.7.1"
ASM_MODULES = ["asm", "asm-commons", "asm-tree", "asm-util", "asm-analysis"]
ASM_CP = os.pathsep.join(
    os.path.join(TOOLS, f"{m}-{ASM_VERSION}.jar") for m in ASM_MODULES
)


def run(cmd, **kw):
    print("[*]", " ".join(str(c) for c in cmd))
    subprocess.run(cmd, check=True, **kw)


def ensure_tools():
    if not os.path.exists(VINEFLOWER):
        print(f"[*] Downloading Vineflower -> {VINEFLOWER}")
        urllib.request.urlretrieve(VINEFLOWER_URL, VINEFLOWER)
    for m in ASM_MODULES:
        jar = os.path.join(TOOLS, f"{m}-{ASM_VERSION}.jar")
        if not os.path.exists(jar):
            url = (f"https://repo1.maven.org/maven2/org/ow2/asm/{m}/"
                   f"{ASM_VERSION}/{m}-{ASM_VERSION}.jar")
            print(f"[*] Downloading {m} -> {jar}")
            urllib.request.urlretrieve(url, jar)


def build_tools():
    """Compile the ASM-based tools (Java 17 bytecode) into TOOLS."""
    for src in ("Remap.java", "ResolveIndy.java"):
        cls = src[:-5] + ".class"
        cf = os.path.join(TOOLS, cls)
        if os.path.exists(cf):
            os.remove(cf)
    run(["javac", "--release", "17", "-cp", ASM_CP, "-d", TOOLS,
         os.path.join(TOOLS, "Remap.java"),
         os.path.join(TOOLS, "ResolveIndy.java")])


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--jar", default=os.path.join(REPO, "libs", "aristois-452.jar"))
    ap.add_argument("--out", default=os.path.join(REPO, "recovered", "java"))
    ap.add_argument("--work", default="/tmp/aristois-work")
    ap.add_argument("--keep-raw", action="store_true",
                    help="keep the remapped .class tree (default: delete it)")
    args = ap.parse_args()

    if not os.path.exists(args.jar):
        print(f"[!] jar not found: {args.jar}")
        sys.exit(1)

    ensure_tools()

    classes = os.path.join(args.work, "staging", "classes")
    resolved = os.path.join(args.work, "staging", "resolved")
    remapped = os.path.join(args.work, "staging", "remapped")
    for d in (classes, resolved, remapped):
        shutil.rmtree(d, ignore_errors=True)

    # 1. Recover names + extract classes with new paths, writing the name maps.
    run([sys.executable, os.path.join(REPO, "scripts", "recover_client.py"),
         "--jar", args.jar,
         "--out-classes", classes,
         "--out-map", os.path.join(REPO, "mappings", "aristois-class-map.json"),
         "--out-map-txt", os.path.join(REPO, "mappings", "aristois-class-map.txt")])

    # 2. Resolve the obfuscator's invokedynamic dispatcher into direct calls.
    #    This MUST happen before renaming: the encrypted dispatcher hashes the
    #    caller class + method name.
    build_tools()
    run(["java", "-Xmx1g", "-cp", TOOLS + os.pathsep + ASM_CP, "ResolveIndy",
         classes, resolved])

    # 3. Rewrite class/field/method names to valid Java.
    run(["java", "-Xmx768m", "-cp", TOOLS + os.pathsep + ASM_CP, "Remap",
         resolved, remapped,
         os.path.join(REPO, "mappings", "aristois-class-map.txt")])

    # 4. Decompile.
    shutil.rmtree(args.out, ignore_errors=True)
    os.makedirs(args.out, exist_ok=True)
    run(["java", "-Xmx1500m", "-jar", VINEFLOWER,
         "-dgs=1", "-hdc=0", "-asc=1", "-rsy=1", "-lit=1",
         remapped, args.out])

    if not args.keep_raw:
        shutil.rmtree(remapped, ignore_errors=True)
        shutil.rmtree(resolved, ignore_errors=True)

    n = sum(len(files) for _r, _d, files in os.walk(args.out)
            for f in files if f.endswith(".java"))
    print(f"\n[+] Done. {n} Java files -> {args.out}")
    print("[*] The invokedynamic dispatcher has been resolved to direct calls.")
    print("[*] Remaining work before a full build: port against the matching EMC API.")


if __name__ == "__main__":
    main()
