package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public abstract class C0169 extends C0195 {
   public C0169(GenericScreen var1, Message... var2) {
      super(var1, var2);
   }

   protected void m_c42948dd() {
      short var1 = 150;
      byte var2 = 10;
      int var3 = this.getGuiScreenWidth() / 2 - (var1 * 2 + var2) / 2;
      this.m_2d156f1a(
         new C0163[]{
            this.f_c93198f3 = this.m_4abf49f6(
               var3, this.getGuiScreenHeight() - 40, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869310>()), this::goBack
            ),
            this.m_4abf49f6(
               var3 + var1 + var2,
               this.getGuiScreenHeight() - 40,
               (float)var1,
               C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.RED)),
               this::m_f10a9ffc
            )
         }
      );
   }

   public abstract void m_f10a9ffc();
}
