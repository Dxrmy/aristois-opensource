/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.Event;

public class EventEntityUpdated
extends Event {
    private final Change change;
    private final Entity entity;

    public EventEntityUpdated(Change change, Entity entity) {
        this.change = change;
        this.entity = entity;
    }

    public Change getChange() {
        return this.change;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public static enum Change {
        Added,
        Removed;

    }
}

