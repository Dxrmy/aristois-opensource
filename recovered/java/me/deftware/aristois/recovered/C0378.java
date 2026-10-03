package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0378 extends AbstractMod {
   @C0098(
      value = "Yaw",
      description = {"Lock your yaw value to the specified value"}
   )
   private boolean f_0a0ca2ba = true;
   @C0098(
      value = "Pitch",
      description = {"Lock your pitch value to the specified value"}
   )
   private boolean f_3340bbb8 = false;
   @C0098(
      value = "Yaw value",
      number = @C0096(
         min = -180.0,
         max = 180.0
      )
   )
   private float f_02a11494 = 90.0F;
   @C0098(
      value = "Pitch value",
      number = @C0096(
         min = -90.0,
         max = 90.0
      )
   )
   private float f_b92c476e = 0.0F;

   public C0378() {
      super(C0252.bootstrap<"get",42949673065>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673066>());
   }

   @EventHandler
   public void m_6e527e8d(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (this.f_0a0ca2ba) {
         var2.setRotationYaw(this.f_02a11494);
      }

      if (this.f_3340bbb8) {
         var2.setRotationPitch(this.f_b92c476e);
      }

      Entity var3 = var2.getVehicle();
      if (var3 != null) {
         if (this.f_0a0ca2ba) {
            var3.setRotationYaw(this.f_02a11494);
         }

         if (this.f_3340bbb8) {
            var3.setRotationPitch(this.f_b92c476e);
         }
      }
   }
}
