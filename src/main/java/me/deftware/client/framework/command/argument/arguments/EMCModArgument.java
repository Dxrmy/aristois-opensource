/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 *  com.mojang.brigadier.exceptions.DynamicCommandExceptionType
 *  com.mojang.brigadier.suggestion.Suggestions
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 */
package me.deftware.client.framework.command.argument.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.command.argument.ArgumentBuilder;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.main.bootstrap.Bootstrap;

public class EMCModArgument
implements ArgumentType<EMCMod> {
    private final DynamicCommandExceptionType modNotFoundException = new DynamicCommandExceptionType(input -> new ArgumentExceptionFunction(String.format("Could not find mod \"%s\"", input)));

    public EMCMod parse(StringReader reader) throws CommandSyntaxException {
        String input = reader.readUnquotedString();
        if (Bootstrap.getMods().containsKey(input)) {
            return Bootstrap.getMods().get(input);
        }
        throw this.modNotFoundException.create((Object)input);
    }

    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return ArgumentBuilder.getSuggestions(Collections.list(Bootstrap.getMods().keys()), builder);
    }

    public Collection<String> getExamples() {
        return Arrays.asList("mod1", "mod2");
    }
}

