/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.class_1297
 *  net.minecraft.class_2487
 */
package me.deftware.client.framework.entity.types;

import java.util.UUID;
import javax.annotation.Nullable;
import me.deftware.client.framework.entity.types.LivingEntity;
import net.minecraft.class_1297;
import net.minecraft.class_2487;

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

