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
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.world.ClientWorld;

public class CommandReload
extends EMCModCommand {
    @Override
    public CommandBuilder<?> getCommandBuilder() {
        return new CommandBuilder().set((LiteralArgumentBuilder)LiteralArgumentBuilder.literal((String)"reload").then(LiteralArgumentBuilder.literal((String)"skins").executes(c -> {
            CommandReload.print("Reloading skins...");
            ClientWorld.getClientWorld().getLoadedEntities().forEach(Entity::reloadSkin);
            CommandReload.print("Skins reloaded");
            return 1;
        })));
    }
}

