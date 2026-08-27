/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_2596
 *  net.minecraft.class_2885
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import net.minecraft.class_1268;
import net.minecraft.class_2596;
import net.minecraft.class_2885;

public class CPacketPlayerUseBlock
extends PacketWrapper {
    public CPacketPlayerUseBlock(class_2596<?> packet) {
        super(packet);
    }

    public CPacketPlayerUseBlock(BlockSwingResult swingResult) {
        this((class_2596<?>)new class_2885(class_1268.field_5808, swingResult.getMinecraftHitResult(), 0));
    }
}

