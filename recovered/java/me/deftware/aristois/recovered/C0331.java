package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

@C0421
public class C0331 extends AbstractMod {
   @C0098(
      value = "Fov multiplier",
      number = @C0096(
         min = 1.0,
         max = 1.5
      )
   )
   private float f_f8822b44 = 1.0F;
   private float f_ec4c47c2 = 1.0F;

   public C0331() {
      super(C0255.m_44418b5d(), C0290.f_3210deb7, C0255.m_813e3509());
   }

   @Override
   public void onEnable() {
      if (Minecraft.getMinecraftGame()._getPlayer() != null) {
         this.f_ec4c47c2 = Minecraft.getMinecraftGame()._getPlayer().getPlayerFovMultiplier();
      }
   }

   @Override
   public void onDisable() {
      if (Minecraft.getMinecraftGame()._getPlayer() != null) {
         Minecraft.getMinecraftGame()._getPlayer().updatePlayerFovMultiplier(this.f_ec4c47c2);
      }
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).updatePlayerFovMultiplier(this.f_f8822b44);
   }
}
