/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.BlockRenderer
 *  org.spongepowered.asm.mixin.Mixin
 */
package me.deftware.integrations.mixins;

import net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.BlockRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={BlockRenderer.class}, remap=false)
public abstract class MixinSodiumBlockRenderer {
}

