package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import me.deftware.client.framework.cosmetics.CosmeticProvider;
import me.deftware.client.framework.cosmetics.PlayerTexture;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0135 implements CosmeticProvider {
   private static final Path f_cd8db680 = C0114.bootstrap<"call",1,1>(
      C0114.bootstrap<"call",0,1>()._getGameDir().getAbsolutePath(),
      new String[]{C0252.bootstrap<"get",4294967320>(), C0252.bootstrap<"get",4294967321>(), C0252.bootstrap<"get",4294967322>()}
   );
   private static final Path f_08eb0f76 = f_cd8db680.resolve(C0252.bootstrap<"get",4294967323>());
   private final ExecutorService f_2e0f21f2 = C0114.bootstrap<"call",0,1>(4);
   private final Map<String, C0135.anonymousthis> f_16c7345c = new HashMap<>();
   private final Map<UUID, PlayerTexture> f_72dc0c71 = new HashMap<>();

   public C0135() {
      C0114.bootstrap<"call",1,1>(() -> {
         try {
            this.m_7957aa40();
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      });
   }

   private void m_7957aa40() throws IOException {
      URL var1 = new URL(C0252.bootstrap<"get",4294967312>());
      HttpURLConnection var2 = (HttpURLConnection)var1.openConnection();
      var2.setConnectTimeout(5000);
      var2.setReadTimeout(5000);

      try (
         InputStream var3 = var2.getInputStream();
         InputStreamReader var5 = new InputStreamReader(var3);
      ) {
         C0135.anonymousthis[] var7 = (C0135.anonymousthis[])new Gson().fromJson(var5, C0135.anonymousthis[].class);

         for (C0135.anonymousthis var11 : var7) {
            this.f_16c7345c.put(C0114.bootstrap<"call",0,1>(var11), var11);
         }
      } finally {
         var2.disconnect();
      }
   }

   public void load(UUID var1, Runnable var2) {
      try {
         String var3 = C0114.bootstrap<"call",0,1>(var1.toString().replace(C0252.bootstrap<"get",4294967313>(), "")).toLowerCase();
         C0135.anonymousthis var4 = this.f_16c7345c.get(var3);
         if (var4 != null && C0114.bootstrap<"call",1,1>(var4).contains(C0252.bootstrap<"get",4294967314>())) {
            Path var5 = f_08eb0f76.resolve(var3 + C0252.bootstrap<"get",4294967315>());
            MinecraftIdentifier var6 = new MinecraftIdentifier(C0252.bootstrap<"get",4294967314>(), var1.toString());
            long var7 = C0114.bootstrap<"call",2,1>(var4).getTime();
            if (C0114.bootstrap<"call",3,1>(var5, new LinkOption[0])) {
               FileTime var9 = C0114.bootstrap<"call",4,1>(var5, new LinkOption[0]);
               if (var7 == var9.toMillis()) {
                  C0114.bootstrap<"call",5,1>(var6, var5.toFile());
                  this.m_02cc9ede(var1, var6);
                  var2.run();
               }
            }

            URL var11 = new URL(C0252.bootstrap<"get",4294967316>() + var1 + C0252.bootstrap<"get",4294967317>());
            this.f_2e0f21f2.submit(() -> {
               HttpURLConnection var8 = null;

               try {
                  var8 = (HttpURLConnection)var11.openConnection();
                  var8.setConnectTimeout(2000);
                  var8.setReadTimeout(2000);
                  var8.setRequestProperty(C0252.bootstrap<"get",4294967318>(), C0139.f_be33f283);
                  if (var8.getResponseCode() != 200) {
                     throw new IOException(C0252.bootstrap<"get",4294967319>());
                  }

                  try (InputStream var9x = var8.getInputStream()) {
                     C0114.bootstrap<"call",1,1>(var9x, var5, new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                     FileTime var11x = C0114.bootstrap<"call",2,1>(var7);
                     C0114.bootstrap<"call",3,1>(var5, var11x);
                  }

                  C0114.bootstrap<"call",4,1>().runOnRenderThread(() -> {
                     C0114.bootstrap<"call",5,1>(var6, var5.toFile());
                     this.m_02cc9ede(var1, var6);
                     var2.run();
                  });
               } catch (IOException var30) {
                  var30.printStackTrace();
               } finally {
                  if (var8 != null) {
                     var8.disconnect();
                  }
               }
            });
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }
   }

   private void m_02cc9ede(UUID var1, MinecraftIdentifier var2) {
      this.f_72dc0c71.putIfAbsent(var1, () -> var2);
   }

   public PlayerTexture getPlayerTexture(UUID var1) {
      return this.f_72dc0c71.get(var1);
   }

   static {
      C0114.bootstrap<"call",2,1>(new Path[]{f_cd8db680, f_08eb0f76}).forEach(var0 -> {
         if (!C0114.bootstrap<"call",6,1>(var0, new LinkOption[0])) {
            try {
               C0114.bootstrap<"call",7,1>(var0, new FileAttribute[0]);
            } catch (IOException var2) {
               var2.printStackTrace();
            }
         }
      });
   }

   private static class anonymousthis {
      @SerializedName("id")
      private String f_64e91569;
      @SerializedName("types")
      private List<String> f_9d984e17;
      @SerializedName("mutated")
      private Date f_e32a8436;

      private anonymousthis() {
      }
   }
}
