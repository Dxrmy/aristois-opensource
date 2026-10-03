package me.deftware.aristois.recovered;

import java.util.AbstractList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class C0208<T> extends AbstractList<T> {
   private final List<T> f_ba967999;
   private final Predicate<T> f_fe82870c;
   private Comparator<T> f_15085994;

   public C0208(List<T> var1, Predicate<T> var2) {
      this.f_ba967999 = var1;
      this.f_fe82870c = var2;
   }

   private List<T> m_6ff347e5() {
      Stream var1 = this.f_ba967999.stream().filter(this.f_fe82870c);
      if (this.f_15085994 != null) {
         var1 = var1.sorted(this.f_15085994);
      }

      return var1.collect(C0114.bootstrap<"call",0,1>());
   }

   @Override
   public T get(int var1) {
      return this.m_6ff347e5().get(var1);
   }

   @Override
   public int size() {
      return this.m_6ff347e5().size();
   }

   public C0208<T> m_bb9d1924(Comparator<T> var1) {
      this.f_15085994 = var1;
      return this;
   }
}
