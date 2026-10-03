/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.OtherClientPlayerEntity
 */
package me.deftware.client.framework.entity.types.objects;

import java.util.Objects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;

public class ClonedPlayerMP
extends class_745 {
    public ClonedPlayerMP(class_1657 entity) {
        super(Objects.requireNonNull(class_310.method_1551().field_1687), entity.method_7334());
        this.clonePlayer(entity, true);
        this.method_5808(entity.method_23317(), entity.method_23318(), entity.method_23321(), entity.method_36454(), entity.method_36455());
        this.field_6241 = entity.field_6241;
    }

    public void clonePlayer(class_1657 oldPlayer, boolean respawnFromEnd) {
        if (respawnFromEnd) {
            this.method_31548().method_7377(oldPlayer.method_31548());
            this.method_6033(oldPlayer.method_6032());
            this.field_7493 = oldPlayer.method_7344();
            this.field_7520 = oldPlayer.field_7520;
            this.field_7510 = oldPlayer.field_7510;
            this.field_7495 = oldPlayer.field_7495;
            this.method_7320(oldPlayer.method_7272());
            this.method_5878((class_1297)oldPlayer);
        } else if (oldPlayer.method_7325()) {
            this.method_31548().method_7377(oldPlayer.method_31548());
            this.field_7520 = oldPlayer.field_7520;
            this.field_7510 = oldPlayer.field_7510;
            this.field_7495 = oldPlayer.field_7495;
            this.method_7320(oldPlayer.method_7272());
        }
        this.field_7494 = oldPlayer.method_7278();
        if (this.method_5841() != null) {
            this.method_5841().method_12778(class_1657.field_7518, (Object)((Byte)oldPlayer.method_5841().method_12789(class_1657.field_7518)));
        }
    }
}

