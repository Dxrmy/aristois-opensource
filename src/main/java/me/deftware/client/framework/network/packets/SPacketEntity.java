/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.class_1937
 *  net.minecraft.class_2596
 *  net.minecraft.class_2684
 *  net.minecraft.class_310
 */
package me.deftware.client.framework.network.packets;

import javax.annotation.Nullable;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.client.framework.world.ClientWorld;
import net.minecraft.class_1937;
import net.minecraft.class_2596;
import net.minecraft.class_2684;
import net.minecraft.class_310;

public class SPacketEntity
extends PacketWrapper {
    public SPacketEntity(class_2596<?> packet) {
        super(packet);
    }

    public boolean isOnGround() {
        return ((class_2684)this.packet).method_11653();
    }

    @Nullable
    public Entity getEntity() {
        return ClientWorld.getClientWorld().getEntityByReference(((class_2684)this.packet).method_11645((class_1937)class_310.method_1551().field_1687));
    }
}

