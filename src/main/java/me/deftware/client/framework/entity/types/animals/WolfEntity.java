/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1493
 */
package me.deftware.client.framework.entity.types.animals;

import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.OwnedEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1493;

public class WolfEntity
extends OwnedEntity {
    public WolfEntity(class_1297 entity) {
        super(entity);
    }

    public class_1493 getMinecraftEntity() {
        return (class_1493)this.entity;
    }

    public boolean isPlayerOwned(EntityPlayer player) {
        return this.getMinecraftEntity().method_6171((class_1309)player.getMinecraftEntity());
    }

    public String getOwnerName(boolean displayName) {
        class_1309 entity = this.getMinecraftEntity().method_35057();
        if (entity != null) {
            return (displayName ? entity.method_5476() : entity.method_5477()).getString();
        }
        return "";
    }

    public String getEntityName(boolean displayName) {
        return (displayName ? this.getMinecraftEntity().method_5476() : this.getMinecraftEntity().method_5477()).getString();
    }
}

