/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.path.OSUtils;

public class ResourceUtils {
    public static InputStream getStreamFromModResources(EMCMod mod, String resourcePath) {
        InputStream in;
        try {
            ZipFile zipFile = new ZipFile(mod.physicalFile);
            ZipEntry entry = zipFile.getEntry(resourcePath);
            in = zipFile.getInputStream(entry);
        }
        catch (Exception e) {
            Bootstrap.logger.error("Requested resource does not exist", (Throwable)e);
            return null;
        }
        return in;
    }

    public static InputStream getStreamFromMinecraftResources(String resourcePath) {
        FileInputStream resource;
        try {
            Bootstrap.logger.debug("Getting resource from: " + String.valueOf(Minecraft.getMinecraftGame()._getGameDir()) + File.separator + resourcePath);
            resource = new FileInputStream(String.valueOf(Minecraft.getMinecraftGame()._getGameDir()) + File.separator + resourcePath);
        }
        catch (Exception e) {
            Bootstrap.logger.error("Requested resource does not exist", (Throwable)e);
            return null;
        }
        return resource;
    }

    public static InputStream getStreamFromUserspace(String resourcePath) {
        FileInputStream resource;
        try {
            resource = OSUtils.isWindows() || OSUtils.isLinux() || OSUtils.isMac() ? new FileInputStream(System.getProperty("user.home") + File.separator + resourcePath) : new FileInputStream("/home/" + System.getProperty("user.name") + File.separator + resourcePath);
            Bootstrap.logger.debug("Getting resource from: " + System.getProperty("user.home") + File.separator + resourcePath);
        }
        catch (Exception e) {
            Bootstrap.logger.error("Requested resource does not exist", (Throwable)e);
            return null;
        }
        return resource;
    }
}

