package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import com.thealtening.auth.service.AlteningServiceType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.session.AccountSession;
import me.deftware.client.framework.session.AccountType;

public class C0053 implements C0049 {
   private static final List<C0053> f_7d3b08cf = new C0219.anonymousthis<>(C0053.class, C0252.bootstrap<"get",100>());
   @SerializedName("username")
   private String f_8b55e7b5;
   @SerializedName("uuid")
   private UUID f_ae9be970;
   @SerializedName("refreshToken")
   private String f_288a2e32;
   @SerializedName("lastUsed")
   private Date f_c6c15b20;
   private String f_b181badf;
   private boolean f_d8e73624 = false;

   public C0053(C0050 var1) throws Exception {
      this.f_b181badf = var1.m_8ffd6531();
      this.f_288a2e32 = var1.m_8fd69e27();
      C0137 var2 = var1.m_e83be9e6();
      this.f_8b55e7b5 = var2.m_c0ebd658();
      this.f_ae9be970 = C0114.bootstrap<"call",0,1>(var2.m_a585c62e());
   }

   public C0053() {
   }

   public String m_93ff70eb() {
      return this.f_8b55e7b5;
   }

   public UUID m_b52fbd59() {
      return this.f_ae9be970;
   }

   public C0230 m_eab502ee() {
      return C0114.bootstrap<"call",0,1>(this.f_ae9be970);
   }

   public void m_4abf7648() {
      f_7d3b08cf.remove(this);
   }

   public void m_63d2dc9e() throws Exception {
      if (C0114.bootstrap<"call",0,1>()) {
         C0236.f_8b0448cf.m_beb16421(AlteningServiceType.MOJANG);
      }

      this.f_d8e73624 = true;
      System.out.println(C0252.bootstrap<"get",93>() + this.f_8b55e7b5);
      if (C0114.bootstrap<"call",1,1>(this.f_b181badf)) {
         this.m_412e7a09();
      }

      HashMap var1 = new HashMap();
      var1.put(C0252.bootstrap<"get",94>(), this.f_8b55e7b5);
      var1.put(C0252.bootstrap<"get",95>(), this.f_ae9be970.toString());
      var1.put(C0252.bootstrap<"get",96>(), this.f_b181badf);
      new AccountSession(null).withSession(var1, AccountType.Microsoft).setSession();
      this.f_c6c15b20 = new Date();
      this.f_d8e73624 = false;
   }

   private void m_412e7a09() throws Exception {
      System.out.println(C0252.bootstrap<"get",97>());
      C0050 var1 = new C0050();
      var1.m_846a2abd(this.f_288a2e32);
      var1.m_2997ae9a();
      var1.m_00408695();
      var1.m_51e0bc72();
      this.f_b181badf = var1.m_8ffd6531();
      this.f_288a2e32 = var1.m_8fd69e27();
   }

   @Override
   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      C0114.bootstrap<"call",2,1>(
         C0114.bootstrap<"call",0,1>(this.f_ae9be970.toString()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GRAY)), var2 + 20, var3 + 15, 16777215
      );
      if (this.f_d8e73624) {
         Message var9 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",98>());
         C0114.bootstrap<"call",2,1>(var9, var2 + var4 - C0114.bootstrap<"call",3,1>(var9) - 35, var3 + 3, 16777215);
      }

      C0049.super.render(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         C0053 var2 = (C0053)var1;
         return C0114.bootstrap<"call",0,1>(this.f_8b55e7b5, var2.f_8b55e7b5) && C0114.bootstrap<"call",0,1>(this.f_ae9be970, var2.f_ae9be970);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return C0114.bootstrap<"call",0,1>(new Object[]{this.f_8b55e7b5, this.f_ae9be970});
   }

   public static void m_e9b9dc51(GenericScreen var0) {
      C0114.bootstrap<"call",0,1>()
         .openScreen(
            new C0178<C0053>(var0, f_7d3b08cf, C0053.class, C0252.bootstrap<"get",99>()) {
               @Override
               protected void onDraw(int var1, int var2, float var3) {
                  super.onDraw(var1, var2, var3);
                  if (C0114.bootstrap<"call",0,1>().isEmpty()) {
                     C0114.bootstrap<"call",4,1>(
                        C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",92>()).style(C0114.bootstrap<"call",2,1>(DefaultColors.GRAY)),
                        C0114.bootstrap<"call",3,1>() / 2,
                        55,
                        16777215
                     );
                  }
               }
            }
         );
   }

   public static List<C0053> m_542d9e9e() {
      return f_7d3b08cf;
   }
}
