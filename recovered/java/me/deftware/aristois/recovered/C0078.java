package me.deftware.aristois.recovered;

import java.util.stream.Stream;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.item.ItemStack;

@C0422
@C0099
public class C0078 extends C0086 {
   public C0078() {
      super(C0252.bootstrap<"get",30064771082>(), C0087.f_0ff82a38, C0252.bootstrap<"get",30064771083>());
      this.f_c053933f = false;
      this.f_09253326 = 2;
   }

   protected Stream<C0086.anonymousdefault> m_b582ff5f() {
      return C0114.bootstrap<"call",0,1>(
         new C0086.anonymousdefault[]{
            new C0086.anonymousdefault()
               .m_25e003cb(C0252.bootstrap<"get",30064771084>(), C0252.bootstrap<"get",25769803897>())
               .m_a514188a(() -> this.m_e2f3ba7e(C0114.bootstrap<"call",0,1>()._getPlayer())),
            new C0086.anonymousdefault()
               .m_25e003cb(C0252.bootstrap<"get",30064771085>(), C0252.bootstrap<"get",25769803897>())
               .m_a514188a(() -> C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer().getSaturationLevel())),
            new C0086.anonymousdefault()
               .m_25e003cb(C0252.bootstrap<"get",30064771086>(), C0252.bootstrap<"get",25769803897>())
               .m_a514188a(() -> C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer().getFoodLevel())),
            new C0086.anonymousdefault().m_25e003cb(C0252.bootstrap<"get",30064771087>(), C0252.bootstrap<"get",25769803897>()).m_a514188a(C0078::m_489b2b9a),
            new C0086.anonymousdefault()
               .m_25e003cb(C0252.bootstrap<"get",30064771088>(), C0252.bootstrap<"get",25769803897>())
               .m_a514188a(WindowHelper::getFPS)
         }
      );
   }

   public static String m_489b2b9a() {
      int var0 = 0;
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1 != null) {
         var0 = var1.getResponseTime();
      }

      return var0 + C0252.bootstrap<"get",30064771089>();
   }

   private String m_e2f3ba7e(MainEntityPlayer var1) {
      ItemStack var2 = var1.getInventory().getHeldItem(false);
      if (!var2.isEmpty()) {
         return var2.isDamageable() ? C0114.bootstrap<"call",0,1>(var2.getMaxDamage() - var2.getDamage()) : C0252.bootstrap<"get",30064771090>();
      } else {
         return C0252.bootstrap<"get",17179869299>();
      }
   }
}
