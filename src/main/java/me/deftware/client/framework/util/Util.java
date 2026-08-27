/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 */
package me.deftware.client.framework.util;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import me.deftware.client.framework.item.ItemStack;

public class Util {
    public static List<ItemStack> getEmptyStackList(int size) {
        return Util.getFilledList(size, i -> ItemStack.EMPTY);
    }

    public static <T> List<T> getFilledList(int size, Function<Integer, T> supplier) {
        ArrayList list = Lists.newArrayListWithCapacity((int)size);
        for (int i = 0; i < size; ++i) {
            list.add(supplier.apply(i));
        }
        return list;
    }
}

