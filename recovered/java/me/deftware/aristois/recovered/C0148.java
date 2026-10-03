package me.deftware.aristois.recovered;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.function.Consumer;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0148 extends GlTexture {
   private final String f_7c8f58bd;
   protected BufferedImage f_80608b4c;

   public C0148(String var1) {
      this.f_7c8f58bd = var1;
      this.m_ce97ec73();
   }

   public boolean isReady() {
      if (this.f_80608b4c != null && this.glId == 0) {
         this.init(this.f_80608b4c, 9728);
      }

      return super.isReady();
   }

   protected BufferedImage m_6377554a(InputStream var1) throws IOException {
      return C0114.bootstrap<"call",0,1>(var1);
   }

   protected void m_30fe63a0(String var1, Consumer<InputStream> var2) {
      try {
         URLConnection var3 = new URL(var1).openConnection();
         var3.setRequestProperty(C0252.bootstrap<"get",4294967318>(), C0139.f_be33f283);
         HttpURLConnection var4 = (HttpURLConnection)var3;
         var4.setDoInput(true);
         var4.setDoOutput(false);
         var4.connect();
         if (var4.getResponseCode() / 100 != 2) {
            throw new IOException(C0252.bootstrap<"get",51539607648>() + var1);
         }

         try (InputStream var5 = var4.getInputStream()) {
            var2.accept(var5);
         }

         var4.disconnect();
      } catch (Exception var18) {
         var18.printStackTrace();
      }
   }

   private void m_ce97ec73() {
      C0114.bootstrap<"call",0,1>(() -> this.m_30fe63a0(this.f_7c8f58bd, var1 -> {
            try {
               this.f_80608b4c = this.m_6377554a(var1);
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }));
   }
}
