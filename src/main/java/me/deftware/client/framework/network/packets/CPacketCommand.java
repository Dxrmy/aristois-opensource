/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket
 *  net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket$Mode
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.network.PacketWrapper;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;

public class CPacketCommand
extends PacketWrapper {
    public CPacketCommand(class_2596<?> packet) {
        super(packet);
    }

    public CPacketCommand(Entity entity, Modes mode) {
        super((class_2596<?>)new class_2848(entity.getMinecraftEntity(), mode.getMinecraftMode()));
    }

    public static enum Modes {
        PRESS_SHIFT_KEY,
        RELEASE_SHIFT_KEY,
        STOP_SLEEPING,
        START_SPRINTING,
        STOP_SPRINTING,
        START_RIDING_JUMP,
        STOP_RIDING_JUMP,
        OPEN_INVENTORY,
        START_FALL_FLYING;


        class_2848.class_2849 getMinecraftMode() {
            return class_2848.class_2849.valueOf((String)this.name());
        }
    }
}

