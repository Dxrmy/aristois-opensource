package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.network.packets.CPacketCloseWindow;

public class C0345 extends AbstractMod {
   public C0345() {
      super(C0260.m_88937f2b(), C0290.f_99d080af, C0260.m_396f9431());
   }

   @Override
   public void onEnable() {
      C0064.m_7853c016().m_ee04ba1b(C0260.m_e9914bd3()).m_1058ed9a();
   }

   @EventHandler
   public void m_2af6dda6(EventPacketSend var1) {
      if (var1.getIPacket() instanceof CPacketCloseWindow) {
         var1.setCanceled(true);
      }
   }
}
