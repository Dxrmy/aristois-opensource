package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0181 implements C0441 {
   private final FontRenderStack f_5836659f = new FontRenderStack(C0231.f_33373362);
   private Color f_dde6ffce = Color.cyan;
   private Color f_0104772f = Color.WHITE;
   private Color f_ffe4a70c = Color.white;
   private Color f_b36e0c43 = new Color(44, 44, 47, 77);
   private Color f_b3fea367 = new Color(45, 62, 80, 245).darker().darker();
   private Color f_ba3b1d99 = this.f_b36e0c43.brighter();
   private Color f_94c912a4 = new Color(65, 192, 121);
   private Color f_1f3aa7a6 = this.f_b36e0c43.brighter().brighter();
   private double f_7bb02e35 = 15.0;
   private double f_52d0c53e = 10.0;
   private boolean f_f1d1532a = true;
   private int f_2010963d = 5;
   private String f_c684a7af = C0261.m_593ecbab();
   private C0102<C0427> f_7a65ab46 = new C0102<>(C0427.f_26bd24ae);
   private long f_83b27ab7 = 170L;

   public C0181() {
   }

   @Override
   public FontRenderStack m_d996e5c5() {
      return this.f_5836659f;
   }

   @Override
   public Color m_0a0c8c22() {
      return this.f_dde6ffce;
   }

   @Override
   public Color m_f6c8a26c() {
      return this.f_0104772f;
   }

   @Override
   public Color m_303ad3a1() {
      return this.f_ffe4a70c;
   }

   @Override
   public Color m_d812cfb6() {
      return this.f_b36e0c43;
   }

   @Override
   public Color m_ac758c94() {
      return this.f_b3fea367;
   }

   @Override
   public Color m_98b03f4f() {
      return this.f_ba3b1d99;
   }

   @Override
   public Color m_e1729432() {
      return this.f_94c912a4;
   }

   @Override
   public Color m_4a97268d() {
      return this.f_1f3aa7a6;
   }

   @Override
   public double m_b2213d56() {
      return this.f_7bb02e35;
   }

   @Override
   public double m_036bd5c5() {
      return this.f_52d0c53e;
   }

   @Override
   public boolean m_f7b07982() {
      return this.f_f1d1532a;
   }

   @Override
   public int m_197b2fc8() {
      return this.f_2010963d;
   }

   public String m_4626ac74() {
      return this.f_c684a7af;
   }

   @Override
   public C0102<C0427> m_bfd5e3dd() {
      return this.f_7a65ab46;
   }

   @Override
   public long m_c7c6e660() {
      return this.f_83b27ab7;
   }

   @Override
   public void m_6e0baed2(Color var1) {
      this.f_dde6ffce = var1;
   }

   @Override
   public void m_29e2138c(Color var1) {
      this.f_0104772f = var1;
   }

   @Override
   public void m_049e1135(Color var1) {
      this.f_ffe4a70c = var1;
   }

   @Override
   public void m_b2bfc074(Color var1) {
      this.f_b36e0c43 = var1;
   }

   @Override
   public void m_78c0cc40(Color var1) {
      this.f_b3fea367 = var1;
   }

   @Override
   public void m_bc794843(Color var1) {
      this.f_ba3b1d99 = var1;
   }

   @Override
   public void m_80c28d0d(Color var1) {
      this.f_94c912a4 = var1;
   }

   @Override
   public void m_289e1884(Color var1) {
      this.f_1f3aa7a6 = var1;
   }

   @Override
   public void m_4b04f920(double var1) {
      this.f_7bb02e35 = var1;
   }

   @Override
   public void m_7c9e279f(double var1) {
      this.f_52d0c53e = var1;
   }

   @Override
   public void m_d6ac7420(boolean var1) {
      this.f_f1d1532a = var1;
   }

   @Override
   public void m_46938bdb(int var1) {
      this.f_2010963d = var1;
   }

   public void m_256015fc(String var1) {
      this.f_c684a7af = var1;
   }

   public void m_64c14e2f(C0102<C0427> var1) {
      this.f_7a65ab46 = var1;
   }

   @Override
   public void m_ad6c7e6f(long var1) {
      this.f_83b27ab7 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0181)) {
         return false;
      } else {
         C0181 var2 = (C0181)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else if (Double.compare(this.m_b2213d56(), var2.m_b2213d56()) != 0) {
            return false;
         } else if (Double.compare(this.m_036bd5c5(), var2.m_036bd5c5()) != 0) {
            return false;
         } else if (this.m_f7b07982() != var2.m_f7b07982()) {
            return false;
         } else if (this.m_197b2fc8() != var2.m_197b2fc8()) {
            return false;
         } else if (this.m_c7c6e660() != var2.m_c7c6e660()) {
            return false;
         } else {
            FontRenderStack var3 = this.m_d996e5c5();
            FontRenderStack var4 = var2.m_d996e5c5();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               Color var5 = this.m_0a0c8c22();
               Color var6 = var2.m_0a0c8c22();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  Color var7 = this.m_f6c8a26c();
                  Color var8 = var2.m_f6c8a26c();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     Color var9 = this.m_303ad3a1();
                     Color var10 = var2.m_303ad3a1();
                     if (var9 == null ? var10 == null : var9.equals(var10)) {
                        Color var11 = this.m_d812cfb6();
                        Color var12 = var2.m_d812cfb6();
                        if (var11 == null ? var12 == null : var11.equals(var12)) {
                           Color var13 = this.m_ac758c94();
                           Color var14 = var2.m_ac758c94();
                           if (var13 == null ? var14 == null : var13.equals(var14)) {
                              Color var15 = this.m_98b03f4f();
                              Color var16 = var2.m_98b03f4f();
                              if (var15 == null ? var16 == null : var15.equals(var16)) {
                                 Color var17 = this.m_e1729432();
                                 Color var18 = var2.m_e1729432();
                                 if (var17 == null ? var18 == null : var17.equals(var18)) {
                                    Color var19 = this.m_4a97268d();
                                    Color var20 = var2.m_4a97268d();
                                    if (var19 == null ? var20 == null : var19.equals(var20)) {
                                       String var21 = this.m_4626ac74();
                                       String var22 = var2.m_4626ac74();
                                       if (var21 == null ? var22 == null : var21.equals(var22)) {
                                          C0102 var23 = this.m_bfd5e3dd();
                                          C0102 var24 = var2.m_bfd5e3dd();
                                          return var23 == null ? var24 == null : var23.equals(var24);
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_22ad6203(Object var1) {
      return var1 instanceof C0181;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      long var3 = Double.doubleToLongBits(this.m_b2213d56());
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = Double.doubleToLongBits(this.m_036bd5c5());
      var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
      var2 = var2 * 59 + (this.m_f7b07982() ? 79 : 97);
      var2 = var2 * 59 + this.m_197b2fc8();
      long var7 = this.m_c7c6e660();
      var2 = var2 * 59 + (int)(var7 >>> 32 ^ var7);
      FontRenderStack var9 = this.m_d996e5c5();
      var2 = var2 * 59 + (var9 == null ? 43 : var9.hashCode());
      Color var10 = this.m_0a0c8c22();
      var2 = var2 * 59 + (var10 == null ? 43 : var10.hashCode());
      Color var11 = this.m_f6c8a26c();
      var2 = var2 * 59 + (var11 == null ? 43 : var11.hashCode());
      Color var12 = this.m_303ad3a1();
      var2 = var2 * 59 + (var12 == null ? 43 : var12.hashCode());
      Color var13 = this.m_d812cfb6();
      var2 = var2 * 59 + (var13 == null ? 43 : var13.hashCode());
      Color var14 = this.m_ac758c94();
      var2 = var2 * 59 + (var14 == null ? 43 : var14.hashCode());
      Color var15 = this.m_98b03f4f();
      var2 = var2 * 59 + (var15 == null ? 43 : var15.hashCode());
      Color var16 = this.m_e1729432();
      var2 = var2 * 59 + (var16 == null ? 43 : var16.hashCode());
      Color var17 = this.m_4a97268d();
      var2 = var2 * 59 + (var17 == null ? 43 : var17.hashCode());
      String var18 = this.m_4626ac74();
      var2 = var2 * 59 + (var18 == null ? 43 : var18.hashCode());
      C0102 var19 = this.m_bfd5e3dd();
      return var2 * 59 + (var19 == null ? 43 : var19.hashCode());
   }

   @Override
   public String toString() {
      return C0254.m_3d3a8736()
         + this.m_d996e5c5()
         + C0254.m_94acbdac()
         + this.m_0a0c8c22()
         + C0254.m_022da1b4()
         + this.m_f6c8a26c()
         + C0254.m_6e2d03c3()
         + this.m_303ad3a1()
         + C0254.m_760db7bb()
         + this.m_d812cfb6()
         + C0254.m_68957b31()
         + this.m_ac758c94()
         + C0254.m_4e02e7a9()
         + this.m_98b03f4f()
         + C0254.m_7f74d855()
         + this.m_e1729432()
         + C0254.m_b89b7876()
         + this.m_4a97268d()
         + C0254.m_a33fab52()
         + this.m_b2213d56()
         + C0254.m_73708dd3()
         + this.m_036bd5c5()
         + C0254.m_96ba50d4()
         + this.m_f7b07982()
         + C0254.m_88726494()
         + this.m_197b2fc8()
         + C0254.m_27479cfa()
         + this.m_4626ac74()
         + C0254.m_23f794da()
         + this.m_bfd5e3dd()
         + C0254.m_cc27b633()
         + this.m_c7c6e660()
         + C0257.m_9e27f038();
   }
}
