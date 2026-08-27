/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_2556$class_7602
 *  net.minecraft.class_2561
 *  net.minecraft.class_338
 *  net.minecraft.class_7469
 *  net.minecraft.class_7471
 *  net.minecraft.class_7591
 *  net.minecraft.class_7594
 *  net.minecraft.class_7595
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.network;

import com.mojang.authlib.GameProfile;
import java.time.Instant;
import me.deftware.client.framework.event.events.EventChatReceive;
import net.minecraft.class_2556;
import net.minecraft.class_2561;
import net.minecraft.class_338;
import net.minecraft.class_7469;
import net.minecraft.class_7471;
import net.minecraft.class_7591;
import net.minecraft.class_7594;
import net.minecraft.class_7595;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_7594.class})
public abstract class MixinMessageHandler {
    @Unique
    private EventChatReceive event;

    @Shadow
    protected abstract class_7595 method_44732(class_7471 var1, class_2561 var2, Instant var3);

    @Inject(method={"onChatMessage"}, at={@At(value="HEAD")}, cancellable=true)
    private void onMessage(class_7471 signedMessage, GameProfile sender, class_2556.class_7602 params, CallbackInfo ci) {
        class_2561 text = params.method_44837(signedMessage.method_46291());
        Instant instant = Instant.now();
        boolean signed = false;
        boolean expired = signedMessage.method_44748(instant);
        if (!signedMessage.method_46293()) {
            class_7595 messageTrustStatus = this.method_44732(signedMessage, text, instant);
            signed = !messageTrustStatus.method_44740();
        }
        this.event = (EventChatReceive)new EventChatReceive(params, signedMessage, expired, signed).broadcast();
        if (this.event.isCanceled()) {
            ci.cancel();
        }
    }

    @Redirect(method={"processChatMessageInternal"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/ChatHud;addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V"))
    private void onAddMessage(class_338 instance, class_2561 original, class_7469 signature, class_7591 indicator) {
        class_2556.class_7602 arg = this.event.getArg();
        class_2561 message = (class_2561)this.event.getMessage();
        class_2561 text = arg.method_44837(message);
        instance.method_44811(text, signature, indicator);
    }
}

