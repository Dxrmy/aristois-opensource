package me.deftware.aristois.recovered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public abstract class C0461 implements C0459 {
   public static String f_20890d0c = C0252.bootstrap<"get",34359738457>();
   private static int f_e7cb31bc = 1;
   private static int f_9997d510 = 2;
   private static int f_4ee82a08 = 3;
   private static int f_a5b11f1a = 4;
   private C0462 f_837889d8 = null;
   private C0467 f_19ad3d75 = null;
   private Charset f_70953d15 = null;
   private InetAddress f_962d957c = null;
   private C0458 f_c0b19f6a = null;
   private C0455 f_d4d9b438 = new C0455();
   private long f_a4a1144c = 1000L;
   private Hashtable<String, Hashtable<C0469, C0469>> f_b24b137a = new Hashtable<>();
   private Hashtable<String, String> f_5a0a26fb = new Hashtable<>();
   private C0464 f_caeb7e06 = new C0464(this);
   private int[] f_0adbeebb = null;
   private InetAddress f_0f43a174 = null;
   private boolean f_f707e26b = false;
   private boolean f_97f0f2b5 = false;
   private String f_7fa01aca = C0252.bootstrap<"get",34359738376>();
   private String f_c73462d0 = this.f_7fa01aca;
   private String f_369475f5 = C0252.bootstrap<"get",34359738376>();
   private String f_b47479f8 = C0252.bootstrap<"get",34359738376>();
   private String f_799f80aa = C0252.bootstrap<"get",34359738377>() + f_20890d0c + C0252.bootstrap<"get",34359738378>();
   private String f_afd96e60 = C0252.bootstrap<"get",34359738379>();
   private String f_c062f1c8 = C0252.bootstrap<"get",34359738380>();
   public Socket f_a12ee6b4;

   public C0461() {
   }

   public synchronized void m_3b58d993(String var1) throws IOException, C0460, C0463 {
      C0458 var2 = new C0458(var1);
      this.m_67b50f7a(var2);
   }

   public synchronized void m_c2bb12dd() {
      try {
         this.f_a12ee6b4.close();
      } catch (Exception var2) {
      }
   }

   public synchronized void m_d1cfe1d7(String var1, int var2) throws IOException, C0460, C0463 {
      C0458 var3 = new C0458(var1);
      var3.f_b6a4eb82 = var2;
      this.m_67b50f7a(var3);
   }

   public synchronized void m_221fd95c(String var1, int var2, String var3) throws IOException, C0460, C0463 {
      C0458 var4 = new C0458(var1);
      var4.f_b6a4eb82 = var2;
      var4.f_73fabc0f = var3;
      this.m_67b50f7a(var4);
   }

   public synchronized void m_67b50f7a(C0458 var1) throws IOException, C0460, C0463 {
      C0458 var2 = var1.m_e4138661();
      this.f_c0b19f6a = var2;
      if (this.m_5abb862d()) {
         throw new IOException(C0252.bootstrap<"get",34359738381>());
      } else {
         this.m_d9c95d26();
         if (var2.f_68d8816b) {
            try {
               SSLSocketFactory var3;
               if (var2.f_bd2232b8) {
                  var3 = C0141.f_f303b426.m_137f1c2e();
               } else {
                  SSLContext var4 = C0114.bootstrap<"call",0,1>();
                  var3 = var4.getSocketFactory();
               }

               this.f_a12ee6b4 = var3.createSocket(var2.f_6d3aab30, var2.f_b6a4eb82);
            } catch (Exception var15) {
               throw new IOException(C0252.bootstrap<"get",34359738382>());
            }
         } else {
            this.f_a12ee6b4 = new Socket(var2.f_6d3aab30, var2.f_b6a4eb82);
         }

         this.m_bcb5e24a(C0252.bootstrap<"get",34359738383>());
         this.f_962d957c = this.f_a12ee6b4.getLocalAddress();
         Object var16 = null;
         Object var18 = null;
         if (this.m_21d6ca75() != null) {
            var16 = new InputStreamReader(this.f_a12ee6b4.getInputStream(), this.m_21d6ca75());
            var18 = new OutputStreamWriter(this.f_a12ee6b4.getOutputStream(), this.m_21d6ca75());
         } else {
            var16 = new InputStreamReader(this.f_a12ee6b4.getInputStream());
            var18 = new OutputStreamWriter(this.f_a12ee6b4.getOutputStream());
         }

         BufferedReader var5 = new BufferedReader((Reader)var16);
         BufferedWriter var6 = new BufferedWriter((Writer)var18);
         if (var2.f_73fabc0f != null && !var2.f_73fabc0f.equals("")) {
            C0114.bootstrap<"call",1,1>(this, var6, C0252.bootstrap<"get",34359738384>() + var2.f_73fabc0f);
         }

         String var7 = this.m_28441b4a();
         C0114.bootstrap<"call",1,1>(this, var6, C0252.bootstrap<"get",34359738385>() + var7);
         C0114.bootstrap<"call",1,1>(
            this, var6, C0252.bootstrap<"get",34359738386>() + this.m_45a6edb9() + C0252.bootstrap<"get",34359738387>() + this.m_d9b50440()
         );
         String var8 = C0114.bootstrap<"call",2,1>();
         String var9 = C0114.bootstrap<"call",3,1>();
         if (!C0114.bootstrap<"call",4,1>().m_ad827dd3().m_6148d8ac()) {
            var8 = this.f_7fa01aca;
            var9 = C0252.bootstrap<"get",34359738388>();
         }

         C0114.bootstrap<"call",1,1>(this, var6, C0252.bootstrap<"get",34359738389>() + var8);
         C0114.bootstrap<"call",1,1>(this, var6, C0252.bootstrap<"get",34359738390>() + var9);
         C0114.bootstrap<"call",1,1>(this, var6, C0252.bootstrap<"get",34359738391>());
         this.f_837889d8 = new C0462(this, this.f_a12ee6b4, var5, var6);
         String var10 = null;
         int var11 = 1;

         while (true) {
            label78: {
               if ((var10 = var5.readLine()) != null) {
                  this.m_3fcc5bc1(var10);
                  int var12 = var10.indexOf(C0252.bootstrap<"get",70>());
                  int var13 = var10.indexOf(C0252.bootstrap<"get",70>(), var12 + 1);
                  if (var13 < 0) {
                     break label78;
                  }

                  String var14 = var10.substring(var12 + 1, var13);
                  if (!var14.equals(C0252.bootstrap<"get",34359738392>())) {
                     if (var14.equals(C0252.bootstrap<"get",34359738393>())) {
                        if (!this.f_f707e26b) {
                           this.f_a12ee6b4.close();
                           this.f_837889d8 = null;
                           throw new C0463(var10);
                        }

                        var7 = this.m_28441b4a() + ++var11;
                        C0114.bootstrap<"call",1,1>(this, var6, C0252.bootstrap<"get",34359738385>() + var7);
                     } else if (!var14.equals(C0252.bootstrap<"get",34359738394>())
                        && (var14.startsWith(C0252.bootstrap<"get",34359738395>()) || var14.startsWith(C0252.bootstrap<"get",34359738396>()))) {
                        this.f_a12ee6b4.close();
                        this.f_837889d8 = null;
                        throw new C0460(C0252.bootstrap<"get",34359738397>() + var10);
                     }
                     break label78;
                  }
               }

               this.m_bcb5e24a(C0252.bootstrap<"get",34359738398>());
               this.f_a12ee6b4.setSoTimeout(300000);
               this.f_837889d8.start();
               if (this.f_19ad3d75 == null) {
                  this.f_19ad3d75 = new C0467(this, this.f_d4d9b438);
                  this.f_19ad3d75.start();
               }

               this.m_c0b2eb96();
               return;
            }

            this.m_b232f92c(var7);
         }
      }
   }

   public synchronized void m_5eac605e() throws IOException, C0460, C0463 {
      if (this.m_9a6826ae() == null) {
         throw new C0460(C0252.bootstrap<"get",34359738399>());
      } else {
         this.m_67b50f7a(this.f_c0b19f6a);
      }
   }

   public synchronized void m_c51a0226() {
      this.m_b2293e38();
   }

   public void m_c303bbd1(boolean var1) {
      this.f_f707e26b = var1;
   }

   public void m_788fcb3f() {
      new C0465(this, this.m_267732f6());
   }

   public void m_24beaa21(String var1) {
      this.m_e767097e(C0252.bootstrap<"get",34359738400>() + var1);
   }

   public void m_2ca91c22(String var1, String var2) {
      this.m_24beaa21(var1 + C0252.bootstrap<"get",70>() + var2);
   }

   public void m_82f65abd(String var1) {
      this.m_e767097e(C0252.bootstrap<"get",34359738401>() + var1);
   }

   public void m_cfc9cfa3(String var1, String var2) {
      this.m_e767097e(C0252.bootstrap<"get",34359738401>() + var1 + C0252.bootstrap<"get",34359738402>() + var2);
   }

   public void m_b2293e38() {
      this.m_5d7051a7("");
   }

   public void m_5d7051a7(String var1) {
      this.m_e767097e(C0252.bootstrap<"get",34359738403>() + var1);
   }

   public synchronized void m_e767097e(String var1) {
      if (this.m_5abb862d()) {
         this.f_837889d8.m_ed2d6353(var1);
      }
   }

   public synchronized void m_77aa7f87(String var1) {
      if (var1 == null) {
         throw new NullPointerException(C0252.bootstrap<"get",34359738404>());
      } else {
         if (this.m_5abb862d()) {
            this.f_d4d9b438.m_bd4aa2cc(var1);
         }
      }
   }

   public void m_8cfb0041(String var1, String var2) {
      this.f_d4d9b438.m_bd4aa2cc(C0252.bootstrap<"get",34359738405>() + var1 + C0252.bootstrap<"get",34359738402>() + var2);
   }

   public void m_9e9f7245(String var1, String var2) {
      this.m_ce0210e2(var1, C0252.bootstrap<"get",34359738406>() + var2);
   }

   public void m_f681d78d(String var1, String var2) {
      this.f_d4d9b438.m_bd4aa2cc(C0252.bootstrap<"get",34359738407>() + var1 + C0252.bootstrap<"get",34359738402>() + var2);
   }

   public void m_ce0210e2(String var1, String var2) {
      this.f_d4d9b438
         .m_bd4aa2cc(C0252.bootstrap<"get",34359738405>() + var1 + C0252.bootstrap<"get",34359738408>() + var2 + C0252.bootstrap<"get",34359738409>());
   }

   public void m_32eecffc(String var1) {
      this.m_e767097e(C0252.bootstrap<"get",34359738385>() + var1);
   }

   public void m_44ecb222(String var1) {
      this.m_e767097e(C0252.bootstrap<"get",34359738410>() + var1);
   }

   public void m_5d11ee53(String var1, String var2) {
      this.m_e767097e(C0252.bootstrap<"get",34359738411>() + var1 + C0252.bootstrap<"get",70>() + var2);
   }

   public void m_e3babeb4(String var1, String var2) {
      this.m_e767097e(C0252.bootstrap<"get",34359738412>() + var1 + C0252.bootstrap<"get",34359738402>() + var2);
   }

   public void m_b9fbdaa9(String var1, String var2) {
      this.m_e767097e(C0252.bootstrap<"get",34359738411>() + var1 + C0252.bootstrap<"get",34359738413>() + var2);
   }

   public void m_2310cae3(String var1, String var2) {
      this.m_e767097e(C0252.bootstrap<"get",34359738411>() + var1 + C0252.bootstrap<"get",34359738414>() + var2);
   }

   public void m_323bd9b3(String var1, String var2) {
      this.m_5d11ee53(var1, C0252.bootstrap<"get",34359738415>() + var2);
   }

   public void m_800d87f8(String var1, String var2) {
      this.m_5d11ee53(var1, C0252.bootstrap<"get",34359738416>() + var2);
   }

   public void m_90c5a30f(String var1, String var2) {
      this.m_5d11ee53(var1, C0252.bootstrap<"get",34359738417>() + var2);
   }

   public void m_80da39ce(String var1, String var2) {
      this.m_5d11ee53(var1, C0252.bootstrap<"get",34359738418>() + var2);
   }

   public void m_205dbd93(String var1, String var2) {
      this.m_e767097e(C0252.bootstrap<"get",34359738419>() + var1 + C0252.bootstrap<"get",34359738402>() + var2);
   }

   public void m_bc903cbd(String var1, String var2) {
      this.m_05d85b77(var1, var2, "");
   }

   public void m_05d85b77(String var1, String var2, String var3) {
      this.m_e767097e(C0252.bootstrap<"get",34359738420>() + var1 + C0252.bootstrap<"get",70>() + var2 + C0252.bootstrap<"get",34359738402>() + var3);
   }

   public void m_efcbe7de() {
      this.m_48104971(null);
   }

   public void m_48104971(String var1) {
      if (var1 == null) {
         this.m_e767097e(C0252.bootstrap<"get",34359738421>());
      } else {
         this.m_e767097e(C0252.bootstrap<"get",34359738422>() + var1);
      }
   }

   public C0468 m_dd0caa7b(File var1, String var2, int var3) {
      C0468 var4 = new C0468(this, this.f_caeb7e06, var1, var2, var3);
      var4.m_73180361(true);
      return var4;
   }

   @Deprecated
   protected void m_3c87fa22(File var1, long var2, int var4, int var5) {
      throw new RuntimeException(C0252.bootstrap<"get",34359738423>());
   }

   public C0456 m_f165c6f2(String var1, int var2) {
      C0456 var3 = null;

      try {
         ServerSocket var4 = null;
         int[] var5 = this.m_b6a3faa3();
         if (var5 == null) {
            var4 = new ServerSocket(0);
         } else {
            for (int var9 : var5) {
               try {
                  var4 = new ServerSocket(var9);
                  break;
               } catch (Exception var12) {
               }
            }

            if (var4 == null) {
               throw new IOException(C0252.bootstrap<"get",30064771189>());
            }
         }

         var4.setSoTimeout(var2);
         int var14 = var4.getLocalPort();
         InetAddress var15 = this.m_2609e004();
         if (var15 == null) {
            var15 = this.m_ae8bc5b6();
         }

         byte[] var16 = var15.getAddress();
         long var17 = this.m_685d082e(var16);
         this.m_ce0210e2(var1, C0252.bootstrap<"get",34359738424>() + var17 + C0252.bootstrap<"get",70>() + var14);
         Socket var11 = var4.accept();
         var4.close();
         var3 = new C0456(this, var1, var11);
      } catch (Exception var13) {
      }

      return var3;
   }

   @Deprecated
   protected C0456 m_95d28fa3(String var1, long var2, int var4) {
      throw new RuntimeException(C0252.bootstrap<"get",34359738425>());
   }

   public void m_bcb5e24a(String var1) {
      if (this.f_97f0f2b5) {
         System.out.println(C0114.bootstrap<"call",0,1>() + C0252.bootstrap<"get",70>() + var1);
      }
   }

   protected void m_3fcc5bc1(String var1) {
      this.m_bcb5e24a(var1);
      if (var1.startsWith(C0252.bootstrap<"get",34359738373>())) {
         this.m_f80a1025(var1.substring(5));
      } else {
         String var2 = "";
         String var3 = "";
         String var4 = "";
         StringTokenizer var5 = new StringTokenizer(var1);
         String var6 = var5.nextToken();
         String var7 = var5.nextToken();
         String var8 = null;
         int var9 = var6.indexOf(C0252.bootstrap<"get",24>());
         int var10 = var6.indexOf(C0252.bootstrap<"get",34359738426>());
         if (var6.startsWith(C0252.bootstrap<"get",25769803903>())) {
            if (var9 > 0 && var10 > 0 && var9 < var10) {
               var2 = var6.substring(1, var9);
               var3 = var6.substring(var9 + 1, var10);
               var4 = var6.substring(var10 + 1);
            } else {
               if (!var5.hasMoreTokens()) {
                  this.m_771411dd(var1);
                  return;
               }

               int var11 = -1;

               try {
                  var11 = C0114.bootstrap<"call",0,1>(var7);
               } catch (NumberFormatException var13) {
               }

               if (var11 != -1) {
                  String var12 = var1.substring(var1.indexOf(var7, var6.length()) + 4);
                  this.m_3f9f60ce(var11, var12);
                  return;
               }

               var2 = var6;
               var8 = var7;
            }
         }

         var7 = var7.toUpperCase();
         if (var2.startsWith(C0252.bootstrap<"get",25769803903>())) {
            var2 = var2.substring(1);
         }

         if (var8 == null) {
            var8 = var5.nextToken();
         }

         if (var8.startsWith(C0252.bootstrap<"get",25769803903>())) {
            var8 = var8.substring(1);
         }

         if (var7.equals(C0252.bootstrap<"get",34359738427>())
            && var1.indexOf(C0252.bootstrap<"get",34359738428>()) > 0
            && var1.endsWith(C0252.bootstrap<"get",34359738409>())) {
            String var18 = var1.substring(var1.indexOf(C0252.bootstrap<"get",34359738428>()) + 2, var1.length() - 1);
            if (var18.equals(C0252.bootstrap<"get",34359738429>())) {
               this.m_f4d65264(var2, var3, var4, var8);
            } else if (var18.startsWith(C0252.bootstrap<"get",34359738406>())) {
               this.m_daa1e7f4(var2, var3, var4, var8, var18.substring(7));
            } else if (var18.startsWith(C0252.bootstrap<"get",34359738373>())) {
               this.m_a170d120(var2, var3, var4, var8, var18.substring(5));
            } else if (var18.equals(C0252.bootstrap<"get",34359738430>())) {
               this.m_d91e417d(var2, var3, var4, var8);
            } else if (var18.equals(C0252.bootstrap<"get",34359738431>())) {
               this.m_7f58bcb5(var2, var3, var4, var8);
            } else if ((var5 = new StringTokenizer(var18)).countTokens() >= 5 && var5.nextToken().equals(C0252.bootstrap<"get",34359738432>())) {
               boolean var19 = this.f_caeb7e06.m_4e28377a(var2, var3, var4, var18);
               if (!var19) {
                  this.m_771411dd(var1);
               }
            } else {
               this.m_771411dd(var1);
            }
         } else if (var7.equals(C0252.bootstrap<"get",34359738427>()) && this.f_c062f1c8.indexOf(var8.charAt(0)) >= 0) {
            this.m_fd7c8d96(var8, var2, var3, var4, var1.substring(var1.indexOf(C0252.bootstrap<"get",34359738402>()) + 2));
         } else if (var7.equals(C0252.bootstrap<"get",34359738427>())) {
            this.m_c70b6cdf(var2, var3, var4, var1.substring(var1.indexOf(C0252.bootstrap<"get",34359738402>()) + 2));
         } else if (var7.equals(C0252.bootstrap<"get",34359738433>())) {
            this.m_02cd88d8(var8, new C0469("", var2));
            this.m_53161e1b(var8, var2, var3, var4);
         } else if (var7.equals(C0252.bootstrap<"get",34359738434>())) {
            this.m_2315c8c7(var8, var2);
            if (var2.equals(this.m_78cdc2e8())) {
               this.m_8644a482(var8);
            }

            this.m_f9901b74(var8, var2, var3, var4);
         } else if (var7.equals(C0252.bootstrap<"get",34359738435>())) {
            this.m_b190af69(var2, var8);
            if (var2.equals(this.m_78cdc2e8())) {
               this.m_b232f92c(var8);
            }

            this.m_0fffa8fe(var2, var3, var4, var8);
         } else if (var7.equals(C0252.bootstrap<"get",34359738436>())) {
            this.m_617f01a3(var2, var3, var4, var8, var1.substring(var1.indexOf(C0252.bootstrap<"get",34359738402>()) + 2));
         } else if (var7.equals(C0252.bootstrap<"get",34359738437>())) {
            if (var2.equals(this.m_78cdc2e8())) {
               this.m_d9c95d26();
            } else {
               this.m_d6820e3d(var2);
            }

            this.m_2202a94d(var2, var3, var4, var1.substring(var1.indexOf(C0252.bootstrap<"get",34359738402>()) + 2));
         } else if (var7.equals(C0252.bootstrap<"get",34359738438>())) {
            String var16 = var5.nextToken();
            if (var16.equals(this.m_78cdc2e8())) {
               this.m_8644a482(var8);
            }

            this.m_2315c8c7(var8, var16);
            this.m_316f5643(var8, var2, var3, var4, var16, var1.substring(var1.indexOf(C0252.bootstrap<"get",34359738402>()) + 2));
         } else if (var7.equals(C0252.bootstrap<"get",34359738439>())) {
            String var17 = var1.substring(var1.indexOf(var8, 2) + var8.length() + 1);
            if (var17.startsWith(C0252.bootstrap<"get",25769803903>())) {
               var17 = var17.substring(1);
            }

            this.m_5e1abd60(var8, var2, var3, var4, var17);
         } else if (var7.equals(C0252.bootstrap<"get",34359738440>())) {
            this.m_f9785c86(var8, var1.substring(var1.indexOf(C0252.bootstrap<"get",34359738402>()) + 2), var2, C0114.bootstrap<"call",1,1>(), true);
         } else if (var7.equals(C0252.bootstrap<"get",34359738441>())) {
            this.m_d39c4997(var8, var2, var3, var4, var1.substring(var1.indexOf(C0252.bootstrap<"get",34359738402>()) + 2));
         } else {
            this.m_771411dd(var1);
         }
      }
   }

   protected void m_c0b2eb96() {
   }

   protected void m_4738ed33() {
   }

   private void m_3f9f60ce(int var1, String var2) {
      if (var1 == 322) {
         int var3 = var2.indexOf(32);
         int var4 = var2.indexOf(32, var3 + 1);
         int var5 = var2.indexOf(32, var4 + 1);
         int var6 = var2.indexOf(58);
         String var7 = var2.substring(var3 + 1, var4);
         int var8 = 0;

         try {
            var8 = C0114.bootstrap<"call",5,1>(var2.substring(var4 + 1, var5));
         } catch (NumberFormatException var11) {
         }

         String var9 = var2.substring(var6 + 1);
         this.m_f1269a30(var7, var8, var9);
      } else if (var1 == 332) {
         int var12 = var2.indexOf(32);
         int var16 = var2.indexOf(32, var12 + 1);
         int var20 = var2.indexOf(58);
         String var23 = var2.substring(var12 + 1, var16);
         String var27 = var2.substring(var20 + 1);
         this.f_5a0a26fb.put(var23, var27);
         this.m_618e8fb3(var23, var27);
      } else if (var1 == 333) {
         StringTokenizer var13 = new StringTokenizer(var2);
         var13.nextToken();
         String var17 = var13.nextToken();
         String var21 = var13.nextToken();
         long var24 = 0L;

         try {
            var24 = C0114.bootstrap<"call",6,1>(var13.nextToken()) * 1000L;
         } catch (NumberFormatException var10) {
         }

         String var29 = this.f_5a0a26fb.get(var17);
         this.f_5a0a26fb.remove(var17);
         this.m_f9785c86(var17, var29, var21, var24, false);
      } else if (var1 == 353) {
         int var14 = var2.indexOf(C0252.bootstrap<"get",34359738402>());
         String var18 = var2.substring(var2.lastIndexOf(32, var14 - 1) + 1, var14);
         StringTokenizer var22 = new StringTokenizer(var2.substring(var2.indexOf(C0252.bootstrap<"get",34359738402>()) + 2));

         while (var22.hasMoreTokens()) {
            String var25 = var22.nextToken();
            String var28 = "";
            if (var25.startsWith(C0252.bootstrap<"get",34359738426>())) {
               var28 = C0252.bootstrap<"get",34359738426>();
            } else if (var25.startsWith(C0252.bootstrap<"get",34359738442>())) {
               var28 = C0252.bootstrap<"get",34359738442>();
            } else if (var25.startsWith(C0252.bootstrap<"get",8589934650>())) {
               var28 = C0252.bootstrap<"get",8589934650>();
            }

            var25 = var25.substring(var28.length());
            this.m_02cd88d8(var18, new C0469(var28, var25));
         }
      } else if (var1 == 366) {
         String var15 = var2.substring(var2.indexOf(32) + 1, var2.indexOf(C0252.bootstrap<"get",34359738402>()));
         C0469[] var19 = this.m_11b1a0e5(var15);
         this.m_2db0bbe0(var15, var19);
      }

      this.m_670bcd46(var1, var2);
   }

   protected void m_670bcd46(int var1, String var2) {
   }

   protected void m_2db0bbe0(String var1, C0469[] var2) {
   }

   protected void m_fd7c8d96(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_c70b6cdf(String var1, String var2, String var3, String var4) {
   }

   protected void m_daa1e7f4(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_617f01a3(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_53161e1b(String var1, String var2, String var3, String var4) {
   }

   protected void m_f9901b74(String var1, String var2, String var3, String var4) {
   }

   protected void m_0fffa8fe(String var1, String var2, String var3, String var4) {
   }

   protected void m_316f5643(String var1, String var2, String var3, String var4, String var5, String var6) {
   }

   protected void m_2202a94d(String var1, String var2, String var3, String var4) {
   }

   @Deprecated
   protected void m_618e8fb3(String var1, String var2) {
   }

   protected void m_f9785c86(String var1, String var2, String var3, long var4, boolean var6) {
   }

   protected void m_f1269a30(String var1, int var2, String var3) {
   }

   private void m_5e1abd60(String var1, String var2, String var3, String var4, String var5) {
      if (this.f_c062f1c8.indexOf(var1.charAt(0)) >= 0) {
         StringTokenizer var6 = new StringTokenizer(var5);
         String[] var7 = new String[var6.countTokens()];

         for (int var8 = 0; var6.hasMoreTokens(); var8++) {
            var7[var8] = var6.nextToken();
         }

         char var9 = ' ';
         int var10 = 1;

         for (int var11 = 0; var11 < var7[0].length(); var11++) {
            char var12 = var7[0].charAt(var11);
            if (var12 == '+' || var12 == '-') {
               var9 = var12;
            } else if (var12 == 'o') {
               if (var9 == '+') {
                  this.m_974dfa97(var1, f_e7cb31bc, var7[var10]);
                  this.m_da51a624(var1, var2, var3, var4, var7[var10]);
               } else {
                  this.m_974dfa97(var1, f_9997d510, var7[var10]);
                  this.m_71bd4b23(var1, var2, var3, var4, var7[var10]);
               }

               var10++;
            } else if (var12 == 'v') {
               if (var9 == '+') {
                  this.m_974dfa97(var1, f_4ee82a08, var7[var10]);
                  this.m_9e95fadb(var1, var2, var3, var4, var7[var10]);
               } else {
                  this.m_974dfa97(var1, f_a5b11f1a, var7[var10]);
                  this.m_a480c7fa(var1, var2, var3, var4, var7[var10]);
               }

               var10++;
            } else if (var12 == 'k') {
               if (var9 == '+') {
                  this.m_14163f11(var1, var2, var3, var4, var7[var10]);
               } else {
                  this.m_46a747d0(var1, var2, var3, var4, var7[var10]);
               }

               var10++;
            } else if (var12 == 'l') {
               if (var9 == '+') {
                  this.m_7eb2064f(var1, var2, var3, var4, C0114.bootstrap<"call",0,1>(var7[var10]));
                  var10++;
               } else {
                  this.m_5308bc4d(var1, var2, var3, var4);
               }
            } else if (var12 == 'b') {
               if (var9 == '+') {
                  this.m_eaf6cbbf(var1, var2, var3, var4, var7[var10]);
               } else {
                  this.m_44c81bf9(var1, var2, var3, var4, var7[var10]);
               }

               var10++;
            } else if (var12 == 't') {
               if (var9 == '+') {
                  this.m_1e3cbffa(var1, var2, var3, var4);
               } else {
                  this.m_43680fc2(var1, var2, var3, var4);
               }
            } else if (var12 == 'n') {
               if (var9 == '+') {
                  this.m_d9651e75(var1, var2, var3, var4);
               } else {
                  this.m_aaf838a8(var1, var2, var3, var4);
               }
            } else if (var12 == 'i') {
               if (var9 == '+') {
                  this.m_b20b96fe(var1, var2, var3, var4);
               } else {
                  this.m_5fed7553(var1, var2, var3, var4);
               }
            } else if (var12 == 'm') {
               if (var9 == '+') {
                  this.m_c8444fea(var1, var2, var3, var4);
               } else {
                  this.m_0511037b(var1, var2, var3, var4);
               }
            } else if (var12 == 'p') {
               if (var9 == '+') {
                  this.m_8c607aa3(var1, var2, var3, var4);
               } else {
                  this.m_e6596abb(var1, var2, var3, var4);
               }
            } else if (var12 == 's') {
               if (var9 == '+') {
                  this.m_d384b042(var1, var2, var3, var4);
               } else {
                  this.m_792ce22d(var1, var2, var3, var4);
               }
            }
         }

         this.m_386fa8f7(var1, var2, var3, var4, var5);
      } else {
         this.m_e6fbdfc7(var1, var2, var3, var4, var5);
      }
   }

   protected void m_386fa8f7(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_e6fbdfc7(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_da51a624(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_71bd4b23(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_9e95fadb(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_a480c7fa(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_14163f11(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_46a747d0(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_7eb2064f(String var1, String var2, String var3, String var4, int var5) {
   }

   protected void m_5308bc4d(String var1, String var2, String var3, String var4) {
   }

   protected void m_eaf6cbbf(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_44c81bf9(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_1e3cbffa(String var1, String var2, String var3, String var4) {
   }

   protected void m_43680fc2(String var1, String var2, String var3, String var4) {
   }

   protected void m_d9651e75(String var1, String var2, String var3, String var4) {
   }

   protected void m_aaf838a8(String var1, String var2, String var3, String var4) {
   }

   protected void m_b20b96fe(String var1, String var2, String var3, String var4) {
   }

   protected void m_5fed7553(String var1, String var2, String var3, String var4) {
   }

   protected void m_c8444fea(String var1, String var2, String var3, String var4) {
   }

   protected void m_0511037b(String var1, String var2, String var3, String var4) {
   }

   protected void m_8c607aa3(String var1, String var2, String var3, String var4) {
   }

   protected void m_e6596abb(String var1, String var2, String var3, String var4) {
   }

   protected void m_d384b042(String var1, String var2, String var3, String var4) {
   }

   protected void m_792ce22d(String var1, String var2, String var3, String var4) {
   }

   protected void m_d39c4997(String var1, String var2, String var3, String var4, String var5) {
   }

   @Deprecated
   protected void m_ba62706e(String var1, String var2, String var3, String var4, long var5, int var7, int var8) {
   }

   @Deprecated
   protected void m_fe2713bb(String var1, String var2, String var3, long var4, int var6) {
   }

   protected void m_5fa4ada6(C0468 var1) {
   }

   protected void m_a938a984(C0468 var1, Exception var2) {
   }

   protected void m_45c0a98e(C0456 var1) {
   }

   protected void m_f4d65264(String var1, String var2, String var3, String var4) {
      this.m_e767097e(
         C0252.bootstrap<"get",34359738407>() + var1 + C0252.bootstrap<"get",34359738443>() + this.f_799f80aa + C0252.bootstrap<"get",34359738409>()
      );
   }

   protected void m_a170d120(String var1, String var2, String var3, String var4, String var5) {
      this.m_e767097e(C0252.bootstrap<"get",34359738407>() + var1 + C0252.bootstrap<"get",34359738444>() + var5 + C0252.bootstrap<"get",34359738409>());
   }

   protected void m_f80a1025(String var1) {
      this.m_e767097e(C0252.bootstrap<"get",34359738445>() + var1);
   }

   protected void m_d91e417d(String var1, String var2, String var3, String var4) {
      this.m_e767097e(
         C0252.bootstrap<"get",34359738407>() + var1 + C0252.bootstrap<"get",34359738446>() + new Date().toString() + C0252.bootstrap<"get",34359738409>()
      );
   }

   protected void m_7f58bcb5(String var1, String var2, String var3, String var4) {
      this.m_e767097e(
         C0252.bootstrap<"get",34359738407>() + var1 + C0252.bootstrap<"get",34359738447>() + this.f_afd96e60 + C0252.bootstrap<"get",34359738409>()
      );
   }

   protected void m_771411dd(String var1) {
   }

   public void m_e655e826(boolean var1) {
      this.f_97f0f2b5 = var1;
   }

   public String m_28441b4a() {
      return this.f_7fa01aca;
   }

   protected void m_b0c8e9b5(String var1) {
      this.f_7fa01aca = var1;
   }

   public String m_78cdc2e8() {
      return this.f_c73462d0;
   }

   public void m_b232f92c(String var1) {
      this.f_c73462d0 = var1;
   }

   @Deprecated
   public String m_267732f6() {
      return this.f_369475f5;
   }

   @Deprecated
   protected void m_2549a480(String var1) {
      this.f_369475f5 = var1;
   }

   public String m_45a6edb9() {
      return this.f_369475f5;
   }

   protected void m_6feb9689(String var1) {
      this.f_369475f5 = var1;
   }

   public String m_d9b50440() {
      return this.f_b47479f8;
   }

   protected void m_a2a3a8ef(String var1) {
      this.f_b47479f8 = var1;
   }

   public String m_e6c03e0a() {
      return this.f_799f80aa;
   }

   protected void m_980b3587(String var1) {
      this.f_799f80aa = var1;
   }

   public String m_b1b1be73() {
      return this.f_afd96e60;
   }

   protected void m_f63d8039(String var1) {
      this.f_afd96e60 = var1;
   }

   public synchronized boolean m_5abb862d() {
      return this.f_837889d8 != null && this.f_837889d8.m_f82663c6();
   }

   public long m_280a22b3() {
      return this.f_a4a1144c;
   }

   public void m_361e80c1(long var1) {
      if (var1 < 0L) {
         throw new IllegalArgumentException(C0252.bootstrap<"get",34359738448>());
      } else {
         this.f_a4a1144c = var1;
      }
   }

   public int m_ee3300f9() {
      return C0462.f_d7c459a1;
   }

   public int m_22013da7() {
      return this.f_d4d9b438.m_f3b1fb04();
   }

   public String m_9a6826ae() {
      return this.f_c0b19f6a == null ? null : this.f_c0b19f6a.f_6d3aab30;
   }

   public int m_4ef27e41() {
      return this.f_c0b19f6a == null ? -1 : this.f_c0b19f6a.f_b6a4eb82;
   }

   public boolean m_6dbf642f() {
      return this.f_c0b19f6a == null ? false : this.f_c0b19f6a.f_68d8816b;
   }

   public String m_6bd53684() {
      return this.f_c0b19f6a == null ? null : this.f_c0b19f6a.f_73fabc0f;
   }

   public int[] m_45e74680(long var1) {
      int[] var3 = new int[4];

      for (int var4 = 3; var4 >= 0; var4--) {
         var3[var4] = (int)(var1 % 256L);
         var1 /= 256L;
      }

      return var3;
   }

   public long m_685d082e(byte[] var1) {
      if (var1.length != 4) {
         throw new IllegalArgumentException(C0252.bootstrap<"get",34359738449>());
      } else {
         long var2 = 0L;
         long var4 = 1L;

         for (int var6 = 3; var6 >= 0; var6--) {
            int var7 = (var1[var6] + 256) % 256;
            var2 += (long)var7 * var4;
            var4 *= 256L;
         }

         return var2;
      }
   }

   public Charset m_21d6ca75() {
      return this.f_70953d15;
   }

   public void m_991d18e3(Charset var1) {
      this.f_70953d15 = var1;
   }

   public InetAddress m_ae8bc5b6() {
      return this.f_962d957c;
   }

   public InetAddress m_2609e004() {
      return this.f_0f43a174;
   }

   public void m_3cdfd86a(InetAddress var1) {
      this.f_0f43a174 = var1;
   }

   public int[] m_b6a3faa3() {
      return this.f_0adbeebb != null && this.f_0adbeebb.length != 0 ? (int[])this.f_0adbeebb.clone() : null;
   }

   public void m_d6c55819(int[] var1) {
      if (var1 != null && var1.length != 0) {
         this.f_0adbeebb = (int[])var1.clone();
      } else {
         this.f_0adbeebb = null;
      }
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof C0461) {
         C0461 var2 = (C0461)var1;
         return var2 == this;
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",34359738450>()
         + this.m_e6c03e0a()
         + C0252.bootstrap<"get",34359738451>()
         + this.m_5abb862d()
         + C0252.bootstrap<"get",34359738452>()
         + this.m_9a6826ae()
         + C0252.bootstrap<"get",34359738453>()
         + this.m_4ef27e41()
         + C0252.bootstrap<"get",34359738454>()
         + this.m_6bd53684()
         + C0252.bootstrap<"get",34359738455>();
   }

   public C0469[] m_11b1a0e5(String var1) {
      var1 = var1.toLowerCase();
      C0469[] var2 = new C0469[0];
      synchronized (this.f_b24b137a) {
         Hashtable var4 = this.f_b24b137a.get(var1);
         if (var4 != null) {
            var2 = new C0469[var4.size()];
            Enumeration var5 = var4.elements();

            for (int var6 = 0; var6 < var2.length; var6++) {
               C0469 var7 = (C0469)var5.nextElement();
               var2[var6] = var7;
            }
         }

         return var2;
      }
   }

   public String[] m_2a44b365() {
      synchronized (this.f_b24b137a) {
         String[] var1 = new String[this.f_b24b137a.size()];
         Enumeration var3 = this.f_b24b137a.keys();

         for (int var4 = 0; var4 < var1.length; var4++) {
            var1[var4] = (String)var3.nextElement();
         }

         return var1;
      }
   }

   public synchronized void m_6505c55d() {
      this.f_19ad3d75.interrupt();
      this.f_837889d8.m_104491ac();
   }

   private void m_02cd88d8(String var1, C0469 var2) {
      var1 = var1.toLowerCase();
      synchronized (this.f_b24b137a) {
         Hashtable var4 = this.f_b24b137a.computeIfAbsent(var1, var0 -> new Hashtable<>());
         var4.put(var2, var2);
      }
   }

   private C0469 m_2315c8c7(String var1, String var2) {
      var1 = var1.toLowerCase();
      C0469 var3 = new C0469("", var2);
      synchronized (this.f_b24b137a) {
         Hashtable var5 = this.f_b24b137a.get(var1);
         return var5 != null ? (C0469)var5.remove(var3) : null;
      }
   }

   private void m_d6820e3d(String var1) {
      synchronized (this.f_b24b137a) {
         Enumeration var3 = this.f_b24b137a.keys();

         while (var3.hasMoreElements()) {
            String var4 = (String)var3.nextElement();
            this.m_2315c8c7(var4, var1);
         }
      }
   }

   private void m_b190af69(String var1, String var2) {
      synchronized (this.f_b24b137a) {
         Enumeration var4 = this.f_b24b137a.keys();

         while (var4.hasMoreElements()) {
            String var5 = (String)var4.nextElement();
            C0469 var6 = this.m_2315c8c7(var5, var1);
            if (var6 != null) {
               var6 = new C0469(var6.m_e9d1d980(), var2);
               this.m_02cd88d8(var5, var6);
            }
         }
      }
   }

   private void m_8644a482(String var1) {
      var1 = var1.toLowerCase();
      synchronized (this.f_b24b137a) {
         this.f_b24b137a.remove(var1);
      }
   }

   private void m_d9c95d26() {
      synchronized (this.f_b24b137a) {
         this.f_b24b137a = new Hashtable<>();
      }
   }

   private void m_974dfa97(String var1, int var2, String var3) {
      var1 = var1.toLowerCase();
      synchronized (this.f_b24b137a) {
         Hashtable var5 = this.f_b24b137a.get(var1);
         C0469 var6 = null;
         if (var5 != null) {
            Enumeration var7 = var5.elements();

            while (var7.hasMoreElements()) {
               C0469 var8 = (C0469)var7.nextElement();
               if (var8.m_1c498a6a().equalsIgnoreCase(var3)) {
                  if (var2 == f_e7cb31bc) {
                     if (var8.m_4a258b9d()) {
                        var6 = new C0469(C0252.bootstrap<"get",34359738456>(), var3);
                     } else {
                        var6 = new C0469(C0252.bootstrap<"get",34359738426>(), var3);
                     }
                  } else if (var2 == f_9997d510) {
                     if (var8.m_4a258b9d()) {
                        var6 = new C0469(C0252.bootstrap<"get",34359738442>(), var3);
                     } else {
                        var6 = new C0469("", var3);
                     }
                  } else if (var2 == f_4ee82a08) {
                     if (var8.m_3c73add0()) {
                        var6 = new C0469(C0252.bootstrap<"get",34359738456>(), var3);
                     } else {
                        var6 = new C0469(C0252.bootstrap<"get",34359738442>(), var3);
                     }
                  } else if (var2 == f_a5b11f1a) {
                     if (var8.m_3c73add0()) {
                        var6 = new C0469(C0252.bootstrap<"get",34359738426>(), var3);
                     } else {
                        var6 = new C0469("", var3);
                     }
                  }
               }
            }
         }

         if (var6 != null) {
            var5.put(var6, var6);
         } else {
            var6 = new C0469("", var3);
            if (var5 != null) {
               var5.put(var6, var6);
            }
         }
      }
   }
}
