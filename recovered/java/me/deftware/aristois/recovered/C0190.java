package me.deftware.aristois.recovered;

import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.GuiScreen.BackgroundType;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0190 extends GuiScreen {
   private final C0245 f_1400665c;
   private int f_25263fda = -1;

   public C0190(C0245 var1, GenericScreen var2) {
      super(var2);
      this.setBackgroundType(BackgroundType.TexturedOrTransparent);
      this.f_1400665c = var1;
   }

   protected void onInitGui() {
      this.addCenteredText(this.getGuiScreenWidth() / 2, this.getGuiScreenHeight() / 2 - FontRenderer.getFontHeight() / 2, Message.of(C0267.m_d597c122()));
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2 - FontRenderer.getFontHeight() / 2 + FontRenderer.getFontHeight() + 5,
         Message.of(C0267.m_18204724() + this.f_1400665c.toString())
      );
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2
            - FontRenderer.getFontHeight() / 2
            + FontRenderer.getFontHeight()
            + 5
            + FontRenderer.getFontHeight()
            + 5
            + FontRenderer.getFontHeight()
            + 5,
         Message.of(C0267.m_cf4f91f1())
      );
   }

   protected void onDraw(int var1, int var2, float var3) {
   }

   private void m_b8629bc5(int var1, int var2, int var3) {
      if (var1 != 256 && var1 != -1) {
         if (var1 == 259) {
            this.f_1400665c.m_1058ed9a();
            C0064.m_13c9ffeb().m_2c2620fc(C0267.m_b251ca51()).m_ee04ba1b(C0266.m_6e2d03c3()).m_1058ed9a();
         } else {
            this.f_1400665c.m_46938bdb(var1);
            this.f_1400665c.m_7c7fe86a(var3);
            Message var4 = new Builder()
               .append(C0267.m_b48a8bc4(), Appearance.of(DefaultColors.GRAY))
               .append(this.f_1400665c.toString(), Appearance.of(DefaultColors.YELLOW))
               .build();
            C0064.m_13c9ffeb().m_2c2620fc(C0267.m_b251ca51()).m_f41992de(var4).m_1058ed9a();
         }

         this.goBack();
      }
   }

   protected boolean onKeyPressed(int var1, int var2, int var3) {
      this.f_25263fda = var1;
      return true;
   }

   protected boolean onKeyReleased(int var1, int var2, int var3) {
      if (this.f_25263fda == var1) {
         this.m_b8629bc5(var1, var2, var3);
      }

      return true;
   }

   protected boolean onMouseClicked(int var1, int var2, int var3) {
      this.m_b8629bc5(var3, 0, m_5b3d3148());
      return true;
   }

   public static int m_5b3d3148() {
      byte var0 = 0;
      if (Keyboard.isCtrlPressed()) {
         var0 = 2;
      } else if (Keyboard.isShiftPressed()) {
         var0 = 1;
      }

      return var0;
   }
}
