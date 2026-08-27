/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_243
 *  net.minecraft.class_3695
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4599
 *  net.minecraft.class_4604
 *  net.minecraft.class_761
 *  net.minecraft.class_898
 *  net.minecraft.class_9779
 *  net.minecraft.class_9909
 *  net.minecraft.class_9925
 *  net.minecraft.class_9958
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.render;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import me.deftware.client.framework.event.events.EventWeather;
import me.deftware.client.framework.render.WorldEntityRenderer;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;
import net.minecraft.class_243;
import net.minecraft.class_3695;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4599;
import net.minecraft.class_4604;
import net.minecraft.class_761;
import net.minecraft.class_898;
import net.minecraft.class_9779;
import net.minecraft.class_9909;
import net.minecraft.class_9925;
import net.minecraft.class_9958;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_761.class})
public abstract class MixinWorldRenderer
implements WorldEntityRenderer {
    @Shadow
    @Final
    private class_898 field_4109;
    @Shadow
    @Final
    private class_4599 field_20951;
    @Unique
    private final List<WorldEntityRenderer.Statue> statues = new ArrayList<WorldEntityRenderer.Statue>();

    @Inject(method={"addWeatherParticlesAndSound"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderRain(class_4184 camera, CallbackInfo ci) {
        EventWeather event = new EventWeather(EventWeather.WeatherType.Rain);
        event.broadcast();
        if (event.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"renderWeather"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderWeather(class_9909 frameGraphBuilder, class_243 vec3d, float f, class_9958 fog, CallbackInfo ci) {
        EventWeather event = new EventWeather(EventWeather.WeatherType.Rain);
        event.broadcast();
        if (event.isCanceled()) {
            ci.cancel();
        }
    }

    @ModifyArg(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;setupTerrain(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/Frustum;ZZ)V"), index=3)
    public boolean isSpectator(boolean spectator) {
        return spectator || CameraEntityMan.isActive();
    }

    @Inject(method={"method_62214"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;drawCurrentLayer()V", ordinal=0)})
    private void onRenderStatues(class_9958 fog, class_9779 renderTickCounter, class_4184 camera, class_3695 profiler, Matrix4f matrix4f, Matrix4f matrix4f2, class_9925 handle, class_9925 handle2, class_9925 handle3, class_9925 handle4, boolean bl, class_4604 frustum, class_9925 handle5, CallbackInfo ci) {
        class_4587 matrices = new class_4587();
        for (WorldEntityRenderer.Statue statue : this.statues) {
            float tickDelta = renderTickCounter.method_60637(true);
            this.field_4109.method_62424(statue.getEntity().getMinecraftEntity(), statue.getPosition().getX() - camera.method_19326().method_10216(), statue.getPosition().getY() - camera.method_19326().method_10214(), statue.getPosition().getZ() - camera.method_19326().method_10215(), tickDelta, matrices, (class_4597)this.field_20951.method_23000(), this.field_4109.method_23839(statue.getEntity().getMinecraftEntity(), tickDelta));
        }
    }

    @Override
    @Generated
    public List<WorldEntityRenderer.Statue> getStatues() {
        return this.statues;
    }
}

