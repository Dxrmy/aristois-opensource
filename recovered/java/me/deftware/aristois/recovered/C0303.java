package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventGameOver;

public class C0303 extends AbstractMod {
   public C0303() {
      super(C0252.bootstrap<"get",38654705774>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705775>());
   }

   @EventHandler
   public void m_c1005085(EventGameOver var1) {
      ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).respawn();
   }
}
