/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2556$class_7602
 *  net.minecraft.class_2561
 *  net.minecraft.class_7471
 */
package me.deftware.client.framework.event.events;

import java.util.UUID;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_2556;
import net.minecraft.class_2561;
import net.minecraft.class_7471;

public class EventChatReceive
extends Event {
    private Message message;
    private final boolean signed;
    private final boolean expired;
    private class_2556.class_7602 arg;
    private final UUID sender;

    public EventChatReceive(class_2556.class_7602 arg, class_7471 message, boolean expired, boolean signed) {
        this.message = (Message)message.method_46291();
        this.expired = expired;
        this.signed = signed;
        this.sender = message.method_46292();
        this.arg = arg;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }

    public boolean isSigned() {
        return this.signed;
    }

    public boolean isExpired() {
        return this.expired;
    }

    public Message getSenderName() {
        return (Message)this.arg.comp_920();
    }

    public class_2556.class_7602 getArg() {
        return this.arg;
    }

    public UUID getSenderId() {
        return this.sender;
    }

    public void setSender(Message name) {
        this.arg = new class_2556.class_7602(this.arg.comp_919(), (class_2561)name, this.arg.comp_921());
    }
}

