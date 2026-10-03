package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class C0224 extends C0148 implements C0230 {
   private static final Map<UUID, C0224> f_a517e9a8 = new ConcurrentHashMap<>();
   private static final String f_1676deac = C0252.bootstrap<"get",17179869278>();
   private BufferedImage f_100b667a;

   public static C0224 m_bf542020(UUID var0) {
      return f_a517e9a8.computeIfAbsent(var0, C0224::new);
   }

   public C0224(UUID var1) {
      super(C0252.bootstrap<"get",17179869278>() + var1);
   }

   private JsonObject m_55829f87(InputStream var1) throws IOException {
      JsonObject var9;
      try (InputStreamReader var2 = new InputStreamReader(var1, StandardCharsets.UTF_8)) {
         JsonObject var4 = (JsonObject)new Gson().fromJson(var2, JsonObject.class);
         Iterator var5 = var4.getAsJsonArray(C0252.bootstrap<"get",17179869279>()).iterator();

         JsonObject var7;
         do {
            if (!var5.hasNext()) {
               throw new IOException(C0252.bootstrap<"get",17179869280>());
            }

            JsonElement var6 = (JsonElement)var5.next();
            var7 = var6.getAsJsonObject();
         } while (!var7.get(C0252.bootstrap<"get",12884901951>()).getAsString().equalsIgnoreCase(C0252.bootstrap<"get",4294967323>()));

         String var8 = new String(C0114.bootstrap<"call",0,1>().decode(var7.get(C0252.bootstrap<"get",12884901913>()).getAsString()));
         var9 = (JsonObject)new Gson().fromJson(var8, JsonObject.class);
      }

      return var9;
   }

   protected BufferedImage m_48f41bcb(InputStream var1) throws IOException {
      JsonObject var2 = this.m_55829f87(var1).getAsJsonObject(C0252.bootstrap<"get",4294967323>()).getAsJsonObject(C0252.bootstrap<"get",17179869281>());
      String var3 = var2.get(C0252.bootstrap<"get",8589934695>()).getAsString();
      this.m_8e0c0dce(var3, var1x -> {
         try {
            this.f_100b667a = super.m_6377554a(var1x);
         } catch (Exception var3x) {
            var3x.printStackTrace();
         }
      });
      return this.f_100b667a;
   }

   public void m_f3bb274c(int var1, int var2, int var3, int var4, C0230.anonymouscatch var5) {
      switch (var5) {
         case f_88d11990:
            this.m_6e6b7b51(var1, var2, var3, var4);
            break;
         case f_b4b41867:
            this.bind().draw(var1, var2, var3, var4, 24, 24, 192, 192).unbind();
            this.bind().draw(var1, var2, var3, var4, 120, 24, 192, 192).unbind();
      }
   }

   public int m_865cd48e() {
      return 0;
   }

   public int m_ec5c26e6() {
      return 0;
   }

   private void m_6e6b7b51(int var1, int var2, int var3, int var4) {
   }

   public boolean m_d737e9da(C0230.anonymouscatch var1) {
      return this.isReady();
   }
}
