/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_5819
 *  net.minecraft.class_5857
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package me.deftware.mixin.mixins.biome;

import net.minecraft.class_2338;
import net.minecraft.class_5819;
import net.minecraft.class_5857;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_5857.class})
public interface CountInvoker {
    @Invoker(value="getCount")
    public int getInvokedCount(class_5819 var1, class_2338 var2);
}

