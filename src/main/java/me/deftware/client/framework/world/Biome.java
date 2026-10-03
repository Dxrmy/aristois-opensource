/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryEntry
 */
package me.deftware.client.framework.world;

import me.deftware.client.framework.world.gen.BiomeDecorator;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

public class Biome {
    private class_6880<class_1959> biome;

    public Biome setReference(class_6880<class_1959> biome) {
        this.biome = biome;
        return this;
    }

    private class_2960 getId() {
        class_5321 key = (class_5321)this.biome.method_40230().get();
        return key.method_29177();
    }

    public String getKey() {
        class_2960 id = this.getId();
        if (id == null) {
            return null;
        }
        return id.method_12832();
    }

    public String getCatergory() {
        return (String)this.biome.method_40229().map(b -> b.method_29177().method_12832(), b -> "[unregistered]");
    }

    public BiomeDecorator getDecorator() {
        return BiomeDecorator.BIOME_DECORATORS.get(this.getId());
    }
}

