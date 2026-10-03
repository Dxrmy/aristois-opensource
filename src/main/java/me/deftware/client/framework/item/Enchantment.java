/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryEntry
 */
package me.deftware.client.framework.item;

import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.Identifiable;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

public interface Enchantment
extends Identifiable {
    public int getMinLevel();

    public int getMaxLevel();

    public int getProtection(int var1);

    public float getDamage(int var1);

    public Message getName(int var1);

    public class_5321<class_1887> getKey();

    public class_6880<class_1887> getEntry();
}

