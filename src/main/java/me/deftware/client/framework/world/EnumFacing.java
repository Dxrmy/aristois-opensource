/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Direction
 */
package me.deftware.client.framework.world;

import me.deftware.client.framework.math.Vector3;
import net.minecraft.util.math.Direction;

public enum EnumFacing {
    DOWN(class_2350.field_11033),
    UP(class_2350.field_11036),
    NORTH(class_2350.field_11043),
    SOUTH(class_2350.field_11035),
    WEST(class_2350.field_11039),
    EAST(class_2350.field_11034);

    private final class_2350 direction;

    private EnumFacing(class_2350 direction) {
        this.direction = direction;
    }

    public Vector3<Integer> getVector() {
        return (Vector3)this.direction.method_62675();
    }

    public class_2350 getFacing() {
        return this.direction;
    }

    public static EnumFacing fromMinecraft(class_2350 direction) {
        for (EnumFacing facing : EnumFacing.values()) {
            if (facing.getFacing() != direction) continue;
            return facing;
        }
        return NORTH;
    }
}

