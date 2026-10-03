package me.deftware.aristois.recovered;

import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0162 implements C0163 {
   protected C0165 f_e8a4e6b8;
   private C0153 f_8c68b8f7;
   private Runnable f_b2641be5;
   private GlTexture f_64d2dc44;

   public C0162(int var1, int var2, int var3, int var4, GlTexture var5) {
      this.f_e8a4e6b8 = new C0165((double)var1, (double)var2, (double)var3, (double)var4);
      this.f_64d2dc44 = var5;
   }

   public C0162 m_569fbc78(Message... var1) {
      this.f_8c68b8f7 = new C0153(this, var1);
      return this;
   }

   public C0162 m_725fbec7(Runnable var1) {
      this.f_b2641be5 = var1;
      return this;
   }

   public void m_8673d451() {
   }

   public boolean m_8641bf14(double var1, double var3, float var5, boolean var6) {
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.f_64d2dc44
         .bind()
         .draw((int)this.f_e8a4e6b8.m_14f8bc2c(), (int)this.f_e8a4e6b8.m_5a998971(), (int)this.f_e8a4e6b8.m_830cb294(), (int)this.f_e8a4e6b8.m_fc7f45bc());
      return var6;
   }

   public boolean m_bc7acd19(double var1, double var3, int var5) {
      if (this.f_e8a4e6b8.m_263d91ea(var1, var3) && var5 == 0 && this.f_b2641be5 != null) {
         this.f_b2641be5.run();
         return true;
      } else {
         return false;
      }
   }

   public C0165 m_b78bffcf() {
      return this.f_e8a4e6b8;
   }

   public C0153 m_c644cdb9() {
      return this.f_8c68b8f7;
   }

   public Runnable m_0f85d017() {
      return this.f_b2641be5;
   }

   public GlTexture m_e1b5b28b() {
      return this.f_64d2dc44;
   }

   public void m_a32a2ae9(C0165 var1) {
      this.f_e8a4e6b8 = var1;
   }

   public void m_6af6ea42(Runnable var1) {
      this.f_b2641be5 = var1;
   }

   public void m_a7000ac1(GlTexture var1) {
      this.f_64d2dc44 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0162)) {
         return false;
      } else {
         C0162 var2 = (C0162)var1;
         if (!var2.m_61c26581(this)) {
            return false;
         } else {
            C0165 var3 = this.m_b78bffcf();
            C0165 var4 = var2.m_b78bffcf();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0153 var5 = this.m_c644cdb9();
               C0153 var6 = var2.m_c644cdb9();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  Runnable var7 = this.m_0f85d017();
                  Runnable var8 = var2.m_0f85d017();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     GlTexture var9 = this.m_e1b5b28b();
                     GlTexture var10 = var2.m_e1b5b28b();
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

   protected boolean m_61c26581(Object var1) {
      return var1 instanceof C0162;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      C0165 var3 = this.m_b78bffcf();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      C0153 var4 = this.m_c644cdb9();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      Runnable var5 = this.m_0f85d017();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      GlTexture var6 = this.m_e1b5b28b();
      return var2 * 59 + (var6 == null ? 43 : var6.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",25769803856>()
         + this.m_b78bffcf()
         + C0252.bootstrap<"get",25769803857>()
         + this.m_c644cdb9()
         + C0252.bootstrap<"get",25769803858>()
         + this.m_0f85d017()
         + C0252.bootstrap<"get",25769803859>()
         + this.m_e1b5b28b()
         + C0252.bootstrap<"get",59>();
   }
}
