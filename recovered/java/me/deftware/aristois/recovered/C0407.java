package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0407 extends AbstractMod {
   public C0407() {
      super(C0263.m_6dc2a812(), C0290.f_dbc16475, C0263.m_e7934778());
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.FORWARD.setPressed(false);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MinecraftKeyBind.FORWARD.setPressed(true);
   }
}
