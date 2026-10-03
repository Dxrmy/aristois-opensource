/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EyeOfEnderEntity
 */
package me.deftware.client.framework.item;

import me.deftware.client.framework.math.Vector3;
import net.minecraft.entity.EyeOfEnderEntity;

public class ThrowData {
    private final class_1672 entity;
    public double x;
    public double z;
    public double posX;
    public double posZ;
    private double count = 1.0;

    public ThrowData(class_1672 entity, double posX, double posZ, double x, double z) {
        this.entity = entity;
        this.posX = posX;
        this.posZ = posZ;
        this.x = x;
        this.z = z;
    }

    public void addVec(double x, double z) {
        this.x = this.x * this.count + x / (this.count + 1.0);
        this.z = this.z * this.count + z / (this.count += 1.0);
    }

    public Vector3<Double> calculateIntersection(ThrowData d) {
        double x = (-d.z * d.posX * this.x + d.x * d.posZ * this.x + d.x * this.z * this.posX + d.x * -this.x * this.posZ) / (d.x * this.z - d.z * this.x);
        double z = this.z / this.x * x + this.posZ - this.z / this.x * this.posX;
        return Vector3.ofDouble(x, 36.0, z);
    }

    public boolean sameEntity(class_1672 e) {
        return this.entity == e;
    }
}

