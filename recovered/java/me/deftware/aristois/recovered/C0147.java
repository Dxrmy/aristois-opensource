package me.deftware.aristois.recovered;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class C0147 {
   private final Map<String, Object> f_00e5526d = new HashMap<>();

   public C0147() {
   }

   public C0147 m_f33d7248(String var1, Object var2) {
      this.f_00e5526d.put(var1, var2);
      return this;
   }

   public C0147 m_4bd209fb(String var1) {
      this.f_00e5526d.remove(var1);
      return this;
   }

   public Object m_66dc1f82(String var1) {
      return this.f_00e5526d.get(var1);
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();

      for (Entry var3 : this.f_00e5526d.entrySet()) {
         var1.append(C0252.bootstrap<"get",73>()).append((String)var3.getKey()).append(C0252.bootstrap<"get",88>()).append(var3.getValue());
      }

      return var1.substring(1);
   }
}
