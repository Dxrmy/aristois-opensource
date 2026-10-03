package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0402 extends AbstractMod {
   public C0402() {
      super(C0263.m_3d3a8736(), C0290.f_dbc16475, C0263.m_94acbdac());
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.JUMP.setPressed(false);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MinecraftKeyBind.JUMP.setPressed(true);
   }
}
