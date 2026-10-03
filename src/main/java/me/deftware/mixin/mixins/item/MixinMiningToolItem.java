/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.MiningToolItem
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.item;

import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.items.AttackItem;
import me.deftware.mixin.mixins.item.MixinItem;
import net.minecraft.item.MiningToolItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_1766.class})
public class MixinMiningToolItem
extends MixinItem
implements AttackItem {
    @Override
    @Unique
    public float getAttackDamage() {
        return Item.damage(this);
    }
}

