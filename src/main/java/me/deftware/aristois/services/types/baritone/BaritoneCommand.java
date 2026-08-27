/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.builder.RequiredArgumentBuilder
 *  com.mojang.brigadier.exceptions.SimpleCommandExceptionType
 *  me.deftware.client.framework.command.CommandBuilder
 *  me.deftware.client.framework.command.CommandResult
 *  me.deftware.client.framework.command.EMCModCommand
 */
package me.deftware.aristois.services.types.baritone;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import me.deftware.aristois.services.Registry;
import me.deftware.aristois.services.types.baritone.BaritoneService;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.CommandResult;
import me.deftware.client.framework.command.EMCModCommand;

public class BaritoneCommand
extends EMCModCommand {
    final private BaritoneService service = (BaritoneService)Registry.Baritone.getService();

    public CommandBuilder<?> getCommandBuilder() {
        return new CommandBuilder().set((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal((String)"baritone").executes(c -> {
            this.service.sendCommand("help");
            return 1;
        })).then(LiteralArgumentBuilder.literal((String)"mine").then(RequiredArgumentBuilder.argument((String)"block", (ArgumentType)StringArgumentType.greedyString()).executes(c -> {
            CommandResult r = new CommandResult(c);
            this.service.sendCommand("mine " + r.getString("block"));
            return 1;
        })))).then(LiteralArgumentBuilder.literal((String)"goto").then(RequiredArgumentBuilder.argument((String)"x", (ArgumentType)IntegerArgumentType.integer()).then(RequiredArgumentBuilder.argument((String)"z", (ArgumentType)IntegerArgumentType.integer()).executes(c -> {
            CommandResult r = new CommandResult(c);
            this.service.sendCommand("goto " + r.getInteger("x") + " " + r.getInteger("z"));
            return 1;
        }))))).then(LiteralArgumentBuilder.literal((String)"stop").executes(c -> {
            this.service.sendCommand("stop");
            return 1;
        }))).then(LiteralArgumentBuilder.literal((String)"help").executes(c -> {
            this.service.sendCommand("help");
            return 1;
        }))).then(RequiredArgumentBuilder.argument((String)"other_command", (ArgumentType)StringArgumentType.greedyString()).executes(c -> {
            CommandResult r = new CommandResult(c);
            if (!this.service.sendCommand(r.getString("other_command"))) {
                throw new SimpleCommandExceptionType(() -> "Unknown Baritone Command: " + r.getString("other_command").split("\\s")[0]).create();
            }
            return 1;
        }))).registerAlias("b");
    }
}

