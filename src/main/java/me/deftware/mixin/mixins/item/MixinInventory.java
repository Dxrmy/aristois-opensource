/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.item;

import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.ItemStack;
import net.minecraft.class_1263;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_1263.class})
public interface MixinInventory
extends Inventory {
    @Override
    @Unique
    default public int getSize() {
        return ((class_1263)this).method_5439();
    }

    @Override
    @Unique
    default public boolean isEmpty() {
        return ((class_1263)this).method_5442();
    }

    @Override
    @Unique
    default public ItemStack getStackInSlot(int slotId) {
        if (slotId >= this.getSize()) {
            return ItemStack.EMPTY;
        }
        return (ItemStack)((class_1263)this).method_5438(slotId);
    }
}

