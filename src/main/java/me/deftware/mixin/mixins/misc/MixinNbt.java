/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.nbt.NbtList
 *  net.minecraft.nbt.NbtElement
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.misc;

import me.deftware.client.framework.nbt.NbtCompound;
import me.deftware.client.framework.nbt.NbtList;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_2487.class})
public class MixinNbt
implements NbtCompound {
    @Override
    @Unique
    public boolean contains(String key) {
        return ((class_2487)this).method_10545(key);
    }

    @Override
    @Unique
    public boolean contains(String key, int type) {
        return ((class_2487)this).method_10573(key, type);
    }

    @Override
    @Unique
    public NbtCompound get(String key) {
        return (NbtCompound)((class_2487)this).method_10580(key);
    }

    @Override
    @Unique
    public NbtList getList(String items, int type) {
        return (NbtList)((class_2487)this).method_10554(items, type);
    }

    @Override
    @Unique
    public int getByte(String key) {
        return ((class_2487)this).method_10571(key);
    }

    @Override
    @Unique
    public void put(String key, NbtList list) {
        ((class_2487)this).method_10566(key, (class_2520)((class_2499)list));
    }
}

