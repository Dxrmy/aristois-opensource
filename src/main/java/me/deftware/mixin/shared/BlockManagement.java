/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_7923
 */
package me.deftware.mixin.shared;

import java.util.Optional;
import me.deftware.client.framework.global.types.BlockProperty;
import me.deftware.client.framework.global.types.BlockPropertyManager;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_7923;

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

