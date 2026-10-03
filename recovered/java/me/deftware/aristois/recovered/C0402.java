package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0402 extends AbstractMod {
   public C0402() {
      super(C0252.bootstrap<"get",38654705705>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705706>());
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.JUMP.setPressed(false);
   }

   @EventHandler
   public void m_8bfe8629(EventUpdate var1) {
      MinecraftKeyBind.JUMP.setPressed(true);
   }
}
