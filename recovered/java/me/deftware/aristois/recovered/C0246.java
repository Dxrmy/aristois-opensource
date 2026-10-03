package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;

public class C0246 implements ListItem {
   @SerializedName("Text")
   private String f_5521d38b;

   public C0246() {
   }

   public C0246 m_079ede7d(String var1) {
      this.f_5521d38b = var1;
      return this;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof String) {
         return ((String)var1).equalsIgnoreCase(this.f_5521d38b);
      } else {
         return var1 instanceof C0246 ? ((C0246)var1).m_4dd2758c().equals(this.f_5521d38b) : false;
      }
   }

   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(this.m_4dd2758c()), var2, var3 + 3, 16777215);
   }

   public String m_4dd2758c() {
      return this.f_5521d38b;
   }

   public void m_bd13fbee(String var1) {
      this.f_5521d38b = var1;
   }
}
