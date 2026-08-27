/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 */
package me.deftware.client.framework.registry;

import java.util.HashMap;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.EntityCapsule;
import me.deftware.client.framework.registry.IRegistry;
import net.minecraft.class_1297;
import net.minecraft.class_1299;

public enum EntityRegistry implements IRegistry.IdentifiableRegistry<EntityCapsule, class_1299<? extends class_1297>>
{
    INSTANCE;

    private final HashMap<String, EntityCapsule> entities = new HashMap();

    @Override
    public Stream<EntityCapsule> stream() {
        return this.entities.values().stream();
    }

    @Override
    public void register(String id, class_1299<? extends class_1297> object) {
        this.entities.putIfAbsent(id, new EntityCapsule(id, object));
    }
}

