/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.world.HeightLimitView
 *  net.minecraft.world.gen.HeightContext
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package me.deftware.client.framework.world.gen;

import net.minecraft.world.chunk.Chunk;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.gen.HeightContext;
import org.jetbrains.annotations.ApiStatus;

public interface DecoratorContext {
    @ApiStatus.Internal
    public class_5868 getHeightContext();

    public static DecoratorContext create() {
        class_2791 chunk = class_310.method_1551().field_1687.method_22350(class_310.method_1551().field_1724.method_24515());
        class_5868 heightContext = new class_5868(null, (class_5539)chunk);
        return () -> heightContext;
    }
}

