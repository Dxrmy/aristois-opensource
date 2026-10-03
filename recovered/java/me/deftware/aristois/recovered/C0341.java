package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketRotation;

public class C0341 extends AbstractMod {
   public C0341() {
      super(C0260.m_cf4f91f1(), C0290.f_99d080af, C0260.m_b251ca51());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      float var3 = var2.getRotationYaw() + (float)(Math.random() * 360.0 - 180.0);
      float var4 = (float)(Math.random() * 180.0 - 90.0);
      new CPacketRotation(var3, var4, var2.isOnGround()).sendPacket();
   }
}
