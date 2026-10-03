package me.deftware.aristois.recovered;

public class C0210<T> {
   private volatile T f_c6798f5a;

   public C0210(T var1, String var2) {
      this.f_c6798f5a = (T)var1;
   }

   public boolean m_f49c4272(T var1) {
      return this.f_c6798f5a == var1;
   }

   public boolean m_aeff818b() {
      return this.f_c6798f5a == null || this.f_c6798f5a instanceof String && ((String)this.f_c6798f5a).isEmpty();
   }

   public synchronized void m_d97b8243(T var1) {
      this.f_c6798f5a = (T)var1;
   }

   public T m_fc9f8a69() {
      return this.f_c6798f5a;
   }
}
