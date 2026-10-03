package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPlayerWalking;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0380 extends AbstractMod {
   private boolean f_11d28dfb = false;
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 2.0,
         max = 9.0
      )
   )
   private int f_3f51bf6f = 2;

   public C0380() {
      super(C0259.m_f257bcca(), C0290.f_829d9b20, C0259.m_d9b37a36());
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.JUMP.setPressed(false);
      MinecraftKeyBind.SPRINT.setPressed(false);
   }

   @Override
   public void onEnable() {
      MinecraftKeyBind.JUMP.setPressed(false);
      MinecraftKeyBind.SPRINT.setPressed(false);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (Minecraft.getMinecraftGame().getScreen() == null && !C0289.m_5caae0c3(C0375.class) && !var2.isFlying()) {
         if (MinecraftKeyBind.FORWARD.isPressed()
            || C0289.m_5caae0c3(C0407.class)
            || MinecraftKeyBind.BACK.isPressed()
            || MinecraftKeyBind.LEFT.isPressed()
            || MinecraftKeyBind.RIGHT.isPressed()) {
            this.f_11d28dfb = true;
            MinecraftKeyBind.JUMP.setPressed(true);
            MinecraftKeyBind.SPRINT.setPressed(true);
         } else if (this.f_11d28dfb) {
            this.f_11d28dfb = false;
            MinecraftKeyBind.JUMP.setPressed(false);
         }
      }
   }

   @EventHandler
   public void m_33949d34(EventPlayerWalking var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      var2.setMovementMultiplier(Float.parseFloat(C0259.m_15737526() + this.f_3f51bf6f));
   }
}
