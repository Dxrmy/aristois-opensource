/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.explosion.ExplosionImpl
 */
package me.deftware.client.framework.entity.types.objects;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.Vector3;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.explosion.ExplosionImpl;

public class EndCrystalEntity
extends Entity {
    public EndCrystalEntity(class_1297 entity) {
        super(entity);
    }

    public float getEntityDamage(Entity entity) {
        return class_9892.method_61731((class_243)this.entity.method_19538(), (class_1297)entity.getMinecraftEntity());
    }

    public static float getExplosionExposure(Vector3<Double> vec, Entity entity) {
        return class_9892.method_61731((class_243)((class_243)vec), (class_1297)entity.getMinecraftEntity());
    }
}

