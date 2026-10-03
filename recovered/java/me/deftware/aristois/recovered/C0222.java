package me.deftware.aristois.recovered;

import me.deftware.client.framework.render.gl.GLX;

public abstract class C0222 {
   protected double f_886bc86a = 180.0;
   protected double f_8d2ab004 = 0.0;
   protected boolean f_b19161b6 = false;
   protected final C0165 f_b430ef15 = new C0165();
   protected double f_6d154f7a = 0.0;
   private final C0233 f_45dc4b3b = new C0233(110.0F, 33.0) {
      protected void m_3cff2634(double var1) {
         double var3 = !C0222.this.f_b19161b6 ? 1.0 - var1 : var1;
         C0222.this.f_6d154f7a = C0222.this.f_8d2ab004 + C0222.this.f_886bc86a * var3;
      }
   };

   public C0222() {
   }

   public void m_bde3528d(double var1) {
      this.f_8d2ab004 = this.f_6d154f7a = var1;
   }

   public void m_ca42edf7(double var1, double var3, float var5) {
      this.f_45dc4b3b.m_61a5f120(var5);
      double var6 = this.f_b430ef15.m_14f8bc2c();
      double var8 = this.f_b430ef15.m_5a998971();
      double var10 = this.f_b430ef15.m_830cb294();
      double var12 = this.f_b430ef15.m_fc7f45bc();
      var6 *= (double)C0114.bootstrap<"call",0,1>();
      var8 *= (double)C0114.bootstrap<"call",0,1>();
      var10 *= (double)C0114.bootstrap<"call",0,1>();
      var12 *= (double)C0114.bootstrap<"call",0,1>();
      GLX.INSTANCE.push();
      double var14 = var6 + var10 / 2.0;
      double var16 = var8 + var12 / 2.0;
      GLX.INSTANCE.translate(var14, var16, 1.0);
      GLX.INSTANCE.rotate(this.f_6d154f7a, 0.0, 0.0, 1.0);
      GLX.INSTANCE.translate(-var14, -var16, 1.0);
      this.m_d915398d(var6, var8, var10, var12);
      GLX.INSTANCE.pop();
   }

   public void m_dcc9a738() {
      this.f_b19161b6 = !this.f_b19161b6;
      this.f_45dc4b3b.m_bb3577b4();
   }

   protected abstract void m_d915398d(double var1, double var3, double var5, double var7);

   public void m_f7e1b7d6(double var1) {
      this.f_886bc86a = var1;
   }

   public double m_9779856e() {
      return this.f_8d2ab004;
   }

   public boolean m_ba8958be() {
      return this.f_b19161b6;
   }

   public C0165 m_66b8456f() {
      return this.f_b430ef15;
   }

   public C0233 m_b73d9bc8() {
      return this.f_45dc4b3b;
   }
}
