package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Arrays;
import java.util.Comparator;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.LineRenderStack;

public class C0153 implements C0194 {
   protected C0165 f_b7c46df7 = new C0165();
   protected C0165 f_24dfcf5a;
   protected Message[] f_6e7fe8d3;
   protected double f_ebce9b12 = 3.0;
   private LineRenderStack f_a400b1c0 = new LineRenderStack();

   public C0153(C0163 var1, Message... var2) {
      this(var1.m_44bb072f(), var2);
   }

   public C0153(C0165 var1, Message... var2) {
      this.f_6e7fe8d3 = var2;
      this.f_24dfcf5a = var1;
      this.m_1058ed9a();
   }

   @Override
   public void m_1058ed9a() {
      this.f_b7c46df7
         .m_6fd9bdae(
            (double)this.m_4096be4e(
               Arrays.stream(this.f_6e7fe8d3).max(Comparator.comparingInt(this::m_4096be4e)).orElseThrow(() -> new RuntimeException(C0267.m_76700429()))
            )
         );
      this.f_b7c46df7.m_61ade8f3(this.m_20206c69() * (double)this.f_6e7fe8d3.length);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      double var7 = 6.0;
      if (this.f_24dfcf5a.m_a58797d6(var1, var3) && !var6) {
         var1 = this.m_31bcc3d1(var1, var7);
         this.m_7b35c96a(var1, var3, var1 + this.f_b7c46df7.m_4388ac29(), var3 + this.f_b7c46df7.m_d42f3372());

         for (Message var12 : this.f_6e7fe8d3) {
            this.m_af7f1db9(var12, (int)var1, (int)var3);
            var3 += this.m_20206c69();
         }
      }

      return var6;
   }

   @Override
   public void m_394ecb95(boolean var1) {
      this.f_a400b1c0.setScaled(var1);
   }

   protected double m_31bcc3d1(double var1, double var3) {
      if (var1 + this.f_b7c46df7.m_4388ac29() + this.f_ebce9b12 + var3 * 2.0 > (double)GuiScreen.getScaledWidth()) {
         var1 -= this.f_b7c46df7.m_4388ac29() + var3 + this.f_ebce9b12;
      } else {
         var1 += var3 * 2.0 + this.f_ebce9b12;
      }

      return var1;
   }

   protected int m_4096be4e(Message var1) {
      return FontRenderer.getStringWidth(var1);
   }

   protected double m_20206c69() {
      return (double)FontRenderer.getFontHeight();
   }

   protected void m_af7f1db9(Message var1, int var2, int var3) {
      FontRenderer.drawStringWithShadow(var1, var2, var3, 16777215);
   }

   protected void m_7b35c96a(double var1, double var3, double var5, double var7) {
      var1 -= this.f_ebce9b12;
      var3 -= this.f_ebce9b12;
      var5 += this.f_ebce9b12;
      var7 += this.f_ebce9b12;
      this.f_a400b1c0.glColor(Color.DARK_GRAY);
      this.f_a400b1c0.begin(1);
      double var9 = var5 - this.f_ebce9b12;
      double var11 = var7 - this.f_ebce9b12;

      for (int var13 = 0; var13 < 360; var13++) {
         if (var13 == 90) {
            var11 = var3 + this.f_ebce9b12;
         } else if (var13 == 180) {
            var9 = var1 + this.f_ebce9b12;
         } else if (var13 == 270) {
            var11 = var7 - this.f_ebce9b12;
         }

         this.f_a400b1c0.vertex(var9, var11);
         this.f_a400b1c0
            .vertex(var9 + Math.sin(Math.toRadians((double)var13)) * this.f_ebce9b12, var11 + Math.cos(Math.toRadians((double)var13)) * this.f_ebce9b12);
      }

      this.f_a400b1c0.end();
      this.f_a400b1c0.begin(7);
      this.f_a400b1c0.vertex(var5 - this.f_ebce9b12, var3);
      this.f_a400b1c0.vertex(var1 + this.f_ebce9b12, var3);
      this.f_a400b1c0.vertex(var1 + this.f_ebce9b12, var7);
      this.f_a400b1c0.vertex(var5 - this.f_ebce9b12, var7);
      this.f_a400b1c0.vertex(var5, var3 + this.f_ebce9b12);
      this.f_a400b1c0.vertex(var1, var3 + this.f_ebce9b12);
      this.f_a400b1c0.vertex(var1, var7 - this.f_ebce9b12);
      this.f_a400b1c0.vertex(var5, var7 - this.f_ebce9b12);
      this.f_a400b1c0.end();
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_b7c46df7;
   }

   public C0165 m_7847f733() {
      return this.f_24dfcf5a;
   }

   public Message[] m_29e309e8() {
      return this.f_6e7fe8d3;
   }

   public double m_b199d4ff() {
      return this.f_ebce9b12;
   }

   public LineRenderStack m_c1a09faa() {
      return this.f_a400b1c0;
   }

   public void m_9ee17df4(C0165 var1) {
      this.f_b7c46df7 = var1;
   }

   public void m_8a961734(C0165 var1) {
      this.f_24dfcf5a = var1;
   }

   public void m_eb5ceeb6(Message[] var1) {
      this.f_6e7fe8d3 = var1;
   }

   public void m_4b04f920(double var1) {
      this.f_ebce9b12 = var1;
   }

   public void m_1efe5872(LineRenderStack var1) {
      this.f_a400b1c0 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0153)) {
         return false;
      } else {
         C0153 var2 = (C0153)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else if (Double.compare(this.m_b199d4ff(), var2.m_b199d4ff()) != 0) {
            return false;
         } else {
            C0165 var3 = this.m_44bb072f();
            C0165 var4 = var2.m_44bb072f();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0165 var5 = this.m_7847f733();
               C0165 var6 = var2.m_7847f733();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  if (!Arrays.deepEquals(this.m_29e309e8(), var2.m_29e309e8())) {
                     return false;
                  } else {
                     LineRenderStack var7 = this.m_c1a09faa();
                     LineRenderStack var8 = var2.m_c1a09faa();
                     return var7 == null ? var8 == null : var7.equals(var8);
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
      return var1 instanceof C0153;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      long var3 = Double.doubleToLongBits(this.m_b199d4ff());
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      C0165 var5 = this.m_44bb072f();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      C0165 var6 = this.m_7847f733();
      var2 = var2 * 59 + (var6 == null ? 43 : var6.hashCode());
      var2 = var2 * 59 + Arrays.deepHashCode(this.m_29e309e8());
      LineRenderStack var7 = this.m_c1a09faa();
      return var2 * 59 + (var7 == null ? 43 : var7.hashCode());
   }

   @Override
   public String toString() {
      return C0267.m_09052c0b()
         + this.m_44bb072f()
         + C0267.m_4cbaf16f()
         + this.m_7847f733()
         + C0267.m_023b99d9()
         + Arrays.deepToString(this.m_29e309e8())
         + C0267.m_8ccfdf29()
         + this.m_b199d4ff()
         + C0267.m_733bff3d()
         + this.m_c1a09faa()
         + C0257.m_9e27f038();
   }
}
