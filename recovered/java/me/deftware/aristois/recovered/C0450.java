package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.chunk.ChunkAccessor;
import me.deftware.client.framework.world.chunk.SectionAccessor;

public class C0450 {
   private final int f_df2ae37d;
   private final int f_3bdb1c6c;
   private final int f_9ea7c808;
   private final int f_c58be027;
   private final C0453[] f_f92345c0;
   public final C0447[] f_adc49585 = new C0447[16 << C0453.f_30a76830];
   private final Set<Integer> f_afeaed21;
   private final C0449 f_0886cf81;

   public C0450(ChunkAccessor var1, C0449 var2) {
      this.f_9ea7c808 = var1.getChunkPosX();
      this.f_c58be027 = var1.getChunkPosZ();
      this.f_3bdb1c6c = var1.getChunkHeight();
      this.f_df2ae37d = Math.abs(var1.getChunkMinY());
      this.f_f92345c0 = new C0453[this.f_3bdb1c6c >> 4];
      this.f_0886cf81 = var2;
      this.f_afeaed21 = var2.m_203344cd().computeIfAbsent(this.m_b580fe58(), var0 -> new HashSet<>());
   }

   public Stream<BlockPosition> m_94900ef2(Block var1) {
      return this.m_7f11fd11(var1x -> var1x.m_fcd1fcc3(var1));
   }

   public Stream<BlockPosition> m_7795e2db() {
      return this.m_7f11fd11(C0453::m_43d3f186);
   }

   private Stream<BlockPosition> m_7f11fd11(Function<C0453, Stream<BlockPosition>> var1) {
      ArrayList var2 = new ArrayList();

      for (C0453 var6 : this.f_f92345c0) {
         if (var6 != null) {
            ((Stream)var1.apply(var6)).map(var2x -> this.m_5974b975(var6, var2x)).forEach(var2::add);
         }
      }

      return var2.stream();
   }

   public BlockPosition m_5974b975(C0453 var1, BlockPosition var2) {
      return var2.offset(
         (double)(this.f_9ea7c808 << C0453.f_30a76830),
         (double)((var1.f_586308ed << C0453.f_30a76830) - this.f_df2ae37d),
         (double)(this.f_c58be027 << C0453.f_30a76830)
      );
   }

   public C0447 m_2dd2ccff(int var1, int var2) {
      return this.f_adc49585[var2 << 4 | var1];
   }

   public static C0450 m_6d749670(ChunkAccessor var0, C0449 var1) {
      long var2 = System.nanoTime();
      int var4 = var0.getChunkHeight() / 16;
      C0450 var5 = new C0450(var0, var1);

      for (int var6 = var4 - 1; var6 >= 0; var6--) {
         SectionAccessor var7 = var0.getSection(var6);
         if (var7 != null) {
            var5.f_f92345c0[var6] = new C0453(var7, var5, var6);
         }
      }

      long var8 = (System.nanoTime() - var2) / 1000000L;
      return var5;
   }

   public C0453 m_b9dafb46(int var1) {
      return this.f_f92345c0[var1];
   }

   public int m_79bbc2da() {
      return Arrays.stream(this.f_f92345c0).filter(Objects::nonNull).mapToInt(C0453::m_5b3d3148).sum();
   }

   public long m_b580fe58() {
      return m_9d673c1c(this.f_9ea7c808, this.f_c58be027);
   }

   public static long m_9d673c1c(int var0, int var1) {
      return (long)var1 << 32 | (long)var0 & 4294967295L;
   }

   public static long m_255478a0(BlockPosition var0) {
      return m_9d673c1c(m_68171740((int)var0.getX()), m_df6b1dec((int)var0.getZ()));
   }

   public void m_7c7fe86a(int var1) {
      this.f_afeaed21.add(var1);
      this.f_0886cf81.m_0e389a72();
   }

   public boolean m_aa45d95d(int var1) {
      return this.f_afeaed21.contains(var1);
   }

   public static int m_68171740(int var0) {
      return var0 >> C0453.f_30a76830;
   }

   public static int m_df6b1dec(int var0) {
      return var0 >> C0453.f_30a76830;
   }

   public static int m_2381a1fe(int var0) {
      return var0 >> 5;
   }

   public static int m_8a99a9ff(int var0) {
      return var0 >> 5;
   }

   public static int m_d823cf5f(int var0) {
      return var0 & 31;
   }

   public static int m_091917f6(int var0) {
      return var0 & 31;
   }

   public int m_29c36efd(int var1, int var2, int var3) {
      var2 += this.f_df2ae37d;
      return var1 << 13 | var3 << 9 | var2;
   }

   public int m_0958cad0(BlockPosition var1) {
      int var2 = (int)var1.getX() - (this.f_9ea7c808 << 4);
      int var3 = (int)var1.getZ() - (this.f_c58be027 << 4);
      return this.m_29c36efd(var2, (int)var1.getY(), var3);
   }

   public int m_36ffc578() {
      return this.f_df2ae37d;
   }

   public int m_a135e825() {
      return this.f_9ea7c808;
   }

   public int m_f34ec3cf() {
      return this.f_c58be027;
   }

   public C0453[] m_cbf9c728() {
      return this.f_f92345c0;
   }
}
