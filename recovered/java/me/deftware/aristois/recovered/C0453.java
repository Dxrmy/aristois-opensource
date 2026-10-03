package me.deftware.aristois.recovered;

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
   public static int f_369f7639 = 4;
   public static final Predicate<Block> f_04c6e417 = Block::isAir;
   public final int f_ab17c72a;
   private final Map<Block, Set<Short>> f_1a02392e = new HashMap<>();
   private final Set<Short> f_49b5169d = new HashSet<>();

   public C0453(SectionAccessor var1, C0450 var2, int var3) {
      this.f_ab17c72a = var3;

      for (int var4 = 0; var4 < 16; var4++) {
         for (int var5 = 0; var5 < 16; var5++) {
            int var6 = var5 << f_369f7639 | var4;
            boolean var7 = var2.f_ba0ba998[var6] != null;

            for (int var8 = 15; var8 >= 0; var8--) {
               Block var9 = var1.getBlock(var4, var8, var5);
               if (!var9.isAir() && var2.f_ba0ba998[var6] == null) {
                  var7 = true;
                  var2.f_ba0ba998[var6] = new C0447(var9, (var3 << f_369f7639 | var8) - var2.m_8eaa236f());
               }

               if (!C0451.f_ad14a2a8.test(var9)) {
                  short var10 = C0114.bootstrap<"call",0,1>(var4, var8, var5);
                  if (!f_04c6e417.test(var9)) {
                     this.f_1a02392e.computeIfAbsent(var9, var0 -> new HashSet<>()).add(C0114.bootstrap<"call",1,1>(var10));
                  } else if (var7) {
                     this.f_49b5169d.add(C0114.bootstrap<"call",1,1>(var10));
                  }
               }
            }
         }
      }
   }

   public int m_4f81a44a() {
      return this.f_1a02392e.values().stream().mapToInt(Set::size).sum();
   }

   public Set<Short> m_59ec77d0(Block var1) {
      return !f_04c6e417.test(var1) ? this.f_1a02392e.computeIfAbsent(var1, var0 -> new HashSet<>()) : this.f_49b5169d;
   }

   public boolean m_45f1e048(Block var1, short var2) {
      return this.m_59ec77d0(var1).add(C0114.bootstrap<"call",0,1>(var2));
   }

   public boolean m_c26d0fc2(Block var1, short var2) {
      return this.m_59ec77d0(var1).remove(C0114.bootstrap<"call",0,1>(var2));
   }

   public Stream<BlockPosition> m_49993109(Block var1) {
      return this.f_1a02392e.getOrDefault(var1, C0114.bootstrap<"call",1,1>()).stream().map(this::m_3f24ee40);
   }

   public Stream<BlockPosition> m_12a4a6d8() {
      return this.f_49b5169d.stream().map(this::m_3f24ee40);
   }

   public boolean m_021d9940(Block var1, short var2) {
      return f_04c6e417.test(var1)
         ? this.f_49b5169d.contains(C0114.bootstrap<"call",0,1>(var2))
         : this.f_1a02392e.getOrDefault(var1, C0114.bootstrap<"call",1,1>()).contains(C0114.bootstrap<"call",0,1>(var2));
   }

   public BlockPosition m_3f24ee40(short var1) {
      return new DoubleBlockPosition((double)(var1 >>> 8 & 15), (double)(var1 & 15), (double)(var1 >>> 4 & 15));
   }

   public static short m_e55ba499(int var0, int var1, int var2) {
      return (short)(var0 << 8 | var2 << 4 | var1);
   }

   public Map<Block, Set<Short>> m_302dee7e() {
      return this.f_1a02392e;
   }
}
