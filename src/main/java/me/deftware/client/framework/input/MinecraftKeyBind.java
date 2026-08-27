/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3675
 */
package me.deftware.client.framework.input;

import me.deftware.mixin.imp.IMixinKeyBinding;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3675;

public enum MinecraftKeyBind {
    SNEAK(class_310.method_1551().field_1690.field_1832),
    USE_ITEM(class_310.method_1551().field_1690.field_1904),
    JUMP(class_310.method_1551().field_1690.field_1903),
    SPRINT(class_310.method_1551().field_1690.field_1867),
    FORWARD(class_310.method_1551().field_1690.field_1894),
    BACK(class_310.method_1551().field_1690.field_1881),
    LEFT(class_310.method_1551().field_1690.field_1913),
    RIGHT(class_310.method_1551().field_1690.field_1849),
    ATTACK(class_310.method_1551().field_1690.field_1886);

    private final class_304 bind;

    public boolean isHeld() {
        return class_3675.method_15987((long)class_310.method_1551().method_22683().method_4490(), (int)((IMixinKeyBinding)this.bind).getInput().method_1444());
    }

    public boolean isPressed() {
        return this.bind.method_1434();
    }

    public void setPressed(boolean state) {
        this.bind.method_23481(state);
    }

    private MinecraftKeyBind(class_304 bind) {
        this.bind = bind;
    }
}

