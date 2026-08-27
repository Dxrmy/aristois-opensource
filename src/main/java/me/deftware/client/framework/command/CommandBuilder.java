/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  net.minecraft.class_2170
 *  net.minecraft.class_2172
 *  net.minecraft.class_2186
 */
package me.deftware.client.framework.command;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import me.deftware.client.framework.command.CommandResult;
import net.minecraft.class_2170;
import net.minecraft.class_2172;
import net.minecraft.class_2186;

public class CommandBuilder<T> {
    private LiteralArgumentBuilder<class_2172> builder;
    private final List<String> aliases = new ArrayList<String>();

    public CommandBuilder<?> addCommand(String command, Consumer<CommandResult> execution) {
        return this.set((LiteralArgumentBuilder)class_2170.method_9247((String)command).executes(source -> {
            execution.accept(new CommandResult(source));
            return 1;
        }));
    }

    public CommandBuilder<?> set(LiteralArgumentBuilder<?> argument) {
        this.builder = argument;
        return this;
    }

    public CommandBuilder<?> append(LiteralArgumentBuilder<class_2172> argument) {
        if (this.builder == null) {
            this.builder = argument;
        } else {
            this.builder.then(argument);
        }
        return this;
    }

    public CommandBuilder<?> registerAlias(String alias) {
        this.aliases.add(alias);
        return this;
    }

    public ArgumentType<T> getEntityArgumentType() {
        return class_2186.method_9308();
    }

    public List<String> getAliases() {
        return this.aliases;
    }

    protected LiteralArgumentBuilder<class_2172> build() {
        return this.builder;
    }
}

