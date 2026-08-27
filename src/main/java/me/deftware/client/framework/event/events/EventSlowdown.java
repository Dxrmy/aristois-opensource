/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventSlowdown
extends Event {
    private SlowdownType type;
    private float multiplier = 1.0f;

    public EventSlowdown create(SlowdownType type, float multiplier) {
        this.setCanceled(false);
        this.type = type;
        this.multiplier = multiplier;
        return this;
    }

    public SlowdownType getType() {
        return this.type;
    }

    public float getMultiplier() {
        return this.multiplier;
    }

    public void setMultiplier(float value) {
        this.multiplier = value;
    }

    public static enum SlowdownType {
        BerryBush,
        Soulsand,
        Web,
        Item_Use,
        Hunger,
        Blindness,
        Sneak,
        Honey,
        Slipperiness;

    }
}

