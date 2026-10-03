package me.deftware.aristois.recovered;

public class C0210<T> {
   private volatile T f_f1b84fee;

   public C0210(T var1, String var2) {
      this.f_f1b84fee = (T)var1;
   }

   public boolean m_22ad6203(T var1) {
      return this.f_f1b84fee == var1;
   }

   public boolean m_efa7610e() {
      return this.f_f1b84fee == null || this.f_f1b84fee instanceof String && ((String)this.f_f1b84fee).isEmpty();
   }

   public synchronized void m_a32b61ee(T var1) {
      this.f_f1b84fee = (T)var1;
   }

   public T m_b252dc95() {
      return this.f_f1b84fee;
   }
}
