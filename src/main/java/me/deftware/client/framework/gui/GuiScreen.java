/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.text.Text
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.text.StringVisitable
 */
package me.deftware.client.framework.gui;

import lombok.Generated;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.gui.widgets.GenericComponent;
import me.deftware.client.framework.gui.widgets.Label;
import me.deftware.client.framework.input.Mouse;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.StringVisitable;

public abstract class GuiScreen
extends class_437
implements GenericScreen {
    public GenericScreen parent;
    private BackgroundType backgroundType = BackgroundType.Textured;
    private GLX glx;

    public GuiScreen(GenericScreen parent) {
        super((class_2561)class_2561.method_43470((String)""));
        this.parent = parent;
    }

    public GuiScreen() {
        this(null);
    }

    public boolean method_25406(double x, double y, int button) {
        if (this.onMouseReleased((int)Math.round(x), (int)Math.round(y), button)) {
            return true;
        }
        return super.method_25406(x, y, button);
    }

    public boolean method_25402(double mouseX, double mouseY, int mouseButton) {
        if (this.onMouseClicked((int)Math.round(mouseX), (int)Math.round(mouseY), mouseButton)) {
            return true;
        }
        return super.method_25402(mouseX, mouseY, mouseButton);
    }

    public void method_25394(class_332 context, int mouseX, int mouseY, float partialTicks) {
        Mouse.updateMousePosition();
        this.glx = GLX.of(context);
        super.method_25394(context, mouseX, mouseY, partialTicks);
        this.onDraw(this.glx, mouseX, mouseY, partialTicks);
        this.onPostDraw(this.glx, mouseX, mouseY, partialTicks);
    }

    public void method_25420(class_332 context, int mouseX, int mouseY, float delta) {
        if (this.backgroundType == BackgroundType.TexturedOrTransparent) {
            super.method_25420(context, mouseX, mouseY, delta);
            return;
        }
        if (this.backgroundType != null) {
            this.backgroundType.renderBackground(this.glx, mouseX, mouseY, delta, this);
        }
    }

    public void method_25410(class_310 mcIn, int w, int h) {
        super.method_25410(mcIn, w, h);
        this.onGuiResize(w, h);
    }

    public void method_25393() {
        super.method_25393();
        this.onUpdate();
    }

    public void method_25426() {
        super.method_25426();
        this.onInitGui();
    }

    public void method_25432() {
        this.onGuiClose();
        super.method_25432();
    }

    public boolean method_25404(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256 && this.goBack()) {
            return true;
        }
        if (this.onKeyPressed(keyCode, scanCode, modifiers)) {
            return true;
        }
        return super.method_25404(keyCode, scanCode, modifiers);
    }

    public boolean method_16803(int keyCode, int scanCode, int modifiers) {
        if (this.onKeyReleased(keyCode, scanCode, modifiers)) {
            return true;
        }
        return super.method_16803(keyCode, scanCode, modifiers);
    }

    protected MinecraftScreen getMinecraftScreen() {
        return (MinecraftScreen)((Object)this);
    }

    protected void addComponent(GenericComponent component) {
        this.getMinecraftScreen().addScreenComponent(component);
    }

    protected GuiScreen addText(int x, int y, Message text) {
        this.addComponent(new Label(x, y, text));
        return this;
    }

    protected GuiScreen addCenteredText(int x, int y, Message text) {
        this.addComponent(new Label(x - class_310.method_1551().field_1772.method_27525((class_5348)((class_2561)text)) / 2, y, text));
        return this;
    }

    protected boolean goBack() {
        class_310.method_1551().method_1507((class_437)this.parent);
        return true;
    }

    public int getGuiScreenWidth() {
        return this.field_22789;
    }

    public int getGuiScreenHeight() {
        return this.field_22790;
    }

    protected void onGuiClose() {
    }

    protected abstract void onInitGui();

    protected void onPostDraw(GLX context, int mouseX, int mouseY, float partialTicks) {
    }

    protected abstract void onDraw(GLX var1, int var2, int var3, float var4);

    protected void onUpdate() {
    }

    protected boolean onKeyPressed(int keyCode, int scanCode, int modifiers) {
        return false;
    }

    protected boolean onKeyReleased(int keyCode, int scanCode, int modifiers) {
        return false;
    }

    protected boolean onMouseReleased(int mouseX, int mouseY, int mouseButton) {
        return false;
    }

    protected boolean onMouseClicked(int mouseX, int mouseY, int mouseButton) {
        return false;
    }

    protected void onGuiResize(int w, int h) {
    }

    public static int getScaledHeight() {
        return class_310.method_1551().method_22683().method_4502();
    }

    public static int getScaledWidth() {
        return class_310.method_1551().method_22683().method_4486();
    }

    public static int getDisplayHeight() {
        return class_310.method_1551().method_22683().method_4507();
    }

    public static int getDisplayWidth() {
        return class_310.method_1551().method_22683().method_4480();
    }

    @Generated
    public void setBackgroundType(BackgroundType backgroundType) {
        this.backgroundType = backgroundType;
    }

    public static interface BackgroundType {
        public static final BackgroundType None = (context, mouseX, mouseY, delta, parent) -> {};
        public static final BackgroundType Textured = (context, mouseX, mouseY, delta, parent) -> {
            if (class_310.method_1551().field_1687 == null) {
                parent.method_57728(context.getContext(), delta);
            }
            parent.method_57734();
            parent.method_57735(context.getContext());
        };
        public static final BackgroundType TexturedOrTransparent = (context, mouseX, mouseY, delta, parent) -> parent.method_25420(context.getContext(), mouseX, mouseY, delta);

        public void renderBackground(GLX var1, int var2, int var3, float var4, GuiScreen var5);
    }
}

