package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventBlockBreakingSpeed;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.item.effect.AppliedStatusEffect;
import me.deftware.client.framework.item.effect.StatusEffect;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.registry.StatusEffectRegistry;

public class C0361 extends AbstractMod {
   @C0098(
      value = "Multiplier",
      number = @C0096(
         min = 1.0,
         max = 10.0
      )
   )
   private float f_c14a72f9 = 1.4F;
   @C0098("Mode")
   private C0102<C0361.anonymousconst> f_52612b9c = new C0102<>(C0361.anonymousconst.f_8ef863f2);
   private final StatusEffect f_2ca5e693;

   public C0361() {
      super(C0255.m_88937f2b(), C0290.f_516f3c47, C0255.m_396f9431());
      this.setMode(this.f_52612b9c);
      this.f_2ca5e693 = (StatusEffect)StatusEffectRegistry.INSTANCE.find(C0267.m_65d43991()).orElse(null);
   }

   @Override
   public void onDisable() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1 != null && var1.hasStatusEffect(this.f_2ca5e693)) {
         var1.removeStatusEffect(this.f_2ca5e693);
      }
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!var2.hasStatusEffect(this.f_2ca5e693)) {
         var2.addStatusEffect(new AppliedStatusEffect(this.f_2ca5e693, 20, this.f_52612b9c.m_284992ec().m_5b3d3148(), false, false, false));
      }
   }

   @EventHandler
   public void m_a11087bc(EventBlockBreakingSpeed var1) {
      var1.setMultiplier(this.f_c14a72f9);
   }

   private static enum anonymousconst {
      f_8ef863f2(0),
      f_832dcfa0(1);

      private final int f_9831769e;

      private anonymousconst(int var3) {
         this.f_9831769e = var3;
      }

      public int m_5b3d3148() {
         return this.f_9831769e;
      }
   }
}
