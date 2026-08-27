/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.FrameworkConstants
 *  me.deftware.client.framework.fonts.FontRenderer
 *  me.deftware.client.framework.gui.GuiScreen
 *  me.deftware.client.framework.gui.ScreenRegistry
 *  me.deftware.client.framework.gui.screens.GenericScreen
 *  me.deftware.client.framework.gui.widgets.Button
 *  me.deftware.client.framework.gui.widgets.GenericComponent
 *  me.deftware.client.framework.input.Keyboard
 *  me.deftware.client.framework.message.Appearance
 *  me.deftware.client.framework.message.Appearance$FormattingColor
 *  me.deftware.client.framework.message.DefaultColors
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.message.Message$Builder
 *  me.deftware.client.framework.minecraft.Minecraft
 */
package me.deftware.aristois.main;

import \u0000nunyaboolean.catch.for.implements.boolean;
import \u0000nunyaboolean.catch.for.null.enum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.main.Validator;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.gui.widgets.GenericComponent;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class GuiUnsupportedModern
extends GuiScreen {
    public static List<Message> text = Arrays.asList(Message.of((String)"Aristois (EMC) was unable to perform an auto update. This means you will").style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), Message.of((String)"need to re-download and re-install Aristois from aristois.net/download.").style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), boolean.assert\u00a0new, new Message.Builder().append("If you proceed without updating, your game", Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)).append(" will be unstable.", Appearance.of(2, (Appearance.FormattingColor)DefaultColors.RED)).append(" Do not ask for", Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)).build(), Message.of((String)"help or support if you choose to ignore this warning!").style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)));
    public static List<Message> fixText = Arrays.asList(Message.of((String)"1. Close Minecraft and open your Minecraft directory.").style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), Message.of((String)"2. Go into the libraries folder and delete the \"me\" folder.").style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), Message.of((String)"3. Start Aristois again and it *should* work.").style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), boolean.assert\u00a0new, Message.of((String)"If it doesn't work, visit aristois.net/guilded or try to re-install Aristois.").style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)));
    final private UnsupportedReason reason;
    private boolean debugInfo = false;

    public static void open(UnsupportedReason reason) {
        Minecraft.getMinecraftGame().openScreen((GenericScreen)new GuiUnsupportedModern(reason));
    }

    public GuiUnsupportedModern(UnsupportedReason reason) {
        this.reason = reason;
    }

    protected void onInitGui() {
        int buttonWidth = 150;
        this.addComponent((GenericComponent)Button.create(0, (int)(this.getGuiScreenWidth() / 2 - buttonWidth - 10), (int)(this.getGuiScreenHeight() - 35), (int)buttonWidth, 20, (Message)Message.of((String)"Continue").style(Appearance.of((Appearance.FormattingColor)DefaultColors.RED)), (boolean)true, btn -> {
            Main.getInstance().setup();
            ScreenRegistry.MainMenu.open(new Object[]{null});
            enum.finally().switch();
            return true;
        }));
        this.addComponent((GenericComponent)Button.create(1, (int)(this.getGuiScreenWidth() / 2 + 10), (int)(this.getGuiScreenHeight() - 35), (int)buttonWidth, 20, (Message)Message.of((String)"Update").style(Appearance.of(8, (Appearance.FormattingColor)DefaultColors.GREEN)), (boolean)true, btn -> {
            Keyboard.openLink((String)"https://aristois.net/download");
            return true;
        }));
        this.addCenteredText(this.getGuiScreenWidth() / 2, 20, new Message.Builder().append("Warning!", Appearance.of(2, (Appearance.FormattingColor)DefaultColors.RED)).append(" Aristois was unable to perform an auto update.", Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)).build());
        int y = 45;
        for (Message line : text) {
            this.addCenteredText(this.getGuiScreenWidth() / 2, y, line);
            y += FontRenderer.getFontHeight() + 2;
        }
        this.populateSubView(y);
    }

    private void populateSubView(int y) {
        y += FontRenderer.getFontHeight() * 2;
        Message.Builder builder = new Message.Builder();
        if (this.debugInfo) {
            builder.append("Debug data (Err ", Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)).append(this.reason.name(), Appearance.of(2, (Appearance.FormattingColor)DefaultColors.RED)).append(")", Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY));
        } else {
            builder.append("How to fix it", Appearance.of(8, (Appearance.FormattingColor)DefaultColors.YELLOW));
        }
        this.addCenteredText(this.getGuiScreenWidth() / 2, y, builder.build());
        y += FontRenderer.getFontHeight() * 2;
        for (Message line : this.debugInfo ? this.reason.getText() : fixText) {
            this.addCenteredText(this.getGuiScreenWidth() / 2, y, line);
            y += FontRenderer.getFontHeight() + 2;
        }
    }

    protected void onDraw(int mouseX, int mouseY, float partialTicks) {
    }

    protected void onUpdate() {
    }

    protected boolean onKeyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 340 || keyCode == 344) {
            this.debugInfo = !this.debugInfo;
            this.getMinecraftScreen()._clearChildren();
            this.onInitGui();
            return true;
        }
        return super.onKeyPressed(keyCode, scanCode, modifiers);
    }

    public static enum UnsupportedReason {
        EMC_INVALID_CHECKSUM(Arrays.asList(Message.of((String)String.format("Local checksum %s", Validator.getLocalChecksum())).style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), Message.of((String)String.format("Remote checksum %s", Validator.getRemoteChecksum())).style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), Message.of((String)FrameworkConstants.toDataString()).style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), Message.of((String)System.getProperty("EMCDir", "Err (EMC dir not set)")).style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), Message.of((String)FrameworkConstants.getFrameworkMaven()).style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)))),
        OTHER(Collections.singletonList(Message.of((String)"Other").style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY))));

        final private List<Message> text;

        private UnsupportedReason(List<Message> text) {
            this.text = text;
        }

        public List<Message> getText() {
            return this.text;
        }
    }
}

