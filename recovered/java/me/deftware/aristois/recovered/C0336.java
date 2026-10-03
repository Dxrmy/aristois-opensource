package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventEntityRender;
import me.deftware.client.framework.event.events.EventParticle;
import me.deftware.client.framework.gui.GuiScreen;

public class C0336 extends AbstractMod {
   private final C0201 f_2c65c36c = new C0201(C0260.m_62895921());
   @C0098(
      value = "Entities",
      description = {"Entities to not render"}
   )
   private final GuiScreen f_fdaef9ca = C0217.m_c1fb6c03(null, this.f_2c65c36c);
   @C0098(
      value = "Particles",
      description = {"Disable rendering particles"}
   )
   private boolean f_1586ec36 = false;

   public C0336() {
      super(C0260.m_5b2d5cb2(), C0290.f_3210deb7, C0260.m_56cd5284());
   }

   @EventHandler
   private void m_eb0fa042(EventEntityRender var1) {
      if (this.f_2c65c36c.m_97a0a4cb(var1.getEntity())) {
         var1.setCanceled(true);
      }
   }

   @EventHandler
   private void m_6ea1db31(EventParticle var1) {
      if (this.f_1586ec36) {
         var1.setCanceled(true);
      }
   }

   public C0201 m_95db1db3() {
      return this.f_2c65c36c;
   }
}
