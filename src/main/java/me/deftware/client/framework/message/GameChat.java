/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.message;

import java.util.function.Function;
import me.deftware.client.framework.message.Message;

public interface GameChat {
    public void append(Message var1);

    public void remove(Function<String, Boolean> var1);

    public void remove(int var1);
}

