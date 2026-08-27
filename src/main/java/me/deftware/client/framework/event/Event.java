/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event;

import me.deftware.client.framework.event.EventBus;

public class Event {
    private boolean canceled = false;

    public <T extends Event> T broadcast() {
        EventBus.INSTANCE.broadcast(this);
        return (T)this;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}

