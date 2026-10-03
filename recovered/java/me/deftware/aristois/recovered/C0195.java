package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.List;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Message;

public class C0195 extends C0150 {
   private List<Message> f_cf810b27;
   protected C0154 f_ceb7007c;

   public C0195(GenericScreen var1, Message... var2) {
      this(var1, Arrays.asList(var2));
   }

   public C0195(GenericScreen var1, List<Message> var2) {
      super(var1);
      this.f_cf810b27 = var2;
   }

   @Override
   protected void m_1058ed9a() {
      short var1 = 250;
      this.m_4f7d4126(
         new C0163[]{
            this.f_ceb7007c = this.m_79273652(
               this.getGuiScreenWidth() / 2 - var1 / 2, this.getGuiScreenHeight() - 40, (float)var1, Message.of(C0257.m_c42f1c7e()), this::goBack
            )
         }
      );
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      super.onDraw(var1, var2, var3);
      int var4 = this.getGuiScreenHeight() / 2 - this.f_cf810b27.size() * FontRenderer.getFontHeight() / 2 - 40;
      int var5 = this.getGuiScreenWidth() / 2;

      for (Message var7 : this.f_cf810b27) {
         FontRenderer.drawString(var7, var5 - FontRenderer.getStringWidth(var7) / 2, var4, 16777215);
         var4 += FontRenderer.getFontHeight() + 2;
      }
   }

   public void m_1793329a(List<Message> var1) {
      this.f_cf810b27 = var1;
   }

   public List<Message> m_39057c01() {
      return this.f_cf810b27;
   }

   public C0154 m_ef9bc8d5() {
      return this.f_ceb7007c;
   }
}
