package me.deftware.aristois.recovered;

import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;

public abstract class C0222 {
   protected double f_ef84fdfb = 180.0;
   protected double f_11a042fe = 0.0;
   protected boolean f_89c83b12 = false;
   protected final C0165 f_274192a2 = new C0165();
   protected double f_7013f599 = 0.0;
   private final C0233 f_5476b6ba = new C0233(110.0F, 33.0) {
      @Override
      protected void m_560d077c(double var1) {
         double var3 = !C0222.this.f_89c83b12 ? 1.0 - var1 : var1;
         C0222.this.f_7013f599 = C0222.this.f_11a042fe + C0222.this.f_ef84fdfb * var3;
      }
   };

   public C0222() {
   }

   public void m_4b04f920(double var1) {
      this.f_11a042fe = this.f_7013f599 = var1;
   }

   public void m_9d486ef7(double var1, double var3, float var5) {
      this.f_5476b6ba.m_d881d3e3(var5);
      double var6 = this.f_274192a2.m_a005efae();
      double var8 = this.f_274192a2.m_84808068();
      double var10 = this.f_274192a2.m_4388ac29();
      double var12 = this.f_274192a2.m_d42f3372();
      var6 *= (double)RenderStack.getScale();
      var8 *= (double)RenderStack.getScale();
      var10 *= (double)RenderStack.getScale();
      var12 *= (double)RenderStack.getScale();
      GLX.INSTANCE.push();
      double var14 = var6 + var10 / 2.0;
      double var16 = var8 + var12 / 2.0;
      GLX.INSTANCE.translate(var14, var16, 1.0);
      GLX.INSTANCE.rotate(this.f_7013f599, 0.0, 0.0, 1.0);
      GLX.INSTANCE.translate(-var14, -var16, 1.0);
      this.m_7b35c96a(var6, var8, var10, var12);
      GLX.INSTANCE.pop();
   }

   public void m_1058ed9a() {
      this.f_89c83b12 = !this.f_89c83b12;
      this.f_5476b6ba.m_41e83f88();
   }

   protected abstract void m_7b35c96a(double var1, double var3, double var5, double var7);

   public void m_7c9e279f(double var1) {
      this.f_ef84fdfb = var1;
   }

   public double m_84808068() {
      return this.f_11a042fe;
   }

   public boolean m_89e0519f() {
      return this.f_89c83b12;
   }

   public C0165 m_44bb072f() {
      return this.f_274192a2;
   }

   public C0233 m_acb8f086() {
      return this.f_5476b6ba;
   }
}
