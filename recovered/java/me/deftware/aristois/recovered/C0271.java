package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPlayerWalking.PostEvent;
import me.deftware.client.framework.network.packets.CPacketRotation;

public class C0271 extends C0273<C0271.anonymousimplements> {
   public static final C0271 f_e53f9422 = new C0271();

   public C0271() {
   }

   public void m_13afcfef(float var1, float var2, int var3, final Runnable var4) {
      this.m_644b7e7d(new C0271.anonymousimplements(var1, var2, var3) {
         @Override
         public void run() {
            if (var4 != null) {
               var4.run();
            }
         }
      });
   }

   @EventHandler
   private void m_1c137f0b(PostEvent var1) {
      if (this.m_39b42f30()) {
         C0271.anonymousimplements var2 = (C0271.anonymousimplements)this.m_0ac58d19();
         if (var2 != null) {
            var2.m_3fd46d73();
            var2.run();
         }

         this.f_7a4a5b60 = var2 == null ? 0 : var2.m_97a8330f();
         this.f_711f859d = 0;
      }
   }

   public abstract static class anonymousimplements implements C0273.anonymouscatch<CPacketRotation> {
      private float f_f31f4488;
      private float f_1625b14a;
      private int f_a9ada6af;

      public void m_3fd46d73() {
         new CPacketRotation(
               this.f_f31f4488, this.f_1625b14a, ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).isOnGround()
            )
            .sendImmediately();
      }

      public float m_910e86be() {
         return this.f_f31f4488;
      }

      public float m_6ef76856() {
         return this.f_1625b14a;
      }

      public int m_97a8330f() {
         return this.f_a9ada6af;
      }

      public void m_3de619ad(float var1) {
         this.f_f31f4488 = var1;
      }

      public void m_f82212ff(float var1) {
         this.f_1625b14a = var1;
      }

      public void m_b393efd3(int var1) {
         this.f_a9ada6af = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0271.anonymousimplements)) {
            return false;
         } else {
            C0271.anonymousimplements var2 = (C0271.anonymousimplements)var1;
            if (!var2.m_0addf583(this)) {
               return false;
            } else if (C0114.bootstrap<"call",0,1>(this.m_910e86be(), var2.m_910e86be()) != 0) {
               return false;
            } else {
               return C0114.bootstrap<"call",0,1>(this.m_6ef76856(), var2.m_6ef76856()) != 0 ? false : this.m_97a8330f() == var2.m_97a8330f();
            }
         }
      }

      protected boolean m_0addf583(Object var1) {
         return var1 instanceof C0271.anonymousimplements;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         var2 = var2 * 59 + C0114.bootstrap<"call",0,1>(this.m_910e86be());
         var2 = var2 * 59 + C0114.bootstrap<"call",0,1>(this.m_6ef76856());
         return var2 * 59 + this.m_97a8330f();
      }

      @Override
      public String toString() {
         return C0252.bootstrap<"get",55834574891>()
            + this.m_910e86be()
            + C0252.bootstrap<"get",55834574892>()
            + this.m_6ef76856()
            + C0252.bootstrap<"get",55834574890>()
            + this.m_97a8330f()
            + C0252.bootstrap<"get",59>();
      }

      public anonymousimplements(float var1, float var2, int var3) {
         this.f_f31f4488 = var1;
         this.f_1625b14a = var2;
         this.f_a9ada6af = var3;
      }
   }
}
