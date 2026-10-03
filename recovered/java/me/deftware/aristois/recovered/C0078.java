package me.deftware.aristois.recovered;

import java.util.stream.Stream;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.minecraft.Minecraft;

@C0422
@C0099
public class C0078 extends C0086 {
   public C0078() {
      super(C0265.m_c42f1c7e(), C0087.f_80a06470, C0265.m_6f1f396d());
      this.f_676ae6d0 = false;
      this.f_fd8e2fcd = 2;
   }

   @Override
   protected Stream<C0086.anonymousdefault> m_cb07f77b() {
      return Stream.of(
         new C0086.anonymousdefault()
            .m_42140133(C0265.m_8ced16bd(), C0267.m_5b2d5cb2())
            .m_b4a5d70c(() -> this.m_c9fcff7c(Minecraft.getMinecraftGame()._getPlayer())),
         new C0086.anonymousdefault()
            .m_42140133(C0265.m_15ef1a0d(), C0267.m_5b2d5cb2())
            .m_b4a5d70c(() -> Minecraft.getMinecraftGame()._getPlayer().getSaturationLevel()),
         new C0086.anonymousdefault()
            .m_42140133(C0265.m_9793dfe2(), C0267.m_5b2d5cb2())
            .m_b4a5d70c(() -> Minecraft.getMinecraftGame()._getPlayer().getFoodLevel()),
         new C0086.anonymousdefault().m_42140133(C0265.m_1635bc47(), C0267.m_5b2d5cb2()).m_b4a5d70c(C0078::m_3d3a8736),
         new C0086.anonymousdefault().m_42140133(C0265.m_d597c122(), C0267.m_5b2d5cb2()).m_b4a5d70c(WindowHelper::getFPS)
      );
   }

   public static String m_3d3a8736() {
      int var0 = 0;
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1 != null) {
         var0 = var1.getResponseTime();
      }

      return var0 + C0265.m_18204724();
   }

   private String m_c9fcff7c(MainEntityPlayer var1) {
      ItemStack var2 = var1.getInventory().getHeldItem(false);
      if (!var2.isEmpty()) {
         return var2.isDamageable() ? String.valueOf(var2.getMaxDamage() - var2.getDamage()) : C0265.m_cf4f91f1();
      } else {
         return C0261.m_733bff3d();
      }
   }
}
