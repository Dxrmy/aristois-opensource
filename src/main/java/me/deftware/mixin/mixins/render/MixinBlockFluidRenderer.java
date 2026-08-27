/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1920
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3610
 *  net.minecraft.class_4588
 *  net.minecraft.class_775
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.render;

import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3610;
import net.minecraft.class_4588;
import net.minecraft.class_775;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_775.class})
public class MixinBlockFluidRenderer {
    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    public void render(class_1920 world, class_2338 pos, class_4588 vertexConsumer, class_2680 blockState, class_3610 fluidState, CallbackInfo cir) {
        if (!GameMap.INSTANCE.get(GameKeys.RENDER_FLUIDS, true).booleanValue()) {
            cir.cancel();
        }
    }
}

