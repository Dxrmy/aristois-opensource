package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.vector.Vector3d;

public class C0371 extends AbstractMod {
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 0.009999999776482582,
         max = 0.800000011920929
      )
   )
   private float f_dd59f335 = 0.2872F;

   public C0371() {
      super(C0252.bootstrap<"get",42949673040>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673041>());
   }

   @EventHandler
   public void m_fc376045(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (var2.isClimbing() && var2.isCollidedHorizontally()) {
         Vector3d var3 = var2.getVelocity();
         var2.setVelocity(var2.getVelocity().set(0.0, (double)this.f_dd59f335, 0.0));
      }
   }
}
