/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.BlockView
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.registry.Registries
 */
package me.deftware.mixin.shared;

import java.util.Optional;
import me.deftware.client.framework.global.types.BlockProperty;
import me.deftware.client.framework.global.types.BlockPropertyManager;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import net.minecraft.world.BlockView;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;

public class BlockManagement {
    public static Optional<Boolean> shouldDrawSide(class_2680 state, class_1922 world, class_2338 pos, class_2350 facing) {
        BlockPropertyManager blockProperties = Bootstrap.blockProperties;
        if (blockProperties.isActive()) {
            int id = class_7923.field_41175.method_10206((Object)state.method_26204());
            if (blockProperties.contains(id) && ((BlockProperty)blockProperties.get(id)).isRender()) {
                if (!blockProperties.isExposedOnly() || BlockManagement.isAnySideTouchingBlock(pos, world, class_2246.field_10124, class_2246.field_10543)) {
                    return Optional.of(true);
                }
            } else if (blockProperties.isDisableCaveRendering() && BlockManagement.isAnySideTouchingBlock(pos, world, class_2246.field_10543, class_2246.field_10382, class_2246.field_10164) || !blockProperties.isOpacityMode()) {
                return Optional.of(false);
            }
        }
        return Optional.empty();
    }

    public static boolean isAnySideTouchingBlock(class_2338 pos, class_1922 world, class_2248 ... blocks) {
        for (class_2350 direction : class_2350.values()) {
            try {
                class_2680 blockState = world.method_8320(pos.method_10079(direction, 1));
                for (class_2248 block : blocks) {
                    if (blockState.method_26204() != block) continue;
                    return true;
                }
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                // empty catch block
            }
        }
        return false;
    }
}

