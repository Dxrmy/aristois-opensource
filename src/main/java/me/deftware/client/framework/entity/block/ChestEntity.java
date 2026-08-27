/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2281
 *  net.minecraft.class_2586
 *  net.minecraft.class_2611
 *  net.minecraft.class_2646
 *  net.minecraft.class_2680
 *  net.minecraft.class_4732$class_4733
 *  net.minecraft.class_5562
 */
package me.deftware.client.framework.entity.block;

import me.deftware.client.framework.entity.block.StorageEntity;
import net.minecraft.class_2281;
import net.minecraft.class_2586;
import net.minecraft.class_2611;
import net.minecraft.class_2646;
import net.minecraft.class_2680;
import net.minecraft.class_4732;
import net.minecraft.class_5562;

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

