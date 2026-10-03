package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0365 extends AbstractMod {
   public C0365() {
      super(C0255.m_e9914bd3(), C0290.f_516f3c47, C0255.m_8631f87f());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      Minecraft.getMinecraftGame().setRightClickDelayTimer(0);
   }
}
