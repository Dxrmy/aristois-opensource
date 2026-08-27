/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  net.minecraft.class_7833
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fStack
 *  org.joml.Matrix4fc
 *  org.lwjgl.opengl.GL11
 */
package me.deftware.client.framework.render.gl;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.StringJoiner;
import java.util.function.Consumer;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_7833;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Matrix4fc;
import org.lwjgl.opengl.GL11;

public class GLX {
    private GLXProvider provider = new GLXMatrixProvider();
    private static final GLX instance = new GLX();
    private class_332 context;

    public class_332 getContext() {
        return this.context;
    }

    public static GLX of(class_332 context) {
        GLX.instance.context = context;
        return instance;
    }

    public Matrix4f getModel() {
        return this.context.method_51448().method_23760().method_23761();
    }

    public void modelViewStack(Consumer<Matrix4fStack> action) {
        Matrix4fStack matrixStack = RenderSystem.getModelViewStack();
        matrixStack.pushMatrix();
        matrixStack.mul((Matrix4fc)this.getModel());
        action.accept(matrixStack);
        matrixStack.popMatrix();
    }

    public void isolate(Runnable action) {
        this.push();
        action.run();
        this.pop();
    }

    public void push() {
        this.provider.push();
    }

    public void pop() {
        this.provider.pop();
    }

    public void color(float red, float green, float blue, float alpha) {
        this.provider.color(red, green, blue, alpha);
    }

    public void color(float red, float green, float blue) {
        this.color(red, green, blue, 1.0f);
    }

    public void scale(float x, float y, float z) {
        this.provider.scale(x, y, z);
    }

    public void scale(double x, double y, double z) {
        this.scale((float)x, (float)y, (float)z);
    }

    public void translate(double x, double y, double z) {
        this.translate((float)x, (float)y, (float)z);
    }

    public void translate(float x, float y, float z) {
        this.provider.translate(x, y, z);
    }

    public void rotate(float angle, float x, float y, float z) {
        this.provider.rotate(angle, x, y, z);
    }

    public void rotate(double angle, double x, double y, double z) {
        this.rotate((float)angle, (float)x, (float)y, (float)z);
    }

    public String toString() {
        return new StringJoiner(",").add("renderer=" + this.provider.getClass().getName()).toString();
    }

    public class GLXMatrixProvider
    implements GLXProvider {
        @Override
        public void translate(float x, float y, float z) {
            GLX.this.context.method_51448().method_46416(x, y, z);
        }

        @Override
        public void scale(float x, float y, float z) {
            GLX.this.context.method_51448().method_22905(x, y, z);
        }

        @Override
        public void color(float red, float green, float blue, float alpha) {
            RenderSystem.setShaderColor((float)red, (float)green, (float)blue, (float)alpha);
        }

        @Override
        public void rotate(float angle, float x, float y, float z) {
            class_4587 matrices = GLX.this.context.method_51448();
            if (x > 0.0f) {
                matrices.method_22907(class_7833.field_40714.rotationDegrees(angle));
            }
            if (y > 0.0f) {
                matrices.method_22907(class_7833.field_40716.rotationDegrees(angle));
            }
            if (z > 0.0f) {
                matrices.method_22907(class_7833.field_40718.rotationDegrees(angle));
            }
        }

        @Override
        public void push() {
            GLX.this.context.method_51448().method_22903();
        }

        @Override
        public void pop() {
            GLX.this.context.method_51448().method_22909();
        }

        @Override
        public String id() {
            return "DrawContext";
        }
    }

    public static interface GLXProvider {
        default public void translate(float x, float y, float z) {
            GL11.glTranslatef((float)x, (float)y, (float)z);
        }

        default public void rotate(float angle, float x, float y, float z) {
            GL11.glRotatef((float)angle, (float)x, (float)y, (float)z);
        }

        default public void scale(float x, float y, float z) {
            GL11.glScalef((float)x, (float)y, (float)z);
        }

        default public void color(float red, float green, float blue, float alpha) {
            GL11.glColor4f((float)red, (float)green, (float)blue, (float)alpha);
        }

        default public void color(Color color) {
            this.color((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
        }

        default public void push() {
            GL11.glPushMatrix();
        }

        default public void pop() {
            GL11.glPopMatrix();
        }

        public String id();
    }
}

