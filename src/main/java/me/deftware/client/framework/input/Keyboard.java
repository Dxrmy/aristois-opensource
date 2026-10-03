/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Util
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.gui.screen.Screen
 *  org.lwjgl.glfw.GLFW
 */
package me.deftware.client.framework.input;

import java.lang.reflect.Field;
import java.util.HashMap;
import net.minecraft.util.Util;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;

public class Keyboard {
    public static HashMap<Integer, String> normalKeys = new HashMap();
    public static HashMap<Integer, String> functionKeys = new HashMap();
    public static HashMap<Integer, String> mouseButtons = new HashMap();

    public static void populateCodePoints() {
        for (Field field : GLFW.class.getDeclaredFields()) {
            try {
                if (field.getType() != Integer.TYPE) continue;
                String name = field.getName();
                int codePoint = field.getInt(null);
                if (name.startsWith("GLFW_KEY_")) {
                    if (codePoint >= 32 && codePoint <= 162) {
                        normalKeys.put(codePoint, name.substring("GLFW_KEY_".length()));
                        continue;
                    }
                    if (codePoint < 256 || codePoint > 348) continue;
                    functionKeys.put(codePoint, name.substring("GLFW_KEY_".length()));
                    continue;
                }
                if (!name.startsWith("GLFW_MOUSE_")) continue;
                mouseButtons.put(codePoint, name.substring("GLFW_MOUSE_".length()));
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getKeyName(int glfwCodePoint) {
        int scanCode = GLFW.glfwGetKeyScancode((int)glfwCodePoint);
        return Keyboard.getKeyName(glfwCodePoint, scanCode);
    }

    public static String getKeyName(int codePoint, int scanCode) {
        String name = GLFW.glfwGetKeyName((int)codePoint, (int)scanCode);
        if (name == null) {
            return normalKeys.getOrDefault(codePoint, functionKeys.getOrDefault(codePoint, "Unknown"));
        }
        return name;
    }

    public static String getClipboardString() {
        return class_310.method_1551().field_1774.method_1460();
    }

    public static void setClipboardString(String copyText) {
        class_310.method_1551().field_1774.method_1455(copyText);
    }

    public static boolean isKeyDown(int key) {
        if (key <= 2) {
            return false;
        }
        return class_3675.method_15987((long)class_310.method_1551().method_22683().method_4490(), (int)key);
    }

    public static void openLink(String url) {
        class_156.method_668().method_670(url);
    }

    public static boolean isCtrlPressed() {
        return class_437.method_25441();
    }

    public static boolean isShiftPressed() {
        return class_437.method_25442();
    }
}

