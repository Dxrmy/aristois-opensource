/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2975
 *  net.minecraft.class_6796
 *  net.minecraft.class_6880
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package me.deftware.mixin.mixins.biome;

import net.minecraft.class_2975;
import net.minecraft.class_6796;
import net.minecraft.class_6880;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_6796.class})
public interface PlacedFeatureAccessor {
    @Accessor(value="feature")
    public class_6880<class_2975<?, ?>> getFeature();
}

