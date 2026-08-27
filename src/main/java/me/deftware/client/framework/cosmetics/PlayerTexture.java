/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10538
 *  net.minecraft.class_2960
 */
package me.deftware.client.framework.cosmetics;

import java.io.File;
import java.nio.file.Path;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;
import net.minecraft.class_10538;
import net.minecraft.class_2960;

public interface PlayerTexture {
    public MinecraftIdentifier getCapeTexture();

    public static void load(MinecraftIdentifier identifier, File cache) {
        class_10538.method_65861((class_2960)identifier, (Path)cache.toPath(), null, (boolean)false);
    }
}

