/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package me.deftware.client.framework.registry;

import java.util.stream.Stream;
import javax.annotation.Nullable;
import me.deftware.client.framework.item.Itemizable;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.registry.ItemRegistry;

public class RegistryMan {
    @Nullable
    public static Itemizable find(String id) {
        return Stream.concat(ItemRegistry.INSTANCE.stream(), BlockRegistry.INSTANCE.stream()).filter(e -> e.getIdentifierKey().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}

