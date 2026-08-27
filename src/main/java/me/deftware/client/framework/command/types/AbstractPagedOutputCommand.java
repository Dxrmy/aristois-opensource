/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.builder.RequiredArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 */
package me.deftware.client.framework.command.types;

import com.google.common.collect.Lists;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public abstract class AbstractPagedOutputCommand
extends EMCModCommand {
    protected final Message title;
    protected final String command;
    protected int chunkSize = 6;
    private final List<String> previousOuput = new ArrayList<String>();

    public AbstractPagedOutputCommand(String command, Message title) {
        this.command = command;
        this.title = title;
    }

    public abstract List<Message> list();

    public List<List<Message>> getChunks() {
        return Lists.partition(this.list(), (int)this.chunkSize);
    }

    @Override
    public CommandBuilder<?> getCommandBuilder() {
        return new CommandBuilder().set((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal((String)this.command).then(RequiredArgumentBuilder.argument((String)"page", (ArgumentType)IntegerArgumentType.integer((int)1)).executes(c -> this.onExecute(IntegerArgumentType.getInteger((CommandContext)c, (String)"page") - 1)))).executes(c -> this.onExecute(0)));
    }

    protected void removePreviousOutput() {
        Minecraft.getMinecraftGame().getGameChat().remove(this.previousOuput::contains);
        this.previousOuput.clear();
    }

    protected void send(Message message) {
        this.previousOuput.add(message.string());
        message.print();
    }

    protected int onExecute(int page) {
        String prefix = CommandRegister.getCommandTrigger();
        if (!this.previousOuput.isEmpty()) {
            this.removePreviousOutput();
        }
        if (this.list().isEmpty()) {
            this.send(this.title);
            this.send(Message.of("Nothing added").style(Appearance.of(DefaultColors.GRAY)));
        } else {
            List<List<Message>> chunks = this.getChunks();
            if (page < 0) {
                page = 0;
            }
            if (page >= chunks.size()) {
                page = chunks.size() - 1;
            }
            List<Message> chunk = chunks.get(page);
            Appearance aqua = Appearance.of(DefaultColors.AQUA);
            this.send(new Message.Builder().append(this.title).append(" ").append(String.format("Page (%s/%s)", page + 1, chunks.size()), aqua).build());
            chunk.forEach(this::send);
            if (chunks.size() > 1) {
                Message.Builder navigation = new Message.Builder();
                if (page > 0) {
                    Message left = Message.of("<< ").style(Appearance.of(DefaultColors.AQUA).withClickEvent(Appearance.ClickAction.RUN_COMMAND, String.format("%s%s %s", prefix, this.command, page)).withTextHoverEvent(Message.of("Previous page")));
                    navigation.append(left);
                }
                if (page + 1 < chunks.size()) {
                    Message right = Message.of(">>").style(Appearance.of(DefaultColors.AQUA).withClickEvent(Appearance.ClickAction.RUN_COMMAND, String.format("%s%s %s", prefix, this.command, page + 2)).withTextHoverEvent(Message.of("Next page")));
                    navigation.append(right);
                }
                this.send(navigation.build());
            }
        }
        return 1;
    }
}

