/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1542
 */
package me.deftware.client.framework.entity.types.objects;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.item.ItemStack;
import net.minecraft.class_1297;
import net.minecraft.class_1542;

public class ItemEntity
extends Entity {
    private final ItemStack stack = ItemStack.EMPTY;

    public ItemEntity(class_1297 entity) {
        super(entity);
    }

    public ItemStack getStack() {
        return (ItemStack)this.getMinecraftEntity().method_6983();
    }

    public class_1542 getMinecraftEntity() {
        return (class_1542)this.entity;
    }
}

