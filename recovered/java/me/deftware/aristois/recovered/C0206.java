package me.deftware.aristois.recovered;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.client.framework.registry.IRegistry;

public class C0206<T> implements IRegistry<T, T> {
   private final IRegistry<T, ?> f_0c3aeb26;
   private final Predicate<T> f_0f34f823;

   public C0206(IRegistry<T, ?> var1, Predicate<T> var2) {
      this.f_0c3aeb26 = var1;
      this.f_0f34f823 = var2;
   }

   public Optional<T> find(String var1) {
      return this.f_0c3aeb26.find(var1);
   }

   public Stream<T> stream() {
      return this.f_0c3aeb26.stream().filter(this.f_0f34f823);
   }

   public void register(String var1, T var2) {
      throw new UnsupportedOperationException(C0256.m_a55b07ff());
   }
}
