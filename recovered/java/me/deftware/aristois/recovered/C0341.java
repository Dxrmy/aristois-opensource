package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.network.packets.CPacketRotation;

public class C0341 extends AbstractMod {
   public C0341() {
      super(C0252.bootstrap<"get",47244640274>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640275>());
   }

   @EventHandler
   public void m_573bb682(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      float var3 = var2.getRotationYaw() + (float)(C0114.bootstrap<"call",2,1>() * 360.0 - 180.0);
      float var4 = (float)(C0114.bootstrap<"call",2,1>() * 180.0 - 90.0);
      new CPacketRotation(var3, var4, var2.isOnGround()).sendPacket();
   }
}
