package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventWeather;

public class C0330 extends AbstractMod {
   public C0330() {
      super(C0252.bootstrap<"get",47244640380>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640381>());
   }

   @EventHandler
   public void m_50105274(EventWeather var1) {
      var1.setCanceled(true);
   }
}
