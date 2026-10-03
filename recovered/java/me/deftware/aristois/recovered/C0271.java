package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPlayerWalking.PostEvent;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketRotation;

public class C0271 extends C0273<C0271.anonymousimplements> {
   public static final C0271 f_15eacd20 = new C0271();

   public C0271() {
   }

   public void m_6696523b(float var1, float var2, int var3, final Runnable var4) {
      this.m_0a42d7e5(new C0271.anonymousimplements(var1, var2, var3) {
         @Override
         public void run() {
            if (var4 != null) {
               var4.run();
            }
         }
      });
   }

   @EventHandler
   private void m_fee3b35d(PostEvent var1) {
      if (this.m_51ce03a5()) {
         C0271.anonymousimplements var2 = this.m_cec3adc2();
         if (var2 != null) {
            var2.m_0e265701();
            var2.run();
         }

         this.f_c67bb039 = var2 == null ? 0 : var2.m_8b15b5f4();
         this.f_e5b1f1d0 = 0;
      }
   }

   public abstract static class anonymousimplements implements C0273.anonymouscatch<CPacketRotation> {
      private float f_71056f40;
      private float f_e380e9d9;
      private int f_d4d61cbc;

      @Override
      public void m_0e265701() {
         new CPacketRotation(this.f_71056f40, this.f_e380e9d9, Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).isOnGround())
            .sendImmediately();
      }

      public float m_796256b9() {
         return this.f_71056f40;
      }

      public float m_b7fbb877() {
         return this.f_e380e9d9;
      }

      @Override
      public int m_8b15b5f4() {
         return this.f_d4d61cbc;
      }

      public void m_d881d3e3(float var1) {
         this.f_71056f40 = var1;
      }

      public void m_35bea3d9(float var1) {
         this.f_e380e9d9 = var1;
      }

      public void m_46938bdb(int var1) {
         this.f_d4d61cbc = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0271.anonymousimplements)) {
            return false;
         } else {
            C0271.anonymousimplements var2 = (C0271.anonymousimplements)var1;
            if (!var2.m_22ad6203(this)) {
               return false;
            } else if (Float.compare(this.m_796256b9(), var2.m_796256b9()) != 0) {
               return false;
            } else {
               return Float.compare(this.m_b7fbb877(), var2.m_b7fbb877()) != 0 ? false : this.m_8b15b5f4() == var2.m_8b15b5f4();
            }
         }
      }

      protected boolean m_22ad6203(Object var1) {
         return var1 instanceof C0271.anonymousimplements;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         var2 = var2 * 59 + Float.floatToIntBits(this.m_796256b9());
         var2 = var2 * 59 + Float.floatToIntBits(this.m_b7fbb877());
         return var2 * 59 + this.m_8b15b5f4();
      }

      @Override
      public String toString() {
         return C0256.m_022da1b4() + this.m_796256b9() + C0256.m_6e2d03c3() + this.m_b7fbb877() + C0256.m_94acbdac() + this.m_8b15b5f4() + C0257.m_9e27f038();
      }

      public anonymousimplements(float var1, float var2, int var3) {
         this.f_71056f40 = var1;
         this.f_e380e9d9 = var2;
         this.f_d4d61cbc = var3;
      }
   }
}
