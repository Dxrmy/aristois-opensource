package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0390 extends AbstractMod {
   @C0098(
      value = "Mode",
      description = {"Speed wont affect Jumpy mode"}
   )
   private C0102<C0390.anonymousconst> f_15efabfc = new C0102<>(C0390.anonymousconst.f_51f32afc);
   @C0098(
      value = "Speed",
      number = @C0096(
         max = 2.0
      )
   )
   private C0106<Double> f_8f44a76a = new C0106<>(C0114.bootstrap<"call",0,1>(1.0)).m_10caee7d(this.f_15efabfc, C0390.anonymousconst.f_51f32afc);

   public C0390() {
      super(C0252.bootstrap<"get",42949673063>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673064>());
      this.setMode(this.f_15efabfc);
   }

   @EventHandler
   public void m_71ebbd80(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (MinecraftKeyBind.JUMP.isPressed()) {
         if (this.f_15efabfc.m_e2691446() == C0390.anonymousconst.f_e2e2a132) {
            var2.doJump();
         } else {
            var2.setVelocity(var2.getVelocity().set(0.0, this.f_8f44a76a.get(), 0.0));
         }
      }
   }

   public static enum anonymousconst {
      f_51f32afc,
      f_e2e2a132;

      private anonymousconst() {
      }
   }
}
