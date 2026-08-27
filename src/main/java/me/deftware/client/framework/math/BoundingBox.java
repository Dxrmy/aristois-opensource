/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_238
 */
package me.deftware.client.framework.math;

import me.deftware.client.framework.math.Vector3;
import net.minecraft.class_238;

public interface BoundingBox {
    public double getMinX();

    public double getMinY();

    public double getMinZ();

    public double getMaxX();

    public double getMaxY();

    public double getMaxZ();

    public Vector3<Double> getCenter();

    public BoundingBox offset(double var1, double var3, double var5);

    public Vector3<Double> rayTrace(Vector3<Double> var1, Vector3<Double> var2);

    public static BoundingBox of(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return (BoundingBox)new class_238(minX, minY, minZ, maxX, maxY, maxZ);
    }
}

