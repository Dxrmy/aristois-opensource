/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_340
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.gui;

import java.util.List;
import java.util.function.Function;
import me.deftware.client.framework.minecraft.Minecraft;
import net.minecraft.class_340;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_340.class})
public class MixinDebugHud {
    @Inject(method={"getLeftText"}, at={@At(value="TAIL")}, cancellable=true)
    protected void retrieveLeftText(CallbackInfoReturnable<List<String>> cir) {
        cir.setReturnValue(this.getModifiedList((List)cir.getReturnValue()));
    }

    @Inject(method={"getRightText"}, at={@At(value="TAIL")}, cancellable=true)
    protected void retrieveRightText(CallbackInfoReturnable<List<String>> cir) {
        cir.setReturnValue(this.getModifiedList((List)cir.getReturnValue()));
    }

    private List<String> getModifiedList(List<String> stringData) {
        for (Function<List<String>, List<String>> modifier : Minecraft.getMinecraftGame().getDebugModifiers()) {
            stringData = modifier.apply(stringData);
        }
        return stringData;
    }
}

