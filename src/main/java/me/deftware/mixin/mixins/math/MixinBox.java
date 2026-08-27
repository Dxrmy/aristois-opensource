/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.math;

import java.util.Optional;
import me.deftware.client.framework.math.BoundingBox;
import me.deftware.client.framework.math.Vector3;
import net.minecraft.class_238;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_238.class})
public class MixinBox
implements BoundingBox {
    @Override
    @Unique
    public double getMinX() {
        return ((class_238)this).field_1323;
    }

    @Override
    @Unique
    public double getMinY() {
        return ((class_238)this).field_1322;
    }

    @Override
    @Unique
    public double getMinZ() {
        return ((class_238)this).field_1321;
    }

    @Override
    @Unique
    public double getMaxX() {
        return ((class_238)this).field_1320;
    }

    @Override
    @Unique
    public double getMaxY() {
        return ((class_238)this).field_1325;
    }

    @Override
    @Unique
    public double getMaxZ() {
        return ((class_238)this).field_1324;
    }

    @Override
    @Unique
    public Vector3<Double> getCenter() {
        return (Vector3)((class_238)this).method_1005();
    }

    @Override
    @Unique
    public BoundingBox offset(double x, double y, double z) {
        return (BoundingBox)((class_238)this).method_989(x, y, z);
    }

    @Override
    @Unique
    public Vector3<Double> rayTrace(Vector3<Double> min, Vector3<Double> max) {
        Optional result = ((class_238)this).method_992((class_243)min, (class_243)max);
        return result.orElse(null);
    }
}

