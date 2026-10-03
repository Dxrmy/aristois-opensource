package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
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
   private float f_e3854871 = 100.0F;

   public C0311() {
      super(C0252.bootstrap<"get",38654705782>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705783>());
   }

   @EventHandler
   public void m_6d419aad(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!var2.isCreative() && var2.getFoodLevel() > 17 && var2.getHealth() < 20.0F && var2.getHealth() != 0.0F && var2.isOnGround()) {
         for (int var3 = 0; (float)var3 < this.f_e3854871; var3++) {
            new CPacketPlayer().sendPacket();
         }
      }
   }
}
