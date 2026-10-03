package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketPlayer;

public class C0311 extends AbstractMod {
   @C0098(
      value = "Speed",
      description = {"Regen speed"},
      number = @C0096(
         min = 100.0,
         max = 1000.0
      )
   )
   private float f_b32f63c3 = 100.0F;

   public C0311() {
      super(C0263.m_a004d745(), C0290.f_4b7b2d37, C0263.m_3c19a819());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!var2.isCreative() && var2.getFoodLevel() > 17 && var2.getHealth() < 20.0F && var2.getHealth() != 0.0F && var2.isOnGround()) {
         for (int var3 = 0; (float)var3 < this.f_b32f63c3; var3++) {
            new CPacketPlayer().sendPacket();
         }
      }
   }
}
