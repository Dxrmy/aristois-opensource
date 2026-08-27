/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_259
 */
package me.deftware.client.framework.math;

import me.deftware.client.framework.math.BoundingBox;
import net.minecraft.class_2248;
import net.minecraft.class_259;

public interface Voxel {
    public BoundingBox getBoundingBox();

    public static Voxel cuboid(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return (Voxel)class_2248.method_9541((double)minX, (double)minY, (double)minZ, (double)maxX, (double)maxY, (double)maxZ);
    }

    public static Voxel solid() {
        return (Voxel)class_259.method_1077();
    }

    public static Voxel empty() {
        return (Voxel)class_259.method_1073();
    }
}

