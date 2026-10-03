package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.BoatEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0376 extends AbstractMod {
   @C0098(
      value = "Alt. hold",
      description = {"Holds your altitude, hold CTRL to go down"}
   )
   private boolean f_7aa5b91b = false;
   @C0098(
      value = "Mobs",
      description = {"Allow mobs to work with this module, if able"}
   )
   private boolean f_ea308a2f = false;
   @C0098(
      value = "Boats",
      description = {"Allow boats to work with this module, if able"}
   )
   private boolean f_5959fb1e = false;

   public C0376() {
      super(C0252.bootstrap<"get",42949673044>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673045>());
   }

   @EventHandler
   public void m_df642786(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      Entity var3 = var2.getVehicle();
      if (var3 != null && (this.f_5959fb1e && var3 instanceof BoatEntity || this.f_ea308a2f)) {
         this.m_fb692fb9(var3, this.f_7aa5b91b);
      }
   }

   private void m_fb692fb9(Entity var1, boolean var2) {
      float var3 = MinecraftKeyBind.JUMP.isPressed() ? 0.3F : (var1.isTouchingWater() ? 0.0F : -0.1F);
      if (var2 && var3 == -0.1F && !C0114.bootstrap<"call",2,1>()) {
         var3 = 0.041F;
      }

      var1.setVelocity(var1.getVelocity().set(0.0, (double)var3, 0.0));
   }
}
