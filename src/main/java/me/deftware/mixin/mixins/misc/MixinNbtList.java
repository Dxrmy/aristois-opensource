/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2499
 *  net.minecraft.class_2519
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.misc;

import me.deftware.client.framework.nbt.NbtCompound;
import me.deftware.client.framework.nbt.NbtList;
import net.minecraft.class_2499;
import net.minecraft.class_2519;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_2499.class})
public class MixinNbtList
implements NbtList {
    @Override
    @Unique
    public int size() {
        return ((class_2499)this).size();
    }

    @Override
    @Unique
    public NbtCompound getCompound(int index) {
        return (NbtCompound)((class_2499)this).method_10602(index);
    }

    @Override
    @Unique
    public void append(String text) {
        ((class_2499)this).add((Object)class_2519.method_23256((String)text));
    }
}

