package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventSneakingCheck;

public class C0393 extends AbstractMod {
   public C0393() {
      super(C0259.m_1616e137(), C0290.f_829d9b20, C0259.m_3c19a819());
   }

   @EventHandler
   public void m_9a134868(EventSneakingCheck var1) {
      var1.setSneaking(true);
   }
}
