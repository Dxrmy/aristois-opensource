package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;

public class C0119 implements C0112<Runnable> {
   public C0119() {
   }

   public List<Class<? extends Runnable>> m_d21306b2() {
      return C0114.bootstrap<"call",0,1>(Runnable.class);
   }

   public C0163 m_5d58bde6(final C0094<Runnable> var1, ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(C0114.bootstrap<"call",1,1>(var1.m_b5ae4ee3()), var2.m_0826645c()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               ((Runnable)var1.m_48b16e97()).run();
            }
         }
      };
      var4.m_e61ee212(new C0426[]{C0426.f_974a55e6});
      return var4;
   }

   public void m_a8dc1dd1(C0094<?> var1) {
      ((Runnable)var1.m_48b16e97()).run();
   }
}
