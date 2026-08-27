/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 */
package me.deftware.client.framework.world.ray;

import net.minecraft.class_3959;

public enum RayProfile {
    Block(class_3959.class_3960.field_17559, class_3959.class_242.field_1348),
    IncludeFluid(class_3959.class_3960.field_17559, class_3959.class_242.field_1347);

    private final class_3959.class_3960 shape;
    private final class_3959.class_242 fluidHandling;

    private RayProfile(class_3959.class_3960 shape, class_3959.class_242 fluidHandling) {
        this.shape = shape;
        this.fluidHandling = fluidHandling;
    }

    public class_3959.class_3960 getShape() {
        return this.shape;
    }

    public class_3959.class_242 getFluidHandling() {
        return this.fluidHandling;
    }
}

