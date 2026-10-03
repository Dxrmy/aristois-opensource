package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventSneakingCheck;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.math.position.DoubleBlockPosition;

public class C0396 extends AbstractMod {
   @C0098("Mode")
   private C0102<C0396.anonymousconst> f_00da9d63 = new C0102<>(C0396.anonymousconst.f_1dda9e70);

   public C0396() {
      super(C0252.bootstrap<"get",42949673038>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673039>());
      this.setMode(this.f_00da9d63);
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
   public void m_2a9759e8(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (this.f_00da9d63.m_e2691446() == C0396.anonymousconst.f_1dda9e70) {
         if (MinecraftKeyBind.JUMP.isPressed()) {
            MinecraftKeyBind.SNEAK.setPressed(false);
         } else {
            MinecraftKeyBind.SNEAK
               .setPressed(
                  C0114.bootstrap<"call",2,1>()._getBlockFromPosition(new DoubleBlockPosition(var2.getPosX(), var2.getPosY() - 1.0, var2.getPosZ())).isAir()
               );
         }
      }
   }

   @EventHandler
   public void m_97562085(EventSneakingCheck var1) {
      if (this.f_00da9d63.m_e2691446() == C0396.anonymousconst.f_a4e54e90) {
         var1.setSneaking(true);
      }
   }

   public static enum anonymousconst {
      f_1dda9e70,
      f_a4e54e90;

      private anonymousconst() {
      }
   }
}
