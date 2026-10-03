package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventSneakingCheck;

public class C0393 extends AbstractMod {
   public C0393() {
      super(C0252.bootstrap<"get",42949673037>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673079>());
   }

   @EventHandler
   public void m_1868d1e8(EventSneakingCheck var1) {
      var1.setSneaking(true);
   }
}
