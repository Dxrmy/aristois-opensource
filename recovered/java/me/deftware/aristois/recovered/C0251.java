package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.Message;

public class C0251 implements ListItem {
   @SerializedName("Pattern")
   private String f_727dee44;
   @SerializedName("Replacement")
   private String f_57557bb5;

   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      FontRenderer.drawString(Message.of(C0256.m_9d6ca6d0() + this.m_8d7dbe31()), var2, var3 + 3, 16777215);
      FontRenderer.drawString(Message.of(C0256.m_87c16989() + this.m_3d3a8736()), var2, var3 + 15, 16777215);
   }

   public C0251() {
   }

   public String m_8d7dbe31() {
      return this.f_727dee44;
   }

   public String m_3d3a8736() {
      return this.f_57557bb5;
   }

   public void m_256015fc(String var1) {
      this.f_727dee44 = var1;
   }

   public void m_a11708c5(String var1) {
      this.f_57557bb5 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0251)) {
         return false;
      } else {
         C0251 var2 = (C0251)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else {
            String var3 = this.m_8d7dbe31();
            String var4 = var2.m_8d7dbe31();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               String var5 = this.m_3d3a8736();
               String var6 = var2.m_3d3a8736();
               return var5 == null ? var6 == null : var5.equals(var6);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_22ad6203(Object var1) {
      return var1 instanceof C0251;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      String var3 = this.m_8d7dbe31();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      String var4 = this.m_3d3a8736();
      return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
   }

   @Override
   public String toString() {
      return C0256.m_b0896de7() + this.m_8d7dbe31() + C0256.m_593ecbab() + this.m_3d3a8736() + C0257.m_9e27f038();
   }
}
