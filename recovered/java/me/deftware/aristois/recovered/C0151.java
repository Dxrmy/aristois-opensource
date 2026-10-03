package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public abstract class C0151 implements C0194 {
   private final C0165 f_5831836d;
   private FontRenderStack f_ccbe9ed2;
   private Message f_92de1e18;
   protected final QuadRenderStack f_d849ea9e = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private Color f_60143b13;
   private boolean f_b77addd1 = false;
   private boolean f_6e2225fc = true;
   private double f_8e36065f = 0.0;
   private int f_bd7833f5 = -1;

   public C0151(Message var1, FontRenderStack var2) {
      this(var1, 0.0, 0.0, var2);
   }

   public C0151(Message var1, double var2, double var4, FontRenderStack var6) {
      this.f_60143b13 = ((C0432)C0114.bootstrap<"call",0,1>(C0432.class)).m_604f8702();
      this.f_5831836d = new C0165(var2, var4, (double)var6.getStringWidth(var1), (double)var6.getFontHeight());
      this.f_ccbe9ed2 = var6;
      this.f_92de1e18 = var1;
   }

   public C0151 m_4c6d5b71() {
      this.f_6e2225fc = false;
      return this;
   }

   public C0151 m_562cdcf4(int var1) {
      this.f_bd7833f5 = var1;
      return this;
   }

   public void m_57727a05(boolean var1) {
      this.f_d849ea9e.setScaled(var1);
   }

   public boolean m_03ca24a3(double var1, double var3, float var5, boolean var6) {
      if (this.f_6e2225fc) {
         this.f_b77addd1 = this.f_5831836d
            .m_263d91ea(
               C0114.bootstrap<"call",0,1>() * (double)C0114.bootstrap<"call",1,1>(), C0114.bootstrap<"call",2,1>() * (double)C0114.bootstrap<"call",1,1>()
            );
         double var7 = this.f_5831836d.m_830cb294() / 8.0;
         if (this.f_b77addd1) {
            this.f_8e36065f = C0114.bootstrap<"call",3,1>(this.f_5831836d.m_830cb294(), this.f_8e36065f + var7 * (double)var5);
         } else {
            this.f_8e36065f = C0114.bootstrap<"call",4,1>(0.0, this.f_8e36065f - var7 * (double)var5);
         }

         ((QuadRenderStack)this.f_d849ea9e.glColor(this.f_60143b13)).begin();
         this.f_d849ea9e
            .drawRect(
               this.f_5831836d.m_14f8bc2c(),
               this.f_5831836d.m_5a998971() + this.f_5831836d.m_fc7f45bc() - 2.0,
               this.f_5831836d.m_14f8bc2c() + this.f_8e36065f,
               this.f_5831836d.m_5a998971() + this.f_5831836d.m_fc7f45bc()
            );
         this.f_d849ea9e.end();
      }

      this.f_ccbe9ed2.begin();
      this.f_ccbe9ed2.drawString((int)this.f_5831836d.m_14f8bc2c(), (int)this.f_5831836d.m_5a998971(), this.f_92de1e18);
      this.f_ccbe9ed2.end();
      return var6;
   }

   public boolean m_abaa3905(double var1, double var3, int var5) {
      boolean var6 = this.f_5831836d
         .m_263d91ea(
            C0114.bootstrap<"call",0,1>() * (double)C0114.bootstrap<"call",1,1>(), C0114.bootstrap<"call",2,1>() * (double)C0114.bootstrap<"call",1,1>()
         );
      if (var6 && var5 == 0) {
         this.m_d11bd0a8();
      }

      return var6;
   }

   public boolean m_d95bdcf9(int var1, int var2, int var3) {
      if (var1 == this.f_bd7833f5 && this.f_bd7833f5 != -1) {
         this.m_d11bd0a8();
         return true;
      } else {
         return false;
      }
   }

   protected abstract void m_d11bd0a8();

   public C0165 m_8cd045bb() {
      return this.f_5831836d;
   }

   public void m_29242ee9(FontRenderStack var1) {
      this.f_ccbe9ed2 = var1;
   }

   public Message m_7f676093() {
      return this.f_92de1e18;
   }

   public void m_e31bed3f(Message var1) {
      this.f_92de1e18 = var1;
   }

   public void m_e422a7ec(Color var1) {
      this.f_60143b13 = var1;
   }

   public boolean m_dc230825() {
      return this.f_b77addd1;
   }

   public boolean m_56635fa0() {
      return this.f_6e2225fc;
   }
}
