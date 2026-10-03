package me.deftware.aristois.recovered;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.ResourceUtils;

public class C0228 {
   public static final GlTexture f_72c39893 = m_dd866dd6(C0261.m_4cbaf16f());
   public static final GlTexture f_7bf45835 = m_5e5c423d(C0261.m_678c4ddb(), 9728);
   public static final GlTexture f_3c443669 = m_dd866dd6(C0261.m_1672ac4d());
   public static final GlTexture f_15fce25d = m_dd866dd6(C0261.m_e9a52709());
   public static final GlTexture f_f4f5578f = m_dd866dd6(C0261.m_37c08c9d());
   public static final GlTexture f_fb45c3fb = m_dd866dd6(C0261.m_1472ab32());
   public static final GlTexture f_0f76d8d5 = m_dd866dd6(C0261.m_a5b24d28());
   public static final C0234 f_12b529e0 = C0217.m_924c66cb(() -> {
      try (InputStream var0 = ResourceUtils.getStreamFromModResources(Main.getInstance(), C0261.m_c04d8f6e())) {
         return new C0234(var0, 3, 5);
      } catch (Exception var14) {
         throw new RuntimeException(C0261.m_2dc36b02());
      }
   });

   public C0228() {
   }

   public static GlTexture m_dd866dd6(String var0) {
      return m_5e5c423d(var0, 9729);
   }

   public static GlTexture m_5e5c423d(String var0, int var1) {
      try (InputStream var2 = ResourceUtils.getStreamFromModResources(Main.getInstance(), var0)) {
         BufferedImage var4 = ImageIO.read(var2);
         return new GlTexture(var4, var1);
      } catch (Exception var18) {
         var18.printStackTrace();
         throw new RuntimeException(C0261.m_bdbd5e40());
      }
   }

   public static class anonymouscatch<T> extends GlTexture {
      private BufferedImage f_9b6326c4;
      private Graphics2D f_07ad935d;
      private int f_bb34034b;
      private int f_aeb28858;

      public anonymouscatch(double var1, double var3) {
         this.f_bb34034b = (int)var1;
         this.f_aeb28858 = (int)var3;
      }

      public void m_009d0825(C0228.anonymousimplements<T> var1) {
         if (this.f_9b6326c4 == null) {
            this.f_9b6326c4 = new BufferedImage(this.f_bb34034b, this.f_aeb28858, 2);
            this.f_07ad935d = this.f_9b6326c4.createGraphics();
            this.f_07ad935d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            this.f_07ad935d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            this.f_07ad935d.setComposite(AlphaComposite.getInstance(2));
         }

         this.f_07ad935d.setColor(new Color(0, 0, 0, 0));
         this.f_07ad935d.clearRect(0, 0, this.f_9b6326c4.getWidth(), this.f_9b6326c4.getHeight());

         for (int var2 = 0; var2 < this.f_9b6326c4.getWidth(); var2++) {
            for (int var3 = 0; var3 < this.f_9b6326c4.getHeight(); var3++) {
               this.f_07ad935d.setColor(var1.m_ea174c21(this, (float)var2, (float)var3, (float)this.f_9b6326c4.getWidth(), (float)this.f_9b6326c4.getHeight()));
               this.f_07ad935d.fillRect(var2, var3, var2 + 1, var3 + 1);
            }
         }

         if (this.isReady()) {
            this.bind().upload(this.f_9b6326c4);
         } else {
            this.init(this.f_9b6326c4, 9729);
         }

         this.unbind();
      }

      public void m_09d6907b(T var1, double var2, double var4) {
      }

      public BufferedImage m_b02459d8() {
         return this.f_9b6326c4;
      }

      public Graphics2D m_18a5b1ca() {
         return this.f_07ad935d;
      }

      public int m_037208cc() {
         return this.f_bb34034b;
      }

      public int m_36ffc578() {
         return this.f_aeb28858;
      }

      public void m_c1c6a923(BufferedImage var1) {
         this.f_9b6326c4 = var1;
      }

      public void m_91002bcd(Graphics2D var1) {
         this.f_07ad935d = var1;
      }

      public void m_46938bdb(int var1) {
         this.f_bb34034b = var1;
      }

      public void m_7c7fe86a(int var1) {
         this.f_aeb28858 = var1;
      }
   }

   @FunctionalInterface
   public interface anonymousimplements<T> {
      Color m_ea174c21(C0228.anonymouscatch<T> var1, float var2, float var3, float var4, float var5);
   }
}
