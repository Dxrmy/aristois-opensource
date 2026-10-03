package me.deftware.aristois.menu.widgets;

import java.awt.Color;
import me.deftware.aristois.recovered.C0222;
import me.deftware.aristois.recovered.C0228;
import me.deftware.aristois.recovered.C0231;
import me.deftware.aristois.recovered.C0234;
import me.deftware.aristois.recovered.C0289;
import me.deftware.aristois.recovered.C0297;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public abstract class TitleWidget extends ButtonWidget {
   protected double underlineHeight = 2.0;
   protected boolean drawArrowButton = false;
   protected boolean drawExitButton = false;
   protected double buttonPadding = 15.0;
   protected Color fontColor = null;
   protected boolean hover = false;
   protected boolean mousePressed = false;
   protected boolean drawIcon = false;
   protected final LineRenderStack lineRenderStack = new LineRenderStack();
   protected C0234 atlas = C0228.f_12b529e0;
   protected int iconU;
   protected int iconV;
   protected final C0222 arrow = new C0222() {
      @Override
      protected void m_7b35c96a(double var1, double var3, double var5, double var7) {
         TitleWidget.this.lineRenderStack.begin();
         TitleWidget.this.lineRenderStack.vertex(var1, var3);
         TitleWidget.this.lineRenderStack.vertex(var1 + var5 / 2.0, var3 + var5);
         TitleWidget.this.lineRenderStack.vertex(var1 + var5 / 2.0, var3 + var5);
         TitleWidget.this.lineRenderStack.vertex(var1 + var5, var3);
         TitleWidget.this.lineRenderStack.end();
      }
   };
   protected final C0222 exit = new C0222() {
      @Override
      protected void m_7b35c96a(double var1, double var3, double var5, double var7) {
         TitleWidget.this.lineRenderStack.begin();
         TitleWidget.this.lineRenderStack.vertex(var1, var3);
         TitleWidget.this.lineRenderStack.vertex(var1 + var5, var3 + var5);
         TitleWidget.this.lineRenderStack.vertex(var1, var3 + var5);
         TitleWidget.this.lineRenderStack.vertex(var1 + var5, var3);
         TitleWidget.this.lineRenderStack.end();
      }
   };

   public TitleWidget(Message var1, C0441 var2) {
      super(var1, var2);
      this.f_360de984 = new FontRenderStack(C0231.f_83bcaed9);
      this.init();
      this.setup();
   }

   @Override
   public void m_394ecb95(boolean var1) {
      super.m_394ecb95(var1);
      this.lineRenderStack.setScaled(var1);
   }

   @Override
   protected void drawText(double var1, double var3, Message var5) {
      this.f_360de984.glColor(this.fontColor != null ? this.fontColor : this.f_02ea293d.m_f6c8a26c());
      this.f_360de984.begin().drawString((int)var1, (int)var3, var5).end();
   }

   protected void setup() {
      double var1 = this.f_7fd3d7b7.m_d42f3372() - this.buttonPadding * 2.0;
      double var3 = this.buttonPadding;
      double var5 = this.buttonPadding;
      this.arrow.m_44bb072f().m_f8b16cfb(var3, var5);
      this.arrow.m_44bb072f().m_6fd9bdae(var1);
      this.arrow.m_44bb072f().m_61ade8f3(var1);
      this.exit.m_44bb072f().m_01fed791(var5);
      this.exit.m_44bb072f().m_6fd9bdae(var1);
      this.exit.m_44bb072f().m_61ade8f3(var1);
      this.exit.m_7c9e279f(90.0);
      this.exit.m_44bb072f().m_8d8487f4(this.f_7fd3d7b7);
      this.arrow.m_44bb072f().m_8d8487f4(this.f_7fd3d7b7);
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      if (this.mousePressed) {
         this.mousePressed = false;
         this.onExitPress();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      super.m_8407b1bf(var1, var3, var5);
      if (this.drawExitButton && this.exit.m_44bb072f().m_a58797d6(var1, var3)) {
         this.mousePressed = true;
         return true;
      } else {
         return false;
      }
   }

   @Override
   protected void drawBackground(double var1, double var3, float var5) {
      super.drawBackground(var1, var3, var5);
      ((QuadRenderStack)this.quadRenderStack.glColor(this.f_02ea293d.m_e1729432()))
         .drawRect(
            this.f_7fd3d7b7.m_a005efae(),
            this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372() - this.underlineHeight,
            this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29(),
            this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372()
         )
         .end();
      if (this.drawExitButton || this.drawArrowButton) {
         ((LineRenderStack)this.lineRenderStack.glColor(Color.white)).lineWidth(1.5F * RenderStack.getScale());
      }

      if (this.drawArrowButton) {
         this.arrow.m_9d486ef7(var1, var3, var5);
      }

      if (this.drawExitButton) {
         boolean var6 = this.exit.m_44bb072f().m_a58797d6(var1, var3);
         if (var6 != this.hover && this.exit.m_acb8f086().m_e606d819()) {
            this.exit.m_1058ed9a();
            this.hover = var6;
         }

         this.exit.m_44bb072f().m_dadc1f5d(this.f_7fd3d7b7.m_4388ac29() - this.buttonPadding - this.exit.m_44bb072f().m_4388ac29());
         this.exit.m_9d486ef7(var1, var3, var5);
      }

      C0297 var11 = C0289.m_c3a8b502(C0297.class);
      if (this.drawIcon && var11.m_f057b877()) {
         double var7 = 10.0;
         double var9 = (this.m_44bb072f().m_d42f3372() - var7 * 2.0) * (double)RenderStack.getScale();
         this.atlas
            .m_9b6362d6(
               var9,
               (this.m_44bb072f().m_a005efae() + var7) * (double)RenderStack.getScale(),
               (this.m_44bb072f().m_84808068() + var7) * (double)RenderStack.getScale(),
               this.iconU,
               this.iconV,
               var11.m_4aac060f()
            );
      }
   }

   protected void onExitPress() {
   }

   public double getUnderlineHeight() {
      return this.underlineHeight;
   }

   public boolean isDrawArrowButton() {
      return this.drawArrowButton;
   }

   public boolean isDrawExitButton() {
      return this.drawExitButton;
   }

   public double getButtonPadding() {
      return this.buttonPadding;
   }

   public Color getFontColor() {
      return this.fontColor;
   }

   public boolean isHover() {
      return this.hover;
   }

   public boolean isMousePressed() {
      return this.mousePressed;
   }

   public boolean isDrawIcon() {
      return this.drawIcon;
   }

   public LineRenderStack getLineRenderStack() {
      return this.lineRenderStack;
   }

   public C0234 getAtlas() {
      return this.atlas;
   }

   public int getIconU() {
      return this.iconU;
   }

   public int getIconV() {
      return this.iconV;
   }

   public void setUnderlineHeight(double var1) {
      this.underlineHeight = var1;
   }

   public void setDrawArrowButton(boolean var1) {
      this.drawArrowButton = var1;
   }

   public void setDrawExitButton(boolean var1) {
      this.drawExitButton = var1;
   }

   public void setButtonPadding(double var1) {
      this.buttonPadding = var1;
   }

   public void setFontColor(Color var1) {
      this.fontColor = var1;
   }

   public void setHover(boolean var1) {
      this.hover = var1;
   }

   public void setMousePressed(boolean var1) {
      this.mousePressed = var1;
   }

   public void setDrawIcon(boolean var1) {
      this.drawIcon = var1;
   }

   public void setAtlas(C0234 var1) {
      this.atlas = var1;
   }

   public void setIconU(int var1) {
      this.iconU = var1;
   }

   public void setIconV(int var1) {
      this.iconV = var1;
   }

   public C0222 getArrow() {
      return this.arrow;
   }

   public C0222 getExit() {
      return this.exit;
   }
}
