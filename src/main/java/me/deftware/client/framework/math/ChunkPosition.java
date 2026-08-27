/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.math;

import me.deftware.client.framework.math.BlockPosition;

public interface ChunkPosition {
    public int getStartX();

    public int getStartZ();

    public int getEndX();

    public int getEndZ();

    public BlockPosition getCenter();
}

