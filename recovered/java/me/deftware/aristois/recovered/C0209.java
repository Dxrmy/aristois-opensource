package me.deftware.aristois.recovered;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.deftware.client.framework.registry.IRegistry;

public class C0209<T extends C0217.anonymousthis> implements IRegistry<T, T> {
   private final Collection<T> f_39865ccf;

   public C0209(Stream<T> var1) {
      this(var1.collect(Collectors.toList()));
   }

   public C0209(Collection<T> var1) {
      this.f_39865ccf = var1;
   }

   public Stream<T> stream() {
      return this.f_39865ccf.stream();
   }

   public Optional<T> find(String var1) {
      return this.stream().filter(var1x -> var1x.m_6f1f396d().contains(var1)).findAny();
   }

   public void m_94d0851e(String var1, T var2) {
      this.f_39865ccf.add((T)var2);
   }
}
