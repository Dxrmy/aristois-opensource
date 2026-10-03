package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.screens.GenericScreen;

public class C0173 extends C0171 {
   private final C0268 f_d510e4e8;

   public C0173(GenericScreen var1, C0268 var2) {
      super(var1);
      this.f_d510e4e8 = var2;
   }

   protected void m_0d417b4e() {
      this.f_e72b906f = C0252.bootstrap<"get",21474836572>();
      this.f_41d7f853 = C0252.bootstrap<"get",21474836563>();
      super.m_3c18b79c();
      this.f_465c1210.m_63ef8c45(this.f_d510e4e8.m_8ccabf49());
      this.f_2c77a795.m_84cbfc35(this.f_d510e4e8.m_9d73c835());
      this.f_eb2665bd.m_84cbfc35(this.f_d510e4e8.m_1921cf88());
   }

   protected void m_c0befa40() {
      this.m_ce8f1ded(this.f_d510e4e8);
      this.goBack();
   }
}
