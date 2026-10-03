package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;

public class C0282 extends C0288<C0282> {
   private boolean f_8496e477 = false;
   private boolean f_cd3798e0 = false;
   private final MainEntityPlayer f_e9999243;
   private long f_65e25b99 = 400L;
   private final int f_f6721b7a;
   private final int f_c81213b2;

   public C0282(MainEntityPlayer var1, int var2, int var3) {
      this.f_e9999243 = var1;
      this.f_f6721b7a = var2;
      this.f_c81213b2 = var3;
   }

   public C0282 m_8aaa9c48() {
      this.f_8496e477 = true;
      return this;
   }

   public C0282 m_5b119d99() {
      this.f_ae2cc37b = System.currentTimeMillis();
      this.f_cd3798e0 = true;
      this.f_e9999243.windowClick(8 - this.f_c81213b2, 0, WindowClickAction.QUICK_MOVE);
      this.f_e9999243.windowClick(this.f_f6721b7a < 9 ? 36 + this.f_f6721b7a : this.f_f6721b7a, 0, WindowClickAction.QUICK_MOVE);
      return this;
   }

   public C0282 m_65521376() {
      if (this.f_ae2cc37b + this.f_65e25b99 < System.currentTimeMillis()) {
         this.f_8496e477 = true;
         this.m_23674f64();
      }

      return this;
   }

   @Override
   public boolean m_f7b07982() {
      return this.f_8496e477;
   }

   @Override
   public boolean m_9362a920() {
      return this.f_cd3798e0;
   }

   public void m_ad6c7e6f(long var1) {
      this.f_65e25b99 = var1;
   }
}
