/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.AirBlock
 *  net.minecraft.block.AnvilBlock
 *  net.minecraft.block.BlockWithEntity
 *  net.minecraft.block.BedBlock
 *  net.minecraft.block.CakeBlock
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.block.CropBlock
 *  net.minecraft.block.CraftingTableBlock
 *  net.minecraft.block.AbstractRedstoneGateBlock
 *  net.minecraft.block.DoorBlock
 *  net.minecraft.block.DragonEggBlock
 *  net.minecraft.block.EnderChestBlock
 *  net.minecraft.block.FenceGateBlock
 *  net.minecraft.block.FenceBlock
 *  net.minecraft.block.FlowerPotBlock
 *  net.minecraft.block.LeverBlock
 *  net.minecraft.block.FluidBlock
 *  net.minecraft.block.LoomBlock
 *  net.minecraft.block.NoteBlock
 *  net.minecraft.block.ShulkerBoxBlock
 *  net.minecraft.block.TrapdoorBlock
 *  net.minecraft.block.BarrelBlock
 *  net.minecraft.block.CartographyTableBlock
 *  net.minecraft.block.GrindstoneBlock
 *  net.minecraft.block.StonecutterBlock
 *  net.minecraft.block.JigsawBlock
 *  net.minecraft.block.ComposterBlock
 *  net.minecraft.block.RespawnAnchorBlock
 *  net.minecraft.block.CauldronBlock
 */
package me.deftware.client.framework.world.block;

import java.util.function.Predicate;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.block.AirBlock;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.BedBlock;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.AbstractRedstoneGateBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.DragonEggBlock;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.LoomBlock;
import net.minecraft.block.NoteBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.CartographyTableBlock;
import net.minecraft.block.GrindstoneBlock;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.block.JigsawBlock;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.block.CauldronBlock;

public enum BlockTypes {
    AIR(block -> block instanceof class_2189),
    FLUID(block -> block instanceof class_2404),
    CROPS(block -> block instanceof class_2302),
    ShulkerBox(block -> block instanceof class_2480),
    Storage(block -> block instanceof class_2281 || block instanceof class_3708 || block instanceof class_2336),
    Interactable(block -> block instanceof class_2237 || block instanceof class_2199 || block instanceof class_2244 || block instanceof class_2272 || block instanceof class_3711 || block instanceof class_5546 || block instanceof class_2312 || block instanceof class_3962 || block instanceof class_2304 || block instanceof class_2323 || block instanceof class_2328 || block instanceof class_2354 || block instanceof class_2349 || block instanceof class_2362 || block instanceof class_3713 || block instanceof class_3748 || block instanceof class_2401 || block instanceof class_2406 || block instanceof class_2428 || block instanceof class_4969 || block instanceof class_3718 || block instanceof class_2533);

    private final Predicate<Block> predicate;

    private BlockTypes(Predicate<Block> predicate) {
        this.predicate = predicate;
    }

    public boolean is(Block block) {
        return this.predicate.test(block);
    }
}

