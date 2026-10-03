package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

@C0421
public class C0331 extends AbstractMod {
   @C0098(
      value = "Fov multiplier",
      number = @C0096(
         min = 1.0,
         max = 1.5
      )
   )
   private float f_65ccbaf3 = 1.0F;
   private float f_30bb85f3 = 1.0F;

   public C0331() {
      super(C0252.bootstrap<"get",51539607552>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",51539607553>());
   }

   @Override
   public void onEnable() {
      if (C0114.bootstrap<"call",0,1>()._getPlayer() != null) {
         this.f_30bb85f3 = C0114.bootstrap<"call",0,1>()._getPlayer().getPlayerFovMultiplier();
      }
   }

   @Override
   public void onDisable() {
      if (C0114.bootstrap<"call",0,1>()._getPlayer() != null) {
         C0114.bootstrap<"call",0,1>()._getPlayer().updatePlayerFovMultiplier(this.f_30bb85f3);
      }
   }

   @EventHandler
   public void m_e4ad9573(EventUpdate var1) {
      ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).updatePlayerFovMultiplier(this.f_65ccbaf3);
   }
}
