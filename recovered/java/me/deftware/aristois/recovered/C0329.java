package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRenderPlayerModel;
import me.deftware.client.framework.event.events.EventSetModelVisibilities;

public class C0329 extends AbstractMod {
   public C0329() {
      super(C0255.m_d597c122(), C0290.f_3210deb7, C0255.m_18204724());
   }

   @EventHandler
   public void m_e8d47a61(EventRenderPlayerModel var1) {
      var1.setShouldRender(true);
   }

   @EventHandler
   public void m_633c88c6(EventSetModelVisibilities var1) {
      var1.setSpectator(false);
   }
}
