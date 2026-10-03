/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.network.PacketRegistry;
import me.deftware.client.framework.network.PacketWrapper;
import net.minecraft.network.packet.Packet;

public class EventPacketSend
extends Event {
    private class_2596<?> packet;
    private final PacketWrapper wrapper;

    public EventPacketSend(class_2596<?> packet) {
        this.packet = packet;
        this.wrapper = PacketRegistry.INSTANCE.translate(packet);
    }

    public class_2596<?> getPacket() {
        return this.packet;
    }

    public void setPacket(class_2596<?> packet) {
        this.packet = packet;
    }

    public void setPacket(PacketWrapper packet) {
        this.packet = packet.getPacket();
    }

    public PacketWrapper getIPacket() {
        return this.wrapper;
    }
}

