package me.deftware.aristois.recovered;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.render.batching.GifRenderStack.GifProvider;

public final class C0211 {
   public static final boolean f_61b5e88b = false;

   public C0211() {
   }

   public static C0211.anonymoustransient m_5e01be8d(byte[] var0) throws IOException {
      new C0211();
      C0211.anonymoustransient var2 = new C0211.anonymoustransient();
      C0211.anonymousboolean var3 = null;
      int var4 = m_29d08f48(var0, var2);
      var4 = m_f33ddcb9(var2, var0, var4);
      if (var2.f_71dc88f2) {
         var2.f_9bdc094c = new int[var2.f_5e49944d];
         var4 = m_42a8eedb(var0, var2.f_9bdc094c, var4);
      }

      while (var4 < var0.length) {
         int var5 = var0[var4] & 255;
         switch (var5) {
            case 33:
               if (var4 + 1 >= var0.length) {
                  throw new IOException(C0256.m_91e95cb4());
               }

               switch (var0[var4 + 1] & 0xFF) {
                  case 1:
                     var3 = null;
                     var4 = m_c168a094(var0, var4);
                     continue;
                  case 249:
                     if (var3 == null) {
                        var3 = new C0211.anonymousboolean();
                        var2.f_62095c62.add(var3);
                     }

                     var4 = m_293dee4d(var3, var0, var4);
                     continue;
                  case 254:
                     var4 = m_c168a094(var0, var4);
                     continue;
                  case 255:
                     var4 = m_e3572f1d(var2, var0, var4);
                     continue;
                  default:
                     throw new IOException(C0256.m_1616e137() + var4);
               }
            case 44:
               if (var3 == null) {
                  var3 = new C0211.anonymousboolean();
                  var2.f_62095c62.add(var3);
               }

               var4 = m_7478293f(var3, var0, var4);
               if (var3.f_5b414054) {
                  var3.f_426f96fb = new int[var3.f_3f6b948e];
                  var4 = m_42a8eedb(var0, var3.f_426f96fb, var4);
               }

               var4 = m_01ee7f59(var3, var0, var4);
               var3 = null;
               break;
            case 59:
               return var2;
            default:
               double var6 = 1.0 * (double)var4 / (double)var0.length;
               if (var6 < 0.9) {
                  throw new IOException(C0256.m_6dc2a812() + var4);
               }

               var4 = var0.length;
         }
      }

      return var2;
   }

   public static C0211.anonymoustransient m_4ad97825(InputStream var0) throws IOException {
      byte[] var1 = new byte[var0.available()];
      var0.read(var1, 0, var1.length);
      return m_5e01be8d(var1);
   }

   public static int m_e3572f1d(C0211.anonymoustransient var0, byte[] var1, int var2) {
      var0.f_a9e59a28 = new String(var1, var2 + 3, 8);
      var0.f_ea313424 = new String(var1, var2 + 11, 3);
      var2 += 14;
      int var3 = var1[var2] & 255;
      if (var3 == 3) {
         var0.f_3972e701 = var1[var2 + 2] & 255 | var1[var2 + 3] & '\uff00';
         return var2 + 5;
      } else {
         while ((var1[var2] & 255) != 0) {
            var2 += (var1[var2] & 255) + 1;
         }

         return var2 + 1;
      }
   }

   public static int m_42a8eedb(byte[] var0, int[] var1, int var2) {
      int var3 = var1.length;

      for (int var4 = 0; var4 < var3; var4++) {
         short var5 = 255;
         int var6 = var0[var2++] & 255;
         int var7 = var0[var2++] & 255;
         int var8 = var0[var2++] & 255;
         var1[var4] = ((0xFF00 | var6) << 8 | var7) << 8 | var8;
      }

      return var2;
   }

   public static int m_293dee4d(C0211.anonymousboolean var0, byte[] var1, int var2) {
      var0.f_783d1e5e = (var1[var2 + 3] & 28) >>> 2;
      var0.f_1dfc989e = (var1[var2 + 3] & 1) == 1;
      var0.f_ee232633 = var1[var2 + 4] & 255 | (var1[var2 + 5] & 255) << 8;
      var0.f_f0b3f8c4 = var1[var2 + 6] & 255;
      return var2 + 8;
   }

   public static int m_29d08f48(byte[] var0, C0211.anonymoustransient var1) throws IOException {
      if (var0.length < 6) {
         throw new IOException(C0256.m_e7934778());
      } else {
         var1.f_5b839fac = new String(var0, 0, 6);
         if (!var1.f_5b839fac.equals(C0256.m_d0e43f69()) && !var1.f_5b839fac.equals(C0256.m_812ab029())) {
            throw new IOException(C0256.m_11f0c704());
         } else {
            return 6;
         }
      }
   }

   public static int m_01ee7f59(C0211.anonymousboolean var0, byte[] var1, int var2) {
      int var3 = var1.length;
      int var4 = var1[var2++] & 255;
      int var5 = 1 << var4;
      var0.f_e5333634 = var4 + 1;
      var0.f_89db4851 = var5;
      var0.f_18ed6e86 = var5 + 1;
      int var6 = m_3bbe5275(var1, var2);
      byte[] var7 = new byte[var6 + 2];
      int var8 = 0;
      int var9 = var1[var2] & 255;

      while (var9 > 0) {
         try {
            int var10 = var2 + var9 + 1;
            int var11 = var1[var10] & 255;
            System.arraycopy(var1, var2 + 1, var7, var8, var9);
            var8 += var9;
            var2 = var10;
            var9 = var11;
         } catch (Exception var12) {
            var9 = var3 - var2 - 1;
            System.arraycopy(var1, var2 + 1, var7, var8, var9);
            var8 += var9;
            var2 += var9 + 1;
            break;
         }
      }

      var0.f_6d59db73 = var7;
      return var2 + 1;
   }

   public static int m_3bbe5275(byte[] var0, int var1) {
      int var2 = var0.length;
      int var3 = 0;
      int var4 = var0[var1] & 255;

      while (var4 > 0) {
         try {
            int var5 = var1 + var4 + 1;
            int var6 = var0[var5] & 255;
            var3 += var4;
            var1 = var5;
            var4 = var6;
         } catch (Exception var7) {
            var4 = var2 - var1 - 1;
            var3 += var4;
            break;
         }
      }

      return var3;
   }

   public static int m_7478293f(C0211.anonymousboolean var0, byte[] var1, int var2) {
      var0.f_9f6b3f42 = var1[++var2] & 255 | (var1[++var2] & 255) << 8;
      var0.f_d79bb608 = var1[++var2] & 255 | (var1[++var2] & 255) << 8;
      var0.f_251c7380 = var1[++var2] & 255 | (var1[++var2] & 255) << 8;
      var0.f_87638830 = var1[++var2] & 255 | (var1[++var2] & 255) << 8;
      var0.f_f39dafbd = var0.f_251c7380 * var0.f_87638830;
      byte var3 = var1[++var2];
      var0.f_5b414054 = (var3 & 128) >>> 7 == 1;
      var0.f_35c7cae4 = (var3 & 64) >>> 6 == 1;
      var0.f_05d79b1f = (var3 & 32) >>> 5 == 1;
      int var4 = (var3 & 7) + 1;
      var0.f_3f6b948e = 1 << var4;
      return var2 + 1;
   }

   public static int m_f33ddcb9(C0211.anonymoustransient var0, byte[] var1, int var2) {
      var0.f_ff374951 = var1[var2] & 255 | (var1[var2 + 1] & 255) << 8;
      var0.f_4a520b7f = var1[var2 + 2] & 255 | (var1[var2 + 3] & 255) << 8;
      var0.f_0bfd3613 = var0.f_ff374951 * var0.f_4a520b7f;
      byte var3 = var1[var2 + 4];
      var0.f_71dc88f2 = (var3 & 128) >>> 7 == 1;
      int var4 = ((var3 & 112) >>> 4) + 1;
      var0.f_381cfdd8 = 1 << var4;
      var0.f_9e67716a = (var3 & 8) >>> 3 == 1;
      int var5 = (var3 & 7) + 1;
      var0.f_5e49944d = 1 << var5;
      var0.f_7f3f46fe = var1[var2 + 5] & 255;
      var0.f_446e8e34 = var1[var2 + 6] & 255;
      return var2 + 7;
   }

   public static int m_c168a094(byte[] var0, int var1) {
      int var5 = var1 + 2;

      for (int var3 = var0[var5++] & 255; var3 != 0 && var5 < var0.length; var3 = var0[var5++] & 255) {
         var5 += var3;
      }

      return var5;
   }

   static final class anonymousboolean {
      private int f_783d1e5e;
      private boolean f_1dfc989e;
      private int f_ee232633;
      private int f_f0b3f8c4;
      private int f_9f6b3f42;
      private int f_d79bb608;
      private int f_251c7380;
      private int f_87638830;
      private int f_f39dafbd;
      private boolean f_5b414054;
      private boolean f_35c7cae4;
      private boolean f_05d79b1f;
      private int f_3f6b948e;
      private int[] f_426f96fb;
      private int f_e5333634;
      private int f_89db4851;
      private int f_18ed6e86;
      private byte[] f_6d59db73;
      private BufferedImage f_a100f8ec;

      public anonymousboolean() {
      }
   }

   static final class anonymousdefault {
      private final int[][] f_023bcf47 = new int[4096][1];
      private int f_66fbb8a7;
      private int f_5f57cf85;
      private int f_0642c1d2;
      private int f_d7bdfafb;
      private int f_5088a500;
      private int f_fd7fe8b9;
      private C0211.anonymousthis f_8854a125;

      public anonymousdefault() {
      }

      private void m_9646f5f4(int[] var1) {
         if (this.f_5088a500 < 4096) {
            if (this.f_5088a500 == this.f_fd7fe8b9 && this.f_d7bdfafb < 12) {
               this.f_d7bdfafb++;
               this.f_8854a125.m_46938bdb(this.f_d7bdfafb);
               this.f_fd7fe8b9 = (1 << this.f_d7bdfafb) - 1;
            }

            this.f_023bcf47[this.f_5088a500++] = var1;
         }
      }

      private void m_1058ed9a() {
         this.f_d7bdfafb = this.f_5f57cf85;
         this.f_8854a125.m_46938bdb(this.f_d7bdfafb);
         this.f_fd7fe8b9 = this.f_0642c1d2;
         this.f_5088a500 = this.f_66fbb8a7;
      }

      private void m_a3264731(C0211.anonymousboolean var1, int[] var2, C0211.anonymousthis var3) {
         this.f_8854a125 = var3;
         int var4 = var2.length;
         this.f_5f57cf85 = var1.f_e5333634;
         this.f_0642c1d2 = (1 << this.f_5f57cf85) - 1;
         this.f_66fbb8a7 = var1.f_18ed6e86 + 1;
         this.f_5088a500 = this.f_66fbb8a7;

         for (int var5 = var4 - 1; var5 >= 0; var5--) {
            this.f_023bcf47[var5][0] = var2[var5];
         }

         this.f_023bcf47[var1.f_89db4851] = new int[]{var1.f_89db4851};
         this.f_023bcf47[var1.f_18ed6e86] = new int[]{var1.f_18ed6e86};
         if (var1.f_1dfc989e && var1.f_f0b3f8c4 < var4) {
            this.f_023bcf47[var1.f_f0b3f8c4][0] = 0;
         }
      }
   }

   static final class anonymousthis {
      private int f_0db8dddb;
      private int f_3171db8d;
      private int f_0a510cc5;
      private byte[] f_7bab2896;

      public anonymousthis() {
      }

      private void m_7e9016dd(byte[] var1) {
         this.f_7bab2896 = var1;
         this.f_0db8dddb = 0;
      }

      private int m_5b3d3148() {
         int var1 = this.f_0db8dddb >>> 3;
         int var2 = this.f_0db8dddb & 7;
         int var3 = this.f_7bab2896[var1++] & 255;
         int var4 = this.f_7bab2896[var1++] & 255;
         int var5 = this.f_7bab2896[var1] & 255;
         int var6 = ((var5 << 8 | var4) << 8 | var3) >>> var2;
         this.f_0db8dddb = this.f_0db8dddb + this.f_3171db8d;
         return var6 & this.f_0a510cc5;
      }

      private void m_46938bdb(int var1) {
         this.f_3171db8d = var1;
         this.f_0a510cc5 = (1 << var1) - 1;
      }
   }

   public static final class anonymoustransient implements GifProvider {
      private final List<C0211.anonymousboolean> f_62095c62 = new ArrayList<>(64);
      private final C0211.anonymousthis f_d954cd76 = new C0211.anonymousthis();
      private final C0211.anonymousdefault f_a283eba7 = new C0211.anonymousdefault();
      public String f_5b839fac;
      public boolean f_71dc88f2;
      public int f_381cfdd8;
      public boolean f_9e67716a;
      public int f_5e49944d;
      public int f_7f3f46fe;
      public int f_446e8e34;
      public int[] f_9bdc094c;
      public String f_a9e59a28 = "";
      public String f_ea313424 = "";
      public int f_3972e701 = 0;
      private int f_ff374951;
      private int f_4a520b7f;
      private int f_0bfd3613;
      private BufferedImage f_d4f5c358 = null;
      private int[] f_df859369 = null;
      private Graphics2D f_ca5a5d52;

      public anonymoustransient() {
      }

      private int[] m_e4c60a20(C0211.anonymousboolean var1, int[] var2) {
         this.f_a283eba7.m_a3264731(var1, var2, this.f_d954cd76);
         this.f_d954cd76.m_7e9016dd(var1.f_6d59db73);
         int var3 = var1.f_89db4851;
         int var4 = var1.f_18ed6e86;
         int[] var5 = new int[this.f_0bfd3613];
         int[][] var6 = this.f_a283eba7.f_023bcf47;
         int var7 = 0;
         this.f_a283eba7.m_1058ed9a();
         this.f_d954cd76.m_5b3d3148();
         int var8 = this.f_d954cd76.m_5b3d3148();
         int[] var9 = var6[var8];
         System.arraycopy(var9, 0, var5, var7, var9.length);
         var7 += var9.length;

         try {
            while (true) {
               int var10 = var8;
               var8 = this.f_d954cd76.m_5b3d3148();
               if (var8 != var3) {
                  if (var8 == var4) {
                     break;
                  }

                  int[] var11 = var6[var10];
                  int[] var12 = new int[var11.length + 1];
                  System.arraycopy(var11, 0, var12, 0, var11.length);
                  if (var8 < this.f_a283eba7.f_5088a500) {
                     var9 = var6[var8];
                     System.arraycopy(var9, 0, var5, var7, var9.length);
                     var7 += var9.length;
                     var12[var11.length] = var6[var8][0];
                  } else {
                     var12[var11.length] = var11[0];
                     System.arraycopy(var12, 0, var5, var7, var12.length);
                     var7 += var12.length;
                  }

                  this.f_a283eba7.m_9646f5f4(var12);
               } else {
                  this.f_a283eba7.m_1058ed9a();
                  var8 = this.f_d954cd76.m_5b3d3148();
                  var9 = var6[var8];
                  System.arraycopy(var9, 0, var5, var7, var9.length);
                  var7 += var9.length;
               }
            }
         } catch (ArrayIndexOutOfBoundsException var13) {
         }

         return var5;
      }

      private int[] m_0c9f924e(int[] var1, C0211.anonymousboolean var2) {
         int var3 = var2.f_251c7380;
         int var4 = var2.f_87638830;
         int var5 = var2.f_f39dafbd;
         int[] var6 = new int[var1.length];
         int var7 = var4 + 7 >>> 3;
         int var8 = var7 + (var4 + 3 >>> 3);
         int var9 = var8 + (var4 + 1 >>> 2);
         int var10 = var3 * var7;
         int var11 = var3 * var8;
         int var12 = var3 * var9;
         int var13 = var3 << 1;
         int var14 = var13 << 1;
         int var15 = var14 << 1;
         int var16 = 0;

         for (int var17 = 0; var16 < var10; var17 += var15) {
            System.arraycopy(var1, var16, var6, var17, var3);
            var16 += var3;
         }

         for (int var18 = var14; var16 < var11; var18 += var15) {
            System.arraycopy(var1, var16, var6, var18, var3);
            var16 += var3;
         }

         for (int var19 = var13; var16 < var12; var19 += var14) {
            System.arraycopy(var1, var16, var6, var19, var3);
            var16 += var3;
         }

         for (int var20 = var3; var16 < var5; var20 += var13) {
            System.arraycopy(var1, var16, var6, var20, var3);
            var16 += var3;
         }

         return var6;
      }

      private void m_49fe3df9(C0211.anonymousboolean var1) {
         int[] var2 = var1.f_5b414054 ? var1.f_426f96fb : this.f_9bdc094c;
         int[] var3 = this.m_e4c60a20(var1, var2);
         if (var1.f_35c7cae4) {
            var3 = this.m_0c9f924e(var3, var1);
         }

         BufferedImage var4 = new BufferedImage(var1.f_251c7380, var1.f_87638830, 2);
         System.arraycopy(var3, 0, ((DataBufferInt)var4.getRaster().getDataBuffer()).getData(), 0, var1.f_f39dafbd);
         this.f_ca5a5d52.drawImage(var4, var1.f_9f6b3f42, var1.f_d79bb608, null);
         this.f_df859369 = new int[this.f_0bfd3613];
         System.arraycopy(((DataBufferInt)this.f_d4f5c358.getRaster().getDataBuffer()).getData(), 0, this.f_df859369, 0, this.f_0bfd3613);
         var1.f_a100f8ec = new BufferedImage(this.f_ff374951, this.f_4a520b7f, 2);
         System.arraycopy(this.f_df859369, 0, ((DataBufferInt)var1.f_a100f8ec.getRaster().getDataBuffer()).getData(), 0, this.f_0bfd3613);
         if (var1.f_783d1e5e == 2) {
            this.f_ca5a5d52.clearRect(var1.f_9f6b3f42, var1.f_d79bb608, var1.f_251c7380, var1.f_87638830);
         } else if (var1.f_783d1e5e == 3 && this.f_df859369 != null) {
            System.arraycopy(this.f_df859369, 0, ((DataBufferInt)this.f_d4f5c358.getRaster().getDataBuffer()).getData(), 0, this.f_0bfd3613);
         }
      }

      public final int m_5b3d3148() {
         C0211.anonymousboolean var1 = this.f_62095c62.get(0);
         if (var1.f_5b414054) {
            return var1.f_426f96fb[this.f_7f3f46fe];
         } else {
            return this.f_71dc88f2 ? this.f_9bdc094c[this.f_7f3f46fe] : 0;
         }
      }

      public final int getDelay(int var1) {
         return this.f_62095c62.get(var1).f_ee232633 * 10;
      }

      public final BufferedImage getFrame(int var1) {
         if (this.f_d4f5c358 == null) {
            this.f_d4f5c358 = new BufferedImage(this.f_ff374951, this.f_4a520b7f, 2);
            this.f_ca5a5d52 = this.f_d4f5c358.createGraphics();
            this.f_ca5a5d52.setBackground(new Color(0, true));
         }

         C0211.anonymousboolean var2 = this.f_62095c62.get(var1);
         if (var2.f_a100f8ec == null) {
            for (int var3 = 0; var3 <= var1; var3++) {
               var2 = this.f_62095c62.get(var3);
               if (var2.f_a100f8ec == null) {
                  this.m_49fe3df9(var2);
               }
            }
         }

         return var2.f_a100f8ec;
      }

      public final int getFrameCount() {
         return this.f_62095c62.size();
      }

      public final int getHeight() {
         return this.f_4a520b7f;
      }

      public final int getWidth() {
         return this.f_ff374951;
      }
   }
}
