/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffectInstance
 */
package me.deftware.client.framework.entity.effect;

import me.deftware.client.framework.entity.effect.Effect;
import me.deftware.client.framework.message.Message;
import net.minecraft.entity.effect.StatusEffectInstance;

public interface AppliedEffect {
    public Effect getEffect();

    public int getDuration();

    public int getAmplifier();

    public boolean isAmbient();

    public boolean isPermanent();

    public Message getName();

    public Message getDurationText();

    public static AppliedEffect of(Effect effect, int duration, int amplifier) {
        return AppliedEffect.of(effect, duration, amplifier, false, true, true);
    }

    public static AppliedEffect of(Effect effect, int duration, int amplifier, boolean ambient, boolean visible, boolean icon) {
        return (AppliedEffect)new class_1293(effect.getStatusEffect(), duration, amplifier, ambient, visible, icon);
    }
}

