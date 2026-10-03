/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.FishingBobberEntity
 *  net.minecraft.client.MinecraftClient
 */
package me.deftware.client.framework.entity.types.objects;

import java.util.Objects;
import me.deftware.client.framework.entity.Entity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.client.MinecraftClient;

public class EntityFishHook
extends Entity {
    private static class_1536 fishHookPtr;
    private static EntityFishHook fishHook;

    public static boolean hasFish() {
        return Objects.requireNonNull(class_310.method_1551().field_1724).field_7513 != null;
    }

    public static EntityFishHook getInstance() {
        if (fishHook == null || Objects.requireNonNull(class_310.method_1551().field_1724).field_7513 != fishHookPtr) {
            fishHookPtr = Objects.requireNonNull(class_310.method_1551().field_1724).field_7513;
            fishHook = new EntityFishHook((class_1297)fishHookPtr);
        }
        return fishHook;
    }

    public EntityFishHook(class_1297 entity) {
        super(entity);
    }
}

