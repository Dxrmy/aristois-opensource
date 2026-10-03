package me.deftware.aristois.recovered;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class C0103<T> implements C0105<T> {
   private final Supplier<T> f_3736c3b5;
   private final Consumer<T> f_73a0815a;
   private boolean f_1785ea47 = false;

   public T m_bda6096a() {
      return this.f_3736c3b5.get();
   }

   public void m_cc6fb0e3(Object var1) {
      if (!var1.equals(this.m_bda6096a())) {
         this.f_73a0815a.accept((T)var1);
      }
   }

   public boolean m_09501248() {
      return this.f_1785ea47;
   }

   public C0103<T> m_d66ab8dc() {
      this.f_1785ea47 = true;
      return this;
   }

   public C0103<T> m_7c5d8048(boolean var1) {
      this.m_cc6fb0e3(C0114.bootstrap<"call",0,1>(var1));
      return this.m_d66ab8dc();
   }

   public C0103(Supplier<T> var1, Consumer<T> var2) {
      this.f_3736c3b5 = var1;
      this.f_73a0815a = var2;
   }

   public void m_8548b9f2(boolean var1) {
      this.f_1785ea47 = var1;
   }
}
