package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import com.thealtening.auth.service.AlteningServiceType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.session.AccountSession;
import me.deftware.client.framework.session.AccountType;
import org.apache.commons.lang3.StringUtils;

public class C0053 implements C0049 {
   private static final List<C0053> f_5dd95803 = new C0219.anonymousthis<>(C0053.class, C0257.m_8ccfdf29());
   @SerializedName("username")
   private String f_82ac271d;
   @SerializedName("uuid")
   private UUID f_6d1ce3a2;
   @SerializedName("refreshToken")
   private String f_a2919e6b;
   @SerializedName("lastUsed")
   private Date f_f6aa1355;
   private String f_ee1b7e73;
   private boolean f_878b638a = false;

   public C0053(C0050 var1) throws Exception {
      this.f_ee1b7e73 = var1.m_c42f1c7e();
      this.f_a2919e6b = var1.m_e9914bd3();
      C0137 var2 = var1.m_035881b0();
      this.f_82ac271d = var2.m_e07cee76();
      this.f_6d1ce3a2 = UUID.fromString(var2.m_8d7dbe31());
   }

   public C0053() {
   }

   @Override
   public String m_c42f1c7e() {
      return this.f_82ac271d;
   }

   @Override
   public UUID m_e3947f34() {
      return this.f_6d1ce3a2;
   }

   @Override
   public C0230 m_7b315cdd() {
      return C0224.m_3d9368ca(this.f_6d1ce3a2);
   }

   @Override
   public void m_fd4438d8() {
      f_5dd95803.remove(this);
   }

   @Override
   public void m_f1ec3ae8() throws Exception {
      if (C0242.m_efa7610e()) {
         C0236.f_758a0b10.m_d43ad68a(AlteningServiceType.MOJANG);
      }

      this.f_878b638a = true;
      System.out.println(C0257.m_9bf0a29a() + this.f_82ac271d);
      if (StringUtils.isEmpty(this.f_ee1b7e73)) {
         this.m_0e389a72();
      }

      HashMap var1 = new HashMap();
      var1.put(C0257.m_85cd13b4(), this.f_82ac271d);
      var1.put(C0257.m_65c7e6e6(), this.f_6d1ce3a2.toString());
      var1.put(C0257.m_a19a564f(), this.f_ee1b7e73);
      new AccountSession(null).withSession(var1, AccountType.Microsoft).setSession();
      this.f_f6aa1355 = new Date();
      this.f_878b638a = false;
   }

   private void m_0e389a72() throws Exception {
      System.out.println(C0257.m_03430357());
      C0050 var1 = new C0050();
      var1.m_256015fc(this.f_a2919e6b);
      var1.m_b728afce();
      var1.m_0e265701();
      var1.m_41e83f88();
      this.f_ee1b7e73 = var1.m_c42f1c7e();
      this.f_a2919e6b = var1.m_e9914bd3();
   }

   @Override
   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      FontRenderer.drawString(Message.of(this.f_6d1ce3a2.toString()).style(Appearance.of(DefaultColors.GRAY)), var2 + 20, var3 + 15, 16777215);
      if (this.f_878b638a) {
         Message var9 = Message.of(C0257.m_ec329d2e());
         FontRenderer.drawString(var9, var2 + var4 - FontRenderer.getStringWidth(var9) - 35, var3 + 3, 16777215);
      }

      C0049.super.render(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         C0053 var2 = (C0053)var1;
         return Objects.equals(this.f_82ac271d, var2.f_82ac271d) && Objects.equals(this.f_6d1ce3a2, var2.f_6d1ce3a2);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.f_82ac271d, this.f_6d1ce3a2);
   }

   public static void m_a4e18580(GenericScreen var0) {
      Minecraft.getMinecraftGame().openScreen(new C0178<C0053>(var0, f_5dd95803, C0053.class, C0257.m_edf5fb69()) {
         @Override
         protected void onDraw(int var1, int var2, float var3) {
            super.onDraw(var1, var2, var3);
            if (C0053.f_5dd95803.isEmpty()) {
               FontRenderer.drawCenteredString(Message.of(C0257.m_fac478b2()).style(Appearance.of(DefaultColors.GRAY)), getScaledWidth() / 2, 55, 16777215);
            }
         }
      });
   }

   public static List<C0053> m_110abc4e() {
      return f_5dd95803;
   }
}
