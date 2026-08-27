/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.builder.RequiredArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 */
package me.deftware.client.framework.command.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.main.bootstrap.Bootstrap;

public class CommandTrigger
extends EMCModCommand {
    @Override
    public CommandBuilder<?> getCommandBuilder() {
        return new CommandBuilder().set((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal((String)"trigger").then(LiteralArgumentBuilder.literal((String)"set").then(RequiredArgumentBuilder.argument((String)"prefix", (ArgumentType)StringArgumentType.string()).executes(c -> {
            String prefix = StringArgumentType.getString((CommandContext)c, (String)"prefix");
            if (prefix.isEmpty()) {
                CommandTrigger.print("Prefix cannot be empty");
                return 1;
            }
            Bootstrap.EMCSettings.putPrimitive("commandtrigger", prefix);
            CommandTrigger.print("Command trigger has been set to \"" + prefix + "\"");
            return 1;
        })))).then(LiteralArgumentBuilder.literal((String)"restore").executes(c -> {
            Bootstrap.EMCSettings.putPrimitive("commandtrigger", ".");
            CommandTrigger.print("Restored command trigger to \".\" (single dot)");
            return 1;
        })));
    }
}

