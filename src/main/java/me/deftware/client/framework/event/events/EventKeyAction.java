/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventKeyAction
extends Event {
    private int keyCode;
    private int action;
    private int modifiers;

    public EventKeyAction(int keyCode, int action, int modifiers) {
        this.keyCode = keyCode;
        this.action = action;
        this.modifiers = modifiers;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public int getAction() {
        return this.action;
    }

    public int getModifiers() {
        return this.modifiers;
    }
}

