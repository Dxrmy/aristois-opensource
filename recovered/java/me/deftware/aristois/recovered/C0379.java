package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0379 extends AbstractMod {
   public C0379() {
      super(C0259.m_85cd13b4(), C0290.f_829d9b20, C0259.m_65c7e6e6());
   }

   @Override
   public void onDisable() {
      for (MinecraftKeyBind var4 : MinecraftKeyBind.values()) {
         if (var4 != MinecraftKeyBind.USE_ITEM && var4 != MinecraftKeyBind.ATTACK) {
            var4.setPressed(false);
         }
      }
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (Minecraft.getMinecraftGame().getScreen() instanceof C0433 || Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen) {
         for (MinecraftKeyBind var5 : MinecraftKeyBind.values()) {
            if (var5 != MinecraftKeyBind.USE_ITEM && var5 != MinecraftKeyBind.ATTACK) {
               var5.setPressed(var5.isHeld());
            }
         }
      }
   }
}
