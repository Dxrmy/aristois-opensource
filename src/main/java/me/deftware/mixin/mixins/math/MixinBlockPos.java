/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.math;

import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.mixin.mixins.math.MixinVector3i;
import net.minecraft.class_2338;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_2338.class})
public class MixinBlockPos
extends MixinVector3i
implements BlockPosition {
    @Override
    @Unique
    public BlockPosition offset(EnumFacing direction) {
        return (BlockPosition)((class_2338)this).method_10079(direction.getFacing(), 1);
    }

    @Override
    @Unique
    public long asLong() {
        return ((class_2338)this).method_10063();
    }
}

