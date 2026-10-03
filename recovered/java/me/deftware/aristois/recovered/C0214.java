package me.deftware.aristois.recovered;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import me.deftware.aristois.main.Main;

public class C0214<V> extends AbstractMap<String, V> {
   private final Map<String, V> f_97c44514 = new HashMap<>();
   private final String f_b6de0128;
   private boolean f_1c76fdd6 = true;
   private final C0125 f_4ab7df6a;
   private final Class<V> f_366ff155;

   public C0214(Class<V> var1, String var2) {
      this.f_366ff155 = var1;
      this.f_b6de0128 = var2;
      this.f_4ab7df6a = C0125.f_94eb86f7;
      if (!var2.isEmpty()) {
         this.m_54e5cf27();
      }

      if (this.f_1c76fdd6) {
         Main.getConfig().getShutdownQueue().add(this::m_4ab806e1);
      }
   }

   public V m_163954c0(String var1, V var2) {
      var2 = this.f_97c44514.put(var1, (V)var2);
      if (this.f_1c76fdd6) {
         this.m_4ab806e1();
      }

      return (V)var2;
   }

   @Override
   public V remove(Object var1) {
      Object var2 = this.f_97c44514.remove(var1);
      if (this.f_1c76fdd6) {
         this.m_4ab806e1();
      }

      return (V)var2;
   }

   @Override
   public Set<Entry<String, V>> entrySet() {
      return this.f_97c44514.entrySet();
   }

   public JsonObject m_f7ec0040() {
      JsonObject var1 = new JsonObject();
      this.f_97c44514.forEach((var2, var3) -> var1.add(var2, this.f_4ab7df6a.m_a7c6d791(var3, var3.getClass())));
      return var1;
   }

   public C0214<V> m_0c22f205(JsonObject var1) {
      var1.entrySet().forEach(var1x -> {
         try {
            this.m_163954c0((String)var1x.getKey(), (V)this.f_4ab7df6a.m_b3b664ad((JsonElement)var1x.getValue(), this.m_caeff032()));
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      });
      return this;
   }

   public C0214<V> m_4ab806e1() {
      Main.getConfig().putObject(this.f_b6de0128, this.m_f7ec0040());
      Main.getConfig().save();
      return this;
   }

   public C0214<V> m_54e5cf27() {
      if (Main.getConfig().hasKey(this.f_b6de0128)) {
         this.m_0c22f205(Main.getConfig().getObject(this.f_b6de0128));
      }

      return this;
   }

   public String m_d32ebe65() {
      return this.f_b6de0128;
   }

   public boolean m_e606d819() {
      return this.f_1c76fdd6;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_1c76fdd6 = var1;
   }

   public C0125 m_b299a0a9() {
      return this.f_4ab7df6a;
   }

   public Class<V> m_caeff032() {
      return this.f_366ff155;
   }
}
