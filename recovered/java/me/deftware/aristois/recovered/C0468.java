package me.deftware.aristois.recovered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class C0468 {
   public static int f_3e2dccc0 = 1024;
   private C0461 f_1fbe8262;
   private C0464 f_2405b800;
   private String f_e89d272f;
   private String f_53e76d57 = null;
   private String f_97fc2012 = null;
   private String f_16530cbb;
   private long f_ebed5854;
   private int f_6f6401df;
   private long f_caf77b26;
   private boolean f_14e6f8bc;
   private Socket f_e18b438a = null;
   private long f_b452da16 = 0L;
   private File f_47d61a2c = null;
   private int f_eee6ea8d = 0;
   private boolean f_ec5ce26d;
   private long f_22042504 = 0L;
   private long f_69fde206 = 0L;

   public C0468(C0461 var1, C0464 var2, String var3, String var4, String var5, String var6, String var7, long var8, int var10, long var11) {
      this.f_1fbe8262 = var1;
      this.f_2405b800 = var2;
      this.f_e89d272f = var3;
      this.f_53e76d57 = var4;
      this.f_97fc2012 = var5;
      this.f_16530cbb = var6;
      this.f_47d61a2c = new File(var7);
      this.f_ebed5854 = var8;
      this.f_6f6401df = var10;
      this.f_caf77b26 = var11;
      this.f_14e6f8bc = false;
      this.f_ec5ce26d = true;
   }

   public C0468(C0461 var1, C0464 var2, File var3, String var4, int var5) {
      this.f_1fbe8262 = var1;
      this.f_2405b800 = var2;
      this.f_e89d272f = var4;
      this.f_47d61a2c = var3;
      this.f_caf77b26 = var3.length();
      this.f_eee6ea8d = var5;
      this.f_14e6f8bc = true;
      this.f_ec5ce26d = false;
   }

   public synchronized void m_5454f1e2(File var1, boolean var2) {
      if (!this.f_14e6f8bc) {
         this.f_14e6f8bc = true;
         this.f_47d61a2c = var1;
         if (this.f_16530cbb.equals(C0252.bootstrap<"get",30064771187>()) && var2) {
            this.f_b452da16 = var1.length();
            if (this.f_b452da16 == 0L) {
               this.m_190c3916(var1, false);
            } else {
               this.f_1fbe8262
                  .m_ce0210e2(this.f_e89d272f, C0252.bootstrap<"get",30064771188>() + this.f_6f6401df + C0252.bootstrap<"get",70>() + this.f_b452da16);
               this.f_2405b800.m_043b2416(this);
            }
         } else {
            this.f_b452da16 = var1.length();
            this.m_190c3916(var1, var2);
         }
      }
   }

   public void m_190c3916(File var1, boolean var2) {
      new Thread(
            () -> {
               BufferedOutputStream var3 = null;
               Exception var4 = null;

               try {
                  int[] var5 = this.f_1fbe8262.m_45e74680(this.f_ebed5854);
                  String var6 = var5[0]
                     + C0252.bootstrap<"get",8589934650>()
                     + var5[1]
                     + C0252.bootstrap<"get",8589934650>()
                     + var5[2]
                     + C0252.bootstrap<"get",8589934650>()
                     + var5[3];
                  this.f_e18b438a = new Socket(var6, this.f_6f6401df);
                  this.f_e18b438a.setSoTimeout(30000);
                  this.f_69fde206 = C0114.bootstrap<"call",0,1>();
                  this.f_2405b800.m_6ed12368(this);
                  BufferedInputStream var7 = new BufferedInputStream(this.f_e18b438a.getInputStream());
                  BufferedOutputStream var8 = new BufferedOutputStream(this.f_e18b438a.getOutputStream());
                  var3 = new BufferedOutputStream(new FileOutputStream(var1.getCanonicalPath(), var2));
                  byte[] var9 = new byte[f_3e2dccc0];
                  byte[] var10 = new byte[4];
                  int var11 = 0;

                  while ((var11 = var7.read(var9, 0, var9.length)) != -1) {
                     var3.write(var9, 0, var11);
                     this.f_b452da16 += (long)var11;
                     var10[0] = (byte)((int)(this.f_b452da16 >> 24 & 255L));
                     var10[1] = (byte)((int)(this.f_b452da16 >> 16 & 255L));
                     var10[2] = (byte)((int)(this.f_b452da16 >> 8 & 255L));
                     var10[3] = (byte)((int)(this.f_b452da16 & 255L));
                     var8.write(var10);
                     var8.flush();
                     this.m_a6bb3f4f();
                  }

                  var3.flush();
               } catch (Exception var20) {
                  var4 = var20;
               } finally {
                  try {
                     if (var3 != null) {
                        var3.close();
                     }

                     this.f_e18b438a.close();
                  } catch (Exception var19) {
                  }
               }

               this.f_1fbe8262.m_a938a984(this, var4);
            }
         )
         .start();
   }

   public void m_73180361(boolean var1) {
      new Thread(
            () -> {
               BufferedInputStream var2 = null;
               Exception var3 = null;

               try {
                  ServerSocket var4 = null;
                  int[] var5 = this.f_1fbe8262.m_b6a3faa3();
                  if (var5 == null) {
                     var4 = new ServerSocket(0);
                  } else {
                     for (int var9 : var5) {
                        try {
                           var4 = new ServerSocket(var9);
                           break;
                        } catch (Exception var25) {
                        }
                     }

                     if (var4 == null) {
                        throw new IOException(C0252.bootstrap<"get",30064771189>());
                     }
                  }

                  var4.setSoTimeout(this.f_eee6ea8d);
                  this.f_6f6401df = var4.getLocalPort();
                  InetAddress var28 = this.f_1fbe8262.m_2609e004();
                  if (var28 == null) {
                     var28 = this.f_1fbe8262.m_ae8bc5b6();
                  }

                  byte[] var29 = var28.getAddress();
                  long var30 = this.f_1fbe8262.m_685d082e(var29);
                  String var10 = this.f_47d61a2c.getName().replace(' ', '_');
                  var10 = var10.replace('\t', '_');
                  if (var1) {
                     this.f_2405b800.m_043b2416(this);
                  }

                  this.f_1fbe8262
                     .m_ce0210e2(
                        this.f_e89d272f,
                        C0252.bootstrap<"get",30064771190>()
                           + var10
                           + C0252.bootstrap<"get",70>()
                           + var30
                           + C0252.bootstrap<"get",70>()
                           + this.f_6f6401df
                           + C0252.bootstrap<"get",70>()
                           + this.f_47d61a2c.length()
                     );
                  this.f_e18b438a = var4.accept();
                  this.f_e18b438a.setSoTimeout(30000);
                  this.f_69fde206 = C0114.bootstrap<"call",0,1>();
                  if (var1) {
                     this.f_2405b800.m_6ed12368(this);
                  }

                  var4.close();
                  BufferedOutputStream var11 = new BufferedOutputStream(this.f_e18b438a.getOutputStream());
                  BufferedInputStream var12 = new BufferedInputStream(this.f_e18b438a.getInputStream());
                  var2 = new BufferedInputStream(new FileInputStream(this.f_47d61a2c));
                  if (this.f_b452da16 > 0L) {
                     long var13 = 0L;

                     while (var13 < this.f_b452da16) {
                        var13 += var2.skip(this.f_b452da16 - var13);
                     }
                  }

                  byte[] var32 = new byte[f_3e2dccc0];
                  byte[] var14 = new byte[4];
                  int var15 = 0;

                  while ((var15 = var2.read(var32, 0, var32.length)) != -1) {
                     var11.write(var32, 0, var15);
                     var11.flush();
                     var12.read(var14, 0, var14.length);
                     this.f_b452da16 += (long)var15;
                     this.m_a6bb3f4f();
                  }
               } catch (Exception var26) {
                  var3 = var26;
               } finally {
                  try {
                     if (var2 != null) {
                        var2.close();
                     }

                     this.f_e18b438a.close();
                  } catch (Exception var24) {
                  }
               }

               this.f_1fbe8262.m_a938a984(this, var3);
            }
         )
         .start();
   }

   private void m_a6bb3f4f() {
      if (this.f_22042504 > 0L) {
         try {
            C0114.bootstrap<"call",0,1>(this.f_22042504);
         } catch (InterruptedException var2) {
         }
      }
   }

   public String m_c9fee510() {
      return this.f_e89d272f;
   }

   public String m_1b6eb0bd() {
      return this.f_53e76d57;
   }

   public String m_c8aa4f28() {
      return this.f_97fc2012;
   }

   public File m_2335353c() {
      return this.f_47d61a2c;
   }

   public int m_146d9f78() {
      return this.f_6f6401df;
   }

   public boolean m_9cd91056() {
      return this.f_ec5ce26d;
   }

   public boolean m_c2bb1238() {
      return !this.m_9cd91056();
   }

   public long m_3e56f843() {
      return this.f_22042504;
   }

   public void m_a4700369(long var1) {
      this.f_22042504 = var1;
   }

   public long m_049e3261() {
      return this.f_caf77b26;
   }

   public long m_e96a7009() {
      return this.f_b452da16;
   }

   public void m_9fe748e5(long var1) {
      this.f_b452da16 = var1;
   }

   public double m_d9f672b2() {
      return 100.0 * ((double)this.m_e96a7009() / (double)this.m_049e3261());
   }

   public void m_c63a28e4() {
      try {
         this.f_e18b438a.close();
      } catch (Exception var2) {
      }
   }

   public long m_56320631() {
      long var1 = (C0114.bootstrap<"call",0,1>() - this.f_69fde206) / 1000L;
      return var1 <= 0L ? 0L : this.m_e96a7009() / var1;
   }

   public long m_d810f2a5() {
      return this.f_ebed5854;
   }
}
