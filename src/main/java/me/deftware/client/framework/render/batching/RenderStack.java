/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  lombok.Generated
 *  net.minecraft.client.gl.ShaderProgramKeys
 *  net.minecraft.client.gl.ShaderProgramKey
 *  com.mojang.blaze3d.systems.ProjectionType
 *  net.minecraft.client.util.Window
 *  net.minecraft.client.render.BufferRenderer
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.render.VertexFormat
 *  net.minecraft.client.render.VertexFormat$DrawMode
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.ShaderProgram
 *  net.minecraft.client.render.BuiltBuffer
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fStack
 */
package me.deftware.client.framework.render.batching;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Generated;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.render.batching.VertexConstructor;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gl.ShaderProgramKey;
import com.mojang.blaze3d.systems.ProjectionType;
import net.minecraft.client.util.Window;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.BuiltBuffer;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;

public abstract class RenderStack<T>
implements VertexConstructor {
    public static float scale = 1.0f;
    public static final CopyOnWriteArrayList<Runnable> scaleChangeCallback = new CopyOnWriteArrayList();
    protected boolean scaled = true;
    protected float red = 1.0f;
    protected float green = 1.0f;
    protected float blue = 1.0f;
    protected float alpha = 1.0f;
    protected float lineWidth = 2.0f;
    protected Color lastColor = Color.white;
    protected class_287 builder = null;
    private int mode = -1;
    private GLX context;
    private static boolean inCustomMatrix = false;

    public static float getScale() {
        return scale;
    }

    public static void setScale(float scale) {
        if (scale < 0.5f) {
            scale = 0.5f;
        }
        if (scale > 4.0f) {
            scale = 4.0f;
        }
        RenderStack.scale = scale;
        Bootstrap.EMCSettings.putPrimitive("RENDER_SCALE", RenderStack.scale);
        scaleChangeCallback.forEach(Runnable::run);
    }

    public T setScaled(boolean scaling) {
        this.scaled = scaling;
        return (T)this;
    }

    public T push() {
        this.context.push();
        return (T)this;
    }

    public T pop() {
        this.context.pop();
        return (T)this;
    }

    public T lineWidth(float width) {
        this.lineWidth = width;
        RenderSystem.lineWidth((float)this.lineWidth);
        return (T)this;
    }

    public T glColor(int rgb, float alpha) {
        this.red = (float)(rgb >> 16 & 0xFF) / 255.0f;
        this.green = (float)(rgb >> 8 & 0xFF) / 255.0f;
        this.blue = (float)(rgb & 0xFF) / 255.0f;
        this.alpha = alpha / 255.0f;
        return (T)this;
    }

    public T glColor(Color color) {
        return this.glColor(color, (float)color.getAlpha());
    }

    public T glColor(Color color, float alpha) {
        this.red = (float)color.getRed() / 255.0f;
        this.green = (float)color.getGreen() / 255.0f;
        this.blue = (float)color.getBlue() / 255.0f;
        this.alpha = alpha / 255.0f;
        this.lastColor = color;
        return (T)this;
    }

    public abstract T begin(GLX var1);

    public T begin(GLX context, int mode) {
        this.context = context;
        this.mode = mode;
        this.setShader();
        RenderSystem.lineWidth((float)this.lineWidth);
        this.setBuilder(RenderStack.translate(mode), this.getFormat());
        return (T)this;
    }

    protected void setBuilder(class_293.class_5596 drawMode, class_293 vertexFormat) {
        this.builder = class_289.method_1348().method_60827(drawMode, vertexFormat);
    }

    public void end() {
        this.drawBuffer();
    }

    public boolean isBuilding() {
        return this.builder != null;
    }

    protected void drawBuffer() {
        class_9801 result;
        class_5944 shader = RenderSystem.getShader();
        if (shader != null && shader.field_29480 != null) {
            shader.field_29480.method_1251(RenderSystem.getShaderLineWidth());
        }
        if ((result = this.builder.method_60794()) != null) {
            class_286.method_43433((class_9801)result);
        }
        this.builder = null;
    }

    public static void noBlend() {
        RenderSystem.disableBlend();
    }

    public static void blend() {
        RenderSystem.blendFunc((int)770, (int)771);
        RenderSystem.enableBlend();
    }

    public static void setupGl() {
        RenderStack.blend();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask((boolean)false);
    }

    public static void restoreGl() {
        RenderStack.noBlend();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.enableDepthTest();
    }

    public static class_293.class_5596 translate(int mode) {
        return switch (mode) {
            case 7 -> class_293.class_5596.field_27382;
            case 3 -> class_293.class_5596.field_29345;
            case 1 -> class_293.class_5596.field_29344;
            case 6 -> class_293.class_5596.field_27381;
            case 5 -> class_293.class_5596.field_27380;
            case 4 -> class_293.class_5596.field_27379;
            default -> class_293.class_5596.field_27382;
        };
    }

    protected Matrix4f getModel() {
        return this.context.getModel();
    }

    @Override
    public void next() {
    }

    @Override
    public VertexConstructor color(float r, float g, float b, float alpha) {
        this.builder.method_22915(r, g, b, alpha);
        return this;
    }

    @Override
    public VertexConstructor texture(float u, float v) {
        this.builder.method_22913(u, v);
        return this;
    }

    @Override
    public VertexConstructor vertex(double x, double y, double z) {
        this.builder.method_22918(this.getModel(), (float)x, (float)y, (float)z).method_22915(this.red, this.green, this.blue, this.alpha);
        return this;
    }

    @Override
    public VertexConstructor normal(float x, float y, float z) {
        this.builder.method_22914(x, y, z);
        return this;
    }

    protected class_293 getFormat() {
        return class_290.field_1576;
    }

    protected void setShader() {
        RenderSystem.setShader((class_10156)class_10142.field_53876);
    }

    public static void reloadCustomMatrix() {
        if (inCustomMatrix) {
            throw new IllegalStateException("Already in custom matrix!");
        }
        inCustomMatrix = true;
        class_1041 window = class_310.method_1551().method_22683();
        RenderStack.setMatrix(window.method_4480(), window.method_4507());
    }

    public static void reloadMinecraftMatrix() {
        if (!inCustomMatrix) {
            throw new IllegalStateException("Already in Minecraft matrix!");
        }
        inCustomMatrix = false;
        class_1041 window = class_310.method_1551().method_22683();
        RenderStack.setMatrix((float)((double)window.method_4489() / window.method_4495()), (float)((double)window.method_4506() / window.method_4495()));
    }

    protected static void setMatrix(float width, float height) {
        RenderSystem.clear((int)256);
        Matrix4f matrix4f = new Matrix4f().setOrtho(0.0f, width, height, 0.0f, 1000.0f, 21000.0f);
        RenderSystem.setProjectionMatrix((Matrix4f)matrix4f, (class_10366)class_10366.field_54954);
        Matrix4fStack matrixStack = RenderSystem.getModelViewStack();
        matrixStack.identity();
        matrixStack.translate(0.0f, 0.0f, -11000.0f);
    }

    @Generated
    public boolean isScaled() {
        return this.scaled;
    }

    @Generated
    public static boolean isInCustomMatrix() {
        return inCustomMatrix;
    }
}

