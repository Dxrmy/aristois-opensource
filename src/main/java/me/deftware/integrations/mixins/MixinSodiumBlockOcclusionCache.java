/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.mixin.shared.BlockManagement
 *  net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.BlockOcclusionCache
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.integrations.mixins;

import java.util.Optional;
import me.deftware.mixin.shared.BlockManagement;
import net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.BlockOcclusionCache;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockOcclusionCache.class}, remap=false)
public class MixinSodiumBlockOcclusionCache {
    @Inject(method={"shouldDrawSide"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    public void shouldDrawSide(class_2680 state, class_1922 view, class_2338 pos, class_2350 facing, CallbackInfoReturnable<Boolean> ci) {
        Optional result = BlockManagement.shouldDrawSide((class_2680)state, (class_1922)view, (class_2338)pos, (class_2350)facing);
        if (result.isPresent()) {
            ci.setReturnValue((Object)((Boolean)result.get()));
        }
    }
}

