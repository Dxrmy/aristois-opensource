package me.deftware.aristois.recovered;

import com.google.common.io.ByteStreams;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.render.batching.GifRenderStack;
import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.ResourceUtils;
import org.apache.commons.io.FilenameUtils;

public class C0223 {
   public static final C0223 f_a04019fa = new C0223();
   private GlTexture f_30ab54f8;
   private GifRenderStack f_6c49ea43;

   public C0223() {
   }

   public boolean m_d7db8b4a(int var1, int var2) {
      if (this.f_6c49ea43 != null) {
         this.f_6c49ea43.begin().draw(0, 0, var1, var2).end();
      } else if (this.f_30ab54f8 != null) {
         this.f_30ab54f8.bind().draw(0, 0, var1, var2);
      }

      return this.f_6c49ea43 != null || this.f_30ab54f8 != null;
   }

   public void m_1058ed9a() {
      try {
         this.f_6c49ea43 = null;
         this.f_30ab54f8 = null;
         File var1 = C0289.m_c3a8b502(C0296.class).m_4e58adf5();
         if (var1.isFile() && var1.exists()) {
            String var2 = FilenameUtils.getExtension(var1.getAbsolutePath());
            if (var2.equalsIgnoreCase(C0261.m_15737526())) {
               if (C0241.f_f6e3d33b) {
                  this.f_6c49ea43 = m_4a3d94d2(C0211.m_4ad97825(new FileInputStream(var1)));
                  if (this.f_6c49ea43 != null) {
                     return;
                  }
               }
            } else if (var2.matches(C0261.m_6cf615ba())) {
               this.f_30ab54f8 = this.m_4ed9a35e(var1);
               if (this.f_30ab54f8 != null) {
                  return;
               }
            }
         }

         this.f_6c49ea43 = this.m_d81de86f();
      } catch (Throwable var3) {
         throw var3;
      }
   }

   private GlTexture m_4ed9a35e(File var1) {
      try {
         return new GlTexture(var1);
      } catch (Exception var3) {
         var3.printStackTrace();
         return null;
      }
   }

   private GifRenderStack m_d81de86f() throws Exception {
      return m_4a3d94d2(C0211.m_5e01be8d(ByteStreams.toByteArray(ResourceUtils.getStreamFromModResources(Main.getInstance(), C0261.m_ecb46027()))));
   }

   public static GifRenderStack m_4a3d94d2(C0211.anonymoustransient var0) {
      try {
         GifRenderStack var1 = new GifRenderStack(var0);
         if (!var1.isAvailable()) {
            throw new IOException(C0261.m_b526dd3b());
         } else {
            return var1;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public GlTexture m_c9334066() {
      return this.f_30ab54f8;
   }

   public GifRenderStack m_fc32fd6d() {
      return this.f_6c49ea43;
   }
}
