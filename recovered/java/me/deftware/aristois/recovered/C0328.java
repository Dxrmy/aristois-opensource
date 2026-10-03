package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventCameraClip;

public class C0328 extends AbstractMod {
   @C0098(
      value = "Distance",
      description = {"Distance of camera"},
      number = @C0096(
         min = 0.0
      )
   )
   private float f_24cbf1f4 = 4.0F;

   public C0328() {
      super(C0260.m_11f0c704(), C0290.f_3210deb7, C0260.m_19faa493());
   }

   @EventHandler
   public void m_14ec7ed6(EventCameraClip var1) {
      var1.setDistance((double)this.f_24cbf1f4);
      var1.setCanceled(true);
   }
}
