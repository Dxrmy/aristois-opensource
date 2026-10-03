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
   public static int f_c25f7a3b = 1024;
   private C0461 f_84a2fafa;
   private C0464 f_ee509d9d;
   private String f_8a6f2139;
   private String f_25bcf1bc = null;
   private String f_494d0915 = null;
   private String f_393f5204;
   private long f_d6f281bc;
   private int f_c1f3f4a3;
   private long f_b721d101;
   private boolean f_8cdd169d;
   private Socket f_5724d0c0 = null;
   private long f_dbc556da = 0L;
   private File f_e5ae5e4d = null;
   private int f_8c5ac125 = 0;
   private boolean f_68a3f703;
   private long f_27f6074a = 0L;
   private long f_216d3659 = 0L;

   public C0468(C0461 var1, C0464 var2, String var3, String var4, String var5, String var6, String var7, long var8, int var10, long var11) {
      this.f_84a2fafa = var1;
      this.f_ee509d9d = var2;
      this.f_8a6f2139 = var3;
      this.f_25bcf1bc = var4;
      this.f_494d0915 = var5;
      this.f_393f5204 = var6;
      this.f_e5ae5e4d = new File(var7);
      this.f_d6f281bc = var8;
      this.f_c1f3f4a3 = var10;
      this.f_b721d101 = var11;
      this.f_8cdd169d = false;
      this.f_68a3f703 = true;
   }

   public C0468(C0461 var1, C0464 var2, File var3, String var4, int var5) {
      this.f_84a2fafa = var1;
      this.f_ee509d9d = var2;
      this.f_8a6f2139 = var4;
      this.f_e5ae5e4d = var3;
      this.f_b721d101 = var3.length();
      this.f_8c5ac125 = var5;
      this.f_8cdd169d = true;
      this.f_68a3f703 = false;
   }

   public synchronized void m_b7343b48(File var1, boolean var2) {
      if (!this.f_8cdd169d) {
         this.f_8cdd169d = true;
         this.f_e5ae5e4d = var1;
         if (this.f_393f5204.equals(C0265.m_733bff3d()) && var2) {
            this.f_dbc556da = var1.length();
            if (this.f_dbc556da == 0L) {
               this.m_2793dddf(var1, false);
            } else {
               this.f_84a2fafa.m_412d10a2(this.f_8a6f2139, C0265.m_76700429() + this.f_c1f3f4a3 + C0257.m_593ecbab() + this.f_dbc556da);
               this.f_ee509d9d.m_f9b69576(this);
            }
         } else {
            this.f_dbc556da = var1.length();
            this.m_2793dddf(var1, var2);
         }
      }
   }

   public void m_2793dddf(File var1, boolean var2) {
      new Thread(() -> {
         BufferedOutputStream var3 = null;
         Exception var4 = null;

         try {
            int[] var5 = this.f_84a2fafa.m_729d3cd6(this.f_d6f281bc);
            String var6 = var5[0] + C0253.m_56242a84() + var5[1] + C0253.m_56242a84() + var5[2] + C0253.m_56242a84() + var5[3];
            this.f_5724d0c0 = new Socket(var6, this.f_c1f3f4a3);
            this.f_5724d0c0.setSoTimeout(30000);
            this.f_216d3659 = System.currentTimeMillis();
            this.f_ee509d9d.m_81a3fe0e(this);
            BufferedInputStream var7 = new BufferedInputStream(this.f_5724d0c0.getInputStream());
            BufferedOutputStream var8 = new BufferedOutputStream(this.f_5724d0c0.getOutputStream());
            var3 = new BufferedOutputStream(new FileOutputStream(var1.getCanonicalPath(), var2));
            byte[] var9 = new byte[f_c25f7a3b];
            byte[] var10 = new byte[4];
            int var11 = 0;

            while ((var11 = var7.read(var9, 0, var9.length)) != -1) {
               var3.write(var9, 0, var11);
               this.f_dbc556da += (long)var11;
               var10[0] = (byte)((int)(this.f_dbc556da >> 24 & 255L));
               var10[1] = (byte)((int)(this.f_dbc556da >> 16 & 255L));
               var10[2] = (byte)((int)(this.f_dbc556da >> 8 & 255L));
               var10[3] = (byte)((int)(this.f_dbc556da & 255L));
               var8.write(var10);
               var8.flush();
               this.m_1058ed9a();
            }

            var3.flush();
         } catch (Exception var20) {
            var4 = var20;
         } finally {
            try {
               if (var3 != null) {
                  var3.close();
               }

               this.f_5724d0c0.close();
            } catch (Exception var19) {
            }
         }

         this.f_84a2fafa.m_4c9108c9(this, var4);
      }).start();
   }

   public void m_d6ac7420(boolean var1) {
      new Thread(
            () -> {
               BufferedInputStream var2 = null;
               Exception var3 = null;

               try {
                  ServerSocket var4 = null;
                  int[] var5 = this.f_84a2fafa.m_9ea7017c();
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
                        throw new IOException(C0265.m_8870d2c1());
                     }
                  }

                  var4.setSoTimeout(this.f_8c5ac125);
                  this.f_c1f3f4a3 = var4.getLocalPort();
                  InetAddress var28 = this.f_84a2fafa.m_7dba075f();
                  if (var28 == null) {
                     var28 = this.f_84a2fafa.m_18ff89bb();
                  }

                  byte[] var29 = var28.getAddress();
                  long var30 = this.f_84a2fafa.m_6fa424cb(var29);
                  String var10 = this.f_e5ae5e4d.getName().replace(' ', '_');
                  var10 = var10.replace('\t', '_');
                  if (var1) {
                     this.f_ee509d9d.m_f9b69576(this);
                  }

                  this.f_84a2fafa
                     .m_412d10a2(
                        this.f_8a6f2139,
                        C0265.m_a004d745()
                           + var10
                           + C0257.m_593ecbab()
                           + var30
                           + C0257.m_593ecbab()
                           + this.f_c1f3f4a3
                           + C0257.m_593ecbab()
                           + this.f_e5ae5e4d.length()
                     );
                  this.f_5724d0c0 = var4.accept();
                  this.f_5724d0c0.setSoTimeout(30000);
                  this.f_216d3659 = System.currentTimeMillis();
                  if (var1) {
                     this.f_ee509d9d.m_81a3fe0e(this);
                  }

                  var4.close();
                  BufferedOutputStream var11 = new BufferedOutputStream(this.f_5724d0c0.getOutputStream());
                  BufferedInputStream var12 = new BufferedInputStream(this.f_5724d0c0.getInputStream());
                  var2 = new BufferedInputStream(new FileInputStream(this.f_e5ae5e4d));
                  if (this.f_dbc556da > 0L) {
                     long var13 = 0L;

                     while (var13 < this.f_dbc556da) {
                        var13 += var2.skip(this.f_dbc556da - var13);
                     }
                  }

                  byte[] var32 = new byte[f_c25f7a3b];
                  byte[] var14 = new byte[4];
                  int var15 = 0;

                  while ((var15 = var2.read(var32, 0, var32.length)) != -1) {
                     var11.write(var32, 0, var15);
                     var11.flush();
                     var12.read(var14, 0, var14.length);
                     this.f_dbc556da += (long)var15;
                     this.m_1058ed9a();
                  }
               } catch (Exception var26) {
                  var3 = var26;
               } finally {
                  try {
                     if (var2 != null) {
                        var2.close();
                     }

                     this.f_5724d0c0.close();
                  } catch (Exception var24) {
                  }
               }

               this.f_84a2fafa.m_4c9108c9(this, var3);
            }
         )
         .start();
   }

   private void m_1058ed9a() {
      if (this.f_27f6074a > 0L) {
         try {
            Thread.sleep(this.f_27f6074a);
         } catch (InterruptedException var2) {
         }
      }
   }

   public String m_3d3a8736() {
      return this.f_8a6f2139;
   }

   public String m_e07cee76() {
      return this.f_25bcf1bc;
   }

   public String m_d32ebe65() {
      return this.f_494d0915;
   }

   public File m_facf6936() {
      return this.f_e5ae5e4d;
   }

   public int m_f34ec3cf() {
      return this.f_c1f3f4a3;
   }

   public boolean m_297cfef6() {
      return this.f_68a3f703;
   }

   public boolean m_275ab222() {
      return !this.m_297cfef6();
   }

   public long m_3edda337() {
      return this.f_27f6074a;
   }

   public void m_ad6c7e6f(long var1) {
      this.f_27f6074a = var1;
   }

   public long m_c495d695() {
      return this.f_b721d101;
   }

   public long m_88ccf931() {
      return this.f_dbc556da;
   }

   public void m_e12f1e31(long var1) {
      this.f_dbc556da = var1;
   }

   public double m_20206c69() {
      return 100.0 * ((double)this.m_88ccf931() / (double)this.m_c495d695());
   }

   public void m_e4dddc57() {
      try {
         this.f_5724d0c0.close();
      } catch (Exception var2) {
      }
   }

   public long m_8adc505c() {
      long var1 = (System.currentTimeMillis() - this.f_216d3659) / 1000L;
      return var1 <= 0L ? 0L : this.m_88ccf931() / var1;
   }

   public long m_1993b0ec() {
      return this.f_d6f281bc;
   }
}
