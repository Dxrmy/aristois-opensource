/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.network.PacketWrapper;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;

public class CPacketEntityAction
extends PacketWrapper {
    public CPacketEntityAction(class_2596<?> packet) {
        super(packet);
    }

    public Action getAction() {
        return Action.values()[((class_2848)this.packet).method_12365().ordinal()];
    }

    public static enum Action {
        START_SNEAK,
        STOP_SNEAK,
        STOP_SLEEP,
        START_SPRINT,
        STOP_SPRINT,
        START_HORSE_JUMP,
        STOP_HORSE_JUMP,
        OPEN_INVENTORY,
        START_GLIDING;

    }
}

