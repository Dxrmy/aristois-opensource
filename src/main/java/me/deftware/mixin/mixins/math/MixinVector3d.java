/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.math;

import me.deftware.client.framework.math.Vector3;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_243.class})
public class MixinVector3d
implements Vector3<Double> {
    @Override
    @Unique
    public Double getX() {
        return ((class_243)this).method_10216();
    }

    @Override
    @Unique
    public Double getY() {
        return ((class_243)this).method_10214();
    }

    @Override
    @Unique
    public Double getZ() {
        return ((class_243)this).method_10215();
    }

    @Override
    @Unique
    public Vector3<Double> add(Double x, Double y, Double z) {
        return (Vector3)((class_243)this).method_1031(x.doubleValue(), y.doubleValue(), z.doubleValue());
    }

    @Override
    @Unique
    public Vector3<Double> subtract(Double x, Double y, Double z) {
        return (Vector3)((class_243)this).method_1023(x.doubleValue(), y.doubleValue(), z.doubleValue());
    }

    @Override
    @Unique
    public Vector3<Double> multiply(Double x, Double y, Double z) {
        return (Vector3)((class_243)this).method_18805(x.doubleValue(), y.doubleValue(), z.doubleValue());
    }

    @Override
    @Unique
    public double distanceTo(Double x, Double y, Double z) {
        return Math.sqrt(((class_243)this).method_1028(x.doubleValue(), y.doubleValue(), z.doubleValue()));
    }
}

