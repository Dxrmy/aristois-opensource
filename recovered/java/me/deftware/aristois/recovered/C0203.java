package me.deftware.aristois.recovered;

import java.util.function.Supplier;

public final class C0203<T> {
   private T f_68b53e72;
   private final Supplier<T> f_2645035b;

   public C0203(Supplier<T> var1) {
      this.f_2645035b = var1;
   }

   public T m_ac6eac3b() {
      if (this.f_68b53e72 == null) {
         this.f_68b53e72 = this.f_2645035b.get();
      }

      return this.f_68b53e72;
   }
}
