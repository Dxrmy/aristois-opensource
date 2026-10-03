package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0379 extends AbstractMod {
   public C0379() {
      super(C0252.bootstrap<"get",42949673054>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673055>());
   }

   @Override
   public void onDisable() {
      for (MinecraftKeyBind var4 : C0114.bootstrap<"call",0,1>()) {
         if (var4 != MinecraftKeyBind.USE_ITEM && var4 != MinecraftKeyBind.ATTACK) {
            var4.setPressed(false);
         }
      }
   }

   @EventHandler
   public void m_5310b858(EventUpdate var1) {
      if (C0114.bootstrap<"call",0,1>().getScreen() instanceof C0433 || C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen) {
         for (MinecraftKeyBind var5 : C0114.bootstrap<"call",1,1>()) {
            if (var5 != MinecraftKeyBind.USE_ITEM && var5 != MinecraftKeyBind.ATTACK) {
               var5.setPressed(var5.isHeld());
            }
         }
      }
   }
}
