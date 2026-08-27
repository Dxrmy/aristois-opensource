/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_3944
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.network.PacketWrapper;
import net.minecraft.class_2596;
import net.minecraft.class_3944;

public class SPacketOpenScreen
extends PacketWrapper {
    public SPacketOpenScreen(class_2596<?> packet) {
        super(packet);
    }

    public int getSyncId() {
        return ((class_3944)this.packet).method_17592();
    }
}

