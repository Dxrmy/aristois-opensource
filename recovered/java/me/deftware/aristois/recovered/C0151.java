package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.input.Mouse;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public abstract class C0151 implements C0194 {
   private final C0165 f_90217941;
   private FontRenderStack f_55266f05;
   private Message f_4d3ee626;
   protected final QuadRenderStack f_ea67bb4c = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private Color f_120c0631;
   private boolean f_83fbbb14 = false;
   private boolean f_0e02aa89 = true;
   private double f_f944c368 = 0.0;
   private int f_0b645d0d = -1;

   public C0151(Message var1, FontRenderStack var2) {
      this(var1, 0.0, 0.0, var2);
   }

   public C0151(Message var1, double var2, double var4, FontRenderStack var6) {
      this.f_120c0631 = C0289.m_c3a8b502(C0432.class).m_e1729432();
      this.f_90217941 = new C0165(var2, var4, (double)var6.getStringWidth(var1), (double)var6.getFontHeight());
      this.f_55266f05 = var6;
      this.f_4d3ee626 = var1;
   }

   public C0151 m_5be40aea() {
      this.f_0e02aa89 = false;
      return this;
   }

   public C0151 m_4ef3b726(int var1) {
      this.f_0b645d0d = var1;
      return this;
   }

   @Override
   public void m_394ecb95(boolean var1) {
      this.f_ea67bb4c.setScaled(var1);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      if (this.f_0e02aa89) {
         this.f_83fbbb14 = this.f_90217941.m_a58797d6(Mouse.getMouseX() * (double)RenderStack.getScale(), Mouse.getMouseY() * (double)RenderStack.getScale());
         double var7 = this.f_90217941.m_4388ac29() / 8.0;
         if (this.f_83fbbb14) {
            this.f_f944c368 = Math.min(this.f_90217941.m_4388ac29(), this.f_f944c368 + var7 * (double)var5);
         } else {
            this.f_f944c368 = Math.max(0.0, this.f_f944c368 - var7 * (double)var5);
         }

         ((QuadRenderStack)this.f_ea67bb4c.glColor(this.f_120c0631)).begin();
         this.f_ea67bb4c
            .drawRect(
               this.f_90217941.m_a005efae(),
               this.f_90217941.m_84808068() + this.f_90217941.m_d42f3372() - 2.0,
               this.f_90217941.m_a005efae() + this.f_f944c368,
               this.f_90217941.m_84808068() + this.f_90217941.m_d42f3372()
            );
         this.f_ea67bb4c.end();
      }

      this.f_55266f05.begin();
      this.f_55266f05.drawString((int)this.f_90217941.m_a005efae(), (int)this.f_90217941.m_84808068(), this.f_4d3ee626);
      this.f_55266f05.end();
      return var6;
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      boolean var6 = this.f_90217941.m_a58797d6(Mouse.getMouseX() * (double)RenderStack.getScale(), Mouse.getMouseY() * (double)RenderStack.getScale());
      if (var6 && var5 == 0) {
         this.m_b728afce();
      }

      return var6;
   }

   @Override
   public boolean m_81405691(int var1, int var2, int var3) {
      if (var1 == this.f_0b645d0d && this.f_0b645d0d != -1) {
         this.m_b728afce();
         return true;
      } else {
         return false;
      }
   }

   protected abstract void m_b728afce();

   @Override
   public C0165 m_44bb072f() {
      return this.f_90217941;
   }

   public void m_b3d7bc43(FontRenderStack var1) {
      this.f_55266f05 = var1;
   }

   public Message m_2d348094() {
      return this.f_4d3ee626;
   }

   public void m_8d564dc2(Message var1) {
      this.f_4d3ee626 = var1;
   }

   public void m_6e0baed2(Color var1) {
      this.f_120c0631 = var1;
   }

   public boolean m_275ab222() {
      return this.f_83fbbb14;
   }

   public boolean m_f21a055b() {
      return this.f_0e02aa89;
   }
}
