/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1297
 */
package me.deftware.client.framework.event.events;

import lombok.Generated;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.world.ClientWorld;
import net.minecraft.class_1297;

public class EventRenderPlayerModel
extends Event {
    private Entity entity;
    private boolean shouldRender = false;

    public EventRenderPlayerModel create(class_1297 entity) {
        this.shouldRender = false;
        this.entity = ClientWorld.getClientWorld().getEntityByReference(entity);
        return this;
    }

    @Generated
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Generated
    public void setShouldRender(boolean shouldRender) {
        this.shouldRender = shouldRender;
    }

    @Generated
    public Entity getEntity() {
        return this.entity;
    }

    @Generated
    public boolean isShouldRender() {
        return this.shouldRender;
    }
}

