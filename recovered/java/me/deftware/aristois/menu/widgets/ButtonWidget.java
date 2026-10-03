package me.deftware.aristois.menu.widgets;

import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0165;
import me.deftware.aristois.recovered.C0252;
import me.deftware.aristois.recovered.C0427;
import me.deftware.aristois.recovered.C0428;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public abstract class ButtonWidget extends C0428 {
   protected Message label;
   protected double padding;
   protected C0165 fontBounds = new C0165();
   protected C0427 textAlign;
   protected boolean loading = false;
   protected boolean hover = false;
   protected final QuadRenderStack quadRenderStack = new QuadRenderStack();
   private int ticks = 0;

   public ButtonWidget(Message var1, C0441 var2) {
      this(0.0, 0.0, 0.0, var1, var2);
   }

   public ButtonWidget(double var1, double var3, double var5, Message var7, C0441 var8) {
      super(var1, var3, var5, 0.0, var8);
      this.label = var7;
      this.fontBounds.m_b772f454(this.f_78afab10);
      this.init();
   }

   public void init() {
      this.fontBounds.m_5078410c((double)this.f_63ca7a32.getFontHeight());
      this.updatePadding(this.padding = this.f_3bd30bfd.m_b419df18());
   }

   public void updatePadding(double var1) {
      this.padding = var1;
      this.m_de124a35().m_5078410c((double)this.f_63ca7a32.getFontHeight() + var1 * 2.0);
      this.fontBounds.m_1e49f000(var1, this.getTextCenter());
   }

   public void m_99260898(boolean var1) {
      this.quadRenderStack.setScaled(var1);
   }

   public boolean m_843bab94(double var1, double var3, float var5, boolean var6) {
      boolean var7 = this.isMouseOver(var1, var3, var6);
      if (var7 != this.hover) {
         this.hover = var7;
      }

      this.drawBackground(var1, var3, var5);
      if (this.quadRenderStack.isBuilding()) {
         this.quadRenderStack.end();
      }

      Message var8 = this.label;
      if (this.loading) {
         var8 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934650>(), this.ticks / 6 % 4));
      }

      this.prepareText(var1, var3, var5, var8);
      return var6;
   }

   public void m_d01f2824() {
      this.ticks++;
   }

   public <T extends ButtonWidget> T setTextAlign(C0427 var1) {
      this.textAlign = var1;
      return (T)this;
   }

   public <T extends ButtonWidget> T autoWidth() {
      this.f_78afab10.m_b9e3750e(this.padding * 2.0 + (double)this.f_63ca7a32.getStringWidth(this.label));
      return (T)this;
   }

   public boolean isMouseOver(double var1, double var3, boolean var5) {
      return this.f_78afab10.m_263d91ea(var1, var3) && !var5;
   }

   protected void drawBackground(double var1, double var3, float var5) {
      ((QuadRenderStack)this.quadRenderStack.glColor(this.f_3bd30bfd.m_cfebe9f1(), this.hover ? (float)this.f_3bd30bfd.m_cfebe9f1().getAlpha() : 0.0F))
         .begin()
         .drawRect(
            this.f_78afab10.m_14f8bc2c(),
            this.f_78afab10.m_5a998971(),
            this.f_78afab10.m_14f8bc2c() + this.f_78afab10.m_830cb294(),
            this.f_78afab10.m_5a998971() + this.f_78afab10.m_fc7f45bc()
         );
   }

   protected C0427 getAlign() {
      return this.textAlign != null ? this.textAlign : this.f_3bd30bfd.m_566523a6().m_e2691446();
   }

   protected void prepareText(double var1, double var3, float var5, Message var6) {
      double var7 = this.f_78afab10.m_14f8bc2c() + (this.f_78afab10.m_830cb294() / 2.0 - (double)this.f_63ca7a32.getStringWidth(var6) / 2.0);
      double var9 = this.f_78afab10.m_5a998971() + this.getTextCenter();
      if (this.getAlign() == C0427.f_f7cee513) {
         var7 = this.f_78afab10.m_14f8bc2c() + this.padding;
      } else if (this.getAlign() == C0427.f_3c5c0941) {
         var7 = this.f_78afab10.m_14f8bc2c() + this.f_78afab10.m_830cb294() - (double)this.f_63ca7a32.getStringWidth(var6) - this.padding;
      }

      this.drawText(var7, var9, var6);
   }

   protected double getTextCenter() {
      return this.f_78afab10.m_fc7f45bc() / 2.0 - (double)this.f_63ca7a32.getFontHeight() / 2.0;
   }

   protected void drawText(double var1, double var3, Message var5) {
      this.f_63ca7a32.begin().drawString((int)var1, (int)var3, var5).end();
   }

   public boolean m_d9e70307(double var1, double var3, int var5) {
      if (this.f_78afab10.m_263d91ea(var1, var3)) {
         this.onClick(var5);
         return true;
      } else {
         return false;
      }
   }

   public void updateLabel() {
   }

   protected abstract void onClick(int var1);

   public Message getLabel() {
      return this.label;
   }

   public void setLabel(Message var1) {
      this.label = var1;
   }

   public double getPadding() {
      return this.padding;
   }

   public C0165 getFontBounds() {
      return this.fontBounds;
   }

   public C0427 getTextAlign() {
      return this.textAlign;
   }

   public void setLoading(boolean var1) {
      this.loading = var1;
   }
}
