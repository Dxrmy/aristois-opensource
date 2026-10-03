package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.gui.GuiScreen;

public class C0116 implements C0112<GuiScreen> {
   public C0116() {
   }

   public List<Class<? extends GuiScreen>> m_ec433cec() {
      return C0114.bootstrap<"call",0,1>(GuiScreen.class);
   }

   public C0163 m_972bab10(final C0094<GuiScreen> var1, ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(C0114.bootstrap<"call",1,1>(var1.m_b5ae4ee3()), var2.m_0826645c()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               C0114.bootstrap<"call",0,1>(C0116.this, (GuiScreen)var1.m_48b16e97());
            }
         }
      };
      var4.m_e61ee212(new C0426[]{C0426.f_974a55e6});
      return var4;
   }

   public void m_f4ee415a(C0094<?> var1) {
      C0114.bootstrap<"call",0,1>().runOnRenderThread(() -> this.m_7f6d8cc3((GuiScreen)var1.m_48b16e97()));
   }

   private void m_7f6d8cc3(GuiScreen var1) {
      var1.parent = C0114.bootstrap<"call",2,1>().getScreen();
      if (var1 instanceof C0150) {
         ((C0150)var1).m_8d846d1c(C0114.bootstrap<"call",2,1>().getScreen());
      }

      C0114.bootstrap<"call",2,1>().openScreen(var1);
   }
}
