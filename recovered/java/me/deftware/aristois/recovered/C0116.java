package me.deftware.aristois.recovered;

import java.util.Collections;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0116 implements C0112<GuiScreen> {
   public C0116() {
   }

   @Override
   public List<Class<? extends GuiScreen>> m_350b5ae0() {
      return Collections.singletonList(GuiScreen.class);
   }

   @Override
   public C0163 m_5f0a4ee5(final C0094<GuiScreen> var1, ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(Message.of(var1.m_6f1f396d()), var2.m_519f75ae()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               C0116.this.m_90551620((GuiScreen)var1.m_50ca8f08());
            }
         }
      };
      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      return var4;
   }

   @Override
   public void m_b9cf1f73(C0094<?> var1) {
      Minecraft.getMinecraftGame().runOnRenderThread(() -> this.m_90551620((GuiScreen)var1.m_50ca8f08()));
   }

   private void m_90551620(GuiScreen var1) {
      var1.parent = Minecraft.getMinecraftGame().getScreen();
      if (var1 instanceof C0150) {
         ((C0150)var1).m_772dbb91(Minecraft.getMinecraftGame().getScreen());
      }

      Minecraft.getMinecraftGame().openScreen(var1);
   }
}
