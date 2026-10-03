/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 */
package me.deftware.client.framework.entity;

import net.minecraft.util.Hand;

public enum EntityHand {
    MainHand,
    OffHand,
    None;


    public class_1268 getMinecraftHand() {
        if (this == None) {
            throw new IllegalStateException("Cannot convert " + this.name() + " to Minecraft hand");
        }
        return class_1268.values()[this.ordinal()];
    }

    public static EntityHand of(class_1268 hand) {
        return EntityHand.values()[hand.ordinal()];
    }
}

