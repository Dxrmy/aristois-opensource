/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.ClientPlayerEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.network;

import me.deftware.client.framework.event.events.EventChatSend;
import me.deftware.client.framework.minecraft.Chat;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_408.class})
public class MixinChatScreen {
    @Redirect(method={"sendMessage"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayNetworkHandler;sendChatMessage(Ljava/lang/String;)V"))
    private void onMessage$Chat(class_634 networkHandler, String content) {
        Chat.send(arg_0 -> ((class_634)networkHandler).method_45729(arg_0), content, class_746.class, EventChatSend.Type.Message);
    }

    @Redirect(method={"sendMessage"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayNetworkHandler;sendChatCommand(Ljava/lang/String;)V"))
    private void onMessage$Command(class_634 networkHandler, String content) {
        Chat.send(arg_0 -> ((class_634)networkHandler).method_45730(arg_0), content, class_746.class, EventChatSend.Type.Command);
    }
}

