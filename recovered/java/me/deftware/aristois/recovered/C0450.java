package me.deftware.aristois.recovered;

import java.util.ArrayList;
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
   private final int f_2f2908db;
   private final int f_44146268;
   private final int f_4a366357;
   private final int f_163d6433;
   private final C0453[] f_1b87698d;
   public final C0447[] f_ba0ba998 = new C0447[16 << C0453.f_369f7639];
   private final Set<Integer> f_29432ab1;
   private final C0449 f_e4128099;

   public C0450(ChunkAccessor var1, C0449 var2) {
      this.f_4a366357 = var1.getChunkPosX();
      this.f_163d6433 = var1.getChunkPosZ();
      this.f_44146268 = var1.getChunkHeight();
      this.f_2f2908db = C0114.bootstrap<"call",0,1>(var1.getChunkMinY());
      this.f_1b87698d = new C0453[this.f_44146268 >> 4];
      this.f_e4128099 = var2;
      this.f_29432ab1 = var2.m_780133c6().computeIfAbsent(C0114.bootstrap<"call",1,1>(this.m_f5501f1c()), var0 -> new HashSet<>());
   }

   public Stream<BlockPosition> m_cc5fafd4(Block var1) {
      return this.m_b4ad563d(var1x -> var1x.m_49993109(var1));
   }

   public Stream<BlockPosition> m_7c0c020b() {
      return this.m_b4ad563d(C0453::m_12a4a6d8);
   }

   private Stream<BlockPosition> m_b4ad563d(Function<C0453, Stream<BlockPosition>> var1) {
      ArrayList var2 = new ArrayList();

      for (C0453 var6 : this.f_1b87698d) {
         if (var6 != null) {
            ((Stream)var1.apply(var6)).map(var2x -> this.m_30e235b6(var6, var2x)).forEach(var2::add);
         }
      }

      return var2.stream();
   }

   public BlockPosition m_30e235b6(C0453 var1, BlockPosition var2) {
      return var2.offset(
         (double)(this.f_4a366357 << C0453.f_369f7639),
         (double)((var1.f_ab17c72a << C0453.f_369f7639) - this.f_2f2908db),
         (double)(this.f_163d6433 << C0453.f_369f7639)
      );
   }

   public C0447 m_b8df0fa0(int var1, int var2) {
      return this.f_ba0ba998[var2 << 4 | var1];
   }

   public static C0450 m_e409fd9c(ChunkAccessor var0, C0449 var1) {
      long var2 = C0114.bootstrap<"call",0,1>();
      int var4 = var0.getChunkHeight() / 16;
      C0450 var5 = new C0450(var0, var1);

      for (int var6 = var4 - 1; var6 >= 0; var6--) {
         SectionAccessor var7 = var0.getSection(var6);
         if (var7 != null) {
            var5.f_1b87698d[var6] = new C0453(var7, var5, var6);
         }
      }

      long var8 = (C0114.bootstrap<"call",0,1>() - var2) / 1000000L;
      return var5;
   }

   public C0453 m_a46e07ae(int var1) {
      return this.f_1b87698d[var1];
   }

   public int m_f13636f0() {
      return C0114.bootstrap<"call",0,1>(this.f_1b87698d).filter(Objects::nonNull).mapToInt(C0453::m_4f81a44a).sum();
   }

   public long m_f5501f1c() {
      return C0114.bootstrap<"call",0,1>(this.f_4a366357, this.f_163d6433);
   }

   public static long m_4961e3ac(int var0, int var1) {
      return (long)var1 << 32 | (long)var0 & 4294967295L;
   }

   public static long m_4e34144a(BlockPosition var0) {
      return C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",1,1>((int)var0.getX()), C0114.bootstrap<"call",2,1>((int)var0.getZ()));
   }

   public void m_a8e21a4e(int var1) {
      this.f_29432ab1.add(C0114.bootstrap<"call",1,1>(var1));
      this.f_e4128099.m_e2783c8e();
   }

   public boolean m_91b2353a(int var1) {
      return this.f_29432ab1.contains(C0114.bootstrap<"call",1,1>(var1));
   }

   public static int m_72b7885c(int var0) {
      return var0 >> C0453.f_369f7639;
   }

   public static int m_3d346c05(int var0) {
      return var0 >> C0453.f_369f7639;
   }

   public static int m_bf67212e(int var0) {
      return var0 >> 5;
   }

   public static int m_d6f299d9(int var0) {
      return var0 >> 5;
   }

   public static int m_ddf4c988(int var0) {
      return var0 & 31;
   }

   public static int m_db027bfc(int var0) {
      return var0 & 31;
   }

   public int m_61aab038(int var1, int var2, int var3) {
      var2 += this.f_2f2908db;
      return var1 << 13 | var3 << 9 | var2;
   }

   public int m_dd4023f2(BlockPosition var1) {
      int var2 = (int)var1.getX() - (this.f_4a366357 << 4);
      int var3 = (int)var1.getZ() - (this.f_163d6433 << 4);
      return this.m_61aab038(var2, (int)var1.getY(), var3);
   }

   public int m_8eaa236f() {
      return this.f_2f2908db;
   }

   public int m_9db65578() {
      return this.f_4a366357;
   }

   public int m_ab854c20() {
      return this.f_163d6433;
   }

   public C0453[] m_6091c3c0() {
      return this.f_1b87698d;
   }
}
