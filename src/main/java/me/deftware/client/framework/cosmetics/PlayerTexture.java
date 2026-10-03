/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.texture.PlayerSkinTextureDownloader
 *  net.minecraft.util.Identifier
 */
package me.deftware.client.framework.cosmetics;

import java.io.File;
import java.nio.file.Path;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;
import net.minecraft.client.texture.PlayerSkinTextureDownloader;
import net.minecraft.util.Identifier;

public interface PlayerTexture {
    public MinecraftIdentifier getCapeTexture();

    public static void load(MinecraftIdentifier identifier, File cache) {
        class_10538.method_65861((class_2960)identifier, (Path)cache.toPath(), null, (boolean)false);
    }
}

