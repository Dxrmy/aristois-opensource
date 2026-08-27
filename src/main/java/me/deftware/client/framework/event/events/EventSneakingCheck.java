/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventSneakingCheck
extends Event {
    private boolean isSneaking;

    public EventSneakingCheck(boolean state) {
        this.isSneaking = state;
    }

    public boolean isSneaking() {
        return this.isSneaking;
    }

    public void setSneaking(boolean isSneaking) {
        this.isSneaking = isSneaking;
    }
}

