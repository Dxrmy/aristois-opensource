/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.BoolArgumentType
 *  com.mojang.brigadier.arguments.DoubleArgumentType
 *  com.mojang.brigadier.arguments.FloatArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  net.minecraft.class_2186
 */
package me.deftware.client.framework.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_2186;

@Deprecated
public class CommandResult {
    private final CommandContext<?> context;

    public CommandResult(CommandContext<?> context) {
        this.context = context;
    }

    public String getString(String node) {
        return StringArgumentType.getString(this.context, (String)node);
    }

    public Entity getEntity(String node) throws Exception {
        return Entity.newInstance(class_2186.method_9313(this.context, (String)node));
    }

    public Message getEntityName(String node) throws Exception {
        return this.getEntity(node).getName();
    }

    public Object getCustom(String node, Class<?> clazz) {
        return this.context.getArgument(node, clazz);
    }

    public int getInteger(String node) {
        return IntegerArgumentType.getInteger(this.context, (String)node);
    }

    public float getFloat(String node) {
        return FloatArgumentType.getFloat(this.context, (String)node);
    }

    public double getDouble(String node) {
        return DoubleArgumentType.getDouble(this.context, (String)node);
    }

    public boolean getBoolean(String node) {
        return BoolArgumentType.getBool(this.context, (String)node);
    }
}

