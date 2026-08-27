/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_2960
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package me.deftware.client.framework.world.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import me.deftware.client.framework.world.gen.DecoratorConfig;
import net.minecraft.class_2960;
import org.jetbrains.annotations.ApiStatus;

public class BiomeDecorator {
    @ApiStatus.Internal
    public static final Map<class_2960, BiomeDecorator> BIOME_DECORATORS = new HashMap<class_2960, BiomeDecorator>();
    private final List<DecoratorConfig> decorators = new ArrayList<DecoratorConfig>();

    @Generated
    public List<DecoratorConfig> getDecorators() {
        return this.decorators;
    }
}

