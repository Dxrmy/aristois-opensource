package me.deftware.aristois.recovered;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0148 extends GlTexture {
   private final String f_fd9a8249;
   protected BufferedImage f_ab5f2746;

   public C0148(String var1) {
      this.f_fd9a8249 = var1;
      this.m_1058ed9a();
   }

   public boolean isReady() {
      if (this.f_ab5f2746 != null && this.glId == 0) {
         this.init(this.f_ab5f2746, 9728);
      }

      return super.isReady();
   }

   protected BufferedImage m_d2b23cd4(InputStream var1) throws IOException {
      return ImageIO.read(var1);
   }

   protected void m_8b8c9021(String var1, Consumer<InputStream> var2) {
      try {
         URLConnection var3 = new URL(var1).openConnection();
         var3.setRequestProperty(C0264.m_bec91365(), C0139.f_a07ec47b);
         HttpURLConnection var4 = (HttpURLConnection)var3;
         var4.setDoInput(true);
         var4.setDoOutput(false);
         var4.connect();
         if (var4.getResponseCode() / 100 != 2) {
            throw new IOException(C0255.m_a19a564f() + var1);
         }

         try (InputStream var5 = var4.getInputStream()) {
            var2.accept(var5);
         }

         var4.disconnect();
      } catch (Exception var18) {
         var18.printStackTrace();
      }
   }

   private void m_1058ed9a() {
      CompletableFuture.runAsync(() -> this.m_8b8c9021(this.f_fd9a8249, var1 -> {
            try {
               this.f_ab5f2746 = this.m_d2b23cd4(var1);
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }));
   }
}
