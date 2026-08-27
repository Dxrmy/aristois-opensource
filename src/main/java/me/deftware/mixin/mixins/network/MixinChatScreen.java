/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_408
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.network;

import me.deftware.client.framework.event.events.EventChatSend;
import me.deftware.client.framework.minecraft.Chat;
import net.minecraft.class_408;
import net.minecraft.class_634;
import net.minecraft.class_746;
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

