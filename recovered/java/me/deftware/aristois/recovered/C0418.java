package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.gl.GLX;

public class C0418 extends AbstractMod {
   @C0098(
      value = "Row Items",
      number = @C0096(
         min = 3.0,
         max = 15.0
      )
   )
   private int f_62c0250b = 5;
   private final double f_2dc326dc = 95.0;
   private final double f_b8792162 = 18.0;

   public C0418() {
      super(C0259.m_e07cee76(), C0290.f_43c13687, C0259.m_7b0db73e());
   }

   @EventHandler
   public void m_84072c65(EventRender2D var1) {
      double var2 = (double)GuiScreen.getScaledWidth() / 2.0 + 95.0;
      double var6 = (double)GuiScreen.getScaledHeight() - 18.0;
      MainEntityPlayer var8 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      GLX.INSTANCE.push();
      GLX.INSTANCE.translate(var2, var6, 1.0);
      double var4 = 0.0;
      var6 = 0.0;
      int var9 = 0;

      for (int var10 = var8.getInventory().getSize() - 6; var10 > 8; var10--) {
         ItemStack var11 = var8.getInventory().getStackInSlot(var10);
         if (!var11.isEmpty()) {
            var11.renderItemAndEffectIntoGUI((int)var4, (int)var6);
            var11.renderItemOverlays((int)var4, (int)var6);
            if (var9++ >= this.f_62c0250b - 1) {
               var9 = 0;
               var4 = 0.0;
               var6 -= 18.0;
            } else {
               var4 += 18.0;
            }
         }
      }

      GLX.INSTANCE.pop();
   }
}
