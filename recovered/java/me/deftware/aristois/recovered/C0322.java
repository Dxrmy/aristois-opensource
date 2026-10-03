package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0322 extends AbstractMod {
   public C0322() {
      super(C0260.m_56c1229f(), C0290.f_3210deb7, C0260.m_0d6ae39b());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      this.m_23674f64();
   }

   private void m_23674f64() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1 != null) {
         var1.setInPortal(false);
      }
   }
}
