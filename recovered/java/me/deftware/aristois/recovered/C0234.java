package me.deftware.aristois.recovered;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0234 extends GlTexture {
   private final int f_8ea77440 = 32;
   private final int f_7a712035;
   private final int f_82c5232b;

   public C0234(InputStream var1, int var2, int var3) throws IOException {
      super(var1);
      this.f_7a712035 = var2;
      this.f_82c5232b = var3;
   }

   public int m_a41b5737(int var1) {
      return var1 % this.f_82c5232b * 32;
   }

   public int m_28584246(int var1) {
      int var2 = 0;
      if (var1 > 4) {
         var2++;
      }

      if (var1 > 9) {
         var2++;
      }

      return var2 * 32;
   }

   public void m_a4212c99(double var1, double var3, double var5, int var7, Color var8) {
      this.m_e8034329(var1, var3, var5, this.m_a41b5737(var7), this.m_28584246(var7), var8);
   }

   public void m_e8034329(double var1, double var3, double var5, int var7, int var8, Color var9) {
      double var10 = var1 / 32.0;
      GLX.INSTANCE.push();
      GLX.INSTANCE.translate(var3, var5, 1.0);
      GLX.INSTANCE.scale(var10, var10, 1.0);
      GLX.INSTANCE.color((float)var9.getRed() / 255.0F, (float)var9.getGreen() / 255.0F, (float)var9.getBlue() / 255.0F, (float)var9.getAlpha() / 255.0F);
      C0114.bootstrap<"call",0,1>();
      this.bind().draw(0, 0, 32, 32, var7, var8, this.getTextureWidth(), this.getTextureHeight()).unbind();
      C0114.bootstrap<"call",1,1>();
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      GLX.INSTANCE.pop();
   }

   public int m_5f2752be() {
      return 32;
   }

   public int m_6a61b374() {
      return this.f_7a712035;
   }

   public int m_8bfedd77() {
      return this.f_82c5232b;
   }
}
