package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.gui.ScreenRegistry;

@C0422
@C0099
public class C0349 extends AbstractMod {
   @C0098(
      value = "Open Keybind",
      description = {"Keybind to open the chat window with the emc prefix already typed"},
      keybind = true
   )
   private C0245 f_b9301bd6 = new C0245(46);

   public C0349() {
      super(C0252.bootstrap<"get",47244640272>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640273>());
   }

   @EventHandler
   public void m_5ee34aff(EventKeyAction var1) {
      if (var1.getKeyCode() == this.f_b9301bd6.m_6978c604()) {
         C0114.bootstrap<"call",0,1>().runOnRenderThread(() -> ScreenRegistry.Chat.open(new Object[]{C0114.bootstrap<"call",0,1>()}));
      }
   }
}
