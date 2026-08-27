/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2919
 *  net.minecraft.class_2919$class_6675
 *  net.minecraft.class_5819
 */
package me.deftware.client.framework.world.chunk;

import me.deftware.client.framework.world.chunk.Randomizer;
import net.minecraft.class_2919;
import net.minecraft.class_5819;

public interface ChunkGenerationRandom
extends Randomizer {
    public long _setPopulationSeed(long var1, int var3, int var4);

    public void _setDecoratorSeed(long var1, int var3, int var4);

    public static ChunkGenerationRandom create(long seed) {
        class_5819 random = class_2919.class_6675.field_35143.method_39006(seed);
        class_2919 chunkRandom = new class_2919(random);
        return (ChunkGenerationRandom)chunkRandom;
    }
}

