package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.BoatEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0376 extends AbstractMod {
   @C0098(
      value = "Alt. hold",
      description = {"Holds your altitude, hold CTRL to go down"}
   )
   private boolean f_91b326d3 = false;
   @C0098(
      value = "Mobs",
      description = {"Allow mobs to work with this module, if able"}
   )
   private boolean f_58c5e1d5 = false;
   @C0098(
      value = "Boats",
      description = {"Allow boats to work with this module, if able"}
   )
   private boolean f_0abbe59d = false;

   public C0376() {
      super(C0259.m_a55b07ff(), C0290.f_829d9b20, C0259.m_16315846());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      Entity var3 = var2.getVehicle();
      if (var3 != null && (this.f_0abbe59d && var3 instanceof BoatEntity || this.f_58c5e1d5)) {
         this.m_d8ea8afb(var3, this.f_91b326d3);
      }
   }

   private void m_d8ea8afb(Entity var1, boolean var2) {
      float var3 = MinecraftKeyBind.JUMP.isPressed() ? 0.3F : (var1.isTouchingWater() ? 0.0F : -0.1F);
      if (var2 && var3 == -0.1F && !Keyboard.isCtrlPressed()) {
         var3 = 0.041F;
      }

      var1.setVelocity(var1.getVelocity().set(0.0, (double)var3, 0.0));
   }
}
