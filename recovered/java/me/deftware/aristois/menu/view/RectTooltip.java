package me.deftware.aristois.menu.view;

import me.deftware.aristois.recovered.C0153;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0165;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class RectTooltip extends C0153 implements C0441.anonymouscatch {
   private C0441 theme;
   private final FontRenderStack fontRenderStack;
   private final QuadRenderStack quadRenderStack = new QuadRenderStack();

   public RectTooltip(C0163 var1, C0441 var2, Message... var3) {
      this(var1.m_44bb072f(), var2, var3);
   }

   public RectTooltip(C0165 var1, C0441 var2, Message... var3) {
      super(var1, var3);
      this.theme = var2;
      this.fontRenderStack = var2.m_d996e5c5();
      this.m_1058ed9a();
   }

   public RectTooltip withScale(boolean var1) {
      this.m_394ecb95(var1);
      return this;
   }

   @Override
   public void m_394ecb95(boolean var1) {
      super.m_394ecb95(var1);
      this.quadRenderStack.setScaled(var1);
   }

   @Override
   protected double m_31bcc3d1(double var1, double var3) {
      if (var1 + this.f_b7c46df7.m_4388ac29() + this.f_ebce9b12 + var3 * 2.0 > (double)GuiScreen.getDisplayWidth()) {
         var1 -= this.f_b7c46df7.m_4388ac29() + var3 + this.f_ebce9b12;
      } else {
         var1 += var3 * 2.0 + this.f_ebce9b12;
      }

      return var1;
   }

   @Override
   protected double m_20206c69() {
      return this.fontRenderStack == null ? super.m_20206c69() : (double)this.fontRenderStack.getFontHeight();
   }

   @Override
   protected int m_4096be4e(Message var1) {
      return this.fontRenderStack == null ? super.m_4096be4e(var1) : this.fontRenderStack.getStringWidth(var1);
   }

   @Override
   protected void m_af7f1db9(Message var1, int var2, int var3) {
      this.fontRenderStack.begin().drawString(var2, var3, var1).end();
   }

   @Override
   protected void m_7b35c96a(double var1, double var3, double var5, double var7) {
      double var9 = 3.0;
      C0165 var11 = new C0165(var1 - var9, var3, var5 - var1 + var9 * 2.0, var7 - var3);
      this.quadRenderStack.begin();
      double var12 = 1.5;
      var11.m_d4bfedfc((QuadRenderStack)this.quadRenderStack.glColor(this.theme.m_d812cfb6().darker(), 180.0F), var12);
      var11.m_4bc1a596((QuadRenderStack)this.quadRenderStack.glColor(this.theme.m_ac758c94()));
      this.quadRenderStack.end();
   }

   @Override
   public C0441 m_519f75ae() {
      return this.theme;
   }

   public void setTheme(C0441 var1) {
      this.theme = var1;
   }
}
