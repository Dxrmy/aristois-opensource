package me.deftware.aristois.recovered;

import me.deftware.aristois.main.Main;
import me.deftware.aristois.menu.view.dialog.DialogWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0434 extends DialogWidget {
   private final FontRenderStack f_67afde7a = this.f_02ea293d.m_d996e5c5();
   private final double f_6e3794e6 = 20.0;
   private Message[] f_c0f59c75;

   public C0434(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.setRenderBackground(true);
      this.setResizable(false);
      this.setDraggable(false);
      DefaultColors var10 = DefaultColors.YELLOW;
      this.m_eb5ceeb6(
         Message.of(C0262.m_c04d8f6e()),
         new Builder()
            .append(C0262.m_2dc36b02(), Appearance.of(var10))
            .append(C0262.m_4cbaf16f())
            .append(C0262.m_678c4ddb(), Appearance.of(var10))
            .append(C0262.m_1672ac4d())
            .append(C0262.m_e9a52709())
            .build(),
         new Builder()
            .append(C0262.m_37c08c9d())
            .append(C0262.m_1472ab32(), Appearance.of(var10))
            .append(C0262.m_a5b24d28())
            .append(C0262.m_678c4ddb(), Appearance.of(var10))
            .append(C0262.m_a9b6ecd9())
            .build(),
         new Builder().append(C0262.m_09052c0b()).append(C0262.m_023b99d9(), Appearance.of(var10)).append(C0262.m_733bff3d()).build(),
         new Builder().append(C0267.m_27479cfa()).append(C0262.m_76700429(), Appearance.of(var10)).append(C0262.m_8870d2c1()).build(),
         C0197.f_9607505d,
         new Builder()
            .append(C0262.m_a004d745())
            .append(C0262.m_0223faff(), Appearance.of(var10))
            .append(C0262.m_3c19a819())
            .append(C0262.m_f599ae93(), Appearance.of(var10))
            .append(C0262.m_5b2d5cb2())
            .build(),
         new Builder().append(C0262.m_56cd5284(), Appearance.of(var10)).append(C0262.m_62895921()).build()
      );
   }

   public void m_eb5ceeb6(Message... var1) {
      this.f_c0f59c75 = var1;
   }

   @Override
   public DialogWidget setupComponents(Message var1) {
      super.setupComponents(var1);
      this.title.setDrawExitButton(false);
      ButtonWidget var2 = new ButtonWidget(0.0, 0.0, 100.0, Message.of(C0262.m_ec4ef19a()), this.f_02ea293d) {
         @Override
         protected void onClick(int var1) {
         }

         @Override
         public boolean m_a2722fba(double var1, double var3, int var5) {
            if (this.f_7fd3d7b7.m_a58797d6(var1, var3) && var5 == 0) {
               Main.getConfig().putPrimitive(C0253.m_cf4f91f1(), true);
               Main.getConfig().save();
               C0434.this.close();
            }

            return false;
         }
      };
      var2.setTextAlign(C0427.f_b1ff7fe9);
      var2.m_44bb072f()
         .m_f8b16cfb(this.f_7fd3d7b7.m_4388ac29() - var2.m_44bb072f().m_4388ac29() - 20.0, this.f_7fd3d7b7.m_d42f3372() - var2.m_44bb072f().m_d42f3372() - 20.0);
      this.m_cb54a800(new C0163[]{var2});
      return this;
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      var6 = super.m_572d14e6(var1, var3, var5, var6);
      if (this.f_c0f59c75 != null) {
         double var7 = this.f_7fd3d7b7.m_a005efae() + 20.0;
         double var9 = this.f_7fd3d7b7.m_84808068() + this.title.m_44bb072f().m_d42f3372() + 20.0;
         this.f_67afde7a.begin();

         for (Message var14 : this.f_c0f59c75) {
            this.f_67afde7a.drawString(var7, var9, var14);
            var9 += (double)this.f_67afde7a.getFontHeight();
         }

         this.f_67afde7a.end();
      }

      return var6;
   }
}
