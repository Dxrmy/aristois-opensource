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
import java.util.Arrays;
import java.util.StringJoiner;
import org.apache.commons.lang3.StringUtils;

public final class C0050 {
   private static final int f_fbb31558 = 8089;
   private static final String f_ffedb0b7 = C0257.m_1b17f04f();
   private static final String f_916384f0 = C0257.m_bcef2112();
   private static final String f_5d4e95a5 = C0257.m_114677c2();
   private String f_c211a673;
   private String f_d5616804;
   private String f_4c3fd157;
   private String f_93fbf271;
   private String f_b2345815;
   private String f_54edf466;
   private String f_823ccaf7;

   public C0050() {
   }

   public void m_1058ed9a() throws Exception {
      JsonObject var1 = new JsonObject();
      var1.addProperty(C0257.m_7b0db73e(), this.f_c211a673);
      C0140 var2 = new C0139(C0257.m_056a389d()).m_5bfd94bd(C0139.anonymousdefault.f_3ced4cdc).m_6e76d0fa(var1).m_0017133f();
      if (!var2.m_9362a920()) {
         throw new Exception(C0257.m_5fa6dd07());
      } else {
         JsonObject var3 = var2.m_f7ec0040();
         this.f_d5616804 = var3.get(C0257.m_5f1ab561()).getAsString();
         this.f_4c3fd157 = var3.get(C0257.m_28b2c020()).getAsString();
      }
   }

   public void m_256015fc(String var1) throws Exception {
      JsonObject var2 = new JsonObject();
      var2.addProperty(C0257.m_45aaaba8(), var1);
      C0140 var3 = new C0139(C0257.m_056a389d()).m_5bfd94bd(C0139.anonymousdefault.f_3ced4cdc).m_6e76d0fa(var2).m_0017133f();
      if (!var3.m_9362a920()) {
         throw new Exception(C0257.m_5fa6dd07());
      } else {
         JsonObject var4 = var3.m_f7ec0040();
         this.f_d5616804 = var4.get(C0257.m_5f1ab561()).getAsString();
         this.f_4c3fd157 = var4.get(C0257.m_28b2c020()).getAsString();
      }
   }

   public void m_b728afce() throws Exception {
      JsonObject var1 = new JsonObject();
      JsonObject var2 = new JsonObject();
      var2.addProperty(C0257.m_88937f2b(), C0257.m_396f9431());
      var2.addProperty(C0257.m_e9914bd3(), C0257.m_8631f87f());
      var2.addProperty(C0257.m_818e6498(), C0257.m_56d4c1c7() + this.f_d5616804);
      var1.add(C0257.m_d32ebe65(), var2);
      var1.addProperty(C0257.m_afb31f66(), C0257.m_c254a253());
      var1.addProperty(C0257.m_3d3a8736(), C0257.m_94acbdac());
      C0140 var3 = new C0139(C0257.m_022da1b4())
         .m_5bfd94bd(C0139.anonymousdefault.f_3ced4cdc)
         .m_de53cd30(C0257.m_6e2d03c3(), C0139.anonymousthis.f_a9e237e2)
         .m_de53cd30(C0257.m_760db7bb(), C0257.m_68957b31())
         .m_27e42f5e(C0141.f_afca7f52.m_f40cad62())
         .m_6e76d0fa(var1)
         .m_0017133f();
      if (!var3.m_9362a920()) {
         throw new Exception(C0257.m_4e02e7a9());
      } else {
         JsonObject var4 = var3.m_f7ec0040();
         this.f_93fbf271 = var4.get(C0257.m_7f74d855()).getAsString();
         JsonArray var5 = var4.getAsJsonObject(C0257.m_b89b7876()).getAsJsonArray(C0257.m_a33fab52());
         this.f_b2345815 = var5.get(0).getAsJsonObject().get(C0257.m_73708dd3()).getAsString();
      }
   }

   public void m_0e265701() throws Exception {
      JsonObject var1 = new JsonObject();
      JsonObject var2 = new JsonObject();
      var2.addProperty(C0257.m_96ba50d4(), C0257.m_88726494());
      JsonArray var3 = new JsonArray();
      var3.add(new JsonPrimitive(this.f_93fbf271));
      var2.add(C0257.m_27479cfa(), var3);
      var1.add(C0257.m_d32ebe65(), var2);
      var1.addProperty(C0257.m_afb31f66(), C0257.m_23f794da());
      var1.addProperty(C0257.m_3d3a8736(), C0257.m_94acbdac());
      C0140 var4 = new C0139(C0257.m_cc27b633())
         .m_5bfd94bd(C0139.anonymousdefault.f_3ced4cdc)
         .m_de53cd30(C0257.m_6e2d03c3(), C0139.anonymousthis.f_a9e237e2)
         .m_de53cd30(C0257.m_760db7bb(), C0257.m_68957b31())
         .m_27e42f5e(C0141.f_afca7f52.m_f40cad62())
         .m_6e76d0fa(var1)
         .m_0017133f();
      var1 = var4.m_f7ec0040();
      if (var1.has(C0257.m_df6e621c())) {
         int var5 = var1.get(C0257.m_df6e621c()).getAsInt();
         throw new Exception(C0257.m_56242a84() + var5 + C0257.m_9e27f038());
      } else {
         this.f_54edf466 = var1.get(C0257.m_7f74d855()).getAsString();
      }
   }

   public void m_41e83f88() throws Exception {
      JsonObject var1 = new JsonObject();
      var1.addProperty(C0257.m_af41331f(), String.format(C0257.m_f257bcca(), this.f_b2345815, this.f_54edf466));
      C0140 var2 = new C0139(C0257.m_d9b37a36())
         .m_5bfd94bd(C0139.anonymousdefault.f_3ced4cdc)
         .m_de53cd30(C0257.m_6e2d03c3(), C0139.anonymousthis.f_a9e237e2)
         .m_de53cd30(C0257.m_760db7bb(), C0257.m_68957b31())
         .m_6e76d0fa(var1)
         .m_0017133f();
      if (!var2.m_9362a920()) {
         throw new Exception(C0257.m_15737526());
      } else {
         this.f_823ccaf7 = var2.m_f7ec0040().get(C0257.m_5f1ab561()).getAsString();
      }
   }

   public C0050.anonymouscatch[] m_52da0a42() {
      C0140 var1 = new C0139(C0257.m_6cf615ba()).m_c17d7df0(this.f_823ccaf7).m_0017133f();
      return (C0050.anonymouscatch[])C0140.f_ff6bbba6.fromJson(var1.m_f7ec0040().get(C0257.m_ecb46027()), C0050.anonymouscatch[].class);
   }

   public C0137 m_035881b0() throws Exception {
      C0140 var1 = new C0139(C0257.m_b526dd3b()).m_c17d7df0(this.f_823ccaf7).m_0017133f();
      JsonObject var2 = var1.m_f7ec0040();
      if (var1.m_9362a920() && !var2.has(C0257.m_9d6ca6d0())) {
         return (C0137)C0140.f_ff6bbba6.fromJson(var2, C0137.class);
      } else {
         throw new Exception(C0257.m_87c16989());
      }
   }

   public boolean m_297cfef6() throws Exception {
      try (ServerSocket var1 = new ServerSocket(8089)) {
         Socket var3 = var1.accept();

         try (
            InputStreamReader var4 = new InputStreamReader(var3.getInputStream(), StandardCharsets.UTF_8);
            OutputStreamWriter var6 = new OutputStreamWriter(var3.getOutputStream(), StandardCharsets.UTF_8);
            BufferedReader var8 = new BufferedReader(var4);
            BufferedWriter var10 = new BufferedWriter(var6);
         ) {
            for (String var12 = C0257.m_b0896de7(); !var12.isEmpty(); var12 = var8.readLine()) {
               String[] var13 = var12.split(C0257.m_593ecbab());
               if (var13[0].equals(C0257.m_17d51275())) {
                  String[] var14 = var13[1].split(C0257.m_00ba16c2())[1].split(C0257.m_d1f7b79f());
                  Arrays.stream(var14).map(var0 -> var0.split(C0257.m_0425f2ec())).forEach(var1x -> {
                     if (var1x[0].equals(C0257.m_d0da63e8())) {
                        this.f_c211a673 = var1x[1];
                     }
                  });
               }
            }

            String var130 = C0257.m_a29090eb();
            if (StringUtils.isEmpty(this.f_c211a673)) {
               var130 = C0257.m_b2dd5137();
            }

            String var131 = C0257.m_91e95cb4() + var130 + C0257.m_1616e137();
            int var132 = var131.getBytes(StandardCharsets.UTF_8).length;
            var10.write(C0257.m_6dc2a812());
            var10.write(C0257.m_e7934778());
            var10.write(C0257.m_d0e43f69() + var132 + C0257.m_b0896de7());
            var10.write(C0257.m_812ab029());
            var10.write(C0257.m_b0896de7());
            var10.write(var131);
         }
      }

      return !StringUtils.isEmpty(this.f_c211a673);
   }

   public static String m_c688f8ca() {
      return C0257.m_11f0c704()
         + new StringJoiner(C0257.m_d1f7b79f()).add(C0257.m_19faa493()).add(C0257.m_a55b07ff()).add(C0257.m_16315846()).add(C0257.m_e8fd0250());
   }

   public String m_c42f1c7e() {
      return this.f_823ccaf7;
   }

   public String m_e9914bd3() {
      return this.f_4c3fd157;
   }

   public static class anonymouscatch {
      @SerializedName("name")
      private String f_4800c1da;
      @SerializedName("signature")
      private String f_ce60dbec;

      public anonymouscatch() {
      }

      public String m_8d7dbe31() {
         return this.f_4800c1da;
      }

      public String m_3d3a8736() {
         return this.f_ce60dbec;
      }
   }
}
