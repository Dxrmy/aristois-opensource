/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket$Full
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.network.packets.CPacketPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class CPacketPositionRotation
extends CPacketPlayer {
    public CPacketPositionRotation(class_2596<?> packet) {
        super(packet);
    }

    public CPacketPositionRotation(double x, double y, double z, float yaw, float pitch, boolean isOnGround) {
        super((class_2596<?>)new class_2828.class_2830(x, y, z, yaw, pitch, isOnGround, false));
    }
}

