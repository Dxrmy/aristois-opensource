package me.deftware.aristois.recovered;

import java.util.function.Supplier;

public class C0085 implements C0084 {
   private final Supplier<Boolean> f_16d2ea7a;

   @Override
   public boolean m_efa7610e() {
      return this.f_16d2ea7a.get();
   }

   public C0085(Supplier<Boolean> var1) {
      this.f_16d2ea7a = var1;
   }
}
