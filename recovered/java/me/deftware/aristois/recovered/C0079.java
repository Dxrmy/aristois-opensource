package me.deftware.aristois.recovered;

import java.util.stream.Stream;

@C0099
public class C0079 extends C0086 {
   public C0079() {
      super(C0252.bootstrap<"get",30064771091>(), C0087.f_a33cc72e, C0252.bootstrap<"get",30064771092>());
      this.f_0dd99811 = false;
   }

   protected Stream<C0086.anonymousdefault> m_f80741fb() {
      return C0114.bootstrap<"call",0,1>(
         new C0086.anonymousdefault[]{
            new C0086.anonymousdefault().m_25e003cb(C0252.bootstrap<"get",30064771093>(), C0252.bootstrap<"get",25769803897>()).m_a514188a(C0079::m_729bff09),
            new C0086.anonymousdefault().m_25e003cb(C0252.bootstrap<"get",30064771094>(), C0252.bootstrap<"get",25769803897>()).m_a514188a(C0079::m_1429b04b),
            new C0086.anonymousdefault().m_25e003cb(C0252.bootstrap<"get",30064771095>(), C0252.bootstrap<"get",25769803897>()).m_a514188a(C0079::m_718d0c3b),
            new C0086.anonymousdefault().m_25e003cb(C0252.bootstrap<"get",30064771096>(), C0252.bootstrap<"get",25769803897>()).m_a514188a(C0079::m_beb9edec),
            new C0086.anonymousdefault()
               .m_25e003cb(C0252.bootstrap<"get",30064771097>(), C0252.bootstrap<"get",30064771098>())
               .m_a514188a(C0044.f_35859108::m_b56b2c3d)
         }
      );
   }

   public static String m_718d0c3b() {
      String var0 = C0114.bootstrap<"call",0,1>()._getBiome().getCatergory();
      return var0.substring(0, 1).toUpperCase() + var0.substring(1).toLowerCase();
   }

   public static String m_beb9edec() {
      double var0 = (double)((C0114.bootstrap<"call",0,1>()._getWorldTime() + 6000L) % 24000L);
      double var2 = var0 / 16.6 % 60.0;
      double var4 = var0 / 1000.0;
      return C0114.bootstrap<"call",3,1>(
         C0252.bootstrap<"get",30064771099>(), new Object[]{C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var4)), C0114.bootstrap<"call",2,1>(var2)}
      );
   }

   public static String m_1429b04b() {
      int var0 = C0114.bootstrap<"call",0,1>()._getDifficulty();
      switch (var0) {
         case 0:
            return C0252.bootstrap<"get",30064771100>();
         case 1:
            return C0252.bootstrap<"get",30064771101>();
         case 2:
            return C0252.bootstrap<"get",30064771102>();
         case 3:
            return C0252.bootstrap<"get",30064771103>();
         default:
            return C0252.bootstrap<"get",30064771104>();
      }
   }

   public static String m_729bff09() {
      int var0 = C0114.bootstrap<"call",0,1>()._getDimension();
      switch (var0) {
         case -1:
            return C0252.bootstrap<"get",30064771107>();
         case 0:
            return C0252.bootstrap<"get",30064771105>();
         case 1:
            return C0252.bootstrap<"get",30064771106>();
         default:
            return C0252.bootstrap<"get",30064771104>();
      }
   }
}
