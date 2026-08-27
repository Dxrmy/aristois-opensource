/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1747
 *  net.minecraft.class_1753
 *  net.minecraft.class_1764
 *  net.minecraft.class_1766
 *  net.minecraft.class_1771
 *  net.minecraft.class_1776
 *  net.minecraft.class_1787
 *  net.minecraft.class_1802
 *  net.minecraft.class_1803
 *  net.minecraft.class_1811
 *  net.minecraft.class_1812
 *  net.minecraft.class_1823
 *  net.minecraft.class_1828
 *  net.minecraft.class_1835
 *  net.minecraft.class_1840
 */
package me.deftware.client.framework.item;

import java.util.function.Predicate;
import me.deftware.client.framework.item.Item;
import net.minecraft.class_1747;
import net.minecraft.class_1753;
import net.minecraft.class_1764;
import net.minecraft.class_1766;
import net.minecraft.class_1771;
import net.minecraft.class_1776;
import net.minecraft.class_1787;
import net.minecraft.class_1802;
import net.minecraft.class_1803;
import net.minecraft.class_1811;
import net.minecraft.class_1812;
import net.minecraft.class_1823;
import net.minecraft.class_1828;
import net.minecraft.class_1835;
import net.minecraft.class_1840;

public enum ItemTypes {
    Tool(item -> item instanceof class_1766),
    SplashPotion(item -> item instanceof class_1828),
    Soup(item -> item == class_1802.field_8515 || item == class_1802.field_8208 || item == class_1802.field_8766),
    WritableBook(item -> item instanceof class_1840),
    Bow(item -> item instanceof class_1753),
    Crossbow(item -> item instanceof class_1764),
    Potion(item -> item instanceof class_1812),
    FishingRod(item -> item instanceof class_1787),
    Trident(item -> item instanceof class_1835),
    ShulkerBox(item -> item instanceof class_1747 && item.getTranslationKey().contains("shulker_box")),
    RangedWeapon(item -> item instanceof class_1811),
    Throwable(item -> item instanceof class_1753 || item instanceof class_1764 || item instanceof class_1823 || item instanceof class_1771 || item instanceof class_1776 || item instanceof class_1828 || item instanceof class_1803 || item instanceof class_1787 || item instanceof class_1835);

    private final Predicate<Item> predicate;

    private ItemTypes(Predicate<Item> predicate) {
        this.predicate = predicate;
    }

    public boolean is(Item block) {
        return this.predicate.test(block);
    }
}

