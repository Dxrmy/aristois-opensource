package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public abstract class C0169 extends C0195 {
   public C0169(GenericScreen var1, Message... var2) {
      super(var1, var2);
   }

   @Override
   protected void m_1058ed9a() {
      short var1 = 150;
      byte var2 = 10;
      int var3 = this.getGuiScreenWidth() / 2 - (var1 * 2 + var2) / 2;
      this.m_4f7d4126(
         new C0163[]{
            this.f_ceb7007c = this.m_79273652(var3, this.getGuiScreenHeight() - 40, (float)var1, Message.of(C0261.m_56c1229f()), this::goBack),
            this.m_79273652(
               var3 + var1 + var2,
               this.getGuiScreenHeight() - 40,
               (float)var1,
               Message.of(C0257.m_4626ac74()).style(Appearance.of(DefaultColors.RED)),
               this::m_f1ec3ae8
            )
         }
      );
   }

   public abstract void m_f1ec3ae8();
}
