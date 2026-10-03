/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.registry.Registries
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.entity;

import me.deftware.client.framework.entity.effect.Effect;
import me.deftware.client.framework.message.Message;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_1291.class})
public class MixinEffect
implements Effect {
    @Override
    @Unique
    public Effect.Type getType() {
        return Effect.Type.values()[((class_1291)this).method_18792().ordinal()];
    }

    @Override
    @Unique
    public Message getName() {
        return (Message)((class_1291)this).method_5560();
    }

    @Override
    @Unique
    public String getTranslationKey() {
        return ((class_1291)this).method_5567();
    }

    @Override
    @Unique
    public String getIdentifierKey() {
        return class_7923.field_41174.method_10221((Object)((class_1291)this)).method_12832();
    }
}

