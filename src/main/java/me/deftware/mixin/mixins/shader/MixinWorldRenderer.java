/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager
 *  com.mojang.blaze3d.platform.GlStateManager$DstFactor
 *  com.mojang.blaze3d.platform.GlStateManager$SrcFactor
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.moulberry.mixinconstraints.annotations.IfModAbsent
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.client.util.Window
 *  net.minecraft.entity.Entity
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gl.PostEffectProcessor$FramebufferSet
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.util.Lazy
 *  net.minecraft.util.profiler.Profiler
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.BufferBuilderStorage
 *  net.minecraft.client.render.Frustum
 *  net.minecraft.client.render.OutlineVertexConsumerProvider
 *  net.minecraft.client.render.GameRenderer
 *  net.minecraft.client.render.WorldRenderer
 *  net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.render.FrameGraphBuilder
 *  net.minecraft.client.render.RenderPass
 *  net.minecraft.client.util.ObjectAllocator
 *  net.minecraft.client.util.Handle
 *  net.minecraft.client.render.Fog
 *  net.minecraft.client.render.DefaultFramebufferSet
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.shader;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.moulberry.mixinconstraints.annotations.IfModAbsent;
import me.deftware.client.framework.entity.block.TileEntity;
import me.deftware.client.framework.render.shader.EntityShader;
import me.deftware.client.framework.render.shader.Shader;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.block.Block;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.util.Window;
import net.minecraft.entity.Entity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Lazy;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.OutlineVertexConsumerProvider;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.FrameGraphBuilder;
import net.minecraft.client.render.RenderPass;
import net.minecraft.client.util.ObjectAllocator;
import net.minecraft.client.util.Handle;
import net.minecraft.client.render.Fog;
import net.minecraft.client.render.DefaultFramebufferSet;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_761.class})
public abstract class MixinWorldRenderer {
    @Unique
    private static final String MAIN_RENDERER = "method_62214";
    @Unique
    private final class_3528<Boolean> isIrisLoaded = new class_3528(() -> FabricLoader.getInstance().isModLoaded("iris"));
    @Shadow
    @Final
    private class_4599 field_20951;
    @Shadow
    @Final
    private class_310 field_4088;
    @Shadow
    @Final
    private class_9960 field_53081;
    @Unique
    private Shader targetShader;
    @Unique
    private boolean anyShaderEnabled = false;
    @Unique
    private class_9909 frameGraphBuilder;

    @Unique
    private boolean isShaderSupported() {
        return (Boolean)this.isIrisLoaded.method_15332() == false;
    }

    @Shadow
    protected abstract void method_22977(class_1297 var1, double var2, double var4, double var6, float var8, class_4587 var9, class_4597 var10);

    @Unique
    private void initShaders() {
        if (!this.isShaderSupported()) {
            return;
        }
        for (EntityShader shader : EntityShader.SHADERS) {
            shader.init(this.field_20951.method_23000());
        }
    }

    @Inject(method={"onResized"}, at={@At(value="HEAD")})
    private void onResized(int width, int height, CallbackInfo ci) {
        if (!this.isShaderSupported()) {
            return;
        }
        for (EntityShader shader : EntityShader.SHADERS) {
            if (!shader.isLoaded()) continue;
            shader.resize(width, height);
        }
    }

    @Inject(method={"loadEntityOutlinePostProcessor"}, at={@At(value="RETURN")})
    private void reload(CallbackInfo ci) {
        this.initShaders();
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void onRender(class_9922 allocator, class_9779 tickCounter, boolean renderBlockOutline, class_4184 camera, class_757 gameRenderer, Matrix4f matrix4f, Matrix4f matrix4f2, CallbackInfo ci) {
        if (!this.isShaderSupported()) {
            return;
        }
        this.anyShaderEnabled = EntityShader.SHADERS.stream().anyMatch(EntityShader::isEnabled);
        this.targetShader = null;
    }

    @Redirect(method={"renderEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/MinecraftClient;hasOutline(Lnet/minecraft/entity/Entity;)Z", opcode=180))
    private boolean hasOutline(class_310 client, class_1297 entity) {
        if (this.anyShaderEnabled) {
            return false;
        }
        return client.method_27022(entity);
    }

    @Inject(method={"getEntityOutlinesFramebuffer"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetFramebuffer(CallbackInfoReturnable<class_276> cir) {
        if (this.targetShader != null && this.anyShaderEnabled) {
            cir.setReturnValue((Object)this.targetShader.getFramebuffer().getMinecraftBuffer());
        }
    }

    @Inject(method={"method_62214"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;canDrawEntityOutlines()Z", ordinal=0)})
    private void onClear(class_9958 fog, class_9779 renderTickCounter, class_4184 camera, class_3695 profiler, Matrix4f matrix4f, Matrix4f matrix4f2, class_9925 handle, class_9925 handle2, class_9925 handle3, class_9925 handle4, boolean bl, class_4604 frustum, class_9925 handle5, CallbackInfo ci) {
        if (!this.isShaderSupported()) {
            return;
        }
        int buffer = GlStateManager.getBoundFramebuffer();
        for (EntityShader shader : EntityShader.SHADERS) {
            if (!shader.isLoaded()) {
                shader.init(this.field_20951.method_23000());
            }
            shader.getFramebuffer().clear();
        }
        GlStateManager._glBindFramebuffer((int)36160, (int)buffer);
    }

    @Redirect(method={"drawEntityOutlinesFramebuffer"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;canDrawEntityOutlines()Z", opcode=180))
    private boolean onDrawEntityFramebuffer(class_761 worldRenderer) {
        if (!this.isShaderSupported()) {
            return false;
        }
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate((GlStateManager.class_4535)GlStateManager.class_4535.SRC_ALPHA, (GlStateManager.class_4534)GlStateManager.class_4534.ONE_MINUS_SRC_ALPHA, (GlStateManager.class_4535)GlStateManager.class_4535.ZERO, (GlStateManager.class_4534)GlStateManager.class_4534.ONE);
        for (EntityShader shader : EntityShader.SHADERS) {
            if (!shader.isEnabled()) continue;
            class_276 buffer = shader.getFramebuffer().getMinecraftBuffer();
            class_1041 window = this.field_4088.method_22683();
            buffer.method_1233(window.method_4489(), window.method_4506());
        }
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
        return false;
    }

    @IfModAbsent(value="sodium")
    @Redirect(method={"renderBlockEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/block/entity/BlockEntityRenderDispatcher;render(Lnet/minecraft/block/entity/BlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;)V", opcode=180, ordinal=0))
    private void renderBlocKEntity(class_824 blockEntityRenderDispatcher, class_2586 blockEntity, float tickDelta, class_4587 matrix, class_4597 vertexConsumerProvider) {
        int buffer = GlStateManager.getBoundFramebuffer();
        if (this.anyShaderEnabled && this.isShaderSupported()) {
            Block block = null;
            for (EntityShader shader : EntityShader.SHADERS) {
                if (!shader.isEnabled()) continue;
                if (block == null) {
                    Object tileEntity = ClientWorld.getClientWorld().getTileEntityByReference(blockEntity);
                    if (tileEntity == null) break;
                    block = ((TileEntity)tileEntity).getBlock();
                }
                if (!shader.getTargetPredicate().test(block)) continue;
                this.targetShader = shader;
                vertexConsumerProvider = shader.getOutlineVertexConsumerProvider();
            }
        }
        blockEntityRenderDispatcher.method_3555(blockEntity, tickDelta, matrix, vertexConsumerProvider);
        GlStateManager._glBindFramebuffer((int)36160, (int)buffer);
    }

    @Redirect(method={"renderEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;renderEntity(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;)V", opcode=180))
    private void doRenderEntity(class_761 worldRenderer, class_1297 entity, double cameraX, double cameraY, double cameraZ, float tickDelta, class_4587 matrices, class_4597 vertexConsumers) {
        int buffer = GlStateManager.getBoundFramebuffer();
        if (this.anyShaderEnabled && this.isShaderSupported()) {
            Object emcEntity = null;
            for (EntityShader shader : EntityShader.SHADERS) {
                if (!shader.isEnabled()) continue;
                if (emcEntity == null) {
                    emcEntity = ClientWorld.getClientWorld().getEntityByReference(entity);
                }
                if (!shader.getTargetPredicate().test(emcEntity)) continue;
                this.targetShader = shader;
                vertexConsumers = shader.getOutlineVertexConsumerProvider();
            }
        }
        this.method_22977(entity, cameraX, cameraY, cameraZ, tickDelta, matrices, vertexConsumers);
        GlStateManager._glBindFramebuffer((int)36160, (int)buffer);
    }

    @Redirect(method={"render"}, at=@At(value="NEW", target="()Lnet/minecraft/client/render/FrameGraphBuilder;"))
    private class_9909 onRenderMain() {
        class_9909 frameGraphBuilder;
        this.frameGraphBuilder = frameGraphBuilder = new class_9909();
        return frameGraphBuilder;
    }

    @Redirect(method={"method_62214"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/OutlineVertexConsumerProvider;draw()V", opcode=180))
    private void onVertexDraw(class_4618 outlineVertexConsumerProvider) {
        if (this.anyShaderEnabled && this.isShaderSupported()) {
            int original = GlStateManager.getBoundFramebuffer();
            for (EntityShader shader : EntityShader.SHADERS) {
                if (!shader.isEnabled()) continue;
                this.targetShader = shader;
                shader.getOutlineVertexConsumerProvider().method_23285();
            }
            GlStateManager._glBindFramebuffer((int)36160, (int)original);
        } else {
            outlineVertexConsumerProvider.method_23285();
        }
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;renderMain(Lnet/minecraft/client/render/FrameGraphBuilder;Lnet/minecraft/client/render/Frustum;Lnet/minecraft/client/render/Camera;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/client/render/Fog;ZZLnet/minecraft/client/render/RenderTickCounter;Lnet/minecraft/util/profiler/Profiler;)V", shift=At.Shift.AFTER)})
    private void onPostRenderMain(class_9922 allocator, class_9779 tickCounter, boolean renderBlockOutline, class_4184 camera, class_757 gameRenderer, Matrix4f matrix4f, Matrix4f matrix4f2, CallbackInfo ci) {
        if (!this.isShaderSupported()) {
            return;
        }
        for (EntityShader shader : EntityShader.SHADERS) {
            if (!shader.isEnabled()) continue;
            class_276 mainBuffer = this.field_4088.method_1522();
            Shader.ShaderFramebufferSet frameSet = shader.getFramebufferSet();
            class_276 buffer = shader.getFramebuffer().getMinecraftBuffer();
            String name = Shader.ShaderFramebufferSet.FINAL.method_12832();
            class_9925 handle = this.frameGraphBuilder.method_61914(name, (Object)buffer);
            frameSet.method_62225(Shader.ShaderFramebufferSet.FINAL, (class_9925<class_276>)handle);
            frameSet.method_62225(class_9960.field_53083, (class_9925<class_276>)this.field_53081.field_53091);
            class_9916 pass = this.frameGraphBuilder.method_61911("uniforms");
            pass.method_61929(shader::applyUniforms);
            pass.method_61924();
            shader.getShaderEffect().method_62234(this.frameGraphBuilder, mainBuffer.field_1482, mainBuffer.field_1481, (class_279.class_9961)frameSet);
        }
    }
}

