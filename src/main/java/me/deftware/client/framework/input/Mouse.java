/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.glfw.GLFW
 */
package me.deftware.client.framework.input;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;

public class Mouse {
    public static double mouseX = 0.0;
    public static double mouseY = 0.0;
    private static final DoubleBuffer posX = BufferUtils.createDoubleBuffer((int)1);
    private static final DoubleBuffer posY = BufferUtils.createDoubleBuffer((int)1);
    private static final ArrayList<BiConsumer<Double, Double>> scrollCallbacks = new ArrayList();

    public static void clickMouse(int button) {
        if (button == 0) {
            Minecraft.getMinecraftGame().doClickMouse();
        } else if (button == 1) {
            Minecraft.getMinecraftGame().doRightClickMouse();
        } else if (button == 2) {
            Minecraft.getMinecraftGame().doMiddleClickMouse();
        }
    }

    public static boolean isButtonDown(int button) {
        return GLFW.glfwGetMouseButton((long)class_310.method_1551().method_22683().method_4490(), (int)button) == 1;
    }

    public static double getMouseX() {
        return mouseX / (double)RenderStack.getScale();
    }

    public static double getMouseY() {
        return mouseY / (double)RenderStack.getScale();
    }

    public static void registerScrollHook(BiConsumer<Double, Double> cb) {
        scrollCallbacks.add(cb);
    }

    public static void onScroll(double x, double y) {
        scrollCallbacks.forEach((Consumer<BiConsumer<Double, Double>>)((Consumer<BiConsumer>)cb -> cb.accept(x, y)));
    }

    public static void updateMousePosition() {
        GLFW.glfwGetCursorPos((long)WindowHelper.getWindowHandle(), (DoubleBuffer)posX, (DoubleBuffer)posY);
        mouseX = posX.get();
        mouseY = posY.get();
        posX.clear();
        posY.clear();
    }
}

