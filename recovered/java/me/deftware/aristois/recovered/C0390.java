package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0390 extends AbstractMod {
   @C0098(
      value = "Mode",
      description = {"Speed wont affect Jumpy mode"}
   )
   private C0102<C0390.anonymousconst> f_47d0446b = new C0102<>(C0390.anonymousconst.f_3332a938);
   @C0098(
      value = "Speed",
      number = @C0096(
         max = 2.0
      )
   )
   private C0106<Double> f_42c9d966 = new C0106<>(1.0).m_2d6ca2bd(this.f_47d0446b, C0390.anonymousconst.f_3332a938);

   public C0390() {
      super(C0259.m_c04d8f6e(), C0290.f_829d9b20, C0259.m_2dc36b02());
      this.setMode(this.f_47d0446b);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (MinecraftKeyBind.JUMP.isPressed()) {
         if (this.f_47d0446b.m_284992ec() == C0390.anonymousconst.f_c138e725) {
            var2.doJump();
         } else {
            var2.setVelocity(var2.getVelocity().set(0.0, this.f_42c9d966.get(), 0.0));
         }
      }
   }

   public static enum anonymousconst {
      f_3332a938,
      f_c138e725;

      private anonymousconst() {
      }
   }
}
