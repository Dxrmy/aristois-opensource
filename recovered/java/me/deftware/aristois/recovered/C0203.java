package me.deftware.aristois.recovered;

import java.util.function.Supplier;

public final class C0203<T> {
   private T f_3eac953d;
   private final Supplier<T> f_5423f6a1;

   public C0203(Supplier<T> var1) {
      this.f_5423f6a1 = var1;
   }

   public T m_1c30b0a8() {
      if (this.f_3eac953d == null) {
         this.f_3eac953d = this.f_5423f6a1.get();
      }

      return this.f_3eac953d;
   }
}
