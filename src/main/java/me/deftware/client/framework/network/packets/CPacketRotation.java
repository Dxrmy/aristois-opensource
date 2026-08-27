/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828$class_2831
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.network.packets.CPacketPlayer;
import net.minecraft.class_2596;
import net.minecraft.class_2828;

public class CPacketRotation
extends CPacketPlayer {
    public CPacketRotation(class_2596<?> packet) {
        super(packet);
    }

    public CPacketRotation(float yaw, float pitch, boolean onGround) {
        super((class_2596<?>)new class_2828.class_2831(yaw, pitch, onGround, false));
    }
}

