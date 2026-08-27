/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.world.chunk;

import me.deftware.client.framework.world.chunk.SectionAccessor;

public interface ChunkAccessor {
    public SectionAccessor getSection(int var1);

    public int getChunkPosX();

    public int getChunkPosZ();

    public int getChunkHeight();

    public int getChunkMinY();
}

