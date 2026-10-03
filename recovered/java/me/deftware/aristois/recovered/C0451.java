package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventBlockUpdate;
import me.deftware.client.framework.event.events.EventChunk;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.event.events.EventBlockUpdate.State;
import me.deftware.client.framework.event.events.EventChunk.Action;
import me.deftware.client.framework.event.events.EventChunk.EventDeltaChunk;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.minecraft.ServerDetails;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.block.Block;

public class C0451 {
   public static final List<String> f_18eeb1af = C0114.bootstrap<"call",0,1>(
      new String[]{
         C0252.bootstrap<"get",60129542178>(),
         C0252.bootstrap<"get",60129542179>(),
         C0252.bootstrap<"get",60129542180>(),
         C0252.bootstrap<"get",60129542181>(),
         C0252.bootstrap<"get",60129542182>(),
         C0252.bootstrap<"get",60129542183>(),
         C0252.bootstrap<"get",60129542184>(),
         C0252.bootstrap<"get",60129542185>(),
         C0252.bootstrap<"get",60129542186>(),
         C0252.bootstrap<"get",60129542187>(),
         C0252.bootstrap<"get",60129542188>()
      }
   );
   public static final Set<String> f_b8e0b6d6 = new HashSet<>();
   public static final Predicate<Block> f_ad14a2a8 = var0 -> var0.isLiquid() || f_b8e0b6d6.contains(var0.getIdentifierKey());
   public static final C0451 f_6cf0f98d = new C0451();
   private final List<BiConsumer<C0450, Action>> f_d3b246dc = new ArrayList<>();
   public final List<Consumer<List<C0066>>> f_66f03ed1 = new ArrayList<>();
   private final ExecutorService f_fffef48c = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>().availableProcessors());
   private final Map<Long, C0449> f_776cec54 = new HashMap<>();
   public static final String f_d429e2de = C0252.bootstrap<"get",55834574884>();
   public static final String f_8176f9c8 = C0252.bootstrap<"get",60129542177>();
   public static final String f_13d5e425 = C0252.bootstrap<"get",60129542176>();

   private C0451() {
      if (C0114.bootstrap<"call",2,1>().hasKey(C0252.bootstrap<"get",60129542173>())) {
         f_18eeb1af.add(C0252.bootstrap<"get",60129542174>());
         f_18eeb1af.add(C0252.bootstrap<"get",60129542175>());
      }

      BlockRegistry.INSTANCE.stream().forEach(var0 -> {
         String var1 = var0.getIdentifierKey();

         for (String var3 : f_18eeb1af) {
            if (var1.matches(var3)) {
               f_b8e0b6d6.add(var1);
            }
         }
      });
      C0114.bootstrap<"call",0,1>().addShutdownHook(new Thread(this::m_c2740a0f));
   }

   private synchronized void m_c2740a0f() {
      for (C0449 var2 : this.f_776cec54.values()) {
         var2.m_33b568ef();
      }
   }

   @EventHandler
   private void m_c4b28f9c(EventBlockUpdate var1) {
      if (var1.getState() == State.Break) {
         this.m_7a1ab05d(var1.getBlock(), var1.getPosition());
         this.f_66f03ed1.forEach(var1x -> var1x.accept(C0114.bootstrap<"call",13,1>(new C0066(var1.getPosition(), C0071.f_f5c338c0))));
      }
   }

   @EventHandler
   private void m_bacd4257(EventDeltaChunk var1) {
      C0450 var2 = this.m_6b9ee92b(var1.getX(), var1.getZ());
      if (var2 != null) {
         ArrayList var3 = new ArrayList();
         int var4 = var1.getY() + (var2.m_8eaa236f() >> C0453.f_369f7639);
         C0453 var5 = var2.m_a46e07ae(var4);
         if (var5 != null) {
            for (int var6 = 0; var6 < var1.getPositions().length; var6++) {
               Block var7 = var1.getBlocks()[var6];
               if (!f_ad14a2a8.test(var7)) {
                  short var8 = var1.getPositions()[var6];
                  BlockPosition var9 = var2.m_30e235b6(var5, var5.m_3f24ee40(var8));
                  C0066 var10 = new C0066(var9, var7);
                  if (var7.isAir()) {
                     for (Entry var12 : var5.m_302dee7e().entrySet()) {
                        if (((Set)var12.getValue()).remove(C0114.bootstrap<"call",0,1>(var8))) {
                           var3.add(var10);
                        }
                     }
                  } else if (var5.m_59ec77d0(var7).add(C0114.bootstrap<"call",0,1>(var8))) {
                     var3.add(var10);
                  }
               }
            }

            this.f_66f03ed1.forEach(var1x -> var1x.accept(var3));
         }
      }
   }

   @EventHandler
   private synchronized void m_d3043690(EventChunk var1) {
      int var2 = C0114.bootstrap<"call",1,1>(var1.getX());
      int var3 = C0114.bootstrap<"call",2,1>(var1.getZ());
      int var4 = C0114.bootstrap<"call",3,1>(var1.getX());
      int var5 = C0114.bootstrap<"call",4,1>(var1.getZ());
      C0449 var6 = this.m_5f27ca64(var2, var3);
      if (var1.getAction() == Action.LOAD) {
         if (!var6.m_6ea01aa9(var4, var5)) {
            this.f_fffef48c.submit(() -> {
               C0450 var5x = C0114.bootstrap<"call",12,1>(var1.getChunk(), var6);
               var6.m_0869e20c(var4, var5, var5x);
               this.f_d3b246dc.forEach(var1xx -> var1xx.accept(var5x, Action.LOAD));
            });
         }
      } else if (var1.getAction() == Action.UNLOAD) {
         C0450 var7 = var6.m_07ba3e7f(var4, var5);
         if (var7 != null) {
            this.f_d3b246dc.forEach(var1x -> var1x.accept(var7, Action.UNLOAD));
         }

         if (var6.m_db8b2094()) {
            var6.m_33b568ef();
            this.f_776cec54.remove(C0114.bootstrap<"call",5,1>(var6.m_0592131b()));
         }
      }
   }

   @EventHandler
   private synchronized void m_eb1f365b(EventWorldLoad var1) {
      this.m_c2740a0f();
      this.f_776cec54.clear();
   }

   public int m_6d652889() {
      return C0114.bootstrap<"call",0,1>()._getDimension();
   }

   public Future<?> m_e02e7992(Runnable var1) {
      return this.f_fffef48c.submit(var1);
   }

   public void m_b3695757(BiConsumer<C0450, Action> var1) {
      this.f_d3b246dc.add(var1);
   }

   public synchronized Stream<C0450> m_9cfb0115() {
      ArrayList var1 = new ArrayList();

      for (C0449 var3 : this.f_776cec54.values()) {
         var3.m_33cf22bb(var1::add);
      }

      return var1.stream();
   }

   public synchronized C0450 m_6b9ee92b(int var1, int var2) {
      int var3 = C0114.bootstrap<"call",1,1>(var1);
      int var4 = C0114.bootstrap<"call",2,1>(var2);
      C0449 var5 = this.m_05ecc206(var3, var4);
      return var5 == null ? null : var5.m_c42e8a86(C0114.bootstrap<"call",3,1>(var1), C0114.bootstrap<"call",4,1>(var2));
   }

   public synchronized C0450 m_017b35bb(BlockPosition var1) {
      int var2 = C0114.bootstrap<"call",6,1>((int)var1.getX());
      int var3 = C0114.bootstrap<"call",7,1>((int)var1.getZ());
      return this.m_6b9ee92b(var2, var3);
   }

   public boolean m_eb853b2e(Block var1, BlockPosition var2) {
      return this.m_9d8b8260(var2, (var1x, var2x) -> C0114.bootstrap<"call",2,1>(var2x.m_45f1e048(var1, var1x)));
   }

   public boolean m_7a1ab05d(Block var1, BlockPosition var2) {
      return this.m_9d8b8260(var2, (var1x, var2x) -> C0114.bootstrap<"call",3,1>(var2x.m_c26d0fc2(var1, var1x)));
   }

   public boolean m_f825eead(Block var1, BlockPosition var2) {
      return this.m_9d8b8260(var2, (var1x, var2x) -> C0114.bootstrap<"call",11,1>(var2x.m_021d9940(var1, var1x)));
   }

   private boolean m_9d8b8260(BlockPosition var1, BiFunction<Short, C0453, Boolean> var2) {
      C0450 var3 = this.m_017b35bb(var1);
      if (var3 != null) {
         int var4 = (int)var1.getX() - (var3.m_9db65578() << 4);
         int var5 = (int)var1.getZ() - (var3.m_ab854c20() << 4);
         int var6 = (int)var1.getY() + var3.m_8eaa236f() >> 4;
         int var7 = (int)var1.getY() & 15;
         C0453 var8 = var3.m_a46e07ae(var6);
         if (var8 != null) {
            return (Boolean)var2.apply(C0114.bootstrap<"call",0,1>(C0114.bootstrap<"call",8,1>(var4, var7, var5)), var8);
         }
      }

      return false;
   }

   public boolean m_91f6dde0(BlockPosition var1) {
      C0450 var2 = this.m_017b35bb(var1);
      if (var2 != null) {
         int var3 = (int)var1.getX() - (var2.m_9db65578() << 4);
         int var4 = (int)var1.getZ() - (var2.m_ab854c20() << 4);
         C0447 var5 = var2.m_b8df0fa0(var3, var4);
         return var1.getY() > (double)var5.m_e496e11c();
      } else {
         return false;
      }
   }

   public synchronized C0449 m_05ecc206(int var1, int var2) {
      return this.f_776cec54.get(C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var1, var2)));
   }

   public synchronized C0449 m_5f27ca64(int var1, int var2) {
      return this.f_776cec54.computeIfAbsent(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var1, var2)), var3 -> {
         C0449 var4 = new C0449(var1, var2, this.m_6d652889());
         var4.m_bb6c7f0f();
         return var4;
      });
   }

   public static String m_d4f4dcd1() {
      ServerDetails var0 = C0114.bootstrap<"call",0,1>().getConnectedServer();
      if (C0114.bootstrap<"call",0,1>()._isSinglePlayer()) {
         return C0114.bootstrap<"call",0,1>()._getWorldName();
      } else if (var0 != null) {
         C0142 var1 = new C0142(var0._getAddress());
         if (var0._isLan()) {
            return C0252.bootstrap<"get",60129542176>() + var0._getName();
         } else {
            return C0114.bootstrap<"call",0,1>()._isOnRealms() ? C0252.bootstrap<"get",60129542177>() + var0._getName() : var1.m_a4d19008();
         }
      } else {
         return C0252.bootstrap<"get",55834574884>();
      }
   }

   public static String m_604a6c39() {
      return C0114.bootstrap<"call",0,1>(false);
   }

   public static String m_a6116c9d(boolean var0) {
      String var1 = C0114.bootstrap<"call",9,1>();
      ClientWorld var2 = C0114.bootstrap<"call",10,1>();
      if (var2 != null) {
         int var3 = var2._getDimension();
         if (var3 != 0 || var0) {
            var1 = var1 + C0252.bootstrap<"get",17179869228>() + var3;
         }
      }

      return var1;
   }
}
