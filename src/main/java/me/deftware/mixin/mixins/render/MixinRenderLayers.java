/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_2680
 *  net.minecraft.class_4696
 *  net.minecraft.class_7923
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.render;

import me.deftware.client.framework.global.types.BlockPropertyManager;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import net.minecraft.class_1921;
import net.minecraft.class_2680;
import net.minecraft.class_4696;
import net.minecraft.class_7923;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_4696.class})
public class MixinRenderLayers {
    @Inject(method={"getBlockLayer"}, at={@At(value="HEAD")}, cancellable=true)
    private static void getBlockLayer(class_2680 state, CallbackInfoReturnable<class_1921> cir) {
        int id;
        BlockPropertyManager blockProperties = Bootstrap.blockProperties;
        if (blockProperties.isActive() && !blockProperties.contains(id = class_7923.field_41175.method_10206((Object)state.method_26204())) && blockProperties.isOpacityMode()) {
            cir.setReturnValue((Object)class_1921.method_23583());
        }
    }
}

