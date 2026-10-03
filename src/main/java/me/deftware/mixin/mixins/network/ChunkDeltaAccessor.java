/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.math.ChunkSectionPos
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package me.deftware.mixin.mixins.network;

import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.ChunkSectionPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_2637.class})
public interface ChunkDeltaAccessor {
    @Accessor(value="positions")
    public short[] getPositions();

    @Accessor(value="blockStates")
    public class_2680[] getBlockStates();

    @Accessor(value="sectionPos")
    public class_4076 getSectionPos();
}

