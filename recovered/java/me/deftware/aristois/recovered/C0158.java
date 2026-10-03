package me.deftware.aristois.recovered;

import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.message.Message;

public class C0158 implements C0163 {
   private final C0165 f_b3f16b55;
   private int f_6fad000e = 2;
   private Message[] f_b9b3badb;

   public C0158(Message... var1) {
      this(0, 0, var1);
   }

   public C0158(int var1, int var2, Message... var3) {
      this.f_b3f16b55 = new C0165().m_f8b16cfb((double)var1, (double)var2);
      this.m_eb5ceeb6(var3);
   }

   public void m_eb5ceeb6(Message... var1) {
      this.f_b9b3badb = var1;
      this.f_b3f16b55.m_61ade8f3((double)((FontRenderer.getFontHeight() + this.f_6fad000e) * var1.length));
   }

   @Override
   public void m_1058ed9a() {
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      int var7 = (int)this.f_b3f16b55.m_a005efae();
      int var8 = (int)this.f_b3f16b55.m_84808068();

      for (Message var12 : this.f_b9b3badb) {
         FontRenderer.drawStringWithShadow(var12, var7, var8, 16777215);
         var8 += FontRenderer.getFontHeight() + this.f_6fad000e;
      }

      return false;
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_b3f16b55;
   }

   public void m_46938bdb(int var1) {
      this.f_6fad000e = var1;
   }

   public Message[] m_70391061() {
      return this.f_b9b3badb;
   }
}
