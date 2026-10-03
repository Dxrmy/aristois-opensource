package me.deftware.aristois.recovered;

import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.BooleanWidget;
import me.deftware.client.framework.message.Message;

public class C0118 implements C0112<Boolean> {
   public C0118() {
   }

   public List<Class<? extends Boolean>> m_210cbb6a() {
      return C0114.bootstrap<"call",0,1>(new Class[]{boolean.class, Boolean.class});
   }

   public C0163 m_6a920dc6(C0094<Boolean> var1, ContainerWidget var2, boolean var3) {
      return C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var1.m_b5ae4ee3()), var1, var2.m_0826645c(), var3);
   }

   public static C0163 m_f90d6613(Message var0, final C0105<Boolean> var1, C0441 var2, boolean var3) {
      BooleanWidget var4 = new BooleanWidget(var0, var2) {
         @Override
         protected void apply(boolean var1x) {
            var1.m_bc5354a6(C0114.bootstrap<"call",0,1>(var1x));
         }

         public void m_6023ab1d() {
            this.enabled = (Boolean)var1.m_d4606028();
            this.getAnimation().m_bb3577b4();
         }

         @Override
         protected void onClick(int var1x) {
            super.onClick(var1x);
            if (var1x == 2 && var1 instanceof C0094) {
               ((C0094)var1).m_4e85e8f7();
               this.m_6023ab1d();
            }
         }
      };
      var4.m_e1ae250d(new C0426[]{C0426.f_974a55e6});
      if (var3) {
         var4.updatePadding(C0114.bootstrap<"call",3,1>());
      }

      return var4;
   }

   public Boolean m_4b820c70(String var1) {
      return C0114.bootstrap<"call",5,1>(C0114.bootstrap<"call",4,1>(var1));
   }

   public void m_7af629af(SuggestionsBuilder var1) {
      var1.suggest(C0252.bootstrap<"get",12884902005>()).suggest(C0252.bootstrap<"get",12884902006>());
   }
}
