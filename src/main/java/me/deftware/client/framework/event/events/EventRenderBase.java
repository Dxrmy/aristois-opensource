/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.render.gl.GLX;

public class EventRenderBase
extends Event {
    private GLX context;

    public GLX getContext() {
        return this.context;
    }

    public EventRenderBase setContext(GLX context) {
        this.context = context;
        return this;
    }

    @Override
    public <T extends Event> T broadcast() {
        Object result = super.broadcast();
        this.context = null;
        return result;
    }
}

