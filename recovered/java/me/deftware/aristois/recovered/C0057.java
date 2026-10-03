package me.deftware.aristois.recovered;

import java.util.Map;

public class C0057 {
   private final Map<String, Long> f_e13de354;

   public C0057(String var1) {
      this.f_e13de354 = new C0214<>(Long.class, var1);
   }

   public long m_a8d71844() {
      return this.f_e13de354.get(this.m_fe543e7d());
   }

   public boolean m_7f8978b5() {
      String var1 = this.m_fe543e7d();
      return var1.equals(C0252.bootstrap<"get",55834574884>()) ? false : this.f_e13de354.containsKey(var1);
   }

   public void m_a81b189b(long var1) {
      this.f_e13de354.put(this.m_fe543e7d(), C0114.bootstrap<"call",0,1>(var1));
   }

   public int m_1ce2ca5e() {
      return this.f_e13de354.size();
   }

   public String m_fe543e7d() {
      return C0114.bootstrap<"call",0,1>(true);
   }
}
