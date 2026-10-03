package me.deftware.aristois.recovered;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class C0147 {
   private final Map<String, Object> f_32cf1bfd = new HashMap<>();

   public C0147() {
   }

   public C0147 m_06d78a22(String var1, Object var2) {
      this.f_32cf1bfd.put(var1, var2);
      return this;
   }

   public C0147 m_ebfa00a2(String var1) {
      this.f_32cf1bfd.remove(var1);
      return this;
   }

   public Object m_b612bf41(String var1) {
      return this.f_32cf1bfd.get(var1);
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();

      for (Entry var3 : this.f_32cf1bfd.entrySet()) {
         var1.append(C0257.m_d1f7b79f()).append((String)var3.getKey()).append(C0257.m_0425f2ec()).append(var3.getValue());
      }

      return var1.substring(1);
   }
}
