/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventChatSend
extends Event {
    private String message;
    private final Type type;
    private final Class<?> sender;

    public EventChatSend(String message, Class<?> sender, Type type) {
        this.message = message;
        this.sender = sender;
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Class<?> getSender() {
        return this.sender;
    }

    public static enum Type {
        Message,
        Command;

    }
}

