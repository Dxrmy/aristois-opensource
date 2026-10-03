package me.deftware.aristois.menu.widgets;

import java.awt.Color;
import me.deftware.aristois.recovered.C0263;
import me.deftware.aristois.recovered.C0265;
import me.deftware.aristois.recovered.C0427;
import me.deftware.aristois.recovered.C0438;
import me.deftware.aristois.recovered.C0441;
import me.deftware.aristois.recovered.C0445;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public abstract class SliderWidget extends ButtonWidget implements C0445.anonymouscatch, C0438 {
   protected boolean drag = false;
   protected double value = 0.5;
   protected double sliderHeight = 2.0;
   protected boolean manualInput = false;
   protected boolean percentageMode = false;
   protected TextBoxWidget textBoxWidget;
   private final String numberRegex = C0263.m_624b40d8();

   public SliderWidget(C0441 var1) {
      this(0.0, 0.0, 0.0, var1);
   }

   public SliderWidget(double var1, double var3, double var5, C0441 var7) {
      super(var1, var3, var5, Message.of(C0263.m_35cdaa1a()), var7);
      this.numberRegex = C0263.m_624b40d8();
   }

   public void addTextBox() {
      this.textBoxWidget = new TextBoxWidget(0.0, 0.0, this.f_7fd3d7b7.m_4388ac29(), this.f_02ea293d) {
         @Override
         protected void apply(String var1) {
         }
      };
      this.textBoxWidget.setTextAlign(C0427.f_26bd24ae);
      this.textBoxWidget.m_44bb072f().m_8d8487f4(this.f_7fd3d7b7);
   }

   @Override
   public void m_394ecb95(boolean var1) {
      super.m_394ecb95(var1);
      this.textBoxWidget.m_394ecb95(var1);
   }

   @Override
   public void m_1058ed9a() {
      this.manualInput = false;
   }

   @Override
   public void m_7c7fe86a(int var1) {
      if (this.manualInput) {
         this.textBoxWidget.m_7c7fe86a(var1);
      }
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      if (this.manualInput) {
         return this.textBoxWidget.m_572d14e6(var1, var3, var5, var6);
      } else {
         var6 = super.m_572d14e6(var1, var3, var5, var6);
         double var7 = this.f_7fd3d7b7.m_4388ac29() - this.padding * 2.0;
         if (this.drag) {
            double var9 = var1 - this.f_7fd3d7b7.m_a005efae() - this.padding;
            this.value = clamp(0.0, var7, var9) / var7;
            this.apply(this.value, false);
            this.updateLabel();
         }

         double var14 = (this.f_7fd3d7b7.m_4388ac29() - this.padding * 2.0) * this.value;
         double var11 = this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372() / 2.0 + (double)this.f_360de984.getFontHeight() / 2.0;
         ((QuadRenderStack)this.quadRenderStack.begin().glColor(Color.white))
            .drawRect(this.f_7fd3d7b7.m_a005efae() + this.padding, var11, this.f_7fd3d7b7.m_a005efae() + this.padding + var14, var11 + this.sliderHeight)
            .end();
         return var6 || this.drag;
      }
   }

   @Override
   public boolean isMouseOver(double var1, double var3, boolean var5) {
      return super.isMouseOver(var1, var3, var5) || this.drag;
   }

   @Override
   public boolean m_82e0832a(int var1, int var2, int var3) {
      if (this.manualInput) {
         if (var1 != 257 && var1 != 335) {
            return this.textBoxWidget.m_82e0832a(var1, var2, var3);
         }

         if (!this.textBoxWidget.getText().isEmpty() && this.textBoxWidget.getText().matches(C0263.m_624b40d8())) {
            if (!this.percentageMode) {
               this.value = this.normalize(Double.parseDouble(this.textBoxWidget.getText()));
            } else {
               this.value = Double.parseDouble(this.textBoxWidget.getText().replace(C0265.m_c254a253(), "")) / 100.0;
            }

            this.apply(this.value, true);
            this.updateLabel();
            this.manualInput = false;
            return true;
         }
      } else if (this.f_a54daaa0 && (var1 == 263 || var1 == 262) && this.hover) {
         double var4 = 0.01;
         this.value = clamp(0.0, 1.0, this.value += var1 == 263 ? -var4 : var4);
         this.apply(this.value, true);
         this.updateLabel();
         return true;
      }

      return false;
   }

   @Override
   public void m_0e265701() {
      if (this.manualInput) {
         this.textBoxWidget.m_0e265701();
      }
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      if (this.drag) {
         this.drag = false;
         this.apply(this.value, true);
      }

      return false;
   }

   public static double clamp(double var0, double var2, double var4) {
      return Math.min(Math.max(var0, var4), var2);
   }

   public double percentage() {
      return this.value * 100.0;
   }

   @Override
   protected void onClick(int var1) {
      if (var1 == 1 && !this.f_a54daaa0) {
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
      return C0263.m_624b40d8();
   }
}
