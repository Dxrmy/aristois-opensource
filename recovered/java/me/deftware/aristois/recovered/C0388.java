package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0388 extends AbstractMod {
   public C0388() {
      super(C0260.m_813e3509(), C0290.f_829d9b20, C0260.m_3855be80());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var2.isInLiquid() && !var2.isSneaking()) {
         var2.setVelocity(var2.getVelocity().set(0.0, 0.5, 0.0));
         if (var2.getMoveForward() > 0.0F) {
            var2.setVelocity(var2.getVelocity().getX() * 1.8, var2.getVelocity().getY(), var2.getVelocity().getZ() * 1.8);
            double var3 = Math.sqrt(Math.pow(var2.getVelocity().getX(), 2.0) + Math.pow(var2.getVelocity().getZ(), 2.0));
            double var5 = 10.0;
            if (var3 > var5) {
               var2.setVelocity(var2.getVelocity().getX() / var3 * var5, var2.getVelocity().getY(), var2.getVelocity().getZ() / var3 * var5);
            }
         }
      }
   }
}
