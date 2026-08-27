/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_7923
 */
package me.deftware.client.framework.registry;

import java.util.stream.Stream;
import me.deftware.client.framework.entity.effect.Effect;
import me.deftware.client.framework.registry.IRegistry;
import net.minecraft.class_7923;

public enum StatusEffectRegistry implements IRegistry.IdentifiableRegistry<Effect, Void>
{
    INSTANCE;


    @Override
    public Stream<Effect> stream() {
        return class_7923.field_41174.method_10220().map(Effect.class::cast);
    }
}

