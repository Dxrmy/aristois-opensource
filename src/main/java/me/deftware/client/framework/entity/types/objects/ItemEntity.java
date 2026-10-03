/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemEntity
 */
package me.deftware.client.framework.entity.types.objects;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;

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

