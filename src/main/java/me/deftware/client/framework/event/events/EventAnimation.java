/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventAnimation
extends Event {
    private AnimationType type;

    public AnimationType getAnimationType() {
        return this.type;
    }

    public EventAnimation create(AnimationType type) {
        this.setCanceled(false);
        this.type = type;
        return this;
    }

    public static enum AnimationType {
        Totem,
        Wall,
        Fire,
        Underwater,
        Portal,
        Vignette,
        Pumpkin;

    }
}

