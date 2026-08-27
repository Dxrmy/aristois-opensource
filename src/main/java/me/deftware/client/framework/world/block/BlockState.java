/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.world.block;

import me.deftware.client.framework.world.block.Block;

public interface BlockState {
    public Block getBlock();

    public boolean isPathFindable();
}

