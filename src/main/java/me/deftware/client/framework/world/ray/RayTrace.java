/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 */
package me.deftware.client.framework.world.ray;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.util.hitresult.CrosshairResult;
import me.deftware.client.framework.world.ray.RayProfile;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public abstract class RayTrace<T extends CrosshairResult> {
    protected final Vector3<Double> start;
    protected final Vector3<Double> end;
    protected final RayProfile profile;

    public RayTrace(Vector3<Double> start, Vector3<Double> end, RayProfile profile) {
        this.start = start;
        this.end = end;
        this.profile = profile;
    }

    protected class_3959 getContext(Entity entity) {
        return new class_3959((class_243)this.start, (class_243)this.end, this.profile.getShape(), this.profile.getFluidHandling(), entity.getMinecraftEntity());
    }

    public abstract T run(Entity var1);
}

