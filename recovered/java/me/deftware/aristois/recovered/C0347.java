package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatReceive;

public class C0347 extends AbstractMod {
   public C0347() {
      super(C0252.bootstrap<"get",47244640264>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640265>());
   }

   @EventHandler
   public void m_3e8bce70(EventChatReceive var1) {
      var1.setCanceled(true);
   }
}
