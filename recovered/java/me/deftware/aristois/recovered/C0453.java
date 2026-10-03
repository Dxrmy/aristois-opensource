package me.deftware.aristois.recovered;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.chunk.SectionAccessor;

public class C0453 {
   public static int f_30a76830 = 4;
   public static final Predicate<Block> f_bf91547b = Block::isAir;
   public final int f_586308ed;
   private final Map<Block, Set<Short>> f_9b911df8 = new HashMap<>();
   private final Set<Short> f_822f8eda = new HashSet<>();

   public C0453(SectionAccessor var1, C0450 var2, int var3) {
      this.f_586308ed = var3;

      for (int var4 = 0; var4 < 16; var4++) {
         for (int var5 = 0; var5 < 16; var5++) {
            int var6 = var5 << f_30a76830 | var4;
            boolean var7 = var2.f_adc49585[var6] != null;

            for (int var8 = 15; var8 >= 0; var8--) {
               Block var9 = var1.getBlock(var4, var8, var5);
               if (!var9.isAir() && var2.f_adc49585[var6] == null) {
                  var7 = true;
                  var2.f_adc49585[var6] = new C0447(var9, (var3 << f_30a76830 | var8) - var2.m_36ffc578());
               }

               if (!C0451.f_1a1ddedc.test(var9)) {
                  short var10 = m_8c1d56b6(var4, var8, var5);
                  if (!f_bf91547b.test(var9)) {
                     this.f_9b911df8.computeIfAbsent(var9, var0 -> new HashSet<>()).add(var10);
                  } else if (var7) {
                     this.f_822f8eda.add(var10);
                  }
               }
            }
         }
      }
   }

   public int m_5b3d3148() {
      return this.f_9b911df8.values().stream().mapToInt(Set::size).sum();
   }

   public Set<Short> m_721cdde3(Block var1) {
      return !f_bf91547b.test(var1) ? this.f_9b911df8.computeIfAbsent(var1, var0 -> new HashSet<>()) : this.f_822f8eda;
   }

   public boolean m_eed07588(Block var1, short var2) {
      return this.m_721cdde3(var1).add(var2);
   }

   public boolean m_23f7d3e3(Block var1, short var2) {
      return this.m_721cdde3(var1).remove(var2);
   }

   public Stream<BlockPosition> m_fcd1fcc3(Block var1) {
      return this.f_9b911df8.getOrDefault(var1, Collections.emptySet()).stream().map(this::m_7eb97656);
   }

   public Stream<BlockPosition> m_43d3f186() {
      return this.f_822f8eda.stream().map(this::m_7eb97656);
   }

   public boolean m_d99ce07a(Block var1, short var2) {
      return f_bf91547b.test(var1) ? this.f_822f8eda.contains(var2) : this.f_9b911df8.getOrDefault(var1, Collections.emptySet()).contains(var2);
   }

   public BlockPosition m_7eb97656(short var1) {
      return new DoubleBlockPosition((double)(var1 >>> 8 & 15), (double)(var1 & 15), (double)(var1 >>> 4 & 15));
   }

   public static short m_8c1d56b6(int var0, int var1, int var2) {
      return (short)(var0 << 8 | var2 << 4 | var1);
   }

   public Map<Block, Set<Short>> m_41982c81() {
      return this.f_9b911df8;
   }
}
