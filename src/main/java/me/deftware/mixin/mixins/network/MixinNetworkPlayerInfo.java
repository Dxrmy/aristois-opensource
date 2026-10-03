/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.PlayerListEntry
 *  org.spongepowered.asm.mixin.Mixin
 */
package me.deftware.mixin.mixins.network;

import me.deftware.mixin.imp.IMixinNetworkPlayerInfo;
import net.minecraft.client.network.PlayerListEntry;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={class_640.class})
public class MixinNetworkPlayerInfo
implements IMixinNetworkPlayerInfo {
    @Override
    public void reloadTextures() {
    }
}

