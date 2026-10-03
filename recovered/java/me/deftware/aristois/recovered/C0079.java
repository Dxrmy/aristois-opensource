package me.deftware.aristois.recovered;

import java.util.stream.Stream;
import me.deftware.client.framework.world.ClientWorld;

@C0099
public class C0079 extends C0086 {
   public C0079() {
      super(C0265.m_b251ca51(), C0087.f_a96599e0, C0265.m_b48a8bc4());
      this.f_676ae6d0 = false;
   }

   @Override
   protected Stream<C0086.anonymousdefault> m_cb07f77b() {
      return Stream.of(
         new C0086.anonymousdefault().m_42140133(C0265.m_b886ae1c(), C0267.m_5b2d5cb2()).m_b4a5d70c(C0079::m_94acbdac),
         new C0086.anonymousdefault().m_42140133(C0265.m_bec91365(), C0267.m_5b2d5cb2()).m_b4a5d70c(C0079::m_e9914bd3),
         new C0086.anonymousdefault().m_42140133(C0265.m_79bfaec2(), C0267.m_5b2d5cb2()).m_b4a5d70c(C0079::m_3d3a8736),
         new C0086.anonymousdefault().m_42140133(C0265.m_2e834348(), C0267.m_5b2d5cb2()).m_b4a5d70c(C0079::m_c42f1c7e),
         new C0086.anonymousdefault().m_42140133(C0265.m_e07cee76(), C0265.m_7b0db73e()).m_b4a5d70c(C0044.f_7b762377::m_a005efae)
      );
   }

   public static String m_3d3a8736() {
      String var0 = ClientWorld.getClientWorld()._getBiome().getCatergory();
      return var0.substring(0, 1).toUpperCase() + var0.substring(1).toLowerCase();
   }

   public static String m_c42f1c7e() {
      double var0 = (double)((ClientWorld.getClientWorld()._getWorldTime() + 6000L) % 24000L);
      double var2 = var0 / 16.6 % 60.0;
      double var4 = var0 / 1000.0;
      return String.format(C0265.m_056a389d(), Math.floor(var4), var2);
   }

   public static String m_e9914bd3() {
      int var0 = ClientWorld.getClientWorld()._getDifficulty();
      switch (var0) {
         case 0:
            return C0265.m_5fa6dd07();
         case 1:
            return C0265.m_5f1ab561();
         case 2:
            return C0265.m_28b2c020();
         case 3:
            return C0265.m_45aaaba8();
         default:
            return C0265.m_88937f2b();
      }
   }

   public static String m_94acbdac() {
      int var0 = ClientWorld.getClientWorld()._getDimension();
      switch (var0) {
         case -1:
            return C0265.m_8631f87f();
         case 0:
            return C0265.m_396f9431();
         case 1:
            return C0265.m_e9914bd3();
         default:
            return C0265.m_88937f2b();
      }
   }
}
