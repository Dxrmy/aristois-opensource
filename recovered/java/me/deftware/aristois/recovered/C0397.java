package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0397 extends AbstractMod {
   @C0098(
      value = "Fall speed",
      number = @C0096(
         min = 0.05000000074505806,
         max = 1.0
      )
   )
   private float f_a9ba9208 = 0.125F;

   public C0397() {
      super(C0252.bootstrap<"get",42949673050>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673051>());
   }

   @EventHandler
   public void m_33eae734(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (var2.getVelocity().getY() < 0.0 && var2.isAirBorne() && !var2.isInLiquid() && !var2.isClimbing()) {
         var2.setVelocity(var2.getVelocity().set(0.0, (double)(-this.f_a9ba9208), 0.0));
         var2.setMovementMultiplier(var2.getMovementMultiplier() * 1.21337F);
      }
   }
}
