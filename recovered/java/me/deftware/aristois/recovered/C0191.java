package me.deftware.aristois.recovered;

import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0191 extends GuiScreen {
   private int f_a044977e = 100;

   public C0191() {
   }

   protected boolean goBack() {
      return true;
   }

   protected void onInitGui() {
      Message var1 = Message.of(C0267.m_c42f1c7e());
      this.addComponent(new C0154(this.getGuiScreenWidth() - FontRenderer.getStringWidth(var1) - 17, 10, FontRenderer.getStringWidth(var1) + 10, 20, var1) {
         @Override
         public boolean m_1521b1fa(int var1) {
            C0191.super.goBack();
            return true;
         }
      });
      this.addCenteredText(this.getGuiScreenWidth() / 2, 20, Message.of(C0267.m_760db7bb()));
      this.addText(30, 45, Message.of(C0267.m_68957b31()).style(Appearance.of(8, DefaultColors.AQUA)));
      this.addText(30, 60, new Builder().append(C0267.m_4e02e7a9()).append(C0267.m_7f74d855(), Appearance.of(DefaultColors.AQUA)).build());
      this.addText(
         30, 70, new Builder().append(C0267.m_b89b7876()).append(C0267.m_a33fab52(), Appearance.of(DefaultColors.AQUA)).append(C0267.m_73708dd3()).build()
      );
      this.addText(
         30, 80, new Builder().append(C0267.m_96ba50d4()).append(C0267.m_88726494(), Appearance.of(DefaultColors.AQUA)).append(C0267.m_73708dd3()).build()
      );
      this.addText(
         30, 90, new Builder().append(C0267.m_27479cfa()).append(C0267.m_23f794da(), Appearance.of(DefaultColors.AQUA)).append(C0267.m_cc27b633()).build()
      );
      this.addText(30, 115, new Builder().append(C0267.m_df6e621c(), Appearance.of(8, DefaultColors.AQUA)).build());
      this.addText(
         30, 130, new Builder().append(C0267.m_56242a84()).append(C0267.m_9e27f038(), Appearance.of(DefaultColors.AQUA)).append(C0267.m_af41331f()).build()
      );
      this.addText(
         30, 140, new Builder().append(C0267.m_f257bcca()).append(C0267.m_d9b37a36(), Appearance.of(DefaultColors.AQUA)).append(C0267.m_15737526()).build()
      );
      this.addText(30, 165, new Builder().append(C0267.m_6cf615ba(), Appearance.of(8, DefaultColors.AQUA)).build());
      this.addText(
         30, 180, new Builder().append(C0267.m_ecb46027()).append(C0267.m_b526dd3b(), Appearance.of(DefaultColors.AQUA)).append(C0267.m_9d6ca6d0()).build()
      );
      this.addText(
         30, 190, new Builder().append(C0267.m_87c16989()).append(C0267.m_b0896de7(), Appearance.of(DefaultColors.AQUA)).append(C0267.m_593ecbab()).build()
      );
      this.addText(30, 200, new Builder().append(C0267.m_17d51275()).append(C0267.m_00ba16c2(), Appearance.of(DefaultColors.AQUA)).build());
   }

   protected void onDraw(int var1, int var2, float var3) {
   }

   protected void onUpdate() {
      if (this.f_a044977e > 0) {
         this.f_a044977e--;
      }

      Button var1 = (Button)this.getMinecraftScreen().getFirstOfType(Button.class);
      var1.setComponentLabel(
         Message.of(C0267.m_d1f7b79f() + (this.f_a044977e > 0 ? C0267.m_a29090eb() + this.f_a044977e / 20 + C0257.m_9e27f038() : C0267.m_b2dd5137()))
      );
      var1.setActive(this.f_a044977e <= 0);
   }
}
