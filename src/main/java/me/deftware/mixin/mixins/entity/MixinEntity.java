/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2784
 *  net.minecraft.class_310
 *  net.minecraft.class_9787
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.entity;

import java.util.UUID;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.event.events.EventEntityPush;
import me.deftware.client.framework.event.events.EventFluidVelocity;
import me.deftware.client.framework.event.events.EventKnockback;
import me.deftware.client.framework.event.events.EventSlowdown;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.mixin.imp.IMixinEntity;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2784;
import net.minecraft.class_310;
import net.minecraft.class_9787;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1297.class})
public abstract class MixinEntity
implements IMixinEntity {
    @Shadow
    public boolean field_5960;
    @Shadow
    protected class_243 field_17046;
    @Shadow
    private boolean field_5958;
    @Shadow
    @Nullable
    public class_9787 field_51994;
    @Unique
    private final EventSlowdown slowdown = new EventSlowdown();

    @Shadow
    public abstract boolean method_5715();

    @Shadow
    public abstract boolean method_5624();

    @Shadow
    protected abstract boolean method_5795(int var1);

    @Shadow
    protected abstract void method_31482();

    @Shadow
    public abstract float method_36454();

    @Shadow
    public abstract float method_36455();

    @Shadow
    public abstract UUID method_5667();

    @Inject(method={"changeLookDirection"}, at={@At(value="HEAD")}, cancellable=true)
    public void changeLookDirection(double cursorX, double cursorY, CallbackInfo ci) {
        if (this == class_310.method_1551().field_1724 && CameraEntityMan.isActive()) {
            CameraEntityMan.fakePlayer.method_5872(cursorX, cursorY);
            CameraEntityMan.fakePlayer.method_5847(CameraEntityMan.fakePlayer.method_36454());
            ci.cancel();
        }
    }

    @Redirect(method={"updateMovementInFluid"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;setVelocity(Lnet/minecraft/util/math/Vec3d;)V", opcode=182))
    private void applyFluidVelocity(class_1297 entity, class_243 velocity) {
        if (entity == class_310.method_1551().field_1724) {
            EventFluidVelocity event = (EventFluidVelocity)new EventFluidVelocity((Vector3)velocity).broadcast();
            if (!event.isCanceled()) {
                entity.method_18799((class_243)event.getVector3d());
            }
        } else {
            entity.method_18799(velocity);
        }
    }

    @Inject(method={"pushAwayFrom"}, at={@At(value="HEAD")}, cancellable=true)
    public void pushAwayFrom(class_1297 entity, CallbackInfo info) {
        if (this == class_310.method_1551().field_1724 && ((Event)new EventEntityPush((Entity)ClientWorld.getClientWorld().getEntityByReference(entity)).broadcast()).isCanceled()) {
            info.cancel();
        }
    }

    @Redirect(method={"move"}, at=@At(value="FIELD", target="Lnet/minecraft/entity/Entity;noClip:Z", opcode=180))
    private boolean noClipCheck(class_1297 self) {
        boolean noClipCheck = GameMap.INSTANCE.get(GameKeys.NOCLIP, false);
        if (self == class_310.method_1551().field_1724) {
            return this.field_5960 || noClipCheck;
        }
        return self.field_5960;
    }

    @Inject(method={"slowMovement"}, at={@At(value="TAIL")}, cancellable=true)
    private void onSlowMovement(class_2680 state, class_243 multiplier, CallbackInfo ci) {
        if (this == class_310.method_1551().field_1724) {
            this.slowdown.create(EventSlowdown.SlowdownType.Web, 1.0f);
            this.slowdown.broadcast();
            if (this.slowdown.isCanceled()) {
                class_243 cobSlowness = new class_243(0.25, (double)0.05f, 0.25);
                if (multiplier.field_1352 == cobSlowness.field_1352 && multiplier.field_1351 == cobSlowness.field_1351 && multiplier.field_1350 == cobSlowness.field_1350) {
                    this.field_17046 = class_243.field_1353;
                    ci.cancel();
                }
            }
        }
    }

    @Inject(method={"setVelocityClient"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSetVelocityClient(double x, double y, double z, CallbackInfo ci) {
        class_1297 entity = (class_1297)this;
        if (entity == class_310.method_1551().field_1724) {
            EventKnockback event = (EventKnockback)new EventKnockback(x, y, z).broadcast();
            if (!event.isCanceled()) {
                entity.method_18800(event.getX(), event.getY(), event.getZ());
            }
            ci.cancel();
        }
    }

    @Redirect(method={"findCollisionsForMovement"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/border/WorldBorder;canCollide(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/Box;)Z"))
    private static boolean onCollision$WorldBorder(class_2784 instance, class_1297 entity, class_238 box) {
        if (GameMap.INSTANCE.get(GameKeys.IGNORE_WORLD_BORDER, false).booleanValue()) {
            return false;
        }
        return instance.method_39459(entity, box);
    }

    @Inject(method={"isGlowing"}, at={@At(value="HEAD")}, cancellable=true)
    private void isGlowing(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue((Object)this.field_5958);
    }

    @Override
    public boolean getAFlag(int id) {
        return this.method_5795(id);
    }

    @Override
    public void setInPortal(boolean inPortal) {
        this.field_51994.method_60705(inPortal);
    }

    @Override
    public void removeRemovedReason() {
        this.method_31482();
    }
}

