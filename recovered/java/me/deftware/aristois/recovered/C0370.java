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
   private float f_edb25504 = 0.0F;
   @C0098(
      value = "Vertical",
      description = {"The percentage of knockback you take vertically"},
      number = @C0096(
         min = 0.0,
         max = 1.0,
         percentage = true
      )
   )
   private float f_9c00edd7 = 0.0F;

   public C0370() {
      super(C0252.bootstrap<"get",42949673061>(), C0290.f_cd638c01, C0252.bootstrap<"get",47244640256>());
   }

   @EventHandler
   public void m_43d5d43c(EventKnockback var1) {
      if (this.f_edb25504 == 0.0F && this.f_9c00edd7 == 0.0F) {
         var1.setCanceled(true);
      } else {
         var1.setX(var1.getX() * (double)this.f_edb25504);
         var1.setY(var1.getY() * (double)this.f_9c00edd7);
         var1.setZ(var1.getZ() * (double)this.f_edb25504);
      }
   }
}
