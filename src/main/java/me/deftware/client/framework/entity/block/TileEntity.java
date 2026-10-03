/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.block.entity.EnderChestBlockEntity
 *  net.minecraft.block.entity.LootableContainerBlockEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.world.chunk.BlockEntityTickInvoker
 */
package me.deftware.client.framework.entity.block;

import java.util.Optional;
import lombok.Generated;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.block.StorageEntity;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.chunk.BlockEntityTickInvoker;

public class TileEntity {
    protected final class_2586 entity;
    protected final class_5562 ticker;
    protected Block block;

    public static TileEntity newInstance(class_2586 entity, class_5562 ticker) {
        if (entity instanceof class_2621 || entity instanceof class_2611) {
            return StorageEntity.newInstance(entity, ticker);
        }
        return new TileEntity(entity, ticker);
    }

    public class_2586 getMinecraftEntity() {
        return this.entity;
    }

    protected TileEntity(class_2586 entity, class_5562 ticker) {
        this.ticker = ticker;
        this.entity = entity;
        class_2960 identifier = class_2591.method_11033((class_2591)entity.method_11017());
        if (identifier != null) {
            Optional<Block> block = BlockRegistry.INSTANCE.find(identifier.method_12832());
            block.ifPresent(value -> {
                this.block = value;
            });
        }
    }

    public String getClassName() {
        return this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().length() - "Entity".length());
    }

    public BlockPosition getBlockPosition() {
        return (BlockPosition)this.getMinecraftEntity().method_11016();
    }

    public double distanceTo(Entity entity) {
        return this.getBlockPosition().distanceTo(entity.getBlockPosition());
    }

    public Block getBlock() {
        return this.block;
    }

    @Generated
    public class_5562 getTicker() {
        return this.ticker;
    }
}

