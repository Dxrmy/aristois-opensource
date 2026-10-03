package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.Cipher;
import org.apache.logging.log4j.Logger;

public class C0136 implements Runnable {
   private static final String f_68e7dc82 = C0252.bootstrap<"get",4294967325>();
   private final Logger f_4ea7780e = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967324>());
   private static final Path f_6579a32f = C0114.bootstrap<"call",1,1>(
      C0114.bootstrap<"call",0,1>()._getGameDir().getAbsolutePath(),
      new String[]{C0252.bootstrap<"get",4294967320>(), C0252.bootstrap<"get",4294967321>(), C0252.bootstrap<"get",4294967338>()}
   );
   private PublicKey f_68046db7;
   private static final String f_0134fd57 = C0252.bootstrap<"get",4294967331>();
   private boolean f_61a37b99 = false;
   private C0134 f_42b07121;
   private C0137 f_8e1b6446;
   private C0133 f_6879ea6e;

   public C0136() {
   }

   private <T> T m_c28eb0d9(Class<T> var1, String var2, String var3, Object... var4) {
      C0139 var5 = new C0139(var2).m_d4c8e485(var3, var4);
      if (var2.equalsIgnoreCase(C0252.bootstrap<"get",4294967325>())) {
         var5.m_49c3bb62(C0252.bootstrap<"get",4294967324>());
      }

      return this.m_685a84f6(var1, var5);
   }

   private <T> T m_685a84f6(Class<T> var1, C0139 var2) {
      C0140 var3 = var2.m_244f5552();
      return var3.m_9781181b() ? var3.m_13e100fc(var1) : null;
   }

   private void m_8b6fad7c() {
      C0140 var1 = new C0139(C0252.bootstrap<"get",66>())
         .m_c87f5f4a(C0252.bootstrap<"get",4294967326>(), C0252.bootstrap<"get",4294967327>() + C0114.bootstrap<"call",0,1>())
         .m_244f5552();
      if (var1.m_9781181b()) {
         this.f_8e1b6446 = var1.m_13e100fc(C0137.class);
      } else {
         this.f_4ea7780e.error(C0252.bootstrap<"get",4294967328>());
      }
   }

   public boolean m_8634fea8() {
      return C0241.f_7826e715 && this.f_61a37b99;
   }

   public boolean m_4b9474ad() {
      return this.m_ef3d4572() && this.f_42b07121.m_e59637a2();
   }

   public boolean m_a2a6bf93() {
      return this.m_ef3d4572() && this.f_42b07121.m_2ca4efdc();
   }

   public boolean m_ef3d4572() {
      return this.f_42b07121 != null;
   }

   public boolean m_6148d8ac() {
      return this.f_8e1b6446 != null;
   }

   private void m_c23dc18c() {
      C0140 var1 = new C0139(C0252.bootstrap<"get",4294967325>())
         .m_d4c8e485(C0252.bootstrap<"get",4294967329>(), this.f_8e1b6446.m_a585c62e())
         .m_c87f5f4a(C0252.bootstrap<"get",94>(), this.f_8e1b6446.m_c0ebd658())
         .m_8eb81fd3(this.f_8e1b6446.m_c0ebd658())
         .m_244f5552();
      int var2 = var1.m_c74e1657();
      if (var2 / 100 == 2) {
         this.f_42b07121 = var1.m_13e100fc(C0134.class);
         if (!this.f_42b07121.m_e59637a2()) {
            this.f_61a37b99 = true;
         }
      } else if (var2 == 403) {
         this.f_4ea7780e.error(C0252.bootstrap<"get",4294967330>());
         this.f_61a37b99 = true;
      }
   }

   @Override
   public void run() {
      this.m_66c9c782();
      this.m_8b6fad7c();
      ScheduledExecutorService var1 = C0114.bootstrap<"call",0,1>();
      if (this.f_68046db7 != null) {
         if (this.f_8e1b6446 != null && C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967331>(), this.f_8e1b6446.m_a562cb5d())) {
            this.m_c23dc18c();
            if (C0241.f_7826e715 && this.m_4b9474ad()) {
               C0289.f_c22b8d7e.m_33356f33();
            }
         } else {
            this.f_4ea7780e.error(C0252.bootstrap<"get",4294967332>());
         }
      }

      this.f_6879ea6e = this.m_c28eb0d9(C0133.class, C0252.bootstrap<"get",4294967325>(), C0252.bootstrap<"get",4294967333>());
      if (!this.m_a2a6bf93()) {
         if (!C0114.bootstrap<"call",2,1>(this.f_6879ea6e.m_5c8e9270()) && this.f_8e1b6446 != null) {
            C0114.bootstrap<"call",1,1>(this.f_6879ea6e.m_5c8e9270(), this.f_8e1b6446.m_a562cb5d());
         }

         try {
            new C0454(this.f_6879ea6e, this.m_6148d8ac(), this.f_42b07121 != null ? this.f_42b07121.m_3d959bd5() : null).m_f378a521();
         } catch (Throwable var3) {
            var3.printStackTrace();
         }
      }
   }

   private void m_66c9c782() {
      try {
         byte[] var1 = C0114.bootstrap<"call",3,1>(
            (InputStream)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(), C0252.bootstrap<"get",4294967334>()))
         );
         X509EncodedKeySpec var2 = new X509EncodedKeySpec(var1);
         KeyFactory var3 = C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",4294967335>());
         this.f_68046db7 = var3.generatePublic(var2);
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   private void m_b36649e7(C0134 var1) throws Exception {
      if (var1 != null && var1.m_4af4c328() != null) {
         byte[] var2 = C0114.bootstrap<"call",1,1>(var1.m_4af4c328().m_ff31934f());
         Cipher var3 = C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967335>());
         var3.init(2, this.f_68046db7);
         C0136.anonymousthis var4 = (C0136.anonymousthis)new Gson().fromJson(new String(var3.doFinal(var2)), C0136.anonymousthis.class);
         String var5 = this.f_8e1b6446.m_a585c62e() + var1.m_4af4c328().m_822eb083();
         if (!var4.m_09e7dcbc().equals(var5)) {
            throw new IOException(C0252.bootstrap<"get",4294967337>());
         }
      } else {
         throw new NullPointerException(C0252.bootstrap<"get",4294967336>());
      }
   }

   public Logger m_37c5855b() {
      return this.f_4ea7780e;
   }

   public PublicKey m_e234cf73() {
      return this.f_68046db7;
   }

   public C0134 m_f558e5b0() {
      return this.f_42b07121;
   }

   public C0137 m_12447e70() {
      return this.f_8e1b6446;
   }

   public C0133 m_70937892() {
      return this.f_6879ea6e;
   }

   private static class anonymousthis {
      @SerializedName("signature")
      private String f_712ac827;

      private anonymousthis() {
      }

      public String m_09e7dcbc() {
         return this.f_712ac827;
      }
   }
}
