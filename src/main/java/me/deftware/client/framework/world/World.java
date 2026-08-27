/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2586
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package me.deftware.client.framework.world;

import java.util.HashMap;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.block.TileEntity;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.world.Biome;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.BlockState;
import me.deftware.client.framework.world.chunk.ChunkAccessor;
import net.minecraft.class_2586;
import org.jetbrains.annotations.ApiStatus;

public interface World {
    public Stream<TileEntity> getLoadedTileEntities();

    public int _getDifficulty();

    public long _getWorldTime();

    public int _getWorldHeight();

    public Biome _getBiome();

    public int _getBlockLightLevel(BlockPosition var1);

    public void _disconnect();

    public ChunkAccessor getChunk(int var1, int var2);

    public boolean _hasChunk(int var1, int var2);

    public int _getDimension();

    public BlockState _getBlockState(BlockPosition var1);

    public boolean rayTraceBlocks(Vector3<Double> var1, Vector3<Double> var2);

    default public Block _getBlockFromPosition(BlockPosition position) {
        return this._getBlockState(position).getBlock();
    }

    @ApiStatus.Internal
    public <T extends TileEntity> T getTileEntityByReference(class_2586 var1);

    @ApiStatus.Internal
    public HashMap<Long, class_2586> getInternalLongToBlockEntity();
}

