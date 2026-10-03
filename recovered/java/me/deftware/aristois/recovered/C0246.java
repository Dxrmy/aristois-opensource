package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.Message;

public class C0246 implements ListItem {
   @SerializedName("Text")
   private String f_687713d6;

   public C0246() {
   }

   public C0246 m_6fec82cb(String var1) {
      this.f_687713d6 = var1;
      return this;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof String) {
         return ((String)var1).equalsIgnoreCase(this.f_687713d6);
      } else {
         return var1 instanceof C0246 ? ((C0246)var1).m_8d7dbe31().equals(this.f_687713d6) : false;
      }
   }

   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      FontRenderer.drawString(Message.of(this.m_8d7dbe31()), var2, var3 + 3, 16777215);
   }

   public String m_8d7dbe31() {
      return this.f_687713d6;
   }

   public void m_a11708c5(String var1) {
      this.f_687713d6 = var1;
   }
}
