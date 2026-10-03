package me.deftware.aristois.recovered;

import java.util.AbstractList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C0208<T> extends AbstractList<T> {
   private final List<T> f_d1a18985;
   private final Predicate<T> f_2628e565;
   private Comparator<T> f_57edc29e;

   public C0208(List<T> var1, Predicate<T> var2) {
      this.f_d1a18985 = var1;
      this.f_2628e565 = var2;
   }

   private List<T> m_350b5ae0() {
      Stream var1 = this.f_d1a18985.stream().filter(this.f_2628e565);
      if (this.f_57edc29e != null) {
         var1 = var1.sorted(this.f_57edc29e);
      }

      return var1.collect(Collectors.toList());
   }

   @Override
   public T get(int var1) {
      return this.m_350b5ae0().get(var1);
   }

   @Override
   public int size() {
      return this.m_350b5ae0().size();
   }

   public C0208<T> m_e9d9653a(Comparator<T> var1) {
      this.f_57edc29e = var1;
      return this;
   }
}
