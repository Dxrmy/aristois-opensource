/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import net.minecraft.util.Hand;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;

public class CPacketPlayerUseBlock
extends PacketWrapper {
    public CPacketPlayerUseBlock(class_2596<?> packet) {
        super(packet);
    }

    public CPacketPlayerUseBlock(BlockSwingResult swingResult) {
        this((class_2596<?>)new class_2885(class_1268.field_5808, swingResult.getMinecraftHitResult(), 0));
    }
}

