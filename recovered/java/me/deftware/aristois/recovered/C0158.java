package me.deftware.aristois.recovered;

import me.deftware.client.framework.message.Message;

public class C0158 implements C0163 {
   private final C0165 f_ab5c3ef6;
   private int f_d7e300a7 = 2;
   private Message[] f_a468a6ae;

   public C0158(Message... var1) {
      this(0, 0, var1);
   }

   public C0158(int var1, int var2, Message... var3) {
      this.f_ab5c3ef6 = new C0165().m_1e49f000((double)var1, (double)var2);
      this.m_09601035(var3);
   }

   public void m_09601035(Message... var1) {
      this.f_a468a6ae = var1;
      this.f_ab5c3ef6.m_5078410c((double)((C0114.bootstrap<"call",0,1>() + this.f_d7e300a7) * var1.length));
   }

   public void m_76c6a16d() {
   }

   public boolean m_1734c90e(double var1, double var3, float var5, boolean var6) {
      int var7 = (int)this.f_ab5c3ef6.m_14f8bc2c();
      int var8 = (int)this.f_ab5c3ef6.m_5a998971();

      for (Message var12 : this.f_a468a6ae) {
         C0114.bootstrap<"call",1,1>(var12, var7, var8, 16777215);
         var8 += C0114.bootstrap<"call",0,1>() + this.f_d7e300a7;
      }

      return false;
   }

   public C0165 m_78de1ffb() {
      return this.f_ab5c3ef6;
   }

   public void m_5a5a866e(int var1) {
      this.f_d7e300a7 = var1;
   }

   public Message[] m_0259750e() {
      return this.f_a468a6ae;
   }
}
