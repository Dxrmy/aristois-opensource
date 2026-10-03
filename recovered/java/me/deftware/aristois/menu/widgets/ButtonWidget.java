package me.deftware.aristois.menu.widgets;

import com.google.common.base.Strings;
import me.deftware.aristois.recovered.C0165;
import me.deftware.aristois.recovered.C0253;
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
      this.fontBounds.m_8d8487f4(this.f_7fd3d7b7);
      this.init();
   }

   public void init() {
      this.fontBounds.m_61ade8f3((double)this.f_360de984.getFontHeight());
      this.updatePadding(this.padding = this.f_02ea293d.m_036bd5c5());
   }

   public void updatePadding(double var1) {
      this.padding = var1;
      this.m_44bb072f().m_61ade8f3((double)this.f_360de984.getFontHeight() + var1 * 2.0);
      this.fontBounds.m_f8b16cfb(var1, this.getTextCenter());
   }

   @Override
   public void m_394ecb95(boolean var1) {
      this.quadRenderStack.setScaled(var1);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
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
         var8 = Message.of(Strings.repeat(C0253.m_56242a84(), this.ticks / 6 % 4));
      }

      this.prepareText(var1, var3, var5, var8);
      return var6;
   }

   @Override
   public void m_0e265701() {
      this.ticks++;
   }

   public <T extends ButtonWidget> T setTextAlign(C0427 var1) {
      this.textAlign = var1;
      return (T)this;
   }

   public <T extends ButtonWidget> T autoWidth() {
      this.f_7fd3d7b7.m_6fd9bdae(this.padding * 2.0 + (double)this.f_360de984.getStringWidth(this.label));
      return (T)this;
   }

   public boolean isMouseOver(double var1, double var3, boolean var5) {
      return this.f_7fd3d7b7.m_a58797d6(var1, var3) && !var5;
   }

   protected void drawBackground(double var1, double var3, float var5) {
      ((QuadRenderStack)this.quadRenderStack.glColor(this.f_02ea293d.m_98b03f4f(), this.hover ? (float)this.f_02ea293d.m_98b03f4f().getAlpha() : 0.0F))
         .begin()
         .drawRect(
            this.f_7fd3d7b7.m_a005efae(),
            this.f_7fd3d7b7.m_84808068(),
            this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29(),
            this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372()
         );
   }

   protected C0427 getAlign() {
      return this.textAlign != null ? this.textAlign : this.f_02ea293d.m_bfd5e3dd().m_284992ec();
   }

   protected void prepareText(double var1, double var3, float var5, Message var6) {
      double var7 = this.f_7fd3d7b7.m_a005efae() + (this.f_7fd3d7b7.m_4388ac29() / 2.0 - (double)this.f_360de984.getStringWidth(var6) / 2.0);
      double var9 = this.f_7fd3d7b7.m_84808068() + this.getTextCenter();
      if (this.getAlign() == C0427.f_26bd24ae) {
         var7 = this.f_7fd3d7b7.m_a005efae() + this.padding;
      } else if (this.getAlign() == C0427.f_73e87f17) {
         var7 = this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29() - (double)this.f_360de984.getStringWidth(var6) - this.padding;
      }

      this.drawText(var7, var9, var6);
   }

   protected double getTextCenter() {
      return this.f_7fd3d7b7.m_d42f3372() / 2.0 - (double)this.f_360de984.getFontHeight() / 2.0;
   }

   protected void drawText(double var1, double var3, Message var5) {
      this.f_360de984.begin().drawString((int)var1, (int)var3, var5).end();
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      if (this.f_7fd3d7b7.m_a58797d6(var1, var3)) {
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
