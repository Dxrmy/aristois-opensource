/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_5636
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.render;

import me.deftware.client.framework.event.events.EventAnimation;
import me.deftware.client.framework.event.events.EventCameraClip;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.render.camera.GameCamera;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_4184.class})
public class MixinCamera
implements GameCamera {
    @Unique
    private final EventCameraClip eventCameraClip = new EventCameraClip();
    @Unique
    private final EventAnimation eventAnimation = new EventAnimation();

    @Inject(at={@At(value="HEAD")}, cancellable=true, method={"getFocusedEntity"})
    public void getFocusedEntity(CallbackInfoReturnable<class_1297> info) {
        class_310 mc = class_310.method_1551();
        if (CameraEntityMan.isActive()) {
            info.setReturnValue((Object)mc.field_1724);
            info.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, cancellable=true, method={"isThirdPerson"})
    public void isThirdPerson(CallbackInfoReturnable<Boolean> info) {
        if (CameraEntityMan.isActive()) {
            info.setReturnValue((Object)true);
            info.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, cancellable=true, method={"clipToSpace"})
    public void clipToSpace(float camDistance, CallbackInfoReturnable<Float> info) {
        this.eventCameraClip.create(camDistance);
        this.eventCameraClip.broadcast();
        if (this.eventCameraClip.isCanceled()) {
            info.setReturnValue((Object)Float.valueOf((float)this.eventCameraClip.getDistance()));
            info.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, cancellable=true, method={"getSubmersionType"})
    public void getSubmergedFluidState(CallbackInfoReturnable<class_5636> info) {
        this.eventAnimation.create(EventAnimation.AnimationType.Underwater).broadcast();
        if (this.eventAnimation.isCanceled()) {
            info.setReturnValue((Object)class_5636.field_27888);
        }
    }

    @Override
    public Vector3<Double> getCameraPosition() {
        return (Vector3)((class_4184)this).method_19326();
    }

    @Override
    public float _getRotationPitch() {
        return ((class_4184)this).method_19329();
    }

    @Override
    public float _getRotationYaw() {
        return ((class_4184)this).method_19330();
    }

    @Override
    public double _getRenderPosX() {
        return ((class_4184)this).method_19326().field_1352;
    }

    @Override
    public double _getRenderPosY() {
        return ((class_4184)this).method_19326().field_1351;
    }

    @Override
    public double _getRenderPosZ() {
        return ((class_4184)this).method_19326().field_1350;
    }
}

