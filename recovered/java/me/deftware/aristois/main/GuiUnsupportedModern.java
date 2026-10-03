package me.deftware.aristois.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.deftware.aristois.recovered.C0197;
import me.deftware.aristois.recovered.C0242;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.minecraft.Minecraft;

public class GuiUnsupportedModern extends GuiScreen {
   public static List<Message> text = Arrays.asList(
      Message.of("Aristois (EMC) was unable to perform an auto update. This means you will").style(Appearance.of(DefaultColors.GRAY)),
      Message.of("need to re-download and re-install Aristois from aristois.net/download.").style(Appearance.of(DefaultColors.GRAY)),
      C0197.f_9607505d,
      new Builder()
         .append("If you proceed without updating, your game", Appearance.of(DefaultColors.GRAY))
         .append(" will be unstable.", Appearance.of(2, DefaultColors.RED))
         .append(" Do not ask for", Appearance.of(DefaultColors.GRAY))
         .build(),
      Message.of("help or support if you choose to ignore this warning!").style(Appearance.of(DefaultColors.GRAY))
   );
   public static List<Message> fixText = Arrays.asList(
      Message.of("1. Close Minecraft and open your Minecraft directory.").style(Appearance.of(DefaultColors.GRAY)),
      Message.of("2. Go into the libraries folder and delete the \"me\" folder.").style(Appearance.of(DefaultColors.GRAY)),
      Message.of("3. Start Aristois again and it *should* work.").style(Appearance.of(DefaultColors.GRAY)),
      C0197.f_9607505d,
      Message.of("If it doesn't work, visit aristois.net/guilded or try to re-install Aristois.").style(Appearance.of(DefaultColors.GRAY))
   );
   private final GuiUnsupportedModern.UnsupportedReason reason;
   private boolean debugInfo = false;

   public static void open(GuiUnsupportedModern.UnsupportedReason reason) {
      Minecraft.getMinecraftGame().openScreen(new GuiUnsupportedModern(reason));
   }

   public GuiUnsupportedModern(GuiUnsupportedModern.UnsupportedReason reason) {
      this.reason = reason;
   }

   protected void onInitGui() {
      int buttonWidth = 150;
      this.addComponent(
         Button.create(
            0,
            this.getGuiScreenWidth() / 2 - buttonWidth - 10,
            this.getGuiScreenHeight() - 35,
            buttonWidth,
            20,
            Message.of("Continue").style(Appearance.of(DefaultColors.RED)),
            true,
            btn -> {
               Main.getInstance().setup();
               ScreenRegistry.MainMenu.open(new Object[]{(GenericScreen)null});
               C0242.m_fc1b642c().m_0e265701();
               return true;
            }
         )
      );
      this.addComponent(
         Button.create(
            1,
            this.getGuiScreenWidth() / 2 + 10,
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
            .append(" Aristois was unable to perform an auto update.", Appearance.of(DefaultColors.GRAY))
            .build()
      );
      int y = 45;

      for (Message line : text) {
         this.addCenteredText(this.getGuiScreenWidth() / 2, y, line);
         y += FontRenderer.getFontHeight() + 2;
      }

      this.populateSubView(y);
   }

   private void populateSubView(int y) {
      y += FontRenderer.getFontHeight() * 2;
      Builder builder = new Builder();
      if (this.debugInfo) {
         builder.append("Debug data (Err ", Appearance.of(DefaultColors.GRAY))
            .append(this.reason.name(), Appearance.of(2, DefaultColors.RED))
            .append(")", Appearance.of(DefaultColors.GRAY));
      } else {
         builder.append("How to fix it", Appearance.of(8, DefaultColors.YELLOW));
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
      if (keyCode != 340 && keyCode != 344) {
         return super.onKeyPressed(keyCode, scanCode, modifiers);
      } else {
         this.debugInfo = !this.debugInfo;
         this.getMinecraftScreen()._clearChildren();
         this.onInitGui();
         return true;
      }
   }

   public static enum UnsupportedReason {
      EMC_INVALID_CHECKSUM(
         Arrays.asList(
            Message.of(String.format("Local checksum %s", Validator.getLocalChecksum())).style(Appearance.of(DefaultColors.GRAY)),
            Message.of(String.format("Remote checksum %s", Validator.getRemoteChecksum())).style(Appearance.of(DefaultColors.GRAY)),
            Message.of(FrameworkConstants.toDataString()).style(Appearance.of(DefaultColors.GRAY)),
            Message.of(System.getProperty("EMCDir", "Err (EMC dir not set)")).style(Appearance.of(DefaultColors.GRAY)),
            Message.of(FrameworkConstants.getFrameworkMaven()).style(Appearance.of(DefaultColors.GRAY))
         )
      ),
      OTHER(Collections.singletonList(Message.of("Other").style(Appearance.of(DefaultColors.GRAY))));

      private final List<Message> text;

      private UnsupportedReason(List<Message> text) {
         this.text = text;
      }

      public List<Message> getText() {
         return this.text;
      }
   }
}
