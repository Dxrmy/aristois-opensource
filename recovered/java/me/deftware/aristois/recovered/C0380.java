package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPlayerWalking;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0380 extends AbstractMod {
   private boolean f_a79b293b = false;
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 2.0,
         max = 9.0
      )
   )
   private int f_4402b1bf = 2;

   public C0380() {
      super(C0252.bootstrap<"get",42949673021>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673022>());
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
   public void m_6a6ab90a(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (C0114.bootstrap<"call",0,1>().getScreen() == null && !C0114.bootstrap<"call",2,1>(C0375.class) && !var2.isFlying()) {
         if (MinecraftKeyBind.FORWARD.isPressed()
            || C0114.bootstrap<"call",2,1>(C0407.class)
            || MinecraftKeyBind.BACK.isPressed()
            || MinecraftKeyBind.LEFT.isPressed()
            || MinecraftKeyBind.RIGHT.isPressed()) {
            this.f_a79b293b = true;
            MinecraftKeyBind.JUMP.setPressed(true);
            MinecraftKeyBind.SPRINT.setPressed(true);
         } else if (this.f_a79b293b) {
            this.f_a79b293b = false;
            MinecraftKeyBind.JUMP.setPressed(false);
         }
      }
   }

   @EventHandler
   public void m_6db61bd8(EventPlayerWalking var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      var2.setMovementMultiplier(C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",42949673023>() + this.f_4402b1bf));
   }
}
