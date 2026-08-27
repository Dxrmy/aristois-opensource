/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_1113;

public class EventSound
extends Event {
    private class_1113 instance;
    private Message translationVal;

    public EventSound(class_1113 instance, Message translationVal) {
        this.instance = instance;
    }

    public String getSoundId() {
        return this.instance.method_4775().toString();
    }

    public Message getSoundName() {
        return this.translationVal;
    }

    public double getX() {
        return this.instance.method_4784();
    }

    public double getY() {
        return this.instance.method_4779();
    }

    public double getZ() {
        return this.instance.method_4778();
    }
}

