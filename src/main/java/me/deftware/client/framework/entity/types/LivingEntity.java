/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 */
package me.deftware.client.framework.entity.types;

import java.util.stream.Stream;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.entity.effect.AppliedEffect;
import me.deftware.client.framework.entity.effect.Effect;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.mixin.imp.IMixinEntity;
import me.deftware.mixin.imp.IMixinEntityLivingBase;
import net.minecraft.util.Hand;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class LivingEntity
extends Entity {
    public LivingEntity(class_1297 entity) {
        super(entity);
    }

    public class_1309 getMinecraftEntity() {
        return (class_1309)this.entity;
    }

    public float getHealth() {
        return this.getMinecraftEntity().method_6032();
    }

    public float getHealthPercentage() {
        return this.getHealth() * 100.0f / this.getMaxHealth();
    }

    public float getMaxHealth() {
        return this.getMinecraftEntity().method_6063();
    }

    public void setMovementMultiplier(double multiplier) {
        ((IMixinEntityLivingBase)this.entity).setAirStrafingSpeed((float)multiplier);
    }

    public float getMovementMultiplier() {
        return ((IMixinEntityLivingBase)this.entity).getAirStrafingSpeed();
    }

    public int getHurtTime() {
        return this.getMinecraftEntity().field_6235;
    }

    public boolean isClimbing() {
        return this.getMinecraftEntity().method_6101();
    }

    public float getMoveStrafing() {
        return this.getMinecraftEntity().field_6212;
    }

    public float getMoveForward() {
        return this.getMinecraftEntity().field_6227;
    }

    public void setAlive(boolean flag) {
        ((IMixinEntity)this.getMinecraftEntity()).removeRemovedReason();
        this.getMinecraftEntity().method_6033(20.0f);
        this.getMinecraftEntity().method_30634(this.getPosX(), this.getPosY(), this.getPosZ());
    }

    public ItemStack getEntityHeldItem(EntityHand hand) {
        if (hand == EntityHand.OffHand) {
            return (ItemStack)this.getMinecraftEntity().method_5998(class_1268.field_5810);
        }
        return (ItemStack)this.getMinecraftEntity().method_5998(class_1268.field_5808);
    }

    @Override
    @Deprecated
    public ItemStack getEntityHeldItem(boolean offhand) {
        return this.getEntityHeldItem(offhand ? EntityHand.OffHand : EntityHand.MainHand);
    }

    public AppliedEffect getStatusEffect(Effect effect) {
        return (AppliedEffect)this.getMinecraftEntity().method_6112(effect.getStatusEffect());
    }

    public void removeStatusEffect(Effect effect) {
        this.getMinecraftEntity().method_6016(effect.getStatusEffect());
    }

    public boolean hasStatusEffect(Effect effect) {
        return this.getMinecraftEntity().method_6059(effect.getStatusEffect());
    }

    public void addStatusEffect(AppliedEffect effect) {
        this.getMinecraftEntity().method_6092((class_1293)effect);
    }

    public Stream<AppliedEffect> getStatusEffects() {
        return this.getMinecraftEntity().method_6026().stream().map(AppliedEffect.class::cast);
    }

    public int getActiveStatusEffects() {
        return this.getMinecraftEntity().method_6026().size();
    }
}

