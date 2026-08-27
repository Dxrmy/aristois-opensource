/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.command.commands;

import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.minecraft.Minecraft;

public class CommandVersion
extends EMCModCommand {
    @Override
    public CommandBuilder<?> getCommandBuilder() {
        return new CommandBuilder().addCommand("version", result -> {
            CommandVersion.print(":: EMC info ::");
            CommandVersion.print(FrameworkConstants.toDataString());
            CommandVersion.print(String.format("Minecraft version %s protocol %s", Minecraft.getMinecraftVersion(), Minecraft.getMinecraftProtocolVersion()));
            CommandVersion.print("EMC mappings is " + FrameworkConstants.MAPPING_LOADER.name());
            CommandVersion.print("EMC mapper is " + FrameworkConstants.MAPPING_SYSTEM.name());
        });
    }
}

