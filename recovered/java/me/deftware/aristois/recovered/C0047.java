package me.deftware.aristois.recovered;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map.Entry;
import me.deftware.aristois.main.Main;

public class C0047 implements Runnable {
   private static final int f_da45efef = 1;
   private static final String f_8dbe2d7d = C0266.m_9d6ca6d0();
   private static final String f_ddd7dde6 = C0266.m_b0896de7();

   public C0047() {
   }

   @Override
   public void run() {
      JsonObject var1 = Main.getConfig().getConfig();
      if (!var1.has(C0266.m_9d6ca6d0()) || var1.get(C0266.m_9d6ca6d0()).getAsInt() != 1) {
         for (Entry var3 : var1.entrySet()) {
            if (((JsonElement)var3.getValue()).isJsonObject()) {
               this.m_dd3aed60(((JsonElement)var3.getValue()).getAsJsonObject());
            }
         }

         var1.addProperty(C0266.m_9d6ca6d0(), 1);
         Main.getConfig().save();
      }

      if (var1.has(C0266.m_87c16989()) && !var1.has(C0266.m_b0896de7())) {
         JsonArray var8 = new JsonArray();

         for (JsonElement var4 : var1.getAsJsonArray(C0266.m_87c16989())) {
            JsonObject var5 = new JsonObject();

            for (Entry var7 : var4.getAsJsonObject().entrySet()) {
               var5.add(((String)var7.getKey()).toLowerCase(), (JsonElement)var7.getValue());
            }

            var8.add(var5);
         }

         var1.remove(C0266.m_87c16989());
         var1.add(C0266.m_87c16989(), var8);
         var1.addProperty(C0266.m_b0896de7(), true);
         Main.getConfig().save();
      }
   }

   private void m_dd3aed60(JsonObject var1) {
      if (var1.has(C0266.m_593ecbab())) {
         JsonObject var2 = new JsonObject();
         var2.addProperty(C0266.m_17d51275(), var1.get(C0266.m_593ecbab()).getAsInt());
         var2.addProperty(C0266.m_00ba16c2(), 0);
         var1.remove(C0266.m_593ecbab());
         var1.add(C0266.m_d1f7b79f(), var2);
      }
   }
}
