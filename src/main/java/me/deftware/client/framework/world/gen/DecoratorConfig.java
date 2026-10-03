/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.world.gen.GenerationStep$Feature
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.world.gen.heightprovider.HeightProvider
 *  net.minecraft.world.gen.placementmodifier.CountPlacementModifier
 */
package me.deftware.client.framework.world.gen;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import lombok.Generated;
import me.deftware.client.framework.registry.Identifiable;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.chunk.Randomizer;
import me.deftware.client.framework.world.gen.DecoratorContext;
import me.deftware.mixin.mixins.biome.CountInvoker;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;

public class DecoratorConfig {
    private String id = "unknown";
    private int index;
    private class_6122 heightProvider;
    private CountInvoker repeat = (CountInvoker)class_6793.method_39623((int)1);
    private int size;
    private int chance = 1;
    private float discardOnAirChance;
    private final Set<Block> blockList = new HashSet<Block>();
    private StructureType structureType = StructureType.Uniform;
    private FeatureType featureType = FeatureType.Ore;
    private final class_2893.class_2895 feature;

    public DecoratorConfig(int index, class_2893.class_2895 feature) {
        this.index = index;
        this.feature = feature;
    }

    public int getY(Randomizer random, DecoratorContext context) {
        return this.heightProvider.method_35391((class_5819)random, context.getHeightContext());
    }

    public int getFeature() {
        return this.feature.ordinal();
    }

    public int getRepeat(Randomizer random) {
        return this.repeat.getInvokedCount(random, null);
    }

    public String toString() {
        return new StringJoiner(", ", "[ ", " ]").add("id=" + this.id).add("index=" + this.index).add("size=" + this.size).add("heightType=" + this.structureType.name()).add("feature=" + this.feature.name()).add("generator=" + this.featureType.name()).add("chance=" + this.chance).add("height=" + (this.heightProvider == null ? "Unknown" : this.heightProvider.toString())).add("blocks=[" + String.join((CharSequence)",", (CharSequence[])this.blockList.stream().map(Identifiable::getIdentifierKey).toArray(String[]::new)) + "]").toString();
    }

    @Generated
    public void setId(String id) {
        this.id = id;
    }

    @Generated
    public void setIndex(int index) {
        this.index = index;
    }

    @Generated
    public void setHeightProvider(class_6122 heightProvider) {
        this.heightProvider = heightProvider;
    }

    @Generated
    public void setRepeat(CountInvoker repeat) {
        this.repeat = repeat;
    }

    @Generated
    public void setSize(int size) {
        this.size = size;
    }

    @Generated
    public void setChance(int chance) {
        this.chance = chance;
    }

    @Generated
    public void setDiscardOnAirChance(float discardOnAirChance) {
        this.discardOnAirChance = discardOnAirChance;
    }

    @Generated
    public void setStructureType(StructureType structureType) {
        this.structureType = structureType;
    }

    @Generated
    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    @Generated
    public String getId() {
        return this.id;
    }

    @Generated
    public int getIndex() {
        return this.index;
    }

    @Generated
    public class_6122 getHeightProvider() {
        return this.heightProvider;
    }

    @Generated
    public CountInvoker getRepeat() {
        return this.repeat;
    }

    @Generated
    public int getSize() {
        return this.size;
    }

    @Generated
    public int getChance() {
        return this.chance;
    }

    @Generated
    public float getDiscardOnAirChance() {
        return this.discardOnAirChance;
    }

    @Generated
    public Set<Block> getBlockList() {
        return this.blockList;
    }

    @Generated
    public StructureType getStructureType() {
        return this.structureType;
    }

    @Generated
    public FeatureType getFeatureType() {
        return this.featureType;
    }

    public static enum StructureType {
        Uniform,
        Trapezoid;

    }

    public static enum FeatureType {
        Ore,
        ScatteredOre,
        Emerald;

    }
}

