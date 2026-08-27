/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1887
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 */
package me.deftware.client.framework.item;

import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.Identifiable;
import net.minecraft.class_1887;
import net.minecraft.class_5321;
import net.minecraft.class_6880;

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

