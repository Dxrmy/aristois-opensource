package me.deftware.aristois.recovered;

import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0162 implements C0163 {
   protected C0165 f_bbc4d1c1;
   private C0153 f_cf71e687;
   private Runnable f_2d10affa;
   private GlTexture f_c0b7adb9;

   public C0162(int var1, int var2, int var3, int var4, GlTexture var5) {
      this.f_bbc4d1c1 = new C0165((double)var1, (double)var2, (double)var3, (double)var4);
      this.f_c0b7adb9 = var5;
   }

   public C0162 m_1313e98f(Message... var1) {
      this.f_cf71e687 = new C0153(this, var1);
      return this;
   }

   public C0162 m_3b434ebf(Runnable var1) {
      this.f_2d10affa = var1;
      return this;
   }

   @Override
   public void m_1058ed9a() {
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.f_c0b7adb9
         .bind()
         .draw((int)this.f_bbc4d1c1.m_a005efae(), (int)this.f_bbc4d1c1.m_84808068(), (int)this.f_bbc4d1c1.m_4388ac29(), (int)this.f_bbc4d1c1.m_d42f3372());
      return var6;
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      if (this.f_bbc4d1c1.m_a58797d6(var1, var3) && var5 == 0 && this.f_2d10affa != null) {
         this.f_2d10affa.run();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_bbc4d1c1;
   }

   @Override
   public C0153 m_75885561() {
      return this.f_cf71e687;
   }

   public Runnable m_ea931ce0() {
      return this.f_2d10affa;
   }

   public GlTexture m_7ce9896b() {
      return this.f_c0b7adb9;
   }

   public void m_9ee17df4(C0165 var1) {
      this.f_bbc4d1c1 = var1;
   }

   public void m_842fae32(Runnable var1) {
      this.f_2d10affa = var1;
   }

   public void m_1cb45ddf(GlTexture var1) {
      this.f_c0b7adb9 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0162)) {
         return false;
      } else {
         C0162 var2 = (C0162)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else {
            C0165 var3 = this.m_44bb072f();
            C0165 var4 = var2.m_44bb072f();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0153 var5 = this.m_75885561();
               C0153 var6 = var2.m_75885561();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  Runnable var7 = this.m_ea931ce0();
                  Runnable var8 = var2.m_ea931ce0();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     GlTexture var9 = this.m_7ce9896b();
                     GlTexture var10 = var2.m_7ce9896b();
                     return var9 == null ? var10 == null : var9.equals(var10);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_22ad6203(Object var1) {
      return var1 instanceof C0162;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      C0165 var3 = this.m_44bb072f();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      C0153 var4 = this.m_75885561();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      Runnable var5 = this.m_ea931ce0();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      GlTexture var6 = this.m_7ce9896b();
      return var2 * 59 + (var6 == null ? 43 : var6.hashCode());
   }

   @Override
   public String toString() {
      return C0267.m_d0e43f69()
         + this.m_44bb072f()
         + C0267.m_812ab029()
         + this.m_75885561()
         + C0267.m_11f0c704()
         + this.m_ea931ce0()
         + C0267.m_19faa493()
         + this.m_7ce9896b()
         + C0257.m_9e27f038();
   }
}
