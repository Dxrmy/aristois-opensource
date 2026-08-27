/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1058
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4603
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.render;

import me.deftware.client.framework.event.events.EventAnimation;
import net.minecraft.class_1058;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4603;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_4603.class})
public class MixinInGameOverlayRenderer {
    @Unique
    private static final EventAnimation eventAnimation = new EventAnimation();

    @Inject(method={"renderInWallOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private static void renderInWallOverlay(class_1058 sprite, class_4587 matrices, class_4597 vertexConsumerProvider, CallbackInfo ci) {
        eventAnimation.create(EventAnimation.AnimationType.Wall);
        eventAnimation.broadcast();
        if (eventAnimation.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"renderFireOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private static void renderFireOverlay(class_4587 matrixStack, class_4597 vertexConsumerProvider, CallbackInfo ci) {
        eventAnimation.create(EventAnimation.AnimationType.Fire);
        eventAnimation.broadcast();
        if (eventAnimation.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"renderUnderwaterOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private static void renderUnderwaterOverlay(class_310 client, class_4587 matrices, class_4597 vertexConsumerProvider, CallbackInfo ci) {
        eventAnimation.create(EventAnimation.AnimationType.Underwater);
        eventAnimation.broadcast();
        if (eventAnimation.isCanceled()) {
            ci.cancel();
        }
    }
}

