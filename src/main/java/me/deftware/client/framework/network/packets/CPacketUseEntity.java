/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket
 */
package me.deftware.client.framework.network.packets;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.mixin.imp.IMixinPlayerInteractEntityC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;

public class CPacketUseEntity
extends PacketWrapper {
    public CPacketUseEntity(class_2596<?> packet) {
        super(packet);
    }

    public static CPacketUseEntity attack(Entity entity) {
        return new CPacketUseEntity((class_2596<?>)class_2824.method_34206((class_1297)entity.getMinecraftEntity(), (boolean)entity.getMinecraftEntity().method_5715()));
    }

    public static CPacketUseEntity interact(Entity entity) {
        return new CPacketUseEntity((class_2596<?>)class_2824.method_34207((class_1297)entity.getMinecraftEntity(), (boolean)entity.getMinecraftEntity().method_5715(), (class_1268)class_1268.field_5808));
    }

    public Type getType() {
        Type type = ((IMixinPlayerInteractEntityC2SPacket)this.packet).getActionType();
        if (type == null) {
            return Type.UNKNOWN;
        }
        return switch (type.ordinal()) {
            case 0 -> Type.ATTACK;
            case 1 -> Type.INTERACT;
            case 2 -> Type.INTERACT_AT;
            default -> Type.UNKNOWN;
        };
    }

    public static enum Type {
        ATTACK,
        INTERACT,
        INTERACT_AT,
        UNKNOWN;

    }
}

