package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

@C0421
public class C0362 extends AbstractMod {
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 0.1,
         max = 6.0
      )
   )
   private float f_2dda2390 = 2.0F;
   @C0098(
      value = "TPSSync",
      description = {"Sync Timer with Server TPS"}
   )
   private boolean f_0b3fc060 = false;

   public C0362() {
      super(C0252.bootstrap<"get",51539607607>(), C0290.f_faada303, C0252.bootstrap<"get",51539607608>());
   }

   @Override
   public void onDisable() {
      C0114.bootstrap<"call",0,1>().getWorldTimer().setTimerSpeed(1.0F);
   }

   @EventHandler
   public void m_15eb9ccc(EventUpdate var1) {
      C0114.bootstrap<"call",0,1>().getWorldTimer().setTimerSpeed(this.f_0b3fc060 ? (float)(C0044.f_35859108.m_b56b2c3d() / 20.0) : this.f_2dda2390);
   }
}
