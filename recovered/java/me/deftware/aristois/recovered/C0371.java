package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0371 extends AbstractMod {
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 0.009999999776482582,
         max = 0.800000011920929
      )
   )
   private float f_fc0edff7 = 0.2872F;

   public C0371() {
      super(C0259.m_d0e43f69(), C0290.f_829d9b20, C0259.m_812ab029());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var2.isClimbing() && var2.isCollidedHorizontally()) {
         Vector3d var3 = var2.getVelocity();
         var2.setVelocity(var2.getVelocity().set(0.0, (double)this.f_fc0edff7, 0.0));
      }
   }
}
