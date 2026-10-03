/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.EnderChestBlockEntity
 *  net.minecraft.block.entity.TrappedChestBlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.DoubleBlockProperties$Type
 *  net.minecraft.world.chunk.BlockEntityTickInvoker
 */
package me.deftware.client.framework.entity.block;

import me.deftware.client.framework.entity.block.StorageEntity;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.TrappedChestBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.world.chunk.BlockEntityTickInvoker;

public class ChestEntity
extends StorageEntity {
    public ChestEntity(class_2586 entity, class_5562 ticker) {
        super(entity, ticker);
    }

    public boolean isFirst() {
        return !this.isEnderChest() && class_2281.method_24169((class_2680)this.entity.method_11010()) == class_4732.class_4733.field_21784;
    }

    public boolean isDouble() {
        return !this.isEnderChest() && class_2281.method_24169((class_2680)this.entity.method_11010()) != class_4732.class_4733.field_21783;
    }

    public boolean isEnderChest() {
        return this.entity instanceof class_2611;
    }

    public boolean isTrapped() {
        return this.entity instanceof class_2646;
    }
}

