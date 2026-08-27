/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventBlockBreakingSpeed
extends Event {
    private float multiplier = 1.0f;

    public float getMultiplier() {
        return this.multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }
}

