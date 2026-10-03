/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.network.PacketWrapper;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket;

public class SPacketOpenScreen
extends PacketWrapper {
    public SPacketOpenScreen(class_2596<?> packet) {
        super(packet);
    }

    public int getSyncId() {
        return ((class_3944)this.packet).method_17592();
    }
}

