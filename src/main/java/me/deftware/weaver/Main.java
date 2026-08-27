/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  joptsimple.ArgumentAcceptingOptionSpec
 *  joptsimple.OptionParser
 *  joptsimple.OptionSet
 *  joptsimple.OptionSpec
 *  me.deftware.client.framework.util.path.LocationUtil
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.loader.impl.launch.knot.Knot
 */
package me.deftware.weaver;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.time.LocalDateTime;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import me.deftware.client.framework.util.path.LocationUtil;
import me.deftware.weaver.Logger;
import me.deftware.weaver.Marketplace;
import me.deftware.weaver.Version;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.impl.launch.knot.Knot;

public class Main {
    public static Version version;
    public static Path gameDir;
    public static Path libraries;
    public static Path versions;
    public static Path mods;
    public static Path emc;
    public static Path emcMods;
    private static Logger logger;

    private static void create(Path ... paths) {
        for (Path path : paths) {
            if (Files.exists(path, new LinkOption[0])) continue;
            logger.info("Creating path %s", path.getFileName().toString());
            try {
                Files.createDirectories(path, new FileAttribute[0]);
            }
            catch (Exception ex) {
                logger.error("Unable to create path", ex);
            }
        }
    }

    public static void main(String[] args) {
        OptionParser parser = new OptionParser();
        parser.allowsUnrecognizedOptions();
        ArgumentAcceptingOptionSpec versionArg = parser.accepts("version").withRequiredArg();
        ArgumentAcceptingOptionSpec gameDirArg = parser.accepts("gameDir").withRequiredArg();
        OptionSet optionSet = parser.parse(args);
        gameDir = Paths.get((String)optionSet.valueOf((OptionSpec)gameDirArg), new String[0]);
        libraries = gameDir.resolve("libraries");
        versions = gameDir.resolve("versions");
        mods = gameDir.resolve("mods");
        Logger.init(gameDir.resolve("weaver.log").toFile());
        logger = new Logger(Main.class.getSimpleName());
        logger.info("Weaver 1.0.2 (Legacy), current date and time is %s", LocalDateTime.now().toString());
        logger.info("Running on %s (%s)", System.getProperty("os.name"), System.getProperty("os.arch"));
        logger.info("Using Java %s", System.getProperty("java.version"));
        logger.info("Source code available at https://gitlab.com/deftware/weaver", new Object[0]);
        Main.create(mods);
        String versionName = (String)optionSet.valueOf((OptionSpec)versionArg);
        File versionJson = versions.resolve(versionName).resolve(versionName + ".json").toFile();
        logger.info("Found version %s", versionJson.getAbsolutePath());
        Gson gson = new Gson();
        try (InputStream stream = Main.class.getResourceAsStream("/version.json");){
            if (stream == null) {
                throw new IOException("Unable to get resource stream");
            }
            try (InputStreamReader reader = new InputStreamReader(stream);){
                version = (Version)gson.fromJson((Reader)reader, Version.class);
                logger.info("Detected Minecraft version %s", version.getId());
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("Unable to get resource stream", ex);
        }
        emcMods = libraries.resolve("EMC").resolve(version.getId());
        try {
            LocationUtil location = LocationUtil.getEMC();
            File file = location.toFile();
            if (file == null) {
                throw new IOException("Location toFile returned null");
            }
            emc = Paths.get(file.getParent(), new String[0]);
            logger.info("Found EMC path %s", emc.toString());
        }
        catch (Exception ex) {
            throw new RuntimeException("Unable to get location of EMC jar file", ex);
        }
        Marketplace.INSTANCE = new Marketplace(version);
        try {
            logger.info("Running marketplace", new Object[0]);
            Marketplace.INSTANCE.init();
            logger.info("Running deduplication", new Object[0]);
            Marketplace.INSTANCE.deduplicate();
            logger.info("Running repair", new Object[0]);
            Marketplace.INSTANCE.repair();
        }
        catch (Exception ex) {
            logger.error("Unable to run marketplace", ex);
        }
        Main.startGame(args);
    }

    private static void startGame(String[] args) {
        try {
            File emcJar = LocationUtil.getEMC().toFile();
            if (emcJar == null) {
                throw new IOException("Unable to find EMC jar");
            }
            Path modsDir = emcJar.getParentFile().toPath();
            logger.info("Setting mods dir to {}", modsDir);
            System.setProperty("fabric.modsFolder", modsDir.toString());
        }
        catch (Exception ex) {
            logger.error("Unable to get EMC jar", ex);
            Logger.close();
            throw new RuntimeException(ex);
        }
        logger.info("Starting game...", new Object[0]);
        Logger.close();
        Knot.launch((String[])args, (EnvType)EnvType.CLIENT);
    }
}

