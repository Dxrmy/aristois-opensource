/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.math.ChunkPosition;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;

public class EventChunkDataReceive
extends Event {
    private final class_1923 rawPos;
    public boolean isInitialFullChunk;
    public boolean updatedIsFullChunk;
    private final class_2672 rootPacket;

    public class_2672 getRootPacket() {
        return this.rootPacket;
    }

    public ChunkPosition getPos() {
        return (ChunkPosition)this.rawPos;
    }

    public EventChunkDataReceive(class_2672 rootPacket) {
        this.rootPacket = rootPacket;
        this.rawPos = new class_1923(rootPacket.method_11523(), rootPacket.method_11524());
        this.isInitialFullChunk = rootPacket.method_11051();
        this.updateFullChunk(rootPacket);
    }

    private void updateFullChunk(class_2672 rootPacket) {
        this.updatedIsFullChunk = rootPacket.method_11051();
    }
}

