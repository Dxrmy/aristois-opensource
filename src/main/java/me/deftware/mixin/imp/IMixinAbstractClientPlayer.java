/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.client.util.SkinTextures
 */
package me.deftware.mixin.imp;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.SkinTextures;

public interface IMixinAbstractClientPlayer {
    public class_640 getPlayerNetworkInfo();

    public class_8685 getCustomSkinTexture();
}

