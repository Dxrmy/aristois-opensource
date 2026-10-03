package me.deftware.aristois.recovered;

import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPlayerWalking.PostEvent;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.network.packets.CPacketPosition;

public class C0272 extends C0273<C0272.anonymousimplements> {
   public static final C0272 f_80dac840 = new C0272();

   public C0272() {
   }

   public void m_1fd1c447(Vector3d var1, int var2, boolean var3, Runnable var4) {
      this.m_c8a9ff54(var1.getX(), var1.getY(), var1.getZ(), var3, var2, var4);
   }

   public void m_c8a9ff54(double var1, double var3, double var5, boolean var7, int var8, final Runnable var9) {
      this.m_0a42d7e5(new C0272.anonymousimplements(var1, var3, var5, var7, var8) {
         @Override
         public void run() {
            if (var9 != null) {
               var9.run();
            }
         }
      });
   }

   @EventHandler
   private void m_fee3b35d(PostEvent var1) {
      this.m_b728afce();
   }

   public abstract static class anonymousimplements implements C0273.anonymouscatch<CPacketPosition> {
      private double f_a4434424;
      private double f_8f3c191d;
      private double f_d100d870;
      private boolean f_b7e473f9;
      private int f_cd1df4c7;

      @Override
      public void m_0e265701() {
         new CPacketPosition(this.f_a4434424, this.f_8f3c191d, this.f_d100d870, this.f_b7e473f9).sendImmediately();
      }

      public double m_a005efae() {
         return this.f_a4434424;
      }

      public double m_d42f3372() {
         return this.f_8f3c191d;
      }

      public double m_b94b5d9f() {
         return this.f_d100d870;
      }

      public boolean m_e0f7c666() {
         return this.f_b7e473f9;
      }

      @Override
      public int m_8b15b5f4() {
         return this.f_cd1df4c7;
      }

      public void m_4b04f920(double var1) {
         this.f_a4434424 = var1;
      }

      public void m_7c9e279f(double var1) {
         this.f_8f3c191d = var1;
      }

      public void m_ddfd9367(double var1) {
         this.f_d100d870 = var1;
      }

      public void m_d6ac7420(boolean var1) {
         this.f_b7e473f9 = var1;
      }

      public void m_46938bdb(int var1) {
         this.f_cd1df4c7 = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0272.anonymousimplements)) {
            return false;
         } else {
            C0272.anonymousimplements var2 = (C0272.anonymousimplements)var1;
            if (!var2.m_22ad6203(this)) {
               return false;
            } else if (Double.compare(this.m_a005efae(), var2.m_a005efae()) != 0) {
               return false;
            } else if (Double.compare(this.m_d42f3372(), var2.m_d42f3372()) != 0) {
               return false;
            } else if (Double.compare(this.m_b94b5d9f(), var2.m_b94b5d9f()) != 0) {
               return false;
            } else {
               return this.m_e0f7c666() != var2.m_e0f7c666() ? false : this.m_8b15b5f4() == var2.m_8b15b5f4();
            }
         }
      }

      protected boolean m_22ad6203(Object var1) {
         return var1 instanceof C0272.anonymousimplements;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         long var3 = Double.doubleToLongBits(this.m_a005efae());
         var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
         long var5 = Double.doubleToLongBits(this.m_d42f3372());
         var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
         long var7 = Double.doubleToLongBits(this.m_b94b5d9f());
         var2 = var2 * 59 + (int)(var7 >>> 32 ^ var7);
         var2 = var2 * 59 + (this.m_e0f7c666() ? 79 : 97);
         return var2 * 59 + this.m_8b15b5f4();
      }

      @Override
      public String toString() {
         return C0256.m_d32ebe65()
            + this.m_a005efae()
            + C0256.m_afb31f66()
            + this.m_d42f3372()
            + C0256.m_c254a253()
            + this.m_b94b5d9f()
            + C0256.m_3d3a8736()
            + this.m_e0f7c666()
            + C0256.m_94acbdac()
            + this.m_8b15b5f4()
            + C0257.m_9e27f038();
      }

      public anonymousimplements(double var1, double var3, double var5, boolean var7, int var8) {
         this.f_a4434424 = var1;
         this.f_8f3c191d = var3;
         this.f_d100d870 = var5;
         this.f_b7e473f9 = var7;
         this.f_cd1df4c7 = var8;
      }
   }
}
