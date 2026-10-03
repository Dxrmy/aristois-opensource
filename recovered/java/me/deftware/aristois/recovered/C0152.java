package me.deftware.aristois.recovered;

import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;

public class C0152 implements C0163 {
   private final C0165 f_5a42c296;
   private boolean f_fff08ccd;
   protected boolean f_be6bbc19 = false;
   private Message f_5ed9b113;

   public C0152(int var1, int var2, int var3, int var4, boolean var5) {
      this.f_5a42c296 = new C0165((double)var1, (double)var2, (double)var3, (double)var4);
      this.f_fff08ccd = var5;
   }

   public boolean m_6da7f8cb(double var1, double var3, float var5, boolean var6) {
      this.f_be6bbc19 = this.f_5a42c296.m_263d91ea(var1, var3) && !var6;
      if (this.f_5ed9b113 != null) {
         C0114.bootstrap<"call",1,1>(
            this.f_5ed9b113,
            (int)(this.f_5a42c296.m_14f8bc2c() + this.f_5a42c296.m_830cb294() + 5.0),
            (int)(this.f_5a42c296.m_5a998971() + this.f_5a42c296.m_fc7f45bc() / 2.0 - (double)(C0114.bootstrap<"call",0,1>() / 2)),
            16777215
         );
      }

      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      C0228.f_13f0edde
         .bind()
         .draw(
            (int)this.f_5a42c296.m_14f8bc2c(),
            (int)this.f_5a42c296.m_5a998971(),
            (int)this.f_5a42c296.m_830cb294(),
            (int)this.f_5a42c296.m_fc7f45bc(),
            this.f_be6bbc19 ? 20 : 0,
            this.f_fff08ccd ? 20 : 0,
            64,
            64
         )
         .unbind();
      return var6 || this.f_be6bbc19;
   }

   public boolean m_a852657c(double var1, double var3, int var5) {
      if (this.f_be6bbc19) {
         this.f_fff08ccd = !this.f_fff08ccd;
         this.m_0b3cd846();
         return true;
      } else {
         return false;
      }
   }

   public void m_0b3cd846() {
   }

   public C0165 m_a702859f() {
      return this.f_5a42c296;
   }

   public boolean m_d4a52db6() {
      return this.f_fff08ccd;
   }

   public void m_5d41c826(boolean var1) {
      this.f_fff08ccd = var1;
   }

   public boolean m_c735e6b9() {
      return this.f_be6bbc19;
   }

   public void m_044b304a(Message var1) {
      this.f_5ed9b113 = var1;
   }
}
