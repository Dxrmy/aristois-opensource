# Aristois Open-Source — Recovery Research

This directory contains all research artifacts, raw data, and documentation 
gathered during the reverse-engineering of the Aristois Minecraft utility client.

---

## Source Discovery Timeline

### 1. Installer JAR (`research/installer-analysis/`)
The user provided `Aristois-Client-Installer-All-Versions.jar` (6.9 MB).
Decompiled with CFR to reveal:
- `me.deftware.installer.*` — GUI installer application
- Download URLs for Aristois artifacts from `maven.aristois.net`
- Config JSON showing dependency tree

Key finding: the actual client was downloaded from:
```
https://maven.aristois.net/me/deftware/aristois/latest/aristois-latest.jar
https://maven.aristois.net/me/deftware/aristois-d/latest/aristois-latest.jar (donor)
```

### 2. EMC Framework — GitLab (`research/gitlab-export/`)
```
https://gitlab.com/EMC-Framework/maven
```
The EMC (Easy Minecraft Client) Framework maven repo was still live.
Recovered JARs:
- `EMC-F-v2-latest-1.21.4.jar` (678 KB) — Full framework, 446 classes
- `weaver-1.0.2.jar` (18 KB) — Mod loader
- `integrations-1.21.4.jar` (80 KB) — OptiFine/Sodium compatibility
- `marketplace/index.json` (62 KB) — Module marketplace index
- `versions.json` — Version metadata for all supported MC versions

### 3. Aristois Client JAR — Wayback Machine (`research/wayback-archives/`)
```
https://web.archive.org/web/20230521060712/
https://maven.aristois.net/me/deftware/aristois/452/aristois-452.jar
```
Found via CDX search query:
```
https://web.archive.org/cdx/search/cdx?url=maven.aristois.net/*&filter=mimetype:application/java-archive
```

Results: 2 archived JARs found
- `aristois-452.jar` (4.2 MB) — Actual client, ~520 classes
- `aristois-d-loader.jar` (471 bytes) — Donor loader stub (useless)

Also recovered the manifest from Wayback:
```
https://web.archive.org/web/20260816103358if_/https://maven.aristois.net/manifest
```

### 4. Other GitLab Forks
Searched all Aristois/EMC-related repositories (~30 repos across GitLab and GitHub).
Most were empty, marketing pages, installer UIs, or EMC framework forks.
The Aristois GitHub org repos (`/Aristois/*`) are private/archived.

Only repo with actual client JARs:
- `byburakk4455/Aristois-Donor-Version-For-Everyone-` (ZIP version metadata only, no actual JARs)

---

## Architecture Overview

```
Aristois Client Architecture (runtime assembly):

┌─────────────────────────────────────────┐
│         aristois-452.jar                │ ← Client modules (hacks, GUI, etc.)
│  me.deftware.aristois.*                 │   37 readable source files
│  me.deftware.aristois.modules.*         │   AbstractMod base class
│  me.deftware.aristois.menu.*            │   ClickGUI framework
│  me.deftware.aristois.main.*            │   Entrypoints, validator
│  me.deftware.aristois.services.*        │   Baritone, CraftPresence, SeedCracker
├─────────────────────────────────────────┤
│         EMC-F-v2-1.21.4.jar             │ ← Framework API (decompiled 409 files)
│  me.deftware.client.framework.*         │   
│  me.deftware.mixin.*                    │   124 mixins into Minecraft
├─────────────────────────────────────────┤
│         weaver-1.0.2.jar                │ ← Mod loader (6 classes decompiled)
│  me.deftware.weaver.*                   │   
├─────────────────────────────────────────┤
│         integrations-1.21.4.jar         │ ← Compatibility (OptiFine/Sodium)
│  me.deftware.integrations.*             │   8 mixins
└─────────────────────────────────────────┘
         ↑ Fabric Loader / Minecraft 1.21.4
```

---

## Build Status

The decompiled source uses Yarn intermediary names (`class_XXXX`) for Minecraft 
class references. A mapping file (`mappings/class_to_mojmap.json`) with 8,831 
entries was generated from the official Yarn→Mojmap mapping to translate these
to readable names.

The source has been remapped but does not yet compile due to:
1. Mixin `@Mixin` annotations reference obfuscated class names
2. Missing `fabric.mod.json` and mixin configuration for the framework packages
3. ~480 obfuscated stub classes in the aristois client JAR need deobfuscation

---

## CDX Query Used (Wayback Machine)
```
https://web.archive.org/cdx/search/cdx?url=maven.aristois.net/*&output=json
```
This returns all archived URLs for the domain. Filter by mimetype for JARs:
```
https://web.archive.org/cdx/search/cdx?url=maven.aristois.net/*&filter=mimetype:application/java-archive
```