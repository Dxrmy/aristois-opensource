/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2382
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.math;

import me.deftware.client.framework.math.Vector3;
import net.minecraft.class_2382;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_2382.class})
public class MixinVector3i
implements Vector3<Integer> {
    @Override
    @Unique
    public Integer getX() {
        return ((class_2382)this).method_10263();
    }

    @Override
    @Unique
    public Integer getY() {
        return ((class_2382)this).method_10264();
    }

    @Override
    @Unique
    public Integer getZ() {
        return ((class_2382)this).method_10260();
    }

    @Override
    @Unique
    public Vector3<Integer> add(Integer x, Integer y, Integer z) {
        return (Vector3)((class_2382)this).method_34592(x.intValue(), y.intValue(), z.intValue());
    }

    @Override
    @Unique
    public Vector3<Integer> subtract(Integer x, Integer y, Integer z) {
        return (Vector3)((class_2382)this).method_34592(-x.intValue(), -y.intValue(), -z.intValue());
    }

    @Override
    @Unique
    public Vector3<Integer> multiply(Integer x, Integer y, Integer z) {
        return Vector3.ofInt(this.getX() * x, this.getY() * y, this.getZ() * z);
    }

    @Override
    @Unique
    public double distanceTo(Integer x, Integer y, Integer z) {
        return Math.sqrt(((class_2382)this).method_40081((double)x.intValue(), (double)y.intValue(), (double)z.intValue()));
    }
}

