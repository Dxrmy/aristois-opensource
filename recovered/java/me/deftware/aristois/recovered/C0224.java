package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class C0224 extends C0148 implements C0230 {
   private static final Map<UUID, C0224> f_4b3dc574 = new ConcurrentHashMap<>();
   private static final String f_f79ff51d = C0261.m_85cd13b4();
   private BufferedImage f_3e054af2;

   public static C0224 m_3d9368ca(UUID var0) {
      return f_4b3dc574.computeIfAbsent(var0, C0224::new);
   }

   public C0224(UUID var1) {
      super(C0261.m_85cd13b4() + var1);
   }

   private JsonObject m_988748b2(InputStream var1) throws IOException {
      JsonObject var9;
      try (InputStreamReader var2 = new InputStreamReader(var1, StandardCharsets.UTF_8)) {
         JsonObject var4 = (JsonObject)new Gson().fromJson(var2, JsonObject.class);
         Iterator var5 = var4.getAsJsonArray(C0261.m_65c7e6e6()).iterator();

         JsonObject var7;
         do {
            if (!var5.hasNext()) {
               throw new IOException(C0261.m_a19a564f());
            }

            JsonElement var6 = (JsonElement)var5.next();
            var7 = var6.getAsJsonObject();
         } while (!var7.get(C0266.m_15737526()).getAsString().equalsIgnoreCase(C0264.m_056a389d()));

         String var8 = new String(Base64.getDecoder().decode(var7.get(C0266.m_e07cee76()).getAsString()));
         var9 = (JsonObject)new Gson().fromJson(var8, JsonObject.class);
      }

      return var9;
   }

   @Override
   protected BufferedImage m_d2b23cd4(InputStream var1) throws IOException {
      JsonObject var2 = this.m_988748b2(var1).getAsJsonObject(C0264.m_056a389d()).getAsJsonObject(C0261.m_03430357());
      String var3 = var2.get(C0253.m_c04d8f6e()).getAsString();
      this.m_8b8c9021(var3, var1x -> {
         try {
            this.f_3e054af2 = super.m_d2b23cd4(var1x);
         } catch (Exception var3x) {
            var3x.printStackTrace();
         }
      });
      return this.f_3e054af2;
   }

   @Override
   public void m_d4d15bd2(int var1, int var2, int var3, int var4, C0230.anonymouscatch var5) {
      switch (var5) {
         case f_431eb11f:
            this.m_f715de73(var1, var2, var3, var4);
            break;
         case f_bce9cc23:
            this.bind().draw(var1, var2, var3, var4, 24, 24, 192, 192).unbind();
            this.bind().draw(var1, var2, var3, var4, 120, 24, 192, 192).unbind();
      }
   }

   @Override
   public int m_79bbc2da() {
      return 0;
   }

   @Override
   public int m_037208cc() {
      return 0;
   }

   private void m_f715de73(int var1, int var2, int var3, int var4) {
   }

   @Override
   public boolean m_c0b2fa8c(C0230.anonymouscatch var1) {
      return this.isReady();
   }
}
