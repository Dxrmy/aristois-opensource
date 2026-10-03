package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventEntityPush;
import me.deftware.client.framework.event.events.EventFluidVelocity;

public class C0398 extends AbstractMod {
   @C0098(
      value = "Entities",
      description = {"Prevents pushing from entities"}
   )
   private boolean f_0825cac1 = true;
   @C0098(
      value = "Fluids",
      description = {"Prevents pushing from fluids"}
   )
   private boolean f_344c15e9 = true;

   public C0398() {
      super(C0259.m_733bff3d(), C0290.f_829d9b20, C0259.m_76700429());
   }

   @EventHandler
   private void m_367b927c(EventFluidVelocity var1) {
      if (this.f_344c15e9) {
         var1.setCanceled(true);
      }
   }

   @EventHandler
   private void m_93b1c786(EventEntityPush var1) {
      if (this.f_0825cac1) {
         var1.setCanceled(true);
      }
   }
}
