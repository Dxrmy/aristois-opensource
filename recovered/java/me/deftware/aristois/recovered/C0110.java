package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;

public class C0110 implements C0112<C0245> {
   public C0110() {
   }

   public List<Class<? extends C0245>> m_b0b0f1e9() {
      return C0114.bootstrap<"call",0,1>(C0245.class);
   }

   public C0163 m_8bd3ef99(C0094<C0245> var1, ContainerWidget var2, boolean var3) {
      return C0114.bootstrap<"call",1,1>(var1.m_371c3bfa(), (C0245)var1.m_48b16e97(), var3, var2.m_0826645c());
   }

   public static C0163 m_05ca08e0(final C0098 var0, final C0245 var1, boolean var2, C0441 var3) {
      ButtonWidget var4 = new ButtonWidget(C0197.f_716a73fa, var3) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               C0114.bootstrap<"call",0,1>().openScreen(new C0190(var1, C0114.bootstrap<"call",0,1>().getScreen()));
            } else if (var1x == 2) {
               var1.m_fce13178();
            }
         }

         public void m_3c2ea845() {
            this.updateLabel();
         }

         @Override
         public void updateLabel() {
            String var1x = var0 == null ? C0252.bootstrap<"get",12884902015>() : var0.value();
            this.setLabel(C0114.bootstrap<"call",0,1>(var1.m_6978c604() == -1 ? var1x : var1.toString()));
         }
      };
      var4.setTextAlign(C0427.f_f7cee513);
      var4.m_e61ee212(new C0426[]{C0426.f_974a55e6});
      var4.m_43533edf(new RectTooltip(var4, (C0441)C0114.bootstrap<"call",2,1>(C0432.class), C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",12884902016>())));
      if (var2) {
         var4.updatePadding(C0114.bootstrap<"call",4,1>());
      }

      return var4;
   }

   public void m_a20a9e7f(C0094<?> var1) {
      C0114.bootstrap<"call",0,1>().runOnRenderThread(() -> {
         C0190 var1x = new C0190((C0245)var1.m_48b16e97(), C0114.bootstrap<"call",1,1>().getScreen());
         C0114.bootstrap<"call",1,1>().openScreen(var1x);
      });
   }

   public static double m_04460d63() {
      return ((C0432)C0114.bootstrap<"call",0,1>(C0432.class)).m_581aafd6() / 2.1;
   }
}
