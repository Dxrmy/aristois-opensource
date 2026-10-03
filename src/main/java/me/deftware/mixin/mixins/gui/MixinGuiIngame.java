/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.gui;

import me.deftware.client.framework.event.events.EventAnimation;
import me.deftware.client.framework.event.events.EventRenderHotbar;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_329.class})
public class MixinGuiIngame {
    @Unique
    private static final class_2960 PUMPKIN_BLUR = class_2960.method_60656((String)"misc/pumpkinblur").method_45134(string -> "textures/" + string + ".png");
    @Unique
    private final EventRenderHotbar eventRenderHotbar = new EventRenderHotbar();
    @Unique
    private final EventAnimation eventAnimation = new EventAnimation();

    @Inject(method={"renderCrosshair"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Ljava/util/function/Function;Lnet/minecraft/util/Identifier;IIII)V", ordinal=0)}, cancellable=true)
    private void crosshairEvent(CallbackInfo ci) {
        if (!GameMap.INSTANCE.get(GameKeys.CROSSHAIR, true).booleanValue()) {
            ci.cancel();
        }
    }

    @Inject(method={"renderStatusEffectOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderStatusEffectOverlay(class_332 context, class_9779 tickCounter, CallbackInfo ci) {
        if (!GameMap.INSTANCE.get(GameKeys.EFFECT_OVERLAY, true).booleanValue()) {
            ci.cancel();
        }
    }

    @Inject(method={"renderHotbar"}, at={@At(value="HEAD")})
    private void renderHotbar(class_332 context, class_9779 tickCounter, CallbackInfo ci) {
        this.eventRenderHotbar.setContext(GLX.of(context));
        this.eventRenderHotbar.broadcast();
    }

    @Inject(method={"renderOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderOverlay(class_332 context, class_2960 texture, float opacity, CallbackInfo ci) {
        if (texture.equals((Object)PUMPKIN_BLUR)) {
            this.eventAnimation.create(EventAnimation.AnimationType.Pumpkin);
            this.eventAnimation.broadcast();
            if (this.eventAnimation.isCanceled()) {
                ci.cancel();
            }
        }
    }

    @Inject(method={"renderPortalOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderPortalOverlay(class_332 context, float nauseaStrength, CallbackInfo ci) {
        this.eventAnimation.create(EventAnimation.AnimationType.Portal);
        this.eventAnimation.broadcast();
        if (this.eventAnimation.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"updateVignetteDarkness"}, at={@At(value="HEAD")}, cancellable=true)
    private void updateVignetteDarkness(class_1297 entity, CallbackInfo ci) {
        this.eventAnimation.create(EventAnimation.AnimationType.Vignette);
        this.eventAnimation.broadcast();
        if (this.eventAnimation.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"renderVignetteOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderVignetteOverlay(class_332 context, class_1297 entity, CallbackInfo ci) {
        this.eventAnimation.create(EventAnimation.AnimationType.Vignette);
        this.eventAnimation.broadcast();
        if (this.eventAnimation.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"getCameraPlayer"}, cancellable=true)
    private void getCameraPlayer(CallbackInfoReturnable<class_1657> info) {
        if (CameraEntityMan.isActive()) {
            info.setReturnValue((Object)class_310.method_1551().field_1724);
            info.cancel();
        }
    }
}

