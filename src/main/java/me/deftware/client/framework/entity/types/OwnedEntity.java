/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.nbt.NbtCompound
 */
package me.deftware.client.framework.entity.types;

import java.util.UUID;
import javax.annotation.Nullable;
import me.deftware.client.framework.entity.types.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;

public class OwnedEntity
extends LivingEntity {
    public OwnedEntity(class_1297 entity) {
        super(entity);
    }

    @Nullable
    public UUID getOwnerUUID() {
        return this.entity.method_5647(new class_2487()).method_25926("Owner");
    }
}

