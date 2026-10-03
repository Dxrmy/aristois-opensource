/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.registry.entry.RegistryEntry
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Constant
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyConstant
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.entity;

import java.util.Map;
import me.deftware.client.framework.event.events.EventIsPotionActive;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.mixin.imp.IMixinEntityLivingBase;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1309.class})
public class MixinEntityLivingBase
implements IMixinEntityLivingBase {
    @Shadow
    @Final
    private Map<class_1291, class_1293> field_6280;
    @Shadow
    protected int field_6222;
    @Unique
    private float height = -1.0f;
    private float airStrafingSpeed = 0.02f;

    @Inject(method={"hasStatusEffect"}, at={@At(value="TAIL")}, cancellable=true)
    private void onHasStatusEffect(class_6880<class_1291> effect, CallbackInfoReturnable<Boolean> cir) {
        if (((class_1309)this).method_31747()) {
            EventIsPotionActive event = (EventIsPotionActive)new EventIsPotionActive(((class_1291)effect.comp_349()).method_5567(), this.field_6280.containsKey(effect)).broadcast();
            cir.setReturnValue((Object)event.isActive());
        }
    }

    @Inject(method={"getJumpVelocity"}, at={@At(value="TAIL")}, cancellable=true)
    private void onGetJumpVelocity(CallbackInfoReturnable<Float> cir) {
        if (((class_1309)this).method_31747()) {
            cir.setReturnValue((Object)GameMap.INSTANCE.get(GameKeys.JUMP_HEIGHT, (Float)cir.getReturnValue()));
        }
    }

    @Override
    public int getActiveItemStackUseCount() {
        return this.field_6222;
    }

    @Redirect(method={"travel"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/LivingEntity;hasStatusEffect(Lnet/minecraft/registry/entry/RegistryEntry;)Z"))
    private boolean travelHasStatusEffectProxy(class_1309 self, class_6880<class_1291> statusEffect) {
        if (statusEffect == class_1294.field_5902 && !GameMap.INSTANCE.get(GameKeys.LEVITATION, true).booleanValue() && ((class_1309)this).method_31747()) {
            return false;
        }
        return self.method_6059(statusEffect);
    }

    @Redirect(method={"travel"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/LivingEntity;getFinalGravity()D"))
    private double travelHasNoGravityProxy(class_1309 self) {
        if (self.method_6059(class_1294.field_5902) && !GameMap.INSTANCE.get(GameKeys.LEVITATION, true).booleanValue() && ((class_1309)this).method_31747()) {
            return 0.0;
        }
        return self.method_56989();
    }

    @Override
    @Unique
    public void _setStepHeight(float height) {
        this.height = height;
    }

    @Inject(method={"getStepHeight"}, at={@At(value="HEAD")}, cancellable=true)
    private void onStepHeightRedirect(CallbackInfoReturnable<Float> cir) {
        if (this.height > 0.0f) {
            cir.setReturnValue((Object)Float.valueOf(this.height));
        }
    }

    @ModifyConstant(method={"getOffGroundSpeed"}, constant={@Constant(floatValue=0.02f)})
    private float getAirStrafeSpeed(float constant) {
        return this.airStrafingSpeed;
    }

    @Override
    @Unique
    public float getAirStrafingSpeed() {
        return this.airStrafingSpeed;
    }

    @Override
    @Unique
    public void setAirStrafingSpeed(float value) {
        this.airStrafingSpeed = value;
    }
}

