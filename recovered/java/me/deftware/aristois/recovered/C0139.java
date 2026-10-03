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
import java.util.Arrays;
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
   public static String f_a07ec47b = C0255.m_56c1229f();
   private final StringBuilder f_9e979711;
   private final Map<String, String> f_7caf425c = new HashMap<>();
   private int f_01f366b3 = 8000;
   private C0139.anonymousdefault f_94f9a562 = C0139.anonymousdefault.f_372e4af0;
   private C0139.anonymousthis f_9385c584 = C0139.anonymousthis.f_a9e237e2;
   private SSLSocketFactory f_44c0d052;
   private String f_2e836fbe;
   private Proxy f_d3e5351b;
   private static final Pattern f_556c1dac = Pattern.compile(C0255.m_0d6ae39b());

   public C0139(String var1) {
      this.f_9e979711 = new StringBuilder(var1);
      this.m_45690c60(f_a07ec47b);
   }

   public C0139 m_de53cd30(String var1, Object var2) {
      this.f_7caf425c.put(var1, var2.toString());
      return this;
   }

   public C0139 m_27e42f5e(SSLSocketFactory var1) {
      this.f_44c0d052 = var1;
      return this;
   }

   public C0139 m_45690c60(String var1) {
      return this.m_de53cd30(C0264.m_bec91365(), var1);
   }

   public C0139 m_e794b2f5(C0139.anonymousthis var1) {
      this.f_9385c584 = var1;
      return this;
   }

   public C0139 m_5bfd94bd(C0139.anonymousdefault var1) {
      this.f_94f9a562 = var1;
      return this;
   }

   public C0139 m_699d9797(int var1) {
      this.f_01f366b3 = var1;
      return this;
   }

   public C0139 m_c17d7df0(String var1) {
      return this.m_de53cd30(C0264.m_28b2c020(), C0264.m_45aaaba8() + var1);
   }

   public C0139 m_61baa417(String var1) {
      this.f_2e836fbe = var1;
      return this;
   }

   public C0139 m_6e76d0fa(JsonElement var1) {
      return this.m_61baa417(var1.toString());
   }

   public C0139 m_e4016701(String... var1) {
      JsonArray var2 = new JsonArray();
      Arrays.stream(var1).forEach(var2::add);
      return this.m_6e76d0fa(var2);
   }

   public C0139 m_5cd9a77d(C0147 var1) {
      return this.m_c9915311(var1, false);
   }

   public C0139 m_c9915311(C0147 var1, boolean var2) {
      if (!var2) {
         this.f_9e979711.append(C0255.m_62895921());
      }

      this.f_9e979711.append(var1.toString());
      return this;
   }

   public C0139 m_4ac4bce5(SocksProxy var1) {
      System.getProperties().put(C0255.m_ec4ef19a(), String.valueOf(var1.getVersion()));
      this.f_d3e5351b = new Proxy(Type.SOCKS, var1.getSocketAddress());
      return this;
   }

   public C0139 m_9875ce0c(String var1, Object... var2) {
      if (var1.contains(C0267.m_0d6ae39b())) {
         Matcher var3 = f_556c1dac.matcher(var1);

         for (int var4 = 0; var3.find(); var4++) {
            var1 = var1.replace(var3.group(), var2[var4].toString());
         }
      }

      this.f_9e979711.append(var1);
      return this;
   }

   public URL m_dde8dbcb() throws URISyntaxException, MalformedURLException {
      return new URI(this.f_9e979711.toString()).toURL();
   }

   public C0140 m_0017133f() {
      return this.m_463a603f(new C0140());
   }

   public C0140 m_7978999d(File var1) {
      return this.m_463a603f(new C0140().m_7978999d(var1));
   }

   public <T extends C0140> T m_463a603f(T var1) {
      try {
         HttpsURLConnection var2;
         if (this.f_d3e5351b != null) {
            var2 = (HttpsURLConnection)this.m_dde8dbcb().openConnection(this.f_d3e5351b);
         } else {
            var2 = (HttpsURLConnection)this.m_dde8dbcb().openConnection();
         }

         if (this.f_44c0d052 != null) {
            var2.setSSLSocketFactory(this.f_44c0d052);
         }

         var2.setConnectTimeout(this.f_01f366b3);
         this.f_7caf425c.forEach(var2::setRequestProperty);
         var2.setRequestMethod(this.f_94f9a562.toString());
         if (this.f_94f9a562 == C0139.anonymousdefault.f_3ced4cdc) {
            var2.setDoOutput(true);
            var2.setRequestProperty(C0255.m_83f6dd00(), this.f_9385c584.toString());

            try (DataOutputStream var3 = new DataOutputStream(var2.getOutputStream())) {
               var3.writeBytes(this.f_2e836fbe);
            }
         }

         var2.connect();
         var1.m_a457177c(var2);
         var2.disconnect();
      } catch (Exception var16) {
         var1.m_46938bdb(500);
         var1.m_256015fc(var16.getMessage());
      }

      return (T)var1;
   }

   public CompletableFuture<C0140> m_51e5366a() {
      return m_93414462(this::m_0017133f);
   }

   public CompletableFuture<C0140> m_e6de1303(File var1) {
      return m_93414462(() -> this.m_7978999d(var1));
   }

   public static <T> CompletableFuture<T> m_93414462(Supplier<T> var0) {
      return CompletableFuture.supplyAsync(var0);
   }

   public static <T> void m_35a6ad75(Supplier<T> var0, Consumer<T> var1) {
      m_93414462(var0).thenAccept(var1);
   }

   public StringBuilder m_b93f7751() {
      return this.f_9e979711;
   }

   public Map<String, String> m_4cdd6a26() {
      return this.f_7caf425c;
   }

   public int m_f34ec3cf() {
      return this.f_01f366b3;
   }

   public C0139.anonymousdefault m_da6bb9b7() {
      return this.f_94f9a562;
   }

   public C0139.anonymousthis m_d5076338() {
      return this.f_9385c584;
   }

   public SSLSocketFactory m_d2a24274() {
      return this.f_44c0d052;
   }

   public String m_e9914bd3() {
      return this.f_2e836fbe;
   }

   public Proxy m_e74d1bf5() {
      return this.f_d3e5351b;
   }

   public static enum anonymousdefault {
      f_372e4af0(C0257.m_17d51275()),
      f_3ced4cdc(C0255.m_56cd5284());

      private final String f_4d1b8125;

      private anonymousdefault(String var3) {
         this.f_4d1b8125 = var3;
      }

      @Override
      public String toString() {
         return this.f_4d1b8125;
      }
   }

   public static enum anonymousthis {
      f_a9e237e2(C0255.m_8870d2c1()),
      f_576b707c(C0255.m_3c19a819());

      private final String f_df9c91dd;

      private anonymousthis(String var3) {
         this.f_df9c91dd = var3;
      }

      @Override
      public String toString() {
         return this.f_df9c91dd;
      }
   }
}
