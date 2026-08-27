/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package me.deftware.client.framework.event.events;

import lombok.Generated;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.world.block.Block;

public class EventBlockUpdate
extends Event {
    private final State state;
    private final BlockPosition position;
    private final Block block;
    private final EntityHand hand;

    public EventBlockUpdate(State state, BlockPosition position, Block block, EntityHand hand) {
        this.state = state;
        this.position = position;
        this.block = block;
        this.hand = hand;
    }

    @Generated
    public State getState() {
        return this.state;
    }

    @Generated
    public BlockPosition getPosition() {
        return this.position;
    }

    @Generated
    public Block getBlock() {
        return this.block;
    }

    @Generated
    public EntityHand getHand() {
        return this.hand;
    }

    public static enum State {
        Place,
        Break;

    }
}

