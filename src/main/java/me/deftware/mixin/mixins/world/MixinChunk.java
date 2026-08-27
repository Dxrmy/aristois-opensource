/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2818
 *  org.spongepowered.asm.mixin.Mixin
 */
package me.deftware.mixin.mixins.world;

import me.deftware.client.framework.world.chunk.ChunkAccessor;
import me.deftware.client.framework.world.chunk.SectionAccessor;
import net.minecraft.class_2818;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={class_2818.class})
public class MixinChunk
implements ChunkAccessor {
    @Override
    public SectionAccessor getSection(int index) {
        return (SectionAccessor)((class_2818)this).method_38259(index);
    }

    @Override
    public int getChunkPosX() {
        return ((class_2818)this).method_12004().field_9181;
    }

    @Override
    public int getChunkPosZ() {
        return ((class_2818)this).method_12004().field_9180;
    }

    @Override
    public int getChunkHeight() {
        return ((class_2818)this).method_31605();
    }

    @Override
    public int getChunkMinY() {
        return ((class_2818)this).method_31607();
    }
}

