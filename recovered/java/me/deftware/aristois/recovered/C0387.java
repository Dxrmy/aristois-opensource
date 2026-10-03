package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0387 extends AbstractMod {
   public C0387() {
      super(C0259.m_fac478b2(), C0290.f_829d9b20, C0259.m_9bf0a29a());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).setHorseJumpPower(1.0F);
   }
}
