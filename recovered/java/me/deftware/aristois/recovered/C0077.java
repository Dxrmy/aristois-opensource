package me.deftware.aristois.recovered;

import java.util.stream.Stream;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.item.effect.AppliedStatusEffect;

@C0422
@C0099
public class C0077 extends C0086 {
   @C0098(
      value = "Vanilla Overlay",
      description = {"Disable the default top-right effect overlay"}
   )
   private C0104<Boolean> f_94d55ae2 = new C0104<>(GameKeys.EFFECT_OVERLAY, C0114.bootstrap<"call",0,1>(false)).m_958520b0(this);
   private int f_353db0b7 = 0;

   public C0077() {
      super(C0252.bootstrap<"get",25769803898>(), C0087.f_5d3a6581, C0252.bootstrap<"get",25769803899>());
      this.f_aaa984b7 = false;
   }

   public static String m_e67dd7ea(AppliedStatusEffect var0) {
      String var1 = C0114.bootstrap<"call",0,1>(var0.getEffect().getIdentifierKey());
      return var1 + C0252.bootstrap<"get",70>() + C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803900>() + (var0.getAmplifier() + 1));
   }

   public static String m_6bc0f977(AppliedStatusEffect var0) {
      if (var0.isPermanent()) {
         return C0252.bootstrap<"get",25769803901>();
      } else {
         int var1 = (int)C0114.bootstrap<"call",0,1>((double)var0.getDuration());
         int var2 = var1 / 20;
         int var3 = var2 / 60;
         var2 %= 60;
         return var2 < 10 ? var3 + C0252.bootstrap<"get",25769803902>() + var2 : var3 + C0252.bootstrap<"get",25769803903>() + var2;
      }
   }

   @EventHandler
   private void m_02c05e8d(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()._getPlayer());
      if (var2.getStatusEffects().size() != this.f_353db0b7) {
         this.f_353db0b7 = var2.getStatusEffects().size();
         this.m_3c017389();
      }
   }

   protected Stream<C0086.anonymousdefault> m_222ead71() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      return var1 != null && !var1.getStatusEffects().isEmpty()
         ? var1.getStatusEffects()
            .stream()
            .filter(this::m_88fd9508)
            .map(var1x -> var1.getStatusEffect(var1x.getEffect()))
            .map(
               var0 -> new C0086.anonymousdefault()
                     .m_25e003cb(C0252.bootstrap<"get",25769803897>(), C0252.bootstrap<"get",25769803897>())
                     .m_a514188a(() -> C0114.bootstrap<"call",0,1>(var0), () -> C0114.bootstrap<"call",2,1>(var0))
            )
            .sorted((var0, var1x) -> (int)(var1x.m_7c2d1617() - var0.m_7c2d1617()))
         : C0114.bootstrap<"call",1,1>();
   }

   private boolean m_88fd9508(AppliedStatusEffect var1) {
      return var1.getEffect().getIdentifierKey().toLowerCase().contains(C0252.bootstrap<"get",25769803904>())
         ? !C0114.bootstrap<"call",0,1>(C0361.class)
         : true;
   }
}
