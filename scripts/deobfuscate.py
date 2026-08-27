#!/usr/bin/env python3
"""
Aristois Deobfuscation Pipeline
Usage: python deobfuscate.py --jar aristois-latest.jar --output ./src/main/java
"""

import argparse
import os
import subprocess
import sys
import shutil
from pathlib import Path

CFR_JAR = "tools/cfr-0.152.jar"
TINY_REMAPPER = "tools/tiny-remapper-0.9.0.jar"
MAPPINGS = "mappings/aristois-mappings.tiny"


def check_java():
    """Verify Java 17+ is available."""
    try:
        result = subprocess.run(
            ["java", "-version"],
            capture_output=True, text=True
        )
        version_line = result.stderr.split("\n")[0]
        print(f"[+] Java: {version_line}")
    except FileNotFoundError:
        print("[!] Java not found. Install JDK 17+.")
        sys.exit(1)


def decompile(jar_path, output_dir):
    """First-pass decompilation with CFR."""
    print(f"[*] Decompiling {jar_path} -> {output_dir}")
    os.makedirs(output_dir, exist_ok=True)

    cmd = [
        "java", "-jar", CFR_JAR,
        jar_path,
        "--outputdir", output_dir,
        "--silent", "false",
        "--renameillegalidentifiers", "true",
        "--caseinsensitivefs", "true",
        "--aexagg", "true",
        "--hideutf", "false",
        "--removeinnerclasssynthetics", "true",
    ]
    subprocess.run(cmd, check=True)
    print("[+] Decompilation complete")


def remap(decomp_dir, output_dir):
    """Apply deobfuscation mappings to decompiled source."""
    if not os.path.exists(MAPPINGS):
        print("[!] No mappings file found — skipping remap phase")
        print("[*] You can contribute mappings by adding to mappings/aristois-mappings.tiny")
        # Still copy decompiled source forward
        if os.path.exists(output_dir):
            shutil.rmtree(output_dir)
        shutil.copytree(decomp_dir, output_dir)
        return

    print(f"[*] Applying mappings: {MAPPINGS}")
    os.makedirs(output_dir, exist_ok=True)

    cmd = [
        "java", "-jar", TINY_REMAPPER,
        "--input", decomp_dir,
        "--output", output_dir,
        "--mapping", MAPPINGS,
    ]
    subprocess.run(cmd, check=True)
    print("[+] Remapping complete")


def strip_paywalls(src_dir):
    """Remove premium/paywall checks from decompiled source."""
    print("[*] Stripping paywall/API-key validation calls...")
    paywall_patterns = [
        "isPremium",
        "isLoggedIn",
        "hasActiveSubscription",
        "licenseKey",
        "apiKey",
        "validateLicense",
        "PremiumUser",
        "paidUser",
        "checkSubscription",
        "ARISTOIS_API",
        "pastebin.com/",  # config hosting
        "discord.gg/invite/",  # invite validation
    ]

    modified_count = 0
    for root, dirs, files in os.walk(src_dir):
        for file in files:
            if not file.endswith(".java"):
                continue
            path = os.path.join(root, file)
            original = open(path, "r", encoding="utf-8", errors="replace").read()
            modified = original

            for pattern in paywall_patterns:
                if pattern in modified:
                    # Replace paywall checks with pass-through true/available
                    modified = modified.replace(
                        f"return this.{pattern}()",
                        "return true  /* paywall stripped */"
                    )
                    modified = modified.replace(
                        f"return {pattern}()",
                        "return true  /* paywall stripped */"
                    )
                    modified = modified.replace(
                        f".{pattern}()",
                        "/* paywall-stripped */"
                    )

            # Remove API endpoint constants
            modified = modified.replace(
                'private static final String API_URL',
                '// [STRIPPED] private static final String API_URL'
            )
            modified = modified.replace(
                'private static final String LICENSE_SERVER',
                '// [STRIPPED] private static final String LICENSE_SERVER'
            )

            if modified != original:
                open(path, "w", encoding="utf-8").write(modified)
                modified_count += 1

    print(f"[+] Stripped paywall checks in {modified_count} files")


def main():
    parser = argparse.ArgumentParser(description="Aristois deobfuscation pipeline")
    parser.add_argument("--jar", required=True, help="Path to Aristois JAR")
    parser.add_argument("--output", default="./src/main/java", help="Output directory for source")
    parser.add_argument("--skip-paywall", action="store_true", help="Skip paywall stripping")
    args = parser.parse_args()

    jar_path = os.path.abspath(args.jar)
    output_dir = os.path.abspath(args.output)
    decomp_dir = output_dir + "_raw"

    if not os.path.exists(jar_path):
        print(f"[!] JAR not found: {jar_path}")
        sys.exit(1)

    check_java()

    cleanup_dirs = [decomp_dir, output_dir]
    for d in cleanup_dirs:
        if os.path.exists(d):
            shutil.rmtree(d)

    decompile(jar_path, decomp_dir)
    remap(decomp_dir, output_dir)

    if not args.skip_paywall:
        strip_paywalls(output_dir)

    # Clean up raw decompilation
    if os.path.exists(decomp_dir):
        shutil.rmtree(decomp_dir)

    print(f"\n[✓] Pipeline complete. Output: {output_dir}")
    print("[*] Run 'gradle build' to verify compilation")
    print("[*] Contribute mappings in mappings/aristois-mappings.tiny")


if __name__ == "__main__":
    main()