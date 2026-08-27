/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.gui.widgets.properties;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import me.deftware.client.framework.message.Message;

public interface Nameable<T> {
    public Message getComponentLabel();

    public T setComponentLabel(Message var1);

    default public void resetToAfter(int ms, Message text) {
        Executors.newSingleThreadScheduledExecutor().schedule(() -> this.setComponentLabel(text), (long)ms, TimeUnit.MILLISECONDS);
    }
}

