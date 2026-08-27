/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.builder.RequiredArgumentBuilder
 *  me.deftware.client.framework.command.CommandBuilder
 *  me.deftware.client.framework.command.CommandResult
 *  me.deftware.client.framework.command.EMCModCommand
 */
package me.deftware.aristois.services.types.baritone;

import \u0000nunyaboolean.catch.for.abstract.do.throws;
import \u0000nunyaboolean.catch.for.private.boolean;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.aristois.services.Registry;
import me.deftware.aristois.services.types.baritone.BaritoneService;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.CommandResult;
import me.deftware.client.framework.command.EMCModCommand;

public class BaritoneGotoCommand
extends EMCModCommand {
    final private BaritoneService service = (BaritoneService)Registry.Baritone.getService();

    public CommandBuilder<?> getCommandBuilder() {
        return new CommandBuilder().set((LiteralArgumentBuilder)LiteralArgumentBuilder.literal((String)"goto").then(RequiredArgumentBuilder.argument((String)"point", (ArgumentType)new throws()).executes(c -> {
            CommandResult r = new CommandResult(c);
            boolean point = (boolean)r.getCustom("point", boolean.class);
            this.service.sendCommand(String.format("goto %s %s %s", point.static(), point.abstract(), point.byte()));
            return 1;
        })));
    }
}

