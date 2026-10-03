package me.deftware.aristois.recovered;

import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;

public class C0152 implements C0163 {
   private final C0165 f_d233b504;
   private boolean f_e2a392e7;
   protected boolean f_f60da464 = false;
   private Message f_8ed8b971;

   public C0152(int var1, int var2, int var3, int var4, boolean var5) {
      this.f_d233b504 = new C0165((double)var1, (double)var2, (double)var3, (double)var4);
      this.f_e2a392e7 = var5;
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      this.f_f60da464 = this.f_d233b504.m_a58797d6(var1, var3) && !var6;
      if (this.f_8ed8b971 != null) {
         FontRenderer.drawString(
            this.f_8ed8b971,
            (int)(this.f_d233b504.m_a005efae() + this.f_d233b504.m_4388ac29() + 5.0),
            (int)(this.f_d233b504.m_84808068() + this.f_d233b504.m_d42f3372() / 2.0 - (double)(FontRenderer.getFontHeight() / 2)),
            16777215
         );
      }

      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      C0228.f_7bf45835
         .bind()
         .draw(
            (int)this.f_d233b504.m_a005efae(),
            (int)this.f_d233b504.m_84808068(),
            (int)this.f_d233b504.m_4388ac29(),
            (int)this.f_d233b504.m_d42f3372(),
            this.f_f60da464 ? 20 : 0,
            this.f_e2a392e7 ? 20 : 0,
            64,
            64
         )
         .unbind();
      return var6 || this.f_f60da464;
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      if (this.f_f60da464) {
         this.f_e2a392e7 = !this.f_e2a392e7;
         this.m_b728afce();
         return true;
      } else {
         return false;
      }
   }

   public void m_b728afce() {
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_d233b504;
   }

   public boolean m_e0f7c666() {
      return this.f_e2a392e7;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_e2a392e7 = var1;
   }

   public boolean m_297cfef6() {
      return this.f_f60da464;
   }

   public void m_8d564dc2(Message var1) {
      this.f_8ed8b971 = var1;
   }
}
