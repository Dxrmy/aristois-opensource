/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.registry.Registry
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.DynamicRegistryManager
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.RegistryWrapper$Impl
 *  net.minecraft.registry.RegistryEntryLookup
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.component.ComponentType
 *  net.minecraft.enchantment.effect.EnchantmentEffectEntry
 *  net.minecraft.component.EnchantmentEffectComponentTypes
 *  net.minecraft.enchantment.effect.EnchantmentValueEffect
 */
package me.deftware.client.framework.registry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import me.deftware.client.framework.item.Enchantment;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.IRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.component.ComponentType;
import net.minecraft.enchantment.effect.EnchantmentEffectEntry;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.enchantment.effect.EnchantmentValueEffect;

public enum EnchantmentRegistry implements IRegistry.IdentifiableRegistry<Enchantment, Void>
{
    INSTANCE;

    private class_7225.class_7226<class_1887> registry;
    private final Map<class_5321<class_1887>, Enchantment> enchantmentMap = new HashMap<class_5321<class_1887>, Enchantment>();

    private void sync() {
        class_638 world = class_310.method_1551().field_1687;
        if (world == null) {
            throw new IllegalStateException("Enchantments cannot be used when not in a world");
        }
        class_5455 registry = world.method_30349();
        class_2378 enchantments = registry.method_30530(class_7924.field_41265);
        if (this.registry != enchantments) {
            this.registry = enchantments;
            this.enchantmentMap.clear();
        }
    }

    @Override
    public Stream<Enchantment> stream() {
        this.sync();
        return this.registry.method_46754().map(key -> this.lookup((class_5321<class_1887>)key, false));
    }

    public synchronized Enchantment lookup(class_5321<class_1887> entry, boolean sync) {
        if (sync) {
            this.sync();
        }
        return this.enchantmentMap.computeIfAbsent(entry, key -> new EnchantmentImpl((class_5321<class_1887>)key, (class_7871<class_1887>)this.registry));
    }

    private static class EnchantmentImpl
    implements Enchantment {
        private final class_6880<class_1887> entry;
        private final class_5321<class_1887> key;
        private final class_1887 enchantment;

        public EnchantmentImpl(class_5321<class_1887> key, class_7871<class_1887> lookup) {
            this.key = key;
            this.entry = lookup.method_46747(key);
            this.enchantment = (class_1887)this.entry.comp_349();
        }

        @Override
        public class_5321<class_1887> getKey() {
            return this.key;
        }

        @Override
        public class_6880<class_1887> getEntry() {
            return this.entry;
        }

        @Override
        public int getMinLevel() {
            return this.enchantment.method_8187();
        }

        @Override
        public int getMaxLevel() {
            return this.enchantment.method_8183();
        }

        private float sumValue(int level, class_9331<List<class_9698<class_9723>>> type) {
            float sum = 0.0f;
            List list = this.enchantment.method_60034(type);
            for (class_9698 value : list) {
                sum += ((class_9723)value.comp_2680()).method_60213(level, null, 0.0f);
            }
            return sum;
        }

        @Override
        public int getProtection(int level) {
            return (int)this.sumValue(level, (class_9331<List<class_9698<class_9723>>>)class_9701.field_51659);
        }

        @Override
        public float getDamage(int level) {
            return this.sumValue(level, (class_9331<List<class_9698<class_9723>>>)class_9701.field_51661);
        }

        @Override
        public Message getName(int level) {
            return (Message)class_1887.method_8179(this.entry, (int)level);
        }

        @Override
        public String getTranslationKey() {
            return this.key.method_29177().method_42094();
        }

        @Override
        public String getIdentifierKey() {
            return this.key.method_29177().method_12832();
        }
    }
}

