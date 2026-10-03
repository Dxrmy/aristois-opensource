#!/usr/bin/env python3
"""
Aristois Community installer.

Assembles a launchable "<mc>-Aristois" profile for the vanilla Minecraft
launcher using the client's original runtime model:

    weaver (main class)  ->  launches Fabric (Knot)
    EMC-F-v2 (Fabric mod) -> scans <game>/libraries/EMC/<mc>/ for client jars
    client jar (v546)     -> read via its embedded client.json

Everything except the vanilla Minecraft assets/client is downloaded from live
mavens (maven.aristois.net, maven.fabricmc.net, Maven Central) so the profile
works without the original download server being up *at launch time*. The
vanilla launcher still supplies the Minecraft client jar and assets.

`--client` selects which client jar is placed in the EMC mods directory:

    free       me.deftware:aristois:latest-<mc>    (from the vendor maven)
    donor      me.deftware:aristois-d:latest-<mc>  (from the vendor maven)
    community  this project's own MIT client jar, fetched from the latest
               GitHub release (see .github/workflows/release.yml)

Usage:
    python3 installer/install.py --mc 1.21.4
    python3 installer/install.py --mc 1.21.4 --game-dir "C:/Users/me/AppData/Roaming/.minecraft"
    python3 installer/install.py --mc 1.21.4 --client donor
    python3 installer/install.py --mc 1.21.4 --client community
    python3 installer/install.py --mc 1.21.4 --verify      # HEAD-check only
"""

import argparse
import json
import os
import platform
import sys
import urllib.request
import urllib.error

ARISTOIS_MAVEN = "https://maven.aristois.net/"
FABRIC_MAVEN = "https://maven.fabricmc.net/"
CENTRAL_MAVEN = "https://repo.maven.apache.org/maven2/"

GITHUB_OWNER = "Dxrmy"
GITHUB_REPO = "aristois-opensource"
COMMUNITY_JAR = "aristois-community-client.jar"
COMMUNITY_URL = (f"https://github.com/{GITHUB_OWNER}/{GITHUB_REPO}"
                 f"/releases/latest/download/{COMMUNITY_JAR}")

# Public maven coordinates. `mc`/`intermediary` are filled from --mc.
# version format: group:artifact:version
BASE_LIBS_1214 = [
    ("me.deftware:weaver:1.0.2", ARISTOIS_MAVEN + "emc/"),
    ("net.fabricmc:fabric-loader:0.16.10", FABRIC_MAVEN),
    ("net.fabricmc:sponge-mixin:0.15.4+mixin.0.8.7", FABRIC_MAVEN),
    ("org.ow2.asm:asm:9.7.1", FABRIC_MAVEN),
    ("org.ow2.asm:asm-analysis:9.7.1", FABRIC_MAVEN),
    ("org.ow2.asm:asm-commons:9.7.1", FABRIC_MAVEN),
    ("org.ow2.asm:asm-tree:9.7.1", FABRIC_MAVEN),
    ("org.ow2.asm:asm-util:9.7.1", FABRIC_MAVEN),
    ("io.netty:netty-codec-socks:4.1.76.Final", CENTRAL_MAVEN),
    ("io.netty:netty-handler-proxy:4.1.76.Final", CENTRAL_MAVEN),
    ("com.thealtening.auth:auth:3.0.2-j9", CENTRAL_MAVEN),
]

CLIENT_ARTIFACT = {
    "free": "aristois",
    "donor": "aristois-d",
}


def default_game_dir():
    home = os.path.expanduser("~")
    system = platform.system()
    if system == "Windows":
        base = os.environ.get("APPDATA", os.path.join(home, "AppData", "Roaming"))
        return os.path.join(base, ".minecraft")
    if system == "Darwin":
        return os.path.join(home, "Library", "Application Support", "minecraft")
    return os.path.join(home, ".minecraft")


def coord_path(coord):
    group, artifact, version = coord.split(":")
    group_path = group.replace(".", "/")
    filename = f"{artifact}-{version}.jar"
    return f"{group_path}/{artifact}/{version}/{filename}"


def library_url(coord, base):
    return base.rstrip("/") + "/" + coord_path(coord)


def download(url, dest, verify_only=False):
    if os.path.exists(dest) and not verify_only:
        print(f"    exists  {os.path.relpath(dest)}")
        return True
    if verify_only:
        try:
            req = urllib.request.Request(url, method="HEAD")
            with urllib.request.urlopen(req, timeout=30) as r:
                code = r.status
            print(f"    {code}  {url}")
            return 200 <= code < 400
        except Exception as e:
            print(f"    ERR  {url}  ({e})")
            return False
    os.makedirs(os.path.dirname(dest), exist_ok=True)
    tmp = dest + ".part"
    print(f"    GET     {url}")
    try:
        urllib.request.urlretrieve(url, tmp)
        os.replace(tmp, dest)
        return True
    except Exception as e:
        if os.path.exists(tmp):
            os.remove(tmp)
        print(f"    FAILED  {url}  ({e})")
        return False


def build_profile(mc, client):
    libs = [{"name": name, "url": url} for name, url in BASE_LIBS_1214]
    # The EMC framework lives under /emc/ on the Aristois maven.
    libs.append({"name": f"me.deftware:EMC-F-v2:latest-{mc}",
                 "url": ARISTOIS_MAVEN + "emc/"})
    libs.append({"name": f"net.fabricmc:intermediary:{mc}", "url": FABRIC_MAVEN})
    profile = {
        "libraries": libs,
        "mainClass": "me.deftware.weaver.Main",
        "id": f"{mc}-Aristois",
        "time": "2026-10-03T00:00:00+00:00",
        "releaseTime": "2026-10-03T00:00:00+00:00",
        "inheritsFrom": mc,
        "type": "release",
    }
    return profile


def main():
    ap = argparse.ArgumentParser(description="Install Aristois for a Minecraft version")
    ap.add_argument("--mc", default="1.21.4", help="Minecraft version (default 1.21.4)")
    ap.add_argument("--game-dir", default=None, help=".minecraft directory")
    ap.add_argument("--client", choices=["free", "donor", "community"],
                    default="free",
                    help="client jar: free/donor from the vendor maven, "
                         "community = this project's MIT client from GitHub releases")
    ap.add_argument("--verify", action="store_true",
                    help="only HEAD-check that every artifact is reachable")
    args = ap.parse_args()

    game = os.path.abspath(args.game_dir or default_game_dir())
    mc = args.mc
    vid = f"{mc}-Aristois"
    print(f"[*] Minecraft {mc} -> {game}")

    libraries = game + "/libraries"
    # --- libraries ---
    print("[*] Downloading libraries")
    ok = True
    for name, url in BASE_LIBS_1214 + [
        (f"me.deftware:EMC-F-v2:latest-{mc}", ARISTOIS_MAVEN + "emc/"),
        (f"net.fabricmc:intermediary:{mc}", FABRIC_MAVEN),
    ]:
        link = library_url(name, url)
        dest = os.path.join(libraries, *coord_path(name).split("/"))
        ok &= download(link, dest, args.verify)

    # --- client jar into the EMC mods directory ---
    if args.client == "community":
        # Our own MIT client, fetched from this repository's latest release.
        client_url = COMMUNITY_URL
        client_dest = os.path.join(libraries, "EMC", mc, COMMUNITY_JAR)
    else:
        art = CLIENT_ARTIFACT[args.client]
        client_coord = f"me.deftware:{art}:latest-{mc}"
        client_url = f"{ARISTOIS_MAVEN}{coord_path(client_coord)}"
        client_dest = os.path.join(libraries, "EMC", mc,
                                   f"{art}-latest-{mc}.jar")
    print(f"[*] Client ({args.client})")
    ok &= download(client_url, client_dest, args.verify)

    if args.verify:
        print("[+] Verification complete." if ok else "[!] Some artifacts failed.")
        return 0 if ok else 1

    # --- version profile ---
    vdir = os.path.join(game, "versions", vid)
    os.makedirs(vdir, exist_ok=True)
    profile_path = os.path.join(vdir, vid + ".json")
    with open(profile_path, "w", encoding="utf-8") as fh:
        json.dump(build_profile(mc, args.client), fh, indent=2)
    print(f"[+] Wrote profile: {profile_path}")

    print("\n[+] Done. Next:")
    print("    1. Open the Minecraft launcher (with Fabric/vanilla 1.21.x available).")
    print(f"    2. Installations -> New -> Version -> select '{vid}'.")
    print(f"    3. Launch. The client is at libraries/EMC/{mc}/.")
    print("\n[!] The original Aristois client is proprietary (All Rights Reserved).")
    print("    Keep installs private unless you have redistribution rights.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
