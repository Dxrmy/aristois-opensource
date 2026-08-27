/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_310
 *  net.minecraft.class_3965
 */
package me.deftware.client.framework.world.ray;

import java.util.Objects;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.ray.RayProfile;
import me.deftware.client.framework.world.ray.RayTrace;
import net.minecraft.class_239;
import net.minecraft.class_310;
import net.minecraft.class_3965;

public class BlockRayTrace
extends RayTrace<BlockSwingResult> {
    public BlockRayTrace(Vector3<Double> start, Vector3<Double> end, RayProfile profile) {
        super(start, end, profile);
    }

    @Override
    public BlockSwingResult run(Entity entity) {
        class_3965 result = Objects.requireNonNull(class_310.method_1551().field_1687).method_17742(this.getContext(entity));
        if (result != null && result.method_17783() == class_239.class_240.field_1332) {
            return new BlockSwingResult((class_239)result);
        }
        return null;
    }
}

