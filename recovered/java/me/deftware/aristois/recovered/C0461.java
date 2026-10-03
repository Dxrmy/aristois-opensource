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
import me.deftware.client.framework.helper.SessionHelper;

public abstract class C0461 implements C0459 {
   public static String f_01c466f3 = C0262.m_1b17f04f();
   private static int f_12c731a5 = 1;
   private static int f_ef6e14cf = 2;
   private static int f_50dffce6 = 3;
   private static int f_be966e12 = 4;
   private C0462 f_bb7f25fe = null;
   private C0467 f_448d408d = null;
   private Charset f_3834da64 = null;
   private InetAddress f_033a865e = null;
   private C0458 f_fc40bced = null;
   private C0455 f_8481f66b = new C0455();
   private long f_ac3b7c72 = 1000L;
   private Hashtable<String, Hashtable<C0469, C0469>> f_44342628 = new Hashtable<>();
   private Hashtable<String, String> f_a7d43774 = new Hashtable<>();
   private C0464 f_bf73e688 = new C0464(this);
   private int[] f_ce48e4cb = null;
   private InetAddress f_60b7ca25 = null;
   private boolean f_133ab3a5 = false;
   private boolean f_75ce9a68 = false;
   private String f_2fcf7d19 = C0262.m_8d7dbe31();
   private String f_6592e3f5 = this.f_2fcf7d19;
   private String f_1bda1989 = C0262.m_8d7dbe31();
   private String f_de6e1ca1 = C0262.m_8d7dbe31();
   private String f_284ae98f = C0262.m_1d87ef21() + f_01c466f3 + C0262.m_c42f1c7e();
   private String f_d1201420 = C0262.m_6f1f396d();
   private String f_b959881b = C0262.m_8ced16bd();
   public Socket f_f16b38e7;

   public C0461() {
   }

   public synchronized void m_256015fc(String var1) throws IOException, C0460, C0463 {
      C0458 var2 = new C0458(var1);
      this.m_ce077c1f(var2);
   }

   public synchronized void m_1058ed9a() {
      try {
         this.f_f16b38e7.close();
      } catch (Exception var2) {
      }
   }

   public synchronized void m_1f5a477c(String var1, int var2) throws IOException, C0460, C0463 {
      C0458 var3 = new C0458(var1);
      var3.f_27871303 = var2;
      this.m_ce077c1f(var3);
   }

   public synchronized void m_bac035b2(String var1, int var2, String var3) throws IOException, C0460, C0463 {
      C0458 var4 = new C0458(var1);
      var4.f_27871303 = var2;
      var4.f_cc78932b = var3;
      this.m_ce077c1f(var4);
   }

   public synchronized void m_ce077c1f(C0458 var1) throws IOException, C0460, C0463 {
      C0458 var2 = var1.m_858f26f6();
      this.f_fc40bced = var2;
      if (this.m_8d50206e()) {
         throw new IOException(C0262.m_15ef1a0d());
      } else {
         this.m_8c12dabd();
         if (var2.f_262c82d8) {
            try {
               SSLSocketFactory var3;
               if (var2.f_52d96364) {
                  var3 = C0141.f_afca7f52.m_f40cad62();
               } else {
                  SSLContext var4 = C0457.m_1c4c6585();
                  var3 = var4.getSocketFactory();
               }

               this.f_f16b38e7 = var3.createSocket(var2.f_d64a3e31, var2.f_27871303);
            } catch (Exception var15) {
               throw new IOException(C0262.m_9793dfe2());
            }
         } else {
            this.f_f16b38e7 = new Socket(var2.f_d64a3e31, var2.f_27871303);
         }

         this.m_e648c663(C0262.m_1635bc47());
         this.f_033a865e = this.f_f16b38e7.getLocalAddress();
         Object var16 = null;
         Object var18 = null;
         if (this.m_19936aa5() != null) {
            var16 = new InputStreamReader(this.f_f16b38e7.getInputStream(), this.m_19936aa5());
            var18 = new OutputStreamWriter(this.f_f16b38e7.getOutputStream(), this.m_19936aa5());
         } else {
            var16 = new InputStreamReader(this.f_f16b38e7.getInputStream());
            var18 = new OutputStreamWriter(this.f_f16b38e7.getOutputStream());
         }

         BufferedReader var5 = new BufferedReader((Reader)var16);
         BufferedWriter var6 = new BufferedWriter((Writer)var18);
         if (var2.f_cc78932b != null && !var2.f_cc78932b.equals("")) {
            C0467.m_9ca91702(this, var6, C0262.m_d597c122() + var2.f_cc78932b);
         }

         String var7 = this.m_c42f1c7e();
         C0467.m_9ca91702(this, var6, C0262.m_18204724() + var7);
         C0467.m_9ca91702(this, var6, C0262.m_cf4f91f1() + this.m_6f1f396d() + C0262.m_b251ca51() + this.m_94acbdac());
         String var8 = SessionHelper.getPlayerUsername();
         String var9 = SessionHelper.getPlayerUUID();
         if (!C0242.m_fc1b642c().m_dc6b6d48().m_e0f7c666()) {
            var8 = this.f_2fcf7d19;
            var9 = C0262.m_b48a8bc4();
         }

         C0467.m_9ca91702(this, var6, C0262.m_b886ae1c() + var8);
         C0467.m_9ca91702(this, var6, C0262.m_bec91365() + var9);
         C0467.m_9ca91702(this, var6, C0262.m_79bfaec2());
         this.f_bb7f25fe = new C0462(this, this.f_f16b38e7, var5, var6);
         String var10 = null;
         int var11 = 1;

         while (true) {
            label78: {
               if ((var10 = var5.readLine()) != null) {
                  this.m_ede76c21(var10);
                  int var12 = var10.indexOf(C0257.m_593ecbab());
                  int var13 = var10.indexOf(C0257.m_593ecbab(), var12 + 1);
                  if (var13 < 0) {
                     break label78;
                  }

                  String var14 = var10.substring(var12 + 1, var13);
                  if (!var14.equals(C0262.m_2e834348())) {
                     if (var14.equals(C0262.m_e07cee76())) {
                        if (!this.f_133ab3a5) {
                           this.f_f16b38e7.close();
                           this.f_bb7f25fe = null;
                           throw new C0463(var10);
                        }

                        var7 = this.m_c42f1c7e() + ++var11;
                        C0467.m_9ca91702(this, var6, C0262.m_18204724() + var7);
                     } else if (!var14.equals(C0262.m_7b0db73e()) && (var14.startsWith(C0262.m_056a389d()) || var14.startsWith(C0262.m_5fa6dd07()))) {
                        this.f_f16b38e7.close();
                        this.f_bb7f25fe = null;
                        throw new C0460(C0262.m_5f1ab561() + var10);
                     }
                     break label78;
                  }
               }

               this.m_e648c663(C0262.m_28b2c020());
               this.f_f16b38e7.setSoTimeout(300000);
               this.f_bb7f25fe.start();
               if (this.f_448d408d == null) {
                  this.f_448d408d = new C0467(this, this.f_8481f66b);
                  this.f_448d408d.start();
               }

               this.m_b728afce();
               return;
            }

            this.m_caa10980(var7);
         }
      }
   }

   public synchronized void m_41e83f88() throws IOException, C0460, C0463 {
      if (this.m_afb31f66() == null) {
         throw new C0460(C0262.m_45aaaba8());
      } else {
         this.m_ce077c1f(this.f_fc40bced);
      }
   }

   public synchronized void m_fd4438d8() {
      this.m_f1ec3ae8();
   }

   public void m_d6ac7420(boolean var1) {
      this.f_133ab3a5 = var1;
   }

   public void m_23674f64() {
      new C0465(this, this.m_4626ac74());
   }

   public void m_a11708c5(String var1) {
      this.m_4f03e646(C0262.m_88937f2b() + var1);
   }

   public void m_e5f08f7c(String var1, String var2) {
      this.m_a11708c5(var1 + C0257.m_593ecbab() + var2);
   }

   public void m_333019c8(String var1) {
      this.m_4f03e646(C0262.m_396f9431() + var1);
   }

   public void m_75cf9ace(String var1, String var2) {
      this.m_4f03e646(C0262.m_396f9431() + var1 + C0262.m_e9914bd3() + var2);
   }

   public void m_f1ec3ae8() {
      this.m_4404c3bc("");
   }

   public void m_4404c3bc(String var1) {
      this.m_4f03e646(C0262.m_8631f87f() + var1);
   }

   public synchronized void m_4f03e646(String var1) {
      if (this.m_8d50206e()) {
         this.f_bb7f25fe.m_256015fc(var1);
      }
   }

   public synchronized void m_9443b5cb(String var1) {
      if (var1 == null) {
         throw new NullPointerException(C0262.m_818e6498());
      } else {
         if (this.m_8d50206e()) {
            this.f_8481f66b.m_360c09fa(var1);
         }
      }
   }

   public void m_715105ec(String var1, String var2) {
      this.f_8481f66b.m_360c09fa(C0262.m_56d4c1c7() + var1 + C0262.m_e9914bd3() + var2);
   }

   public void m_6387b4bd(String var1, String var2) {
      this.m_412d10a2(var1, C0262.m_d32ebe65() + var2);
   }

   public void m_208a2db1(String var1, String var2) {
      this.f_8481f66b.m_360c09fa(C0262.m_afb31f66() + var1 + C0262.m_e9914bd3() + var2);
   }

   public void m_412d10a2(String var1, String var2) {
      this.f_8481f66b.m_360c09fa(C0262.m_56d4c1c7() + var1 + C0262.m_c254a253() + var2 + C0262.m_3d3a8736());
   }

   public void m_119a82d4(String var1) {
      this.m_4f03e646(C0262.m_18204724() + var1);
   }

   public void m_dc55a4fb(String var1) {
      this.m_4f03e646(C0262.m_94acbdac() + var1);
   }

   public void m_ba26de7f(String var1, String var2) {
      this.m_4f03e646(C0262.m_022da1b4() + var1 + C0257.m_593ecbab() + var2);
   }

   public void m_a73c1a93(String var1, String var2) {
      this.m_4f03e646(C0262.m_6e2d03c3() + var1 + C0262.m_e9914bd3() + var2);
   }

   public void m_78a34a68(String var1, String var2) {
      this.m_4f03e646(C0262.m_022da1b4() + var1 + C0262.m_760db7bb() + var2);
   }

   public void m_667995e2(String var1, String var2) {
      this.m_4f03e646(C0262.m_022da1b4() + var1 + C0262.m_68957b31() + var2);
   }

   public void m_0e6043f0(String var1, String var2) {
      this.m_ba26de7f(var1, C0262.m_4e02e7a9() + var2);
   }

   public void m_7089b47b(String var1, String var2) {
      this.m_ba26de7f(var1, C0262.m_7f74d855() + var2);
   }

   public void m_fd9e08e8(String var1, String var2) {
      this.m_ba26de7f(var1, C0262.m_b89b7876() + var2);
   }

   public void m_4854c548(String var1, String var2) {
      this.m_ba26de7f(var1, C0262.m_a33fab52() + var2);
   }

   public void m_b5fe6017(String var1, String var2) {
      this.m_4f03e646(C0262.m_73708dd3() + var1 + C0262.m_e9914bd3() + var2);
   }

   public void m_a4ed82b9(String var1, String var2) {
      this.m_a2c98d40(var1, var2, "");
   }

   public void m_a2c98d40(String var1, String var2, String var3) {
      this.m_4f03e646(C0262.m_96ba50d4() + var1 + C0257.m_593ecbab() + var2 + C0262.m_e9914bd3() + var3);
   }

   public void m_0e389a72() {
      this.m_0f68027c(null);
   }

   public void m_0f68027c(String var1) {
      if (var1 == null) {
         this.m_4f03e646(C0262.m_88726494());
      } else {
         this.m_4f03e646(C0262.m_27479cfa() + var1);
      }
   }

   public C0468 m_892b5477(File var1, String var2, int var3) {
      C0468 var4 = new C0468(this, this.f_bf73e688, var1, var2, var3);
      var4.m_d6ac7420(true);
      return var4;
   }

   @Deprecated
   protected void m_6b8ac054(File var1, long var2, int var4, int var5) {
      throw new RuntimeException(C0262.m_23f794da());
   }

   public C0456 m_f4a64e1c(String var1, int var2) {
      C0456 var3 = null;

      try {
         ServerSocket var4 = null;
         int[] var5 = this.m_9ea7017c();
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
               throw new IOException(C0265.m_8870d2c1());
            }
         }

         var4.setSoTimeout(var2);
         int var14 = var4.getLocalPort();
         InetAddress var15 = this.m_7dba075f();
         if (var15 == null) {
            var15 = this.m_18ff89bb();
         }

         byte[] var16 = var15.getAddress();
         long var17 = this.m_6fa424cb(var16);
         this.m_412d10a2(var1, C0262.m_cc27b633() + var17 + C0257.m_593ecbab() + var14);
         Socket var11 = var4.accept();
         var4.close();
         var3 = new C0456(this, var1, var11);
      } catch (Exception var13) {
      }

      return var3;
   }

   @Deprecated
   protected C0456 m_36cf0940(String var1, long var2, int var4) {
      throw new RuntimeException(C0262.m_df6e621c());
   }

   public void m_e648c663(String var1) {
      if (this.f_75ce9a68) {
         System.out.println(System.currentTimeMillis() + C0257.m_593ecbab() + var1);
      }
   }

   protected void m_ede76c21(String var1) {
      this.m_e648c663(var1);
      if (var1.startsWith(C0262.m_c688f8ca())) {
         this.m_f2135140(var1.substring(5));
      } else {
         String var2 = "";
         String var3 = "";
         String var4 = "";
         StringTokenizer var5 = new StringTokenizer(var1);
         String var6 = var5.nextToken();
         String var7 = var5.nextToken();
         String var8 = null;
         int var9 = var6.indexOf(C0257.m_2e834348());
         int var10 = var6.indexOf(C0262.m_56242a84());
         if (var6.startsWith(C0267.m_0d6ae39b())) {
            if (var9 > 0 && var10 > 0 && var9 < var10) {
               var2 = var6.substring(1, var9);
               var3 = var6.substring(var9 + 1, var10);
               var4 = var6.substring(var10 + 1);
            } else {
               if (!var5.hasMoreTokens()) {
                  this.m_7f49eb10(var1);
                  return;
               }

               int var11 = -1;

               try {
                  var11 = Integer.parseInt(var7);
               } catch (NumberFormatException var13) {
               }

               if (var11 != -1) {
                  String var12 = var1.substring(var1.indexOf(var7, var6.length()) + 4);
                  this.m_d80e39d3(var11, var12);
                  return;
               }

               var2 = var6;
               var8 = var7;
            }
         }

         var7 = var7.toUpperCase();
         if (var2.startsWith(C0267.m_0d6ae39b())) {
            var2 = var2.substring(1);
         }

         if (var8 == null) {
            var8 = var5.nextToken();
         }

         if (var8.startsWith(C0267.m_0d6ae39b())) {
            var8 = var8.substring(1);
         }

         if (var7.equals(C0262.m_9e27f038()) && var1.indexOf(C0262.m_af41331f()) > 0 && var1.endsWith(C0262.m_3d3a8736())) {
            String var18 = var1.substring(var1.indexOf(C0262.m_af41331f()) + 2, var1.length() - 1);
            if (var18.equals(C0262.m_f257bcca())) {
               this.m_8ba810b1(var2, var3, var4, var8);
            } else if (var18.startsWith(C0262.m_d32ebe65())) {
               this.m_86e8bcca(var2, var3, var4, var8, var18.substring(7));
            } else if (var18.startsWith(C0262.m_c688f8ca())) {
               this.m_f72cf5af(var2, var3, var4, var8, var18.substring(5));
            } else if (var18.equals(C0262.m_d9b37a36())) {
               this.m_1164dce1(var2, var3, var4, var8);
            } else if (var18.equals(C0262.m_15737526())) {
               this.m_ea89520d(var2, var3, var4, var8);
            } else if ((var5 = new StringTokenizer(var18)).countTokens() >= 5 && var5.nextToken().equals(C0262.m_6cf615ba())) {
               boolean var19 = this.f_bf73e688.m_2179ee1e(var2, var3, var4, var18);
               if (!var19) {
                  this.m_7f49eb10(var1);
               }
            } else {
               this.m_7f49eb10(var1);
            }
         } else if (var7.equals(C0262.m_9e27f038()) && this.f_b959881b.indexOf(var8.charAt(0)) >= 0) {
            this.m_b8355785(var8, var2, var3, var4, var1.substring(var1.indexOf(C0262.m_e9914bd3()) + 2));
         } else if (var7.equals(C0262.m_9e27f038())) {
            this.m_4570df10(var2, var3, var4, var1.substring(var1.indexOf(C0262.m_e9914bd3()) + 2));
         } else if (var7.equals(C0262.m_ecb46027())) {
            this.m_eb9bd660(var8, new C0469("", var2));
            this.m_aa5d1499(var8, var2, var3, var4);
         } else if (var7.equals(C0262.m_b526dd3b())) {
            this.m_a5dfc9fd(var8, var2);
            if (var2.equals(this.m_e9914bd3())) {
               this.m_96471a3a(var8);
            }

            this.m_a932acb4(var8, var2, var3, var4);
         } else if (var7.equals(C0262.m_9d6ca6d0())) {
            this.m_f9801473(var2, var8);
            if (var2.equals(this.m_e9914bd3())) {
               this.m_caa10980(var8);
            }

            this.m_3afed413(var2, var3, var4, var8);
         } else if (var7.equals(C0262.m_87c16989())) {
            this.m_07a87136(var2, var3, var4, var8, var1.substring(var1.indexOf(C0262.m_e9914bd3()) + 2));
         } else if (var7.equals(C0262.m_b0896de7())) {
            if (var2.equals(this.m_e9914bd3())) {
               this.m_8c12dabd();
            } else {
               this.m_4e1e57ef(var2);
            }

            this.m_7d6e6866(var2, var3, var4, var1.substring(var1.indexOf(C0262.m_e9914bd3()) + 2));
         } else if (var7.equals(C0262.m_593ecbab())) {
            String var16 = var5.nextToken();
            if (var16.equals(this.m_e9914bd3())) {
               this.m_96471a3a(var8);
            }

            this.m_a5dfc9fd(var8, var16);
            this.m_9d569f79(var8, var2, var3, var4, var16, var1.substring(var1.indexOf(C0262.m_e9914bd3()) + 2));
         } else if (var7.equals(C0262.m_17d51275())) {
            String var17 = var1.substring(var1.indexOf(var8, 2) + var8.length() + 1);
            if (var17.startsWith(C0267.m_0d6ae39b())) {
               var17 = var17.substring(1);
            }

            this.m_067d3b1a(var8, var2, var3, var4, var17);
         } else if (var7.equals(C0262.m_00ba16c2())) {
            this.m_000eb017(var8, var1.substring(var1.indexOf(C0262.m_e9914bd3()) + 2), var2, System.currentTimeMillis(), true);
         } else if (var7.equals(C0262.m_d1f7b79f())) {
            this.m_bc6ead5a(var8, var2, var3, var4, var1.substring(var1.indexOf(C0262.m_e9914bd3()) + 2));
         } else {
            this.m_7f49eb10(var1);
         }
      }
   }

   protected void m_b728afce() {
   }

   protected void m_0e265701() {
   }

   private void m_d80e39d3(int var1, String var2) {
      if (var1 == 322) {
         int var3 = var2.indexOf(32);
         int var4 = var2.indexOf(32, var3 + 1);
         int var5 = var2.indexOf(32, var4 + 1);
         int var6 = var2.indexOf(58);
         String var7 = var2.substring(var3 + 1, var4);
         int var8 = 0;

         try {
            var8 = Integer.parseInt(var2.substring(var4 + 1, var5));
         } catch (NumberFormatException var11) {
         }

         String var9 = var2.substring(var6 + 1);
         this.m_ddebe4d5(var7, var8, var9);
      } else if (var1 == 332) {
         int var12 = var2.indexOf(32);
         int var16 = var2.indexOf(32, var12 + 1);
         int var20 = var2.indexOf(58);
         String var23 = var2.substring(var12 + 1, var16);
         String var27 = var2.substring(var20 + 1);
         this.f_a7d43774.put(var23, var27);
         this.m_decf2ebe(var23, var27);
      } else if (var1 == 333) {
         StringTokenizer var13 = new StringTokenizer(var2);
         var13.nextToken();
         String var17 = var13.nextToken();
         String var21 = var13.nextToken();
         long var24 = 0L;

         try {
            var24 = Long.parseLong(var13.nextToken()) * 1000L;
         } catch (NumberFormatException var10) {
         }

         String var29 = this.f_a7d43774.get(var17);
         this.f_a7d43774.remove(var17);
         this.m_000eb017(var17, var29, var21, var24, false);
      } else if (var1 == 353) {
         int var14 = var2.indexOf(C0262.m_e9914bd3());
         String var18 = var2.substring(var2.lastIndexOf(32, var14 - 1) + 1, var14);
         StringTokenizer var22 = new StringTokenizer(var2.substring(var2.indexOf(C0262.m_e9914bd3()) + 2));

         while (var22.hasMoreTokens()) {
            String var25 = var22.nextToken();
            String var28 = "";
            if (var25.startsWith(C0262.m_56242a84())) {
               var28 = C0262.m_56242a84();
            } else if (var25.startsWith(C0262.m_a29090eb())) {
               var28 = C0262.m_a29090eb();
            } else if (var25.startsWith(C0253.m_56242a84())) {
               var28 = C0253.m_56242a84();
            }

            var25 = var25.substring(var28.length());
            this.m_eb9bd660(var18, new C0469(var28, var25));
         }
      } else if (var1 == 366) {
         String var15 = var2.substring(var2.indexOf(32) + 1, var2.indexOf(C0262.m_e9914bd3()));
         C0469[] var19 = this.m_8dc743f8(var15);
         this.m_45dedee1(var15, var19);
      }

      this.m_497a3d53(var1, var2);
   }

   protected void m_497a3d53(int var1, String var2) {
   }

   protected void m_45dedee1(String var1, C0469[] var2) {
   }

   protected void m_b8355785(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_4570df10(String var1, String var2, String var3, String var4) {
   }

   protected void m_86e8bcca(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_07a87136(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_aa5d1499(String var1, String var2, String var3, String var4) {
   }

   protected void m_a932acb4(String var1, String var2, String var3, String var4) {
   }

   protected void m_3afed413(String var1, String var2, String var3, String var4) {
   }

   protected void m_9d569f79(String var1, String var2, String var3, String var4, String var5, String var6) {
   }

   protected void m_7d6e6866(String var1, String var2, String var3, String var4) {
   }

   @Deprecated
   protected void m_decf2ebe(String var1, String var2) {
   }

   protected void m_000eb017(String var1, String var2, String var3, long var4, boolean var6) {
   }

   protected void m_ddebe4d5(String var1, int var2, String var3) {
   }

   private void m_067d3b1a(String var1, String var2, String var3, String var4, String var5) {
      if (this.f_b959881b.indexOf(var1.charAt(0)) >= 0) {
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
                  this.m_4ad6ed6d(var1, f_12c731a5, var7[var10]);
                  this.m_cf074206(var1, var2, var3, var4, var7[var10]);
               } else {
                  this.m_4ad6ed6d(var1, f_ef6e14cf, var7[var10]);
                  this.m_9da9c711(var1, var2, var3, var4, var7[var10]);
               }

               var10++;
            } else if (var12 == 'v') {
               if (var9 == '+') {
                  this.m_4ad6ed6d(var1, f_50dffce6, var7[var10]);
                  this.m_296e0177(var1, var2, var3, var4, var7[var10]);
               } else {
                  this.m_4ad6ed6d(var1, f_be966e12, var7[var10]);
                  this.m_0e8709a9(var1, var2, var3, var4, var7[var10]);
               }

               var10++;
            } else if (var12 == 'k') {
               if (var9 == '+') {
                  this.m_0a1da1ea(var1, var2, var3, var4, var7[var10]);
               } else {
                  this.m_e48aa41b(var1, var2, var3, var4, var7[var10]);
               }

               var10++;
            } else if (var12 == 'l') {
               if (var9 == '+') {
                  this.m_8696e4e5(var1, var2, var3, var4, Integer.parseInt(var7[var10]));
                  var10++;
               } else {
                  this.m_0a5469af(var1, var2, var3, var4);
               }
            } else if (var12 == 'b') {
               if (var9 == '+') {
                  this.m_11424d71(var1, var2, var3, var4, var7[var10]);
               } else {
                  this.m_6eed16eb(var1, var2, var3, var4, var7[var10]);
               }

               var10++;
            } else if (var12 == 't') {
               if (var9 == '+') {
                  this.m_c335149c(var1, var2, var3, var4);
               } else {
                  this.m_36ae07b2(var1, var2, var3, var4);
               }
            } else if (var12 == 'n') {
               if (var9 == '+') {
                  this.m_2e58a4bc(var1, var2, var3, var4);
               } else {
                  this.m_aa16ca42(var1, var2, var3, var4);
               }
            } else if (var12 == 'i') {
               if (var9 == '+') {
                  this.m_6f9e795e(var1, var2, var3, var4);
               } else {
                  this.m_31f2d1be(var1, var2, var3, var4);
               }
            } else if (var12 == 'm') {
               if (var9 == '+') {
                  this.m_4e7cb9ce(var1, var2, var3, var4);
               } else {
                  this.m_d77192e3(var1, var2, var3, var4);
               }
            } else if (var12 == 'p') {
               if (var9 == '+') {
                  this.m_3908a5e7(var1, var2, var3, var4);
               } else {
                  this.m_3c444258(var1, var2, var3, var4);
               }
            } else if (var12 == 's') {
               if (var9 == '+') {
                  this.m_f30b4e3e(var1, var2, var3, var4);
               } else {
                  this.m_933f406b(var1, var2, var3, var4);
               }
            }
         }

         this.m_b9bdece4(var1, var2, var3, var4, var5);
      } else {
         this.m_1e734bc0(var1, var2, var3, var4, var5);
      }
   }

   protected void m_b9bdece4(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_1e734bc0(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_cf074206(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_9da9c711(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_296e0177(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_0e8709a9(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_0a1da1ea(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_e48aa41b(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_8696e4e5(String var1, String var2, String var3, String var4, int var5) {
   }

   protected void m_0a5469af(String var1, String var2, String var3, String var4) {
   }

   protected void m_11424d71(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_6eed16eb(String var1, String var2, String var3, String var4, String var5) {
   }

   protected void m_c335149c(String var1, String var2, String var3, String var4) {
   }

   protected void m_36ae07b2(String var1, String var2, String var3, String var4) {
   }

   protected void m_2e58a4bc(String var1, String var2, String var3, String var4) {
   }

   protected void m_aa16ca42(String var1, String var2, String var3, String var4) {
   }

   protected void m_6f9e795e(String var1, String var2, String var3, String var4) {
   }

   protected void m_31f2d1be(String var1, String var2, String var3, String var4) {
   }

   protected void m_4e7cb9ce(String var1, String var2, String var3, String var4) {
   }

   protected void m_d77192e3(String var1, String var2, String var3, String var4) {
   }

   protected void m_3908a5e7(String var1, String var2, String var3, String var4) {
   }

   protected void m_3c444258(String var1, String var2, String var3, String var4) {
   }

   protected void m_f30b4e3e(String var1, String var2, String var3, String var4) {
   }

   protected void m_933f406b(String var1, String var2, String var3, String var4) {
   }

   protected void m_bc6ead5a(String var1, String var2, String var3, String var4, String var5) {
   }

   @Deprecated
   protected void m_ca0f3887(String var1, String var2, String var3, String var4, long var5, int var7, int var8) {
   }

   @Deprecated
   protected void m_f845e258(String var1, String var2, String var3, long var4, int var6) {
   }

   protected void m_f9b69576(C0468 var1) {
   }

   protected void m_4c9108c9(C0468 var1, Exception var2) {
   }

   protected void m_5a42b460(C0456 var1) {
   }

   protected void m_8ba810b1(String var1, String var2, String var3, String var4) {
      this.m_4f03e646(C0262.m_afb31f66() + var1 + C0262.m_b2dd5137() + this.f_284ae98f + C0262.m_3d3a8736());
   }

   protected void m_f72cf5af(String var1, String var2, String var3, String var4, String var5) {
      this.m_4f03e646(C0262.m_afb31f66() + var1 + C0262.m_91e95cb4() + var5 + C0262.m_3d3a8736());
   }

   protected void m_f2135140(String var1) {
      this.m_4f03e646(C0262.m_1616e137() + var1);
   }

   protected void m_1164dce1(String var1, String var2, String var3, String var4) {
      this.m_4f03e646(C0262.m_afb31f66() + var1 + C0262.m_6dc2a812() + new Date().toString() + C0262.m_3d3a8736());
   }

   protected void m_ea89520d(String var1, String var2, String var3, String var4) {
      this.m_4f03e646(C0262.m_afb31f66() + var1 + C0262.m_e7934778() + this.f_d1201420 + C0262.m_3d3a8736());
   }

   protected void m_7f49eb10(String var1) {
   }

   public void m_394ecb95(boolean var1) {
      this.f_75ce9a68 = var1;
   }

   public String m_c42f1c7e() {
      return this.f_2fcf7d19;
   }

   protected void m_40548ad7(String var1) {
      this.f_2fcf7d19 = var1;
   }

   public String m_e9914bd3() {
      return this.f_6592e3f5;
   }

   public void m_caa10980(String var1) {
      this.f_6592e3f5 = var1;
   }

   @Deprecated
   public String m_4626ac74() {
      return this.f_1bda1989;
   }

   @Deprecated
   protected void m_6f8863c6(String var1) {
      this.f_1bda1989 = var1;
   }

   public String m_6f1f396d() {
      return this.f_1bda1989;
   }

   protected void m_fdd449a5(String var1) {
      this.f_1bda1989 = var1;
   }

   public String m_94acbdac() {
      return this.f_de6e1ca1;
   }

   protected void m_398e75c1(String var1) {
      this.f_de6e1ca1 = var1;
   }

   public String m_c254a253() {
      return this.f_284ae98f;
   }

   protected void m_d5638289(String var1) {
      this.f_284ae98f = var1;
   }

   public String m_b48a8bc4() {
      return this.f_d1201420;
   }

   protected void m_b037b453(String var1) {
      this.f_d1201420 = var1;
   }

   public synchronized boolean m_8d50206e() {
      return this.f_bb7f25fe != null && this.f_bb7f25fe.m_efa7610e();
   }

   public long m_c7c6e660() {
      return this.f_ac3b7c72;
   }

   public void m_ad6c7e6f(long var1) {
      if (var1 < 0L) {
         throw new IllegalArgumentException(C0262.m_d0e43f69());
      } else {
         this.f_ac3b7c72 = var1;
      }
   }

   public int m_d1e531af() {
      return C0462.f_f359619d;
   }

   public int m_1f1a663e() {
      return this.f_8481f66b.m_36ffc578();
   }

   public String m_afb31f66() {
      return this.f_fc40bced == null ? null : this.f_fc40bced.f_d64a3e31;
   }

   public int m_9274e178() {
      return this.f_fc40bced == null ? -1 : this.f_fc40bced.f_27871303;
   }

   public boolean m_5b3b8fdb() {
      return this.f_fc40bced == null ? false : this.f_fc40bced.f_262c82d8;
   }

   public String m_b886ae1c() {
      return this.f_fc40bced == null ? null : this.f_fc40bced.f_cc78932b;
   }

   public int[] m_729d3cd6(long var1) {
      int[] var3 = new int[4];

      for (int var4 = 3; var4 >= 0; var4--) {
         var3[var4] = (int)(var1 % 256L);
         var1 /= 256L;
      }

      return var3;
   }

   public long m_6fa424cb(byte[] var1) {
      if (var1.length != 4) {
         throw new IllegalArgumentException(C0262.m_812ab029());
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

   public Charset m_19936aa5() {
      return this.f_3834da64;
   }

   public void m_e3ff8e51(Charset var1) {
      this.f_3834da64 = var1;
   }

   public InetAddress m_18ff89bb() {
      return this.f_033a865e;
   }

   public InetAddress m_7dba075f() {
      return this.f_60b7ca25;
   }

   public void m_da4c68f4(InetAddress var1) {
      this.f_60b7ca25 = var1;
   }

   public int[] m_9ea7017c() {
      return this.f_ce48e4cb != null && this.f_ce48e4cb.length != 0 ? (int[])this.f_ce48e4cb.clone() : null;
   }

   public void m_9646f5f4(int[] var1) {
      if (var1 != null && var1.length != 0) {
         this.f_ce48e4cb = (int[])var1.clone();
      } else {
         this.f_ce48e4cb = null;
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
      return C0262.m_11f0c704()
         + this.m_c254a253()
         + C0262.m_19faa493()
         + this.m_8d50206e()
         + C0262.m_a55b07ff()
         + this.m_afb31f66()
         + C0262.m_16315846()
         + this.m_9274e178()
         + C0262.m_e8fd0250()
         + this.m_b886ae1c()
         + C0262.m_d0da63e8();
   }

   public C0469[] m_8dc743f8(String var1) {
      var1 = var1.toLowerCase();
      C0469[] var2 = new C0469[0];
      synchronized (this.f_44342628) {
         Hashtable var4 = this.f_44342628.get(var1);
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

   public String[] m_858bd65b() {
      synchronized (this.f_44342628) {
         String[] var1 = new String[this.f_44342628.size()];
         Enumeration var3 = this.f_44342628.keys();

         for (int var4 = 0; var4 < var1.length; var4++) {
            var1[var4] = (String)var3.nextElement();
         }

         return var1;
      }
   }

   public synchronized void m_1d41ca9a() {
      this.f_448d408d.interrupt();
      this.f_bb7f25fe.m_b728afce();
   }

   private void m_eb9bd660(String var1, C0469 var2) {
      var1 = var1.toLowerCase();
      synchronized (this.f_44342628) {
         Hashtable var4 = this.f_44342628.computeIfAbsent(var1, var0 -> new Hashtable<>());
         var4.put(var2, var2);
      }
   }

   private C0469 m_a5dfc9fd(String var1, String var2) {
      var1 = var1.toLowerCase();
      C0469 var3 = new C0469("", var2);
      synchronized (this.f_44342628) {
         Hashtable var5 = this.f_44342628.get(var1);
         return var5 != null ? (C0469)var5.remove(var3) : null;
      }
   }

   private void m_4e1e57ef(String var1) {
      synchronized (this.f_44342628) {
         Enumeration var3 = this.f_44342628.keys();

         while (var3.hasMoreElements()) {
            String var4 = (String)var3.nextElement();
            this.m_a5dfc9fd(var4, var1);
         }
      }
   }

   private void m_f9801473(String var1, String var2) {
      synchronized (this.f_44342628) {
         Enumeration var4 = this.f_44342628.keys();

         while (var4.hasMoreElements()) {
            String var5 = (String)var4.nextElement();
            C0469 var6 = this.m_a5dfc9fd(var5, var1);
            if (var6 != null) {
               var6 = new C0469(var6.m_8d7dbe31(), var2);
               this.m_eb9bd660(var5, var6);
            }
         }
      }
   }

   private void m_96471a3a(String var1) {
      var1 = var1.toLowerCase();
      synchronized (this.f_44342628) {
         this.f_44342628.remove(var1);
      }
   }

   private void m_8c12dabd() {
      synchronized (this.f_44342628) {
         this.f_44342628 = new Hashtable<>();
      }
   }

   private void m_4ad6ed6d(String var1, int var2, String var3) {
      var1 = var1.toLowerCase();
      synchronized (this.f_44342628) {
         Hashtable var5 = this.f_44342628.get(var1);
         C0469 var6 = null;
         if (var5 != null) {
            Enumeration var7 = var5.elements();

            while (var7.hasMoreElements()) {
               C0469 var8 = (C0469)var7.nextElement();
               if (var8.m_d32ebe65().equalsIgnoreCase(var3)) {
                  if (var2 == f_12c731a5) {
                     if (var8.m_89e0519f()) {
                        var6 = new C0469(C0262.m_0425f2ec(), var3);
                     } else {
                        var6 = new C0469(C0262.m_56242a84(), var3);
                     }
                  } else if (var2 == f_ef6e14cf) {
                     if (var8.m_89e0519f()) {
                        var6 = new C0469(C0262.m_a29090eb(), var3);
                     } else {
                        var6 = new C0469("", var3);
                     }
                  } else if (var2 == f_50dffce6) {
                     if (var8.m_9362a920()) {
                        var6 = new C0469(C0262.m_0425f2ec(), var3);
                     } else {
                        var6 = new C0469(C0262.m_a29090eb(), var3);
                     }
                  } else if (var2 == f_be966e12) {
                     if (var8.m_9362a920()) {
                        var6 = new C0469(C0262.m_56242a84(), var3);
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
