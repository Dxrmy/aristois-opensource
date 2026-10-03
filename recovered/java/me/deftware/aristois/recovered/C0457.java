package me.deftware.aristois.recovered;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class C0457 {
   public C0457() {
   }

   public static SSLContext m_a79af71b() throws Exception {
      TrustManager[] var0 = new TrustManager[]{new X509TrustManager() {
         @Override
         public X509Certificate[] getAcceptedIssuers() {
            return null;
         }

         @Override
         public void checkClientTrusted(X509Certificate[] var1, String var2) {
         }

         @Override
         public void checkServerTrusted(X509Certificate[] var1, String var2) {
         }
      }};
      HostnameVerifier var1 = (var0x, var1x) -> true;
      SSLContext var2 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",34359738459>());
      var2.init(null, var0, new SecureRandom());
      return var2;
   }
}
