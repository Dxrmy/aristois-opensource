package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventSlowdown;
import me.deftware.client.framework.event.events.EventSlowdown.SlowdownType;

public class C0386 extends AbstractMod {
   @C0098("Sneaking")
   private boolean f_2c6337b0 = true;
   @C0098("Eating")
   private boolean f_f3005075 = true;
   @C0098("Webs")
   private boolean f_76a0e99d = true;
   @C0098(
      value = "Blocks",
      description = {"Prevents slowdown/slipperiness with blocks such as soul sand and honey"}
   )
   private boolean f_6685592d = true;
   @C0098("Hunger")
   private boolean f_784b40b7 = true;

   public C0386() {
      super(C0259.m_8870d2c1(), C0290.f_829d9b20, C0259.m_a004d745());
   }

   @EventHandler
   public void m_96d45445(EventSlowdown var1) {
      if (var1.getType().equals(SlowdownType.Web) && this.f_76a0e99d) {
         var1.setCanceled(true);
      } else if (var1.getType().equals(SlowdownType.Sneak) && this.f_2c6337b0) {
         var1.setCanceled(true);
      } else if (var1.getType().equals(SlowdownType.Item_Use) && this.f_f3005075) {
         var1.setCanceled(true);
      } else if (var1.getType().equals(SlowdownType.Hunger) && this.f_784b40b7) {
         var1.setCanceled(true);
      } else if ((
            var1.getType().equals(SlowdownType.Soulsand)
               || var1.getType().equals(SlowdownType.BerryBush)
               || var1.getType().equals(SlowdownType.Slipperiness)
               || var1.getType().equals(SlowdownType.Honey)
         )
         && this.f_6685592d) {
         var1.setCanceled(true);
      } else if (var1.getType().equals(SlowdownType.Blindness)) {
         var1.setCanceled(true);
      }
   }
}
