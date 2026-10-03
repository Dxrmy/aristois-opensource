package me.deftware.aristois.recovered;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class C0048 {
   private static final String f_fdfb1742 = C0266.m_a29090eb();

   public C0048() {
   }

   public void m_1058ed9a() throws Exception {
      C0089 var1 = new C0089();
      if (!var1.m_828a75ae(C0266.m_a29090eb())) {
         System.out.println(C0266.m_b2dd5137());
         var1.m_f7ec0040().addProperty(C0266.m_91e95cb4(), C0266.m_1616e137());
         var1.m_e5f08f7c(C0266.m_a29090eb(), C0266.m_6dc2a812());
         JsonElement var2 = null;

         for (JsonElement var4 : var1.m_e40a2c80()) {
            JsonObject var5 = var4.getAsJsonObject();
            String var6 = var5.get(C0266.m_15737526()).getAsString();
            if (var6.startsWith(C0266.m_e7934778())) {
               var6 = var6.replace(C0266.m_d0e43f69(), C0266.m_812ab029());
               var5.addProperty(C0266.m_15737526(), var6);
            } else if (var6.startsWith(C0266.m_11f0c704())) {
               var6 = C0266.m_19faa493();
               var5.addProperty(C0266.m_15737526(), var6);
            } else if (var6.startsWith(C0266.m_a55b07ff())) {
               var6 = C0266.m_16315846();
               var5.addProperty(C0266.m_15737526(), var6);
            } else if (var6.startsWith(C0266.m_e8fd0250())) {
               var6 = C0266.m_d0da63e8();
               var5.addProperty(C0266.m_15737526(), var6);
            } else if (var6.contains(C0266.m_0425f2ec())) {
               var2 = var4;
            }
         }

         if (var2 != null) {
            var1.m_e40a2c80().remove(var2);
         }

         var1.m_0e265701();
      }
   }
}
