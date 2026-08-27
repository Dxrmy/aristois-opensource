/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package me.deftware.client.framework.fonts;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import lombok.Generated;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.path.OSUtils;

public class AtlasTextureFont {
    public final Map<String, CharData> characterMap = new HashMap<String, CharData>();
    protected int fontSize;
    public boolean scaled;
    public int shadow = 1;
    private GlTexture textureAtlas;
    public int textureWidth;
    public int textureHeight;
    protected Font baseFont;
    protected Font stdFont;
    protected boolean ligatures = false;
    private FontMetrics metrics;

    public AtlasTextureFont(Font font, int fontSize, boolean scaled) {
        this.baseFont = font;
        this.fontSize = fontSize;
        this.scaled = scaled;
        RenderStack.scaleChangeCallback.add(() -> {
            this.setFont(this.baseFont);
            this.initialize();
        });
        this.setFont(this.baseFont);
    }

    public AtlasTextureFont(Font font, int fontSize) {
        this(font, fontSize, true);
    }

    public static Font getSystem(String name) {
        Font fallback = new Font(name, 0, 18);
        if (OSUtils.isWindows()) {
            try {
                File font = Paths.get(System.getenv("LOCALAPPDATA"), "Microsoft", "Windows", "Fonts", name + ".ttf").toFile();
                if (font.exists()) {
                    fallback = Font.createFont(0, new FileInputStream(font.getAbsolutePath()));
                }
            }
            catch (Throwable ex) {
                ex.printStackTrace();
            }
        }
        return fallback;
    }

    private Font derive(Font font) {
        return font.deriveFont(0, (float)this.fontSize * (this.scaled ? RenderStack.getScale() : 1.0f));
    }

    public void setFont(Font font) {
        this.stdFont = this.derive(font);
        this.ligatures = this.stdFont.getAttributes().containsKey(TextAttribute.LIGATURES);
        this.setMetrics(font);
    }

    public void setMetrics(Font font) {
        this.metrics = new Canvas().getFontMetrics(this.derive(font));
    }

    public void initialize() {
        this.destroy();
        ArrayList<String> characters = new ArrayList<String>();
        for (char numeric = '!'; numeric <= '\u00ff'; numeric = (char)(numeric + '\u0001')) {
            if (numeric == ' ') continue;
            characters.add(Character.toString(numeric));
        }
        if (this.ligatures) {
            characters.addAll(Arrays.asList("--", "---", "==", "===", "!=", "!==", "=!=", "=:=", "=/=", "<=", ">=", "&&", "&&&", "&=", "++", "+++", "***", ";;", "!!", "??", "?:", "?.", "?=", "<:", ":<", ":>", ">:", "<>", "<<<", ">>>", "<<", ">>", "||", "-|", "_|_", "|-", "||-", "|=", "||=", "##", "###", "####", "#{", "#[", "]#", "#(", "#?", "#_", "#_(", "#:", "#!", "#=", "^=", "<$>", "<$", "$>", "<+>", "<+", "+>", "<*>", "<*", "*>", "</", "</>", "/>", "<!--", "<#--", "-->", "->", "->>", "<<-", "<-", "<=<", "=<<", "<<=", "<==", "<=>", "<==>", "==>", "=>", "=>>", ">=>", ">>=", ">>-", ">-", ">--", "-<", "-<<", ">->", "<-<", "<-|", "<=|", "|=>", "|->", "<->", "<~~", "<~", "<~>", "~~", "~~>", "~>", "~-", "-~", "~@", "[||]", "|]", "[|", "|}", "{|", "[<", ">]", "|>", "<|", "||>", "<||", "|||>", "<|||", "<|>", "...", "..", ".=", ".-", "..<", ".?", "::", ":::", ":=", "::=", ":?", ":?>", "//", "///", "/*", "*/", "/=", "//=", "/==", "@_", "__"));
        }
        this.textureAtlas = this.characterGenerate(characters);
    }

    protected GlTexture characterGenerate(List<String> characters) {
        int characterWidth = 60;
        int maxPerRow = 30;
        int xLocation = 0;
        int height = this.getStringHeight();
        ArrayList<Consumer<Graphics2D>> generation = new ArrayList<Consumer<Graphics2D>>();
        for (int i = 0; i < characters.size(); ++i) {
            if (i > 0 && i % maxPerRow == 0) {
                height += this.getStringHeight() + 10;
                xLocation = 0;
            }
            String character = characters.get(i);
            int textWidth = this.getStringWidth(character);
            int textHeight = this.getStringHeight();
            int xOffset = xLocation;
            int yOffset = height - this.getStringHeight();
            generation.add(graphics -> {
                graphics.drawString(character, xOffset, yOffset + (textHeight - textHeight / 4));
                CharData data = new CharData(textWidth, textHeight, xOffset, yOffset, character);
                this.characterMap.put(character, data);
            });
            xLocation += characterWidth;
        }
        BufferedImage characterTexture = new BufferedImage(characterWidth * maxPerRow, height, 2);
        Graphics2D graphics2 = characterTexture.createGraphics();
        graphics2.setFont(this.stdFont);
        graphics2.setColor(Color.white);
        graphics2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        generation.forEach(c -> c.accept(graphics2));
        graphics2.dispose();
        this.textureWidth = characterTexture.getWidth();
        this.textureHeight = characterTexture.getHeight();
        DataBuffer dataBuffer = characterTexture.getData().getDataBuffer();
        long sizeBytes = (long)dataBuffer.getSize() * 4L;
        long sizeMB = sizeBytes / 0x100000L;
        Bootstrap.logger.debug("Font atlas {}x{}, {} megabytes", new Object[]{this.textureWidth, this.textureHeight, sizeMB});
        return new GlTexture(characterTexture);
    }

    public int getStringWidth(char ... chars) {
        return this.metrics.charsWidth(chars, 0, chars.length);
    }

    public int getStringWidth(String text) {
        return this.getStringWidth(text.toCharArray());
    }

    public int getStringHeight() {
        return this.metrics.getHeight();
    }

    public void destroy() {
        if (this.textureAtlas != null) {
            this.textureAtlas.destroy();
            this.characterMap.clear();
            this.textureAtlas = null;
        }
    }

    @Generated
    public Map<String, CharData> getCharacterMap() {
        return this.characterMap;
    }

    @Generated
    public void setShadow(int shadow) {
        this.shadow = shadow;
    }

    @Generated
    public int getShadow() {
        return this.shadow;
    }

    @Generated
    public GlTexture getTextureAtlas() {
        return this.textureAtlas;
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
    public void setBaseFont(Font baseFont) {
        this.baseFont = baseFont;
    }

    @Generated
    public void setStdFont(Font stdFont) {
        this.stdFont = stdFont;
    }

    @Generated
    public boolean isLigatures() {
        return this.ligatures;
    }

    public static class CharData {
        private int width;
        private int height;
        private int u;
        private int v;
        private String character;

        @Generated
        public int getWidth() {
            return this.width;
        }

        @Generated
        public int getHeight() {
            return this.height;
        }

        @Generated
        public int getU() {
            return this.u;
        }

        @Generated
        public int getV() {
            return this.v;
        }

        @Generated
        public String getCharacter() {
            return this.character;
        }

        @Generated
        public void setWidth(int width) {
            this.width = width;
        }

        @Generated
        public void setHeight(int height) {
            this.height = height;
        }

        @Generated
        public void setU(int u) {
            this.u = u;
        }

        @Generated
        public void setV(int v) {
            this.v = v;
        }

        @Generated
        public void setCharacter(String character) {
            this.character = character;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof CharData)) {
                return false;
            }
            CharData other = (CharData)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getWidth() != other.getWidth()) {
                return false;
            }
            if (this.getHeight() != other.getHeight()) {
                return false;
            }
            if (this.getU() != other.getU()) {
                return false;
            }
            if (this.getV() != other.getV()) {
                return false;
            }
            String this$character = this.getCharacter();
            String other$character = other.getCharacter();
            return !(this$character == null ? other$character != null : !this$character.equals(other$character));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof CharData;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getWidth();
            result = result * 59 + this.getHeight();
            result = result * 59 + this.getU();
            result = result * 59 + this.getV();
            String $character = this.getCharacter();
            result = result * 59 + ($character == null ? 43 : $character.hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "AtlasTextureFont.CharData(width=" + this.getWidth() + ", height=" + this.getHeight() + ", u=" + this.getU() + ", v=" + this.getV() + ", character=" + this.getCharacter() + ")";
        }

        @Generated
        public CharData(int width, int height, int u, int v, String character) {
            this.width = width;
            this.height = height;
            this.u = u;
            this.v = v;
            this.character = character;
        }
    }
}

