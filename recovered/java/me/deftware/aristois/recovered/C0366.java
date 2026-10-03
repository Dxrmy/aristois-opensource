package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventBlockBreakingCooldown;

public class C0366 extends AbstractMod {
   public C0366() {
      super(C0252.bootstrap<"get",51539607598>(), C0290.f_faada303, C0252.bootstrap<"get",51539607599>());
   }

   @EventHandler
   public void m_bfd4407b(EventBlockBreakingCooldown var1) {
      var1.setCooldown(0);
   }
}
