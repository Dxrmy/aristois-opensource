/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 */
package me.deftware.client.framework.math;

import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.world.EnumFacing;
import net.minecraft.class_2338;

public interface BlockPosition
extends Vector3<Integer> {
    public long asLong();

    public BlockPosition offset(EnumFacing var1);

    default public BlockPosition offset(int x, int y, int z) {
        return BlockPosition.of((Integer)this.getX() + x, (Integer)this.getY() + y, (Integer)this.getZ() + z);
    }

    public static BlockPosition of(int x, int y, int z) {
        return (BlockPosition)new class_2338(x, y, z);
    }

    public static BlockPosition of(Vector3<Integer> vector) {
        return BlockPosition.of(vector.getX(), vector.getY(), vector.getZ());
    }
}

