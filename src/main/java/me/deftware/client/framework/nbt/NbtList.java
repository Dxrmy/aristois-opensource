/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.NbtList
 */
package me.deftware.client.framework.nbt;

import me.deftware.client.framework.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

public interface NbtList {
    public static NbtList empty() {
        return (NbtList)new class_2499();
    }

    public int size();

    public NbtCompound getCompound(int var1);

    public void append(String var1);
}

