package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0381 extends AbstractMod {
   public C0381() {
      super(C0259.m_11f0c704(), C0290.f_829d9b20, C0259.m_19faa493());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var2.isInLiquid() && !var2.isSneaking()) {
         Vector3d var3 = var2.getVelocity();
         var2.setVelocity(var3.getX(), 0.0, var3.getZ());
      }
   }
}
