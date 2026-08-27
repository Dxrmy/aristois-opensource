/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.Message
 */
package me.deftware.client.framework.command.argument;

import com.mojang.brigadier.Message;

public class ArgumentExceptionFunction
implements Message {
    private final String message;

    public ArgumentExceptionFunction(String message) {
        this.message = message;
    }

    public String getString() {
        return this.message;
    }
}

