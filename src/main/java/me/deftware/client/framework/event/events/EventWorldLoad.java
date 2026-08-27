/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.world.ClientWorld;

public class EventWorldLoad
extends Event {
    private final ClientWorld world;

    public EventWorldLoad(ClientWorld world) {
        this.world = world;
    }

    public ClientWorld getWorld() {
        return this.world;
    }
}

