package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;

public class C0284 extends C0288<C0284> {
   private boolean f_1c8f927c = false;
   private boolean f_2f1546b3 = false;
   protected final MainEntityPlayer f_31999166;
   protected final int f_2763385f;
   protected final int f_d809e855;

   public C0284(int var1, int var2, MainEntityPlayer var3) {
      this.f_2763385f = var1;
      this.f_31999166 = var3;
      this.f_d809e855 = var2;
   }

   public C0284 m_1a243e53() {
      this.f_1c8f927c = true;
      return this;
   }

   public C0284 m_1a5e78c3() {
      this.f_ac570c63 = C0114.bootstrap<"call",0,1>();
      this.f_2f1546b3 = true;
      return this;
   }

   public C0284 m_a31f7138() {
      this.f_31999166.moveToHotBar(this.f_2763385f, this.f_d809e855, 0);
      this.f_1c8f927c = true;
      this.m_99967baf();
      return this;
   }

   public boolean m_c2ea53db() {
      return this.f_1c8f927c;
   }

   public boolean m_164ea7bc() {
      return this.f_2f1546b3;
   }
}
