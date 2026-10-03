/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.shape.VoxelShape
 *  org.spongepowered.asm.mixin.Mixin
 */
package me.deftware.mixin.mixins.math;

import me.deftware.client.framework.math.BoundingBox;
import me.deftware.client.framework.math.Voxel;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={class_265.class})
public class MixinVoxelShape
implements Voxel {
    @Override
    public BoundingBox getBoundingBox() {
        return (BoundingBox)((class_265)this).method_1107();
    }
}

