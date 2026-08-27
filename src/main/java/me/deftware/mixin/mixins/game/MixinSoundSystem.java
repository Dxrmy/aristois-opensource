/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 *  net.minecraft.class_1140
 *  net.minecraft.class_1144
 *  net.minecraft.class_2561
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.game;

import me.deftware.client.framework.event.events.EventSound;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_1113;
import net.minecraft.class_1140;
import net.minecraft.class_1144;
import net.minecraft.class_2561;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1140.class})
public class MixinSoundSystem {
    @Shadow
    @Final
    private class_1144 field_5552;

    @Inject(at={@At(value="INVOKE", target="Lnet/minecraft/client/sound/SoundInstance;getVolume()F")}, method={"play(Lnet/minecraft/client/sound/SoundInstance;)V"}, cancellable=true)
    public void onPlay(class_1113 instance, CallbackInfo info) {
        class_2561 soundName = instance.method_4783(this.field_5552).method_4886();
        EventSound event = new EventSound(instance, (Message)soundName);
        event.broadcast();
        if (event.isCanceled()) {
            info.cancel();
        }
    }
}

