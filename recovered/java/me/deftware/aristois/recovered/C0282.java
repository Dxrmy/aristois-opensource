package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;

public class C0282 extends C0288<C0282> {
   private boolean f_95e2d071 = false;
   private boolean f_40108e25 = false;
   private final MainEntityPlayer f_1a08f606;
   private long f_38ec2150 = 400L;
   private final int f_d752ba42;
   private final int f_3ee9af88;

   public C0282(MainEntityPlayer var1, int var2, int var3) {
      this.f_1a08f606 = var1;
      this.f_d752ba42 = var2;
      this.f_3ee9af88 = var3;
   }

   public C0282 m_bea0657b() {
      this.f_95e2d071 = true;
      return this;
   }

   public C0282 m_60aaa182() {
      this.f_3d88bbca = C0114.bootstrap<"call",0,1>();
      this.f_40108e25 = true;
      this.f_1a08f606.windowClick(8 - this.f_3ee9af88, 0, WindowClickAction.QUICK_MOVE);
      this.f_1a08f606.windowClick(this.f_d752ba42 < 9 ? 36 + this.f_d752ba42 : this.f_d752ba42, 0, WindowClickAction.QUICK_MOVE);
      return this;
   }

   public C0282 m_119f429e() {
      if (this.f_3d88bbca + this.f_38ec2150 < C0114.bootstrap<"call",0,1>()) {
         this.f_95e2d071 = true;
         this.m_dd01d476();
      }

      return this;
   }

   public boolean m_afcb9a2d() {
      return this.f_95e2d071;
   }

   public boolean m_222881e6() {
      return this.f_40108e25;
   }

   public void m_86c5942b(long var1) {
      this.f_38ec2150 = var1;
   }
}
