package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0374 extends AbstractMod {
   public C0374() {
      super(C0259.m_23f794da(), C0290.f_829d9b20, C0259.m_cc27b633());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      var2.setNoClip(true);
      var2.setFallDistance(0.0F);
      var2.setOnGround(true);
   }
}
