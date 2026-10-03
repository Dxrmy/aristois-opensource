package me.deftware.aristois.menu.widgets;

import java.awt.Color;
import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0222;
import me.deftware.aristois.recovered.C0228;
import me.deftware.aristois.recovered.C0231;
import me.deftware.aristois.recovered.C0234;
import me.deftware.aristois.recovered.C0297;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.QuadRenderStack;
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
   protected C0234 atlas = C0228.f_1a35892e;
   protected int iconU;
   protected int iconV;
   protected final C0222 arrow = new C0222() {
      protected void m_5069a71f(double var1, double var3, double var5, double var7) {
         TitleWidget.this.lineRenderStack.begin();
         TitleWidget.this.lineRenderStack.vertex(var1, var3);
         TitleWidget.this.lineRenderStack.vertex(var1 + var5 / 2.0, var3 + var5);
         TitleWidget.this.lineRenderStack.vertex(var1 + var5 / 2.0, var3 + var5);
         TitleWidget.this.lineRenderStack.vertex(var1 + var5, var3);
         TitleWidget.this.lineRenderStack.end();
      }
   };
   protected final C0222 exit = new C0222() {
      protected void m_583f8707(double var1, double var3, double var5, double var7) {
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
      this.f_0d293471 = new FontRenderStack(C0231.f_a3b67470);
      this.init();
      this.setup();
   }

   public void m_f584ec52(boolean var1) {
      super.m_99260898(var1);
      this.lineRenderStack.setScaled(var1);
   }

   @Override
   protected void drawText(double var1, double var3, Message var5) {
      this.f_0d293471.glColor(this.fontColor != null ? this.fontColor : this.f_0e78903e.m_b675cf2a());
      this.f_0d293471.begin().drawString((int)var1, (int)var3, var5).end();
   }

   protected void setup() {
      double var1 = this.f_e1c11053.m_fc7f45bc() - this.buttonPadding * 2.0;
      double var3 = this.buttonPadding;
      double var5 = this.buttonPadding;
      this.arrow.m_66b8456f().m_1e49f000(var3, var5);
      this.arrow.m_66b8456f().m_b9e3750e(var1);
      this.arrow.m_66b8456f().m_5078410c(var1);
      this.exit.m_66b8456f().m_7e0ab7c8(var5);
      this.exit.m_66b8456f().m_b9e3750e(var1);
      this.exit.m_66b8456f().m_5078410c(var1);
      this.exit.m_f7e1b7d6(90.0);
      this.exit.m_66b8456f().m_b772f454(this.f_e1c11053);
      this.arrow.m_66b8456f().m_b772f454(this.f_e1c11053);
   }

   public boolean m_5fe8ba72(double var1, double var3, int var5) {
      if (this.mousePressed) {
         this.mousePressed = false;
         this.onExitPress();
         return true;
      } else {
         return false;
      }
   }

   public boolean m_a993d5f6(double var1, double var3, int var5) {
      super.m_d9e70307(var1, var3, var5);
      if (this.drawExitButton && this.exit.m_66b8456f().m_263d91ea(var1, var3)) {
         this.mousePressed = true;
         return true;
      } else {
         return false;
      }
   }

   @Override
   protected void drawBackground(double var1, double var3, float var5) {
      super.drawBackground(var1, var3, var5);
      ((QuadRenderStack)this.quadRenderStack.glColor(this.f_0e78903e.m_8ccc187c()))
         .drawRect(
            this.f_e1c11053.m_14f8bc2c(),
            this.f_e1c11053.m_5a998971() + this.f_e1c11053.m_fc7f45bc() - this.underlineHeight,
            this.f_e1c11053.m_14f8bc2c() + this.f_e1c11053.m_830cb294(),
            this.f_e1c11053.m_5a998971() + this.f_e1c11053.m_fc7f45bc()
         )
         .end();
      if (this.drawExitButton || this.drawArrowButton) {
         ((LineRenderStack)this.lineRenderStack.glColor(Color.white)).lineWidth(1.5F * C0114.bootstrap<"call",0,1>());
      }

      if (this.drawArrowButton) {
         this.arrow.m_ca42edf7(var1, var3, var5);
      }

      if (this.drawExitButton) {
         boolean var6 = this.exit.m_66b8456f().m_263d91ea(var1, var3);
         if (var6 != this.hover && this.exit.m_b73d9bc8().m_f6c24736()) {
            this.exit.m_dcc9a738();
            this.hover = var6;
         }

         this.exit.m_66b8456f().m_6894765d(this.f_e1c11053.m_830cb294() - this.buttonPadding - this.exit.m_66b8456f().m_830cb294());
         this.exit.m_ca42edf7(var1, var3, var5);
      }

      C0297 var11 = (C0297)C0114.bootstrap<"call",1,1>(C0297.class);
      if (this.drawIcon && var11.m_85d9b73d()) {
         double var7 = 10.0;
         double var9 = (this.m_cb4e693c().m_fc7f45bc() - var7 * 2.0) * (double)C0114.bootstrap<"call",0,1>();
         this.atlas
            .m_e8034329(
               var9,
               (this.m_cb4e693c().m_14f8bc2c() + var7) * (double)C0114.bootstrap<"call",0,1>(),
               (this.m_cb4e693c().m_5a998971() + var7) * (double)C0114.bootstrap<"call",0,1>(),
               this.iconU,
               this.iconV,
               var11.m_0a1415e1()
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
