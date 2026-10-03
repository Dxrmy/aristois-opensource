package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.LineRenderStack;

public class C0153 implements C0194 {
   protected C0165 f_d6f0a6d2 = new C0165();
   protected C0165 f_8d088f26;
   protected Message[] f_c56737e3;
   protected double f_d7b831e8 = 3.0;
   private LineRenderStack f_f361c7ac = new LineRenderStack();

   public C0153(C0163 var1, Message... var2) {
      this(var1.m_fd6ca281(), var2);
   }

   public C0153(C0165 var1, Message... var2) {
      this.f_c56737e3 = var2;
      this.f_8d088f26 = var1;
      this.m_4f39a897();
   }

   public void m_4f39a897() {
      this.f_d6f0a6d2
         .m_b9e3750e(
            (double)this.m_ef709b97(
               (Message)C0114.bootstrap<"call",0,1>(this.f_c56737e3)
                  .max(C0114.bootstrap<"call",1,1>(this::m_ef709b97))
                  .orElseThrow(() -> new RuntimeException(C0252.bootstrap<"get",25769803892>()))
            )
         );
      this.f_d6f0a6d2.m_5078410c(this.m_ce15e2e1() * (double)this.f_c56737e3.length);
   }

   public boolean m_92696976(double var1, double var3, float var5, boolean var6) {
      double var7 = 6.0;
      if (this.f_8d088f26.m_263d91ea(var1, var3) && !var6) {
         var1 = this.m_abe8f47b(var1, var7);
         this.m_ac20042b(var1, var3, var1 + this.f_d6f0a6d2.m_830cb294(), var3 + this.f_d6f0a6d2.m_fc7f45bc());

         for (Message var12 : this.f_c56737e3) {
            this.m_cdc3694f(var12, (int)var1, (int)var3);
            var3 += this.m_ce15e2e1();
         }
      }

      return var6;
   }

   public void m_0d45cade(boolean var1) {
      this.f_f361c7ac.setScaled(var1);
   }

   protected double m_abe8f47b(double var1, double var3) {
      if (var1 + this.f_d6f0a6d2.m_830cb294() + this.f_d7b831e8 + var3 * 2.0 > (double)C0114.bootstrap<"call",2,1>()) {
         var1 -= this.f_d6f0a6d2.m_830cb294() + var3 + this.f_d7b831e8;
      } else {
         var1 += var3 * 2.0 + this.f_d7b831e8;
      }

      return var1;
   }

   protected int m_ef709b97(Message var1) {
      return C0114.bootstrap<"call",0,1>(var1);
   }

   protected double m_ce15e2e1() {
      return (double)C0114.bootstrap<"call",0,1>();
   }

   protected void m_cdc3694f(Message var1, int var2, int var3) {
      C0114.bootstrap<"call",1,1>(var1, var2, var3, 16777215);
   }

   protected void m_ac20042b(double var1, double var3, double var5, double var7) {
      var1 -= this.f_d7b831e8;
      var3 -= this.f_d7b831e8;
      var5 += this.f_d7b831e8;
      var7 += this.f_d7b831e8;
      this.f_f361c7ac.glColor(Color.DARK_GRAY);
      this.f_f361c7ac.begin(1);
      double var9 = var5 - this.f_d7b831e8;
      double var11 = var7 - this.f_d7b831e8;

      for (int var13 = 0; var13 < 360; var13++) {
         if (var13 == 90) {
            var11 = var3 + this.f_d7b831e8;
         } else if (var13 == 180) {
            var9 = var1 + this.f_d7b831e8;
         } else if (var13 == 270) {
            var11 = var7 - this.f_d7b831e8;
         }

         this.f_f361c7ac.vertex(var9, var11);
         this.f_f361c7ac
            .vertex(
               var9 + C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>((double)var13)) * this.f_d7b831e8,
               var11 + C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",2,1>((double)var13)) * this.f_d7b831e8
            );
      }

      this.f_f361c7ac.end();
      this.f_f361c7ac.begin(7);
      this.f_f361c7ac.vertex(var5 - this.f_d7b831e8, var3);
      this.f_f361c7ac.vertex(var1 + this.f_d7b831e8, var3);
      this.f_f361c7ac.vertex(var1 + this.f_d7b831e8, var7);
      this.f_f361c7ac.vertex(var5 - this.f_d7b831e8, var7);
      this.f_f361c7ac.vertex(var5, var3 + this.f_d7b831e8);
      this.f_f361c7ac.vertex(var1, var3 + this.f_d7b831e8);
      this.f_f361c7ac.vertex(var1, var7 - this.f_d7b831e8);
      this.f_f361c7ac.vertex(var5, var7 - this.f_d7b831e8);
      this.f_f361c7ac.end();
   }

   public C0165 m_44d81a4d() {
      return this.f_d6f0a6d2;
   }

   public C0165 m_ee532cc3() {
      return this.f_8d088f26;
   }

   public Message[] m_ee1d9af6() {
      return this.f_c56737e3;
   }

   public double m_76291cac() {
      return this.f_d7b831e8;
   }

   public LineRenderStack m_f803d0c5() {
      return this.f_f361c7ac;
   }

   public void m_dacbac48(C0165 var1) {
      this.f_d6f0a6d2 = var1;
   }

   public void m_94b7c735(C0165 var1) {
      this.f_8d088f26 = var1;
   }

   public void m_efa4409b(Message[] var1) {
      this.f_c56737e3 = var1;
   }

   public void m_c1c3bc5c(double var1) {
      this.f_d7b831e8 = var1;
   }

   public void m_34e7a119(LineRenderStack var1) {
      this.f_f361c7ac = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0153)) {
         return false;
      } else {
         C0153 var2 = (C0153)var1;
         if (!var2.m_f98438eb(this)) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_76291cac(), var2.m_76291cac()) != 0) {
            return false;
         } else {
            C0165 var3 = this.m_44d81a4d();
            C0165 var4 = var2.m_44d81a4d();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0165 var5 = this.m_ee532cc3();
               C0165 var6 = var2.m_ee532cc3();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  if (!C0114.bootstrap<"call",1,1>(this.m_ee1d9af6(), var2.m_ee1d9af6())) {
                     return false;
                  } else {
                     LineRenderStack var7 = this.m_f803d0c5();
                     LineRenderStack var8 = var2.m_f803d0c5();
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

   protected boolean m_f98438eb(Object var1) {
      return var1 instanceof C0153;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      long var3 = C0114.bootstrap<"call",0,1>(this.m_76291cac());
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      C0165 var5 = this.m_44d81a4d();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      C0165 var6 = this.m_ee532cc3();
      var2 = var2 * 59 + (var6 == null ? 43 : var6.hashCode());
      var2 = var2 * 59 + C0114.bootstrap<"call",1,1>(this.m_ee1d9af6());
      LineRenderStack var7 = this.m_f803d0c5();
      return var2 * 59 + (var7 == null ? 43 : var7.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",25769803889>()
         + this.m_44d81a4d()
         + C0252.bootstrap<"get",25769803881>()
         + this.m_ee532cc3()
         + C0252.bootstrap<"get",25769803890>()
         + C0114.bootstrap<"call",0,1>(this.m_ee1d9af6())
         + C0252.bootstrap<"get",25769803876>()
         + this.m_76291cac()
         + C0252.bootstrap<"get",25769803891>()
         + this.m_f803d0c5()
         + C0252.bootstrap<"get",59>();
   }
}
