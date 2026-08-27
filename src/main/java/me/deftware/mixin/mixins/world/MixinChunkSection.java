/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2826
 *  org.spongepowered.asm.mixin.Mixin
 */
package me.deftware.mixin.mixins.world;

import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.chunk.SectionAccessor;
import net.minecraft.class_2826;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={class_2826.class})
public class MixinChunkSection
implements SectionAccessor {
    @Override
    public Block getBlock(int x, int y, int z) {
        return (Block)((class_2826)this).method_12254(x, y, z).method_26204();
    }
}

