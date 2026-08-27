/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventBlockBreakingCooldown
extends Event {
    private int cooldown;

    public EventBlockBreakingCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
}

