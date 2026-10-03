/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.DoubleInventory
 */
package me.deftware.client.framework.inventory;

import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import net.minecraft.inventory.DoubleInventory;

public interface Inventory {
    public int getSize();

    public boolean isEmpty();

    public ItemStack getStackInSlot(int var1);

    default public int findItem(Item item) {
        for (int i = 0; i < this.getSize(); ++i) {
            ItemStack it = this.getStackInSlot(i);
            if (!it.getItem().equals(item)) continue;
            return i;
        }
        return -1;
    }

    default public boolean isFull() {
        for (int i = 0; i < this.getSize(); ++i) {
            if (!this.getStackInSlot(i).isEmpty()) continue;
            return false;
        }
        return true;
    }

    default public boolean isDouble() {
        return this instanceof class_1258;
    }
}

