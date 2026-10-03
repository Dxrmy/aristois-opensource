package me.deftware.aristois.recovered;

import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPlayerWalking.PostEvent;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.network.packets.CPacketPosition;

public class C0272 extends C0273<C0272.anonymousimplements> {
   public static final C0272 f_57dc9762 = new C0272();

   public C0272() {
   }

   public void m_3febe6c2(Vector3d var1, int var2, boolean var3, Runnable var4) {
      this.m_3e49027f(var1.getX(), var1.getY(), var1.getZ(), var3, var2, var4);
   }

   public void m_3e49027f(double var1, double var3, double var5, boolean var7, int var8, final Runnable var9) {
      this.m_d87f0193(new C0272.anonymousimplements(var1, var3, var5, var7, var8) {
         @Override
         public void run() {
            if (var9 != null) {
               var9.run();
            }
         }
      });
   }

   @EventHandler
   private void m_2cc18b4b(PostEvent var1) {
      this.m_4f07d40d();
   }

   public abstract static class anonymousimplements implements C0273.anonymouscatch<CPacketPosition> {
      private double f_26a7f654;
      private double f_02bb0235;
      private double f_ecb51610;
      private boolean f_13932047;
      private int f_c1b792d0;

      public void m_fee90d09() {
         new CPacketPosition(this.f_26a7f654, this.f_02bb0235, this.f_ecb51610, this.f_13932047).sendImmediately();
      }

      public double m_5fe630f7() {
         return this.f_26a7f654;
      }

      public double m_ffdc41a7() {
         return this.f_02bb0235;
      }

      public double m_fcf0d59f() {
         return this.f_ecb51610;
      }

      public boolean m_126c8962() {
         return this.f_13932047;
      }

      public int m_00db26e1() {
         return this.f_c1b792d0;
      }

      public void m_9c2dcb61(double var1) {
         this.f_26a7f654 = var1;
      }

      public void m_7b4be820(double var1) {
         this.f_02bb0235 = var1;
      }

      public void m_ab6c317b(double var1) {
         this.f_ecb51610 = var1;
      }

      public void m_31f64d09(boolean var1) {
         this.f_13932047 = var1;
      }

      public void m_40476252(int var1) {
         this.f_c1b792d0 = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0272.anonymousimplements)) {
            return false;
         } else {
            C0272.anonymousimplements var2 = (C0272.anonymousimplements)var1;
            if (!var2.m_092898ae(this)) {
               return false;
            } else if (C0114.bootstrap<"call",0,1>(this.m_5fe630f7(), var2.m_5fe630f7()) != 0) {
               return false;
            } else if (C0114.bootstrap<"call",0,1>(this.m_ffdc41a7(), var2.m_ffdc41a7()) != 0) {
               return false;
            } else if (C0114.bootstrap<"call",0,1>(this.m_fcf0d59f(), var2.m_fcf0d59f()) != 0) {
               return false;
            } else {
               return this.m_126c8962() != var2.m_126c8962() ? false : this.m_00db26e1() == var2.m_00db26e1();
            }
         }
      }

      protected boolean m_092898ae(Object var1) {
         return var1 instanceof C0272.anonymousimplements;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         long var3 = C0114.bootstrap<"call",0,1>(this.m_5fe630f7());
         var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
         long var5 = C0114.bootstrap<"call",0,1>(this.m_ffdc41a7());
         var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
         long var7 = C0114.bootstrap<"call",0,1>(this.m_fcf0d59f());
         var2 = var2 * 59 + (int)(var7 >>> 32 ^ var7);
         var2 = var2 * 59 + (this.m_126c8962() ? 79 : 97);
         return var2 * 59 + this.m_00db26e1();
      }

      @Override
      public String toString() {
         return C0252.bootstrap<"get",55834574886>()
            + this.m_5fe630f7()
            + C0252.bootstrap<"get",55834574887>()
            + this.m_ffdc41a7()
            + C0252.bootstrap<"get",55834574888>()
            + this.m_fcf0d59f()
            + C0252.bootstrap<"get",55834574889>()
            + this.m_126c8962()
            + C0252.bootstrap<"get",55834574890>()
            + this.m_00db26e1()
            + C0252.bootstrap<"get",59>();
      }

      public anonymousimplements(double var1, double var3, double var5, boolean var7, int var8) {
         this.f_26a7f654 = var1;
         this.f_02bb0235 = var3;
         this.f_ecb51610 = var5;
         this.f_13932047 = var7;
         this.f_c1b792d0 = var8;
      }
   }
}
