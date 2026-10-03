/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffectUtil
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.client.MinecraftClient
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.entity;

import me.deftware.client.framework.entity.effect.AppliedEffect;
import me.deftware.client.framework.entity.effect.Effect;
import me.deftware.client.framework.message.Message;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_1293.class})
public class MixinAppliedEffect
implements AppliedEffect {
    @Override
    @Unique
    public Effect getEffect() {
        return (Effect)((class_1293)this).method_5579().comp_349();
    }

    @Override
    @Unique
    public int getDuration() {
        return ((class_1293)this).method_5584();
    }

    @Override
    @Unique
    public int getAmplifier() {
        return ((class_1293)this).method_5584();
    }

    @Override
    @Unique
    public boolean isAmbient() {
        return ((class_1293)this).method_5591();
    }

    @Override
    @Unique
    public boolean isPermanent() {
        return ((class_1293)this).method_48559();
    }

    @Override
    @Unique
    public Message getName() {
        Message name = this.getEffect().getName().copy();
        int amplifier = this.getAmplifier();
        if (amplifier >= 1 && amplifier <= 9) {
            Message level = Message.translated("enchantment.level." + (amplifier + 1), new Object[0]);
            name = name.append(Message.SPACE).append(level);
        }
        return name;
    }

    @Override
    @Unique
    public Message getDurationText() {
        if (this.isPermanent()) {
            return Message.of("Infinite");
        }
        class_310 mc = class_310.method_1551();
        float tickRate = 20.0f;
        if (mc.field_1687 != null) {
            tickRate = mc.field_1687.method_54719().method_54748();
        }
        return (Message)class_1292.method_5577((class_1293)((class_1293)this), (float)1.0f, (float)tickRate);
    }
}

