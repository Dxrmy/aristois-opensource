/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket
 *  net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket$OnGroundOnly
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.mixin.imp.IMixinCPacketPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class CPacketPlayer
extends PacketWrapper {
    public CPacketPlayer(class_2596<?> packet) {
        super(packet);
    }

    public CPacketPlayer() {
        super((class_2596<?>)new class_2828.class_5911(false, false));
    }

    public void setOnGround(boolean state) {
        ((IMixinCPacketPlayer)this.getPacket()).setOnGround(state);
    }

    public void setY(double y) {
        ((IMixinCPacketPlayer)this.getPacket()).setY(y);
    }

    public double getY(double currentPosY) {
        return ((class_2828)this.getPacket()).method_12268(currentPosY);
    }

    public void setMoving(boolean state) {
        ((IMixinCPacketPlayer)this.getPacket()).setMoving(state);
    }
}

