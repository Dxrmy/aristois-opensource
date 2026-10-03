package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.chunk.ChunkGenerationRandom;
import me.deftware.client.framework.world.chunk.Randomizer;

public class C0055 {
   public final Block f_9cefc49e;
   public C0055.anonymoustransient f_559eb713 = C0055.anonymoustransient.f_3687e176;
   public C0054 f_09f47e55 = C0056.f_265014c5;
   public Map<String, Integer> f_31ad587c = new HashMap<>();
   public boolean f_d1121cfe = true;
   public int f_a06f2bb4 = 6;
   public int f_9f831d7a;
   public int f_a9028697;
   public int f_3a0b2bd3;
   public C0055.anonymoussynchronized f_d3fac58f;
   public String f_6865c866;
   public float f_66f9eacf = 0.0F;
   public float f_34d21176 = 1.0F;

   public C0055(Block var1) {
      this.f_9cefc49e = var1;
      this.f_6865c866 = var1.getIdentifierKey();
   }

   public int m_6cb686b1(String var1) {
      return this.f_31ad587c.containsKey(var1)
         ? this.f_31ad587c.get(var1)
         : this.f_31ad587c.getOrDefault(C0252.bootstrap<"get",8589934601>(), C0114.bootstrap<"call",0,1>(-1));
   }

   public int m_d33e4028(ChunkGenerationRandom var1) {
      return this.f_d3fac58f.m_8bfe082f(var1);
   }

   static class anonymousboolean implements C0055.anonymoussynchronized {
      private final int f_285bbf8e;

      public anonymousboolean(int var1) {
         this.f_285bbf8e = var1;
      }

      public int m_426bf005(Randomizer var1) {
         return this.f_285bbf8e;
      }
   }

   public static class anonymousdefault extends C0055.anonymousthrows {
      public anonymousdefault() {
         this.m_cf1b464f(C0071.f_534eec6c).m_c492dcd2(7).m_51cac490(20).m_9ded039b(false).m_9c9999fd(0).m_1d764c70(128).m_027dd97b(20);
         this.m_cf1b464f(C0071.f_6276ab1d).m_c492dcd2(8).m_51cac490(20).m_9ded039b(false).m_9c9999fd(0).m_1d764c70(64).m_027dd97b(9);
         this.m_cf1b464f(C0071.f_ac8f8cb8).m_c492dcd2(9).m_51cac490(2).m_9ded039b(false).m_9c9999fd(0).m_1d764c70(32).m_027dd97b(9);
         this.m_cf1b464f(C0071.f_ac8f8cb8)
            .m_015d26de(
               14,
               C0252.bootstrap<"get",51539607681>(),
               C0252.bootstrap<"get",55834574848>(),
               C0252.bootstrap<"get",55834574849>(),
               C0252.bootstrap<"get",55834574850>(),
               C0252.bootstrap<"get",55834574851>(),
               C0252.bootstrap<"get",55834574852>(),
               C0252.bootstrap<"get",55834574853>()
            )
            .m_51cac490(20)
            .m_9ded039b(false)
            .m_9c9999fd(32)
            .m_1d764c70(80)
            .m_027dd97b(9);
         this.m_cf1b464f(C0071.f_1eed9530).m_c492dcd2(10).m_51cac490(8).m_9ded039b(false).m_9c9999fd(0).m_1d764c70(16).m_027dd97b(8);
         this.m_cf1b464f(C0071.f_633dfc7a).m_c492dcd2(11).m_51cac490(1).m_9ded039b(false).m_9c9999fd(0).m_1d764c70(16).m_027dd97b(8);
         this.m_cf1b464f(C0071.f_19c3efd9).m_c492dcd2(12).m_51cac490(1).m_9c9999fd(16).m_1d764c70(16).m_027dd97b(7);
         if (C0213.f_57699eb8.m_093ae25a()) {
            this.m_cf1b464f(C0071.f_88dee4bd).m_c492dcd2(13).m_51cac490(6).m_9c9999fd(49).m_1d764c70(49).m_027dd97b(10);
         }

         this.m_cf1b464f(C0071.f_55bb623e)
            .m_015d26de(
               14,
               C0252.bootstrap<"get",55834574854>(),
               C0252.bootstrap<"get",55834574855>(),
               C0252.bootstrap<"get",55834574856>(),
               C0252.bootstrap<"get",55834574857>(),
               C0252.bootstrap<"get",55834574858>(),
               C0252.bootstrap<"get",55834574853>()
            )
            .m_d48ec170(6, 8)
            .m_9c9999fd(4)
            .m_1d764c70(32)
            .m_9ded039b(false)
            .m_027dd97b(1);
         if (C0213.f_33309411.m_093ae25a()) {
            this.m_cf1b464f(C0071.f_dfe32957)
               .m_c492dcd2(13)
               .m_225ff3d3(C0252.bootstrap<"get",55834574859>(), -1)
               .m_db69479f(7)
               .m_51cac490(10)
               .m_9ded039b(false)
               .m_9c9999fd(10)
               .m_1d764c70(118)
               .m_027dd97b(10)
               .m_7083ac4c(C0055.anonymoustransient.f_2f04715d);
            this.m_cf1b464f(C0071.f_dfe32957)
               .m_225ff3d3(C0252.bootstrap<"get",55834574859>(), 13)
               .m_db69479f(7)
               .m_51cac490(20)
               .m_9ded039b(false)
               .m_9c9999fd(10)
               .m_1d764c70(118)
               .m_027dd97b(10)
               .m_7083ac4c(C0055.anonymoustransient.f_2f04715d);
            this.m_cf1b464f(C0071.f_9b9b8c1d)
               .m_c492dcd2(15)
               .m_225ff3d3(C0252.bootstrap<"get",55834574860>(), 12)
               .m_225ff3d3(C0252.bootstrap<"get",55834574861>(), 13)
               .m_db69479f(7)
               .m_51cac490(1)
               .m_9c9999fd(17)
               .m_1d764c70(9)
               .m_027dd97b(3)
               .m_7083ac4c(C0055.anonymoustransient.f_2f04715d)
               .m_88620df9(C0058.f_3dfc769b);
            this.m_cf1b464f(C0071.f_9b9b8c1d)
               .m_c492dcd2(16)
               .m_225ff3d3(C0252.bootstrap<"get",55834574860>(), 13)
               .m_225ff3d3(C0252.bootstrap<"get",55834574861>(), 14)
               .m_db69479f(7)
               .m_9ded039b(false)
               .m_51cac490(1)
               .m_9c9999fd(8)
               .m_1d764c70(120)
               .m_027dd97b(2)
               .m_7083ac4c(C0055.anonymoustransient.f_2f04715d)
               .m_88620df9(C0058.f_3dfc769b)
               .m_6a395647(C0252.bootstrap<"get",55834574862>());
         }

         this.m_cf1b464f(C0071.f_a208b2a3)
            .m_c492dcd2(14)
            .m_225ff3d3(C0252.bootstrap<"get",55834574859>(), -1)
            .m_db69479f(7)
            .m_51cac490(16)
            .m_9ded039b(false)
            .m_9c9999fd(10)
            .m_1d764c70(118)
            .m_027dd97b(14)
            .m_7083ac4c(C0055.anonymoustransient.f_2f04715d);
         this.m_cf1b464f(C0071.f_a208b2a3)
            .m_225ff3d3(C0252.bootstrap<"get",55834574859>(), 14)
            .m_db69479f(7)
            .m_51cac490(32)
            .m_9ded039b(false)
            .m_9c9999fd(10)
            .m_1d764c70(118)
            .m_027dd97b(14)
            .m_7083ac4c(C0055.anonymoustransient.f_2f04715d);
      }

      public C0055.anonymousdefault m_57b1c16a() {
         this.m_c29ddaa4(C0071.f_633dfc7a).forEach(var0 -> var0.f_3a0b2bd3 = 17);
         this.m_c29ddaa4(C0071.f_55bb623e).forEach(var0 -> var0.f_d3fac58f = new C0055.anonymousinterface(6, 24));
         return this;
      }

      public C0055.anonymousdefault m_562686db() {
         for (C0055 var2 : this.f_41313beb) {
            if (var2.f_6865c866.contains(C0252.bootstrap<"get",55834574863>()) || var2.f_9cefc49e.equals(C0071.f_55bb623e)) {
               var2.f_31ad587c.keySet().forEach(var1 -> {
                  Integer var10000 = var2.f_31ad587c.put(var1, C0114.bootstrap<"call",0,1>(var2.f_31ad587c.get(var1) - 3));
               });
            } else if (var2.f_559eb713.equals(C0055.anonymoustransient.f_3687e176)) {
               var2.f_31ad587c.keySet().forEach(var1 -> {
                  Integer var10000 = var2.f_31ad587c.put(var1, C0114.bootstrap<"call",0,1>(var2.f_31ad587c.get(var1) - 2));
               });
            } else if (var2.f_6865c866.equals(C0252.bootstrap<"get",55834574862>())) {
               var2.f_a9028697 = 16;
               var2.f_3a0b2bd3 = 8;
            }
         }

         return this;
      }

      public C0055.anonymousdefault m_41c018a7() {
         this.m_562686db();

         for (C0055 var2 : this.f_41313beb) {
            var2.f_a06f2bb4 -= 2;
         }

         return this;
      }
   }

   public static class anonymousfalse extends C0055.anonymousthrows {
      public anonymousfalse() {
         this.m_b257a9ca(C0071.f_534eec6c).m_c492dcd2(9).m_51cac490(30).m_9ded039b(false).m_9c9999fd(136).m_1d764c70(320).m_027dd97b(17);
         this.m_b257a9ca(C0071.f_534eec6c).m_c492dcd2(10).m_51cac490(20).m_9c9999fd(97).m_1d764c70(97).m_027dd97b(17).m_3d267c34(0.5F);
         this.m_b257a9ca(C0071.f_1eed9530).m_c492dcd2(16).m_51cac490(4).m_9ded039b(false).m_9c9999fd(-64).m_1d764c70(16).m_027dd97b(8);
         this.m_b257a9ca(C0071.f_1eed9530).m_c492dcd2(17).m_51cac490(8).m_9c9999fd(-63).m_1d764c70(33).m_027dd97b(8);
         this.m_b257a9ca(C0071.f_19c3efd9).m_c492dcd2(21).m_51cac490(2).m_9c9999fd(1).m_1d764c70(33).m_027dd97b(7);
         this.m_b257a9ca(C0071.f_19c3efd9).m_c492dcd2(22).m_51cac490(4).m_9c9999fd(-64).m_1d764c70(65).m_027dd97b(7).m_9ded039b(false);
         this.m_b257a9ca(C0071.f_ac8f8cb8)
            .m_015d26de(27, C0252.bootstrap<"get",51539607681>(), C0252.bootstrap<"get",55834574852>(), C0252.bootstrap<"get",55834574876>())
            .m_51cac490(50)
            .m_9c9999fd(32)
            .m_1d764c70(257)
            .m_027dd97b(9)
            .m_9ded039b(false);
         this.m_b257a9ca(C0071.f_ac8f8cb8).m_c492dcd2(14).m_51cac490(4).m_9c9999fd(-15).m_1d764c70(49).m_027dd97b(9).m_3d267c34(0.5F);
         this.m_b257a9ca(C0071.f_ac8f8cb8).m_c492dcd2(15).m_d48ec170(0, 1).m_9c9999fd(-64).m_1d764c70(-47).m_027dd97b(9).m_9ded039b(false).m_3d267c34(0.5F);
         this.m_b257a9ca(C0071.f_6276ab1d).m_c492dcd2(11).m_51cac490(90).m_9c9999fd(233).m_1d764c70(153).m_027dd97b(9);
         this.m_b257a9ca(C0071.f_6276ab1d).m_c492dcd2(12).m_51cac490(10).m_9c9999fd(17).m_1d764c70(41).m_027dd97b(9);
         this.m_b257a9ca(C0071.f_6276ab1d).m_c492dcd2(13).m_51cac490(10).m_9c9999fd(-64).m_1d764c70(73).m_027dd97b(4).m_9ded039b(false);
         this.m_b257a9ca(C0071.f_633dfc7a).m_9c9999fd(-63).m_1d764c70(81).m_c492dcd2(18).m_027dd97b(4).m_3d267c34(0.5F).m_51cac490(7);
         this.m_b257a9ca(C0071.f_633dfc7a).m_9c9999fd(-63).m_1d764c70(81).m_c492dcd2(19).m_027dd97b(12).m_3d267c34(0.7F).m_b6d789ee(0.11111111F).m_51cac490(1);
         this.m_b257a9ca(C0071.f_633dfc7a).m_9c9999fd(-63).m_1d764c70(81).m_c492dcd2(20).m_027dd97b(8).m_3d267c34(1.0F).m_51cac490(4);
         if (C0213.f_57699eb8.m_093ae25a()) {
            this.m_b257a9ca(C0071.f_88dee4bd).m_c492dcd2(24).m_51cac490(16).m_9c9999fd(49).m_1d764c70(65).m_027dd97b(10);
         }

         this.m_b257a9ca(C0071.f_55bb623e)
            .m_015d26de(
               27,
               C0252.bootstrap<"get",55834574877>(),
               C0252.bootstrap<"get",55834574878>(),
               C0252.bootstrap<"get",55834574879>(),
               C0252.bootstrap<"get",55834574880>(),
               C0252.bootstrap<"get",55834574881>(),
               C0252.bootstrap<"get",55834574882>(),
               C0252.bootstrap<"get",55834574883>()
            )
            .m_51cac490(100)
            .m_9c9999fd(233)
            .m_1d764c70(249)
            .m_027dd97b(3)
            .m_88620df9(C0055.anonymousnative.f_4efe6de2);
         if (C0213.f_33309411.m_093ae25a()) {
            this.m_b257a9ca(C0071.f_9b9b8c1d)
               .m_c492dcd2(21)
               .m_db69479f(7)
               .m_51cac490(1)
               .m_9c9999fd(17)
               .m_1d764c70(9)
               .m_027dd97b(3)
               .m_7083ac4c(C0055.anonymoustransient.f_2f04715d)
               .m_88620df9(C0058.f_3dfc769b);
            this.m_b257a9ca(C0071.f_9b9b8c1d)
               .m_c492dcd2(22)
               .m_db69479f(7)
               .m_51cac490(1)
               .m_9c9999fd(8)
               .m_1d764c70(120)
               .m_027dd97b(2)
               .m_9ded039b(false)
               .m_7083ac4c(C0055.anonymoustransient.f_2f04715d)
               .m_88620df9(C0058.f_3dfc769b);
            this.m_b257a9ca(C0071.f_dfe32957)
               .m_225ff3d3(C0252.bootstrap<"get",8589934601>(), 19)
               .m_225ff3d3(C0252.bootstrap<"get",55834574859>(), -1)
               .m_db69479f(7)
               .m_51cac490(10)
               .m_9ded039b(false)
               .m_9c9999fd(10)
               .m_1d764c70(118)
               .m_027dd97b(10)
               .m_7083ac4c(C0055.anonymoustransient.f_2f04715d);
            this.m_b257a9ca(C0071.f_dfe32957)
               .m_225ff3d3(C0252.bootstrap<"get",55834574859>(), 13)
               .m_db69479f(7)
               .m_51cac490(20)
               .m_9ded039b(false)
               .m_9c9999fd(10)
               .m_1d764c70(118)
               .m_027dd97b(10)
               .m_7083ac4c(C0055.anonymoustransient.f_2f04715d);
         }

         this.m_b257a9ca(C0071.f_a208b2a3)
            .m_225ff3d3(C0252.bootstrap<"get",55834574859>(), 14)
            .m_db69479f(7)
            .m_51cac490(32)
            .m_9ded039b(false)
            .m_9c9999fd(10)
            .m_1d764c70(118)
            .m_027dd97b(14)
            .m_7083ac4c(C0055.anonymoustransient.f_2f04715d);
         this.m_b257a9ca(C0071.f_a208b2a3)
            .m_c492dcd2(20)
            .m_225ff3d3(C0252.bootstrap<"get",55834574859>(), -1)
            .m_db69479f(7)
            .m_51cac490(16)
            .m_9ded039b(false)
            .m_9c9999fd(10)
            .m_1d764c70(118)
            .m_027dd97b(14)
            .m_7083ac4c(C0055.anonymoustransient.f_2f04715d);
      }
   }

   public static enum anonymousfor {
      f_83c3f27c(new C0055.anonymousfalse(), C0252.bootstrap<"get",55834574865>(), 759, 762),
      f_daf7acc9(new C0055.anonymousfalse(), C0252.bootstrap<"get",55834574867>(), 757, 758),
      f_abff1ce8(new C0055.anonymousdefault(), C0252.bootstrap<"get",55834574869>(), 756),
      f_66eb5544(new C0055.anonymousdefault().m_57b1c16a(), C0252.bootstrap<"get",55834574871>(), 755),
      f_04cee556(new C0055.anonymousdefault().m_562686db(), C0252.bootstrap<"get",55834574873>(), 735, 754),
      f_fecb5767(new C0055.anonymousdefault().m_41c018a7(), C0252.bootstrap<"get",55834574875>(), 573, 578);

      public final C0055.anonymousthrows f_50ec7f47;
      private final String f_6e308ef5;
      public final int f_e1ebd347;
      public final int f_ee21cc2f;

      private anonymousfor(C0055.anonymousthrows var3, String var4, int var5, int var6) {
         this.f_50ec7f47 = var3;
         this.f_6e308ef5 = var4;
         this.f_e1ebd347 = var5;
         this.f_ee21cc2f = var6;
      }

      private anonymousfor(C0055.anonymousthrows var3, String var4, int var5) {
         this(var3, var4, var5, var5);
      }

      public boolean m_a49acb39(int var1) {
         return var1 >= this.f_e1ebd347 && var1 <= this.f_ee21cc2f;
      }

      @Override
      public String toString() {
         return this.f_6e308ef5;
      }
   }

   static class anonymousinterface implements C0055.anonymoussynchronized {
      private final int f_bf975815;
      private final int f_1e3214c9;

      public anonymousinterface(int var1, int var2) {
         this.f_bf975815 = var1;
         this.f_1e3214c9 = var2;
      }

      public int m_8fb400a5(Randomizer var1) {
         return var1._nextInt(this.f_1e3214c9 - this.f_bf975815 + 1) + this.f_bf975815;
      }
   }

   static class anonymousnative implements C0054 {
      public static final C0055.anonymousnative f_4efe6de2 = new C0055.anonymousnative();

      public anonymousnative() {
      }

      public List<BlockPosition> m_4572a53b(Randomizer var1, BlockPosition var2, C0055 var3) {
         return C0114.bootstrap<"call",0,1>(var2);
      }
   }

   interface anonymoussynchronized {
      int m_8bfe082f(Randomizer var1);
   }

   static class anonymousthis {
      public static final String f_51b706ad = C0252.bootstrap<"get",8589934601>();
      private final C0055 f_3c8e814e;

      public anonymousthis(Block var1) {
         this.f_3c8e814e = new C0055(var1);
      }

      public C0055.anonymousthis m_7083ac4c(C0055.anonymoustransient var1) {
         this.f_3c8e814e.f_559eb713 = var1;
         return this;
      }

      public C0055.anonymousthis m_c492dcd2(int var1) {
         this.f_3c8e814e.f_31ad587c.put(C0252.bootstrap<"get",8589934601>(), C0114.bootstrap<"call",0,1>(var1));
         return this;
      }

      public C0055.anonymousthis m_225ff3d3(String var1, int var2) {
         this.f_3c8e814e.f_31ad587c.put(var1, C0114.bootstrap<"call",0,1>(var2));
         return this;
      }

      public C0055.anonymousthis m_9ded039b(boolean var1) {
         this.f_3c8e814e.f_d1121cfe = var1;
         return this;
      }

      public C0055.anonymousthis m_027dd97b(int var1) {
         this.f_3c8e814e.f_9f831d7a = var1;
         return this;
      }

      public C0055.anonymousthis m_db69479f(int var1) {
         this.f_3c8e814e.f_a06f2bb4 = var1;
         return this;
      }

      public C0055.anonymousthis m_9c9999fd(int var1) {
         this.f_3c8e814e.f_a9028697 = var1;
         return this;
      }

      public C0055.anonymousthis m_1d764c70(int var1) {
         this.f_3c8e814e.f_3a0b2bd3 = var1;
         return this;
      }

      public C0055.anonymousthis m_b6d789ee(float var1) {
         this.f_3c8e814e.f_34d21176 = var1;
         return this;
      }

      public C0055.anonymousthis m_3d267c34(float var1) {
         this.f_3c8e814e.f_66f9eacf = var1;
         return this;
      }

      public C0055.anonymousthis m_51cac490(int var1) {
         this.f_3c8e814e.f_d3fac58f = new C0055.anonymousboolean(var1);
         return this;
      }

      public C0055.anonymousthis m_d48ec170(int var1, int var2) {
         this.f_3c8e814e.f_d3fac58f = new C0055.anonymousinterface(var1, var2);
         return this;
      }

      public C0055.anonymousthis m_88620df9(C0054 var1) {
         this.f_3c8e814e.f_09f47e55 = var1;
         return this;
      }

      public C0055.anonymousthis m_015d26de(int var1, String... var2) {
         for (String var6 : var2) {
            this.f_3c8e814e.f_31ad587c.put(var6, C0114.bootstrap<"call",0,1>(var1));
         }

         return this;
      }

      public C0055.anonymousthis m_6a395647(String var1) {
         this.f_3c8e814e.f_6865c866 = var1;
         return this;
      }

      public C0055 m_07c492f9() {
         return this.f_3c8e814e;
      }
   }

   public abstract static class anonymousthrows {
      public final List<C0055> f_2889a32f = new ArrayList<>();

      public anonymousthrows() {
      }

      public C0055.anonymousthrows m_c01dd162(C0055... var1) {
         this.f_2889a32f.addAll(C0114.bootstrap<"call",0,1>(var1));
         return this;
      }

      public List<C0055> m_b3cd3ba2() {
         return this.f_2889a32f;
      }

      public Stream<C0055> m_179ca3c7(Block var1) {
         return this.f_2889a32f.stream().filter(var1x -> var1x.f_9cefc49e.equals(var1));
      }

      public C0055.anonymousthis m_fe9ed75b(Block var1) {
         C0055.anonymousthis var2 = new C0055.anonymousthis(var1);
         this.f_2889a32f.add(var2.m_07c492f9());
         return var2;
      }
   }

   public static enum anonymoustransient {
      f_3687e176(0),
      f_2f04715d(-1);

      public final int f_dd665f21;

      private anonymoustransient(int var3) {
         this.f_dd665f21 = var3;
      }
   }
}
