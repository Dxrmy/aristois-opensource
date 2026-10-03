/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.option.SimpleOption
 */
package me.deftware.client.framework.helper;

import me.deftware.client.framework.main.bootstrap.Bootstrap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.SimpleOption;

public class RenderHelper {
    private static class_7172<Boolean> aoMode = null;

    private static boolean getAoMode() {
        return (Boolean)class_310.method_1551().field_1690.method_41792().method_41753();
    }

    private static void setAoMode(boolean mode) {
        class_310.method_1551().field_1690.method_41792().method_41748((Object)mode);
    }

    public static void reloadRenderers() {
        if (aoMode == null) {
            aoMode = class_7172.method_42402((String)"dummyAoMode", (boolean)RenderHelper.getAoMode());
        }
        if (Bootstrap.blockProperties.isActive()) {
            aoMode.method_41748((Object)RenderHelper.getAoMode());
            RenderHelper.setAoMode(false);
        } else {
            RenderHelper.setAoMode((Boolean)aoMode.method_41753());
        }
        class_310.method_1551().field_1769.method_3279();
    }
}

