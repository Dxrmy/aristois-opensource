/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1764
 *  net.minecraft.class_1799
 *  org.apache.commons.lang3.mutable.MutableBoolean
 *  org.apache.commons.lang3.mutable.MutableFloat
 *  org.apache.commons.lang3.mutable.MutableInt
 */
package me.deftware.client.framework.item;

import java.util.Collection;
import me.deftware.client.framework.entity.effect.Effect;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.items.ArmorItem;
import me.deftware.client.framework.item.items.AttackItem;
import net.minecraft.class_1764;
import net.minecraft.class_1799;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.apache.commons.lang3.mutable.MutableFloat;
import org.apache.commons.lang3.mutable.MutableInt;

public class ItemUtils {
    public static boolean hasEffect(ItemStack stack, Effect effect) {
        MutableBoolean hasEffect = new MutableBoolean(false);
        stack.effects(appliedEffect -> {
            if (appliedEffect.getEffect() == effect) {
                hasEffect.setTrue();
            }
        });
        return hasEffect.booleanValue();
    }

    public static int getProtection(Collection<ItemStack> equipment) {
        MutableInt amount = new MutableInt();
        equipment.forEach(stack -> {
            stack.enchantments((level, enchantment) -> amount.add(enchantment.getProtection((int)level)));
            Item patt0$temp = stack.getItem();
            if (patt0$temp instanceof ArmorItem) {
                ArmorItem armor = (ArmorItem)patt0$temp;
                amount.add(armor.getDamageReduceAmount());
            }
        });
        return amount.intValue();
    }

    public static float getDamage(ItemStack stack) {
        MutableFloat amount = new MutableFloat();
        stack.enchantments((level, enchantment) -> amount.add(enchantment.getDamage((int)level)));
        Item item = stack.getItem();
        if (item instanceof AttackItem) {
            AttackItem item2 = (AttackItem)item;
            amount.add(item2.getAttackDamage());
        }
        return amount.floatValue();
    }

    public static class Crossbow {
        public static boolean isCharged(ItemStack stack) {
            if (stack.getItem() instanceof class_1764) {
                return class_1764.method_7781((class_1799)((class_1799)stack));
            }
            return false;
        }
    }
}

