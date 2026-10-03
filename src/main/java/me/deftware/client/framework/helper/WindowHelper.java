/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 */
package me.deftware.client.framework.helper;

import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.shader.Shader;
import me.deftware.mixin.imp.IMixinEntityRenderer;
import net.minecraft.client.MinecraftClient;

public class WindowHelper {
    public static long getWindowHandle() {
        return class_310.method_1551().method_22683().method_4490();
    }

    public static boolean isFocused() {
        return class_310.method_1551().method_1569();
    }

    public static boolean isMinimized() {
        return GuiScreen.getDisplayHeight() == 0 && GuiScreen.getDisplayWidth() == 0;
    }

    public static int getFPS() {
        return Minecraft.getMinecraftGame().getFPS();
    }

    public static void loadShader(Shader shader) {
        ((IMixinEntityRenderer)class_310.method_1551().field_1773).loadShader(shader);
    }

    public static void disableShader() {
        ((IMixinEntityRenderer)class_310.method_1551().field_1773).loadShader(null);
    }
}

