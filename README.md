# Aristois Community Edition

> *Keeping the client alive, for the players.*
> Original Aristois development ceased June 2025 after ~9 years. This is a community-driven revival.

---

## What This Is

Deobfuscated, open-source, paywall-free continuation of the Aristois Minecraft utility client. All premium/licensing code stripped. No API key servers. No license validation. Just the client, compiled from source, maintained by the community.

## What This Isn't

- Not affiliated with the original Aristois team
- Not a fork — this is reconstructed from the latest public release with all proprietary/obfuscated layers removed
- Not monetized — no ads, no paywalls, no premium tiers

## Building

```bash
# Prerequisites: JDK 17+, Git
git clone https://github.com/your-org/aristois-opensource.git
cd aristois-opensource
./gradlew build
```

The output JAR will be in `build/libs/`.

## Deobfuscation Pipeline

If you have the original Aristois JAR and want to contribute improved mappings:

```bash
python scripts/deobfuscate.py --jar aristois-latest.jar
```

This will:
1. Decompile the JAR using CFR
2. Apply current mappings from `mappings/aristois-mappings.tiny`
3. Strip all paywall/license validation code
4. Output clean source to `src/main/java/`

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md).

Mappings are the hardest part — every class, field, and method rename accepted. If you recognize a class from the original client, submit a PR to `mappings/aristois-mappings.tiny`.

## Credits

- **Original Aristois Team** — 9 years of development. This revival exists because of their work.
- **Community Contributors** — Everyone submitting mappings, fixes, and ports.
- **CFR** — Decompiler that made this possible.
- **Fabric Loom** — Build tooling.

## License

MIT — do what you want, just credit the original work.