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
   private float f_f8fbea33 = 4.0F;

   public C0328() {
      super(C0252.bootstrap<"get",47244640338>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640339>());
   }

   @EventHandler
   public void m_fe786889(EventCameraClip var1) {
      var1.setDistance((double)this.f_f8fbea33);
      var1.setCanceled(true);
   }
}
