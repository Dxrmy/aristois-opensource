package me.deftware.aristois.recovered;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class C0214<V> extends AbstractMap<String, V> {
   private final Map<String, V> f_3bb91b90 = new HashMap<>();
   private final String f_99f57bfa;
   private boolean f_629af19a = true;
   private final C0125 f_becc8aed;
   private final Class<V> f_ee40c881;

   public C0214(Class<V> var1, String var2) {
      this.f_ee40c881 = var1;
      this.f_99f57bfa = var2;
      this.f_becc8aed = C0125.f_70947d4f;
      if (!var2.isEmpty()) {
         this.m_a91b2d6a();
      }

      if (this.f_629af19a) {
         C0114.bootstrap<"call",0,1>().getShutdownQueue().add(this::m_b28c827b);
      }
   }

   public V m_245c1162(String var1, V var2) {
      var2 = this.f_3bb91b90.put(var1, (V)var2);
      if (this.f_629af19a) {
         this.m_b28c827b();
      }

      return (V)var2;
   }

   @Override
   public V remove(Object var1) {
      Object var2 = this.f_3bb91b90.remove(var1);
      if (this.f_629af19a) {
         this.m_b28c827b();
      }

      return (V)var2;
   }

   @Override
   public Set<Entry<String, V>> entrySet() {
      return this.f_3bb91b90.entrySet();
   }

   public JsonObject m_3fbaeb69() {
      JsonObject var1 = new JsonObject();
      this.f_3bb91b90.forEach((var2, var3) -> var1.add(var2, this.f_becc8aed.m_77b61bf9(var3, var3.getClass())));
      return var1;
   }

   public C0214<V> m_c8406f98(JsonObject var1) {
      var1.entrySet().forEach(var1x -> {
         try {
            this.m_245c1162((String)var1x.getKey(), (V)this.f_becc8aed.m_5f630fc1((JsonElement)var1x.getValue(), this.m_8b28e6b9()));
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      });
      return this;
   }

   public C0214<V> m_b28c827b() {
      C0114.bootstrap<"call",0,1>().putObject(this.f_99f57bfa, this.m_3fbaeb69());
      C0114.bootstrap<"call",0,1>().save();
      return this;
   }

   public C0214<V> m_a91b2d6a() {
      if (C0114.bootstrap<"call",0,1>().hasKey(this.f_99f57bfa)) {
         this.m_c8406f98(C0114.bootstrap<"call",0,1>().getObject(this.f_99f57bfa));
      }

      return this;
   }

   public String m_e430d2ab() {
      return this.f_99f57bfa;
   }

   public boolean m_24ef4b31() {
      return this.f_629af19a;
   }

   public void m_b0acfee5(boolean var1) {
      this.f_629af19a = var1;
   }

   public C0125 m_a4113686() {
      return this.f_becc8aed;
   }

   public Class<V> m_8b28e6b9() {
      return this.f_ee40c881;
   }
}
