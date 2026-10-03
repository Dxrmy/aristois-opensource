/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.random.ChunkRandom
 *  org.spongepowered.asm.mixin.Mixin
 */
package me.deftware.mixin.mixins.biome;

import me.deftware.client.framework.world.chunk.ChunkGenerationRandom;
import net.minecraft.util.math.random.ChunkRandom;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={class_2919.class})
public abstract class MixinChunkRandom
implements ChunkGenerationRandom {
    @Override
    public long _setPopulationSeed(long worldSeed, int blockX, int blockZ) {
        return ((class_2919)this).method_12661(worldSeed, blockX, blockZ);
    }

    @Override
    public void _setDecoratorSeed(long populationSeed, int index, int step) {
        ((class_2919)this).method_12664(populationSeed, index, step);
    }

    @Override
    public int _nextInt(int bound) {
        return ((class_2919)this).method_43048(bound);
    }

    @Override
    public float _nextFloat() {
        return ((class_2919)this).method_43057();
    }

    @Override
    public double _nextDouble() {
        return ((class_2919)this).method_43058();
    }
}

