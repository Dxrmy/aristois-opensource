package me.deftware.aristois.recovered;

import com.thealtening.auth.TheAlteningAuthentication;
import com.thealtening.auth.service.AlteningServiceType;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.config.Settings;

public class C0236 {
   private TheAlteningAuthentication f_c95bfd27;
   public static final String f_1474eec8 = C0257.m_ec4ef19a();
   public static final C0236 f_758a0b10 = new C0236();
   private C0239 f_a69bc6ed;
   private final Settings f_489fc687 = Main.getConfig();
   private String f_d4773508 = this.f_489fc687.getPrimitive(C0257.m_ec4ef19a(), "");
   private final List<C0238> f_e00f87a9 = new CopyOnWriteArrayList<>();
   private final List<C0238> f_af7d2e71 = new CopyOnWriteArrayList<>();
   private C0238 f_26b378e8;

   public void m_d43ad68a(AlteningServiceType var1) {
      if (this.f_c95bfd27 != null && this.f_c95bfd27.getService() != var1) {
         this.f_c95bfd27.updateService(var1);
      }
   }

   private C0236() {
      if (System.getProperty(C0257.m_83f6dd00()).startsWith(C0257.m_56c1229f())) {
         this.f_c95bfd27 = TheAlteningAuthentication.mojang();
      }

      if (!this.f_d4773508.isEmpty()) {
         this.m_ed2a80e1(null);
      }
   }

   public void m_8b8c9021(String var1, Consumer<Boolean> var2) {
      this.f_489fc687.putPrimitive(C0257.m_ec4ef19a(), this.f_d4773508 = var1).save();
      this.f_a69bc6ed = null;
      if (!var1.isEmpty()) {
         this.m_ed2a80e1(var2);
      }
   }

   private void m_ed2a80e1(Consumer<Boolean> var1) {
      C0217.m_35a6ad75(this::m_632da154, var2 -> {
         this.f_a69bc6ed = var2;
         if (var2 != null) {
            if (this.m_9362a920()) {
               Stream.concat(Stream.of(this.m_472bc474()), Stream.of(this.m_037dcb3a())).forEach(this.f_e00f87a9::add);
            }
         } else {
            this.f_d4773508 = "";
         }

         if (var1 != null) {
            var1.accept(this.m_efa7610e());
         }
      });
   }

   public boolean m_efa7610e() {
      return this.f_a69bc6ed != null;
   }

   public <T> T m_300c5efb(C0240 var1, Class<T> var2, C0147 var3) {
      C0140 var4 = new C0139(var1.toString()).m_5cd9a77d(var3.m_06d78a22(C0257.m_0d6ae39b(), this.f_d4773508)).m_0017133f();

      try {
         if (var4.m_9362a920()) {
            return var4.m_3ccb9922(var2);
         }
      } catch (Throwable var6) {
         var6.printStackTrace();
      }

      return null;
   }

   public boolean m_9362a920() {
      return this.f_a69bc6ed != null && this.f_a69bc6ed.m_d32ebe65().equalsIgnoreCase(C0257.m_65d43991());
   }

   public C0239 m_632da154() {
      C0239 var1 = this.m_300c5efb(C0240.f_a5473946, C0239.class, new C0147());
      return var1 != null && !var1.m_89e0519f() ? null : var1;
   }

   public C0238 m_702aae34() {
      C0238 var1 = this.m_300c5efb(C0240.f_6c792335, C0238.class, new C0147().m_06d78a22(C0264.m_44418b5d(), true));
      this.f_af7d2e71.add(0, var1);
      return var1;
   }

   public C0237 m_27701ec3(String var1) {
      return this.m_300c5efb(C0240.f_e6b584fa, C0237.class, new C0147().m_06d78a22(C0257.m_7b0db73e(), var1));
   }

   private C0238[] m_d0e669a7(C0240 var1, Consumer<C0238> var2) {
      C0238[] var3 = this.m_300c5efb(var1, C0238[].class, new C0147());
      if (var3 != null) {
         for (C0238 var7 : var3) {
            var2.accept(var7);
         }
      }

      return var3;
   }

   public C0238[] m_472bc474() {
      return this.m_d0e669a7(C0240.f_4194b72c, var0 -> var0.m_3b0d2ec4(true));
   }

   public C0238[] m_037dcb3a() {
      return this.m_d0e669a7(C0240.f_3e186d64, var0 -> var0.m_58cfd116(true));
   }

   public TheAlteningAuthentication m_cd862afc() {
      return this.f_c95bfd27;
   }

   public C0239 m_52ce40dc() {
      return this.f_a69bc6ed;
   }

   public Settings m_0e68071d() {
      return this.f_489fc687;
   }

   public String m_e9914bd3() {
      return this.f_d4773508;
   }

   public List<C0238> m_8db15fc6() {
      return this.f_e00f87a9;
   }

   public List<C0238> m_b984ce9c() {
      return this.f_af7d2e71;
   }

   public C0238 m_3e35aa0d() {
      return this.f_26b378e8;
   }

   public void m_92447ea7(C0238 var1) {
      this.f_26b378e8 = var1;
   }
}
