/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.client.MinecraftClient
 */
package me.deftware.client.framework.network;

import me.deftware.mixin.imp.IMixinNetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.client.MinecraftClient;

public class PacketWrapper {
    protected class_2596<?> packet;

    public PacketWrapper(class_2596<?> packet) {
        this.packet = packet;
    }

    public class_2596<?> getPacket() {
        return this.packet;
    }

    public void sendPacket() {
        class_310.method_1551().field_1724.field_3944.method_52787(this.packet);
    }

    public void sendImmediately() {
        ((IMixinNetworkManager)class_310.method_1551().field_1724.field_3944.method_48296()).sendPacketImmediately(this.packet);
    }
}

