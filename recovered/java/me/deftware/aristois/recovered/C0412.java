package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0412 extends AbstractMod {
   public C0412() {
      super(C0252.bootstrap<"get",38654705738>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705739>());
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.SPRINT.setPressed(false);
   }

   @EventHandler
   public void m_0772bdb7(EventUpdate var1) {
      if (!ScreenRegistry.Chat.isOpen()) {
         MinecraftKeyBind.SPRINT.setPressed(true);
      }
   }
}
