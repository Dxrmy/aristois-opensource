/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.world.block.Block;

public class EventCollideCheck
extends Event {
    private final Block block;
    private final BlockPosition position;
    public boolean updated = false;
    public boolean canCollide;

    public EventCollideCheck(Block block, BlockPosition position) {
        this.block = block;
        this.position = position;
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockPosition getPosition() {
        return this.position;
    }

    public void setCollidable(boolean canCollide) {
        this.updated = true;
        this.canCollide = canCollide;
    }
}

