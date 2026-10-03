package me.deftware.aristois.recovered;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;
import me.deftware.client.framework.registry.IRegistry;

public class C0209<T extends C0217.anonymousthis> implements IRegistry<T, T> {
   private final Collection<T> f_7288a0ca;

   public C0209(Stream<T> var1) {
      this(var1.collect(C0114.bootstrap<"call",0,1>()));
   }

   public C0209(Collection<T> var1) {
      this.f_7288a0ca = var1;
   }

   public Stream<T> stream() {
      return this.f_7288a0ca.stream();
   }

   public Optional<T> find(String var1) {
      return this.stream().filter(var1x -> var1x.m_35ba7118().contains(var1)).findAny();
   }

   public void m_f400eb08(String var1, T var2) {
      this.f_7288a0ca.add((T)var2);
   }
}
