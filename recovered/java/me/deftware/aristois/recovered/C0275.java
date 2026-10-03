package me.deftware.aristois.recovered;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import me.deftware.client.framework.world.block.Block;

public class C0275<T> extends C0283<C0283.anonymousconst> {
   private Map<T, List<C0283.anonymousconst>> f_7e9e93ec = new LinkedHashMap<>();
   private final Runnable f_a4cd14f0;

   public C0275(Predicate<C0283.anonymousconst> var1, int var2, BiFunction<C0283.anonymousconst, Map<String, Block>, T> var3) {
      super(var1, var2);
      this.f_a4cd14f0 = () -> {
         ConcurrentHashMap var2x = new ConcurrentHashMap();
         LinkedHashMap var3x = new LinkedHashMap();
         this.f_0c75d6e7.forEach(var1xx -> {
            Block var10000 = var3x.put(var1xx.m_82942af9().toString(), var1xx.m_268de4b2());
         });
         this.f_0c75d6e7.forEach(var3xx -> {
            Object var4 = var3.apply(var3xx, var3x);
            if (!var2x.containsKey(var4)) {
               var2x.put(var4, new LinkedList());
            }

            ((List)var2x.get(var4)).add(var3xx);
         });
         this.f_7e9e93ec = var2x;
      };
   }

   public C0275<T> m_0bdfa3f3() {
      this.f_5c3828cd = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
         this.f_af160a87.run();
         this.f_a4cd14f0.run();
      }, 0L, 50L, TimeUnit.MILLISECONDS);
      this.f_ae2cc37b = System.currentTimeMillis();
      this.f_0e95c81f = true;
      return this;
   }

   public Map<T, List<C0283.anonymousconst>> m_b4f914e1() {
      return this.f_7e9e93ec;
   }
}
