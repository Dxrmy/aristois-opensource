package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0392 extends AbstractMod {
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 0.0,
         max = 0.800000011920929
      )
   )
   private float f_3dbb5d9e = 0.2F;

   public C0392() {
      super(C0259.m_56c1229f(), C0290.f_829d9b20, C0259.m_0d6ae39b());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var2.isCollidedHorizontally()) {
         var2.setVelocity(var2.getVelocity().set(0.0, (double)this.f_3dbb5d9e, 0.0));
      }
   }
}
