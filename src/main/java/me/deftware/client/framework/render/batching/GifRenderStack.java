/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  lombok.Generated
 *  net.minecraft.class_10142
 *  net.minecraft.class_10156
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package me.deftware.client.framework.render.batching;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.batching.VertexConstructor;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.texture.GlTexture;
import net.minecraft.class_10142;
import net.minecraft.class_10156;
import net.minecraft.class_290;
import net.minecraft.class_293;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GifRenderStack
extends RenderStack<GifRenderStack> {
    private static final Logger logger = LoggerFactory.getLogger((String)"GifRenderer");
    private boolean isAvailable = false;
    private int width = 0;
    private int height = 0;
    private final Map<Integer, Frame> frames = new HashMap<Integer, Frame>();
    private GlTexture texture;
    private int frameIndex = 0;
    private long lastFrame = System.currentTimeMillis();

    public GifRenderStack(GifProvider gif) {
        try {
            logger.debug("Loading gif, with {} frames", (Object)gif.getFrameCount());
            this.width = gif.getWidth();
            this.height = gif.getHeight();
            this.texture = new GlTexture(gif.getFrame(0));
            logger.debug("Allocated texture with id {}", (Object)this.texture.getGlId());
            for (int i = 0; i < gif.getFrameCount(); ++i) {
                BufferedImage image = gif.getFrame(i);
                if (image.getWidth() != this.width || image.getHeight() != this.height) {
                    throw new IOException("Target frame is not the same size as the first one");
                }
                this.frames.put(i, new Frame(image.getWidth(), image.getHeight(), gif.getDelay(i), GlTexture.getImageBuffer(image)));
            }
            logger.debug("Successfully loaded gif");
            this.isAvailable = true;
        }
        catch (Throwable ex) {
            logger.error("Failed to load gif", ex);
        }
    }

    private void nextFrame() {
        if (this.lastFrame < System.currentTimeMillis()) {
            if (this.frameIndex >= this.frames.size()) {
                this.frameIndex = 0;
            }
            Frame frame = this.frames.get(this.frameIndex);
            frame.upload(this.texture);
            ++this.frameIndex;
            this.lastFrame = System.currentTimeMillis() + (long)frame.getDelay();
        }
    }

    @Override
    public GifRenderStack begin(GLX context) {
        if (!this.isAvailable) {
            throw new RuntimeException("Cannot render unavailable gif!");
        }
        this.texture.bind();
        return (GifRenderStack)this.begin(context, 7);
    }

    @Override
    public void end() {
        super.end();
    }

    @Override
    protected class_293 getFormat() {
        return class_290.field_1575;
    }

    @Override
    protected void setShader() {
        RenderSystem.setShader((class_10156)class_10142.field_53880);
    }

    @Override
    public VertexConstructor vertex(double x, double y, double z) {
        this.builder.method_22918(this.getModel(), (float)x, (float)y, (float)z);
        return this;
    }

    public GifRenderStack draw(int x0, int y0, int x1, int y1) {
        boolean u0 = false;
        boolean u1 = true;
        boolean v0 = false;
        boolean v1 = true;
        this.vertex(x0, y1, 0.0).texture((float)u0, (float)v1).color(this.red, this.green, this.blue, this.alpha).next();
        this.vertex(x1, y1, 0.0).texture((float)u1, (float)v1).color(this.red, this.green, this.blue, this.alpha).next();
        this.vertex(x1, y0, 0.0).texture((float)u1, (float)v0).color(this.red, this.green, this.blue, this.alpha).next();
        this.vertex(x0, y0, 0.0).texture((float)u0, (float)v0).color(this.red, this.green, this.blue, this.alpha).next();
        this.nextFrame();
        return this;
    }

    public void destroy() {
        this.texture.destroy();
        this.texture = null;
    }

    @Generated
    public boolean isAvailable() {
        return this.isAvailable;
    }

    @Generated
    public int getWidth() {
        return this.width;
    }

    @Generated
    public int getHeight() {
        return this.height;
    }

    @Generated
    public Map<Integer, Frame> getFrames() {
        return this.frames;
    }

    @Generated
    public GlTexture getTexture() {
        return this.texture;
    }

    @Generated
    public int getFrameIndex() {
        return this.frameIndex;
    }

    @Generated
    public void setLastFrame(long lastFrame) {
        this.lastFrame = lastFrame;
    }

    public static interface GifProvider {
        public int getFrameCount();

        public BufferedImage getFrame(int var1);

        public int getDelay(int var1);

        public int getWidth();

        public int getHeight();
    }

    private static class Frame {
        private final int width;
        private final int height;
        private final int delay;
        private final ByteBuffer buffer;

        public void upload(GlTexture texture) {
            texture.upload(this.buffer, true);
        }

        @Generated
        public int getWidth() {
            return this.width;
        }

        @Generated
        public int getHeight() {
            return this.height;
        }

        @Generated
        public int getDelay() {
            return this.delay;
        }

        @Generated
        public ByteBuffer getBuffer() {
            return this.buffer;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Frame)) {
                return false;
            }
            Frame other = (Frame)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getWidth() != other.getWidth()) {
                return false;
            }
            if (this.getHeight() != other.getHeight()) {
                return false;
            }
            if (this.getDelay() != other.getDelay()) {
                return false;
            }
            ByteBuffer this$buffer = this.getBuffer();
            ByteBuffer other$buffer = other.getBuffer();
            return !(this$buffer == null ? other$buffer != null : !((Object)this$buffer).equals(other$buffer));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Frame;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getWidth();
            result = result * 59 + this.getHeight();
            result = result * 59 + this.getDelay();
            ByteBuffer $buffer = this.getBuffer();
            result = result * 59 + ($buffer == null ? 43 : ((Object)$buffer).hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "GifRenderStack.Frame(width=" + this.getWidth() + ", height=" + this.getHeight() + ", delay=" + this.getDelay() + ", buffer=" + String.valueOf(this.getBuffer()) + ")";
        }

        @Generated
        public Frame(int width, int height, int delay, ByteBuffer buffer) {
            this.width = width;
            this.height = height;
            this.delay = delay;
            this.buffer = buffer;
        }
    }
}

