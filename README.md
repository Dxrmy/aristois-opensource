# Aristois Community Edition

> Community tooling, recovery work and an installer for the Aristois Minecraft
> utility client.

## Status (2026-10)

Aristois **stopped shipping client updates** (last client build: **v546**,
2025-01-12; last EMC framework: **17.0.0-1.21.5**, 2025-03-26), but the
production maven at **`https://maven.aristois.net` is still online** and serving
every artifact. That means the last released version can still be installed and
run today, and this project provides a reproducible installer for it.

| Piece | Where it is now |
|-------|-----------------|
| Client (free) | `me.deftware:aristois:latest-<mc>` — v546, `All Rights Reserved` |
| Client (donor) | `me.deftware:aristois-d:latest-<mc>` — v546 |
| EMC framework | `me.deftware:EMC-F-v2:latest-<mc>` — MIT |
| Weaver / loader | `me.deftware:weaver:1.0.2` under `/emc/` |

> **Rights:** the client is proprietary. This repo's MIT license covers the
> **tooling and the EMC framework**, not the client. See `NOTICE`.

## Install the last version

```bash
python3 installer/install.py --mc 1.21.4 --verify      # check every artifact
python3 installer/install.py --mc 1.21.4               # install
```

This writes `.minecraft/versions/1.21.4-Aristois/`, downloads every library from
the live mavens, and drops the client where the EMC framework scans for mods
(`libraries/EMC/1.21.4/`). Then:

1. Open the Minecraft launcher.
2. Installations → New → Version → `1.21.4-Aristois` → Create.
3. Launch.

The original in-repo installer packages (`libs/1.21.x-Aristois.zip`) still work
too; `installer/install.py` just makes the process automatic and verifiable.

Options: `--client donor`, `--game-dir <path>`, `--mc <version>`.

## Recovering the client source

`libs/aristois-452.jar` (and any client jar) can be turned into Java with the
recovery pipeline. The client is obfuscated with a method-handle
`invokedynamic` dispatcher, so the output is readable but not yet compilable.

```bash
python3 scripts/deobfuscate.py --jar libs/aristois-452.jar --out recovered/java
```

Pipeline:

1. `scripts/recover_client.py` — recovers real class names (many ZIP entries are
   blank) and builds a name map (`mappings/aristois-class-map.*`).
2. `tools/Remap.java` — ASM remapper that renames every invalid
   class/field/method to valid Java names.
3. Vineflower — decompiles the remapped classes.

Output lives in [`recovered/`](recovered/) (508 Java files for v452). See
[`docs/DEOBFUSCATION.md`](docs/DEOBFUSCATION.md) for the obfuscation scheme and
the remaining `invokedynamic` resolution step needed to compile it.

## Repository layout

```
aristois-opensource/
├── installer/install.py        # working launcher-profile installer
├── scripts/
│   ├── deobfuscate.py          # recovery orchestrator
│   ├── recover_client.py       # name recovery + extraction
│   └── check_mappings.py
├── tools/
│   ├── Remap.java              # ASM class/member renaming
│   └── cfr-0.152.jar
├── mappings/                   # recovered name maps + yarn->mojmap
├── recovered/                  # decompiled client (reference only)
├── src/main/java/              # EMC framework / weaver / integrations source
├── src/main/resources/         # genuine EMC fabric.mod.json + mixins + AW
└── libs/                       # recovered reference artifacts
```

## Building the framework

`src/main/java` contains the decompiled **EMC framework** (MIT), the weaver and
integrations. It is a Fabric project. Building needs Minecraft 1.21.4 via Loom
and **~8 GB+ of RAM** (Loom decompiles Minecraft):

```bash
./gradlew build
```

## Credits

* Original Aristois / EMC team (deftware) — the framework and client.
* CFR and Vineflower — decompilers.
* The EMC maven for still serving the artifacts.
