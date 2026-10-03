package me.deftware.aristois.main;

import java.util.Arrays;
import java.util.List;
import me.deftware.client.framework.chat.LiteralChatMessage;
import me.deftware.client.framework.chat.style.ChatColors;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.input.Keyboard;

public class GuiOutdated extends GuiScreen {
   public static List<LiteralChatMessage> text = Arrays.asList(
      new LiteralChatMessage("Aristois no longer supports this Minecraft version"),
      new LiteralChatMessage("You can reinstall Aristois from aristois.net/download."),
      new LiteralChatMessage(""),
      new LiteralChatMessage("If you want to continue using this version"),
      new LiteralChatMessage("you can install the latest major version of"),
      new LiteralChatMessage("Aristois, then install multiconnect in ESC > Addons."),
      new LiteralChatMessage(""),
      new LiteralChatMessage("Multiconnect will allow you to join this version of Minecraft"),
      new LiteralChatMessage("with a newer and supported version of Minecraft.")
   );

   public GuiOutdated() {
   }

   protected void onInitGui() {
      int buttonWidth = 150;
      this.addComponent(
         Button.create(
            1,
            this.getGuiScreenWidth() / 2 - buttonWidth / 2,
            this.getGuiScreenHeight() - 35,
            buttonWidth,
            20,
            new LiteralChatMessage("Update", ChatColors.GREEN),
            true,
            btn -> {
               Keyboard.openLink("https://aristois.net/download");
               return true;
            }
         )
      );
      this.addCenteredText(this.getGuiScreenWidth() / 2, 20, new LiteralChatMessage("Warning! Unsupported Minecraft version!!", ChatColors.RED));
      int y = 45;

      for (LiteralChatMessage line : text) {
         this.addCenteredText(this.getGuiScreenWidth() / 2, y, line);
         y += FontRenderer.getFontHeight() + 2;
      }
   }

   protected void onDraw(int mouseX, int mouseY, float partialTicks) {
   }
}
