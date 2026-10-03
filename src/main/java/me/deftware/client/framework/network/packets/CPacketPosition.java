/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket$PositionAndOnGround
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.network.packets.CPacketPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class CPacketPosition
extends CPacketPlayer {
    public CPacketPosition(class_2596<?> packet) {
        super(packet);
    }

    public CPacketPosition(double xIn, double yIn, double zIn, boolean onGroundIn) {
        super((class_2596<?>)new class_2828.class_2829(xIn, yIn, zIn, onGroundIn, false));
    }
}

