package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatReceive;

public class C0347 extends AbstractMod {
   public C0347() {
      super(C0260.m_8d7dbe31(), C0290.f_99d080af, C0260.m_1d87ef21());
   }

   @EventHandler
   public void m_f84326ec(EventChatReceive var1) {
      var1.setCanceled(true);
   }
}
