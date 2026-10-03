package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.render.batching.CircleRenderStack;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;

public abstract class C0167 implements C0163 {
   protected C0165 f_8c81526a;
   protected C0163 f_b4a86baa;
   private boolean f_d06bfead = false;
   protected final QuadRenderStack f_65c6f8d1 = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private final RenderStack<CircleRenderStack> f_19a418a8 = (RenderStack<CircleRenderStack>)new CircleRenderStack().setScaled(false);
   private C0167.anonymousimplements f_7c3f95bb;
   private double f_7bb57f49 = 1.0;
   private double f_3fa4924d = 1.0;
   private C0153 f_02c6f596;
   private final C0233 f_97ce0073 = new C0233(60.0F, 33.0) {
      protected void m_f9ca7bc9(double var1) {
         double var3 = !C0114.bootstrap<"call",0,1>(C0167.this) ? 1.0 - var1 : var1;
         C0114.bootstrap<"call",2,1>(C0167.this, C0114.bootstrap<"call",1,1>(C0167.this) * var3);
      }
   };

   public C0167(double var1, double var3, double var5, double var7, C0163 var9, C0167.anonymousimplements var10) {
      this.f_8c81526a = new C0165(var1, var3, var5, var7);
      this.f_b4a86baa = var9;
      this.f_7c3f95bb = var10;
      this.f_97ce0073.m_fae54ac4(C0233.anonymousdefault.f_805d07d6);
   }

   public void m_02d5d202() {
      double var1;
      if (this.f_7c3f95bb != C0167.anonymousimplements.f_b787d6f1 && this.f_7c3f95bb != C0167.anonymousimplements.f_1d856601) {
         var1 = this.f_8c81526a.m_14f8bc2c() + this.f_8c81526a.m_830cb294();
      } else {
         var1 = this.f_8c81526a.m_14f8bc2c() - this.f_b4a86baa.m_fd6ca281().m_830cb294();
      }

      double var3 = this.f_7c3f95bb != C0167.anonymousimplements.f_b787d6f1 && this.f_7c3f95bb != C0167.anonymousimplements.f_339070d9
         ? this.f_8c81526a.m_5a998971()
         : this.f_8c81526a.m_5a998971() - this.f_b4a86baa.m_fd6ca281().m_fc7f45bc() + this.f_8c81526a.m_fc7f45bc();
      this.f_b4a86baa.m_fd6ca281().m_1e49f000(var1, var3);
      this.f_b4a86baa.m_6b155392();
      double var5 = this.f_b4a86baa.m_fd6ca281().m_14f8bc2c();
      double var7 = this.f_b4a86baa.m_fd6ca281().m_5a998971();
      double var9 = this.f_b4a86baa.m_fd6ca281().m_14f8bc2c() + this.f_b4a86baa.m_fd6ca281().m_830cb294();
      double var11 = this.f_b4a86baa.m_fd6ca281().m_5a998971() + this.f_b4a86baa.m_fd6ca281().m_fc7f45bc();
      this.f_3fa4924d = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var9 - var5, 2.0) + C0114.bootstrap<"call",0,1>(var11 - var7, 2.0)) + 30.0;
   }

   protected abstract void m_5c9767e6(double var1, double var3, float var5);

   public boolean m_4ef7f721(double var1, double var3, float var5, boolean var6) {
      this.f_97ce0073.m_61a5f120(var5);
      this.m_5c9767e6(var1, var3, var5);
      if (this.f_d06bfead || this.f_7bb57f49 > 1.0) {
         GLX.INSTANCE.push();
         C0114.bootstrap<"call",2,1>(1024);
         C0114.bootstrap<"call",3,1>(2960);
         C0114.bootstrap<"call",4,1>(false, false, false, false);
         C0114.bootstrap<"call",5,1>(false);
         C0114.bootstrap<"call",6,1>(519, 1, 255);
         C0114.bootstrap<"call",7,1>(7680, 7680, 7681);
         C0114.bootstrap<"call",8,1>(255);
         ((CircleRenderStack)((CircleRenderStack)this.f_19a418a8.begin()).glColor(Color.white))
            .drawFilledCircle((float)this.f_8c81526a.m_14f8bc2c(), (float)this.f_8c81526a.m_5a998971(), (float)this.f_7bb57f49)
            .end();
         C0114.bootstrap<"call",4,1>(true, true, true, true);
         C0114.bootstrap<"call",5,1>(true);
         C0114.bootstrap<"call",6,1>(514, 1, 255);
         var6 = this.f_b4a86baa.m_2f338522(var1, var3, var5, var6);
         C0114.bootstrap<"call",9,1>(2960);
         GLX.INSTANCE.pop();
      }

      return var6;
   }

   public boolean m_dfe5b198(double var1, double var3, int var5) {
      if (this.f_d06bfead) {
         this.f_b4a86baa.m_73c37f1a(var1, var3, var5);
      }

      return false;
   }

   public boolean m_3fd09420(double var1, double var3, int var5) {
      if (this.f_8c81526a.m_263d91ea(var1, var3)) {
         this.m_baf21d1c();
         return true;
      } else {
         if (this.f_d06bfead) {
            this.f_b4a86baa.m_7e41b969(var1, var3, var5);
            if (!this.f_b4a86baa.m_fd6ca281().m_263d91ea(var1, var3)) {
               this.m_baf21d1c();
            }
         }

         return false;
      }
   }

   private void m_baf21d1c() {
      if (this.f_97ce0073.m_f6c24736()) {
         this.f_d06bfead = !this.f_d06bfead;
         this.f_97ce0073.m_bb3577b4();
      }
   }

   public void m_809d1f60() {
      if (this.f_d06bfead) {
         this.f_b4a86baa.m_e103589e();
      }
   }

   public C0165 m_981700a5() {
      return this.f_8c81526a;
   }

   public C0163 m_01540f6d() {
      return this.f_b4a86baa;
   }

   public boolean m_5b63d5ef() {
      return this.f_d06bfead;
   }

   public QuadRenderStack m_1a1350d0() {
      return this.f_65c6f8d1;
   }

   public RenderStack<CircleRenderStack> m_1eefb089() {
      return this.f_19a418a8;
   }

   public C0167.anonymousimplements m_656fd949() {
      return this.f_7c3f95bb;
   }

   public double m_b166877b() {
      return this.f_7bb57f49;
   }

   public double m_331f4ab8() {
      return this.f_3fa4924d;
   }

   public C0153 m_a484ee35() {
      return this.f_02c6f596;
   }

   public void m_885ca57d(C0165 var1) {
      this.f_8c81526a = var1;
   }

   public void m_b39d690c(C0163 var1) {
      this.f_b4a86baa = var1;
   }

   public void m_905cae96(boolean var1) {
      this.f_d06bfead = var1;
   }

   public void m_3ee31a25(C0167.anonymousimplements var1) {
      this.f_7c3f95bb = var1;
   }

   public void m_b620bc05(double var1) {
      this.f_7bb57f49 = var1;
   }

   public void m_969ed4b4(double var1) {
      this.f_3fa4924d = var1;
   }

   public void m_51e4e198(C0153 var1) {
      this.f_02c6f596 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0167)) {
         return false;
      } else {
         C0167 var2 = (C0167)var1;
         if (!var2.m_452021b0(this)) {
            return false;
         } else if (this.m_5b63d5ef() != var2.m_5b63d5ef()) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_b166877b(), var2.m_b166877b()) != 0) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_331f4ab8(), var2.m_331f4ab8()) != 0) {
            return false;
         } else {
            C0165 var3 = this.m_981700a5();
            C0165 var4 = var2.m_981700a5();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0163 var5 = this.m_01540f6d();
               C0163 var6 = var2.m_01540f6d();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  QuadRenderStack var7 = this.m_1a1350d0();
                  QuadRenderStack var8 = var2.m_1a1350d0();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     RenderStack var9 = this.m_1eefb089();
                     RenderStack var10 = var2.m_1eefb089();
                     if (var9 == null ? var10 == null : var9.equals(var10)) {
                        C0167.anonymousimplements var11 = this.m_656fd949();
                        C0167.anonymousimplements var12 = var2.m_656fd949();
                        if (var11 == null ? var12 == null : var11.equals(var12)) {
                           C0153 var13 = this.m_a484ee35();
                           C0153 var14 = var2.m_a484ee35();
                           if (var13 == null ? var14 == null : var13.equals(var14)) {
                              C0233 var15 = this.m_314a58f7();
                              C0233 var16 = var2.m_314a58f7();
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

   protected boolean m_452021b0(Object var1) {
      return var1 instanceof C0167;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + (this.m_5b63d5ef() ? 79 : 97);
      long var3 = C0114.bootstrap<"call",0,1>(this.m_b166877b());
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = C0114.bootstrap<"call",0,1>(this.m_331f4ab8());
      var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
      C0165 var7 = this.m_981700a5();
      var2 = var2 * 59 + (var7 == null ? 43 : var7.hashCode());
      C0163 var8 = this.m_01540f6d();
      var2 = var2 * 59 + (var8 == null ? 43 : var8.hashCode());
      QuadRenderStack var9 = this.m_1a1350d0();
      var2 = var2 * 59 + (var9 == null ? 43 : var9.hashCode());
      RenderStack var10 = this.m_1eefb089();
      var2 = var2 * 59 + (var10 == null ? 43 : var10.hashCode());
      C0167.anonymousimplements var11 = this.m_656fd949();
      var2 = var2 * 59 + (var11 == null ? 43 : var11.hashCode());
      C0153 var12 = this.m_a484ee35();
      var2 = var2 * 59 + (var12 == null ? 43 : var12.hashCode());
      C0233 var13 = this.m_314a58f7();
      return var2 * 59 + (var13 == null ? 43 : var13.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",25769803870>()
         + this.m_981700a5()
         + C0252.bootstrap<"get",25769803871>()
         + this.m_01540f6d()
         + C0252.bootstrap<"get",25769803872>()
         + this.m_5b63d5ef()
         + C0252.bootstrap<"get",25769803873>()
         + this.m_1a1350d0()
         + C0252.bootstrap<"get",25769803874>()
         + this.m_1eefb089()
         + C0252.bootstrap<"get",25769803875>()
         + this.m_656fd949()
         + C0252.bootstrap<"get",25769803876>()
         + this.m_b166877b()
         + C0252.bootstrap<"get",25769803877>()
         + this.m_331f4ab8()
         + C0252.bootstrap<"get",25769803857>()
         + this.m_a484ee35()
         + C0252.bootstrap<"get",25769803878>()
         + this.m_314a58f7()
         + C0252.bootstrap<"get",59>();
   }

   public C0233 m_314a58f7() {
      return this.f_97ce0073;
   }

   public static enum anonymousimplements {
      f_1d856601,
      f_807c707b,
      f_b787d6f1,
      f_339070d9;

      private anonymousimplements() {
      }
   }
}
