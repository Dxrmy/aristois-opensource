package me.deftware.aristois.recovered;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import me.deftware.client.framework.world.block.Block;

public class C0275<T> extends C0283<C0283.anonymousconst> {
   private Map<T, List<C0283.anonymousconst>> f_0a0538a4 = new LinkedHashMap<>();
   private final Runnable f_d04492fe;

   public C0275(Predicate<C0283.anonymousconst> var1, int var2, BiFunction<C0283.anonymousconst, Map<String, Block>, T> var3) {
      super(var1, var2);
      this.f_d04492fe = () -> {
         ConcurrentHashMap var2x = new ConcurrentHashMap();
         LinkedHashMap var3x = new LinkedHashMap();
         this.f_cb36c263.forEach(var1xx -> {
            Block var10000 = var3x.put(var1xx.m_8ac0e23f().toString(), var1xx.m_5d9fe07a());
         });
         this.f_cb36c263.forEach(var3xx -> {
            Object var4 = var3.apply(var3xx, var3x);
            if (!var2x.containsKey(var4)) {
               var2x.put(var4, new LinkedList());
            }

            ((List)var2x.get(var4)).add(var3xx);
         });
         this.f_0a0538a4 = var2x;
      };
   }

   public C0275<T> m_0e0e46fe() {
      this.f_ff28c5e4 = C0114.bootstrap<"call",0,1>().scheduleAtFixedRate(() -> {
         this.f_dab6c988.run();
         this.f_d04492fe.run();
      }, 0L, 50L, TimeUnit.MILLISECONDS);
      this.f_750bc60e = C0114.bootstrap<"call",1,1>();
      this.f_4736ef99 = true;
      return this;
   }

   public Map<T, List<C0283.anonymousconst>> m_deb0b934() {
      return this.f_0a0538a4;
   }
}
