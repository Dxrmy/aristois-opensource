package me.deftware.aristois.recovered;

import java.util.function.Supplier;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.minecraft.GameSetting.GuiScaleSetting;

public enum C0087 {
   f_3fce7dbc(C0087::m_f6e21b30, C0087::m_f6e21b30),
   f_7dfd032f(C0087.anonymousdefault::m_07e2f35f, C0087::m_f6e21b30),
   f_a2a770a2(C0087.anonymousdefault::m_bcf8a999, C0087::m_f6e21b30),
   f_5d3a6581(C0087::m_f6e21b30, C0087.anonymousthis::m_10bd5d1f),
   f_498dbecb(C0087.anonymousdefault::m_bcf8a999, C0087.anonymousthis::m_10bd5d1f),
   f_0ff82a38(C0087::m_f6e21b30, C0087.anonymousthis::m_320f21ef),
   f_a33cc72e(C0087.anonymousdefault::m_bcf8a999, C0087.anonymousthis::m_320f21ef);

   private final Supplier<Double> f_a8d275d7;
   private final Supplier<Double> f_648a1612;

   private C0087(Supplier<Double> var3, Supplier<Double> var4) {
      this.f_a8d275d7 = var3;
      this.f_648a1612 = var4;
   }

   public void m_7feef65d(C0075... var1) {
      double var2 = this.f_a8d275d7.get();
      double var4 = this.f_648a1612.get();
      double var6 = C0114.bootstrap<"call",0,1>(var1).filter(C0075::m_f5c4d925).mapToDouble(C0075::m_53084e34).sum();
      if (this.m_69611f66()) {
         var4 -= var6;
         if (ScreenRegistry.Chat.isOpen()) {
            if (this.m_04f1a475()) {
               return;
            }

            var4 -= 15.0 * GuiScaleSetting.INSTANCE.getScaleFactor();
         }
      } else if (this.m_c5f03b9c()) {
         var4 -= var6 / 2.0;
      }

      if (this.m_ac24d544()) {
         var2 -= 4.0;
      }

      for (C0075 var11 : var1) {
         if (var11.m_f5c4d925()) {
            double var12 = var2;
            if (this.m_91744074()) {
               var12 = var2 - var11.m_48cd465e() / 2.0;
            }

            if (this.m_ac24d544()) {
               var12 -= var11.m_48cd465e();
            }

            var11.m_f998b96d(var12, var4);
            var4 += var11.m_53084e34();
         }
      }
   }

   public boolean m_91744074() {
      return this == f_7dfd032f;
   }

   public boolean m_c5f03b9c() {
      return this == f_5d3a6581 || this == f_498dbecb;
   }

   public boolean m_45dc3fbf() {
      return this == f_3fce7dbc || this == f_a2a770a2;
   }

   public boolean m_69611f66() {
      return this == f_0ff82a38 || this == f_a33cc72e;
   }

   public boolean m_04f1a475() {
      return this == f_3fce7dbc || this == f_0ff82a38 || this == f_5d3a6581;
   }

   public boolean m_ac24d544() {
      return this == f_a2a770a2 || this == f_a33cc72e || this == f_498dbecb;
   }

   public static double m_f6e21b30() {
      return 2.0;
   }

   public static class anonymousdefault {
      public anonymousdefault() {
      }

      public static double m_bcf8a999() {
         return (double)C0114.bootstrap<"call",0,1>();
      }

      public static double m_07e2f35f() {
         return C0114.bootstrap<"call",0,1>() / 2.0;
      }
   }

   public static class anonymousthis {
      public anonymousthis() {
      }

      public static double m_320f21ef() {
         return (double)C0114.bootstrap<"call",0,1>();
      }

      public static double m_10bd5d1f() {
         return C0114.bootstrap<"call",0,1>() / 2.0;
      }
   }
}
