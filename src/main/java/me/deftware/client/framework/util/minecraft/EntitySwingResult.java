/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_239
 *  net.minecraft.class_3966
 */
package me.deftware.client.framework.util.minecraft;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.util.hitresult.CrosshairResult;
import me.deftware.client.framework.world.ClientWorld;
import net.minecraft.class_239;
import net.minecraft.class_3966;

public class EntitySwingResult
extends CrosshairResult {
    public EntitySwingResult(class_239 hitResult) {
        super(hitResult);
    }

    public EntitySwingResult(Entity entity) {
        super((class_239)new class_3966(entity.getMinecraftEntity()));
    }

    public class_3966 getMinecraftHitResult() {
        return (class_3966)this.hitResult;
    }

    public Entity getEntity() {
        return ClientWorld.getClientWorld().getEntityByReference(this.getMinecraftHitResult().method_17782());
    }
}

