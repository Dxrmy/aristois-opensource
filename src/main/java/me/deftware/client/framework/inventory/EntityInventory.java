/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.inventory;

import java.util.function.Consumer;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.ItemStack;

public interface EntityInventory
extends Inventory {
    public void armor(Consumer<ItemStack> var1);

    public void main(Consumer<ItemStack> var1);

    public ItemStack getStackInArmourSlot(int var1);

    public void setCurrentItem(int var1);

    public int getCurrentItem();
}

