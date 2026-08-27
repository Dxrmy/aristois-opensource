/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.fonts.FontRenderer
 *  me.deftware.client.framework.gui.GuiScreen
 *  me.deftware.client.framework.gui.widgets.Button
 *  me.deftware.client.framework.gui.widgets.GenericComponent
 *  me.deftware.client.framework.input.Keyboard
 *  me.deftware.client.framework.message.Appearance
 *  me.deftware.client.framework.message.Appearance$FormattingColor
 *  me.deftware.client.framework.message.DefaultColors
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.message.Message$Builder
 */
package me.deftware.aristois.main;

import \u0000nunyaboolean.catch.for.implements.boolean;
import java.util.Arrays;
import java.util.List;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.gui.widgets.GenericComponent;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class GuiOutdatedModern
extends GuiScreen {
    public static List<Message> text = Arrays.asList(Message.of((String)"Aristois no longer supports this Minecraft version"), Message.of((String)"You can reinstall Aristois from aristois.net/download."), boolean.assert\u00a0new, Message.of((String)"If you want to continue using this version"), Message.of((String)"you can install the latest major version of"), Message.of((String)"Aristois, then install multiconnect in ESC > Addons."), boolean.assert\u00a0new, Message.of((String)"Multiconnect will allow you to join this version of Minecraft"), Message.of((String)"with a newer and supported version of Minecraft."));

    protected void onInitGui() {
        int buttonWidth = 150;
        this.addComponent((GenericComponent)Button.create(1, (int)(this.getGuiScreenWidth() / 2 - buttonWidth / 2), (int)(this.getGuiScreenHeight() - 35), (int)buttonWidth, 20, (Message)Message.of((String)"Update").style(Appearance.of(8, (Appearance.FormattingColor)DefaultColors.GREEN)), (boolean)true, btn -> {
            Keyboard.openLink((String)"https://aristois.net/download");
            return true;
        }));
        this.addCenteredText(this.getGuiScreenWidth() / 2, 20, new Message.Builder().append("Warning!", Appearance.of(2, (Appearance.FormattingColor)DefaultColors.RED)).append(" Unsupported Minecraft version", Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)).build());
        int y = 45;
        for (Message line : text) {
            this.addCenteredText(this.getGuiScreenWidth() / 2, y, line);
            y += FontRenderer.getFontHeight() + 2;
        }
    }

    protected void onDraw(int mouseX, int mouseY, float partialTicks) {
    }
}

