/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerAbilities
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.entity;

import me.deftware.client.framework.event.events.EventBlockBreakingSpeed;
import me.deftware.client.framework.event.events.EventSneakingCheck;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1657.class})
public class MixinPlayerEntity {
    @Shadow
    @Final
    private class_1656 field_7503;

    @Redirect(method={"adjustMovementForSneaking"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/player/PlayerEntity;clipAtLedge()Z"))
    private boolean sneakingCheck(class_1657 self) {
        if (self == class_310.method_1551().field_1724) {
            EventSneakingCheck event = new EventSneakingCheck(self.method_5715());
            event.broadcast();
            return event.isSneaking();
        }
        return self.method_5715();
    }

    @Inject(method={"getBlockBreakingSpeed"}, at={@At(value="RETURN")}, cancellable=true)
    public void onGetBlockBreakingSpeed(class_2680 block, CallbackInfoReturnable<Float> cir) {
        EventBlockBreakingSpeed event = (EventBlockBreakingSpeed)new EventBlockBreakingSpeed().broadcast();
        cir.setReturnValue((Object)Float.valueOf(((Float)cir.getReturnValue()).floatValue() * event.getMultiplier()));
    }

    @Inject(method={"getEntityInteractionRange"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetEntityReachDistance(CallbackInfoReturnable<Double> cir) {
        GameMap map = GameMap.INSTANCE;
        if (map.contains(GameKeys.BLOCK_REACH_DISTANCE)) {
            float value = ((Float)map.get(GameKeys.BLOCK_REACH_DISTANCE, null)).floatValue();
            cir.setReturnValue((Object)value);
        }
    }
}

