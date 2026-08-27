/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.tree.CommandNode
 *  com.mojang.brigadier.tree.LiteralCommandNode
 *  com.mojang.brigadier.tree.RootCommandNode
 *  net.minecraft.class_2172
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 */
package me.deftware.client.framework.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import java.util.ArrayList;
import java.util.Map;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import net.minecraft.class_2172;
import net.minecraft.class_310;
import net.minecraft.class_634;

public class CommandRegister {
    private static CommandDispatcher<class_2172> dispatcher = new CommandDispatcher();

    public static CommandDispatcher<class_2172> getDispatcher() {
        return dispatcher;
    }

    public static void clearDispatcher() {
        dispatcher = new CommandDispatcher();
    }

    public static synchronized void registerCommand(CommandBuilder<?> command) {
        LiteralCommandNode node = dispatcher.register(command.build());
        for (String alias : command.getAliases()) {
            LiteralArgumentBuilder argumentBuilder = LiteralArgumentBuilder.literal((String)alias);
            dispatcher.register((LiteralArgumentBuilder)argumentBuilder.redirect((CommandNode)node));
        }
    }

    public static void registerCommand(EMCModCommand modCommand) {
        CommandRegister.registerCommand(modCommand.getCommandBuilder());
    }

    public static ArrayList<String> listCommands() {
        ArrayList<String> commands = new ArrayList<String>();
        RootCommandNode rootNode = dispatcher.getRoot();
        for (CommandNode child : rootNode.getChildren()) {
            commands.add(child.getName());
        }
        return commands;
    }

    public static ArrayList<String> getCommandsAndUsage() {
        Map<CommandNode<class_2172>, String> map = CommandRegister.getSmartUsage();
        return new ArrayList<String>(map.values());
    }

    public static Map<CommandNode<class_2172>, String> getSmartUsage() {
        class_634 networkHandler = class_310.method_1551().method_1562();
        if (networkHandler != null) {
            return dispatcher.getSmartUsage((CommandNode)dispatcher.getRoot(), (Object)networkHandler.method_2875());
        }
        return Map.of();
    }

    public static String getCommandTrigger() {
        return Bootstrap.EMCSettings.getPrimitive("commandtrigger", ".");
    }
}

