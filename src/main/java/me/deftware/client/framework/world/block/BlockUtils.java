/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BambooBlock
 *  net.minecraft.block.Block
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.ShulkerBoxBlock
 *  net.minecraft.block.SlabBlock
 *  net.minecraft.block.SnowBlock
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.PistonExtensionBlock
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.property.Property
 *  net.minecraft.block.enums.SlabType
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.fluid.Fluid
 *  net.minecraft.fluid.Fluids
 *  net.minecraft.block.ScaffoldingBlock
 *  net.minecraft.block.DoubleBlockProperties$Type
 *  net.minecraft.block.AmethystClusterBlock
 *  net.minecraft.block.PointedDripstoneBlock
 */
package me.deftware.client.framework.world.block;

import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.BlockState;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.PistonExtensionBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.block.enums.SlabType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.ScaffoldingBlock;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.PointedDripstoneBlock;

public class BlockUtils {
    public static DoubleBlockType getDoubleBlockType(BlockPosition position) {
        class_2680 state = class_310.method_1551().field_1687.method_8320((class_2338)position);
        if (state.method_26204() instanceof class_2281) {
            class_4732.class_4733 type = class_2281.method_24169((class_2680)state);
            return DoubleBlockType.values()[type.ordinal()];
        }
        return DoubleBlockType.Single;
    }

    public static EnumFacing getBlockFacing(BlockPosition position) {
        class_2680 state = class_310.method_1551().field_1687.method_8320((class_2338)position);
        if (state.method_26204() instanceof class_2281) {
            return EnumFacing.fromMinecraft(class_2281.method_9758((class_2680)state));
        }
        return null;
    }

    public static boolean isNormalCube(BlockState state) {
        Block block = state.getBlock();
        if (block instanceof class_2211 || block instanceof class_2667 || block instanceof class_3736 || block instanceof class_2480 || block instanceof class_5689 || block instanceof class_5542) {
            return false;
        }
        return class_2248.method_9614((class_265)((class_2680)state).method_26220(null, null));
    }

    public static enum DoubleBlockType {
        Single,
        First,
        Second;

    }

    public static class State {
        public static int getSnowLayers(BlockState blockState) {
            if (blockState.getBlock() instanceof class_2488) {
                return (Integer)((class_2680)blockState).method_11654((class_2769)class_2488.field_11518);
            }
            return 0;
        }

        public static boolean isBottomSlab(BlockState blockState) {
            if (blockState.getBlock() instanceof class_2482) {
                return ((class_2680)blockState).method_11654((class_2769)class_2482.field_11501) == class_2771.field_12681;
            }
            return false;
        }
    }

    public static class FluidState {
        public static boolean hasFluid(BlockState blockState) {
            return !((class_2680)blockState).method_26227().method_15769();
        }

        public static boolean isFluidWater(BlockState blockState) {
            class_3611 state = ((class_2680)blockState).method_26227().method_15772();
            return state == class_3612.field_15910 || state == class_3612.field_15909;
        }

        public static boolean isFluidFlowing(BlockState blockState) {
            class_3611 state = ((class_2680)blockState).method_26227().method_15772();
            return state == class_3612.field_15907 || state == class_3612.field_15909;
        }
    }
}

