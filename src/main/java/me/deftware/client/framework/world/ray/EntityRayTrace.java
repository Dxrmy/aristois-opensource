/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.ProjectileUtil
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.util.hit.EntityHitResult
 */
package me.deftware.client.framework.world.ray;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.util.minecraft.EntitySwingResult;
import me.deftware.client.framework.world.ray.RayProfile;
import me.deftware.client.framework.world.ray.RayTrace;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.math.Box;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.EntityHitResult;

public class EntityRayTrace
extends RayTrace<EntitySwingResult> {
    private final double maxDistance;
    private final Vector3<Double> rotation;

    public EntityRayTrace(Vector3<Double> start, Vector3<Double> end, Vector3<Double> rotation, double distance, RayProfile profile) {
        super(start, end, profile);
        this.maxDistance = distance;
        this.rotation = rotation;
    }

    @Override
    public EntitySwingResult run(Entity in) {
        double g;
        class_238 box;
        class_3966 result;
        class_1297 entity = in.getMinecraftEntity();
        class_239 hitResult = this.raycast(this.start, this.end, entity);
        double distance = this.maxDistance * this.maxDistance;
        if (hitResult != null && hitResult.method_17783() == class_239.class_240.field_1332) {
            distance = hitResult.method_17784().method_1025((class_243)this.start);
        }
        if ((result = class_1675.method_18075((class_1297)entity, (class_243)((class_243)this.start), (class_243)((class_243)this.end), (class_238)(box = entity.method_5829().method_18804((class_243)this.rotation.multiply(this.maxDistance)).method_1009(1.0, 1.0, 1.0)), e -> !e.method_7325() && e.method_5863(), (double)distance)) != null && (g = this.start.distanceTo((Vector3)result.method_17784())) < distance) {
            return new EntitySwingResult((class_239)result);
        }
        return null;
    }

    public class_239 raycast(Vector3<Double> start, Vector3<Double> end, class_1297 entity) {
        return class_310.method_1551().field_1687.method_17742(new class_3959((class_243)start, (class_243)end, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, entity));
    }
}

