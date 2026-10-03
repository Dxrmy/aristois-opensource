package me.deftware.aristois.recovered;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class C0103<T> implements C0105<T> {
   private final Supplier<T> f_f95d8324;
   private final Consumer<T> f_8a3b0555;
   private boolean f_996431d4 = false;

   @Override
   public T m_50ca8f08() {
      return this.f_f95d8324.get();
   }

   @Override
   public void m_a32b61ee(Object var1) {
      if (!var1.equals(this.m_50ca8f08())) {
         this.f_8a3b0555.accept((T)var1);
      }
   }

   @Override
   public boolean m_e0f7c666() {
      return this.f_996431d4;
   }

   public C0103<T> m_01388fcf() {
      this.f_996431d4 = true;
      return this;
   }

   public C0103<T> m_34ef27b9(boolean var1) {
      this.m_a32b61ee(var1);
      return this.m_01388fcf();
   }

   public C0103(Supplier<T> var1, Consumer<T> var2) {
      this.f_f95d8324 = var1;
      this.f_8a3b0555 = var2;
   }

   public void m_394ecb95(boolean var1) {
      this.f_996431d4 = var1;
   }
}
