package me.deftware.aristois.recovered;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

public final class C0050 {
   private static final int f_17ca0ce2 = 8089;
   private static final String f_10ae0b31 = C0252.bootstrap<"get",89>();
   private static final String f_511c20a8 = C0252.bootstrap<"get",90>();
   private static final String f_287073ad = C0252.bootstrap<"get",91>();
   private String f_e46df534;
   private String f_b834b286;
   private String f_f5fa2117;
   private String f_b624d37c;
   private String f_c51c1e26;
   private String f_8daf428b;
   private String f_ef03f1c3;

   public C0050() {
   }

   public void m_65a56fc7() throws Exception {
      JsonObject var1 = new JsonObject();
      var1.addProperty(C0252.bootstrap<"get",26>(), this.f_e46df534);
      C0140 var2 = new C0139(C0252.bootstrap<"get",27>()).m_4404daa7(C0139.anonymousdefault.f_3523c07a).m_b0cb481e(var1).m_244f5552();
      if (!var2.m_9781181b()) {
         throw new Exception(C0252.bootstrap<"get",28>());
      } else {
         JsonObject var3 = var2.m_fcc066b3();
         this.f_b834b286 = var3.get(C0252.bootstrap<"get",29>()).getAsString();
         this.f_f5fa2117 = var3.get(C0252.bootstrap<"get",30>()).getAsString();
      }
   }

   public void m_846a2abd(String var1) throws Exception {
      JsonObject var2 = new JsonObject();
      var2.addProperty(C0252.bootstrap<"get",31>(), var1);
      C0140 var3 = new C0139(C0252.bootstrap<"get",27>()).m_4404daa7(C0139.anonymousdefault.f_3523c07a).m_b0cb481e(var2).m_244f5552();
      if (!var3.m_9781181b()) {
         throw new Exception(C0252.bootstrap<"get",28>());
      } else {
         JsonObject var4 = var3.m_fcc066b3();
         this.f_b834b286 = var4.get(C0252.bootstrap<"get",29>()).getAsString();
         this.f_f5fa2117 = var4.get(C0252.bootstrap<"get",30>()).getAsString();
      }
   }

   public void m_2997ae9a() throws Exception {
      JsonObject var1 = new JsonObject();
      JsonObject var2 = new JsonObject();
      var2.addProperty(C0252.bootstrap<"get",32>(), C0252.bootstrap<"get",33>());
      var2.addProperty(C0252.bootstrap<"get",34>(), C0252.bootstrap<"get",35>());
      var2.addProperty(C0252.bootstrap<"get",36>(), C0252.bootstrap<"get",37>() + this.f_b834b286);
      var1.add(C0252.bootstrap<"get",38>(), var2);
      var1.addProperty(C0252.bootstrap<"get",39>(), C0252.bootstrap<"get",40>());
      var1.addProperty(C0252.bootstrap<"get",41>(), C0252.bootstrap<"get",42>());
      C0140 var3 = new C0139(C0252.bootstrap<"get",43>())
         .m_4404daa7(C0139.anonymousdefault.f_3523c07a)
         .m_c87f5f4a(C0252.bootstrap<"get",44>(), C0139.anonymousthis.f_06ff8b73)
         .m_c87f5f4a(C0252.bootstrap<"get",45>(), C0252.bootstrap<"get",46>())
         .m_d45320a4(C0141.f_f303b426.m_137f1c2e())
         .m_b0cb481e(var1)
         .m_244f5552();
      if (!var3.m_9781181b()) {
         throw new Exception(C0252.bootstrap<"get",47>());
      } else {
         JsonObject var4 = var3.m_fcc066b3();
         this.f_b624d37c = var4.get(C0252.bootstrap<"get",48>()).getAsString();
         JsonArray var5 = var4.getAsJsonObject(C0252.bootstrap<"get",49>()).getAsJsonArray(C0252.bootstrap<"get",50>());
         this.f_c51c1e26 = var5.get(0).getAsJsonObject().get(C0252.bootstrap<"get",51>()).getAsString();
      }
   }

   public void m_00408695() throws Exception {
      JsonObject var1 = new JsonObject();
      JsonObject var2 = new JsonObject();
      var2.addProperty(C0252.bootstrap<"get",52>(), C0252.bootstrap<"get",53>());
      JsonArray var3 = new JsonArray();
      var3.add(new JsonPrimitive(this.f_b624d37c));
      var2.add(C0252.bootstrap<"get",54>(), var3);
      var1.add(C0252.bootstrap<"get",38>(), var2);
      var1.addProperty(C0252.bootstrap<"get",39>(), C0252.bootstrap<"get",55>());
      var1.addProperty(C0252.bootstrap<"get",41>(), C0252.bootstrap<"get",42>());
      C0140 var4 = new C0139(C0252.bootstrap<"get",56>())
         .m_4404daa7(C0139.anonymousdefault.f_3523c07a)
         .m_c87f5f4a(C0252.bootstrap<"get",44>(), C0139.anonymousthis.f_06ff8b73)
         .m_c87f5f4a(C0252.bootstrap<"get",45>(), C0252.bootstrap<"get",46>())
         .m_d45320a4(C0141.f_f303b426.m_137f1c2e())
         .m_b0cb481e(var1)
         .m_244f5552();
      var1 = var4.m_fcc066b3();
      if (var1.has(C0252.bootstrap<"get",57>())) {
         int var5 = var1.get(C0252.bootstrap<"get",57>()).getAsInt();
         throw new Exception(C0252.bootstrap<"get",58>() + var5 + C0252.bootstrap<"get",59>());
      } else {
         this.f_8daf428b = var1.get(C0252.bootstrap<"get",48>()).getAsString();
      }
   }

   public void m_51e0bc72() throws Exception {
      JsonObject var1 = new JsonObject();
      var1.addProperty(C0252.bootstrap<"get",60>(), C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",61>(), new Object[]{this.f_c51c1e26, this.f_8daf428b}));
      C0140 var2 = new C0139(C0252.bootstrap<"get",62>())
         .m_4404daa7(C0139.anonymousdefault.f_3523c07a)
         .m_c87f5f4a(C0252.bootstrap<"get",44>(), C0139.anonymousthis.f_06ff8b73)
         .m_c87f5f4a(C0252.bootstrap<"get",45>(), C0252.bootstrap<"get",46>())
         .m_b0cb481e(var1)
         .m_244f5552();
      if (!var2.m_9781181b()) {
         throw new Exception(C0252.bootstrap<"get",63>());
      } else {
         this.f_ef03f1c3 = var2.m_fcc066b3().get(C0252.bootstrap<"get",29>()).getAsString();
      }
   }

   public C0050.anonymouscatch[] m_d4edaf82() {
      C0140 var1 = new C0139(C0252.bootstrap<"get",64>()).m_8eb81fd3(this.f_ef03f1c3).m_244f5552();
      return (C0050.anonymouscatch[])C0140.f_37d3281f.fromJson(var1.m_fcc066b3().get(C0252.bootstrap<"get",65>()), C0050.anonymouscatch[].class);
   }

   public C0137 m_e83be9e6() throws Exception {
      C0140 var1 = new C0139(C0252.bootstrap<"get",66>()).m_8eb81fd3(this.f_ef03f1c3).m_244f5552();
      JsonObject var2 = var1.m_fcc066b3();
      if (var1.m_9781181b() && !var2.has(C0252.bootstrap<"get",67>())) {
         return (C0137)C0140.f_37d3281f.fromJson(var2, C0137.class);
      } else {
         throw new Exception(C0252.bootstrap<"get",68>());
      }
   }

   public boolean m_488b7328() throws Exception {
      try (ServerSocket var1 = new ServerSocket(8089)) {
         Socket var3 = var1.accept();

         try (
            InputStreamReader var4 = new InputStreamReader(var3.getInputStream(), StandardCharsets.UTF_8);
            OutputStreamWriter var6 = new OutputStreamWriter(var3.getOutputStream(), StandardCharsets.UTF_8);
            BufferedReader var8 = new BufferedReader(var4);
            BufferedWriter var10 = new BufferedWriter(var6);
         ) {
            for (String var12 = C0252.bootstrap<"get",69>(); !var12.isEmpty(); var12 = var8.readLine()) {
               String[] var13 = var12.split(C0252.bootstrap<"get",70>());
               if (var13[0].equals(C0252.bootstrap<"get",71>())) {
                  String[] var14 = var13[1].split(C0252.bootstrap<"get",72>())[1].split(C0252.bootstrap<"get",73>());
                  C0114.bootstrap<"call",0,1>(var14).map(var0 -> var0.split(C0252.bootstrap<"get",88>())).forEach(var1x -> {
                     if (var1x[0].equals(C0252.bootstrap<"get",87>())) {
                        this.f_e46df534 = var1x[1];
                     }
                  });
               }
            }

            String var130 = C0252.bootstrap<"get",74>();
            if (C0114.bootstrap<"call",1,1>(this.f_e46df534)) {
               var130 = C0252.bootstrap<"get",75>();
            }

            String var131 = C0252.bootstrap<"get",76>() + var130 + C0252.bootstrap<"get",77>();
            int var132 = var131.getBytes(StandardCharsets.UTF_8).length;
            var10.write(C0252.bootstrap<"get",78>());
            var10.write(C0252.bootstrap<"get",79>());
            var10.write(C0252.bootstrap<"get",80>() + var132 + C0252.bootstrap<"get",69>());
            var10.write(C0252.bootstrap<"get",81>());
            var10.write(C0252.bootstrap<"get",69>());
            var10.write(var131);
         }
      }

      return !C0114.bootstrap<"call",1,1>(this.f_e46df534);
   }

   public static String m_90e6bcdc() {
      return C0252.bootstrap<"get",82>()
         + new StringJoiner(C0252.bootstrap<"get",73>())
            .add(C0252.bootstrap<"get",83>())
            .add(C0252.bootstrap<"get",84>())
            .add(C0252.bootstrap<"get",85>())
            .add(C0252.bootstrap<"get",86>());
   }

   public String m_8ffd6531() {
      return this.f_ef03f1c3;
   }

   public String m_8fd69e27() {
      return this.f_f5fa2117;
   }

   public static class anonymouscatch {
      @SerializedName("name")
      private String f_d391b0cd;
      @SerializedName("signature")
      private String f_781ff2b4;

      public anonymouscatch() {
      }

      public String m_52ec40cd() {
         return this.f_d391b0cd;
      }

      public String m_96c7777a() {
         return this.f_781ff2b4;
      }
   }
}
