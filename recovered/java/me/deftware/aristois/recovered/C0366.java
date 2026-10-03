package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventBlockBreakingCooldown;

public class C0366 extends AbstractMod {
   public C0366() {
      super(C0255.m_68957b31(), C0290.f_516f3c47, C0255.m_4e02e7a9());
   }

   @EventHandler
   public void m_dfc5de8c(EventBlockBreakingCooldown var1) {
      var1.setCooldown(0);
   }
}
