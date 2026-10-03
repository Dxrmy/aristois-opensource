/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.gen.heightprovider.HeightProvider
 *  net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package me.deftware.mixin.mixins.biome;

import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_6795.class})
public interface HeightPlacementAccessor {
    @Accessor(value="height")
    public class_6122 getHeight();
}

