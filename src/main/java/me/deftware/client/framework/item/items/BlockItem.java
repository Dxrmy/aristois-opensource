/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_9288
 *  net.minecraft.class_9334
 */
package me.deftware.client.framework.item.items;

import java.util.function.Consumer;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.class_1799;
import net.minecraft.class_9288;
import net.minecraft.class_9334;

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

