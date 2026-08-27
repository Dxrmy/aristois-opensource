/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventFovModifier
extends Event {
    private float fov;

    public EventFovModifier(float fov) {
        this.fov = fov;
    }

    public float getFov() {
        return this.fov;
    }

    public void setFov(float fov) {
        this.fov = fov;
    }
}

