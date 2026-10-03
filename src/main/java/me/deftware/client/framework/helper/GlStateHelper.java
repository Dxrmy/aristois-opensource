/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.render.DiffuseLighting
 */
package me.deftware.client.framework.helper;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.DiffuseLighting;

public class GlStateHelper {
    public static void disableAlpha() {
    }

    public static void enableAlpha() {
    }

    public static void enablePolygonOffset() {
        RenderSystem.enablePolygonOffset();
    }

    public static void enableDepth() {
        RenderSystem.enableDepthTest();
    }

    public static void disableDepth() {
        RenderSystem.disableDepthTest();
    }

    public static void disableLighting() {
    }

    public static void enableLighting() {
    }

    public static void enableBlend() {
        RenderSystem.enableBlend();
    }

    public static void disableBlend() {
        RenderSystem.disableBlend();
    }

    public static void disableTexture2D() {
    }

    public static void tryBlendFuncSeparate(int srcFactor, int dstFactor, int srcFactorAlpha, int dstFactorAlpha) {
        RenderSystem.blendFuncSeparate((int)srcFactor, (int)dstFactor, (int)srcFactorAlpha, (int)dstFactorAlpha);
    }

    public static void enableTexture2D() {
    }

    public static void disableStandardItemLighting() {
    }

    public static void enableStandardItemLighting() {
    }

    public static void enableGUIStandardItemLighting() {
        class_308.method_1452();
    }

    public static void disablePolygonOffset() {
        RenderSystem.disablePolygonOffset();
    }

    public static void doPolygonOffset(float f, float g) {
        RenderSystem.polygonOffset((float)f, (float)g);
    }
}

