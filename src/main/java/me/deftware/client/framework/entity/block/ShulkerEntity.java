/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2586
 *  net.minecraft.class_2627
 *  net.minecraft.class_5562
 */
package me.deftware.client.framework.entity.block;

import java.awt.Color;
import me.deftware.client.framework.entity.block.StorageEntity;
import net.minecraft.class_2586;
import net.minecraft.class_2627;
import net.minecraft.class_5562;

public class ShulkerEntity
extends StorageEntity {
    private Color color;

    public ShulkerEntity(class_2586 entity, class_5562 ticker) {
        super(entity, ticker);
    }

    public class_2627 getMinecraftEntity() {
        return (class_2627)this.entity;
    }

    public Color getColor() {
        if (this.color == null && this.getMinecraftEntity().method_11320() == null) {
            this.color = Color.pink;
        }
        return this.color;
    }
}

