package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.dialog.DialogWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;

public class C0107 implements C0112<C0163> {
   public C0107() {
   }

   public List<Class<? extends C0163>> m_9ceb4421() {
      return C0114.bootstrap<"call",0,1>(new Class[]{C0163.class, C0428.class, DialogWidget.class});
   }

   public C0163 m_032c270d(final C0094<C0163> var1, final ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(C0114.bootstrap<"call",1,1>(var1.m_b5ae4ee3()), var2.m_0826645c()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               C0163 var2x = (C0163)var1.m_48b16e97();
               if (var2x instanceof DialogWidget) {
                  var2.close();
                  ((DialogWidget)var2x).open((C0446)C0114.bootstrap<"call",0,1>().getScreen());
               }
            }
         }
      };
      var4.m_e61ee212(new C0426[]{C0426.f_974a55e6});
      return var4;
   }
}
