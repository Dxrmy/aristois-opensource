package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0407 extends AbstractMod {
   public C0407() {
      super(C0252.bootstrap<"get",38654705742>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705743>());
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.FORWARD.setPressed(false);
   }

   @EventHandler
   public void m_db8f999a(EventUpdate var1) {
      MinecraftKeyBind.FORWARD.setPressed(true);
   }
}
