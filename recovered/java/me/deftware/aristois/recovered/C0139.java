package me.deftware.aristois.recovered;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.DataOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.Proxy.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import me.deftware.client.framework.network.SocksProxy;

public class C0139 {
   public static String f_be33f283 = C0252.bootstrap<"get",51539607678>();
   private final StringBuilder f_f036357e;
   private final Map<String, String> f_f3fd5d35 = new HashMap<>();
   private int f_ce1c75c5 = 8000;
   private C0139.anonymousdefault f_fbc01fbf = C0139.anonymousdefault.f_a302b94e;
   private C0139.anonymousthis f_10e3ca16 = C0139.anonymousthis.f_06ff8b73;
   private SSLSocketFactory f_4daddf70;
   private String f_9309e490;
   private Proxy f_dde12f7c;
   private static final Pattern f_30c2e638 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",51539607679>());

   public C0139(String var1) {
      this.f_f036357e = new StringBuilder(var1);
      this.m_49c3bb62(f_be33f283);
   }

   public C0139 m_c87f5f4a(String var1, Object var2) {
      this.f_f3fd5d35.put(var1, var2.toString());
      return this;
   }

   public C0139 m_d45320a4(SSLSocketFactory var1) {
      this.f_4daddf70 = var1;
      return this;
   }

   public C0139 m_49c3bb62(String var1) {
      return this.m_c87f5f4a(C0252.bootstrap<"get",4294967318>(), var1);
   }

   public C0139 m_c40b048b(C0139.anonymousthis var1) {
      this.f_10e3ca16 = var1;
      return this;
   }

   public C0139 m_4404daa7(C0139.anonymousdefault var1) {
      this.f_fbc01fbf = var1;
      return this;
   }

   public C0139 m_67f15747(int var1) {
      this.f_ce1c75c5 = var1;
      return this;
   }

   public C0139 m_8eb81fd3(String var1) {
      return this.m_c87f5f4a(C0252.bootstrap<"get",4294967326>(), C0252.bootstrap<"get",4294967327>() + var1);
   }

   public C0139 m_317aab59(String var1) {
      this.f_9309e490 = var1;
      return this;
   }

   public C0139 m_b0cb481e(JsonElement var1) {
      return this.m_317aab59(var1.toString());
   }

   public C0139 m_82a48542(String... var1) {
      JsonArray var2 = new JsonArray();
      C0114.bootstrap<"call",0,1>(var1).forEach(var2::add);
      return this.m_b0cb481e(var2);
   }

   public C0139 m_73a7224e(C0147 var1) {
      return this.m_cd257448(var1, false);
   }

   public C0139 m_cd257448(C0147 var1, boolean var2) {
      if (!var2) {
         this.f_f036357e.append(C0252.bootstrap<"get",51539607675>());
      }

      this.f_f036357e.append(var1.toString());
      return this;
   }

   public C0139 m_5d950b0b(SocksProxy var1) {
      C0114.bootstrap<"call",1,1>().put(C0252.bootstrap<"get",51539607676>(), C0114.bootstrap<"call",2,1>(var1.getVersion()));
      this.f_dde12f7c = new Proxy(Type.SOCKS, var1.getSocketAddress());
      return this;
   }

   public C0139 m_d4c8e485(String var1, Object... var2) {
      if (var1.contains(C0252.bootstrap<"get",25769803903>())) {
         Matcher var3 = f_30c2e638.matcher(var1);

         for (int var4 = 0; var3.find(); var4++) {
            var1 = var1.replace(var3.group(), var2[var4].toString());
         }
      }

      this.f_f036357e.append(var1);
      return this;
   }

   public URL m_ea3fad3b() throws URISyntaxException, MalformedURLException {
      return new URI(this.f_f036357e.toString()).toURL();
   }

   public C0140 m_244f5552() {
      return this.m_ee833548(new C0140());
   }

   public C0140 m_4c1cd5ff(File var1) {
      return this.m_ee833548(new C0140().m_f5dba2b6(var1));
   }

   public <T extends C0140> T m_ee833548(T var1) {
      try {
         HttpsURLConnection var2;
         if (this.f_dde12f7c != null) {
            var2 = (HttpsURLConnection)this.m_ea3fad3b().openConnection(this.f_dde12f7c);
         } else {
            var2 = (HttpsURLConnection)this.m_ea3fad3b().openConnection();
         }

         if (this.f_4daddf70 != null) {
            var2.setSSLSocketFactory(this.f_4daddf70);
         }

         var2.setConnectTimeout(this.f_ce1c75c5);
         this.f_f3fd5d35.forEach(var2::setRequestProperty);
         var2.setRequestMethod(this.f_fbc01fbf.toString());
         if (this.f_fbc01fbf == C0139.anonymousdefault.f_3523c07a) {
            var2.setDoOutput(true);
            var2.setRequestProperty(C0252.bootstrap<"get",51539607677>(), this.f_10e3ca16.toString());

            try (DataOutputStream var3 = new DataOutputStream(var2.getOutputStream())) {
               var3.writeBytes(this.f_9309e490);
            }
         }

         var2.connect();
         var1.m_cfcaf3a3(var2);
         var2.disconnect();
      } catch (Exception var16) {
         var1.m_802e3bf3(500);
         var1.m_ddacd97c(var16.getMessage());
      }

      return (T)var1;
   }

   public CompletableFuture<C0140> m_b24e4acc() {
      return C0114.bootstrap<"call",0,1>(this::m_244f5552);
   }

   public CompletableFuture<C0140> m_781e574f(File var1) {
      return C0114.bootstrap<"call",0,1>(() -> this.m_4c1cd5ff(var1));
   }

   public static <T> CompletableFuture<T> m_4394f85c(Supplier<T> var0) {
      return C0114.bootstrap<"call",3,1>(var0);
   }

   public static <T> void m_0dd3548b(Supplier<T> var0, Consumer<T> var1) {
      C0114.bootstrap<"call",4,1>(var0).thenAccept(var1);
   }

   public StringBuilder m_1091d69f() {
      return this.f_f036357e;
   }

   public Map<String, String> m_2d938443() {
      return this.f_f3fd5d35;
   }

   public int m_0c3096e0() {
      return this.f_ce1c75c5;
   }

   public C0139.anonymousdefault m_7463edb8() {
      return this.f_fbc01fbf;
   }

   public C0139.anonymousthis m_52ef0bde() {
      return this.f_10e3ca16;
   }

   public SSLSocketFactory m_b3c73d31() {
      return this.f_4daddf70;
   }

   public String m_40d7b8b0() {
      return this.f_9309e490;
   }

   public Proxy m_325d5aee() {
      return this.f_dde12f7c;
   }

   public static enum anonymousdefault {
      f_a302b94e(C0252.bootstrap<"get",71>()),
      f_3523c07a(C0252.bootstrap<"get",51539607674>());

      private final String f_35743cea;

      private anonymousdefault(String var3) {
         this.f_35743cea = var3;
      }

      @Override
      public String toString() {
         return this.f_35743cea;
      }
   }

   public static enum anonymousthis {
      f_06ff8b73(C0252.bootstrap<"get",51539607669>()),
      f_e867a831(C0252.bootstrap<"get",51539607671>());

      private final String f_ca5b2ce1;

      private anonymousthis(String var3) {
         this.f_ca5b2ce1 = var3;
      }

      @Override
      public String toString() {
         return this.f_ca5b2ce1;
      }
   }
}
