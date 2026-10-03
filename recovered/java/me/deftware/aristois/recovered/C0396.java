package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventSneakingCheck;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.ClientWorld;

public class C0396 extends AbstractMod {
   @C0098("Mode")
   private C0102<C0396.anonymousconst> f_7bf8440d = new C0102<>(C0396.anonymousconst.f_b3a4b4e2);

   public C0396() {
      super(C0259.m_6dc2a812(), C0290.f_829d9b20, C0259.m_e7934778());
      this.setMode(this.f_7bf8440d);
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.SNEAK.setPressed(false);
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      MinecraftKeyBind.SNEAK.setPressed(false);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (this.f_7bf8440d.m_284992ec() == C0396.anonymousconst.f_b3a4b4e2) {
         if (MinecraftKeyBind.JUMP.isPressed()) {
            MinecraftKeyBind.SNEAK.setPressed(false);
         } else {
            MinecraftKeyBind.SNEAK
               .setPressed(
                  ClientWorld.getClientWorld()._getBlockFromPosition(new DoubleBlockPosition(var2.getPosX(), var2.getPosY() - 1.0, var2.getPosZ())).isAir()
               );
         }
      }
   }

   @EventHandler
   public void m_9a134868(EventSneakingCheck var1) {
      if (this.f_7bf8440d.m_284992ec() == C0396.anonymousconst.f_5a338bf3) {
         var1.setSneaking(true);
      }
   }

   public static enum anonymousconst {
      f_b3a4b4e2,
      f_5a338bf3;

      private anonymousconst() {
      }
   }
}
