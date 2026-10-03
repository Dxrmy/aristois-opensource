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
   private boolean f_47d30f75 = true;
   @C0098(
      value = "Fluids",
      description = {"Prevents pushing from fluids"}
   )
   private boolean f_6e8a1781 = true;

   public C0398() {
      super(C0252.bootstrap<"get",42949673075>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673076>());
   }

   @EventHandler
   private void m_06eb2ade(EventFluidVelocity var1) {
      if (this.f_6e8a1781) {
         var1.setCanceled(true);
      }
   }

   @EventHandler
   private void m_aac48081(EventEntityPush var1) {
      if (this.f_47d30f75) {
         var1.setCanceled(true);
      }
   }
}
