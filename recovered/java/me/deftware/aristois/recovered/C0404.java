package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0404 extends AbstractMod {
   public C0404() {
      super(C0252.bootstrap<"get",38654705734>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705735>());
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.SNEAK.setPressed(false);
   }

   @EventHandler
   public void m_26fe80dc(EventUpdate var1) {
      MinecraftKeyBind.SNEAK.setPressed(true);
   }
}
