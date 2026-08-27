/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package me.deftware.client.framework.event.events;

import lombok.Generated;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.Event;

public class EventEntityPush
extends Event {
    private final Entity entity;

    @Generated
    public EventEntityPush(Entity entity) {
        this.entity = entity;
    }

    @Generated
    public Entity getEntity() {
        return this.entity;
    }
}

