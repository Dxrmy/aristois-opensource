/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.command;

import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public abstract class EMCModCommand {
    public abstract CommandBuilder<?> getCommandBuilder();

    public static void print(Message message) {
        new Message.Builder().append("EMC ", Appearance.of(2, DefaultColors.AQUA)).append(Message.CHEVRON + " ", Appearance.of(2, DefaultColors.GRAY)).append(message).build().print();
    }

    public static void print(String text) {
        EMCModCommand.print(Message.of(text));
    }

    public static void error(String text) {
        EMCModCommand.print(Message.of(text).style(Appearance.of(2, DefaultColors.RED)));
    }
}

