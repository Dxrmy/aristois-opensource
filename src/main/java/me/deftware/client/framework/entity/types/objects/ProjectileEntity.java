/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.ProjectileEntity
 */
package me.deftware.client.framework.entity.types.objects;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.Vector3;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;

public class ProjectileEntity
extends Entity {
    private Vector3<Double> lastPos;

    public ProjectileEntity(class_1297 entity) {
        super(entity);
    }

    public class_1676 getMinecraftEntity() {
        return (class_1676)this.entity;
    }

    public boolean isMoving() {
        if (this.lastPos != null && this.lastPos.equals(this.getPosition())) {
            return false;
        }
        this.lastPos = this.getPosition();
        return true;
    }
}

