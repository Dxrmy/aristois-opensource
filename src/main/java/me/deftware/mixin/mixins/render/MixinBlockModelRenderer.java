/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.model.BakedModel
 *  net.minecraft.world.BlockRenderView
 *  net.minecraft.world.BlockView
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.client.render.block.BlockModelRenderer
 *  net.minecraft.registry.Registries
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.render;

import java.util.Optional;
import me.deftware.client.framework.global.types.BlockProperty;
import me.deftware.client.framework.global.types.BlockPropertyManager;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.mixin.shared.BlockManagement;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.util.math.random.Random;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_778.class})
public abstract class MixinBlockModelRenderer {
    @Unique
    private class_1920 world;
    @Unique
    private class_2338 pos;

    @Inject(method={"render(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/client/render/model/BakedModel;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;ZLnet/minecraft/util/math/random/Random;JI)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void render(class_1920 world, class_1087 model, class_2680 state, class_2338 pos, class_4587 matrices, class_4588 vertexConsumer, boolean cull, class_5819 random, long seed, int overlay, CallbackInfo cir) {
        int id;
        this.world = world;
        this.pos = pos;
        BlockPropertyManager blockProperties = Bootstrap.blockProperties;
        if (!(!blockProperties.isActive() || blockProperties.isOpacityMode() || blockProperties.contains(id = class_7923.field_41175.method_10206((Object)state.method_26204())) && ((BlockProperty)blockProperties.get(id)).isRender())) {
            cir.cancel();
        }
    }

    @Redirect(method={"renderSmooth", "renderFlat"}, at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;shouldDrawSide(Lnet/minecraft/block/BlockState;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/Direction;)Z"))
    private boolean onShouldDrawSide(class_2680 state, class_2680 otherState, class_2350 side) {
        Optional<Boolean> result = BlockManagement.shouldDrawSide(state, (class_1922)this.world, this.pos, side);
        if (result.isPresent()) {
            return result.get();
        }
        return class_2248.method_9607((class_2680)state, (class_2680)otherState, (class_2350)side);
    }
}

