package me.deftware.aristois.recovered;

import java.util.Objects;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.item.effect.AppliedStatusEffect;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.TranslationUtil;

@C0422
@C0099
public class C0077 extends C0086 {
   @C0098(
      value = "Vanilla Overlay",
      description = {"Disable the default top-right effect overlay"}
   )
   private C0104<Boolean> f_3d06aaae = new C0104<>(GameKeys.EFFECT_OVERLAY, false).m_43d84283(this);
   private int f_da45f92b = 0;

   public C0077() {
      super(C0267.m_56cd5284(), C0087.f_5cabf205, C0267.m_62895921());
      this.f_676ae6d0 = false;
   }

   public static String m_5f7c8e4e(AppliedStatusEffect var0) {
      String var1 = TranslationUtil.translate(var0.getEffect().getIdentifierKey());
      return var1 + C0257.m_593ecbab() + TranslationUtil.translate(C0267.m_ec4ef19a() + (var0.getAmplifier() + 1));
   }

   public static String m_5197f203(AppliedStatusEffect var0) {
      if (var0.isPermanent()) {
         return C0267.m_83f6dd00();
      } else {
         int var1 = (int)Math.floor((double)var0.getDuration());
         int var2 = var1 / 20;
         int var3 = var2 / 60;
         var2 %= 60;
         return var2 < 10 ? var3 + C0267.m_56c1229f() + var2 : var3 + C0267.m_0d6ae39b() + var2;
      }
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var2.getStatusEffects().size() != this.f_da45f92b) {
         this.f_da45f92b = var2.getStatusEffects().size();
         this.m_083b6d08();
      }
   }

   @Override
   protected Stream<C0086.anonymousdefault> m_cb07f77b() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      return var1 != null && !var1.getStatusEffects().isEmpty()
         ? var1.getStatusEffects()
            .stream()
            .filter(this::m_a0fdfad4)
            .map(var1x -> var1.getStatusEffect(var1x.getEffect()))
            .map(
               var0 -> new C0086.anonymousdefault()
                     .m_42140133(C0267.m_5b2d5cb2(), C0267.m_5b2d5cb2())
                     .m_b4a5d70c(() -> m_5f7c8e4e(var0), () -> m_5197f203(var0))
            )
            .sorted((var0, var1x) -> (int)(var1x.m_4388ac29() - var0.m_4388ac29()))
         : Stream.empty();
   }

   private boolean m_a0fdfad4(AppliedStatusEffect var1) {
      return var1.getEffect().getIdentifierKey().toLowerCase().contains(C0267.m_65d43991()) ? !C0289.m_5caae0c3(C0361.class) : true;
   }
}
