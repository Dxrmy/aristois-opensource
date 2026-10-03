/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.ParseResults
 *  com.mojang.brigadier.StringReader
 *  net.minecraft.command.CommandSource
 *  net.minecraft.client.gui.widget.TextFieldWidget
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ChatInputSuggestor
 *  net.minecraft.client.network.ClientCommandSource
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.gui;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import me.deftware.client.framework.command.CommandRegister;
import net.minecraft.command.CommandSource;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ChatInputSuggestor;
import net.minecraft.client.network.ClientCommandSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_4717.class})
public class MixinChatSuggestion {
    @Shadow
    @Final
    class_342 field_21599;
    @Shadow
    @Final
    class_437 field_21598;

    @Redirect(method={"refresh"}, at=@At(value="INVOKE", target="Lcom/mojang/brigadier/StringReader;peek()C", remap=false))
    private char onPeek(StringReader stringReader) {
        String trigger = CommandRegister.getCommandTrigger();
        if (this.field_21599.method_1882().startsWith(trigger) && this.isDispatcherActive()) {
            if (trigger.length() > 1) {
                for (int i = 1; i < trigger.length(); ++i) {
                    stringReader.skip();
                }
            }
            return '/';
        }
        return stringReader.peek();
    }

    @Redirect(method={"refresh"}, at=@At(value="INVOKE", target="Lcom/mojang/brigadier/CommandDispatcher;parse(Lcom/mojang/brigadier/StringReader;Ljava/lang/Object;)Lcom/mojang/brigadier/ParseResults;", remap=false))
    private ParseResults<class_2172> onParse(CommandDispatcher<class_2172> commandDispatcher, StringReader reader, Object source) {
        class_637 clientCommandSource = (class_637)source;
        if (this.field_21599.method_1882().startsWith(CommandRegister.getCommandTrigger()) && this.isDispatcherActive()) {
            return CommandRegister.getDispatcher().parse(reader, (Object)clientCommandSource);
        }
        return commandDispatcher.parse(reader, (Object)clientCommandSource);
    }

    @Unique
    private boolean isDispatcherActive() {
        return this.field_21598 instanceof class_408;
    }
}

