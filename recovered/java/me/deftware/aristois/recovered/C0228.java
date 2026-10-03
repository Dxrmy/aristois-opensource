package me.deftware.aristois.recovered;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0228 {
   public static final GlTexture f_50a5ed91 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869289>());
   public static final GlTexture f_13f0edde = C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",17179869290>(), 9728);
   public static final GlTexture f_920c4eab = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869291>());
   public static final GlTexture f_001fe5a0 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869292>());
   public static final GlTexture f_c8a9acfa = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869293>());
   public static final GlTexture f_70b24af3 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869294>());
   public static final GlTexture f_43ffd340 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869295>());
   public static final C0234 f_1a35892e = (C0234)C0114.bootstrap<"call",2,1>(() -> {
      try (InputStream var0 = C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(), C0252.bootstrap<"get",17179869287>())) {
         return new C0234(var0, 3, 5);
      } catch (Exception var14) {
         throw new RuntimeException(C0252.bootstrap<"get",17179869288>());
      }
   });

   public C0228() {
   }

   public static GlTexture m_fcdb3685(String var0) {
      return C0114.bootstrap<"call",0,1>(var0, 9729);
   }

   public static GlTexture m_aa2a0e1b(String var0, int var1) {
      try (InputStream var2 = C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(), var0)) {
         BufferedImage var4 = C0114.bootstrap<"call",3,1>(var2);
         return new GlTexture(var4, var1);
      } catch (Exception var18) {
         var18.printStackTrace();
         throw new RuntimeException(C0252.bootstrap<"get",17179869286>());
      }
   }

   public static class anonymouscatch<T> extends GlTexture {
      private BufferedImage f_ee1e3147;
      private Graphics2D f_2a09f06a;
      private int f_99dc02fa;
      private int f_bfc6ac56;

      public anonymouscatch(double var1, double var3) {
         this.f_99dc02fa = (int)var1;
         this.f_bfc6ac56 = (int)var3;
      }

      public void m_774394be(C0228.anonymousimplements<T> var1) {
         if (this.f_ee1e3147 == null) {
            this.f_ee1e3147 = new BufferedImage(this.f_99dc02fa, this.f_bfc6ac56, 2);
            this.f_2a09f06a = this.f_ee1e3147.createGraphics();
            this.f_2a09f06a.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            this.f_2a09f06a.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            this.f_2a09f06a.setComposite(C0114.bootstrap<"call",0,1>(2));
         }

         this.f_2a09f06a.setColor(new Color(0, 0, 0, 0));
         this.f_2a09f06a.clearRect(0, 0, this.f_ee1e3147.getWidth(), this.f_ee1e3147.getHeight());

         for (int var2 = 0; var2 < this.f_ee1e3147.getWidth(); var2++) {
            for (int var3 = 0; var3 < this.f_ee1e3147.getHeight(); var3++) {
               this.f_2a09f06a.setColor(var1.m_8e8019d8(this, (float)var2, (float)var3, (float)this.f_ee1e3147.getWidth(), (float)this.f_ee1e3147.getHeight()));
               this.f_2a09f06a.fillRect(var2, var3, var2 + 1, var3 + 1);
            }
         }

         if (this.isReady()) {
            this.bind().upload(this.f_ee1e3147);
         } else {
            this.init(this.f_ee1e3147, 9729);
         }

         this.unbind();
      }

      public void m_f7eedf56(T var1, double var2, double var4) {
      }

      public BufferedImage m_ad4c6d10() {
         return this.f_ee1e3147;
      }

      public Graphics2D m_eb5cdf98() {
         return this.f_2a09f06a;
      }

      public int m_021a72c4() {
         return this.f_99dc02fa;
      }

      public int m_4f2283cb() {
         return this.f_bfc6ac56;
      }

      public void m_b969eb6a(BufferedImage var1) {
         this.f_ee1e3147 = var1;
      }

      public void m_949ac45d(Graphics2D var1) {
         this.f_2a09f06a = var1;
      }

      public void m_9ae5d3d2(int var1) {
         this.f_99dc02fa = var1;
      }

      public void m_e07485ca(int var1) {
         this.f_bfc6ac56 = var1;
      }
   }

   @FunctionalInterface
   public interface anonymousimplements<T> {
      Color m_8e8019d8(C0228.anonymouscatch<T> var1, float var2, float var3, float var4, float var5);
   }
}
