/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package me.deftware.client.framework.event.events;

import lombok.Generated;
import me.deftware.client.framework.entity.block.TileEntity;
import me.deftware.client.framework.event.Event;

public class EventTileBlockRemoved
extends Event {
    private final TileEntity blockEntity;

    @Generated
    public EventTileBlockRemoved(TileEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    @Generated
    public TileEntity getBlockEntity() {
        return this.blockEntity;
    }
}

