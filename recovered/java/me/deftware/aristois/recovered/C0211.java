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
   public static final boolean f_8c359a22 = false;

   public C0211() {
   }

   public static C0211.anonymoustransient m_0f0f60f8(byte[] var0) throws IOException {
      new C0211();
      C0211.anonymoustransient var2 = new C0211.anonymoustransient();
      C0211.anonymousboolean var3 = null;
      int var4 = C0114.bootstrap<"call",0,1>(var0, var2);
      var4 = C0114.bootstrap<"call",1,1>(var2, var0, var4);
      if (var2.f_873567d5) {
         var2.f_3b893e59 = new int[var2.f_b9089b81];
         var4 = C0114.bootstrap<"call",2,1>(var0, var2.f_3b893e59, var4);
      }

      while (var4 < var0.length) {
         int var5 = var0[var4] & 255;
         switch (var5) {
            case 33:
               if (var4 + 1 >= var0.length) {
                  throw new IOException(C0252.bootstrap<"get",55834574924>());
               }

               switch (var0[var4 + 1] & 0xFF) {
                  case 1:
                     var3 = null;
                     var4 = C0114.bootstrap<"call",3,1>(var0, var4);
                     continue;
                  case 249:
                     if (var3 == null) {
                        var3 = new C0211.anonymousboolean();
                        C0114.bootstrap<"call",5,1>(var2).add(var3);
                     }

                     var4 = C0114.bootstrap<"call",6,1>(var3, var0, var4);
                     continue;
                  case 254:
                     var4 = C0114.bootstrap<"call",3,1>(var0, var4);
                     continue;
                  case 255:
                     var4 = C0114.bootstrap<"call",4,1>(var2, var0, var4);
                     continue;
                  default:
                     throw new IOException(C0252.bootstrap<"get",55834574925>() + var4);
               }
            case 44:
               if (var3 == null) {
                  var3 = new C0211.anonymousboolean();
                  C0114.bootstrap<"call",5,1>(var2).add(var3);
               }

               var4 = C0114.bootstrap<"call",7,1>(var3, var0, var4);
               if (C0114.bootstrap<"call",8,1>(var3)) {
                  C0114.bootstrap<"call",10,1>(var3, new int[C0114.bootstrap<"call",9,1>(var3)]);
                  var4 = C0114.bootstrap<"call",2,1>(var0, C0114.bootstrap<"call",11,1>(var3), var4);
               }

               var4 = C0114.bootstrap<"call",12,1>(var3, var0, var4);
               var3 = null;
               break;
            case 59:
               return var2;
            default:
               double var6 = 1.0 * (double)var4 / (double)var0.length;
               if (var6 < 0.9) {
                  throw new IOException(C0252.bootstrap<"get",55834574926>() + var4);
               }

               var4 = var0.length;
         }
      }

      return var2;
   }

   public static C0211.anonymoustransient m_c714ec75(InputStream var0) throws IOException {
      byte[] var1 = new byte[var0.available()];
      var0.read(var1, 0, var1.length);
      return C0114.bootstrap<"call",13,1>(var1);
   }

   public static int m_c0aaa240(C0211.anonymoustransient var0, byte[] var1, int var2) {
      var0.f_0945379c = new String(var1, var2 + 3, 8);
      var0.f_d19ebf8a = new String(var1, var2 + 11, 3);
      var2 += 14;
      int var3 = var1[var2] & 255;
      if (var3 == 3) {
         var0.f_8849d689 = var1[var2 + 2] & 255 | var1[var2 + 3] & '\uff00';
         return var2 + 5;
      } else {
         while ((var1[var2] & 255) != 0) {
            var2 += (var1[var2] & 255) + 1;
         }

         return var2 + 1;
      }
   }

   public static int m_cd249701(byte[] var0, int[] var1, int var2) {
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

   public static int m_53f618f5(C0211.anonymousboolean var0, byte[] var1, int var2) {
      C0114.bootstrap<"call",14,1>(var0, (var1[var2 + 3] & 28) >>> 2);
      C0114.bootstrap<"call",15,1>(var0, (var1[var2 + 3] & 1) == 1);
      C0114.bootstrap<"call",16,1>(var0, var1[var2 + 4] & 255 | (var1[var2 + 5] & 255) << 8);
      C0114.bootstrap<"call",17,1>(var0, var1[var2 + 6] & 255);
      return var2 + 8;
   }

   public static int m_9d041d14(byte[] var0, C0211.anonymoustransient var1) throws IOException {
      if (var0.length < 6) {
         throw new IOException(C0252.bootstrap<"get",55834574927>());
      } else {
         var1.f_9cffe02a = new String(var0, 0, 6);
         if (!var1.f_9cffe02a.equals(C0252.bootstrap<"get",55834574928>()) && !var1.f_9cffe02a.equals(C0252.bootstrap<"get",55834574929>())) {
            throw new IOException(C0252.bootstrap<"get",55834574930>());
         } else {
            return 6;
         }
      }
   }

   public static int m_b1ea765e(C0211.anonymousboolean var0, byte[] var1, int var2) {
      int var3 = var1.length;
      int var4 = var1[var2++] & 255;
      int var5 = 1 << var4;
      C0114.bootstrap<"call",0,1>(var0, var4 + 1);
      C0114.bootstrap<"call",1,1>(var0, var5);
      C0114.bootstrap<"call",2,1>(var0, var5 + 1);
      int var6 = C0114.bootstrap<"call",3,1>(var1, var2);
      byte[] var7 = new byte[var6 + 2];
      int var8 = 0;
      int var9 = var1[var2] & 255;

      while (var9 > 0) {
         try {
            int var10 = var2 + var9 + 1;
            int var11 = var1[var10] & 255;
            C0114.bootstrap<"call",4,1>(var1, var2 + 1, var7, var8, var9);
            var8 += var9;
            var2 = var10;
            var9 = var11;
         } catch (Exception var12) {
            var9 = var3 - var2 - 1;
            C0114.bootstrap<"call",4,1>(var1, var2 + 1, var7, var8, var9);
            var8 += var9;
            var2 += var9 + 1;
            break;
         }
      }

      C0114.bootstrap<"call",5,1>(var0, var7);
      return var2 + 1;
   }

   public static int m_94da7441(byte[] var0, int var1) {
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

   public static int m_0145e9e5(C0211.anonymousboolean var0, byte[] var1, int var2) {
      C0114.bootstrap<"call",0,1>(var0, var1[++var2] & 255 | (var1[++var2] & 255) << 8);
      C0114.bootstrap<"call",1,1>(var0, var1[++var2] & 255 | (var1[++var2] & 255) << 8);
      C0114.bootstrap<"call",2,1>(var0, var1[++var2] & 255 | (var1[++var2] & 255) << 8);
      C0114.bootstrap<"call",3,1>(var0, var1[++var2] & 255 | (var1[++var2] & 255) << 8);
      C0114.bootstrap<"call",6,1>(var0, C0114.bootstrap<"call",4,1>(var0) * C0114.bootstrap<"call",5,1>(var0));
      byte var3 = var1[++var2];
      C0114.bootstrap<"call",7,1>(var0, (var3 & 128) >>> 7 == 1);
      C0114.bootstrap<"call",8,1>(var0, (var3 & 64) >>> 6 == 1);
      C0114.bootstrap<"call",9,1>(var0, (var3 & 32) >>> 5 == 1);
      int var4 = (var3 & 7) + 1;
      C0114.bootstrap<"call",10,1>(var0, 1 << var4);
      return var2 + 1;
   }

   public static int m_bf7ca6f1(C0211.anonymoustransient var0, byte[] var1, int var2) {
      C0114.bootstrap<"call",6,1>(var0, var1[var2] & 255 | (var1[var2 + 1] & 255) << 8);
      C0114.bootstrap<"call",7,1>(var0, var1[var2 + 2] & 255 | (var1[var2 + 3] & 255) << 8);
      C0114.bootstrap<"call",10,1>(var0, C0114.bootstrap<"call",8,1>(var0) * C0114.bootstrap<"call",9,1>(var0));
      byte var3 = var1[var2 + 4];
      var0.f_873567d5 = (var3 & 128) >>> 7 == 1;
      int var4 = ((var3 & 112) >>> 4) + 1;
      var0.f_c6d50f43 = 1 << var4;
      var0.f_ca53022c = (var3 & 8) >>> 3 == 1;
      int var5 = (var3 & 7) + 1;
      var0.f_b9089b81 = 1 << var5;
      var0.f_3ebb2442 = var1[var2 + 5] & 255;
      var0.f_387f3429 = var1[var2 + 6] & 255;
      return var2 + 7;
   }

   public static int m_a35a1c1d(byte[] var0, int var1) {
      int var5 = var1 + 2;

      for (int var3 = var0[var5++] & 255; var3 != 0 && var5 < var0.length; var3 = var0[var5++] & 255) {
         var5 += var3;
      }

      return var5;
   }

   static final class anonymousboolean {
      private int f_23b6fcbe;
      private boolean f_13e7d72f;
      private int f_4efcbabd;
      private int f_74cdd0cb;
      private int f_839b295c;
      private int f_8be66be3;
      private int f_f98851b3;
      private int f_4f64fc64;
      private int f_a0835f98;
      private boolean f_18c5b0bb;
      private boolean f_30363998;
      private boolean f_1d5a114b;
      private int f_101a153b;
      private int[] f_859b4707;
      private int f_38894e30;
      private int f_1af51d28;
      private int f_de89d765;
      private byte[] f_9689b96d;
      private BufferedImage f_042ad8d1;

      public anonymousboolean() {
      }
   }

   static final class anonymousdefault {
      private final int[][] f_dd746154 = new int[4096][1];
      private int f_7199861d;
      private int f_766e85c3;
      private int f_1931b665;
      private int f_21f17684;
      private int f_39c0897a;
      private int f_b63a9961;
      private C0211.anonymousthis f_5ec2d396;

      public anonymousdefault() {
      }

      private void m_c6c004bd(int[] var1) {
         if (this.f_39c0897a < 4096) {
            if (this.f_39c0897a == this.f_b63a9961 && this.f_21f17684 < 12) {
               this.f_21f17684++;
               C0114.bootstrap<"call",0,1>(this.f_5ec2d396, this.f_21f17684);
               this.f_b63a9961 = (1 << this.f_21f17684) - 1;
            }

            this.f_dd746154[this.f_39c0897a++] = var1;
         }
      }

      private void m_0e367f45() {
         this.f_21f17684 = this.f_766e85c3;
         C0114.bootstrap<"call",0,1>(this.f_5ec2d396, this.f_21f17684);
         this.f_b63a9961 = this.f_1931b665;
         this.f_39c0897a = this.f_7199861d;
      }

      private void m_d7039758(C0211.anonymousboolean var1, int[] var2, C0211.anonymousthis var3) {
         this.f_5ec2d396 = var3;
         int var4 = var2.length;
         this.f_766e85c3 = C0114.bootstrap<"call",1,1>(var1);
         this.f_1931b665 = (1 << this.f_766e85c3) - 1;
         this.f_7199861d = C0114.bootstrap<"call",2,1>(var1) + 1;
         this.f_39c0897a = this.f_7199861d;

         for (int var5 = var4 - 1; var5 >= 0; var5--) {
            this.f_dd746154[var5][0] = var2[var5];
         }

         this.f_dd746154[C0114.bootstrap<"call",3,1>(var1)] = new int[]{C0114.bootstrap<"call",3,1>(var1)};
         this.f_dd746154[C0114.bootstrap<"call",2,1>(var1)] = new int[]{C0114.bootstrap<"call",2,1>(var1)};
         if (C0114.bootstrap<"call",4,1>(var1) && C0114.bootstrap<"call",5,1>(var1) < var4) {
            this.f_dd746154[C0114.bootstrap<"call",5,1>(var1)][0] = 0;
         }
      }
   }

   static final class anonymousthis {
      private int f_8daacf3e;
      private int f_98baf32a;
      private int f_74b0801a;
      private byte[] f_c4b712ac;

      public anonymousthis() {
      }

      private void m_9e7755b6(byte[] var1) {
         this.f_c4b712ac = var1;
         this.f_8daacf3e = 0;
      }

      private int m_f1fc6fe5() {
         int var1 = this.f_8daacf3e >>> 3;
         int var2 = this.f_8daacf3e & 7;
         int var3 = this.f_c4b712ac[var1++] & 255;
         int var4 = this.f_c4b712ac[var1++] & 255;
         int var5 = this.f_c4b712ac[var1] & 255;
         int var6 = ((var5 << 8 | var4) << 8 | var3) >>> var2;
         this.f_8daacf3e = this.f_8daacf3e + this.f_98baf32a;
         return var6 & this.f_74b0801a;
      }

      private void m_f61563a9(int var1) {
         this.f_98baf32a = var1;
         this.f_74b0801a = (1 << var1) - 1;
      }
   }

   public static final class anonymoustransient implements GifProvider {
      private final List<C0211.anonymousboolean> f_233fd847 = new ArrayList<>(64);
      private final C0211.anonymousthis f_9d649cbe = new C0211.anonymousthis();
      private final C0211.anonymousdefault f_03469e84 = new C0211.anonymousdefault();
      public String f_9cffe02a;
      public boolean f_873567d5;
      public int f_c6d50f43;
      public boolean f_ca53022c;
      public int f_b9089b81;
      public int f_3ebb2442;
      public int f_387f3429;
      public int[] f_3b893e59;
      public String f_0945379c = "";
      public String f_d19ebf8a = "";
      public int f_8849d689 = 0;
      private int f_81f85877;
      private int f_4fabfc81;
      private int f_4c48a50e;
      private BufferedImage f_31c6e125 = null;
      private int[] f_f5420581 = null;
      private Graphics2D f_8839130e;

      public anonymoustransient() {
      }

      private int[] m_032b1db9(C0211.anonymousboolean var1, int[] var2) {
         C0114.bootstrap<"call",0,1>(this.f_03469e84, var1, var2, this.f_9d649cbe);
         C0114.bootstrap<"call",2,1>(this.f_9d649cbe, C0114.bootstrap<"call",1,1>(var1));
         int var3 = C0114.bootstrap<"call",3,1>(var1);
         int var4 = C0114.bootstrap<"call",4,1>(var1);
         int[] var5 = new int[this.f_4c48a50e];
         int[][] var6 = C0114.bootstrap<"call",5,1>(this.f_03469e84);
         int var7 = 0;
         C0114.bootstrap<"call",6,1>(this.f_03469e84);
         C0114.bootstrap<"call",7,1>(this.f_9d649cbe);
         int var8 = C0114.bootstrap<"call",7,1>(this.f_9d649cbe);
         int[] var9 = var6[var8];
         C0114.bootstrap<"call",8,1>(var9, 0, var5, var7, var9.length);
         var7 += var9.length;

         try {
            while (true) {
               int var10 = var8;
               var8 = C0114.bootstrap<"call",7,1>(this.f_9d649cbe);
               if (var8 != var3) {
                  if (var8 == var4) {
                     break;
                  }

                  int[] var11 = var6[var10];
                  int[] var12 = new int[var11.length + 1];
                  C0114.bootstrap<"call",8,1>(var11, 0, var12, 0, var11.length);
                  if (var8 < C0114.bootstrap<"call",9,1>(this.f_03469e84)) {
                     var9 = var6[var8];
                     C0114.bootstrap<"call",8,1>(var9, 0, var5, var7, var9.length);
                     var7 += var9.length;
                     var12[var11.length] = var6[var8][0];
                  } else {
                     var12[var11.length] = var11[0];
                     C0114.bootstrap<"call",8,1>(var12, 0, var5, var7, var12.length);
                     var7 += var12.length;
                  }

                  C0114.bootstrap<"call",10,1>(this.f_03469e84, var12);
               } else {
                  C0114.bootstrap<"call",6,1>(this.f_03469e84);
                  var8 = C0114.bootstrap<"call",7,1>(this.f_9d649cbe);
                  var9 = var6[var8];
                  C0114.bootstrap<"call",8,1>(var9, 0, var5, var7, var9.length);
                  var7 += var9.length;
               }
            }
         } catch (ArrayIndexOutOfBoundsException var13) {
         }

         return var5;
      }

      private int[] m_743bf468(int[] var1, C0211.anonymousboolean var2) {
         int var3 = C0114.bootstrap<"call",11,1>(var2);
         int var4 = C0114.bootstrap<"call",12,1>(var2);
         int var5 = C0114.bootstrap<"call",13,1>(var2);
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
            C0114.bootstrap<"call",8,1>(var1, var16, var6, var17, var3);
            var16 += var3;
         }

         for (int var18 = var14; var16 < var11; var18 += var15) {
            C0114.bootstrap<"call",8,1>(var1, var16, var6, var18, var3);
            var16 += var3;
         }

         for (int var19 = var13; var16 < var12; var19 += var14) {
            C0114.bootstrap<"call",8,1>(var1, var16, var6, var19, var3);
            var16 += var3;
         }

         for (int var20 = var3; var16 < var5; var20 += var13) {
            C0114.bootstrap<"call",8,1>(var1, var16, var6, var20, var3);
            var16 += var3;
         }

         return var6;
      }

      private void m_4eb7c58d(C0211.anonymousboolean var1) {
         int[] var2 = C0114.bootstrap<"call",14,1>(var1) ? C0114.bootstrap<"call",15,1>(var1) : this.f_3b893e59;
         int[] var3 = this.m_032b1db9(var1, var2);
         if (C0114.bootstrap<"call",16,1>(var1)) {
            var3 = this.m_743bf468(var3, var1);
         }

         BufferedImage var4 = new BufferedImage(C0114.bootstrap<"call",11,1>(var1), C0114.bootstrap<"call",12,1>(var1), 2);
         C0114.bootstrap<"call",8,1>(var3, 0, ((DataBufferInt)var4.getRaster().getDataBuffer()).getData(), 0, C0114.bootstrap<"call",13,1>(var1));
         this.f_8839130e.drawImage(var4, C0114.bootstrap<"call",17,1>(var1), C0114.bootstrap<"call",18,1>(var1), null);
         this.f_f5420581 = new int[this.f_4c48a50e];
         C0114.bootstrap<"call",8,1>(((DataBufferInt)this.f_31c6e125.getRaster().getDataBuffer()).getData(), 0, this.f_f5420581, 0, this.f_4c48a50e);
         C0114.bootstrap<"call",19,1>(var1, new BufferedImage(this.f_81f85877, this.f_4fabfc81, 2));
         C0114.bootstrap<"call",8,1>(
            this.f_f5420581, 0, ((DataBufferInt)C0114.bootstrap<"call",20,1>(var1).getRaster().getDataBuffer()).getData(), 0, this.f_4c48a50e
         );
         if (C0114.bootstrap<"call",21,1>(var1) == 2) {
            this.f_8839130e
               .clearRect(
                  C0114.bootstrap<"call",17,1>(var1),
                  C0114.bootstrap<"call",18,1>(var1),
                  C0114.bootstrap<"call",11,1>(var1),
                  C0114.bootstrap<"call",12,1>(var1)
               );
         } else if (C0114.bootstrap<"call",21,1>(var1) == 3 && this.f_f5420581 != null) {
            C0114.bootstrap<"call",8,1>(this.f_f5420581, 0, ((DataBufferInt)this.f_31c6e125.getRaster().getDataBuffer()).getData(), 0, this.f_4c48a50e);
         }
      }

      public final int m_b6054f1b() {
         C0211.anonymousboolean var1 = this.f_233fd847.get(0);
         if (C0114.bootstrap<"call",14,1>(var1)) {
            return C0114.bootstrap<"call",15,1>(var1)[this.f_3ebb2442];
         } else {
            return this.f_873567d5 ? this.f_3b893e59[this.f_3ebb2442] : 0;
         }
      }

      public final int getDelay(int var1) {
         return C0114.bootstrap<"call",0,1>(this.f_233fd847.get(var1)) * 10;
      }

      public final BufferedImage getFrame(int var1) {
         if (this.f_31c6e125 == null) {
            this.f_31c6e125 = new BufferedImage(this.f_81f85877, this.f_4fabfc81, 2);
            this.f_8839130e = this.f_31c6e125.createGraphics();
            this.f_8839130e.setBackground(new Color(0, true));
         }

         C0211.anonymousboolean var2 = this.f_233fd847.get(var1);
         if (C0114.bootstrap<"call",0,1>(var2) == null) {
            for (int var3 = 0; var3 <= var1; var3++) {
               var2 = this.f_233fd847.get(var3);
               if (C0114.bootstrap<"call",0,1>(var2) == null) {
                  this.m_4eb7c58d(var2);
               }
            }
         }

         return C0114.bootstrap<"call",0,1>(var2);
      }

      public final int getFrameCount() {
         return this.f_233fd847.size();
      }

      public final int getHeight() {
         return this.f_4fabfc81;
      }

      public final int getWidth() {
         return this.f_81f85877;
      }
   }
}
