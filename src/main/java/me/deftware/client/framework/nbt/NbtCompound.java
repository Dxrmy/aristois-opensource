/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.NbtCompound
 */
package me.deftware.client.framework.nbt;

import me.deftware.client.framework.nbt.NbtList;
import net.minecraft.nbt.NbtCompound;

public interface NbtCompound {
    public static NbtCompound create() {
        return (NbtCompound)new class_2487();
    }

    public boolean contains(String var1);

    public boolean contains(String var1, int var2);

    public NbtCompound get(String var1);

    public NbtList getList(String var1, int var2);

    public int getByte(String var1);

    public void put(String var1, NbtList var2);
}

