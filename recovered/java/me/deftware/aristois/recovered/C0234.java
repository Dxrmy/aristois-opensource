package me.deftware.aristois.recovered;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import me.deftware.client.framework.helper.GlStateHelper;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0234 extends GlTexture {
   private final int f_7196521d = 32;
   private final int f_7daa99d5;
   private final int f_4fe39b32;

   public C0234(InputStream var1, int var2, int var3) throws IOException {
      super(var1);
      this.f_7daa99d5 = var2;
      this.f_4fe39b32 = var3;
   }

   public int m_a73ee2be(int var1) {
      return var1 % this.f_4fe39b32 * 32;
   }

   public int m_8cb6f232(int var1) {
      int var2 = 0;
      if (var1 > 4) {
         var2++;
      }

      if (var1 > 9) {
         var2++;
      }

      return var2 * 32;
   }

   public void m_843fa6d3(double var1, double var3, double var5, int var7, Color var8) {
      this.m_9b6362d6(var1, var3, var5, this.m_a73ee2be(var7), this.m_8cb6f232(var7), var8);
   }

   public void m_9b6362d6(double var1, double var3, double var5, int var7, int var8, Color var9) {
      double var10 = var1 / 32.0;
      GLX.INSTANCE.push();
      GLX.INSTANCE.translate(var3, var5, 1.0);
      GLX.INSTANCE.scale(var10, var10, 1.0);
      GLX.INSTANCE.color((float)var9.getRed() / 255.0F, (float)var9.getGreen() / 255.0F, (float)var9.getBlue() / 255.0F, (float)var9.getAlpha() / 255.0F);
      GlStateHelper.enableTexture2D();
      this.bind().draw(0, 0, 32, 32, var7, var8, this.getTextureWidth(), this.getTextureHeight()).unbind();
      GlStateHelper.disableTexture2D();
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      GLX.INSTANCE.pop();
   }

   public int m_5b3d3148() {
      return 32;
   }

   public int m_79bbc2da() {
      return this.f_7daa99d5;
   }

   public int m_037208cc() {
      return this.f_4fe39b32;
   }
}
