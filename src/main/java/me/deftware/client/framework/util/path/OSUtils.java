/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.util.path;

public class OSUtils {
    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static boolean isMac() {
        return OS.contains("darwin") || OS.contains("mac");
    }

    public static boolean isLinux() {
        return OS.contains("nux");
    }
}

