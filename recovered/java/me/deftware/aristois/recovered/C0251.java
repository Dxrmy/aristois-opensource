package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;

public class C0251 implements ListItem {
   @SerializedName("Pattern")
   private String f_477d8fc0;
   @SerializedName("Replacement")
   private String f_f6f935f8;

   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",55834574915>() + this.m_683b214e()), var2, var3 + 3, 16777215);
      C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",55834574916>() + this.m_90aafe00()), var2, var3 + 15, 16777215);
   }

   public C0251() {
   }

   public String m_683b214e() {
      return this.f_477d8fc0;
   }

   public String m_90aafe00() {
      return this.f_f6f935f8;
   }

   public void m_e324fd7f(String var1) {
      this.f_477d8fc0 = var1;
   }

   public void m_60d66dfb(String var1) {
      this.f_f6f935f8 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0251)) {
         return false;
      } else {
         C0251 var2 = (C0251)var1;
         if (!var2.m_3fc08ece(this)) {
            return false;
         } else {
            String var3 = this.m_683b214e();
            String var4 = var2.m_683b214e();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               String var5 = this.m_90aafe00();
               String var6 = var2.m_90aafe00();
               return var5 == null ? var6 == null : var5.equals(var6);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_3fc08ece(Object var1) {
      return var1 instanceof C0251;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      String var3 = this.m_683b214e();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      String var4 = this.m_90aafe00();
      return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",55834574917>() + this.m_683b214e() + C0252.bootstrap<"get",55834574918>() + this.m_90aafe00() + C0252.bootstrap<"get",59>();
   }
}
