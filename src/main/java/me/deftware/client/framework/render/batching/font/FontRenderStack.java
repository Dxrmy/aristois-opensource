/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  lombok.Generated
 *  net.minecraft.client.gl.ShaderProgramKeys
 *  net.minecraft.client.gl.ShaderProgramKey
 *  net.minecraft.text.Style
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.render.VertexFormat
 *  net.minecraft.text.TextColor
 */
package me.deftware.client.framework.render.batching.font;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.Map;
import java.util.Optional;
import lombok.Generated;
import me.deftware.client.framework.fonts.AtlasTextureFont;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.font.IFontProvider;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.batching.VertexConstructor;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.text.Style;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.text.TextColor;

public class FontRenderStack
extends RenderStack<FontRenderStack> {
    private int offset = 0;
    private final AtlasTextureFont font;
    private int maxLigatureSize = 5;
    private boolean ligatures;

    public FontRenderStack(IFontProvider font) {
        this.font = font.getFont();
        this.scaled = this.font.scaled;
        this.ligatures = this.font.isLigatures();
    }

    @Override
    public FontRenderStack begin(GLX context) {
        this.font.getTextureAtlas().bind();
        return (FontRenderStack)super.begin(context, 7);
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

    public FontRenderStack drawString(double x, double y, String message) {
        return this.drawString((int)x, (int)y, message);
    }

    public FontRenderStack drawString(int x, int y, String message) {
        this.renderCharBuffer(message.split(""), x, y, this.lastColor.getRGB());
        this.offset = 0;
        return this;
    }

    public FontRenderStack drawString(double x, double y, Message message) {
        return this.drawString((int)x, (int)y, message);
    }

    public FontRenderStack drawString(int x, int y, Message message) {
        message.visit((style, text) -> {
            class_5251 textColor = ((class_2583)style).method_10973();
            int color = Color.WHITE.getRGB();
            if (textColor != null) {
                color = textColor.method_27716();
            }
            this.renderCharBuffer(text.split(""), x, y, color);
            return Optional.empty();
        });
        this.offset = 0;
        return this;
    }

    public void reset() {
        this.offset = 0;
    }

    public AtlasTextureFont getFont() {
        return this.font;
    }

    public int getOffset() {
        return this.offset;
    }

    public int renderCharBuffer(String[] buffer, int x, int y, int color) {
        if (this.scaled) {
            x = (int)((float)x * RenderStack.getScale());
            y = (int)((float)y * RenderStack.getScale());
        }
        int shadow = this.font.getShadow();
        Map<String, AtlasTextureFont.CharData> characterMap = this.font.getCharacterMap();
        for (int character = 0; character < buffer.length; ++character) {
            if (buffer[character].isEmpty()) continue;
            if (buffer[character].equalsIgnoreCase(" ")) {
                this.offset += this.font.getStringWidth(" ");
                continue;
            }
            int index = character;
            if (this.ligatures) {
                Object tempString = buffer[character];
                for (int i = 1; i <= this.maxLigatureSize && character + i < buffer.length; ++i) {
                    if (!characterMap.containsKey(tempString = (String)tempString + buffer[character + i])) continue;
                    buffer[index] = tempString;
                    character += i;
                    break;
                }
            }
            if (!characterMap.containsKey(buffer[index])) {
                buffer[index] = "?";
            }
            AtlasTextureFont.CharData data = characterMap.get(buffer[index]);
            if (shadow > 0) {
                this.glColor(Color.black);
                this.drawCharacter(x + this.offset + shadow, y + shadow, data);
            }
            this.glColor(color, 255.0f);
            this.drawCharacter(x + this.offset, y, data);
            this.offset += data.getWidth();
        }
        return this.offset;
    }

    public int getFontHeight() {
        return (int)((float)this.font.getStringHeight() / (this.scaled ? RenderStack.getScale() : 1.0f));
    }

    public int getStringWidth(String text) {
        return (int)((float)this.font.getStringWidth(text) / (this.scaled ? RenderStack.getScale() : 1.0f));
    }

    public int getStringWidth(Message text) {
        return this.getStringWidth(text.string());
    }

    private void drawCharacter(int x, int y, AtlasTextureFont.CharData data) {
        int width = data.getWidth();
        int height = data.getHeight();
        int u = data.getU();
        int v = data.getV();
        this.drawTexture(x, x + width, y, y + height, 0, width, height, u, v, this.font.getTextureWidth(), this.font.getTextureHeight());
    }

    private void drawTexture(int x0, int x1, int y0, int y1, int z, int regionWidth, int regionHeight, float u, float v, int textureWidth, int textureHeight) {
        this.drawTexturedQuad(x0, x1, y0, y1, z, u / (float)textureWidth, (u + (float)regionWidth) / (float)textureWidth, v / (float)textureHeight, (v + (float)regionHeight) / (float)textureHeight);
    }

    private void drawTexturedQuad(int x0, int x1, int y0, int y1, int z, float u0, float u1, float v0, float v1) {
        this.vertex(x0, y1, z).texture(u0, v1).color(this.red, this.green, this.blue, this.alpha).next();
        this.vertex(x1, y1, z).texture(u1, v1).color(this.red, this.green, this.blue, this.alpha).next();
        this.vertex(x1, y0, z).texture(u1, v0).color(this.red, this.green, this.blue, this.alpha).next();
        this.vertex(x0, y0, z).texture(u0, v0).color(this.red, this.green, this.blue, this.alpha).next();
    }

    @Generated
    public void setMaxLigatureSize(int maxLigatureSize) {
        this.maxLigatureSize = maxLigatureSize;
    }

    @Generated
    public void setLigatures(boolean ligatures) {
        this.ligatures = ligatures;
    }
}

