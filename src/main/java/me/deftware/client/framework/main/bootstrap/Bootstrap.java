/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.mojang.brigadier.tree.CommandNode
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package me.deftware.client.framework.main.bootstrap;

import com.google.gson.JsonObject;
import com.mojang.brigadier.tree.CommandNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.command.commands.CommandHelp;
import me.deftware.client.framework.command.commands.CommandMods;
import me.deftware.client.framework.command.commands.CommandReload;
import me.deftware.client.framework.command.commands.CommandScale;
import me.deftware.client.framework.command.commands.CommandTrigger;
import me.deftware.client.framework.command.commands.CommandUnload;
import me.deftware.client.framework.command.commands.CommandVersion;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.global.types.BlockPropertyManager;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.main.bootstrap.discovery.AbstractModDiscovery;
import me.deftware.client.framework.main.bootstrap.discovery.ClasspathModDiscovery;
import me.deftware.client.framework.main.bootstrap.discovery.DirectoryModDiscovery;
import me.deftware.client.framework.main.bootstrap.discovery.JVMModDiscovery;
import me.deftware.client.framework.main.validation.Validator;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.util.path.LocationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bootstrap {
    public static final Logger logger = LoggerFactory.getLogger((String)"EMC Framework");
    public static ArrayList<JsonObject> modsInfo = new ArrayList();
    public static boolean bootstrapped = false;
    public static boolean initialized = false;
    public static boolean isRunning = true;
    public static File EMC_ROOT;
    public static File EMC_CONFIGS;
    public static Settings EMCSettings;
    private static final ConcurrentHashMap<String, EMCMod> mods;
    private static List<AbstractModDiscovery> modDiscoveries;
    public static final BlockPropertyManager blockProperties;

    public static void init() {
        if (bootstrapped) {
            logger.warn("Tried to call bootstrap init twice! If running with OptiFine you can ignore this.");
            return;
        }
        bootstrapped = true;
        try {
            Keyboard.populateCodePoints();
            for (int i = 0; i < 200 && !System.getProperty("logging" + i, "null").equalsIgnoreCase("null"); ++i) {
                logger.debug(System.getProperty("logging" + i));
            }
            File capesCache = new File(Minecraft.getMinecraftGame()._getGameDir(), "libraries/EMC/capes/");
            if (!capesCache.exists() && !capesCache.mkdirs()) {
                logger.warn("Failed to create EMC capes dir");
            }
            logger.info("Loading EMC v{}.{}", (Object)FrameworkConstants.VERSION, (Object)FrameworkConstants.PATCH);
            EMC_ROOT = new File(Minecraft.getMinecraftGame()._getGameDir(), "libraries" + File.separator + "EMC" + File.separator + Minecraft.getMinecraftVersion() + File.separator);
            logger.info("EMC root dir is {}", (Object)EMC_ROOT.getAbsolutePath());
            EMC_CONFIGS = new File(EMC_ROOT.getAbsolutePath() + File.separator + "configs" + File.separator);
            if (!EMC_ROOT.exists() && !EMC_ROOT.mkdirs()) {
                logger.warn("Failed to create EMC directories");
            }
            if (!EMC_CONFIGS.exists() && !EMC_CONFIGS.mkdirs()) {
                logger.warn("Failed to create EMC config dir");
            }
            logger.debug("EMC root is {}", (Object)EMC_ROOT.getAbsolutePath());
            FrameworkConstants.VALID_EMC_INSTANCE = Validator.isValidInstance();
            if (!FrameworkConstants.VALID_EMC_INSTANCE) {
                logger.warn("EMC instance is not up to date! This may cause instability or crashes.");
            }
            FrameworkConstants.SUBSYSTEM_IN_USE = System.getProperty("SUBSYSTEM", "false").equalsIgnoreCase("true");
            EMCSettings = new Settings("EMC");
            EMCSettings.setupShutdownHook();
            RenderStack.setScale(EMCSettings.getPrimitive("RENDER_SCALE", 1.0f));
            modDiscoveries.forEach(discovery -> {
                discovery.discover();
                if (discovery.size() != 0) {
                    logger.info("{} found {} mod{}", new Object[]{discovery.getClass().getSimpleName(), discovery.size(), discovery.size() != 1 ? "s" : ""});
                }
                discovery.stream().forEach(AbstractModDiscovery.AbstractModEntry::init);
            });
            Bootstrap.registerFrameworkCommands();
            modDiscoveries.forEach(discovery -> discovery.stream().forEach(mod -> {
                try {
                    Bootstrap.loadMod(mod);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    logger.error("Failed to load {}", (Object)mod.getFile().getName());
                }
            }));
        }
        catch (Exception ex) {
            logger.warn("Failed to load EMC", (Throwable)ex);
        }
    }

    public File getEMCJar() {
        return LocationUtil.getEMC().toFile();
    }

    public static void reset() {
        try {
            Bootstrap.ejectMods();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        GameMap.INSTANCE.reset();
        modsInfo.clear();
        mods.clear();
        modDiscoveries.clear();
        modDiscoveries = new ArrayList<AbstractModDiscovery>(Arrays.asList(new JVMModDiscovery(), new DirectoryModDiscovery()));
    }

    private static void registerFrameworkCommands() {
        logger.debug("Loading EMC commands");
        Bootstrap.clearChildren(CommandRegister.getDispatcher().getRoot());
        CommandRegister.clearDispatcher();
        CommandRegister.registerCommand(new CommandMods());
        CommandRegister.registerCommand(new CommandUnload());
        CommandRegister.registerCommand(new CommandVersion());
        CommandRegister.registerCommand(new CommandTrigger());
        CommandRegister.registerCommand(new CommandReload());
        CommandRegister.registerCommand(new CommandScale());
        CommandRegister.registerCommand(new CommandHelp());
    }

    public static synchronized void loadMod(AbstractModDiscovery.AbstractModEntry entry) throws Exception {
        EMCMod mod = entry.toInstance();
        if (mod == null) {
            return;
        }
        String[] minVersion = (entry.getJson().has("minVersion") ? entry.getJson().get("minVersion").getAsString() : String.format("%s.%s", FrameworkConstants.VERSION, FrameworkConstants.PATCH)).split("\\.");
        Object[] objectArray = new Object[]{minVersion[0], minVersion[1]};
        if (Double.parseDouble(String.format("%s.%s", objectArray)) >= FrameworkConstants.VERSION && Integer.parseInt(minVersion[2]) > FrameworkConstants.PATCH) {
            logger.warn("Will not load {}, unsupported EMC version", (Object)entry.getFile().getName());
            return;
        }
        if (!entry.getJson().has("scheme") || entry.getJson().get("scheme").getAsInt() < FrameworkConstants.SCHEME) {
            logger.warn("Will not load unsupported mod {}, unsupported scheme", (Object)entry.getFile().getName());
            return;
        }
        if (mods.containsKey(entry.getJson().get("name").getAsString())) {
            logger.warn("Tried to load duplicate mod {}", (Object)entry.getJson().get("name").getAsString());
            return;
        }
        logger.debug("Loading {} v{} by {}", new Object[]{entry.getJson().get("name").getAsString(), entry.getJson().get("version").getAsString(), entry.getJson().get("author").getAsString()});
        mods.put(entry.getJson().get("name").getAsString(), mod);
        mods.get(entry.getJson().get("name").getAsString()).init(entry.getJson());
        logger.info("Loaded {}", (Object)entry.getJson().get("name").getAsString());
    }

    public static void callMethod(String mod, String method, String caller, Object object) {
        if (mods.containsKey(mod)) {
            logger.debug("Mod {} calling {} in mod {}", new Object[]{caller, method, mod});
            mods.get(mod).callMethod(method, caller, object);
        } else {
            logger.error("EMC mod {} tried to call method {} in mod {}", new Object[]{caller, method, mod});
        }
    }

    public static ConcurrentHashMap<String, EMCMod> getMods() {
        return mods;
    }

    public static void ejectMods() {
        logger.warn("Ejecting all loaded mods");
        for (EMCMod mod : mods.values()) {
            try {
                mod.onUnload();
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
            try {
                mod.classLoader.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        mods.clear();
        Bootstrap.registerFrameworkCommands();
        System.gc();
    }

    private static void clearChildren(CommandNode<?> commandNode) {
        for (CommandNode child : commandNode.getChildren()) {
            Bootstrap.clearChildren(child);
        }
        commandNode.getChildren().clear();
    }

    static {
        mods = new ConcurrentHashMap();
        modDiscoveries = new ArrayList<AbstractModDiscovery>(Arrays.asList(new ClasspathModDiscovery(), new JVMModDiscovery(), new DirectoryModDiscovery()));
        blockProperties = new BlockPropertyManager();
    }
}

