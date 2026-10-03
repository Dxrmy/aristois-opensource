package me.deftware.aristois.recovered;

import com.thealtening.auth.TheAlteningAuthentication;
import com.thealtening.auth.service.AlteningServiceType;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import me.deftware.client.framework.config.Settings;

public class C0236 {
   private TheAlteningAuthentication f_81c4753a;
   public static final String f_a965ece6 = C0252.bootstrap<"get",124>();
   public static final C0236 f_8b0448cf = new C0236();
   private C0239 f_adf7c86c;
   private final Settings f_0a202a32 = C0114.bootstrap<"call",0,1>();
   private String f_f74a4a69 = this.f_0a202a32.getPrimitive(C0252.bootstrap<"get",124>(), "");
   private final List<C0238> f_19007c16 = new CopyOnWriteArrayList<>();
   private final List<C0238> f_37f3be34 = new CopyOnWriteArrayList<>();
   private C0238 f_91076275;

   public void m_beb16421(AlteningServiceType var1) {
      if (this.f_81c4753a != null && this.f_81c4753a.getService() != var1) {
         this.f_81c4753a.updateService(var1);
      }
   }

   private C0236() {
      if (C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",125>()).startsWith(C0252.bootstrap<"get",126>())) {
         this.f_81c4753a = C0114.bootstrap<"call",2,1>();
      }

      if (!this.f_f74a4a69.isEmpty()) {
         this.m_86460fc3(null);
      }
   }

   public void m_3cc0ac72(String var1, Consumer<Boolean> var2) {
      this.f_0a202a32.putPrimitive(C0252.bootstrap<"get",124>(), this.f_f74a4a69 = var1).save();
      this.f_adf7c86c = null;
      if (!var1.isEmpty()) {
         this.m_86460fc3(var2);
      }
   }

   private void m_86460fc3(Consumer<Boolean> var1) {
      C0114.bootstrap<"call",0,1>(
         this::m_1144f31c,
         var2 -> {
            this.f_adf7c86c = var2;
            if (var2 != null) {
               if (this.m_71ecc75e()) {
                  C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(this.m_6e7ca71b()), C0114.bootstrap<"call",1,1>(this.m_ff89b855()))
                     .forEach(this.f_19007c16::add);
               }
            } else {
               this.f_f74a4a69 = "";
            }

            if (var1 != null) {
               var1.accept(C0114.bootstrap<"call",3,1>(this.m_af69325d()));
            }
         }
      );
   }

   public boolean m_af69325d() {
      return this.f_adf7c86c != null;
   }

   public <T> T m_a6573cd3(C0240 var1, Class<T> var2, C0147 var3) {
      C0140 var4 = new C0139(var1.toString()).m_73a7224e(var3.m_f33d7248(C0252.bootstrap<"get",127>(), this.f_f74a4a69)).m_244f5552();

      try {
         if (var4.m_9781181b()) {
            return var4.m_13e100fc(var2);
         }
      } catch (Throwable var6) {
         var6.printStackTrace();
      }

      return null;
   }

   public boolean m_71ecc75e() {
      return this.f_adf7c86c != null && this.f_adf7c86c.m_44ec4e9e().equalsIgnoreCase(C0252.bootstrap<"get",128>());
   }

   public C0239 m_1144f31c() {
      C0239 var1 = this.m_a6573cd3(C0240.f_3af90b11, C0239.class, new C0147());
      return var1 != null && !var1.m_0fdbf221() ? null : var1;
   }

   public C0238 m_d92a89b2() {
      C0238 var1 = this.m_a6573cd3(
         C0240.f_460ccc97, C0238.class, new C0147().m_f33d7248(C0252.bootstrap<"get",4294967296>(), C0114.bootstrap<"call",0,1>(true))
      );
      this.f_37f3be34.add(0, var1);
      return var1;
   }

   public C0237 m_ff4d2205(String var1) {
      return this.m_a6573cd3(C0240.f_4a580de0, C0237.class, new C0147().m_f33d7248(C0252.bootstrap<"get",26>(), var1));
   }

   private C0238[] m_6579d530(C0240 var1, Consumer<C0238> var2) {
      C0238[] var3 = this.m_a6573cd3(var1, C0238[].class, new C0147());
      if (var3 != null) {
         for (C0238 var7 : var3) {
            var2.accept(var7);
         }
      }

      return var3;
   }

   public C0238[] m_6e7ca71b() {
      return this.m_6579d530(C0240.f_7284e38f, var0 -> var0.m_c5e4a17f(true));
   }

   public C0238[] m_ff89b855() {
      return this.m_6579d530(C0240.f_9b505db1, var0 -> var0.m_80ad8e67(true));
   }

   public TheAlteningAuthentication m_1144dda7() {
      return this.f_81c4753a;
   }

   public C0239 m_6d4cc4e9() {
      return this.f_adf7c86c;
   }

   public Settings m_fe21882d() {
      return this.f_0a202a32;
   }

   public String m_69549747() {
      return this.f_f74a4a69;
   }

   public List<C0238> m_29ca3911() {
      return this.f_19007c16;
   }

   public List<C0238> m_818b0bed() {
      return this.f_37f3be34;
   }

   public C0238 m_558711f1() {
      return this.f_91076275;
   }

   public void m_4ef9abdf(C0238 var1) {
      this.f_91076275 = var1;
   }
}
