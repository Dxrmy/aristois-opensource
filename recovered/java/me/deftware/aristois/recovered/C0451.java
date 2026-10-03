package me.deftware.aristois.recovered;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventBlockUpdate;
import me.deftware.client.framework.event.events.EventChunk;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.event.events.EventBlockUpdate.State;
import me.deftware.client.framework.event.events.EventChunk.Action;
import me.deftware.client.framework.event.events.EventChunk.EventDeltaChunk;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.minecraft.ServerDetails;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.block.Block;

public class C0451 {
   public static final List<String> f_caa11c8f = Lists.newArrayList(
      new String[]{
         C0258.m_e9914bd3(),
         C0258.m_8631f87f(),
         C0258.m_818e6498(),
         C0258.m_56d4c1c7(),
         C0258.m_d32ebe65(),
         C0258.m_afb31f66(),
         C0258.m_c254a253(),
         C0258.m_3d3a8736(),
         C0258.m_94acbdac(),
         C0258.m_022da1b4(),
         C0258.m_6e2d03c3()
      }
   );
   public static final Set<String> f_10c30cb9 = new HashSet<>();
   public static final Predicate<Block> f_1a1ddedc = var0 -> var0.isLiquid() || f_10c30cb9.contains(var0.getIdentifierKey());
   public static final C0451 f_3c37bf88 = new C0451();
   private final List<BiConsumer<C0450, Action>> f_5f7168d7 = new ArrayList<>();
   public final List<Consumer<List<C0066>>> f_6f32d742 = new ArrayList<>();
   private final ExecutorService f_106a9592 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
   private final Map<Long, C0449> f_09774022 = new HashMap<>();
   public static final String f_de1e83e1 = C0256.m_818e6498();
   public static final String f_1ae9d583 = C0258.m_396f9431();
   public static final String f_3afdc7c0 = C0258.m_88937f2b();

   private C0451() {
      if (Main.getConfig().hasKey(C0258.m_5f1ab561())) {
         f_caa11c8f.add(C0258.m_28b2c020());
         f_caa11c8f.add(C0258.m_45aaaba8());
      }

      BlockRegistry.INSTANCE.stream().forEach(var0 -> {
         String var1 = var0.getIdentifierKey();

         for (String var3 : f_caa11c8f) {
            if (var1.matches(var3)) {
               f_10c30cb9.add(var1);
            }
         }
      });
      Runtime.getRuntime().addShutdownHook(new Thread(this::m_1058ed9a));
   }

   private synchronized void m_1058ed9a() {
      for (C0449 var2 : this.f_09774022.values()) {
         var2.m_f1ec3ae8();
      }
   }

   @EventHandler
   private void m_243b8b08(EventBlockUpdate var1) {
      if (var1.getState() == State.Break) {
         this.m_a9f5b72c(var1.getBlock(), var1.getPosition());
         this.f_6f32d742.forEach(var1x -> var1x.accept(Collections.singletonList(new C0066(var1.getPosition(), C0071.f_adbd1d51))));
      }
   }

   @EventHandler
   private void m_732628cc(EventDeltaChunk var1) {
      C0450 var2 = this.m_b6b92f06(var1.getX(), var1.getZ());
      if (var2 != null) {
         ArrayList var3 = new ArrayList();
         int var4 = var1.getY() + (var2.m_36ffc578() >> C0453.f_30a76830);
         C0453 var5 = var2.m_b9dafb46(var4);
         if (var5 != null) {
            for (int var6 = 0; var6 < var1.getPositions().length; var6++) {
               Block var7 = var1.getBlocks()[var6];
               if (!f_1a1ddedc.test(var7)) {
                  short var8 = var1.getPositions()[var6];
                  BlockPosition var9 = var2.m_5974b975(var5, var5.m_7eb97656(var8));
                  C0066 var10 = new C0066(var9, var7);
                  if (var7.isAir()) {
                     for (Entry var12 : var5.m_41982c81().entrySet()) {
                        if (((Set)var12.getValue()).remove(var8)) {
                           var3.add(var10);
                        }
                     }
                  } else if (var5.m_721cdde3(var7).add(var8)) {
                     var3.add(var10);
                  }
               }
            }

            this.f_6f32d742.forEach(var1x -> var1x.accept(var3));
         }
      }
   }

   @EventHandler
   private synchronized void m_c8053988(EventChunk var1) {
      int var2 = C0450.m_2381a1fe(var1.getX());
      int var3 = C0450.m_8a99a9ff(var1.getZ());
      int var4 = C0450.m_d823cf5f(var1.getX());
      int var5 = C0450.m_091917f6(var1.getZ());
      C0449 var6 = this.m_5c914f25(var2, var3);
      if (var1.getAction() == Action.LOAD) {
         if (!var6.m_d7db8b4a(var4, var5)) {
            this.f_106a9592.submit(() -> {
               C0450 var5x = C0450.m_6d749670(var1.getChunk(), var6);
               var6.m_80da0d1a(var4, var5, var5x);
               this.f_5f7168d7.forEach(var1xx -> var1xx.accept(var5x, Action.LOAD));
            });
         }
      } else if (var1.getAction() == Action.UNLOAD) {
         C0450 var7 = var6.m_c046bc68(var4, var5);
         if (var7 != null) {
            this.f_5f7168d7.forEach(var1x -> var1x.accept(var7, Action.UNLOAD));
         }

         if (var6.m_efa7610e()) {
            var6.m_f1ec3ae8();
            this.f_09774022.remove(var6.m_9d4d8e71());
         }
      }
   }

   @EventHandler
   private synchronized void m_270a7d18(EventWorldLoad var1) {
      this.m_1058ed9a();
      this.f_09774022.clear();
   }

   public int m_79bbc2da() {
      return ClientWorld.getClientWorld()._getDimension();
   }

   public Future<?> m_1482fea6(Runnable var1) {
      return this.f_106a9592.submit(var1);
   }

   public void m_ee5d3d0f(BiConsumer<C0450, Action> var1) {
      this.f_5f7168d7.add(var1);
   }

   public synchronized Stream<C0450> m_918b7b9e() {
      ArrayList var1 = new ArrayList();

      for (C0449 var3 : this.f_09774022.values()) {
         var3.m_ed2a80e1(var1::add);
      }

      return var1.stream();
   }

   public synchronized C0450 m_b6b92f06(int var1, int var2) {
      int var3 = C0450.m_2381a1fe(var1);
      int var4 = C0450.m_8a99a9ff(var2);
      C0449 var5 = this.m_baf7328a(var3, var4);
      return var5 == null ? null : var5.m_fad6b1b2(C0450.m_d823cf5f(var1), C0450.m_091917f6(var2));
   }

   public synchronized C0450 m_2857973f(BlockPosition var1) {
      int var2 = C0450.m_68171740((int)var1.getX());
      int var3 = C0450.m_df6b1dec((int)var1.getZ());
      return this.m_b6b92f06(var2, var3);
   }

   public boolean m_5b780737(Block var1, BlockPosition var2) {
      return this.m_1b7f9c92(var2, (var1x, var2x) -> var2x.m_eed07588(var1, var1x));
   }

   public boolean m_a9f5b72c(Block var1, BlockPosition var2) {
      return this.m_1b7f9c92(var2, (var1x, var2x) -> var2x.m_23f7d3e3(var1, var1x));
   }

   public boolean m_4e531893(Block var1, BlockPosition var2) {
      return this.m_1b7f9c92(var2, (var1x, var2x) -> var2x.m_d99ce07a(var1, var1x));
   }

   private boolean m_1b7f9c92(BlockPosition var1, BiFunction<Short, C0453, Boolean> var2) {
      C0450 var3 = this.m_2857973f(var1);
      if (var3 != null) {
         int var4 = (int)var1.getX() - (var3.m_a135e825() << 4);
         int var5 = (int)var1.getZ() - (var3.m_f34ec3cf() << 4);
         int var6 = (int)var1.getY() + var3.m_36ffc578() >> 4;
         int var7 = (int)var1.getY() & 15;
         C0453 var8 = var3.m_b9dafb46(var6);
         if (var8 != null) {
            return (Boolean)var2.apply(C0453.m_8c1d56b6(var4, var7, var5), var8);
         }
      }

      return false;
   }

   public boolean m_1a0730f0(BlockPosition var1) {
      C0450 var2 = this.m_2857973f(var1);
      if (var2 != null) {
         int var3 = (int)var1.getX() - (var2.m_a135e825() << 4);
         int var4 = (int)var1.getZ() - (var2.m_f34ec3cf() << 4);
         C0447 var5 = var2.m_2dd2ccff(var3, var4);
         return var1.getY() > (double)var5.m_79bbc2da();
      } else {
         return false;
      }
   }

   public synchronized C0449 m_baf7328a(int var1, int var2) {
      return this.f_09774022.get(C0449.m_e4655c68(var1, var2));
   }

   public synchronized C0449 m_5c914f25(int var1, int var2) {
      return this.f_09774022.computeIfAbsent(C0449.m_e4655c68(var1, var2), var3 -> {
         C0449 var4 = new C0449(var1, var2, this.m_79bbc2da());
         var4.m_23674f64();
         return var4;
      });
   }

   public static String m_d32ebe65() {
      ServerDetails var0 = Minecraft.getMinecraftGame().getConnectedServer();
      if (Minecraft.getMinecraftGame()._isSinglePlayer()) {
         return Minecraft.getMinecraftGame()._getWorldName();
      } else if (var0 != null) {
         C0142 var1 = new C0142(var0._getAddress());
         if (var0._isLan()) {
            return C0258.m_88937f2b() + var0._getName();
         } else {
            return Minecraft.getMinecraftGame()._isOnRealms() ? C0258.m_396f9431() + var0._getName() : var1.m_3d3a8736();
         }
      } else {
         return C0256.m_818e6498();
      }
   }

   public static String m_3855be80() {
      return m_4521bcf9(false);
   }

   public static String m_4521bcf9(boolean var0) {
      String var1 = m_d32ebe65();
      ClientWorld var2 = ClientWorld.getClientWorld();
      if (var2 != null) {
         int var3 = var2._getDimension();
         if (var3 != 0 || var0) {
            var1 = var1 + C0261.m_6e2d03c3() + var3;
         }
      }

      return var1;
   }
}
