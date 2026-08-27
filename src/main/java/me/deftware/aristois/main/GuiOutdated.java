/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.chat.ChatMessage
 *  me.deftware.client.framework.chat.LiteralChatMessage
 *  me.deftware.client.framework.chat.style.ChatColors
 *  me.deftware.client.framework.fonts.FontRenderer
 *  me.deftware.client.framework.gui.GuiScreen
 *  me.deftware.client.framework.gui.widgets.Button
 *  me.deftware.client.framework.gui.widgets.GenericComponent
 *  me.deftware.client.framework.input.Keyboard
 */
package me.deftware.aristois.main;

import java.util.Arrays;
import java.util.List;
import me.deftware.client.framework.chat.ChatMessage;
import me.deftware.client.framework.chat.LiteralChatMessage;
import me.deftware.client.framework.chat.style.ChatColors;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.gui.widgets.GenericComponent;
import me.deftware.client.framework.input.Keyboard;

public class GuiOutdated
extends GuiScreen {
    public static List<LiteralChatMessage> text = Arrays.asList(new LiteralChatMessage("Aristois no longer supports this Minecraft version"), new LiteralChatMessage("You can reinstall Aristois from aristois.net/download."), new LiteralChatMessage(""), new LiteralChatMessage("If you want to continue using this version"), new LiteralChatMessage("you can install the latest major version of"), new LiteralChatMessage("Aristois, then install multiconnect in ESC > Addons."), new LiteralChatMessage(""), new LiteralChatMessage("Multiconnect will allow you to join this version of Minecraft"), new LiteralChatMessage("with a newer and supported version of Minecraft."));

    protected void onInitGui() {
        int buttonWidth = 150;
        this.addComponent((GenericComponent)Button.create(1, (int)(this.getGuiScreenWidth() / 2 - buttonWidth / 2), (int)(this.getGuiScreenHeight() - 35), (int)buttonWidth, 20, (ChatMessage)new LiteralChatMessage("Update", ChatColors.GREEN), (boolean)true, btn -> {
            Keyboard.openLink((String)"https://aristois.net/download");
            return true;
        }));
        this.addCenteredText(this.getGuiScreenWidth() / 2, 20, (ChatMessage)new LiteralChatMessage("Warning! Unsupported Minecraft version!!", ChatColors.RED));
        int y = 45;
        for (LiteralChatMessage line : text) {
            this.addCenteredText(this.getGuiScreenWidth() / 2, y, (ChatMessage)line);
            y += FontRenderer.getFontHeight() + 2;
        }
    }

    protected void onDraw(int mouseX, int mouseY, float partialTicks) {
    }
}

