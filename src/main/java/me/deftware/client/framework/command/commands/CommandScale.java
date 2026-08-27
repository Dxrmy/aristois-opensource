/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.FloatArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.builder.RequiredArgumentBuilder
 */
package me.deftware.client.framework.command.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.render.batching.RenderStack;

public class CommandScale
extends EMCModCommand {
    private void setScale(float scale) {
        RenderStack.setScale(scale);
        Bootstrap.EMCSettings.putPrimitive("RENDER_SCALE", scale);
        CommandScale.print("Scale has been set to '" + scale + "'!");
    }

    @Override
    public CommandBuilder<?> getCommandBuilder() {
        return new CommandBuilder().set((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal((String)"scale").then(LiteralArgumentBuilder.literal((String)"set").then(RequiredArgumentBuilder.argument((String)"size", (ArgumentType)FloatArgumentType.floatArg((float)0.2f, (float)4.0f)).executes(c -> {
            this.setScale(((Float)c.getArgument("size", Float.class)).floatValue());
            return 1;
        })))).then(LiteralArgumentBuilder.literal((String)"reset").executes(c -> {
            this.setScale(1.0f);
            return 1;
        })));
    }
}

