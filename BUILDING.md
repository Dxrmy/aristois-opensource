# Building

Everything here builds from this repository plus public Maven mirrors. No
private services or accounts are required for the open-source parts.

## Prerequisites

| Tool | Version | Notes |
|------|---------|-------|
| JDK | 21 | `javac` and `java` on `PATH` (JDK 17 works for the tools too) |
| Python | 3.9+ | for the installer and recovery pipeline |
| RAM | 8 GB+ | the Fabric/Loom build decompiles Minecraft |

## 1. Run the last released version (private install)

```bash
python3 installer/install.py --mc 1.21.4 --verify   # check artifacts resolve
python3 installer/install.py --mc 1.21.4            # install
```

Then open the Minecraft launcher, create an installation for
`1.21.4-Aristois`, and launch. `--game-dir` overrides the target directory and
`--client donor` selects the donor build.

## 2. Build the clean-room client (MIT)

```bash
./gradlew emcClientJar
# -> build/emc/aristois-community-client.jar
```

Copy the jar into `<game>/libraries/EMC/<minecraft-version>/` and the EMC
framework will load it. See `docs/CLIENT.md`.

## 3. Build the EMC framework / integrations from source

```bash
./gradlew build
```

If Gradle runs out of memory, lower `org.gradle.jvmargs` in `gradle.properties`
or run on a machine with more RAM. The first run downloads Minecraft and
decompiles it, which is the slow part.

## 4. Recover a client jar to Java

```bash
python3 scripts/deobfuscate.py --jar libs/aristois-452.jar --out recovered/java
```

This downloads its own tools (Vineflower, ASM) into `tools/` and runs:

1. `scripts/recover_client.py` — recover real class names
2. `tools/ResolveIndy.java` — resolve the `invokedynamic` dispatcher
3. `tools/Remap.java` — rename invalid class/field/method names
4. Vineflower — decompile

## Make targets

```bash
make help
make verify     # syntax check + installer artifact check
make recover    # run the recovery pipeline
make client     # build the clean-room client jar
make build      # build the framework
make install    # install the last released version
make clean
```

## Continuous integration

* `.github/workflows/verify.yml` — Python syntax, tool compilation, artifact
  reachability. Runs on every push and pull request.
* `.github/workflows/build.yml` — the Loom build and artifact upload. Marked
  non-blocking until the build is verified end to end.
