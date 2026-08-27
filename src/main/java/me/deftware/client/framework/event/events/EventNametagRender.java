/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.world.ClientWorld;
import net.minecraft.class_1297;

public class EventNametagRender
extends Event {
    private Entity entity;

    public EventNametagRender create(class_1297 entity) {
        this.setCanceled(false);
        this.entity = ClientWorld.getClientWorld().getEntityByReference(entity);
        return this;
    }

    public Entity getEntity() {
        return this.entity;
    }
}

