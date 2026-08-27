/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_2266
 *  net.minecraft.class_2338
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3726
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.block;

import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import net.minecraft.class_1922;
import net.minecraft.class_2266;
import net.minecraft.class_2338;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2266.class})
public class MixinBlockCactus {
    @Inject(method={"getCollisionShape"}, at={@At(value="TAIL")}, cancellable=true)
    private void onGetCollisionShape(class_2680 state, class_1922 view, class_2338 pos, class_3726 context, CallbackInfoReturnable<class_265> cir) {
        if (GameMap.INSTANCE.get(GameKeys.FULL_CACTUS_VOXEL, false).booleanValue()) {
            cir.setReturnValue((Object)class_259.method_1077());
        }
    }
}

