package me.deftware.aristois.main;

import java.util.Arrays;
import java.util.List;
import me.deftware.aristois.recovered.C0197;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class GuiOutdatedModern extends GuiScreen {
   public static List<Message> text = Arrays.asList(
      Message.of("Aristois no longer supports this Minecraft version"),
      Message.of("You can reinstall Aristois from aristois.net/download."),
      C0197.f_716a73fa,
      Message.of("If you want to continue using this version"),
      Message.of("you can install the latest major version of"),
      Message.of("Aristois, then install multiconnect in ESC > Addons."),
      C0197.f_716a73fa,
      Message.of("Multiconnect will allow you to join this version of Minecraft"),
      Message.of("with a newer and supported version of Minecraft.")
   );

   public GuiOutdatedModern() {
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
            Message.of("Update").style(Appearance.of(8, DefaultColors.GREEN)),
            true,
            btn -> {
               Keyboard.openLink("https://aristois.net/download");
               return true;
            }
         )
      );
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         20,
         new Builder()
            .append("Warning!", Appearance.of(2, DefaultColors.RED))
            .append(" Unsupported Minecraft version", Appearance.of(DefaultColors.GRAY))
            .build()
      );
      int y = 45;

      for (Message line : text) {
         this.addCenteredText(this.getGuiScreenWidth() / 2, y, line);
         y += FontRenderer.getFontHeight() + 2;
      }
   }

   protected void onDraw(int mouseX, int mouseY, float partialTicks) {
   }
}
