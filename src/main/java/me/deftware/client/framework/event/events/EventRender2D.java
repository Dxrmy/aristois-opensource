/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.events.EventRenderBase;

public class EventRender2D
extends EventRenderBase {
    protected float partialTicks;

    public float getPartialTicks() {
        return this.partialTicks;
    }

    public EventRender2D create(float partialTicks) {
        this.setCanceled(false);
        this.partialTicks = partialTicks;
        return this;
    }
}

