package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0388 extends AbstractMod {
   public C0388() {
      super(C0252.bootstrap<"get",47244640257>(), C0290.f_cd638c01, C0252.bootstrap<"get",47244640258>());
   }

   @EventHandler
   public void m_db4bca00(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (var2.isInLiquid() && !var2.isSneaking()) {
         var2.setVelocity(var2.getVelocity().set(0.0, 0.5, 0.0));
         if (var2.getMoveForward() > 0.0F) {
            var2.setVelocity(var2.getVelocity().getX() * 1.8, var2.getVelocity().getY(), var2.getVelocity().getZ() * 1.8);
            double var3 = C0114.bootstrap<"call",3,1>(
               C0114.bootstrap<"call",2,1>(var2.getVelocity().getX(), 2.0) + C0114.bootstrap<"call",2,1>(var2.getVelocity().getZ(), 2.0)
            );
            double var5 = 10.0;
            if (var3 > var5) {
               var2.setVelocity(var2.getVelocity().getX() / var3 * var5, var2.getVelocity().getY(), var2.getVelocity().getZ() / var3 * var5);
            }
         }
      }
   }
}
