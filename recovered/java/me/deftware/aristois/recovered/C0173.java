package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.screens.GenericScreen;

public class C0173 extends C0171 {
   private final C0268 f_973bbbf4;

   public C0173(GenericScreen var1, C0268 var2) {
      super(var1);
      this.f_973bbbf4 = var2;
   }

   @Override
   protected void m_1058ed9a() {
      this.f_45ed19a3 = C0254.m_fac478b2();
      this.f_8b9abab9 = C0254.m_19faa493();
      super.m_1058ed9a();
      this.f_7a8bca33.m_333019c8(this.f_973bbbf4.m_8d7dbe31());
      this.f_03900406.m_e190ec3a(this.f_973bbbf4.m_79bbc2da());
      this.f_fce448d3.m_e190ec3a(this.f_973bbbf4.m_037208cc());
   }

   @Override
   protected void m_23674f64() {
      this.m_e07ace4d(this.f_973bbbf4);
      this.goBack();
   }
}
