package me.deftware.aristois.menu.widgets;

import java.awt.Color;
import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0252;
import me.deftware.aristois.recovered.C0427;
import me.deftware.aristois.recovered.C0438;
import me.deftware.aristois.recovered.C0441;
import me.deftware.aristois.recovered.C0445;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public abstract class SliderWidget extends ButtonWidget implements C0445.anonymouscatch, C0438 {
   protected boolean drag = false;
   protected double value = 0.5;
   protected double sliderHeight = 2.0;
   protected boolean manualInput = false;
   protected boolean percentageMode = false;
   protected TextBoxWidget textBoxWidget;
   private final String numberRegex = C0252.bootstrap<"get",38654705671>();

   public SliderWidget(C0441 var1) {
      this(0.0, 0.0, 0.0, var1);
   }

   public SliderWidget(double var1, double var3, double var5, C0441 var7) {
      super(var1, var3, var5, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",38654705670>()), var7);
      this.numberRegex = C0252.bootstrap<"get",38654705671>();
   }

   public void addTextBox() {
      this.textBoxWidget = new TextBoxWidget(0.0, 0.0, this.f_9e3853eb.m_830cb294(), this.f_1b60990e) {
         @Override
         protected void apply(String var1) {
         }
      };
      this.textBoxWidget.setTextAlign(C0427.f_f7cee513);
      this.textBoxWidget.m_bc27aa02().m_b772f454(this.f_9e3853eb);
   }

   public void m_6da44979(boolean var1) {
      super.m_99260898(var1);
      this.textBoxWidget.m_8f699672(var1);
   }

   public void m_3a84e561() {
      this.manualInput = false;
   }

   public void m_3143e17f(int var1) {
      if (this.manualInput) {
         this.textBoxWidget.m_6b58ebc7(var1);
      }
   }

   public boolean m_73791369(double var1, double var3, float var5, boolean var6) {
      if (this.manualInput) {
         return this.textBoxWidget.m_1a0f2d91(var1, var3, var5, var6);
      } else {
         var6 = super.m_843bab94(var1, var3, var5, var6);
         double var7 = this.f_9e3853eb.m_830cb294() - this.padding * 2.0;
         if (this.drag) {
            double var9 = var1 - this.f_9e3853eb.m_14f8bc2c() - this.padding;
            this.value = C0114.bootstrap<"call",0,1>(0.0, var7, var9) / var7;
            this.apply(this.value, false);
            this.updateLabel();
         }

         double var14 = (this.f_9e3853eb.m_830cb294() - this.padding * 2.0) * this.value;
         double var11 = this.f_9e3853eb.m_5a998971() + this.f_9e3853eb.m_fc7f45bc() / 2.0 + (double)this.f_ff9958b7.getFontHeight() / 2.0;
         ((QuadRenderStack)this.quadRenderStack.begin().glColor(Color.white))
            .drawRect(this.f_9e3853eb.m_14f8bc2c() + this.padding, var11, this.f_9e3853eb.m_14f8bc2c() + this.padding + var14, var11 + this.sliderHeight)
            .end();
         return var6 || this.drag;
      }
   }

   @Override
   public boolean isMouseOver(double var1, double var3, boolean var5) {
      return super.isMouseOver(var1, var3, var5) || this.drag;
   }

   public boolean m_cad08978(int var1, int var2, int var3) {
      if (this.manualInput) {
         if (var1 != 257 && var1 != 335) {
            return this.textBoxWidget.m_f030b790(var1, var2, var3);
         }

         if (!this.textBoxWidget.getText().isEmpty() && this.textBoxWidget.getText().matches(C0252.bootstrap<"get",38654705671>())) {
            if (!this.percentageMode) {
               this.value = this.normalize(C0114.bootstrap<"call",0,1>(this.textBoxWidget.getText()));
            } else {
               this.value = C0114.bootstrap<"call",0,1>(this.textBoxWidget.getText().replace(C0252.bootstrap<"get",30064771112>(), "")) / 100.0;
            }

            this.apply(this.value, true);
            this.updateLabel();
            this.manualInput = false;
            return true;
         }
      } else if (this.f_b585f26f && (var1 == 263 || var1 == 262) && this.hover) {
         double var4 = 0.01;
         this.value = C0114.bootstrap<"call",1,1>(0.0, 1.0, this.value += var1 == 263 ? -var4 : var4);
         this.apply(this.value, true);
         this.updateLabel();
         return true;
      }

      return false;
   }

   public void m_1f5a037d() {
      if (this.manualInput) {
         this.textBoxWidget.m_0f0d0ce4();
      }
   }

   public boolean m_0a69bb65(double var1, double var3, int var5) {
      if (this.drag) {
         this.drag = false;
         this.apply(this.value, true);
      }

      return false;
   }

   public static double clamp(double var0, double var2, double var4) {
      return C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var0, var4), var2);
   }

   public double percentage() {
      return this.value * 100.0;
   }

   @Override
   protected void onClick(int var1) {
      if (var1 == 1 && !this.f_b585f26f) {
         if (this.textBoxWidget == null) {
            this.addTextBox();
         }

         this.manualInput = !this.manualInput;
         if (this.manualInput) {
            this.textBoxWidget.setFocused(true);
            this.textBoxWidget.setText(this.getValueText());
         }
      }

      this.drag = var1 == 0;
   }

   public abstract double normalize(double var1);

   public abstract void apply(double var1, boolean var3);

   @Override
   public abstract void updateLabel();

   public abstract String getValueText();

   public boolean isDrag() {
      return this.drag;
   }

   public double getValue() {
      return this.value;
   }

   public double getSliderHeight() {
      return this.sliderHeight;
   }

   public void setValue(double var1) {
      this.value = var1;
   }

   public void setSliderHeight(double var1) {
      this.sliderHeight = var1;
   }

   public boolean isManualInput() {
      return this.manualInput;
   }

   public void setManualInput(boolean var1) {
      this.manualInput = var1;
   }

   public void setPercentageMode(boolean var1) {
      this.percentageMode = var1;
   }

   public String getNumberRegex() {
      this.getClass();
      return C0252.bootstrap<"get",38654705671>();
   }
}
