package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRenderPlayerModel;
import me.deftware.client.framework.event.events.EventSetModelVisibilities;

public class C0329 extends AbstractMod {
   public C0329() {
      super(C0252.bootstrap<"get",51539607568>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",51539607569>());
   }

   @EventHandler
   public void m_9ca7aeec(EventRenderPlayerModel var1) {
      var1.setShouldRender(true);
   }

   @EventHandler
   public void m_34a1e0a5(EventSetModelVisibilities var1) {
      var1.setSpectator(false);
   }
}
