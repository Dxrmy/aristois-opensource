package me.deftware.aristois.recovered;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.client.framework.registry.IRegistry;

public class C0206<T> implements IRegistry<T, T> {
   private final IRegistry<T, ?> f_7b04ed64;
   private final Predicate<T> f_3f9f418b;

   public C0206(IRegistry<T, ?> var1, Predicate<T> var2) {
      this.f_7b04ed64 = var1;
      this.f_3f9f418b = var2;
   }

   public Optional<T> find(String var1) {
      return this.f_7b04ed64.find(var1);
   }

   public Stream<T> stream() {
      return this.f_7b04ed64.stream().filter(this.f_3f9f418b);
   }

   public void register(String var1, T var2) {
      throw new UnsupportedOperationException(C0252.bootstrap<"get",55834574932>());
   }
}
