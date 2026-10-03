package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.Cipher;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.helper.SessionHelper;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.ResourceUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C0136 implements Runnable {
   private static final String f_6f994f2d = C0264.m_5f1ab561();
   private final Logger f_6ad4c46f = LogManager.getLogger(C0264.m_5fa6dd07());
   private static final Path f_b2fa889e = Paths.get(
      Minecraft.getMinecraftGame()._getGameDir().getAbsolutePath(), C0264.m_2e834348(), C0264.m_e07cee76(), C0264.m_94acbdac()
   );
   private PublicKey f_34d849e1;
   private static final String f_8de4a0d4 = C0264.m_8631f87f();
   private boolean f_3bdd359a = false;
   private C0134 f_7054ca79;
   private C0137 f_a9ecf230;
   private C0133 f_8ca884f9;

   public C0136() {
   }

   private <T> T m_c2f50253(Class<T> var1, String var2, String var3, Object... var4) {
      C0139 var5 = new C0139(var2).m_9875ce0c(var3, var4);
      if (var2.equalsIgnoreCase(C0264.m_5f1ab561())) {
         var5.m_45690c60(C0264.m_5fa6dd07());
      }

      return this.m_c200a150(var1, var5);
   }

   private <T> T m_c200a150(Class<T> var1, C0139 var2) {
      C0140 var3 = var2.m_0017133f();
      return var3.m_9362a920() ? var3.m_3ccb9922(var1) : null;
   }

   private void m_1058ed9a() {
      C0140 var1 = new C0139(C0257.m_b526dd3b()).m_de53cd30(C0264.m_28b2c020(), C0264.m_45aaaba8() + SessionHelper.getAccessToken()).m_0017133f();
      if (var1.m_9362a920()) {
         this.f_a9ecf230 = var1.m_3ccb9922(C0137.class);
      } else {
         this.f_6ad4c46f.error(C0264.m_88937f2b());
      }
   }

   public boolean m_9362a920() {
      return C0241.f_f6e3d33b && this.f_3bdd359a;
   }

   public boolean m_89e0519f() {
      return this.m_e606d819() && this.f_7054ca79.m_9362a920();
   }

   public boolean m_51ce03a5() {
      return this.m_e606d819() && this.f_7054ca79.m_efa7610e();
   }

   public boolean m_e606d819() {
      return this.f_7054ca79 != null;
   }

   public boolean m_e0f7c666() {
      return this.f_a9ecf230 != null;
   }

   private void m_f1ec3ae8() {
      C0140 var1 = new C0139(C0264.m_5f1ab561())
         .m_9875ce0c(C0264.m_396f9431(), this.f_a9ecf230.m_8d7dbe31())
         .m_de53cd30(C0257.m_85cd13b4(), this.f_a9ecf230.m_e07cee76())
         .m_c17d7df0(this.f_a9ecf230.m_e07cee76())
         .m_0017133f();
      int var2 = var1.m_36ffc578();
      if (var2 / 100 == 2) {
         this.f_7054ca79 = var1.m_3ccb9922(C0134.class);
         if (!this.f_7054ca79.m_9362a920()) {
            this.f_3bdd359a = true;
         }
      } else if (var2 == 403) {
         this.f_6ad4c46f.error(C0264.m_e9914bd3());
         this.f_3bdd359a = true;
      }
   }

   @Override
   public void run() {
      this.m_0e389a72();
      this.m_1058ed9a();
      ScheduledExecutorService var1 = Executors.newSingleThreadScheduledExecutor();
      if (this.f_34d849e1 != null) {
         if (this.f_a9ecf230 != null && C0138.m_bc0226ab(C0264.m_8631f87f(), this.f_a9ecf230.m_3d3a8736())) {
            this.m_f1ec3ae8();
            if (C0241.f_f6e3d33b && this.m_89e0519f()) {
               C0289.f_85a7343f.m_41e83f88();
            }
         } else {
            this.f_6ad4c46f.error(C0264.m_818e6498());
         }
      }

      this.f_8ca884f9 = this.m_c2f50253(C0133.class, C0264.m_5f1ab561(), C0264.m_56d4c1c7());
      if (!this.m_51ce03a5()) {
         if (!StringUtils.isEmpty(this.f_8ca884f9.m_3855be80()) && this.f_a9ecf230 != null) {
            C0138.m_bc0226ab(this.f_8ca884f9.m_3855be80(), this.f_a9ecf230.m_3d3a8736());
         }

         try {
            new C0454(this.f_8ca884f9, this.m_e0f7c666(), this.f_7054ca79 != null ? this.f_7054ca79.m_772cf437() : null).m_1058ed9a();
         } catch (Throwable var3) {
            var3.printStackTrace();
         }
      }
   }

   private void m_0e389a72() {
      try {
         byte[] var1 = IOUtils.toByteArray(Objects.requireNonNull(ResourceUtils.getStreamFromModResources(Main.getInstance(), C0264.m_d32ebe65())));
         X509EncodedKeySpec var2 = new X509EncodedKeySpec(var1);
         KeyFactory var3 = KeyFactory.getInstance(C0264.m_afb31f66());
         this.f_34d849e1 = var3.generatePublic(var2);
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   private void m_92fdf9c4(C0134 var1) throws Exception {
      if (var1 != null && var1.m_1b54fc03() != null) {
         byte[] var2 = Base64.decodeBase64(var1.m_1b54fc03().m_3d3a8736());
         Cipher var3 = Cipher.getInstance(C0264.m_afb31f66());
         var3.init(2, this.f_34d849e1);
         C0136.anonymousthis var4 = (C0136.anonymousthis)new Gson().fromJson(new String(var3.doFinal(var2)), C0136.anonymousthis.class);
         String var5 = this.f_a9ecf230.m_8d7dbe31() + var1.m_1b54fc03().m_8d7dbe31();
         if (!var4.m_8d7dbe31().equals(var5)) {
            throw new IOException(C0264.m_3d3a8736());
         }
      } else {
         throw new NullPointerException(C0264.m_c254a253());
      }
   }

   public Logger m_3b296b8f() {
      return this.f_6ad4c46f;
   }

   public PublicKey m_e0ea9dd7() {
      return this.f_34d849e1;
   }

   public C0134 m_6f236238() {
      return this.f_7054ca79;
   }

   public C0137 m_8c26738c() {
      return this.f_a9ecf230;
   }

   public C0133 m_bc1774a3() {
      return this.f_8ca884f9;
   }

   private static class anonymousthis {
      @SerializedName("signature")
      private String f_96de3e97;

      private anonymousthis() {
      }

      public String m_8d7dbe31() {
         return this.f_96de3e97;
      }
   }
}
