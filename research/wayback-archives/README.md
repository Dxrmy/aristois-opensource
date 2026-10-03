# Wayback Machine Archives

Files recovered from the Wayback Machine snapshots of `maven.aristois.net`.

## Manifest (2026-08-16)
Source: `https://web.archive.org/web/20260816103358if_/https://maven.aristois.net/manifest`

JSON listing all supported Minecraft versions (1.8.9 through 1.21.4), their
protocol versions, and platform (fabric/tweaker). Some versions also list
Forge as an alternative loader.

## Client JAR (2023-05-21)
Source: `https://web.archive.org/web/20230521060712if_/https://maven.aristois.net/me/deftware/aristois/452/aristois-452.jar`

The actual Aristois client binary. 4.2 MB, ~520 classes including:
- Client main entrypoint
- Module system (~150 hacks)  
- ClickGUI framework
- Marketplace system
- Service integrations

Heavily obfuscated (keyword-name stubs). CFR with `--antiobf true` extracted
37 readable source files.

## Other Wayback URLs Not Recovered
The following paths returned 404 from Wayback (not archived):
- `/me/deftware/aristois/latest/aristois-latest.jar` (free version)
- `/me/deftware/aristois-d/latest/aristois-latest.jar` (donor version)
- `/manifest/{version}.zip?donor=true` (version ZIP downloads)
- `/me/deftware/aristois/loader/latest/aristois-loader.jar`

The CDX search showed only 2 archived JAR files total on the domain.
The rest of the artifacts existed only on the live server at time of
shutdown and were not crawled by Wayback.