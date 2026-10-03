/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.mixin.shared.BlockManagement
 *  net.fabricmc.fabric.impl.client.indigo.renderer.render.BlockRenderInfo
 *  net.minecraft.world.BlockRenderView
 *  net.minecraft.world.BlockView
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.integrations.mixins;

import java.util.Optional;
import me.deftware.mixin.shared.BlockManagement;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.BlockRenderInfo;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={BlockRenderInfo.class})
public class MixinBlockRenderInfo {
    @Shadow
    public class_1920 blockView;
    @Shadow
    public class_2338 blockPos;

    @Redirect(method={"shouldDrawSide"}, at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;shouldDrawSide(Lnet/minecraft/block/BlockState;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/Direction;)Z"))
    private boolean onShouldDrawFace(class_2680 state, class_2680 otherState, class_2350 side) {
        Optional result = BlockManagement.shouldDrawSide((class_2680)state, (class_1922)this.blockView, (class_2338)this.blockPos, (class_2350)side);
        if (result.isPresent()) {
            return (Boolean)result.get();
        }
        return class_2248.method_9607((class_2680)state, (class_2680)otherState, (class_2350)side);
    }
}

