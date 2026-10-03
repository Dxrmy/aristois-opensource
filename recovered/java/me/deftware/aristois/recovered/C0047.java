package me.deftware.aristois.recovered;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map.Entry;

public class C0047 implements Runnable {
   private static final int f_d285a85b = 1;
   private static final String f_94652448 = C0252.bootstrap<"get",12884901955>();
   private static final String f_fa0dcbbe = C0252.bootstrap<"get",12884901957>();

   public C0047() {
   }

   @Override
   public void run() {
      JsonObject var1 = C0114.bootstrap<"call",0,1>().getConfig();
      if (!var1.has(C0252.bootstrap<"get",12884901955>()) || var1.get(C0252.bootstrap<"get",12884901955>()).getAsInt() != 1) {
         for (Entry var3 : var1.entrySet()) {
            if (((JsonElement)var3.getValue()).isJsonObject()) {
               this.m_d911196d(((JsonElement)var3.getValue()).getAsJsonObject());
            }
         }

         var1.addProperty(C0252.bootstrap<"get",12884901955>(), C0114.bootstrap<"call",1,1>(1));
         C0114.bootstrap<"call",0,1>().save();
      }

      if (var1.has(C0252.bootstrap<"get",12884901956>()) && !var1.has(C0252.bootstrap<"get",12884901957>())) {
         JsonArray var8 = new JsonArray();

         for (JsonElement var4 : var1.getAsJsonArray(C0252.bootstrap<"get",12884901956>())) {
            JsonObject var5 = new JsonObject();

            for (Entry var7 : var4.getAsJsonObject().entrySet()) {
               var5.add(((String)var7.getKey()).toLowerCase(), (JsonElement)var7.getValue());
            }

            var8.add(var5);
         }

         var1.remove(C0252.bootstrap<"get",12884901956>());
         var1.add(C0252.bootstrap<"get",12884901956>(), var8);
         var1.addProperty(C0252.bootstrap<"get",12884901957>(), C0114.bootstrap<"call",2,1>(true));
         C0114.bootstrap<"call",0,1>().save();
      }
   }

   private void m_d911196d(JsonObject var1) {
      if (var1.has(C0252.bootstrap<"get",12884901958>())) {
         JsonObject var2 = new JsonObject();
         var2.addProperty(C0252.bootstrap<"get",12884901959>(), C0114.bootstrap<"call",0,1>(var1.get(C0252.bootstrap<"get",12884901958>()).getAsInt()));
         var2.addProperty(C0252.bootstrap<"get",12884901960>(), C0114.bootstrap<"call",0,1>(0));
         var1.remove(C0252.bootstrap<"get",12884901958>());
         var1.add(C0252.bootstrap<"get",12884901961>(), var2);
      }
   }
}
