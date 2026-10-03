package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;

public class C0284 extends C0288<C0284> {
   private boolean f_c886d696 = false;
   private boolean f_4d1c3ffb = false;
   protected final MainEntityPlayer f_e5b70b70;
   protected final int f_09572364;
   protected final int f_b56f28db;

   public C0284(int var1, int var2, MainEntityPlayer var3) {
      this.f_09572364 = var1;
      this.f_e5b70b70 = var3;
      this.f_b56f28db = var2;
   }

   public C0284 m_1aa75638() {
      this.f_c886d696 = true;
      return this;
   }

   public C0284 m_f96d72ab() {
      this.f_ae2cc37b = System.currentTimeMillis();
      this.f_4d1c3ffb = true;
      return this;
   }

   public C0284 m_170df87c() {
      this.f_e5b70b70.moveToHotBar(this.f_09572364, this.f_b56f28db, 0);
      this.f_c886d696 = true;
      this.m_23674f64();
      return this;
   }

   @Override
   public boolean m_f7b07982() {
      return this.f_c886d696;
   }

   @Override
   public boolean m_9362a920() {
      return this.f_4d1c3ffb;
   }
}
