/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.SweetBerryBushBlock
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.block;

import me.deftware.client.framework.event.events.EventDamage;
import me.deftware.client.framework.event.events.EventSlowdown;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_3830.class})
public class MixinSweetBerryBushBlock {
    @Unique
    private final EventSlowdown slowdown = new EventSlowdown();

    @Redirect(method={"onEntityCollision"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;slowMovement(Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/Vec3d;)V"))
    private void onSlowMovement(class_1297 entity, class_2680 state, class_243 multiplier) {
        this.slowdown.create(EventSlowdown.SlowdownType.BerryBush, 1.0f);
        this.slowdown.broadcast();
        if (!this.slowdown.isCanceled()) {
            entity.method_5844(state, multiplier);
        }
    }

    @Inject(method={"onEntityCollision"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z")}, cancellable=true)
    private void onDamage(class_2680 state, class_1937 world, class_2338 pos, class_1297 entity, CallbackInfo ci) {
        EventDamage eventDamage = new EventDamage(EventDamage.DamageSource.BerryBush);
        eventDamage.broadcast();
        if (eventDamage.isCanceled()) {
            ci.cancel();
        }
    }
}

