/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_2596
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.client.framework.world.EnumFacing;
import net.minecraft.class_2338;
import net.minecraft.class_2596;
import net.minecraft.class_2846;

public class CPacketDig
extends PacketWrapper {
    public CPacketDig(class_2596<?> packet) {
        super(packet);
    }

    public CPacketDig(IDigAction action, BlockPosition pos, EnumFacing facing) {
        super((class_2596<?>)new class_2846(CPacketDig.getAction(action), (class_2338)pos, facing.getFacing()));
    }

    public static class_2846.class_2847 getAction(IDigAction action) {
        if (action.equals((Object)IDigAction.START_DESTROY_BLOCK)) {
            return class_2846.class_2847.field_12968;
        }
        if (action.equals((Object)IDigAction.STOP_DESTROY_BLOCK)) {
            return class_2846.class_2847.field_12973;
        }
        return null;
    }

    public static enum IDigAction {
        START_DESTROY_BLOCK,
        STOP_DESTROY_BLOCK;

    }
}

