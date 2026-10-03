/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.BowItem
 *  net.minecraft.item.CrossbowItem
 *  net.minecraft.item.MiningToolItem
 *  net.minecraft.item.EggItem
 *  net.minecraft.item.EnderPearlItem
 *  net.minecraft.item.FishingRodItem
 *  net.minecraft.item.Items
 *  net.minecraft.item.LingeringPotionItem
 *  net.minecraft.item.RangedWeaponItem
 *  net.minecraft.item.PotionItem
 *  net.minecraft.item.SnowballItem
 *  net.minecraft.item.SplashPotionItem
 *  net.minecraft.item.TridentItem
 *  net.minecraft.item.WritableBookItem
 */
package me.deftware.client.framework.item;

import java.util.function.Predicate;
import me.deftware.client.framework.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.EggItem;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Items;
import net.minecraft.item.LingeringPotionItem;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.PotionItem;
import net.minecraft.item.SnowballItem;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.item.TridentItem;
import net.minecraft.item.WritableBookItem;

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

