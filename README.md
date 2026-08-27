# Aristois Open-Source Project

> *Community reconstruction of Aristois Minecraft utility client from available artifacts.*

## Current Status

**Framework decompiled ✓** — The EMC-Framework-v2 (446 classes) that Aristois ran on top of has been successfully decompiled and reconstructed.

**Client modules missing ✗** — The actual Aristois client modules (hacks, click GUI, module system) were stored at `maven.aristois.net` which is now defunct. The original devs did not publish the client source code before shutdown.

**Available artifacts:**
- `libs/EMC-F-v2-1.21.4.jar` — Full EMC framework, 446 classes → **decompiled** to `src/main/java/`
- `libs/weaver-1.0.2.jar` — Weaver mod loader → **decompiled** to `src/main/java/me/deftware/weaver/`
- `libs/integrations-1.21.4.jar` — OptiFine/Sodium compat → **decompiled**

**What's needed from the community:**
- Reconstruct the actual Aristois client modules from scratch using the EMC Framework API
- Submit pull requests with module implementations (KillAura, Scaffold, ESP, ClickGUI, etc.)
- Contribute to the deobfuscation mapping file at `mappings/aristois-mappings.tiny`

## Building

```bash
# Requires: JDK 17+, Minecraft 1.21.4 client jar
./gradlew build
```

## Repository Structure

```
aristois-opensource/
├── build.gradle
├── settings.gradle
├── src/main/java/me/deftware/  ← decompiled framework source
│   ├── client/framework/       ← EMC Framework (270+ classes)
│   ├── weaver/                 ← Mod loader
│   └── integrations/           ← OptiFine/Sodium compat
├── libs/                       ← Original JARs (for reference)
├── mappings/                   ← Deobfuscation mappings (community contributed)
├── scripts/
│   ├── deobfuscate.py          ← Pipeline for processing Aristois JARs
│   └── check_mappings.py       ← Mapping validation utility
└── tools/
    └── cfr-0.152.jar           ← Decompiler
```

## How to Contribute

### If you have an Aristois client JAR backup
Run the decompile pipeline:
```bash
python scripts/deobfuscate.py --jar path/to/aristois-client.jar
```

### If you want to help rebuild the client
Study the EMC Framework API in `src/main/java/me/deftware/client/framework/` and implement:
- Module system hooks (event based)
- GUI screens using NanoVG
- Network packet interception
- World rendering modifications

## License

MIT — This project is a community reconstruction. The original Aristois team retains rights to their work. This is NOT affiliated with or endorsed by the original Aristois developers.

## Credits

- **Original Aristois Team** (me.deftware) — 9 years of development, EMC Framework
- **CFR Decompiler** — leibnitz
- **Community Contributors** — Everyone submitting code, mappings, and fixes