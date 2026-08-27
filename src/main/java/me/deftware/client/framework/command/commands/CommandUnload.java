/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 */
package me.deftware.client.framework.command.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.main.bootstrap.Bootstrap;

public class CommandUnload
extends EMCModCommand {
    @Override
    public CommandBuilder<?> getCommandBuilder() {
        return new CommandBuilder().set((LiteralArgumentBuilder)LiteralArgumentBuilder.literal((String)"unload").executes(c -> {
            Bootstrap.ejectMods();
            CommandUnload.print("Unloaded all mods");
            return 1;
        }));
    }
}

