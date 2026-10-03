package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.dialog.DialogWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0107 implements C0112<C0163> {
   public C0107() {
   }

   @Override
   public List<Class<? extends C0163>> m_350b5ae0() {
      return Arrays.asList(C0163.class, C0428.class, DialogWidget.class);
   }

   @Override
   public C0163 m_5f0a4ee5(final C0094<C0163> var1, final ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(Message.of(var1.m_6f1f396d()), var2.m_519f75ae()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               C0163 var2x = (C0163)var1.m_50ca8f08();
               if (var2x instanceof DialogWidget) {
                  var2.close();
                  ((DialogWidget)var2x).open((C0446)Minecraft.getMinecraftGame().getScreen());
               }
            }
         }
      };
      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      return var4;
   }
}
