package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;

public class C0281 extends C0288<C0281> {
   private boolean f_ee94260c = false;
   private boolean f_ef846732 = false;
   protected final MainEntityPlayer f_3bc129ea;
   protected int f_e22ad567 = -1;
   protected int f_28e2e4e7;
   protected int f_a2096a6e = 0;

   public C0281(int var1, MainEntityPlayer var2) {
      if (var1 > 8) {
         throw new IllegalArgumentException(C0252.bootstrap<"get",55834574893>());
      } else {
         this.f_28e2e4e7 = var1;
         this.f_3bc129ea = var2;
         this.f_e22ad567 = var2.getInventory().getCurrentItem();
      }
   }

   public C0281 m_7cdd50de() {
      this.f_ee94260c = true;
      return this;
   }

   public C0281 m_9fb23962() {
      this.f_3b961bae = C0114.bootstrap<"call",0,1>();
      this.f_ef846732 = true;
      return this;
   }

   public C0281 m_006cb48c() {
      if (this.f_3b961bae + 300L < C0114.bootstrap<"call",0,1>() && this.f_a2096a6e == 0) {
         if (this.f_e22ad567 != this.f_28e2e4e7) {
            this.f_3bc129ea.getInventory().setCurrentItem(this.f_28e2e4e7);
         }

         this.f_a2096a6e++;
      } else if (this.f_3b961bae + 500L < C0114.bootstrap<"call",0,1>() && this.f_a2096a6e == 1) {
         this.f_a2096a6e++;
         this.f_3bc129ea.swapHands();
      } else if (this.f_3b961bae + 700L < C0114.bootstrap<"call",0,1>()) {
         if (this.f_e22ad567 != this.f_28e2e4e7) {
            this.f_3bc129ea.getInventory().setCurrentItem(this.f_e22ad567);
         }

         this.f_ee94260c = true;
         this.m_a63803c5();
      }

      return this;
   }

   public boolean m_2f5cd2ab() {
      return this.f_ee94260c;
   }

   public boolean m_f8424ff6() {
      return this.f_ef846732;
   }
}
