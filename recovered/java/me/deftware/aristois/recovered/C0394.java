package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0394 extends AbstractMod {
   @C0098(
      value = "Step height",
      description = {"How many blocks you can step up on"}
   )
   private float f_feefd6dc = 2.0F;
   @C0098(
      value = "Apply for entities",
      description = {"Apply step height to ridable entities"}
   )
   private boolean f_f095a558 = false;
   private float f_f46eef62 = 0.0F;

   public C0394() {
      super(C0259.m_65d43991(), C0290.f_829d9b20, C0259.m_c6614274());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (this.f_f46eef62 == 0.0F) {
         this.f_f46eef62 = var2.getStepHeight();
      }

      if (this.f_f095a558) {
         Entity var3 = var2.getVehicle();
         if (var3 != null) {
            var3.setStepHeight(this.f_feefd6dc);
         }
      }

      var2.setStepHeight(this.f_feefd6dc);
   }

   @Override
   public void onDisable() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1 != null) {
         var1.setStepHeight(this.f_f46eef62);
      }
   }
}
