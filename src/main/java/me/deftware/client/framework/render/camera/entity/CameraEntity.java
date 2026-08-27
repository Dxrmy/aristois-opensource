/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1702
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_743
 *  net.minecraft.class_744
 *  net.minecraft.class_745
 */
package me.deftware.client.framework.render.camera.entity;

import com.mojang.authlib.GameProfile;
import java.util.Objects;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;
import net.minecraft.class_1297;
import net.minecraft.class_1702;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_743;
import net.minecraft.class_744;
import net.minecraft.class_745;

public class CameraEntity
extends class_745 {
    public class_744 input;

    public CameraEntity(class_638 clientWorld, GameProfile gameProfile, class_1702 hunger) {
        super(clientWorld, gameProfile);
        this.field_7493 = hunger;
        class_310 mc = class_310.method_1551();
        this.input = new class_743(mc.field_1690);
    }

    public boolean method_5727(double cameraX, double cameraY, double cameraZ) {
        return false;
    }

    public boolean method_5640(double distance) {
        return false;
    }

    public boolean method_5733() {
        return false;
    }

    public void method_6007() {
        this.method_18800(0.0, 0.0, 0.0);
        this.input.method_3129();
        boolean sneaking = this.input.field_54155.comp_3164();
        boolean jumping = this.input.field_54155.comp_3163();
        float upDown = (sneaking ? -CameraEntityMan.speed : 0.0f) + (jumping ? CameraEntityMan.speed : 0.0f);
        class_243 forward = new class_243(0.0, 0.0, (double)CameraEntityMan.speed * 2.5).method_1024(-((float)Math.toRadians(this.field_6241)));
        class_243 strafe = forward.method_1024((float)Math.toRadians(90.0));
        class_243 motion = this.method_18798();
        motion = motion.method_1031(0.0, (double)(2.0f * upDown), 0.0);
        motion = motion.method_1031(strafe.field_1352 * (double)this.input.field_3907, 0.0, strafe.field_1350 * (double)this.input.field_3907);
        motion = motion.method_1031(forward.field_1352 * (double)this.input.field_3905, 0.0, forward.field_1350 * (double)this.input.field_3905);
        this.method_23327(this.method_23317() + motion.field_1352, this.method_23318() + motion.field_1351, this.method_23321() + motion.field_1350);
    }

    public void spawn() {
        class_310 mc = class_310.method_1551();
        Objects.requireNonNull(mc.field_1687).method_53875((class_1297)this);
    }

    public void despawn() {
        class_310 mc = class_310.method_1551();
        Objects.requireNonNull(mc.field_1687).method_2945(this.method_5628(), class_1297.class_5529.field_26999);
    }
}

