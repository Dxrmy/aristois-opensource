/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.ChestBlockEntity
 *  net.minecraft.block.entity.EnderChestBlockEntity
 *  net.minecraft.block.entity.HopperBlockEntity
 *  net.minecraft.block.entity.ShulkerBoxBlockEntity
 *  net.minecraft.block.entity.BarrelBlockEntity
 *  net.minecraft.world.chunk.BlockEntityTickInvoker
 */
package me.deftware.client.framework.entity.block;

import me.deftware.client.framework.entity.block.BarrelEntity;
import me.deftware.client.framework.entity.block.ChestEntity;
import me.deftware.client.framework.entity.block.HopperEntity;
import me.deftware.client.framework.entity.block.ShulkerEntity;
import me.deftware.client.framework.entity.block.TileEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.world.chunk.BlockEntityTickInvoker;

public class StorageEntity
extends TileEntity {
    public static StorageEntity newInstance(class_2586 entity, class_5562 ticker) {
        if (entity instanceof class_2595 || entity instanceof class_2611) {
            return new ChestEntity(entity, ticker);
        }
        if (entity instanceof class_3719) {
            return new BarrelEntity(entity, ticker);
        }
        if (entity instanceof class_2627) {
            return new ShulkerEntity(entity, ticker);
        }
        if (entity instanceof class_2614) {
            return new HopperEntity(entity, ticker);
        }
        return new StorageEntity(entity, ticker);
    }

    protected StorageEntity(class_2586 entity, class_5562 ticker) {
        super(entity, ticker);
    }
}

