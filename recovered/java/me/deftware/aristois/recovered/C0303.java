package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventGameOver;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0303 extends AbstractMod {
   public C0303() {
      super(C0263.m_1472ab32(), C0290.f_4b7b2d37, C0263.m_a5b24d28());
   }

   @EventHandler
   public void m_cf449f57(EventGameOver var1) {
      Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).respawn();
   }
}
