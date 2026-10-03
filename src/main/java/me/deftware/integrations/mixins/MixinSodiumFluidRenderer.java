/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.global.GameKeys
 *  me.deftware.client.framework.global.GameMap
 *  me.deftware.client.framework.global.IGameKey
 *  net.caffeinemc.mods.sodium.client.render.chunk.compile.ChunkBuildBuffers
 *  net.caffeinemc.mods.sodium.client.render.chunk.translucent_sorting.TranslucentGeometryCollector
 *  net.caffeinemc.mods.sodium.client.world.LevelSlice
 *  net.caffeinemc.mods.sodium.fabric.render.FluidRendererImpl
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.fluid.FluidState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.integrations.mixins;

import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.global.IGameKey;
import net.caffeinemc.mods.sodium.client.render.chunk.compile.ChunkBuildBuffers;
import net.caffeinemc.mods.sodium.client.render.chunk.translucent_sorting.TranslucentGeometryCollector;
import net.caffeinemc.mods.sodium.client.world.LevelSlice;
import net.caffeinemc.mods.sodium.fabric.render.FluidRendererImpl;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={FluidRendererImpl.class}, remap=false)
public class MixinSodiumFluidRenderer {
    @Inject(method={"render"}, at={@At(value="HEAD")}, remap=false, cancellable=true)
    private void onRender(LevelSlice par1, class_2680 par2, class_3610 par3, class_2338 par4, class_2338 par5, TranslucentGeometryCollector par6, ChunkBuildBuffers par7, CallbackInfo ci) {
        if (!((Boolean)GameMap.INSTANCE.get((IGameKey)GameKeys.RENDER_FLUIDS, (Object)true)).booleanValue()) {
            ci.cancel();
        }
    }
}

