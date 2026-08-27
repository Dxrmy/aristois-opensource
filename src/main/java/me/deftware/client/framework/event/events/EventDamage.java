/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventDamage
extends Event {
    private DamageSource source;

    public EventDamage(DamageSource source) {
        this.source = source;
    }

    public DamageSource getSource() {
        return this.source;
    }

    public static enum DamageSource {
        BerryBush;

    }
}

