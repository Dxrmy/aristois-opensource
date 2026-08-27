/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_418
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.gui;

import me.deftware.client.framework.event.events.EventGameOver;
import net.minecraft.class_418;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_418.class})
public class MixinGuiGameOver {
    private boolean flag = false;

    @Inject(method={"init"}, at={@At(value="HEAD")})
    private void initGui(CallbackInfo ci) {
        if (!this.flag) {
            this.flag = true;
            new EventGameOver().broadcast();
        }
    }
}

