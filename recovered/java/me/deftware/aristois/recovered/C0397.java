package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0397 extends AbstractMod {
   @C0098(
      value = "Fall speed",
      number = @C0096(
         min = 0.05000000074505806,
         max = 1.0
      )
   )
   private float f_bfdebbd4 = 0.125F;

   public C0397() {
      super(C0259.m_bcef2112(), C0290.f_829d9b20, C0259.m_114677c2());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var2.getVelocity().getY() < 0.0 && var2.isAirBorne() && !var2.isInLiquid() && !var2.isClimbing()) {
         var2.setVelocity(var2.getVelocity().set(0.0, (double)(-this.f_bfdebbd4), 0.0));
         var2.setMovementMultiplier(var2.getMovementMultiplier() * 1.21337F);
      }
   }
}
