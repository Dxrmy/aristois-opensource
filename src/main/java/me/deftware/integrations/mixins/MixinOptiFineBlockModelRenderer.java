/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.FrameworkConstants
 *  me.deftware.client.framework.global.types.BlockProperty
 *  me.deftware.client.framework.global.types.BlockPropertyManager
 *  me.deftware.client.framework.main.bootstrap.Bootstrap
 *  net.minecraft.class_1087
 *  net.minecraft.class_1920
 *  net.minecraft.class_1921
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_5819
 *  net.minecraft.class_778
 *  net.minecraft.class_7923
 *  net.minecraftforge.client.model.data.ModelData
 *  net.optifine.Config
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.integrations.mixins;

import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.global.types.BlockProperty;
import me.deftware.client.framework.global.types.BlockPropertyManager;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import net.minecraft.class_1087;
import net.minecraft.class_1920;
import net.minecraft.class_1921;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5819;
import net.minecraft.class_778;
import net.minecraft.class_7923;
import net.minecraftforge.client.model.data.ModelData;
import net.optifine.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(value={class_778.class})
public abstract class MixinOptiFineBlockModelRenderer {
    @Shadow(remap=false)
    public abstract void renderModelSmooth(class_1920 var1, class_1087 var2, class_2680 var3, class_2338 var4, class_4587 var5, class_4588 var6, boolean var7, class_5819 var8, long var9, int var11, ModelData var12, class_1921 var13);

    @Shadow(remap=false)
    public abstract void renderModelFlat(class_1920 var1, class_1087 var2, class_2680 var3, class_2338 var4, class_4587 var5, class_4588 var6, boolean var7, class_5819 var8, long var9, int var11, ModelData var12, class_1921 var13);

    @Inject(method={"renderModelSmooth"}, at={@At(value="HEAD")}, remap=false, cancellable=true)
    public void renderModelSmoothInject(class_1920 world, class_1087 model, class_2680 state, class_2338 pos, class_4587 matrix, class_4588 vertexConsumer, boolean cull, class_5819 random, long seed, int overlay, ModelData data, class_1921 layer, CallbackInfo ci) {
        this.onBlockModelRender(state.method_26204(), cull, ci, () -> this.renderModelSmooth(world, model, state, pos, matrix, vertexConsumer, false, random, seed, overlay, data, layer));
    }

    @Inject(method={"renderModelFlat"}, at={@At(value="HEAD")}, remap=false, cancellable=true)
    public void renderModelFlatInject(class_1920 world, class_1087 model, class_2680 state, class_2338 pos, class_4587 buffer, class_4588 vertexConsumer, boolean cull, class_5819 random, long l, int i, ModelData data, class_1921 layer, CallbackInfo ci) {
        this.onBlockModelRender(state.method_26204(), cull, ci, () -> this.renderModelFlat(world, model, state, pos, buffer, vertexConsumer, false, random, l, i, data, layer));
    }

    @Unique
    private void onBlockModelRender(class_2248 block, boolean cull, CallbackInfo ci, Runnable runnable) {
        FrameworkConstants.CAN_RENDER_SHADER = !Config.isShaders();
        try {
            BlockPropertyManager blockProperties = Bootstrap.blockProperties;
            if (blockProperties.isActive() && !blockProperties.isOpacityMode()) {
                int id = class_7923.field_41175.method_10206((Object)block);
                if (!blockProperties.contains(id) || !((BlockProperty)blockProperties.get(id)).isRender()) {
                    ci.cancel();
                } else if (cull) {
                    runnable.run();
                    ci.cancel();
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

