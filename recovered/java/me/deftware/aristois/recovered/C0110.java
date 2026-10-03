package me.deftware.aristois.recovered;

import java.util.Collections;
import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0110 implements C0112<C0245> {
   public C0110() {
   }

   @Override
   public List<Class<? extends C0245>> m_350b5ae0() {
      return Collections.singletonList(C0245.class);
   }

   @Override
   public C0163 m_5f0a4ee5(C0094<C0245> var1, ContainerWidget var2, boolean var3) {
      return m_7d393be8(var1.m_347620b9(), (C0245)var1.m_50ca8f08(), var3, var2.m_519f75ae());
   }

   public static C0163 m_7d393be8(final C0098 var0, final C0245 var1, boolean var2, C0441 var3) {
      ButtonWidget var4 = new ButtonWidget(C0197.f_9607505d, var3) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               Minecraft.getMinecraftGame().openScreen(new C0190(var1, Minecraft.getMinecraftGame().getScreen()));
            } else if (var1x == 2) {
               var1.m_1058ed9a();
            }
         }

         @Override
         public void m_1058ed9a() {
            this.updateLabel();
         }

         @Override
         public void updateLabel() {
            String var1x = var0 == null ? C0266.m_0d6ae39b() : var0.value();
            this.setLabel(Message.of(var1.m_36ffc578() == -1 ? var1x : var1.toString()));
         }
      };
      var4.setTextAlign(C0427.f_26bd24ae);
      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      var4.m_c7a3618c(new RectTooltip(var4, C0289.m_c3a8b502(C0432.class), Message.of(C0266.m_65d43991())));
      if (var2) {
         var4.updatePadding(m_4388ac29());
      }

      return var4;
   }

   @Override
   public void m_b9cf1f73(C0094<?> var1) {
      Minecraft.getMinecraftGame().runOnRenderThread(() -> {
         C0190 var1x = new C0190((C0245)var1.m_50ca8f08(), Minecraft.getMinecraftGame().getScreen());
         Minecraft.getMinecraftGame().openScreen(var1x);
      });
   }

   public static double m_4388ac29() {
      return C0289.m_c3a8b502(C0432.class).m_036bd5c5() / 2.1;
   }
}
