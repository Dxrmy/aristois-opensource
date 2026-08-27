/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1923
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.math;

import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.math.ChunkPosition;
import net.minecraft.class_1923;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_1923.class})
public class MixinChunkPos
implements ChunkPosition {
    @Override
    @Unique
    public int getStartX() {
        return ((class_1923)this).method_8326();
    }

    @Override
    @Unique
    public int getStartZ() {
        return ((class_1923)this).method_8328();
    }

    @Override
    @Unique
    public int getEndX() {
        return ((class_1923)this).method_8327();
    }

    @Override
    @Unique
    public int getEndZ() {
        return ((class_1923)this).method_8329();
    }

    @Override
    @Unique
    public BlockPosition getCenter() {
        return BlockPosition.of(((class_1923)this).method_33940(), 0, ((class_1923)this).method_33942());
    }
}

