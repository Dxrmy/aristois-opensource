/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.client.framework.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;

public class SPacketAnimation
extends PacketWrapper {
    public SPacketAnimation(class_2596<?> packet) {
        super(packet);
    }

    public int getEntityID() {
        return ((class_2616)this.packet).method_11269();
    }

    public int getAnimationID() {
        return ((class_2616)this.packet).method_11267();
    }

    public Entity getEntity() {
        return ClientWorld.getClientWorld()._getEntityById(this.getEntityID());
    }
}

