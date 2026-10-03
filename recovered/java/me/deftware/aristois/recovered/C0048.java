package me.deftware.aristois.recovered;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class C0048 {
   private static final String f_ffe91d32 = C0252.bootstrap<"get",12884901962>();

   public C0048() {
   }

   public void m_2977064b() throws Exception {
      C0089 var1 = new C0089();
      if (!var1.m_2d04db88(C0252.bootstrap<"get",12884901962>())) {
         System.out.println(C0252.bootstrap<"get",12884901963>());
         var1.m_3b67f137().addProperty(C0252.bootstrap<"get",12884901964>(), C0252.bootstrap<"get",12884901965>());
         var1.m_c6a6bad9(C0252.bootstrap<"get",12884901962>(), C0252.bootstrap<"get",12884901966>());
         JsonElement var2 = null;

         for (JsonElement var4 : var1.m_f452fb43()) {
            JsonObject var5 = var4.getAsJsonObject();
            String var6 = var5.get(C0252.bootstrap<"get",12884901951>()).getAsString();
            if (var6.startsWith(C0252.bootstrap<"get",12884901967>())) {
               var6 = var6.replace(C0252.bootstrap<"get",12884901968>(), C0252.bootstrap<"get",12884901969>());
               var5.addProperty(C0252.bootstrap<"get",12884901951>(), var6);
            } else if (var6.startsWith(C0252.bootstrap<"get",12884901970>())) {
               var6 = C0252.bootstrap<"get",12884901971>();
               var5.addProperty(C0252.bootstrap<"get",12884901951>(), var6);
            } else if (var6.startsWith(C0252.bootstrap<"get",12884901972>())) {
               var6 = C0252.bootstrap<"get",12884901973>();
               var5.addProperty(C0252.bootstrap<"get",12884901951>(), var6);
            } else if (var6.startsWith(C0252.bootstrap<"get",12884901974>())) {
               var6 = C0252.bootstrap<"get",12884901975>();
               var5.addProperty(C0252.bootstrap<"get",12884901951>(), var6);
            } else if (var6.contains(C0252.bootstrap<"get",12884901976>())) {
               var2 = var4;
            }
         }

         if (var2 != null) {
            var1.m_f452fb43().remove(var2);
         }

         var1.m_71d0d167();
      }
   }
}
