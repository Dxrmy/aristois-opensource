#!/usr/bin/env python3
"""
Mapping checker utility — validates aristois-mappings.tiny format
and reports coverage stats.
"""

import sys
import re
from collections import defaultdict

MAPPINGS_PATH = "mappings/aristois-mappings.tiny"

CLASS_PATTERN = re.compile(r"^c\s+(\S+)\s+(\S+)$")
FIELD_PATTERN = re.compile(r"^\tf\s+(\S+)\s+(\S+)\s+(\S+)$")
METHOD_PATTERN = re.compile(r"^\tm\s+(\S+)\s+(\S+)\s+(\S+)$")


def validate():
    if not os.path.exists(MAPPINGS_PATH):
        print(f"[!] No mappings file at {MAPPINGS_PATH}")
        print("[*] Create one or add individual class entries")
        return

    classes = 0
    fields = 0
    methods = 0

    with open(MAPPINGS_PATH, "r") as f:
        for line in f:
            line = line.rstrip()
            if CLASS_PATTERN.match(line):
                classes += 1
            elif FIELD_PATTERN.match(line):
                fields += 1
            elif METHOD_PATTERN.match(line):
                methods += 1

    total = classes + fields + methods
    print(f"[+] Mapping coverage: {classes} classes, {fields} fields, {methods} methods")
    print(f"[+] Total entries: {total}")

    if classes == 0:
        print("[!] WARNING: No class mappings — remap phase will be skipped")
    else:
        print("[*] Pipeline is ready for remapping")


if __name__ == "__main__":
    import os
    validate()