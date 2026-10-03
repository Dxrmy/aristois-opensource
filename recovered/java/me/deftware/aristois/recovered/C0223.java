package me.deftware.aristois.recovered;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import me.deftware.client.framework.render.batching.GifRenderStack;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0223 {
   public static final C0223 f_7c6d0315 = new C0223();
   private GlTexture f_bca93dd0;
   private GifRenderStack f_89957fbf;

   public C0223() {
   }

   public boolean m_9f85df3c(int var1, int var2) {
      if (this.f_89957fbf != null) {
         this.f_89957fbf.begin().draw(0, 0, var1, var2).end();
      } else if (this.f_bca93dd0 != null) {
         this.f_bca93dd0.bind().draw(0, 0, var1, var2);
      }

      return this.f_89957fbf != null || this.f_bca93dd0 != null;
   }

   public void m_b8fdf5b9() {
      try {
         this.f_89957fbf = null;
         this.f_bca93dd0 = null;
         File var1 = ((C0296)C0114.bootstrap<"call",0,1>(C0296.class)).m_b3cfdea7();
         if (var1.isFile() && var1.exists()) {
            String var2 = C0114.bootstrap<"call",1,1>(var1.getAbsolutePath());
            if (var2.equalsIgnoreCase(C0252.bootstrap<"get",17179869247>())) {
               if (C0241.f_7826e715) {
                  this.f_89957fbf = C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(new FileInputStream(var1)));
                  if (this.f_89957fbf != null) {
                     return;
                  }
               }
            } else if (var2.matches(C0252.bootstrap<"get",17179869248>())) {
               this.f_bca93dd0 = this.m_074c8a2f(var1);
               if (this.f_bca93dd0 != null) {
                  return;
               }
            }
         }

         this.f_89957fbf = this.m_d8291589();
      } catch (Throwable var3) {
         throw var3;
      }
   }

   private GlTexture m_074c8a2f(File var1) {
      try {
         return new GlTexture(var1);
      } catch (Exception var3) {
         var3.printStackTrace();
         return null;
      }
   }

   private GifRenderStack m_d8291589() throws Exception {
      return C0114.bootstrap<"call",4,1>(
         C0114.bootstrap<"call",3,1>(
            C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(), C0252.bootstrap<"get",17179869249>()))
         )
      );
   }

   public static GifRenderStack m_b001aa46(C0211.anonymoustransient var0) {
      try {
         GifRenderStack var1 = new GifRenderStack(var0);
         if (!var1.isAvailable()) {
            throw new IOException(C0252.bootstrap<"get",17179869250>());
         } else {
            return var1;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public GlTexture m_11f01c95() {
      return this.f_bca93dd0;
   }

   public GifRenderStack m_6bad9734() {
      return this.f_89957fbf;
   }
}
