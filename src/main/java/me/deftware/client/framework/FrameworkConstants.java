/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework;

import me.deftware.client.framework.minecraft.Minecraft;

public class FrameworkConstants {
    public static double VERSION = 17.0;
    public static int PATCH = 0;
    public static int SCHEME = 4;
    public static boolean VALID_EMC_INSTANCE = false;
    public static boolean SUBSYSTEM_IN_USE = false;
    public static boolean CAN_RENDER_SHADER = true;
    public static String FRAMEWORK_MAVEN_URL = "https://gitlab.com/EMC-Framework/maven/raw/master/";
    public static MappingSystem MAPPING_SYSTEM = MappingSystem.YarnV2;
    public static MappingsLoader MAPPING_LOADER = MappingsLoader.Fabric;

    public static String toDataString() {
        return String.format("EMC v%s version %s.%s using %s with %s mappings", SCHEME, VERSION, PATCH, MAPPING_LOADER.name(), MAPPING_SYSTEM.name());
    }

    public static String getFrameworkMaven() {
        Object mavenName = "me.deftware:EMC";
        if (MAPPING_LOADER == MappingsLoader.Forge) {
            mavenName = (String)mavenName + "-Forge";
        } else if (MAPPING_LOADER == MappingsLoader.Fabric) {
            mavenName = (String)mavenName + "-F";
            if (MAPPING_SYSTEM == MappingSystem.YarnV2) {
                mavenName = (String)mavenName + "-v2";
            }
        }
        return (String)mavenName + ":latest-" + Minecraft.getMinecraftVersion();
    }

    static {
        try {
            Class.forName("net.minecraftforge.fml.ModList");
            MAPPING_LOADER = MappingsLoader.Forge;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static enum MappingsLoader {
        Fabric,
        Tweaker,
        Forge;

    }

    public static enum MappingSystem {
        Yarn,
        YarnV2,
        MCPConfig;

    }
}

