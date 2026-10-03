package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0353 extends AbstractMod {
   @C0098(
      value = "Delay",
      number = @C0096(
         min = 10.0,
         max = 200.0
      )
   )
   private float f_a3456e5f = 40.0F;
   private float f_df787dae = 0.0F;

   public C0353() {
      super(C0260.m_23f794da(), C0290.f_99d080af, C0260.m_cc27b633());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (this.f_df787dae < this.f_a3456e5f * 2.0F) {
         this.f_df787dae++;
      } else {
         this.f_df787dae = 0.0F;
         Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).toggleSkinLayers();
      }
   }
}
