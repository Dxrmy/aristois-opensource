package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.function.Supplier;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.minecraft.GameSetting.GuiScaleSetting;

public enum C0087 {
   f_7fb0edf4(C0087::m_0b83410d, C0087::m_0b83410d),
   f_4ea7c28e(C0087.anonymousdefault::m_84808068, C0087::m_0b83410d),
   f_993458d0(C0087.anonymousdefault::m_a005efae, C0087::m_0b83410d),
   f_5cabf205(C0087::m_0b83410d, C0087.anonymousthis::m_84808068),
   f_e9680a83(C0087.anonymousdefault::m_a005efae, C0087.anonymousthis::m_84808068),
   f_80a06470(C0087::m_0b83410d, C0087.anonymousthis::m_a005efae),
   f_a96599e0(C0087.anonymousdefault::m_a005efae, C0087.anonymousthis::m_a005efae);

   private final Supplier<Double> f_6e6dfce0;
   private final Supplier<Double> f_6bd3723d;

   private C0087(Supplier<Double> var3, Supplier<Double> var4) {
      this.f_6e6dfce0 = var3;
      this.f_6bd3723d = var4;
   }

   public void m_9fb2cb0e(C0075... var1) {
      double var2 = this.f_6e6dfce0.get();
      double var4 = this.f_6bd3723d.get();
      double var6 = Arrays.stream(var1).filter(C0075::m_89e0519f).mapToDouble(C0075::m_a005efae).sum();
      if (this.m_51ce03a5()) {
         var4 -= var6;
         if (ScreenRegistry.Chat.isOpen()) {
            if (this.m_e606d819()) {
               return;
            }

            var4 -= 15.0 * GuiScaleSetting.INSTANCE.getScaleFactor();
         }
      } else if (this.m_9362a920()) {
         var4 -= var6 / 2.0;
      }

      if (this.m_e0f7c666()) {
         var2 -= 4.0;
      }

      for (C0075 var11 : var1) {
         if (var11.m_89e0519f()) {
            double var12 = var2;
            if (this.m_efa7610e()) {
               var12 = var2 - var11.m_b199d4ff() / 2.0;
            }

            if (this.m_e0f7c666()) {
               var12 -= var11.m_b199d4ff();
            }

            var11.m_a172f6fe(var12, var4);
            var4 += var11.m_a005efae();
         }
      }
   }

   public boolean m_efa7610e() {
      return this == f_4ea7c28e;
   }

   public boolean m_9362a920() {
      return this == f_5cabf205 || this == f_e9680a83;
   }

   public boolean m_89e0519f() {
      return this == f_7fb0edf4 || this == f_993458d0;
   }

   public boolean m_51ce03a5() {
      return this == f_80a06470 || this == f_a96599e0;
   }

   public boolean m_e606d819() {
      return this == f_7fb0edf4 || this == f_80a06470 || this == f_5cabf205;
   }

   public boolean m_e0f7c666() {
      return this == f_993458d0 || this == f_a96599e0 || this == f_e9680a83;
   }

   public static double m_0b83410d() {
      return 2.0;
   }

   public static class anonymousdefault {
      public anonymousdefault() {
      }

      public static double m_a005efae() {
         return (double)GuiScreen.getDisplayWidth();
      }

      public static double m_84808068() {
         return m_a005efae() / 2.0;
      }
   }

   public static class anonymousthis {
      public anonymousthis() {
      }

      public static double m_a005efae() {
         return (double)GuiScreen.getDisplayHeight();
      }

      public static double m_84808068() {
         return m_a005efae() / 2.0;
      }
   }
}
