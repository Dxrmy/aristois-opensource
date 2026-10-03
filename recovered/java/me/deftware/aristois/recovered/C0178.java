package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;

public class C0178<T extends C0049> extends C0174<T> {
   private final List<C0178.anonymousconst<T>> f_f4324af7 = new ArrayList<>();
   private double f_b5fa62e8 = 0.0;

   public C0178(GenericScreen var1, List<T> var2, Class<T> var3, String var4) {
      super(var1, var2, var3, var4);
   }

   public C0178<T> m_7637cf92(C0178.anonymousconst<T> var1) {
      this.f_f4324af7.add(var1);
      return this;
   }

   @Override
   protected void m_1058ed9a() {
      this.m_d6ac7420(true);
      super.m_1058ed9a();
      int var1 = 10;

      for (C0178.anonymousconst var3 : this.f_f4324af7) {
         C0154 var4 = this.m_5a1fbc03(
               var1, 10, (float)(FontRenderer.getStringWidth(var3.m_50076859()) + 10), var3.m_50076859(), var2 -> var3.m_63a4faac(this.m_cee5fd5a(), var2)
            )
            .m_798462fc(() -> var3.m_24ac1cf7(this.m_51ce03a5()));
         var4.m_c7a3618c(new C0153(var4, var3.m_a461dcd9()));
         this.m_4f7d4126(new C0163[]{var4});
         var1 = (int)((double)var1 + var4.m_44bb072f().m_4388ac29() + 5.0);
      }
   }

   protected void m_33f32c61(T var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9) {
      byte var10 = 17;
      int var11 = this.getGuiScreenWidth() - 30;
      int var12 = var4 + (this.f_751e4f27 / 2 - var10 / 2) - 2;
      boolean var13 = var7 > var11 && var7 < var11 + var10 && var8 > var12 && var8 < var12 + var10;
      if (this.m_cee5fd5a() == var1) {
         GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
         GLX.INSTANCE.push();
         int var14 = var11 + var10 / 2;
         int var15 = var12 + var10 / 2;
         GLX.INSTANCE.translate((float)var14, (float)var15, 1.0F);
         double var16 = 50.0 * Math.sin(this.f_b5fa62e8);
         if (!var13 && !(Math.abs(var16) > 5.0)) {
            var11 = var12 = -(var10 / 2);
            this.f_b5fa62e8 = 0.0;
         } else {
            GLX.INSTANCE.rotate(var16, 0.0, 0.0, 1.0);
            GLX.INSTANCE.translate((float)(-var14), (float)(-var15), 1.0F);
            this.f_b5fa62e8 += 0.1;
         }

         C0228.f_0f76d8d5.bind().draw(var11, var12, var10, var10).unbind();
         GLX.INSTANCE.pop();
      }
   }

   @Override
   protected boolean onMouseClicked(int var1, int var2, int var3) {
      C0049 var4 = (C0049)this.f_1d8ec2c9.getHoveredItem(var1, var2);
      if (var4 != null && var1 > this.getGuiScreenWidth() - 30) {
         this.m_e775aa43(null);
      }

      return super.onMouseClicked(var1, var2, var3);
   }

   protected T m_e775aa43(C0154 var1) {
      if (!this.m_51ce03a5()) {
         return null;
      } else {
         C0049 var2 = this.m_cee5fd5a();
         var2.m_fd4438d8();
         return (T)var2;
      }
   }

   protected void m_a7bd9b16(T var1) {
      CompletableFuture.runAsync(() -> {
         try {
            var1.m_f1ec3ae8();
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      });
   }

   @Override
   protected C0155[] m_da527608() {
      return new C0155[0];
   }

   public interface anonymousconst<T> {
      void m_63a4faac(T var1, C0154 var2);

      Message m_a461dcd9();

      Message m_50076859();

      default boolean m_24ac1cf7(boolean var1) {
         return var1;
      }
   }
}
