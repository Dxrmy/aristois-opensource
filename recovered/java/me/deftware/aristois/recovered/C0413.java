package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0413 extends AbstractMod {
   public C0413() {
      super(C0252.bootstrap<"get",38654705707>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705708>());
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.ATTACK.setPressed(false);
   }

   @EventHandler
   public void m_dd2caad1(EventUpdate var1) {
      MinecraftKeyBind.ATTACK.setPressed(C0114.bootstrap<"call",0,1>().isMouseOver());
   }
}
