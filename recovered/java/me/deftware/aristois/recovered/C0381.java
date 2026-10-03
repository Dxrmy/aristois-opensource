package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.vector.Vector3d;

public class C0381 extends AbstractMod {
   public C0381() {
      super(C0252.bootstrap<"get",42949673042>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673043>());
   }

   @EventHandler
   public void m_d9b7a38e(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (var2.isInLiquid() && !var2.isSneaking()) {
         Vector3d var3 = var2.getVelocity();
         var2.setVelocity(var3.getX(), 0.0, var3.getZ());
      }
   }
}
