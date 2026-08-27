/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_4174
 *  net.minecraft.class_7923
 *  net.minecraft.class_9334
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.item;

import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_1792;
import net.minecraft.class_4174;
import net.minecraft.class_7923;
import net.minecraft.class_9334;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_1792.class})
public class MixinItem
implements Item {
    @Override
    @Unique
    public int getID() {
        return class_1792.method_7880((class_1792)((class_1792)this));
    }

    @Override
    @Unique
    public Message getName() {
        return (Message)((class_1792)this).method_63680();
    }

    @Unique
    private class_4174 foodComponent() {
        return (class_4174)((class_1792)this).method_57347().method_57829(class_9334.field_50075);
    }

    @Override
    @Unique
    public boolean isFood() {
        return this.foodComponent() != null;
    }

    @Override
    @Unique
    public int getHunger() {
        return this.foodComponent().comp_2491();
    }

    @Override
    @Unique
    public float getSaturation() {
        return this.foodComponent().comp_2492();
    }

    @Override
    @Unique
    public String getTranslationKey() {
        return ((class_1792)this).method_7876();
    }

    @Override
    @Unique
    public String getIdentifierKey() {
        return class_7923.field_41178.method_10221((Object)((class_1792)this)).method_12832();
    }

    @Override
    @Unique
    public Item getItem() {
        return this;
    }
}

