package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0378 extends AbstractMod {
   @C0098(
      value = "Yaw",
      description = {"Lock your yaw value to the specified value"}
   )
   private boolean f_8dd630b5 = true;
   @C0098(
      value = "Pitch",
      description = {"Lock your pitch value to the specified value"}
   )
   private boolean f_b3a15657 = false;
   @C0098(
      value = "Yaw value",
      number = @C0096(
         min = -180.0,
         max = 180.0
      )
   )
   private float f_ea24609a = 90.0F;
   @C0098(
      value = "Pitch value",
      number = @C0096(
         min = -90.0,
         max = 90.0
      )
   )
   private float f_e5aff334 = 0.0F;

   public C0378() {
      super(C0259.m_4cbaf16f(), C0290.f_829d9b20, C0259.m_678c4ddb());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (this.f_8dd630b5) {
         var2.setRotationYaw(this.f_ea24609a);
      }

      if (this.f_b3a15657) {
         var2.setRotationPitch(this.f_e5aff334);
      }

      Entity var3 = var2.getVehicle();
      if (var3 != null) {
         if (this.f_8dd630b5) {
            var3.setRotationYaw(this.f_ea24609a);
         }

         if (this.f_b3a15657) {
            var3.setRotationPitch(this.f_e5aff334);
         }
      }
   }
}
