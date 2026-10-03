package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

@C0421
public class C0362 extends AbstractMod {
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 0.1,
         max = 6.0
      )
   )
   private float f_d3af6835 = 2.0F;
   @C0098(
      value = "TPSSync",
      description = {"Sync Timer with Server TPS"}
   )
   private boolean f_016e7fcb = false;

   public C0362() {
      super(C0255.m_23f794da(), C0290.f_516f3c47, C0255.m_cc27b633());
   }

   @Override
   public void onDisable() {
      Minecraft.getMinecraftGame().getWorldTimer().setTimerSpeed(1.0F);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      Minecraft.getMinecraftGame().getWorldTimer().setTimerSpeed(this.f_016e7fcb ? (float)(C0044.f_7b762377.m_a005efae() / 20.0) : this.f_d3af6835);
   }
}
