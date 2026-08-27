/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_2596
 *  net.minecraft.class_2820
 *  net.minecraft.class_9262
 *  net.minecraft.class_9301
 *  net.minecraft.class_9334
 */
package me.deftware.client.framework.network.packets;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.ItemTypes;
import me.deftware.client.framework.network.PacketWrapper;
import net.minecraft.class_1799;
import net.minecraft.class_2596;
import net.minecraft.class_2820;
import net.minecraft.class_9262;
import net.minecraft.class_9301;
import net.minecraft.class_9334;

public class CPacketEditBook
extends PacketWrapper {
    public CPacketEditBook(class_2596<?> packet) {
        super(packet);
    }

    public CPacketEditBook(int slot, List<String> pages, Optional<String> title) {
        super((class_2596<?>)new class_2820(slot, pages, title));
    }

    private static class_2820 of(ItemStack book) {
        class_9301 contents = (class_9301)((class_1799)book).method_57824(class_9334.field_49653);
        if (contents != null) {
            List pages = contents.comp_2422();
            ArrayList<String> list = new ArrayList<String>(pages.size());
            for (class_9262 page : pages) {
                list.add((String)page.comp_2369());
            }
            return new class_2820(0, list, Optional.empty());
        }
        throw new IllegalArgumentException("ItemStack must be a writable book with valid data");
    }

    public CPacketEditBook(ItemStack book) {
        super((class_2596<?>)CPacketEditBook.of(book));
    }

    public static void setContents(ItemStack stack, List<String> pages) {
        if (!ItemTypes.WritableBook.is(stack.getItem())) {
            throw new IllegalArgumentException("The stack must be a writable book!");
        }
        class_9301 value = new class_9301(pages.stream().map(class_9262::method_57137).toList());
        ((class_1799)stack).method_57379(class_9334.field_49653, (Object)value);
    }
}

