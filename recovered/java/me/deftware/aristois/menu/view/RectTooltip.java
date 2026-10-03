package me.deftware.aristois.menu.view;

import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0153;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0165;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class RectTooltip extends C0153 implements C0441.anonymouscatch {
   private C0441 theme;
   private final FontRenderStack fontRenderStack;
   private final QuadRenderStack quadRenderStack = new QuadRenderStack();

   public RectTooltip(C0163 var1, C0441 var2, Message... var3) {
      this(var1.m_fd6ca281(), var2, var3);
   }

   public RectTooltip(C0165 var1, C0441 var2, Message... var3) {
      super(var1, var3);
      this.theme = var2;
      this.fontRenderStack = var2.m_4aa3f6de();
      this.m_b054e001();
   }

   public RectTooltip withScale(boolean var1) {
      this.m_843db6e6(var1);
      return this;
   }

   public void m_843db6e6(boolean var1) {
      super.m_0d45cade(var1);
      this.quadRenderStack.setScaled(var1);
   }

   protected double m_78cd8ad7(double var1, double var3) {
      if (var1 + this.f_0ee8e264.m_830cb294() + this.f_83c900aa + var3 * 2.0 > (double)C0114.bootstrap<"call",0,1>()) {
         var1 -= this.f_0ee8e264.m_830cb294() + var3 + this.f_83c900aa;
      } else {
         var1 += var3 * 2.0 + this.f_83c900aa;
      }

      return var1;
   }

   protected double m_9c1d7cc6() {
      return this.fontRenderStack == null ? super.m_ce15e2e1() : (double)this.fontRenderStack.getFontHeight();
   }

   protected int m_4b137d01(Message var1) {
      return this.fontRenderStack == null ? super.m_ef709b97(var1) : this.fontRenderStack.getStringWidth(var1);
   }

   protected void m_7080fe8a(Message var1, int var2, int var3) {
      this.fontRenderStack.begin().drawString(var2, var3, var1).end();
   }

   protected void m_063804dc(double var1, double var3, double var5, double var7) {
      double var9 = 3.0;
      C0165 var11 = new C0165(var1 - var9, var3, var5 - var1 + var9 * 2.0, var7 - var3);
      this.quadRenderStack.begin();
      double var12 = 1.5;
      var11.m_40710a35((QuadRenderStack)this.quadRenderStack.glColor(this.theme.m_dee103ad().darker(), 180.0F), var12);
      var11.m_79e11f68((QuadRenderStack)this.quadRenderStack.glColor(this.theme.m_8a513671()));
      this.quadRenderStack.end();
   }

   public C0441 m_41e38140() {
      return this.theme;
   }

   public void setTheme(C0441 var1) {
      this.theme = var1;
   }
}
