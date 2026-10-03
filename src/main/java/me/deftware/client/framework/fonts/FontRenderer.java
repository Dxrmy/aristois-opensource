/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.text.StringVisitable
 */
package me.deftware.client.framework.fonts;

import java.util.Objects;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.text.StringVisitable;

public class FontRenderer {
    public static void drawString(GLX context, Message text, int x, int y, int color) {
        context.getContext().method_51439(FontRenderer.getTextRenderer(), (class_2561)text, x, y, color, false);
    }

    public static void drawCenteredString(GLX context, Message text, int x, int y, int color) {
        context.getContext().method_27535(FontRenderer.getTextRenderer(), (class_2561)text, x - FontRenderer.getTextRenderer().method_27525((class_5348)((class_2561)text)) / 2, y, color);
    }

    public static void drawStringWithShadow(GLX context, Message text, int x, int y, int color) {
        context.getContext().method_27535(FontRenderer.getTextRenderer(), (class_2561)text, x, y, color);
    }

    public static int getFontHeight() {
        Objects.requireNonNull(class_310.method_1551().field_1772);
        return 9;
    }

    public static int getStringWidth(Message string) {
        return class_310.method_1551().field_1772.method_27525((class_5348)((class_2561)string));
    }

    public static int getStringWidth(String string) {
        return class_310.method_1551().field_1772.method_1727(string);
    }

    private static class_327 getTextRenderer() {
        return class_310.method_1551().field_1772;
    }
}

