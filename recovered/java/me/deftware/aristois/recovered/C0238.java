package me.deftware.aristois.recovered;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.thealtening.auth.service.AlteningServiceType;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.helper.SessionHelper;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.session.AccountSession;
import me.deftware.client.framework.session.AuthEnvironment;
import org.apache.commons.lang3.StringUtils;

public class C0238 implements C0049 {
   private static final AuthEnvironment f_c4b0c590 = new AuthEnvironment(C0257.m_5b2d5cb2(), C0257.m_56cd5284(), C0257.m_62895921());
   public static final Map<String, C0230> f_a9549f9a = new ConcurrentHashMap<>();
   @SerializedName("token")
   private String f_d96eb254;
   @SerializedName("username")
   private String f_5e65f8ed;
   @SerializedName("limit")
   private boolean f_5d7c1565;
   @SerializedName("skin")
   private String f_ca12c87d;
   @SerializedName("expires")
   private String f_48fad41f;
   @SerializedName("info")
   private C0238.anonymousthis f_ffeb3c82;
   @SerializedName("valid")
   private boolean f_70189ccb = true;
   private boolean f_b6b2a755 = false;
   private boolean f_6a337117 = false;
   private final C0236 f_9d406e5e = C0236.f_758a0b10;
   private boolean f_096b28c0;

   @Override
   public UUID m_e3947f34() {
      return null;
   }

   @Override
   public C0230 m_7b315cdd() {
      if (StringUtils.isEmpty(this.f_ca12c87d)) {
         return C0229.f_60968b94;
      } else {
         if (!f_a9549f9a.containsKey(this.f_ca12c87d)) {
            f_a9549f9a.put(this.f_ca12c87d, new C0229(this.f_ca12c87d));
         }

         return f_a9549f9a.get(this.f_ca12c87d);
      }
   }

   public void m_ed2a80e1(Consumer<Boolean> var1) {
      C0217.m_35a6ad75(() -> this.f_9d406e5e.m_27701ec3(this.f_d96eb254), var1x -> var1.accept(var1x != null));
   }

   public void m_46be67d3(Consumer<Boolean> var1, boolean var2) {
      this.m_ab801e61(C0240.f_525a8cfb, var2, var3 -> {
         if (var3) {
            this.f_b6b2a755 = var2;
         }

         var1.accept(var3);
      });
   }

   public void m_b8138d4a(Consumer<Boolean> var1, boolean var2) {
      this.m_ab801e61(C0240.f_6da1d878, var2, var3 -> {
         if (var3) {
            this.f_6a337117 = var2;
         }

         var1.accept(var3);
      });
   }

   private void m_ab801e61(C0240 var1, boolean var2, Consumer<Boolean> var3) {
      C0147 var4 = new C0147().m_06d78a22(C0257.m_7b0db73e(), this.f_d96eb254).m_06d78a22(C0257.m_0223faff(), var2);
      C0217.m_35a6ad75(() -> this.f_9d406e5e.m_300c5efb(var1, JsonObject.class, var4), var2x -> {
         boolean var3x = var2x != null && var2x.has(C0257.m_f599ae93()) && var2x.get(C0257.m_f599ae93()).getAsBoolean();
         var3.accept(var3x);
         if (var3x) {
            if (this.f_9d406e5e.m_8db15fc6().contains(this)) {
               this.f_9d406e5e.m_8db15fc6().remove(this);
            } else {
               this.f_9d406e5e.m_8db15fc6().add(0, this);
            }
         }
      });
   }

   public static void m_256015fc(String var0) throws Exception {
      C0236.f_758a0b10.m_d43ad68a(AlteningServiceType.THEALTENING);
      AccountSession var1 = new AccountSession(f_c4b0c590);
      var1.withCredentials(var0, C0257.m_bdbd5e40());
      var1.setSession();
   }

   @Override
   public void m_f1ec3ae8() throws Exception {
      this.f_096b28c0 = true;

      try {
         m_256015fc(this.f_d96eb254);
         this.f_9d406e5e.m_92447ea7(this);
         this.f_5e65f8ed = SessionHelper.getPlayerUsername();
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      this.f_096b28c0 = false;
   }

   public Message m_af8ff2b6() {
      return Message.of(String.format(C0257.m_c04d8f6e(), this.m_4626ac74())).style(Appearance.of(DefaultColors.GRAY));
   }

   public Message m_11f0095b() {
      Builder var1 = new Builder();
      if (this.f_6a337117) {
         var1.append(C0257.m_2dc36b02());
      }

      if (this.f_b6b2a755) {
         var1.append(C0257.m_4cbaf16f());
      }

      if (!this.f_70189ccb) {
         var1.append(C0257.m_678c4ddb(), Appearance.of(DefaultColors.RED));
      }

      return var1.build();
   }

   @Override
   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      FontRenderer.drawString(this.m_11f0095b(), var2 + 20, var3 + 15, 16777215);
      C0049.super.render(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   @Override
   public void m_fd4438d8() {
      Consumer var1 = var0 -> {
         if (!var0) {
            System.err.println(C0257.m_3c19a819());
         }
      };
      if (this.f_6a337117) {
         this.m_b8138d4a(var1, false);
      }

      if (this.f_b6b2a755) {
         this.m_46be67d3(var1, false);
      }
   }

   public String m_4626ac74() {
      return new SimpleDateFormat(C0257.m_1672ac4d(), Locale.US).format(Date.from(OffsetDateTime.parse(this.f_48fad41f).toInstant()));
   }

   public C0238() {
   }

   public String m_6f1f396d() {
      return this.f_d96eb254;
   }

   @Override
   public String m_c42f1c7e() {
      return this.f_5e65f8ed;
   }

   public boolean m_c70eae42() {
      return this.f_5d7c1565;
   }

   public String m_c254a253() {
      return this.f_ca12c87d;
   }

   public String m_b48a8bc4() {
      return this.f_48fad41f;
   }

   public C0238.anonymousthis m_16297180() {
      return this.f_ffeb3c82;
   }

   public boolean m_ab90d2cd() {
      return this.f_70189ccb;
   }

   public boolean m_85f6d0f6() {
      return this.f_b6b2a755;
   }

   public boolean m_d68ce734() {
      return this.f_6a337117;
   }

   public C0236 m_3a556253() {
      return this.f_9d406e5e;
   }

   public boolean m_a1c66c94() {
      return this.f_096b28c0;
   }

   public void m_a11708c5(String var1) {
      this.f_d96eb254 = var1;
   }

   public void m_333019c8(String var1) {
      this.f_5e65f8ed = var1;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_5d7c1565 = var1;
   }

   public void m_4404c3bc(String var1) {
      this.f_ca12c87d = var1;
   }

   public void m_4f03e646(String var1) {
      this.f_48fad41f = var1;
   }

   public void m_38973567(C0238.anonymousthis var1) {
      this.f_ffeb3c82 = var1;
   }

   public void m_394ecb95(boolean var1) {
      this.f_70189ccb = var1;
   }

   public void m_fb32e2fb(boolean var1) {
      this.f_096b28c0 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0238)) {
         return false;
      } else {
         C0238 var2 = (C0238)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else if (this.m_c70eae42() != var2.m_c70eae42()) {
            return false;
         } else if (this.m_ab90d2cd() != var2.m_ab90d2cd()) {
            return false;
         } else if (this.m_85f6d0f6() != var2.m_85f6d0f6()) {
            return false;
         } else if (this.m_d68ce734() != var2.m_d68ce734()) {
            return false;
         } else if (this.m_a1c66c94() != var2.m_a1c66c94()) {
            return false;
         } else {
            String var3 = this.m_6f1f396d();
            String var4 = var2.m_6f1f396d();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               String var5 = this.m_c42f1c7e();
               String var6 = var2.m_c42f1c7e();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  String var7 = this.m_c254a253();
                  String var8 = var2.m_c254a253();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     String var9 = this.m_b48a8bc4();
                     String var10 = var2.m_b48a8bc4();
                     if (var9 == null ? var10 == null : var9.equals(var10)) {
                        C0238.anonymousthis var11 = this.m_16297180();
                        C0238.anonymousthis var12 = var2.m_16297180();
                        if (var11 == null ? var12 == null : var11.equals(var12)) {
                           C0236 var13 = this.m_3a556253();
                           C0236 var14 = var2.m_3a556253();
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

   protected boolean m_22ad6203(Object var1) {
      return var1 instanceof C0238;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + (this.m_c70eae42() ? 79 : 97);
      var2 = var2 * 59 + (this.m_ab90d2cd() ? 79 : 97);
      var2 = var2 * 59 + (this.m_85f6d0f6() ? 79 : 97);
      var2 = var2 * 59 + (this.m_d68ce734() ? 79 : 97);
      var2 = var2 * 59 + (this.m_a1c66c94() ? 79 : 97);
      String var3 = this.m_6f1f396d();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      String var4 = this.m_c42f1c7e();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      String var5 = this.m_c254a253();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      String var6 = this.m_b48a8bc4();
      var2 = var2 * 59 + (var6 == null ? 43 : var6.hashCode());
      C0238.anonymousthis var7 = this.m_16297180();
      var2 = var2 * 59 + (var7 == null ? 43 : var7.hashCode());
      C0236 var8 = this.m_3a556253();
      return var2 * 59 + (var8 == null ? 43 : var8.hashCode());
   }

   @Override
   public String toString() {
      return C0257.m_e9a52709()
         + this.m_6f1f396d()
         + C0257.m_37c08c9d()
         + this.m_c42f1c7e()
         + C0257.m_1472ab32()
         + this.m_c70eae42()
         + C0257.m_a5b24d28()
         + this.m_c254a253()
         + C0257.m_a9b6ecd9()
         + this.m_b48a8bc4()
         + C0257.m_09052c0b()
         + this.m_16297180()
         + C0257.m_023b99d9()
         + this.m_ab90d2cd()
         + C0257.m_733bff3d()
         + this.m_85f6d0f6()
         + C0257.m_76700429()
         + this.m_d68ce734()
         + C0257.m_8870d2c1()
         + this.m_3a556253()
         + C0257.m_a004d745()
         + this.m_a1c66c94()
         + C0257.m_9e27f038();
   }

   public void m_3b0d2ec4(boolean var1) {
      this.f_b6b2a755 = var1;
   }

   public void m_58cfd116(boolean var1) {
      this.f_6a337117 = var1;
   }

   public static class anonymousthis {
      @SerializedName("hypixel.lvl")
      private String f_7122b19a;
      @SerializedName("hypixel.rank")
      private String f_9fb973e7;
      @SerializedName("mineplex.lvl")
      private String f_98f726c8;
      @SerializedName("mineplex.rank")
      private String f_8a096719;
      @SerializedName("labymod.cape")
      private String f_4583f209;
      @SerializedName("5zig.cape")
      private String f_a59cee90;

      public anonymousthis() {
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder();
         return var1.toString();
      }

      public String m_8d7dbe31() {
         return this.f_7122b19a;
      }

      public String m_3d3a8736() {
         return this.f_9fb973e7;
      }

      public String m_e07cee76() {
         return this.f_98f726c8;
      }

      public String m_d32ebe65() {
         return this.f_8a096719;
      }

      public String m_3855be80() {
         return this.f_4583f209;
      }

      public String m_8ced16bd() {
         return this.f_a59cee90;
      }
   }
}
