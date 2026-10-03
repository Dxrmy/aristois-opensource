package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventKnockback;

public class C0370 extends AbstractMod {
   @C0098(
      value = "Horizontal",
      description = {"The percentage of knockback you take horizontally"},
      number = @C0096(
         min = 0.0,
         max = 1.0,
         percentage = true
      )
   )
   private float f_5afc585d = 0.0F;
   @C0098(
      value = "Vertical",
      description = {"The percentage of knockback you take vertically"},
      number = @C0096(
         min = 0.0,
         max = 1.0,
         percentage = true
      )
   )
   private float f_568795bb = 0.0F;

   public C0370() {
      super(C0259.m_0223faff(), C0290.f_829d9b20, C0260.m_44418b5d());
   }

   @EventHandler
   public void m_7a1f9607(EventKnockback var1) {
      if (this.f_5afc585d == 0.0F && this.f_568795bb == 0.0F) {
         var1.setCanceled(true);
      } else {
         var1.setX(var1.getX() * (double)this.f_5afc585d);
         var1.setY(var1.getY() * (double)this.f_568795bb);
         var1.setZ(var1.getZ() * (double)this.f_5afc585d);
      }
   }
}
