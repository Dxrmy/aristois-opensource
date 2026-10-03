/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.math.Vec3d
 */
package me.deftware.client.framework.math;

import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.Vec3d;

public interface Vector3<T extends Number> {
    public T getX();

    public T getY();

    public T getZ();

    public Vector3<T> add(T var1, T var2, T var3);

    public Vector3<T> subtract(T var1, T var2, T var3);

    public Vector3<T> multiply(T var1, T var2, T var3);

    public double distanceTo(T var1, T var2, T var3);

    default public double getMagnitude() {
        double x = ((Number)this.getX()).doubleValue();
        double y = ((Number)this.getY()).doubleValue();
        double z = ((Number)this.getZ()).doubleValue();
        return Math.sqrt(x * x + y * y + z * z);
    }

    default public Vector3<T> multiply(T scalar) {
        return this.multiply(scalar, scalar, scalar);
    }

    default public Vector3<T> add(Vector3<T> vector) {
        return this.add(vector.getX(), vector.getY(), vector.getZ());
    }

    default public Vector3<T> subtract(Vector3<T> vector) {
        return this.subtract(vector.getX(), vector.getY(), vector.getZ());
    }

    default public Vector3<T> multiply(Vector3<T> vector) {
        return this.multiply(vector.getX(), vector.getY(), vector.getZ());
    }

    default public double distanceTo(Vector3<T> vector) {
        return this.distanceTo(vector.getX(), vector.getY(), vector.getZ());
    }

    public static Vector3<Integer> ofInt(int x, int y, int z) {
        return (Vector3)new class_2382(x, y, z);
    }

    public static Vector3<Double> ofDouble(double x, double y, double z) {
        return (Vector3)new class_243(x, y, z);
    }
}

