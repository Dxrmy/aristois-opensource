/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_9919
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.misc;

import me.deftware.client.framework.minecraft.GameSetting;
import net.minecraft.class_9919;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_9919.class})
public class MixinInactivityFpsLimiter {
    @Redirect(method={"update"}, at=@At(value="FIELD", target="Lnet/minecraft/client/option/InactivityFpsLimiter;maxFps:I"))
    private int onGetMaxFps(class_9919 instance) {
        return GameSetting.MAX_FPS.get();
    }
}

