package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0387 extends AbstractMod {
   public C0387() {
      super(C0252.bootstrap<"get",42949673052>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673053>());
   }

   @EventHandler
   public void m_65812eeb(EventUpdate var1) {
      ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).setHorseJumpPower(1.0F);
   }
}
