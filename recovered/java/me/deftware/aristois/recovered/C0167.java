package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.render.batching.CircleRenderStack;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;
import org.lwjgl.opengl.GL11;

public abstract class C0167 implements C0163 {
   protected C0165 f_454f8a85;
   protected C0163 f_344c71c7;
   private boolean f_2ce0a5ef = false;
   protected final QuadRenderStack f_4cf19435 = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private final RenderStack<CircleRenderStack> f_e1cd8e61 = (RenderStack<CircleRenderStack>)new CircleRenderStack().setScaled(false);
   private C0167.anonymousimplements f_cb3d51e2;
   private double f_cb1453f6 = 1.0;
   private double f_014ebd8a = 1.0;
   private C0153 f_f6cd69cb;
   private final C0233 f_34117694 = new C0233(60.0F, 33.0) {
      @Override
      protected void m_560d077c(double var1) {
         double var3 = !C0167.this.f_2ce0a5ef ? 1.0 - var1 : var1;
         C0167.this.f_cb1453f6 = C0167.this.f_014ebd8a * var3;
      }
   };

   public C0167(double var1, double var3, double var5, double var7, C0163 var9, C0167.anonymousimplements var10) {
      this.f_454f8a85 = new C0165(var1, var3, var5, var7);
      this.f_344c71c7 = var9;
      this.f_cb3d51e2 = var10;
      this.f_34117694.m_e83888e2(C0233.anonymousdefault.f_c8bd7ffc);
   }

   @Override
   public void m_1058ed9a() {
      double var1;
      if (this.f_cb3d51e2 != C0167.anonymousimplements.f_544b0734 && this.f_cb3d51e2 != C0167.anonymousimplements.f_3dab3aca) {
         var1 = this.f_454f8a85.m_a005efae() + this.f_454f8a85.m_4388ac29();
      } else {
         var1 = this.f_454f8a85.m_a005efae() - this.f_344c71c7.m_44bb072f().m_4388ac29();
      }

      double var3 = this.f_cb3d51e2 != C0167.anonymousimplements.f_544b0734 && this.f_cb3d51e2 != C0167.anonymousimplements.f_5c18cefe
         ? this.f_454f8a85.m_84808068()
         : this.f_454f8a85.m_84808068() - this.f_344c71c7.m_44bb072f().m_d42f3372() + this.f_454f8a85.m_d42f3372();
      this.f_344c71c7.m_44bb072f().m_f8b16cfb(var1, var3);
      this.f_344c71c7.m_1058ed9a();
      double var5 = this.f_344c71c7.m_44bb072f().m_a005efae();
      double var7 = this.f_344c71c7.m_44bb072f().m_84808068();
      double var9 = this.f_344c71c7.m_44bb072f().m_a005efae() + this.f_344c71c7.m_44bb072f().m_4388ac29();
      double var11 = this.f_344c71c7.m_44bb072f().m_84808068() + this.f_344c71c7.m_44bb072f().m_d42f3372();
      this.f_014ebd8a = Math.sqrt(Math.pow(var9 - var5, 2.0) + Math.pow(var11 - var7, 2.0)) + 30.0;
   }

   @Override
   protected abstract void m_9d486ef7(double var1, double var3, float var5);

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      this.f_34117694.m_d881d3e3(var5);
      this.m_9d486ef7(var1, var3, var5);
      if (this.f_2ce0a5ef || this.f_cb1453f6 > 1.0) {
         GLX.INSTANCE.push();
         GL11.glClear(1024);
         GL11.glEnable(2960);
         GL11.glColorMask(false, false, false, false);
         GL11.glDepthMask(false);
         GL11.glStencilFunc(519, 1, 255);
         GL11.glStencilOp(7680, 7680, 7681);
         GL11.glStencilMask(255);
         ((CircleRenderStack)((CircleRenderStack)this.f_e1cd8e61.begin()).glColor(Color.white))
            .drawFilledCircle((float)this.f_454f8a85.m_a005efae(), (float)this.f_454f8a85.m_84808068(), (float)this.f_cb1453f6)
            .end();
         GL11.glColorMask(true, true, true, true);
         GL11.glDepthMask(true);
         GL11.glStencilFunc(514, 1, 255);
         var6 = this.f_344c71c7.m_572d14e6(var1, var3, var5, var6);
         GL11.glDisable(2960);
         GLX.INSTANCE.pop();
      }

      return var6;
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      if (this.f_2ce0a5ef) {
         this.f_344c71c7.m_a2722fba(var1, var3, var5);
      }

      return false;
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      if (this.f_454f8a85.m_a58797d6(var1, var3)) {
         this.m_b728afce();
         return true;
      } else {
         if (this.f_2ce0a5ef) {
            this.f_344c71c7.m_8407b1bf(var1, var3, var5);
            if (!this.f_344c71c7.m_44bb072f().m_a58797d6(var1, var3)) {
               this.m_b728afce();
            }
         }

         return false;
      }
   }

   private void m_b728afce() {
      if (this.f_34117694.m_e606d819()) {
         this.f_2ce0a5ef = !this.f_2ce0a5ef;
         this.f_34117694.m_41e83f88();
      }
   }

   @Override
   public void m_0e265701() {
      if (this.f_2ce0a5ef) {
         this.f_344c71c7.m_0e265701();
      }
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_454f8a85;
   }

   public C0163 m_4b7a3f6e() {
      return this.f_344c71c7;
   }

   public boolean m_297cfef6() {
      return this.f_2ce0a5ef;
   }

   public QuadRenderStack m_0fae4676() {
      return this.f_4cf19435;
   }

   public RenderStack<CircleRenderStack> m_8e1ea841() {
      return this.f_e1cd8e61;
   }

   public C0167.anonymousimplements m_fff92e14() {
      return this.f_cb3d51e2;
   }

   public double m_1adf23b9() {
      return this.f_cb1453f6;
   }

   public double m_20206c69() {
      return this.f_014ebd8a;
   }

   @Override
   public C0153 m_75885561() {
      return this.f_f6cd69cb;
   }

   public void m_9ee17df4(C0165 var1) {
      this.f_454f8a85 = var1;
   }

   public void m_facdcfcf(C0163 var1) {
      this.f_344c71c7 = var1;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_2ce0a5ef = var1;
   }

   public void m_37f26b7a(C0167.anonymousimplements var1) {
      this.f_cb3d51e2 = var1;
   }

   public void m_4b04f920(double var1) {
      this.f_cb1453f6 = var1;
   }

   public void m_7c9e279f(double var1) {
      this.f_014ebd8a = var1;
   }

   @Override
   public void m_c7a3618c(C0153 var1) {
      this.f_f6cd69cb = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0167)) {
         return false;
      } else {
         C0167 var2 = (C0167)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else if (this.m_297cfef6() != var2.m_297cfef6()) {
            return false;
         } else if (Double.compare(this.m_1adf23b9(), var2.m_1adf23b9()) != 0) {
            return false;
         } else if (Double.compare(this.m_20206c69(), var2.m_20206c69()) != 0) {
            return false;
         } else {
            C0165 var3 = this.m_44bb072f();
            C0165 var4 = var2.m_44bb072f();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0163 var5 = this.m_4b7a3f6e();
               C0163 var6 = var2.m_4b7a3f6e();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  QuadRenderStack var7 = this.m_0fae4676();
                  QuadRenderStack var8 = var2.m_0fae4676();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     RenderStack var9 = this.m_8e1ea841();
                     RenderStack var10 = var2.m_8e1ea841();
                     if (var9 == null ? var10 == null : var9.equals(var10)) {
                        C0167.anonymousimplements var11 = this.m_fff92e14();
                        C0167.anonymousimplements var12 = var2.m_fff92e14();
                        if (var11 == null ? var12 == null : var11.equals(var12)) {
                           C0153 var13 = this.m_75885561();
                           C0153 var14 = var2.m_75885561();
                           if (var13 == null ? var14 == null : var13.equals(var14)) {
                              C0233 var15 = this.m_a4c45087();
                              C0233 var16 = var2.m_a4c45087();
                              return var15 == null ? var16 == null : var15.equals(var16);
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
      return var1 instanceof C0167;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + (this.m_297cfef6() ? 79 : 97);
      long var3 = Double.doubleToLongBits(this.m_1adf23b9());
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = Double.doubleToLongBits(this.m_20206c69());
      var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
      C0165 var7 = this.m_44bb072f();
      var2 = var2 * 59 + (var7 == null ? 43 : var7.hashCode());
      C0163 var8 = this.m_4b7a3f6e();
      var2 = var2 * 59 + (var8 == null ? 43 : var8.hashCode());
      QuadRenderStack var9 = this.m_0fae4676();
      var2 = var2 * 59 + (var9 == null ? 43 : var9.hashCode());
      RenderStack var10 = this.m_8e1ea841();
      var2 = var2 * 59 + (var10 == null ? 43 : var10.hashCode());
      C0167.anonymousimplements var11 = this.m_fff92e14();
      var2 = var2 * 59 + (var11 == null ? 43 : var11.hashCode());
      C0153 var12 = this.m_75885561();
      var2 = var2 * 59 + (var12 == null ? 43 : var12.hashCode());
      C0233 var13 = this.m_a4c45087();
      return var2 * 59 + (var13 == null ? 43 : var13.hashCode());
   }

   @Override
   public String toString() {
      return C0267.m_85cd13b4()
         + this.m_44bb072f()
         + C0267.m_65c7e6e6()
         + this.m_4b7a3f6e()
         + C0267.m_a19a564f()
         + this.m_297cfef6()
         + C0267.m_03430357()
         + this.m_0fae4676()
         + C0267.m_ec329d2e()
         + this.m_8e1ea841()
         + C0267.m_edf5fb69()
         + this.m_fff92e14()
         + C0267.m_8ccfdf29()
         + this.m_1adf23b9()
         + C0267.m_0223faff()
         + this.m_20206c69()
         + C0267.m_812ab029()
         + this.m_75885561()
         + C0267.m_bdbd5e40()
         + this.m_a4c45087()
         + C0257.m_9e27f038();
   }

   public C0233 m_a4c45087() {
      return this.f_34117694;
   }

   public static enum anonymousimplements {
      f_3dab3aca,
      f_da45570f,
      f_544b0734,
      f_5c18cefe;

      private anonymousimplements() {
      }
   }
}
