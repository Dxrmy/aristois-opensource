/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EyeOfEnderEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.entity;

import me.deftware.client.framework.event.events.EventStructureLocation;
import me.deftware.client.framework.item.ThrowData;
import net.minecraft.entity.EyeOfEnderEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1672.class})
public class MixinEnderEyeEntity {
    @Unique
    private static ThrowData firstThrow = null;
    @Unique
    private static ThrowData secondThrow = null;

    @Inject(method={"initDataTracker"}, at={@At(value="HEAD")})
    public void onInit(CallbackInfo ci) {
        if (firstThrow != null && secondThrow != null) {
            firstThrow = null;
            secondThrow = null;
        }
    }

    @Inject(method={"initTargetPos"}, at={@At(value="HEAD")})
    public void moveTowards(class_2338 pos, CallbackInfo ci) {
        EventStructureLocation event = new EventStructureLocation(pos.method_10263(), pos.method_10264(), pos.method_10260(), EventStructureLocation.StructureType.Stronghold);
        event.broadcast();
    }

    @Inject(method={"setVelocityClient"}, at={@At(value="TAIL")})
    public void setVelocityClient(double x, double y, double z, CallbackInfo info) {
        class_1672 entity = (class_1672)this;
        if (firstThrow == null) {
            firstThrow = new ThrowData(entity, entity.method_23317(), entity.method_23321(), x, z);
            return;
        }
        if (firstThrow.sameEntity(entity)) {
            firstThrow.addVec(x, z);
            return;
        }
        if (secondThrow == null) {
            secondThrow = new ThrowData(entity, entity.method_23317(), entity.method_23321(), x, z);
            return;
        }
        if (secondThrow.sameEntity(entity)) {
            secondThrow.addVec(x, z);
            return;
        }
    }

    @Inject(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/EyeOfEnderEntity;setPos(DDD)V")})
    public void setPos(CallbackInfo info) {
        class_243 vel = ((class_1672)this).method_18798();
        if (firstThrow != null && secondThrow != null && Math.abs(vel.field_1352 * vel.field_1350) <= 1.0E-7 && Math.abs(vel.field_1351) != 0.0) {
            EventStructureLocation event = new EventStructureLocation(firstThrow.calculateIntersection(secondThrow), EventStructureLocation.StructureType.Stronghold);
            event.broadcast();
        }
    }
}

