/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.gen.chunk.ChunkGenerator
 *  net.minecraft.world.gen.HeightContext
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.biome;

import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.HeightContext;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_5868.class})
public class MixinHeightContext {
    @Shadow
    @Final
    @Mutable
    private int field_34030;
    @Shadow
    @Final
    @Mutable
    private int field_34031;

    @Redirect(method={"<init>"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/gen/chunk/ChunkGenerator;getMinimumY()I"))
    private int onGetChunkY(class_2794 instance) {
        if (instance == null) {
            return -9999;
        }
        return instance.method_33730();
    }

    @Redirect(method={"<init>"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/gen/chunk/ChunkGenerator;getWorldHeight()I"))
    private int onGetChunkHeight(class_2794 instance) {
        if (instance == null) {
            return 9999;
        }
        return instance.method_12104();
    }
}

