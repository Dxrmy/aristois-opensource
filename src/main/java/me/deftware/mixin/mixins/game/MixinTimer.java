/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_8921
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.game;

import me.deftware.client.framework.world.WorldTimer;
import net.minecraft.class_310;
import net.minecraft.class_8921;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_310.class})
public class MixinTimer
implements WorldTimer {
    @Unique
    private float speed = 1.0f;

    @ModifyVariable(method={"getTargetMillisPerTick"}, at=@At(value="HEAD"), argsOnly=true)
    private float onGetTargetMillis(float millis) {
        return millis / this.speed;
    }

    @Redirect(method={"getTargetMillisPerTick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/tick/TickManager;getMillisPerTick()F"))
    private float onMax(class_8921 instance) {
        return instance.method_54749() / this.speed;
    }

    @Override
    public float getTimerSpeed() {
        return this.speed;
    }

    @Override
    public void setTimerSpeed(float speed) {
        this.speed = speed;
    }
}

