package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;

public class C0068 implements C0067 {
   public static final Map<EnumFacing, C0065> f_0f817432 = new HashMap<>();
   public static final C0065 f_bcf83d78 = C0114.bootstrap<"call",0,1>((var0, var1) -> {
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
   }, EnumFacing.UP);
   public static final C0065 f_cf3cb8e7 = C0114.bootstrap<"call",0,1>((var0, var1) -> {
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
   }, EnumFacing.DOWN);
   public static final C0065 f_b1281085 = C0114.bootstrap<"call",0,1>((var0, var1) -> {
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
   }, EnumFacing.SOUTH);
   public static final C0065 f_bb98b0d4 = C0114.bootstrap<"call",0,1>((var0, var1) -> {
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
   }, EnumFacing.NORTH);
   public static final C0065 f_d1f55713 = C0114.bootstrap<"call",0,1>((var0, var1) -> {
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMinX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMinX(), var0.getMinY(), var0.getMinZ()).next();
   }, EnumFacing.WEST);
   public static final C0065 f_1a9fcd07 = C0114.bootstrap<"call",0,1>((var0, var1) -> {
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMinZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMaxY(), var0.getMaxZ()).next();
      var1.vertex(var0.getMaxX(), var0.getMinY(), var0.getMaxZ()).next();
   }, EnumFacing.EAST);
   private BiPredicate<Block, BlockPosition> f_f7ee786b = C0451.f_6cf0f98d::m_f825eead;
   private Function<C0066, Color> f_717958f2 = var0 -> C0114.bootstrap<"call",5,1>(var0.f_580c1967);
   protected final Map<Long, List<C0069>> f_0ea8fc12 = new ConcurrentHashMap<>();
   private int f_a70a22ca = 4;
   private Predicate<Block> f_50764587 = var0 -> true;

   public C0068() {
   }

   public static C0065 m_f8996bc4(C0065 var0, EnumFacing var1) {
      f_0f817432.put(var1, var0);
      return var0;
   }

   public void m_3b275439() {
      this.f_0ea8fc12.clear();
   }

   public void m_093e3f96(Collection<BlockPosition> var1) {
      ArrayList var2 = new ArrayList();

      for (Entry var4 : this.f_0ea8fc12.entrySet()) {
         List var5 = (List)var4.getValue();
         var5.removeIf(var1x -> !var1.contains(var1x.m_02522bed()));
         if (var5.isEmpty()) {
            var2.add(var4.getKey());
         }
      }

      var2.forEach(this.f_0ea8fc12::remove);
   }

   public void m_7674d8f0(Runnable var1) {
      C0114.bootstrap<"call",0,1>(var1, 3000L);
   }

   public boolean m_06e0a4f6(BlockPosition var1) {
      return this.f_0ea8fc12
         .getOrDefault(C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var1)), C0114.bootstrap<"call",3,1>())
         .stream()
         .map(C0069::m_02522bed)
         .anyMatch(var1x -> var1x.equals(var1));
   }

   public int m_ba7c5d74() {
      return this.f_0ea8fc12.size();
   }

   public void m_d9731494(RenderStack<?> var1, int var2, int var3, int var4) {
      for (Entry var6 : this.f_0ea8fc12.entrySet()) {
         long var7 = (Long)var6.getKey();
         double var9 = (double)(var2 - (int)var7);
         double var11 = (double)(var3 - (int)(var7 >> 32));
         double var13 = C0114.bootstrap<"call",4,1>(var9 * var9 + var11 * var11);
         if (var13 <= (double)var4) {
            for (C0069 var16 : (List)var6.getValue()) {
               if (this.f_50764587.test(var16.m_69395525())) {
                  var16.m_380bf3b4(var1);
               }
            }
         }
      }
   }

   public void m_7d4bb95a(Iterable<C0066> var1) {
      for (C0066 var3 : var1) {
         this.m_48bea716(var3);
      }
   }

   public void m_48bea716(C0066 var1) {
      this.m_e89ef5fe(var1, this.f_717958f2);
   }

   public void m_e89ef5fe(C0066 var1, Function<C0066, Color> var2) {
      List var3 = this.f_0ea8fc12
         .computeIfAbsent(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var1.f_2d141078)), var0 -> new CopyOnWriteArrayList<>());
      List var4 = this.m_a7540311(var1);
      if (var4.size() <= this.f_a70a22ca) {
         List var5 = C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>()).filter(var1x -> !var4.contains(var1x)).collect(C0114.bootstrap<"call",4,1>());
         C0069 var6 = new C0069(var5, var1, (Color)var2.apply(var1));
         int var7 = var3.indexOf(var6);
         if (var7 != -1) {
            var3.set(var7, var6);
         } else {
            var3.add(var6);
         }
      }
   }

   public void m_09798ad6(BlockPosition var1) {
      long var2 = C0114.bootstrap<"call",0,1>(var1);
      if (this.f_0ea8fc12.containsKey(C0114.bootstrap<"call",1,1>(var2))) {
         this.f_0ea8fc12.get(C0114.bootstrap<"call",1,1>(var2)).removeIf(var1x -> var1x.m_02522bed().equals(var1));
      }
   }

   public void m_8828e4fd(BlockPosition var1) {
      long var2 = C0114.bootstrap<"call",0,1>(var1);
      if (this.f_0ea8fc12.containsKey(C0114.bootstrap<"call",1,1>(var2))) {
         for (C0069 var6 : this.f_0ea8fc12.get(C0114.bootstrap<"call",1,1>(var2))) {
            for (EnumFacing var10 : C0114.bootstrap<"call",2,1>()) {
               BlockPosition var11 = var1.offset(var10);
               if (var6.m_02522bed().equals(var11)) {
                  List var12 = this.m_a7540311(var6.m_002398fa());
                  List var13 = C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>())
                     .filter(var1x -> !var12.contains(var1x))
                     .collect(C0114.bootstrap<"call",4,1>());
                  var6.m_9c6233fb(var13);
               }
            }
         }
      }
   }

   private List<EnumFacing> m_a7540311(C0066 var1) {
      ArrayList var2 = new ArrayList();

      for (EnumFacing var6 : C0114.bootstrap<"call",5,1>()) {
         BlockPosition var7 = var1.f_2d141078.offset(var6);
         if (this.f_f7ee786b.test(var1.f_580c1967, var7)) {
            var2.add(var6);
         }
      }

      return var2;
   }

   public void m_487d86d4(long var1) {
      this.f_0ea8fc12.remove(C0114.bootstrap<"call",1,1>(var1));
   }

   public boolean m_0243c826(long var1) {
      return this.f_0ea8fc12.containsKey(C0114.bootstrap<"call",2,1>(var1));
   }

   public void m_ce447e8d(BiPredicate<Block, BlockPosition> var1) {
      this.f_f7ee786b = var1;
   }

   public void m_54c2833e(Function<C0066, Color> var1) {
      this.f_717958f2 = var1;
   }

   public Map<Long, List<C0069>> m_f3a2b5f8() {
      return this.f_0ea8fc12;
   }

   public void m_ce7c684e(int var1) {
      this.f_a70a22ca = var1;
   }

   public void m_0a94c119(Predicate<Block> var1) {
      this.f_50764587 = var1;
   }
}
