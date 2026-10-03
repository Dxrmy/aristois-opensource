/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.component.type.ContainerComponent
 *  net.minecraft.component.DataComponentTypes
 */
package me.deftware.client.framework.item.items;

import java.util.function.Consumer;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.component.DataComponentTypes;

public interface BlockItem
extends Item {
    public Block getBlock();

    public static void getItems(ItemStack stack, Consumer<ItemStack> consumer) {
        class_9288 container = (class_9288)((class_1799)stack).method_57824(class_9334.field_49622);
        if (container != null) {
            container.method_57489().forEach(s -> consumer.accept((ItemStack)s));
        }
    }
}

