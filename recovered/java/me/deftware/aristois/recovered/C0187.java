package me.deftware.aristois.recovered;

import java.awt.Color;

public class C0187 extends C0185 {
   private final C0244 f_b798ff7c;

   public C0187(C0186 var1, C0244 var2) {
      super(var1);
      this.f_b798ff7c = var2;
   }

   @Override
   protected void m_1058ed9a() {
      this.f_64f4a2c5 = C0254.m_bdbd5e40();
      this.f_9de1b0db = C0254.m_19faa493();
      super.m_1058ed9a();
   }

   @Override
   protected void m_f1ec3ae8() {
      this.f_9160ab3f.m_333019c8(String.valueOf(Math.round((float)this.f_b798ff7c.m_36ffc578())));
      this.f_a74fb56c.m_333019c8(String.valueOf(Math.round((float)this.f_b798ff7c.m_a135e825())));
      this.f_e44a6836.m_333019c8(String.valueOf(Math.round((float)this.f_b798ff7c.m_f34ec3cf())));
      this.f_069ab5b9.m_333019c8(this.f_b798ff7c.m_c688f8ca());
      this.f_928d78c2.m_6e0baed2(new Color(this.f_b798ff7c.m_8b15b5f4(), true));
   }

   @Override
   protected void m_0e265701() {
      this.m_1c2178b4(this.f_b798ff7c);
      this.goBack();
   }
}
