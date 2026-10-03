package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0394 extends AbstractMod {
   @C0098(
      value = "Step height",
      description = {"How many blocks you can step up on"}
   )
   private float f_49aa8ce1 = 2.0F;
   @C0098(
      value = "Apply for entities",
      description = {"Apply step height to ridable entities"}
   )
   private boolean f_bc29b54a = false;
   private float f_5db3c907 = 0.0F;

   public C0394() {
      super(C0252.bootstrap<"get",42949673088>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673089>());
   }

   @EventHandler
   public void m_9dd20bff(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (this.f_5db3c907 == 0.0F) {
         this.f_5db3c907 = var2.getStepHeight();
      }

      if (this.f_bc29b54a) {
         Entity var3 = var2.getVehicle();
         if (var3 != null) {
            var3.setStepHeight(this.f_49aa8ce1);
         }
      }

      var2.setStepHeight(this.f_49aa8ce1);
   }

   @Override
   public void onDisable() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1 != null) {
         var1.setStepHeight(this.f_5db3c907);
      }
   }
}
