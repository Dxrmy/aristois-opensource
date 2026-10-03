package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import me.deftware.client.framework.cosmetics.CosmeticProvider;
import me.deftware.client.framework.cosmetics.PlayerTexture;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.HashUtils;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0135 implements CosmeticProvider {
   private static final Path f_b754e7dd = Paths.get(
      Minecraft.getMinecraftGame()._getGameDir().getAbsolutePath(), C0264.m_2e834348(), C0264.m_e07cee76(), C0264.m_7b0db73e()
   );
   private static final Path f_5aa472f2 = f_b754e7dd.resolve(C0264.m_056a389d());
   private final ExecutorService f_995ea4e2 = Executors.newFixedThreadPool(4);
   private final Map<String, C0135.anonymousthis> f_d45f26d8 = new HashMap<>();
   private final Map<UUID, PlayerTexture> f_528afb9d = new HashMap<>();

   public C0135() {
      CompletableFuture.runAsync(() -> {
         try {
            this.m_1058ed9a();
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      });
   }

   private void m_1058ed9a() throws IOException {
      URL var1 = new URL(C0264.m_d597c122());
      HttpURLConnection var2 = (HttpURLConnection)var1.openConnection();
      var2.setConnectTimeout(5000);
      var2.setReadTimeout(5000);

      try (
         InputStream var3 = var2.getInputStream();
         InputStreamReader var5 = new InputStreamReader(var3);
      ) {
         C0135.anonymousthis[] var7 = (C0135.anonymousthis[])new Gson().fromJson(var5, C0135.anonymousthis[].class);

         for (C0135.anonymousthis var11 : var7) {
            this.f_d45f26d8.put(var11.f_efa1be1b, var11);
         }
      } finally {
         var2.disconnect();
      }
   }

   public void load(UUID var1, Runnable var2) {
      try {
         String var3 = HashUtils.getSHA(var1.toString().replace(C0264.m_18204724(), "")).toLowerCase();
         C0135.anonymousthis var4 = this.f_d45f26d8.get(var3);
         if (var4 != null && var4.f_77baca3c.contains(C0264.m_cf4f91f1())) {
            Path var5 = f_5aa472f2.resolve(var3 + C0264.m_b251ca51());
            MinecraftIdentifier var6 = new MinecraftIdentifier(C0264.m_cf4f91f1(), var1.toString());
            long var7 = var4.f_d014ba6c.getTime();
            if (Files.exists(var5)) {
               FileTime var9 = Files.getLastModifiedTime(var5);
               if (var7 == var9.toMillis()) {
                  PlayerTexture.load(var6, var5.toFile());
                  this.m_6aeff332(var1, var6);
                  var2.run();
               }
            }

            URL var11 = new URL(C0264.m_b48a8bc4() + var1 + C0264.m_b886ae1c());
            this.f_995ea4e2.submit(() -> {
               HttpURLConnection var8 = null;

               try {
                  var8 = (HttpURLConnection)var11.openConnection();
                  var8.setConnectTimeout(2000);
                  var8.setReadTimeout(2000);
                  var8.setRequestProperty(C0264.m_bec91365(), C0139.f_a07ec47b);
                  if (var8.getResponseCode() != 200) {
                     throw new IOException(C0264.m_79bfaec2());
                  }

                  try (InputStream var9x = var8.getInputStream()) {
                     Files.copy(var9x, var5, StandardCopyOption.REPLACE_EXISTING);
                     FileTime var11x = FileTime.fromMillis(var7);
                     Files.setLastModifiedTime(var5, var11x);
                  }

                  Minecraft.getMinecraftGame().runOnRenderThread(() -> {
                     PlayerTexture.load(var6, var5.toFile());
                     this.m_6aeff332(var1, var6);
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

   private void m_6aeff332(UUID var1, MinecraftIdentifier var2) {
      this.f_528afb9d.putIfAbsent(var1, () -> var2);
   }

   public PlayerTexture getPlayerTexture(UUID var1) {
      return this.f_528afb9d.get(var1);
   }

   static {
      Arrays.asList(f_b754e7dd, f_5aa472f2).forEach(var0 -> {
         if (!Files.exists(var0)) {
            try {
               Files.createDirectories(var0);
            } catch (IOException var2) {
               var2.printStackTrace();
            }
         }
      });
   }

   private static class anonymousthis {
      @SerializedName("id")
      private String f_efa1be1b;
      @SerializedName("types")
      private List<String> f_77baca3c;
      @SerializedName("mutated")
      private Date f_d014ba6c;

      private anonymousthis() {
      }
   }
}
