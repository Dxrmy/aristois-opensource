package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0389 extends AbstractMod {
   @C0098(
      value = "Riding speed",
      number = @C0096(
         min = 0.5
      )
   )
   public float f_af0c8367 = 5.0F;
   @C0098(
      value = "Walk speed",
      number = @C0096(
         min = 0.5,
         max = 2.0
      )
   )
   private float f_60606186 = 0.4F;
   @C0098("Apply for entities")
   private boolean f_d9e1b3c1 = true;
   @C0098(
      value = "AutoDisable",
      description = {"Automatically pause speed while sneaking"}
   )
   private boolean f_54e808ef = true;

   public C0389() {
      super(C0252.bootstrap<"get",30064771078>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673085>());
   }

   @EventHandler
   public void m_a27a7824(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!MinecraftKeyBind.SNEAK.isPressed() || this.f_54e808ef) {
         if (this.f_d9e1b3c1) {
            Entity var3 = var2.getVehicle();
            if (var3 != null) {
               this.m_b23bbfe1(var3, var2, this.f_af0c8367 / 2.0F);
            }
         }

         if (!var2.isRiding()) {
            this.m_b23bbfe1(var2, var2, this.f_60606186);
         }
      }
   }

   private void m_b23bbfe1(Entity var1, MainEntityPlayer var2, float var3) {
      float var4 = var2.getRotationYaw();
      double var5 = var2.getForward();
      double var7 = var2.getStrafe();
      if (var5 == 0.0 && var7 == 0.0) {
         var1.setVelocity(0.0, var1.getVelocity().getY(), 0.0);
      } else {
         if (var5 != 0.0) {
            if (var7 > 0.0) {
               var4 += (float)(var5 > 0.0 ? -45 : 45);
            } else if (var7 < 0.0) {
               var4 += (float)(var5 > 0.0 ? 45 : -45);
            }

            var7 = 0.0;
            if (var5 > 0.0) {
               var5 = 1.0;
            } else if (var5 < 0.0) {
               var5 = -1.0;
            }
         }

         var1.setVelocity(
            var5 * (double)var3 * C0114.bootstrap<"call",3,1>((double)((float)C0114.bootstrap<"call",2,1>((double)(var4 + 90.0F))))
               + var7 * (double)var3 * C0114.bootstrap<"call",4,1>((double)((float)C0114.bootstrap<"call",2,1>((double)(var4 + 90.0F)))),
            var1.getVelocity().getY(),
            var5 * (double)var3 * C0114.bootstrap<"call",4,1>((double)((float)C0114.bootstrap<"call",2,1>((double)(var4 + 90.0F))))
               - var7 * (double)var3 * C0114.bootstrap<"call",3,1>((double)((float)C0114.bootstrap<"call",2,1>((double)(var4 + 90.0F))))
         );
      }
   }
}
