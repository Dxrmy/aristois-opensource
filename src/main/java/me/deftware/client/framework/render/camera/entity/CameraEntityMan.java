/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 *  net.minecraft.class_5498
 *  net.minecraft.class_743
 */
package me.deftware.client.framework.render.camera.entity;

import java.util.Objects;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.render.camera.entity.CameraEntity;
import me.deftware.client.framework.render.camera.entity.DummyInput;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_5498;
import net.minecraft.class_743;

public class CameraEntityMan {
    public static float speed = 0.25f;
    public static CameraEntity fakePlayer;
    private static class_5498 savedPerspective;

    public static boolean isActive() {
        return fakePlayer != null;
    }

    public static void enable() {
        fakePlayer = new CameraEntity(Objects.requireNonNull(class_310.method_1551().field_1687), Objects.requireNonNull(class_310.method_1551().field_1724).method_7334(), Objects.requireNonNull(class_310.method_1551().field_1724).method_7344());
        fakePlayer.method_5719((class_1297)Objects.requireNonNull(class_310.method_1551().field_1724));
        fakePlayer.method_5847(Objects.requireNonNull(class_310.method_1551().field_1724).field_6241);
        fakePlayer.spawn();
        savedPerspective = Objects.requireNonNull(class_310.method_1551().field_1690).method_31044();
        Objects.requireNonNull(class_310.method_1551().field_1690).method_31043(class_5498.field_26664);
        class_310.method_1551().method_1504((class_1297)fakePlayer);
        if (class_310.method_1551().field_1724.field_3913 instanceof class_743) {
            class_310.method_1551().field_1724.field_3913 = new DummyInput();
        }
    }

    public static boolean isCameraEntity(Entity entity) {
        return entity.getMinecraftEntity() == fakePlayer;
    }

    public static void disable() {
        class_310.method_1551().field_1690.method_31043(savedPerspective);
        class_310.method_1551().method_1504((class_1297)Objects.requireNonNull(class_310.method_1551().field_1724));
        if (fakePlayer != null) {
            fakePlayer.despawn();
        }
        fakePlayer = null;
        if (class_310.method_1551().field_1724.field_3913 instanceof DummyInput) {
            class_310.method_1551().field_1724.field_3913 = new class_743(class_310.method_1551().field_1690);
        }
    }
}

