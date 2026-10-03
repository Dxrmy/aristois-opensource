package me.deftware.aristois.recovered;

import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class C0141 {
   public static final C0141 f_afca7f52 = new C0141();
   private KeyStore f_a49a2799;
   private SSLContext f_3b209ca3;
   private SSLSocketFactory f_03b29c66;
   private TrustManagerFactory f_11c6c96c;

   private C0141() {
   }

   public void m_1058ed9a() throws Exception {
      this.f_11c6c96c = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      this.f_3b209ca3 = SSLContext.getInstance(C0255.m_733bff3d());
      this.f_a49a2799 = KeyStore.getInstance(KeyStore.getDefaultType());
      this.f_a49a2799.load(null, null);
   }

   public void m_9ac856b9(String var1, Certificate var2) throws Exception {
      this.f_a49a2799.setCertificateEntry(var1, var2);
   }

   public void m_b728afce() throws Exception {
      this.f_11c6c96c.init(this.f_a49a2799);
      this.f_3b209ca3.init(null, this.f_11c6c96c.getTrustManagers(), null);
      this.f_03b29c66 = this.f_3b209ca3.getSocketFactory();
   }

   public SSLSocketFactory m_f40cad62() {
      return this.f_03b29c66;
   }
}
