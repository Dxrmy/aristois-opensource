package me.deftware.aristois.recovered;

import java.util.Map;

public class C0057 {
   private final Map<String, Long> f_9000b6ca;

   public C0057(String var1) {
      this.f_9000b6ca = new C0214<>(Long.class, var1);
   }

   public long m_7054c744() {
      return this.f_9000b6ca.get(this.m_d32ebe65());
   }

   public boolean m_9362a920() {
      String var1 = this.m_d32ebe65();
      return var1.equals(C0256.m_818e6498()) ? false : this.f_9000b6ca.containsKey(var1);
   }

   public void m_ad6c7e6f(long var1) {
      this.f_9000b6ca.put(this.m_d32ebe65(), var1);
   }

   public int m_037208cc() {
      return this.f_9000b6ca.size();
   }

   public String m_d32ebe65() {
      return C0451.m_4521bcf9(true);
   }
}
