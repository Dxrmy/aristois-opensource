/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.MinecraftClient
 */
package me.deftware.client.framework.render.shader;

import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.MinecraftClient;

public class Framebuffer {
    public static final Framebuffer Main = new Framebuffer(class_310.method_1551().method_1522());
    private final class_276 buffer;

    public Framebuffer(class_276 buffer) {
        this.buffer = buffer;
    }

    public void clear() {
        this.buffer.method_1230();
    }

    public void bind(boolean setViewport) {
        this.buffer.method_1235(setViewport);
    }

    public void draw(int width, int height, boolean disableBlend) {
        this.buffer.method_1237(width, height);
    }

    public void resize(int width, int height) {
        this.buffer.method_1234(width, height);
    }

    public void close() {
        this.buffer.method_1238();
    }

    public void copyDepth(Framebuffer buffer) {
        this.buffer.method_29329(buffer.getMinecraftBuffer());
    }

    public class_276 getMinecraftBuffer() {
        return this.buffer;
    }
}

