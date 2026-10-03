package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import me.deftware.client.framework.item.IItem;
import me.deftware.client.framework.registry.IRegistry;

public class C0207 {
   public C0207() {
   }

   public static <T extends IItem> List<T> m_5058bc5d(IRegistry<T, ?> var0, Predicate<T> var1) {
      ArrayList var2 = new ArrayList();
      var0.stream().forEach(var2x -> {
         if (var1.test(var2x)) {
            var2.add(var2x);
         }
      });
      return var2;
   }

   public static <T> List<T> m_d2df6e1e(IRegistry<T, ?> var0, String... var1) {
      ArrayList var2 = new ArrayList();

      for (String var6 : var1) {
         Optional var7 = var0.find(var6);
         var7.ifPresent(var2::add);
      }

      return var2;
   }

   public static <T> T m_502631b2(IRegistry<T, ?> var0, String var1) {
      return (T)var0.find(var1).orElse(null);
   }
}
