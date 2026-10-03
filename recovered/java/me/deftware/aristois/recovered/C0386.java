package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventSlowdown;
import me.deftware.client.framework.event.events.EventSlowdown.SlowdownType;

public class C0386 extends AbstractMod {
   @C0098("Sneaking")
   private boolean f_ab755b60 = true;
   @C0098("Eating")
   private boolean f_f0c084be = true;
   @C0098("Webs")
   private boolean f_a88dbecb = true;
   @C0098(
      value = "Blocks",
      description = {"Prevents slowdown/slipperiness with blocks such as soul sand and honey"}
   )
   private boolean f_55e5160c = true;
   @C0098("Hunger")
   private boolean f_551f506b = true;

   public C0386() {
      super(C0252.bootstrap<"get",42949673077>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673078>());
   }

   @EventHandler
   public void m_628de4ba(EventSlowdown var1) {
      if (var1.getType().equals(SlowdownType.Web) && this.f_a88dbecb) {
         var1.setCanceled(true);
      } else if (var1.getType().equals(SlowdownType.Sneak) && this.f_ab755b60) {
         var1.setCanceled(true);
      } else if (var1.getType().equals(SlowdownType.Item_Use) && this.f_f0c084be) {
         var1.setCanceled(true);
      } else if (var1.getType().equals(SlowdownType.Hunger) && this.f_551f506b) {
         var1.setCanceled(true);
      } else if ((
            var1.getType().equals(SlowdownType.Soulsand)
               || var1.getType().equals(SlowdownType.BerryBush)
               || var1.getType().equals(SlowdownType.Slipperiness)
               || var1.getType().equals(SlowdownType.Honey)
         )
         && this.f_55e5160c) {
         var1.setCanceled(true);
      } else if (var1.getType().equals(SlowdownType.Blindness)) {
         var1.setCanceled(true);
      }
   }
}
