/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1675
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3966
 */
package me.deftware.client.framework.world.ray;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.util.minecraft.EntitySwingResult;
import me.deftware.client.framework.world.ray.RayProfile;
import me.deftware.client.framework.world.ray.RayTrace;
import net.minecraft.class_1297;
import net.minecraft.class_1675;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3959;
import net.minecraft.class_3966;

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

