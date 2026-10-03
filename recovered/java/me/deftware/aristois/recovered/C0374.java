package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0374 extends AbstractMod {
   public C0374() {
      super(C0252.bootstrap<"get",42949673015>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673016>());
   }

   @EventHandler
   public void m_9791851f(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      var2.setNoClip(true);
      var2.setFallDistance(0.0F);
      var2.setOnGround(true);
   }
}
