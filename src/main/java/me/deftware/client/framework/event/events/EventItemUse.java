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
import me.deftware.client.framework.item.Item;

public class EventItemUse
extends Event {
    private final Item item;
    private final EntityHand hand;

    public EventItemUse(Item item, EntityHand hand) {
        this.item = item;
        this.hand = hand;
    }

    @Generated
    public Item getItem() {
        return this.item;
    }

    @Generated
    public EntityHand getHand() {
        return this.hand;
    }
}

