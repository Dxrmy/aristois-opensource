package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventWeather;

public class C0330 extends AbstractMod {
   public C0330() {
      super(C0260.m_ec4ef19a(), C0290.f_3210deb7, C0260.m_83f6dd00());
   }

   @EventHandler
   public void m_c21fae39(EventWeather var1) {
      var1.setCanceled(true);
   }
}
