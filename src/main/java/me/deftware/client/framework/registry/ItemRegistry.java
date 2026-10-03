/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.Registries
 */
package me.deftware.client.framework.registry;

import java.util.stream.Stream;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.registry.IRegistry;
import net.minecraft.registry.Registries;

public enum ItemRegistry implements IRegistry.IdentifiableRegistry<Item, Void>
{
    INSTANCE;


    @Override
    public Stream<Item> stream() {
        return class_7923.field_41178.method_10220().map(Item.class::cast);
    }
}

