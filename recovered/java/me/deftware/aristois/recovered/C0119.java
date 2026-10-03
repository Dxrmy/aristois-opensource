package me.deftware.aristois.recovered;

import java.util.Collections;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;

public class C0119 implements C0112<Runnable> {
   public C0119() {
   }

   @Override
   public List<Class<? extends Runnable>> m_350b5ae0() {
      return Collections.singletonList(Runnable.class);
   }

   @Override
   public C0163 m_5f0a4ee5(final C0094<Runnable> var1, ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(Message.of(var1.m_6f1f396d()), var2.m_519f75ae()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               ((Runnable)var1.m_50ca8f08()).run();
            }
         }
      };
      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      return var4;
   }

   @Override
   public void m_b9cf1f73(C0094<?> var1) {
      ((Runnable)var1.m_50ca8f08()).run();
   }
}
