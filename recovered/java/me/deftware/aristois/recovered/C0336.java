package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventEntityRender;
import me.deftware.client.framework.event.events.EventParticle;
import me.deftware.client.framework.gui.GuiScreen;

public class C0336 extends AbstractMod {
   private final C0201 f_7324d8a8 = new C0201(C0252.bootstrap<"get",47244640379>());
   @C0098(
      value = "Entities",
      description = {"Entities to not render"}
   )
   private final GuiScreen f_b6ee181c = C0114.bootstrap<"call",0,1>(null, this.f_7324d8a8);
   @C0098(
      value = "Particles",
      description = {"Disable rendering particles"}
   )
   private boolean f_89c71455 = false;

   public C0336() {
      super(C0252.bootstrap<"get",47244640377>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640378>());
   }

   @EventHandler
   private void m_ddde6a19(EventEntityRender var1) {
      if (this.f_7324d8a8.m_4fb0d5ef(var1.getEntity())) {
         var1.setCanceled(true);
      }
   }

   @EventHandler
   private void m_27ad1286(EventParticle var1) {
      if (this.f_89c71455) {
         var1.setCanceled(true);
      }
   }

   public C0201 m_66a5d8ff() {
      return this.f_7324d8a8;
   }
}
