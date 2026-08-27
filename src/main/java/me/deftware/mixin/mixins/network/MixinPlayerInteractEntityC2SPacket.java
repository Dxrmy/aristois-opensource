/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_2824
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.network;

import lombok.Generated;
import me.deftware.client.framework.network.packets.CPacketUseEntity;
import me.deftware.mixin.imp.IMixinPlayerInteractEntityC2SPacket;
import net.minecraft.class_2824;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_2824.class})
public class MixinPlayerInteractEntityC2SPacket
implements IMixinPlayerInteractEntityC2SPacket {
    @Unique
    private CPacketUseEntity.Type actionType;

    @Override
    @Generated
    public void setActionType(CPacketUseEntity.Type actionType) {
        this.actionType = actionType;
    }

    @Override
    @Generated
    public CPacketUseEntity.Type getActionType() {
        return this.actionType;
    }
}

