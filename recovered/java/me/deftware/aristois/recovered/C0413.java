package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0413 extends AbstractMod {
   public C0413() {
      super(C0263.m_022da1b4(), C0290.f_dbc16475, C0263.m_6e2d03c3());
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.ATTACK.setPressed(false);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MinecraftKeyBind.ATTACK.setPressed(Minecraft.getMinecraftGame().isMouseOver());
   }
}
