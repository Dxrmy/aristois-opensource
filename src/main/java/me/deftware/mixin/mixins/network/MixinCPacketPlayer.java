/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2828
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 */
package me.deftware.mixin.mixins.network;

import me.deftware.mixin.imp.IMixinCPacketPlayer;
import net.minecraft.class_2828;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={class_2828.class})
public class MixinCPacketPlayer
implements IMixinCPacketPlayer {
    @Mutable
    @Final
    @Shadow
    protected double field_12886;
    @Mutable
    @Final
    @Shadow
    protected boolean field_29179;
    @Mutable
    @Final
    @Shadow
    protected boolean field_12890;

    @Override
    public boolean isOnGround() {
        return this.field_29179;
    }

    @Override
    public void setOnGround(boolean state) {
        this.field_29179 = state;
    }

    @Override
    public boolean isMoving() {
        return this.field_12890;
    }

    @Override
    public void setMoving(boolean state) {
        this.field_12890 = state;
    }

    @Override
    public void setY(double y) {
        this.field_12886 = y;
    }

    @Override
    public double getY() {
        return this.field_12886;
    }
}

