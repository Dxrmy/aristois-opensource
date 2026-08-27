/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2211
 *  net.minecraft.class_2248
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2480
 *  net.minecraft.class_2482
 *  net.minecraft.class_2488
 *  net.minecraft.class_265
 *  net.minecraft.class_2667
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_2771
 *  net.minecraft.class_310
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3736
 *  net.minecraft.class_4732$class_4733
 *  net.minecraft.class_5542
 *  net.minecraft.class_5689
 */
package me.deftware.client.framework.world.block;

import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.BlockState;
import net.minecraft.class_2211;
import net.minecraft.class_2248;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2480;
import net.minecraft.class_2482;
import net.minecraft.class_2488;
import net.minecraft.class_265;
import net.minecraft.class_2667;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2771;
import net.minecraft.class_310;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3736;
import net.minecraft.class_4732;
import net.minecraft.class_5542;
import net.minecraft.class_5689;

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

