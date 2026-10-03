# Contributing

Thanks for helping keep Aristois usable and studyable. Please read `NOTICE`
first — the client is proprietary, so contributed **tooling, mappings and
documentation** are welcome, but do not relicense or rehost the client itself.

## Highest-value work

### 1. Resolve the `invokedynamic` dispatcher

The recovered client source does not compile because calls were replaced by
method-handle `invokedynamic` instructions. Implementing the resolver described
in `docs/DEOBFUSCATION.md` (`tools/ResolveIndy.java`) is the single biggest win.

### 2. Name mappings

The obfuscated classes are named `me/deftware/aristois/recovered/C####`. Give
them real names by editing `mappings/aristois-class-map.json` (and the derived
`.txt`), then re-run the pipeline. Display names, setting names and descriptions
often survive as string constants, which makes identification easier.

### 3. Installer / version support

`installer/install.py` currently targets Fabric-based versions. Test more
Minecraft versions and report which artifacts resolve.

## Workflow

1. Fork and branch (`git checkout -b feature/thing`).
2. Keep the source buildable where possible (`./gradlew build` for the
   framework). Note: Loom needs ~8 GB RAM.
3. Use 4 spaces; no tabs; no trailing whitespace.
4. Open a PR describing what you changed and how you tested it.

## What not to do

* Do not commit the client jars (they are already referenced, not bundled).
* Do not re-add paywalls, license checks or API-key gates.
* Do not claim affiliation with the original Aristois team.
