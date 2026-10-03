package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.network.packets.CPacketCloseWindow;

public class C0345 extends AbstractMod {
   public C0345() {
      super(C0252.bootstrap<"get",47244640288>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640289>());
   }

   @Override
   public void onEnable() {
      C0114.bootstrap<"call",0,1>().m_77a7bc18(C0252.bootstrap<"get",47244640290>()).m_66e721c0();
   }

   @EventHandler
   public void m_354bee91(EventPacketSend var1) {
      if (var1.getIPacket() instanceof CPacketCloseWindow) {
         var1.setCanceled(true);
      }
   }
}
