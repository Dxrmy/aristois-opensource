package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventBlockBreakingSpeed;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.item.effect.AppliedStatusEffect;
import me.deftware.client.framework.item.effect.StatusEffect;
import me.deftware.client.framework.registry.StatusEffectRegistry;

public class C0361 extends AbstractMod {
   @C0098(
      value = "Multiplier",
      number = @C0096(
         min = 1.0,
         max = 10.0
      )
   )
   private float f_8ee81c7c = 1.4F;
   @C0098("Mode")
   private C0102<C0361.anonymousconst> f_2272ffdc = new C0102<>(C0361.anonymousconst.f_eb3b943e);
   private final StatusEffect f_ad7a45c1;

   public C0361() {
      super(C0252.bootstrap<"get",51539607584>(), C0290.f_faada303, C0252.bootstrap<"get",51539607585>());
      this.setMode(this.f_2272ffdc);
      this.f_ad7a45c1 = (StatusEffect)StatusEffectRegistry.INSTANCE.find(C0252.bootstrap<"get",25769803904>()).orElse(null);
   }

   @Override
   public void onDisable() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1 != null && var1.hasStatusEffect(this.f_ad7a45c1)) {
         var1.removeStatusEffect(this.f_ad7a45c1);
      }
   }

   @EventHandler
   public void m_80f72aba(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!var2.hasStatusEffect(this.f_ad7a45c1)) {
         var2.addStatusEffect(new AppliedStatusEffect(this.f_ad7a45c1, 20, this.f_2272ffdc.m_e2691446().m_f87d0ea8(), false, false, false));
      }
   }

   @EventHandler
   public void m_9aa487e6(EventBlockBreakingSpeed var1) {
      var1.setMultiplier(this.f_8ee81c7c);
   }

   private static enum anonymousconst {
      f_eb3b943e(0),
      f_eebffa89(1);

      private final int f_bcaeefb6;

      private anonymousconst(int var3) {
         this.f_bcaeefb6 = var3;
      }

      public int m_f87d0ea8() {
         return this.f_bcaeefb6;
      }
   }
}
