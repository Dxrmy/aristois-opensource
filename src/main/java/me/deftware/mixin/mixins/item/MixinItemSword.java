/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.SwordItem
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.item;

import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.items.AttackItem;
import me.deftware.mixin.mixins.item.MixinItem;
import net.minecraft.item.SwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_1829.class})
public class MixinItemSword
extends MixinItem
implements AttackItem {
    @Override
    @Unique
    public float getAttackDamage() {
        return Item.damage(this);
    }
}

