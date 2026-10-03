package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;

public class C0178<T extends C0049> extends C0174<T> {
   private final List<C0178.anonymousconst<T>> f_8172c055 = new ArrayList<>();
   private double f_d572ae74 = 0.0;

   public C0178(GenericScreen var1, List<T> var2, Class<T> var3, String var4) {
      super(var1, var2, var3, var4);
   }

   public C0178<T> m_218bde78(C0178.anonymousconst<T> var1) {
      this.f_8172c055.add(var1);
      return this;
   }

   protected void m_a7c7b5d5() {
      this.m_6864b1c2(true);
      super.m_4a76dabf();
      int var1 = 10;

      for (C0178.anonymousconst var3 : this.f_8172c055) {
         C0154 var4 = this.m_d05530d0(
               var1, 10, (float)(C0114.bootstrap<"call",0,1>(var3.m_d52b4449()) + 10), var3.m_d52b4449(), var2 -> var3.m_3554b4ed(this.m_deeb7069(), var2)
            )
            .m_dc08502f(() -> C0114.bootstrap<"call",0,1>(var3.m_17bbc95c(this.m_f2246348())));
         var4.m_ca06ea23(new C0153(var4, var3.m_6133fd9c()));
         this.m_f8cc84cb(new C0163[]{var4});
         var1 = (int)((double)var1 + var4.m_9c5eea58().m_830cb294() + 5.0);
      }
   }

   protected void m_635431fb(T var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9) {
      byte var10 = 17;
      int var11 = this.getGuiScreenWidth() - 30;
      int var12 = var4 + (this.f_ab8cc2c5 / 2 - var10 / 2) - 2;
      boolean var13 = var7 > var11 && var7 < var11 + var10 && var8 > var12 && var8 < var12 + var10;
      if (this.m_deeb7069() == var1) {
         GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
         GLX.INSTANCE.push();
         int var14 = var11 + var10 / 2;
         int var15 = var12 + var10 / 2;
         GLX.INSTANCE.translate((float)var14, (float)var15, 1.0F);
         double var16 = 50.0 * C0114.bootstrap<"call",1,1>(this.f_d572ae74);
         if (!var13 && !(C0114.bootstrap<"call",2,1>(var16) > 5.0)) {
            var11 = var12 = -(var10 / 2);
            this.f_d572ae74 = 0.0;
         } else {
            GLX.INSTANCE.rotate(var16, 0.0, 0.0, 1.0);
            GLX.INSTANCE.translate((float)(-var14), (float)(-var15), 1.0F);
            this.f_d572ae74 += 0.1;
         }

         C0228.f_43ffd340.bind().draw(var11, var12, var10, var10).unbind();
         GLX.INSTANCE.pop();
      }
   }

   @Override
   protected boolean onMouseClicked(int var1, int var2, int var3) {
      C0049 var4 = (C0049)this.f_036c291d.getHoveredItem(var1, var2);
      if (var4 != null && var1 > this.getGuiScreenWidth() - 30) {
         this.m_11b8901a(null);
      }

      return super.onMouseClicked(var1, var2, var3);
   }

   protected T m_11b8901a(C0154 var1) {
      if (!this.m_f2246348()) {
         return null;
      } else {
         C0049 var2 = (C0049)this.m_deeb7069();
         var2.m_afc8f035();
         return (T)var2;
      }
   }

   protected void m_0c0ba9d1(T var1) {
      C0114.bootstrap<"call",3,1>(() -> {
         try {
            var1.m_02fb878c();
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      });
   }

   protected C0155[] m_21613932() {
      return new C0155[0];
   }

   public interface anonymousconst<T> {
      void m_3554b4ed(T var1, C0154 var2);

      Message m_6133fd9c();

      Message m_d52b4449();

      default boolean m_17bbc95c(boolean var1) {
         return var1;
      }
   }
}
