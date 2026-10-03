package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;

public class C0068 implements C0067 {
   public static final Map<EnumFacing, C0065> f_976b17f3 = new HashMap<>();
   public static final C0065 f_17b036f4 = m_acd8afa3((var0, var1) -> {
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
   }, EnumFacing.UP);
   public static final C0065 f_a46821a4 = m_acd8afa3((var0, var1) -> {
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
   }, EnumFacing.DOWN);
   public static final C0065 f_18d95d35 = m_acd8afa3((var0, var1) -> {
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
   }, EnumFacing.SOUTH);
   public static final C0065 f_7b2a2733 = m_acd8afa3((var0, var1) -> {
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
   }, EnumFacing.NORTH);
   public static final C0065 f_1aa59790 = m_acd8afa3((var0, var1) -> {
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
   }, EnumFacing.WEST);
   public static final C0065 f_fa1aa235 = m_acd8afa3((var0, var1) -> {
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
   }, EnumFacing.EAST);
   private BiPredicate<Block, BlockPosition> f_020993c9 = C0451.f_3c37bf88::m_4e531893;
   private Function<C0066, Color> f_64566f6e = var0 -> C0071.m_b9636182(var0.f_bc3f6e3b);
   protected final Map<Long, List<C0069>> f_082fcbef = new ConcurrentHashMap<>();
   private int f_f17db659 = 4;
   private Predicate<Block> f_cc4c1281 = var0 -> true;

   public C0068() {
   }

   public static C0065 m_acd8afa3(C0065 var0, EnumFacing var1) {
      f_976b17f3.put(var1, var0);
      return var0;
   }

   @Override
   public void m_41e83f88() {
      this.f_082fcbef.clear();
   }

   public void m_21736e90(Collection<BlockPosition> var1) {
      ArrayList var2 = new ArrayList();

      for (Entry var4 : this.f_082fcbef.entrySet()) {
         List var5 = (List)var4.getValue();
         var5.removeIf(var1x -> !var1.contains(var1x.m_82942af9()));
         if (var5.isEmpty()) {
            var2.add(var4.getKey());
         }
      }

      var2.forEach(this.f_082fcbef::remove);
   }

   @Override
   public void m_842fae32(Runnable var1) {
      C0217.m_1d393e3f(var1, 3000L);
   }

   @Override
   public boolean m_1a0730f0(BlockPosition var1) {
      return this.f_082fcbef
         .getOrDefault(C0450.m_255478a0(var1), Collections.emptyList())
         .stream()
         .map(C0069::m_82942af9)
         .anyMatch(var1x -> var1x.equals(var1));
   }

   @Override
   public int m_79bbc2da() {
      return this.f_082fcbef.size();
   }

   @Override
   public void m_352d0b9e(RenderStack<?> var1, int var2, int var3, int var4) {
      for (Entry var6 : this.f_082fcbef.entrySet()) {
         long var7 = (Long)var6.getKey();
         double var9 = (double)(var2 - (int)var7);
         double var11 = (double)(var3 - (int)(var7 >> 32));
         double var13 = Math.sqrt(var9 * var9 + var11 * var11);
         if (var13 <= (double)var4) {
            for (C0069 var16 : (List)var6.getValue()) {
               if (this.f_cc4c1281.test(var16.m_268de4b2())) {
                  var16.m_41e9cd11(var1);
               }
            }
         }
      }
   }

   @Override
   public void m_e764c4eb(Iterable<C0066> var1) {
      for (C0066 var3 : var1) {
         this.m_6f674dd3(var3);
      }
   }

   public void m_6f674dd3(C0066 var1) {
      this.m_0e10d2a9(var1, this.f_64566f6e);
   }

   public void m_0e10d2a9(C0066 var1, Function<C0066, Color> var2) {
      List var3 = this.f_082fcbef.computeIfAbsent(C0450.m_255478a0(var1.f_5cbc6730), var0 -> new CopyOnWriteArrayList<>());
      List var4 = this.m_9128eece(var1);
      if (var4.size() <= this.f_f17db659) {
         List var5 = Arrays.stream(EnumFacing.values()).filter(var1x -> !var4.contains(var1x)).collect(Collectors.toList());
         C0069 var6 = new C0069(var5, var1, (Color)var2.apply(var1));
         int var7 = var3.indexOf(var6);
         if (var7 != -1) {
            var3.set(var7, var6);
         } else {
            var3.add(var6);
         }
      }
   }

   public void m_2405ca7d(BlockPosition var1) {
      long var2 = C0450.m_255478a0(var1);
      if (this.f_082fcbef.containsKey(var2)) {
         this.f_082fcbef.get(var2).removeIf(var1x -> var1x.m_82942af9().equals(var1));
      }
   }

   public void m_f87f5317(BlockPosition var1) {
      long var2 = C0450.m_255478a0(var1);
      if (this.f_082fcbef.containsKey(var2)) {
         for (C0069 var6 : this.f_082fcbef.get(var2)) {
            for (EnumFacing var10 : EnumFacing.values()) {
               BlockPosition var11 = var1.offset(var10);
               if (var6.m_82942af9().equals(var11)) {
                  List var12 = this.m_9128eece(var6.m_f8f51e05());
                  List var13 = Arrays.stream(EnumFacing.values()).filter(var1x -> !var12.contains(var1x)).collect(Collectors.toList());
                  var6.m_1793329a(var13);
               }
            }
         }
      }
   }

   private List<EnumFacing> m_9128eece(C0066 var1) {
      ArrayList var2 = new ArrayList();

      for (EnumFacing var6 : EnumFacing.values()) {
         BlockPosition var7 = var1.f_5cbc6730.offset(var6);
         if (this.f_020993c9.test(var1.f_bc3f6e3b, var7)) {
            var2.add(var6);
         }
      }

      return var2;
   }

   public void m_ad6c7e6f(long var1) {
      this.f_082fcbef.remove(var1);
   }

   public boolean m_ba0de549(long var1) {
      return this.f_082fcbef.containsKey(var1);
   }

   public void m_e4640d90(BiPredicate<Block, BlockPosition> var1) {
      this.f_020993c9 = var1;
   }

   public void m_b50f8578(Function<C0066, Color> var1) {
      this.f_64566f6e = var1;
   }

   public Map<Long, List<C0069>> m_41982c81() {
      return this.f_082fcbef;
   }

   public void m_46938bdb(int var1) {
      this.f_f17db659 = var1;
   }

   public void m_da1753cf(Predicate<Block> var1) {
      this.f_cc4c1281 = var1;
   }
}
