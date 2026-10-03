package me.deftware.aristois.recovered;

import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class C0141 {
   public static final C0141 f_f303b426 = new C0141();
   private KeyStore f_900f9669;
   private SSLContext f_2df20c1a;
   private SSLSocketFactory f_c09a453f;
   private TrustManagerFactory f_4dc25a18;

   private C0141() {
   }

   public void m_2c34f216() throws Exception {
      this.f_4dc25a18 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>());
      this.f_2df20c1a = C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",51539607667>());
      this.f_900f9669 = C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>());
      this.f_900f9669.load(null, null);
   }

   public void m_507989c7(String var1, Certificate var2) throws Exception {
      this.f_900f9669.setCertificateEntry(var1, var2);
   }

   public void m_5ad9a929() throws Exception {
      this.f_4dc25a18.init(this.f_900f9669);
      this.f_2df20c1a.init(null, this.f_4dc25a18.getTrustManagers(), null);
      this.f_c09a453f = this.f_2df20c1a.getSocketFactory();
   }

   public SSLSocketFactory m_137f1c2e() {
      return this.f_c09a453f;
   }
}
