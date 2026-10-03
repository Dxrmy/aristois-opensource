/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registries
 */
package me.deftware.client.framework.entity.effect;

import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.Identifiable;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registries;

public interface Effect
extends Identifiable {
    public Type getType();

    public Message getName();

    default public class_6880<class_1291> getStatusEffect() {
        return class_7923.field_41174.method_47983((Object)((class_1291)this));
    }

    public static enum Type {
        BENEFICIAL,
        HARMFUL,
        NEUTRAL;

    }
}

