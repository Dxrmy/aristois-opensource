/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.item;

import java.util.function.Consumer;
import me.deftware.client.framework.inventory.EntityInventory;
import me.deftware.client.framework.item.ItemStack;
import net.minecraft.class_1661;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_1661.class})
public abstract class MixinEntityInventory
implements EntityInventory {
    @Override
    @Unique
    public void armor(Consumer<ItemStack> consumer) {
        ((class_1661)this).field_7548.forEach(stack -> consumer.accept((ItemStack)stack));
    }

    @Override
    @Unique
    public void main(Consumer<ItemStack> consumer) {
        ((class_1661)this).field_7547.forEach(stack -> consumer.accept((ItemStack)stack));
    }

    @Override
    @Unique
    public ItemStack getStackInArmourSlot(int slotId) {
        if (slotId >= ((class_1661)this).field_7548.size()) {
            return ItemStack.EMPTY;
        }
        return (ItemStack)((class_1661)this).field_7548.get(slotId);
    }

    @Override
    @Unique
    public void setCurrentItem(int id) {
        ((class_1661)this).field_7545 = id;
    }

    @Override
    @Unique
    public int getCurrentItem() {
        return ((class_1661)this).field_7545;
    }
}

