/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.util.shape.VoxelShapes
 */
package me.deftware.client.framework.math;

import me.deftware.client.framework.math.BoundingBox;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShapes;

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

