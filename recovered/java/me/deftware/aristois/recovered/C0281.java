package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;

public class C0281 extends C0288<C0281> {
   private boolean f_0b289329 = false;
   private boolean f_1f5644c8 = false;
   protected final MainEntityPlayer f_7a43bece;
   protected int f_0ebbb825 = -1;
   protected int f_41827991;
   protected int f_363e8322 = 0;

   public C0281(int var1, MainEntityPlayer var2) {
      if (var1 > 8) {
         throw new IllegalArgumentException(C0256.m_760db7bb());
      } else {
         this.f_41827991 = var1;
         this.f_7a43bece = var2;
         this.f_0ebbb825 = var2.getInventory().getCurrentItem();
      }
   }

   public C0281 m_2d2cf7a8() {
      this.f_0b289329 = true;
      return this;
   }

   public C0281 m_9c777e87() {
      this.f_ae2cc37b = System.currentTimeMillis();
      this.f_1f5644c8 = true;
      return this;
   }

   public C0281 m_cb71ab98() {
      if (this.f_ae2cc37b + 300L < System.currentTimeMillis() && this.f_363e8322 == 0) {
         if (this.f_0ebbb825 != this.f_41827991) {
            this.f_7a43bece.getInventory().setCurrentItem(this.f_41827991);
         }

         this.f_363e8322++;
      } else if (this.f_ae2cc37b + 500L < System.currentTimeMillis() && this.f_363e8322 == 1) {
         this.f_363e8322++;
         this.f_7a43bece.swapHands();
      } else if (this.f_ae2cc37b + 700L < System.currentTimeMillis()) {
         if (this.f_0ebbb825 != this.f_41827991) {
            this.f_7a43bece.getInventory().setCurrentItem(this.f_0ebbb825);
         }

         this.f_0b289329 = true;
         this.m_23674f64();
      }

      return this;
   }

   @Override
   public boolean m_f7b07982() {
      return this.f_0b289329;
   }

   @Override
   public boolean m_9362a920() {
      return this.f_1f5644c8;
   }
}
