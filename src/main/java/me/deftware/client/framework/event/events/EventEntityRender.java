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

public class EventEntityRender
extends Event {
    private Entity entity;
    private double x;
    private double y;
    private double z;

    public EventEntityRender create(Entity entity, double x, double y, double z) {
        this.setCanceled(false);
        this.entity = entity;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @Generated
    public Entity getEntity() {
        return this.entity;
    }

    @Generated
    public double getX() {
        return this.x;
    }

    @Generated
    public double getY() {
        return this.y;
    }

    @Generated
    public double getZ() {
        return this.z;
    }
}

