/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.world.ClientWorld;
import net.minecraft.class_1297;

public class EventAttackEntity
extends Event {
    private final Entity player;
    private final Entity target;

    public EventAttackEntity(class_1297 player, class_1297 target) {
        this.player = ClientWorld.getClientWorld().getEntityByReference(player);
        this.target = ClientWorld.getClientWorld().getEntityByReference(target);
    }

    public Entity getPlayer() {
        return this.player;
    }

    public Entity getTarget() {
        return this.target;
    }
}

