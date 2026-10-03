package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0392 extends AbstractMod {
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 0.0,
         max = 0.800000011920929
      )
   )
   private float f_bb7f5582 = 0.2F;

   public C0392() {
      super(C0252.bootstrap<"get",42949673086>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673087>());
   }

   @EventHandler
   public void m_64a7bab3(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (var2.isCollidedHorizontally()) {
         var2.setVelocity(var2.getVelocity().set(0.0, (double)this.f_bb7f5582, 0.0));
      }
   }
}
