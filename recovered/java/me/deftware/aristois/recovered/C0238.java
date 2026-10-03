package me.deftware.aristois.recovered;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.thealtening.auth.service.AlteningServiceType;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.session.AccountSession;
import me.deftware.client.framework.session.AuthEnvironment;

public class C0238 implements C0049 {
   private static final AuthEnvironment f_dd42cf38 = new AuthEnvironment(
      C0252.bootstrap<"get",121>(), C0252.bootstrap<"get",122>(), C0252.bootstrap<"get",123>()
   );
   public static final Map<String, C0230> f_13a7c1e0 = new ConcurrentHashMap<>();
   @SerializedName("token")
   private String f_47f29acf;
   @SerializedName("username")
   private String f_e00dd6c8;
   @SerializedName("limit")
   private boolean f_0fec9dd9;
   @SerializedName("skin")
   private String f_a901005a;
   @SerializedName("expires")
   private String f_9ff06fd5;
   @SerializedName("info")
   private C0238.anonymousthis f_3d44d797;
   @SerializedName("valid")
   private boolean f_4dcb1f1d = true;
   private boolean f_3cdb1ec5 = false;
   private boolean f_b70ea563 = false;
   private final C0236 f_ee60947a = C0236.f_8b0448cf;
   private boolean f_71e1abd9;

   public UUID m_ddf4c0ff() {
      return null;
   }

   public C0230 m_b1574147() {
      if (C0114.bootstrap<"call",0,1>(this.f_a901005a)) {
         return C0229.f_91d70760;
      } else {
         if (!f_13a7c1e0.containsKey(this.f_a901005a)) {
            f_13a7c1e0.put(this.f_a901005a, new C0229(this.f_a901005a));
         }

         return f_13a7c1e0.get(this.f_a901005a);
      }
   }

   public void m_8424334e(Consumer<Boolean> var1) {
      C0114.bootstrap<"call",0,1>(() -> this.f_ee60947a.m_ff4d2205(this.f_47f29acf), var1x -> var1.accept(C0114.bootstrap<"call",1,1>(var1x != null)));
   }

   public void m_39b50c56(Consumer<Boolean> var1, boolean var2) {
      this.m_fb61cde1(C0240.f_bbc7a518, var2, var3 -> {
         if (var3) {
            this.f_3cdb1ec5 = var2;
         }

         var1.accept(var3);
      });
   }

   public void m_2eced60d(Consumer<Boolean> var1, boolean var2) {
      this.m_fb61cde1(C0240.f_b27c3ed4, var2, var3 -> {
         if (var3) {
            this.f_b70ea563 = var2;
         }

         var1.accept(var3);
      });
   }

   private void m_fb61cde1(C0240 var1, boolean var2, Consumer<Boolean> var3) {
      C0147 var4 = new C0147()
         .m_f33d7248(C0252.bootstrap<"get",26>(), this.f_47f29acf)
         .m_f33d7248(C0252.bootstrap<"get",101>(), C0114.bootstrap<"call",1,1>(var2));
      C0114.bootstrap<"call",0,1>(() -> this.f_ee60947a.m_a6573cd3(var1, JsonObject.class, var4), var2x -> {
         boolean var3x = var2x != null && var2x.has(C0252.bootstrap<"get",120>()) && var2x.get(C0252.bootstrap<"get",120>()).getAsBoolean();
         var3.accept(C0114.bootstrap<"call",1,1>(var3x));
         if (var3x) {
            if (this.f_ee60947a.m_29ca3911().contains(this)) {
               this.f_ee60947a.m_29ca3911().remove(this);
            } else {
               this.f_ee60947a.m_29ca3911().add(0, this);
            }
         }
      });
   }

   public static void m_9aa2a620(String var0) throws Exception {
      C0236.f_8b0448cf.m_beb16421(AlteningServiceType.THEALTENING);
      AccountSession var1 = new AccountSession(f_dd42cf38);
      var1.withCredentials(var0, C0252.bootstrap<"get",102>());
      var1.setSession();
   }

   public void m_2ca21399() throws Exception {
      this.f_71e1abd9 = true;

      try {
         C0114.bootstrap<"call",0,1>(this.f_47f29acf);
         this.f_ee60947a.m_4ef9abdf(this);
         this.f_e00dd6c8 = C0114.bootstrap<"call",1,1>();
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      this.f_71e1abd9 = false;
   }

   public Message m_3f51c5a5() {
      return C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",103>(), new Object[]{this.m_0d825ff2()}))
         .style(C0114.bootstrap<"call",2,1>(DefaultColors.GRAY));
   }

   public Message m_a12d1f40() {
      Builder var1 = new Builder();
      if (this.f_b70ea563) {
         var1.append(C0252.bootstrap<"get",104>());
      }

      if (this.f_3cdb1ec5) {
         var1.append(C0252.bootstrap<"get",105>());
      }

      if (!this.f_4dcb1f1d) {
         var1.append(C0252.bootstrap<"get",106>(), C0114.bootstrap<"call",0,1>(DefaultColors.RED));
      }

      return var1.build();
   }

   @Override
   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      C0114.bootstrap<"call",0,1>(this.m_a12d1f40(), var2 + 20, var3 + 15, 16777215);
      C0049.super.render(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void m_bdee68f5() {
      Consumer var1 = var0 -> {
         if (!var0) {
            System.err.println(C0252.bootstrap<"get",119>());
         }
      };
      if (this.f_b70ea563) {
         this.m_2eced60d(var1, false);
      }

      if (this.f_3cdb1ec5) {
         this.m_39b50c56(var1, false);
      }
   }

   public String m_0d825ff2() {
      return new SimpleDateFormat(C0252.bootstrap<"get",107>(), Locale.US)
         .format(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(this.f_9ff06fd5).toInstant()));
   }

   public C0238() {
   }

   public String m_d6d233fd() {
      return this.f_47f29acf;
   }

   public String m_d1e72559() {
      return this.f_e00dd6c8;
   }

   public boolean m_46a1be90() {
      return this.f_0fec9dd9;
   }

   public String m_ceded8ac() {
      return this.f_a901005a;
   }

   public String m_86edcb52() {
      return this.f_9ff06fd5;
   }

   public C0238.anonymousthis m_4871ee0f() {
      return this.f_3d44d797;
   }

   public boolean m_135366de() {
      return this.f_4dcb1f1d;
   }

   public boolean m_3a0223ce() {
      return this.f_3cdb1ec5;
   }

   public boolean m_73224595() {
      return this.f_b70ea563;
   }

   public C0236 m_8a153aa0() {
      return this.f_ee60947a;
   }

   public boolean m_58d3612a() {
      return this.f_71e1abd9;
   }

   public void m_d6d66515(String var1) {
      this.f_47f29acf = var1;
   }

   public void m_d726f6c2(String var1) {
      this.f_e00dd6c8 = var1;
   }

   public void m_f9becbba(boolean var1) {
      this.f_0fec9dd9 = var1;
   }

   public void m_f4885acf(String var1) {
      this.f_a901005a = var1;
   }

   public void m_089dca43(String var1) {
      this.f_9ff06fd5 = var1;
   }

   public void m_d89191a1(C0238.anonymousthis var1) {
      this.f_3d44d797 = var1;
   }

   public void m_6b4854d8(boolean var1) {
      this.f_4dcb1f1d = var1;
   }

   public void m_4b123054(boolean var1) {
      this.f_71e1abd9 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0238)) {
         return false;
      } else {
         C0238 var2 = (C0238)var1;
         if (!var2.m_a08e58d6(this)) {
            return false;
         } else if (this.m_46a1be90() != var2.m_46a1be90()) {
            return false;
         } else if (this.m_135366de() != var2.m_135366de()) {
            return false;
         } else if (this.m_3a0223ce() != var2.m_3a0223ce()) {
            return false;
         } else if (this.m_73224595() != var2.m_73224595()) {
            return false;
         } else if (this.m_58d3612a() != var2.m_58d3612a()) {
            return false;
         } else {
            String var3 = this.m_d6d233fd();
            String var4 = var2.m_d6d233fd();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               String var5 = this.m_d1e72559();
               String var6 = var2.m_d1e72559();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  String var7 = this.m_ceded8ac();
                  String var8 = var2.m_ceded8ac();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     String var9 = this.m_86edcb52();
                     String var10 = var2.m_86edcb52();
                     if (var9 == null ? var10 == null : var9.equals(var10)) {
                        C0238.anonymousthis var11 = this.m_4871ee0f();
                        C0238.anonymousthis var12 = var2.m_4871ee0f();
                        if (var11 == null ? var12 == null : var11.equals(var12)) {
                           C0236 var13 = this.m_8a153aa0();
                           C0236 var14 = var2.m_8a153aa0();
                           return var13 == null ? var14 == null : var13.equals(var14);
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_a08e58d6(Object var1) {
      return var1 instanceof C0238;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + (this.m_46a1be90() ? 79 : 97);
      var2 = var2 * 59 + (this.m_135366de() ? 79 : 97);
      var2 = var2 * 59 + (this.m_3a0223ce() ? 79 : 97);
      var2 = var2 * 59 + (this.m_73224595() ? 79 : 97);
      var2 = var2 * 59 + (this.m_58d3612a() ? 79 : 97);
      String var3 = this.m_d6d233fd();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      String var4 = this.m_d1e72559();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      String var5 = this.m_ceded8ac();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      String var6 = this.m_86edcb52();
      var2 = var2 * 59 + (var6 == null ? 43 : var6.hashCode());
      C0238.anonymousthis var7 = this.m_4871ee0f();
      var2 = var2 * 59 + (var7 == null ? 43 : var7.hashCode());
      C0236 var8 = this.m_8a153aa0();
      return var2 * 59 + (var8 == null ? 43 : var8.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",108>()
         + this.m_d6d233fd()
         + C0252.bootstrap<"get",109>()
         + this.m_d1e72559()
         + C0252.bootstrap<"get",110>()
         + this.m_46a1be90()
         + C0252.bootstrap<"get",111>()
         + this.m_ceded8ac()
         + C0252.bootstrap<"get",112>()
         + this.m_86edcb52()
         + C0252.bootstrap<"get",113>()
         + this.m_4871ee0f()
         + C0252.bootstrap<"get",114>()
         + this.m_135366de()
         + C0252.bootstrap<"get",115>()
         + this.m_3a0223ce()
         + C0252.bootstrap<"get",116>()
         + this.m_73224595()
         + C0252.bootstrap<"get",117>()
         + this.m_8a153aa0()
         + C0252.bootstrap<"get",118>()
         + this.m_58d3612a()
         + C0252.bootstrap<"get",59>();
   }

   public void m_c5e4a17f(boolean var1) {
      this.f_3cdb1ec5 = var1;
   }

   public void m_80ad8e67(boolean var1) {
      this.f_b70ea563 = var1;
   }

   public static class anonymousthis {
      @SerializedName("hypixel.lvl")
      private String f_7309741f;
      @SerializedName("hypixel.rank")
      private String f_c315a1f3;
      @SerializedName("mineplex.lvl")
      private String f_2cf8ce48;
      @SerializedName("mineplex.rank")
      private String f_cc741222;
      @SerializedName("labymod.cape")
      private String f_ace0435c;
      @SerializedName("5zig.cape")
      private String f_a897735f;

      public anonymousthis() {
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder();
         return var1.toString();
      }

      public String m_eb02e5ec() {
         return this.f_7309741f;
      }

      public String m_edad23bf() {
         return this.f_c315a1f3;
      }

      public String m_1c3ffd02() {
         return this.f_2cf8ce48;
      }

      public String m_967cc6b5() {
         return this.f_cc741222;
      }

      public String m_bd2588f3() {
         return this.f_ace0435c;
      }

      public String m_65b8785a() {
         return this.f_a897735f;
      }
   }
}
