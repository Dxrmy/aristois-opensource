/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2616
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.client.framework.world.ClientWorld;
import net.minecraft.class_2596;
import net.minecraft.class_2616;

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

