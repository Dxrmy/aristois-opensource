package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0365 extends AbstractMod {
   public C0365() {
      super(C0252.bootstrap<"get",51539607586>(), C0290.f_faada303, C0252.bootstrap<"get",51539607587>());
   }

   @EventHandler
   public void m_cf205081(EventUpdate var1) {
      C0114.bootstrap<"call",0,1>().setRightClickDelayTimer(0);
   }
}
