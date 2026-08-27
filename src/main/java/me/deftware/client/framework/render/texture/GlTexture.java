/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  lombok.Generated
 *  net.minecraft.class_10142
 *  net.minecraft.class_10156
 *  net.minecraft.class_1044
 *  net.minecraft.class_286
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_9801
 *  org.joml.Matrix4f
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL30
 */
package me.deftware.client.framework.render.texture;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import lombok.Generated;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.util.ResourceUtils;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;
import net.minecraft.class_10142;
import net.minecraft.class_10156;
import net.minecraft.class_1044;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_9801;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;

public class GlTexture
implements GuiScreen.BackgroundType {
    protected int glId;
    protected int textureWidth;
    protected int textureHeight;
    protected int scaling;

    public GlTexture(EMCMod mod, String asset) throws IOException {
        this(ResourceUtils.getStreamFromModResources(mod, asset));
    }

    public GlTexture(File file) throws IOException {
        this(ImageIO.read(file));
    }

    public GlTexture(InputStream stream) throws IOException {
        this(ImageIO.read(stream));
    }

    public GlTexture(BufferedImage image) {
        this(image, 9729);
    }

    public GlTexture() {
    }

    public GlTexture(BufferedImage image, int scaling) {
        this.init(image, scaling);
    }

    protected void init(BufferedImage image, int scaling) {
        this.scaling = scaling;
        this.textureWidth = image.getWidth();
        this.textureHeight = image.getHeight();
        this.glId = GL11.glGenTextures();
        GL13.glActiveTexture((int)33984);
        GL11.glBindTexture((int)3553, (int)this.glId);
        this.upload(GlTexture.getImageBuffer(image), false);
        GL30.glGenerateMipmap((int)3553);
    }

    public GlTexture draw(GLX context, int x, int y, int width, int height) {
        return this.draw(context, x, y, width, height, 0, 0, width, height);
    }

    public GlTexture draw(GLX context, int x, int y, int width, int height, int u, int v, int textureWidth, int textureHeight) {
        GlTexture.drawTexture(context, x, y, width, height, u, v, textureWidth, textureHeight);
        return this;
    }

    public static void drawTexture(GLX context, int x, int y, int width, int height, int u, int v, int textureWidth, int textureHeight) {
        GlTexture.drawTexture(context, x, x + width, y, y + height, 0, width, height, u, v, textureWidth, textureHeight);
    }

    public GlTexture bind() {
        GlTexture.bindTexture(this.glId);
        return this;
    }

    public boolean isReady() {
        return this.glId != 0;
    }

    public void unbind() {
        GlTexture.bindTexture(0);
    }

    public void upload(BufferedImage image) {
        this.upload(GlTexture.getImageBuffer(image), true);
    }

    public void upload(ByteBuffer buffer, boolean replace) {
        GL11.glPixelStorei((int)3314, (int)0);
        GL11.glPixelStorei((int)3316, (int)0);
        GL11.glPixelStorei((int)3315, (int)0);
        GL11.glPixelStorei((int)3317, (int)4);
        GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
        GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
        GL11.glTexParameteri((int)3553, (int)10241, (int)this.scaling);
        GL11.glTexParameteri((int)3553, (int)10240, (int)this.scaling);
        if (replace) {
            GL11.glTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)this.textureWidth, (int)this.textureHeight, (int)6408, (int)5121, (ByteBuffer)buffer);
        } else {
            GL11.glTexImage2D((int)3553, (int)0, (int)32856, (int)this.textureWidth, (int)this.textureHeight, (int)0, (int)6408, (int)5121, (ByteBuffer)buffer);
        }
    }

    public void destroy() {
        this.bind();
        GL11.glDeleteTextures((int)this.glId);
        this.glId = -1;
    }

    @Override
    public void renderBackground(GLX context, int mouseX, int mouseY, float delta, GuiScreen parent) {
        context.color(1.0f, 1.0f, 1.0f, 1.0f);
        int width = parent.getGuiScreenWidth();
        int height = parent.getGuiScreenHeight();
        if (RenderStack.isInCustomMatrix()) {
            width = GuiScreen.getDisplayWidth();
            height = GuiScreen.getDisplayHeight();
        }
        this.bind().draw(context, 0, 0, width, height).unbind();
    }

    public static ByteBuffer getImageBuffer(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, image.getWidth());
        ByteBuffer buffer = BufferUtils.createByteBuffer((int)(image.getWidth() * image.getHeight() * 4));
        for (int y = 0; y < image.getHeight(); ++y) {
            for (int x = 0; x < image.getWidth(); ++x) {
                int pixel = pixels[y * image.getWidth() + x];
                buffer.put((byte)(pixel >> 16 & 0xFF));
                buffer.put((byte)(pixel >> 8 & 0xFF));
                buffer.put((byte)(pixel & 0xFF));
                buffer.put((byte)(pixel >> 24 & 0xFF));
            }
        }
        buffer.flip();
        return buffer;
    }

    public static void bindTexture(int id) {
        RenderSystem.bindTexture((int)id);
        RenderSystem.setShaderTexture((int)0, (int)id);
    }

    public static void bindTexture(MinecraftIdentifier id) {
        class_1044 texture = class_310.method_1551().method_1531().method_4619((class_2960)id);
        GlTexture.bindTexture(texture.method_4624());
    }

    private static void drawTexture(GLX context, int x0, int x1, int y0, int y1, int z, int regionWidth, int regionHeight, float u, float v, int textureWidth, int textureHeight) {
        GlTexture.drawTexturedQuad(context, x0, x1, y0, y1, z, u / (float)textureWidth, (u + (float)regionWidth) / (float)textureWidth, v / (float)textureHeight, (v + (float)regionHeight) / (float)textureHeight);
    }

    private static void drawTexturedQuad(GLX context, int x0, int x1, int y0, int y1, int z, float u0, float u1, float v0, float v1) {
        RenderSystem.setShader((class_10156)class_10142.field_53879);
        Matrix4f matrix4f = context.getContext().method_51448().method_23760().method_23761();
        class_287 bufferBuilder = class_289.method_1348().method_60827(class_293.class_5596.field_27382, class_290.field_1585);
        bufferBuilder.method_22918(matrix4f, (float)x0, (float)y1, (float)z).method_22913(u0, v1);
        bufferBuilder.method_22918(matrix4f, (float)x1, (float)y1, (float)z).method_22913(u1, v1);
        bufferBuilder.method_22918(matrix4f, (float)x1, (float)y0, (float)z).method_22913(u1, v0);
        bufferBuilder.method_22918(matrix4f, (float)x0, (float)y0, (float)z).method_22913(u0, v0);
        class_286.method_43433((class_9801)bufferBuilder.method_60800());
    }

    @Generated
    public int getGlId() {
        return this.glId;
    }

    @Generated
    public int getTextureWidth() {
        return this.textureWidth;
    }

    @Generated
    public int getTextureHeight() {
        return this.textureHeight;
    }

    @Generated
    public int getScaling() {
        return this.scaling;
    }
}

