/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2586
 *  net.minecraft.class_2595
 *  net.minecraft.class_2611
 *  net.minecraft.class_2614
 *  net.minecraft.class_2627
 *  net.minecraft.class_3719
 *  net.minecraft.class_5562
 */
package me.deftware.client.framework.entity.block;

import me.deftware.client.framework.entity.block.BarrelEntity;
import me.deftware.client.framework.entity.block.ChestEntity;
import me.deftware.client.framework.entity.block.HopperEntity;
import me.deftware.client.framework.entity.block.ShulkerEntity;
import me.deftware.client.framework.entity.block.TileEntity;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2611;
import net.minecraft.class_2614;
import net.minecraft.class_2627;
import net.minecraft.class_3719;
import net.minecraft.class_5562;

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

