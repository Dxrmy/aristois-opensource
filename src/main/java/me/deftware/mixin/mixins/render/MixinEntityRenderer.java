/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_10366
 *  net.minecraft.class_1297
 *  net.minecraft.class_1675
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  net.minecraft.class_3966
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4599
 *  net.minecraft.class_757
 *  net.minecraft.class_7833
 *  net.minecraft.class_9779
 *  net.minecraft.class_9920
 *  net.minecraft.class_9922
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.render;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Predicate;
import java.util.function.Supplier;
import me.deftware.client.framework.event.events.EventHurtcam;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.helper.GlStateHelper;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.shader.Shader;
import me.deftware.mixin.imp.IMixinEntityRenderer;
import me.deftware.mixin.mixins.render.MixinDrawContextInvoker;
import net.minecraft.class_10366;
import net.minecraft.class_1297;
import net.minecraft.class_1675;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_3966;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4599;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_9779;
import net.minecraft.class_9920;
import net.minecraft.class_9922;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_757.class})
public abstract class MixinEntityRenderer
implements IMixinEntityRenderer {
    @Shadow
    private float field_4019;
    @Shadow
    private float field_3999;
    @Shadow
    @Final
    private class_4184 field_18765;
    @Shadow
    @Final
    private class_310 field_4015;
    @Shadow
    private boolean field_4013;
    @Shadow
    @Final
    private class_4599 field_20948;
    @Shadow
    @Final
    private class_9920 field_53066;
    @Unique
    private final EventRender3D eventRender3D = new EventRender3D();
    @Unique
    private final EventRender3DNoBobbing eventRender3DNoBobbing = new EventRender3DNoBobbing();
    @Unique
    private final EventHurtcam eventHurtcam = new EventHurtcam();
    @Unique
    private final EventRender2D eventRender2D = new EventRender2D();
    @Unique
    private final EventMatrixRender eventMatrixRender = new EventMatrixRender();
    @Unique
    private Shader shader;

    @Shadow
    public abstract Matrix4f method_22973(float var1);

    @Shadow
    protected abstract float method_3196(class_4184 var1, float var2, boolean var3);

    @Inject(method={"renderHand"}, at={@At(value="HEAD")})
    private void renderHand(class_4184 camera, float partialTicks, Matrix4f matrix4f, CallbackInfo ci) {
        if (!WindowHelper.isMinimized()) {
            class_4587 matrixStack = new class_4587();
            matrixStack.method_22907(class_7833.field_40714.rotationDegrees(camera.method_19329()));
            matrixStack.method_22907(class_7833.field_40716.rotationDegrees(camera.method_19330() + 180.0f));
            class_332 drawContext = MixinDrawContextInvoker.create(this.field_4015, matrixStack, this.field_20948.method_23000());
            this.loadPushPop(() -> this.eventRender3D, drawContext, partialTicks);
            drawContext = new class_332(this.field_4015, this.field_20948.method_23000());
            class_4587 matrix = drawContext.method_51448();
            matrix.method_22903();
            float fov = this.method_3196(camera, partialTicks, true);
            Matrix4f matrix4f2 = this.method_22973(fov);
            matrix.method_23760().method_23761().mul((Matrix4fc)matrix4f2);
            RenderSystem.setProjectionMatrix((Matrix4f)matrix.method_23760().method_23761(), (class_10366)class_10366.field_54954);
            matrix.method_22909();
            matrix.method_22907(class_7833.field_40714.rotationDegrees(this.field_18765.method_19329()));
            matrix.method_22907(class_7833.field_40716.rotationDegrees(this.field_18765.method_19330() + 180.0f));
            this.loadPushPop(() -> this.eventRender3DNoBobbing, drawContext, partialTicks);
            drawContext.method_51452();
            RenderSystem.setProjectionMatrix((Matrix4f)matrixStack.method_23760().method_23761(), (class_10366)class_10366.field_54954);
            GlStateHelper.enableLighting();
        }
    }

    @Unique
    private <T extends EventRender3D> void loadPushPop(Supplier<T> supplier, class_332 context, float partialTicks) {
        EventRender3D event = (EventRender3D)supplier.get();
        event.create(partialTicks);
        event.setContext(GLX.of(context));
        event.broadcast();
    }

    @Inject(method={"bobView"}, at={@At(value="HEAD")}, cancellable=true)
    private void hurtCameraEffect(class_4587 stack, float partialTicks, CallbackInfo ci) {
        this.eventHurtcam.setCanceled(false);
        this.eventHurtcam.broadcast();
        if (this.eventHurtcam.isCanceled()) {
            ci.cancel();
        }
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", opcode=180, target="Lnet/minecraft/client/gui/hud/InGameHud;render(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"))
    private void onRender2D(class_329 inGameHud, class_332 context, class_9779 tickCounter) {
        if (!WindowHelper.isMinimized()) {
            GLX glx = GLX.of(context);
            float tickDelta = tickCounter.method_60637(true);
            glx.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.eventRender2D.setContext(glx);
            this.eventRender2D.create(tickDelta).broadcast();
            RenderStack.reloadCustomMatrix();
            RenderStack.setupGl();
            this.eventMatrixRender.setContext(glx);
            this.eventMatrixRender.create(tickDelta).broadcast();
            RenderStack.restoreGl();
            RenderStack.reloadMinecraftMatrix();
        }
        inGameHud.method_1753(context, tickCounter);
    }

    @Override
    public void loadShader(Shader shader) {
        if (shader != null && !shader.isLoaded()) {
            shader.init();
        }
        this.shader = shader;
    }

    @Inject(method={"onResized"}, at={@At(value="HEAD")})
    private void onResized(int width, int height, CallbackInfo ci) {
        if (this.shader != null) {
            this.shader.getFramebuffer().resize(width, height);
        }
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;drawEntityOutlinesFramebuffer()V", shift=At.Shift.AFTER)})
    private void onRender(class_9779 tickCounter, boolean tick, CallbackInfo ci) {
        if (this.shader != null) {
            RenderSystem.disableBlend();
            RenderSystem.disableDepthTest();
            RenderSystem.resetTextureMatrix();
            this.shader.applyUniforms();
            this.shader.getShaderEffect().method_1258(this.field_4015.method_1522(), (class_9922)this.field_53066);
        }
    }

    @Redirect(method={"findCrosshairTarget"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/projectile/ProjectileUtil;raycast(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Box;Ljava/util/function/Predicate;D)Lnet/minecraft/util/hit/EntityHitResult;"))
    private class_3966 onRayTraceDistance(class_1297 entity, class_243 vec3d, class_243 vec3d2, class_238 box, Predicate<class_1297> predicate, double distance) {
        return class_1675.method_18075((class_1297)entity, (class_243)vec3d, (class_243)vec3d2, (class_238)box, predicate, (double)(GameMap.INSTANCE.get(GameKeys.BYPASS_REACH_LIMIT, false) != false ? 0.0 : distance));
    }

    @Redirect(method={"findCrosshairTarget"}, at=@At(value="INVOKE", target="Lnet/minecraft/util/math/Vec3d;squaredDistanceTo(Lnet/minecraft/util/math/Vec3d;)D", ordinal=1))
    private double onDistance(class_243 self, class_243 vec3d) {
        return GameMap.INSTANCE.get(GameKeys.BYPASS_REACH_LIMIT, false) != false ? 2.0 : self.method_1025(vec3d);
    }

    @Override
    public float getFovMultiplier() {
        return this.field_4019;
    }

    @Override
    public void updateFovMultiplier(float newFov) {
        this.field_4019 = this.field_3999 = newFov;
    }
}

