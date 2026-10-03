package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.chunk.ChunkGenerationRandom;
import me.deftware.client.framework.world.chunk.Randomizer;

public class C0055 {
   public final Block f_4bf0ba39;
   public C0055.anonymoustransient f_6f080da4 = C0055.anonymoustransient.f_4b7faba2;
   public C0054 f_ad0c1bd2 = C0056.f_c13a777d;
   public Map<String, Integer> f_4a51c5ba = new HashMap<>();
   public boolean f_5560ec9b = true;
   public int f_6758268f = 6;
   public int f_e282479e;
   public int f_40dbb793;
   public int f_4beaab70;
   public C0055.anonymoussynchronized f_ec3910d5;
   public String f_e938b1dd;
   public float f_ff7fba00 = 0.0F;
   public float f_0ce92f03 = 1.0F;

   public C0055(Block var1) {
      this.f_4bf0ba39 = var1;
      this.f_e938b1dd = var1.getIdentifierKey();
   }

   public int m_f16981ce(String var1) {
      return this.f_4a51c5ba.containsKey(var1) ? this.f_4a51c5ba.get(var1) : this.f_4a51c5ba.getOrDefault(C0253.m_1d87ef21(), -1);
   }

   public int m_ba0ed846(ChunkGenerationRandom var1) {
      return this.f_ec3910d5.m_d7753de9(var1);
   }

   static class anonymousboolean implements C0055.anonymoussynchronized {
      private final int f_f9024463;

      public anonymousboolean(int var1) {
         this.f_f9024463 = var1;
      }

      @Override
      public int m_d7753de9(Randomizer var1) {
         return this.f_f9024463;
      }
   }

   public static class anonymousdefault extends C0055.anonymousthrows {
      public anonymousdefault() {
         this.m_d4e61fad(C0071.f_b8217426).m_34f2e39e(7).m_3c01317a(20).m_d3c4667d(false).m_c9a0919e(0).m_2e13d085(128).m_f2e6c3ed(20);
         this.m_d4e61fad(C0071.f_d503b57f).m_34f2e39e(8).m_3c01317a(20).m_d3c4667d(false).m_c9a0919e(0).m_2e13d085(64).m_f2e6c3ed(9);
         this.m_d4e61fad(C0071.f_4e132e1e).m_34f2e39e(9).m_3c01317a(2).m_d3c4667d(false).m_c9a0919e(0).m_2e13d085(32).m_f2e6c3ed(9);
         this.m_d4e61fad(C0071.f_4e132e1e)
            .m_e8eadcbf(
               14, C0255.m_c6614274(), C0256.m_44418b5d(), C0256.m_813e3509(), C0256.m_3855be80(), C0256.m_a9247108(), C0256.m_4626ac74(), C0256.m_c688f8ca()
            )
            .m_3c01317a(20)
            .m_d3c4667d(false)
            .m_c9a0919e(32)
            .m_2e13d085(80)
            .m_f2e6c3ed(9);
         this.m_d4e61fad(C0071.f_1d5e9526).m_34f2e39e(10).m_3c01317a(8).m_d3c4667d(false).m_c9a0919e(0).m_2e13d085(16).m_f2e6c3ed(8);
         this.m_d4e61fad(C0071.f_b9cb311f).m_34f2e39e(11).m_3c01317a(1).m_d3c4667d(false).m_c9a0919e(0).m_2e13d085(16).m_f2e6c3ed(8);
         this.m_d4e61fad(C0071.f_80ae02db).m_34f2e39e(12).m_3c01317a(1).m_c9a0919e(16).m_2e13d085(16).m_f2e6c3ed(7);
         if (C0213.f_17e12451.m_efa7610e()) {
            this.m_d4e61fad(C0071.f_cdbb4931).m_34f2e39e(13).m_3c01317a(6).m_c9a0919e(49).m_2e13d085(49).m_f2e6c3ed(10);
         }

         this.m_d4e61fad(C0071.f_9751c393)
            .m_e8eadcbf(14, C0256.m_35cdaa1a(), C0256.m_624b40d8(), C0256.m_8d7dbe31(), C0256.m_1d87ef21(), C0256.m_c42f1c7e(), C0256.m_c688f8ca())
            .m_50a97026(6, 8)
            .m_c9a0919e(4)
            .m_2e13d085(32)
            .m_d3c4667d(false)
            .m_f2e6c3ed(1);
         if (C0213.f_cb39f22f.m_efa7610e()) {
            this.m_d4e61fad(C0071.f_89066a04)
               .m_34f2e39e(13)
               .m_a8e6bda9(C0256.m_6f1f396d(), -1)
               .m_7329c2c0(7)
               .m_3c01317a(10)
               .m_d3c4667d(false)
               .m_c9a0919e(10)
               .m_2e13d085(118)
               .m_f2e6c3ed(10)
               .m_69cc63b5(C0055.anonymoustransient.f_7acb8769);
            this.m_d4e61fad(C0071.f_89066a04)
               .m_a8e6bda9(C0256.m_6f1f396d(), 13)
               .m_7329c2c0(7)
               .m_3c01317a(20)
               .m_d3c4667d(false)
               .m_c9a0919e(10)
               .m_2e13d085(118)
               .m_f2e6c3ed(10)
               .m_69cc63b5(C0055.anonymoustransient.f_7acb8769);
            this.m_d4e61fad(C0071.f_153c92dd)
               .m_34f2e39e(15)
               .m_a8e6bda9(C0256.m_8ced16bd(), 12)
               .m_a8e6bda9(C0256.m_15ef1a0d(), 13)
               .m_7329c2c0(7)
               .m_3c01317a(1)
               .m_c9a0919e(17)
               .m_2e13d085(9)
               .m_f2e6c3ed(3)
               .m_69cc63b5(C0055.anonymoustransient.f_7acb8769)
               .m_bd30edd7(C0058.f_0c7a8cb0);
            this.m_d4e61fad(C0071.f_153c92dd)
               .m_34f2e39e(16)
               .m_a8e6bda9(C0256.m_8ced16bd(), 13)
               .m_a8e6bda9(C0256.m_15ef1a0d(), 14)
               .m_7329c2c0(7)
               .m_d3c4667d(false)
               .m_3c01317a(1)
               .m_c9a0919e(8)
               .m_2e13d085(120)
               .m_f2e6c3ed(2)
               .m_69cc63b5(C0055.anonymoustransient.f_7acb8769)
               .m_bd30edd7(C0058.f_0c7a8cb0)
               .m_057721d3(C0256.m_9793dfe2());
         }

         this.m_d4e61fad(C0071.f_43b9c78f)
            .m_34f2e39e(14)
            .m_a8e6bda9(C0256.m_6f1f396d(), -1)
            .m_7329c2c0(7)
            .m_3c01317a(16)
            .m_d3c4667d(false)
            .m_c9a0919e(10)
            .m_2e13d085(118)
            .m_f2e6c3ed(14)
            .m_69cc63b5(C0055.anonymoustransient.f_7acb8769);
         this.m_d4e61fad(C0071.f_43b9c78f)
            .m_a8e6bda9(C0256.m_6f1f396d(), 14)
            .m_7329c2c0(7)
            .m_3c01317a(32)
            .m_d3c4667d(false)
            .m_c9a0919e(10)
            .m_2e13d085(118)
            .m_f2e6c3ed(14)
            .m_69cc63b5(C0055.anonymoustransient.f_7acb8769);
      }

      public C0055.anonymousdefault m_b46168a2() {
         this.m_94900ef2(C0071.f_b9cb311f).forEach(var0 -> var0.f_4beaab70 = 17);
         this.m_94900ef2(C0071.f_9751c393).forEach(var0 -> var0.f_ec3910d5 = new C0055.anonymousinterface(6, 24));
         return this;
      }

      public C0055.anonymousdefault m_0a1d1c25() {
         for (C0055 var2 : this.f_01c8ff24) {
            if (var2.f_e938b1dd.contains(C0256.m_1635bc47()) || var2.f_4bf0ba39.equals(C0071.f_9751c393)) {
               var2.f_4a51c5ba.keySet().forEach(var1 -> {
                  Integer var10000 = var2.f_4a51c5ba.put(var1, var2.f_4a51c5ba.get(var1) - 3);
               });
            } else if (var2.f_6f080da4.equals(C0055.anonymoustransient.f_4b7faba2)) {
               var2.f_4a51c5ba.keySet().forEach(var1 -> {
                  Integer var10000 = var2.f_4a51c5ba.put(var1, var2.f_4a51c5ba.get(var1) - 2);
               });
            } else if (var2.f_e938b1dd.equals(C0256.m_9793dfe2())) {
               var2.f_40dbb793 = 16;
               var2.f_4beaab70 = 8;
            }
         }

         return this;
      }

      public C0055.anonymousdefault m_d494a464() {
         this.m_0a1d1c25();

         for (C0055 var2 : this.f_01c8ff24) {
            var2.f_6758268f -= 2;
         }

         return this;
      }
   }

   public static class anonymousfalse extends C0055.anonymousthrows {
      public anonymousfalse() {
         this.m_d4e61fad(C0071.f_b8217426).m_34f2e39e(9).m_3c01317a(30).m_d3c4667d(false).m_c9a0919e(136).m_2e13d085(320).m_f2e6c3ed(17);
         this.m_d4e61fad(C0071.f_b8217426).m_34f2e39e(10).m_3c01317a(20).m_c9a0919e(97).m_2e13d085(97).m_f2e6c3ed(17).m_0d481ee6(0.5F);
         this.m_d4e61fad(C0071.f_1d5e9526).m_34f2e39e(16).m_3c01317a(4).m_d3c4667d(false).m_c9a0919e(-64).m_2e13d085(16).m_f2e6c3ed(8);
         this.m_d4e61fad(C0071.f_1d5e9526).m_34f2e39e(17).m_3c01317a(8).m_c9a0919e(-63).m_2e13d085(33).m_f2e6c3ed(8);
         this.m_d4e61fad(C0071.f_80ae02db).m_34f2e39e(21).m_3c01317a(2).m_c9a0919e(1).m_2e13d085(33).m_f2e6c3ed(7);
         this.m_d4e61fad(C0071.f_80ae02db).m_34f2e39e(22).m_3c01317a(4).m_c9a0919e(-64).m_2e13d085(65).m_f2e6c3ed(7).m_d3c4667d(false);
         this.m_d4e61fad(C0071.f_4e132e1e)
            .m_e8eadcbf(27, C0255.m_c6614274(), C0256.m_4626ac74(), C0256.m_5fa6dd07())
            .m_3c01317a(50)
            .m_c9a0919e(32)
            .m_2e13d085(257)
            .m_f2e6c3ed(9)
            .m_d3c4667d(false);
         this.m_d4e61fad(C0071.f_4e132e1e).m_34f2e39e(14).m_3c01317a(4).m_c9a0919e(-15).m_2e13d085(49).m_f2e6c3ed(9).m_0d481ee6(0.5F);
         this.m_d4e61fad(C0071.f_4e132e1e).m_34f2e39e(15).m_50a97026(0, 1).m_c9a0919e(-64).m_2e13d085(-47).m_f2e6c3ed(9).m_d3c4667d(false).m_0d481ee6(0.5F);
         this.m_d4e61fad(C0071.f_d503b57f).m_34f2e39e(11).m_3c01317a(90).m_c9a0919e(233).m_2e13d085(153).m_f2e6c3ed(9);
         this.m_d4e61fad(C0071.f_d503b57f).m_34f2e39e(12).m_3c01317a(10).m_c9a0919e(17).m_2e13d085(41).m_f2e6c3ed(9);
         this.m_d4e61fad(C0071.f_d503b57f).m_34f2e39e(13).m_3c01317a(10).m_c9a0919e(-64).m_2e13d085(73).m_f2e6c3ed(4).m_d3c4667d(false);
         this.m_d4e61fad(C0071.f_b9cb311f).m_c9a0919e(-63).m_2e13d085(81).m_34f2e39e(18).m_f2e6c3ed(4).m_0d481ee6(0.5F).m_3c01317a(7);
         this.m_d4e61fad(C0071.f_b9cb311f).m_c9a0919e(-63).m_2e13d085(81).m_34f2e39e(19).m_f2e6c3ed(12).m_0d481ee6(0.7F).m_e482ba34(0.11111111F).m_3c01317a(1);
         this.m_d4e61fad(C0071.f_b9cb311f).m_c9a0919e(-63).m_2e13d085(81).m_34f2e39e(20).m_f2e6c3ed(8).m_0d481ee6(1.0F).m_3c01317a(4);
         if (C0213.f_17e12451.m_efa7610e()) {
            this.m_d4e61fad(C0071.f_cdbb4931).m_34f2e39e(24).m_3c01317a(16).m_c9a0919e(49).m_2e13d085(65).m_f2e6c3ed(10);
         }

         this.m_d4e61fad(C0071.f_9751c393)
            .m_e8eadcbf(
               27, C0256.m_5f1ab561(), C0256.m_28b2c020(), C0256.m_45aaaba8(), C0256.m_88937f2b(), C0256.m_396f9431(), C0256.m_e9914bd3(), C0256.m_8631f87f()
            )
            .m_3c01317a(100)
            .m_c9a0919e(233)
            .m_2e13d085(249)
            .m_f2e6c3ed(3)
            .m_bd30edd7(C0055.anonymousnative.f_fbc25e22);
         if (C0213.f_cb39f22f.m_efa7610e()) {
            this.m_d4e61fad(C0071.f_153c92dd)
               .m_34f2e39e(21)
               .m_7329c2c0(7)
               .m_3c01317a(1)
               .m_c9a0919e(17)
               .m_2e13d085(9)
               .m_f2e6c3ed(3)
               .m_69cc63b5(C0055.anonymoustransient.f_7acb8769)
               .m_bd30edd7(C0058.f_0c7a8cb0);
            this.m_d4e61fad(C0071.f_153c92dd)
               .m_34f2e39e(22)
               .m_7329c2c0(7)
               .m_3c01317a(1)
               .m_c9a0919e(8)
               .m_2e13d085(120)
               .m_f2e6c3ed(2)
               .m_d3c4667d(false)
               .m_69cc63b5(C0055.anonymoustransient.f_7acb8769)
               .m_bd30edd7(C0058.f_0c7a8cb0);
            this.m_d4e61fad(C0071.f_89066a04)
               .m_a8e6bda9(C0253.m_1d87ef21(), 19)
               .m_a8e6bda9(C0256.m_6f1f396d(), -1)
               .m_7329c2c0(7)
               .m_3c01317a(10)
               .m_d3c4667d(false)
               .m_c9a0919e(10)
               .m_2e13d085(118)
               .m_f2e6c3ed(10)
               .m_69cc63b5(C0055.anonymoustransient.f_7acb8769);
            this.m_d4e61fad(C0071.f_89066a04)
               .m_a8e6bda9(C0256.m_6f1f396d(), 13)
               .m_7329c2c0(7)
               .m_3c01317a(20)
               .m_d3c4667d(false)
               .m_c9a0919e(10)
               .m_2e13d085(118)
               .m_f2e6c3ed(10)
               .m_69cc63b5(C0055.anonymoustransient.f_7acb8769);
         }

         this.m_d4e61fad(C0071.f_43b9c78f)
            .m_a8e6bda9(C0256.m_6f1f396d(), 14)
            .m_7329c2c0(7)
            .m_3c01317a(32)
            .m_d3c4667d(false)
            .m_c9a0919e(10)
            .m_2e13d085(118)
            .m_f2e6c3ed(14)
            .m_69cc63b5(C0055.anonymoustransient.f_7acb8769);
         this.m_d4e61fad(C0071.f_43b9c78f)
            .m_34f2e39e(20)
            .m_a8e6bda9(C0256.m_6f1f396d(), -1)
            .m_7329c2c0(7)
            .m_3c01317a(16)
            .m_d3c4667d(false)
            .m_c9a0919e(10)
            .m_2e13d085(118)
            .m_f2e6c3ed(14)
            .m_69cc63b5(C0055.anonymoustransient.f_7acb8769);
      }
   }

   public static enum anonymousfor {
      f_0ac614d8(new C0055.anonymousfalse(), C0256.m_18204724(), 759, 762),
      f_5291574c(new C0055.anonymousfalse(), C0256.m_b251ca51(), 757, 758),
      f_d1aa6d58(new C0055.anonymousdefault(), C0256.m_b886ae1c(), 756),
      f_6ac32328(new C0055.anonymousdefault().m_b46168a2(), C0256.m_79bfaec2(), 755),
      f_8dd85b53(new C0055.anonymousdefault().m_0a1d1c25(), C0256.m_e07cee76(), 735, 754),
      f_8dae18ea(new C0055.anonymousdefault().m_d494a464(), C0256.m_056a389d(), 573, 578);

      public final C0055.anonymousthrows f_90e964e7;
      private final String f_08121b71;
      public final int f_b4ae5032;
      public final int f_bec953de;

      private anonymousfor(C0055.anonymousthrows var3, String var4, int var5, int var6) {
         this.f_90e964e7 = var3;
         this.f_08121b71 = var4;
         this.f_b4ae5032 = var5;
         this.f_bec953de = var6;
      }

      private anonymousfor(C0055.anonymousthrows var3, String var4, int var5) {
         this(var3, var4, var5, var5);
      }

      public boolean m_1521b1fa(int var1) {
         return var1 >= this.f_b4ae5032 && var1 <= this.f_bec953de;
      }

      @Override
      public String toString() {
         return this.f_08121b71;
      }
   }

   static class anonymousinterface implements C0055.anonymoussynchronized {
      private final int f_25503898;
      private final int f_be266d22;

      public anonymousinterface(int var1, int var2) {
         this.f_25503898 = var1;
         this.f_be266d22 = var2;
      }

      @Override
      public int m_d7753de9(Randomizer var1) {
         return var1._nextInt(this.f_be266d22 - this.f_25503898 + 1) + this.f_25503898;
      }
   }

   static class anonymousnative implements C0054 {
      public static final C0055.anonymousnative f_fbc25e22 = new C0055.anonymousnative();

      public anonymousnative() {
      }

      @Override
      public List<BlockPosition> m_f01e936e(Randomizer var1, BlockPosition var2, C0055 var3) {
         return Collections.singletonList(var2);
      }
   }

   interface anonymoussynchronized {
      int m_d7753de9(Randomizer var1);
   }

   static class anonymousthis {
      public static final String f_56507fc3 = C0253.m_1d87ef21();
      private final C0055 f_b2631ca8;

      public anonymousthis(Block var1) {
         this.f_b2631ca8 = new C0055(var1);
      }

      public C0055.anonymousthis m_69cc63b5(C0055.anonymoustransient var1) {
         this.f_b2631ca8.f_6f080da4 = var1;
         return this;
      }

      public C0055.anonymousthis m_34f2e39e(int var1) {
         this.f_b2631ca8.f_4a51c5ba.put(C0253.m_1d87ef21(), var1);
         return this;
      }

      public C0055.anonymousthis m_a8e6bda9(String var1, int var2) {
         this.f_b2631ca8.f_4a51c5ba.put(var1, var2);
         return this;
      }

      public C0055.anonymousthis m_d3c4667d(boolean var1) {
         this.f_b2631ca8.f_5560ec9b = var1;
         return this;
      }

      public C0055.anonymousthis m_f2e6c3ed(int var1) {
         this.f_b2631ca8.f_e282479e = var1;
         return this;
      }

      public C0055.anonymousthis m_7329c2c0(int var1) {
         this.f_b2631ca8.f_6758268f = var1;
         return this;
      }

      public C0055.anonymousthis m_c9a0919e(int var1) {
         this.f_b2631ca8.f_40dbb793 = var1;
         return this;
      }

      public C0055.anonymousthis m_2e13d085(int var1) {
         this.f_b2631ca8.f_4beaab70 = var1;
         return this;
      }

      public C0055.anonymousthis m_e482ba34(float var1) {
         this.f_b2631ca8.f_0ce92f03 = var1;
         return this;
      }

      public C0055.anonymousthis m_0d481ee6(float var1) {
         this.f_b2631ca8.f_ff7fba00 = var1;
         return this;
      }

      public C0055.anonymousthis m_3c01317a(int var1) {
         this.f_b2631ca8.f_ec3910d5 = new C0055.anonymousboolean(var1);
         return this;
      }

      public C0055.anonymousthis m_50a97026(int var1, int var2) {
         this.f_b2631ca8.f_ec3910d5 = new C0055.anonymousinterface(var1, var2);
         return this;
      }

      public C0055.anonymousthis m_bd30edd7(C0054 var1) {
         this.f_b2631ca8.f_ad0c1bd2 = var1;
         return this;
      }

      public C0055.anonymousthis m_e8eadcbf(int var1, String... var2) {
         for (String var6 : var2) {
            this.f_b2631ca8.f_4a51c5ba.put(var6, var1);
         }

         return this;
      }

      public C0055.anonymousthis m_057721d3(String var1) {
         this.f_b2631ca8.f_e938b1dd = var1;
         return this;
      }

      public C0055 m_10ac5519() {
         return this.f_b2631ca8;
      }
   }

   public abstract static class anonymousthrows {
      public final List<C0055> f_01c8ff24 = new ArrayList<>();

      public anonymousthrows() {
      }

      public C0055.anonymousthrows m_33a9b420(C0055... var1) {
         this.f_01c8ff24.addAll(Arrays.asList(var1));
         return this;
      }

      public List<C0055> m_350b5ae0() {
         return this.f_01c8ff24;
      }

      public Stream<C0055> m_94900ef2(Block var1) {
         return this.f_01c8ff24.stream().filter(var1x -> var1x.f_4bf0ba39.equals(var1));
      }

      public C0055.anonymousthis m_d4e61fad(Block var1) {
         C0055.anonymousthis var2 = new C0055.anonymousthis(var1);
         this.f_01c8ff24.add(var2.m_10ac5519());
         return var2;
      }
   }

   public static enum anonymoustransient {
      f_4b7faba2(0),
      f_7acb8769(-1);

      public final int f_d9636f98;

      private anonymoustransient(int var3) {
         this.f_d9636f98 = var3;
      }
   }
}
