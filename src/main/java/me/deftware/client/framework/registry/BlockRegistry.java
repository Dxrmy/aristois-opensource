/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.Registries
 */
package me.deftware.client.framework.registry;

import java.util.stream.Stream;
import me.deftware.client.framework.registry.IRegistry;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.registry.Registries;

public enum BlockRegistry implements IRegistry.IdentifiableRegistry<Block, Void>
{
    INSTANCE;


    @Override
    public Stream<Block> stream() {
        return class_7923.field_41175.method_10220().map(Block.class::cast);
    }
}

