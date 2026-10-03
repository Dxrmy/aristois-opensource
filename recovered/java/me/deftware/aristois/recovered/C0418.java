package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.render.gl.GLX;

public class C0418 extends AbstractMod {
   @C0098(
      value = "Row Items",
      number = @C0096(
         min = 3.0,
         max = 15.0
      )
   )
   private int f_235a3600 = 5;
   private final double f_611ec0ca = 95.0;
   private final double f_958cb71d = 18.0;

   public C0418() {
      super(C0252.bootstrap<"get",42949672985>(), C0290.f_4792a25c, C0252.bootstrap<"get",42949672986>());
   }

   @EventHandler
   public void m_43b6ad69(EventRender2D var1) {
      double var2 = (double)C0114.bootstrap<"call",0,1>() / 2.0 + 95.0;
      double var6 = (double)C0114.bootstrap<"call",1,1>() - 18.0;
      MainEntityPlayer var8 = (MainEntityPlayer)C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>()._getPlayer());
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
            if (var9++ >= this.f_235a3600 - 1) {
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
