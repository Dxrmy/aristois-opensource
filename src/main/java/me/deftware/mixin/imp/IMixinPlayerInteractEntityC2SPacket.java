/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.mixin.imp;

import me.deftware.client.framework.network.packets.CPacketUseEntity;

public interface IMixinPlayerInteractEntityC2SPacket {
    public CPacketUseEntity.Type getActionType();

    public void setActionType(CPacketUseEntity.Type var1);
}

