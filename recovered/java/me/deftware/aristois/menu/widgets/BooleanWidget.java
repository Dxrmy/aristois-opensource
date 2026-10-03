package me.deftware.aristois.menu.widgets;

import java.awt.Color;
import me.deftware.aristois.recovered.C0233;
import me.deftware.aristois.recovered.C0441;
import me.deftware.aristois.recovered.C0445;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.CircleRenderStack;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public abstract class BooleanWidget extends ButtonWidget implements C0445.anonymouscatch {
   protected boolean enabled = false;
   private double sliderWidth = 20.0;
   protected final CircleRenderStack circleRenderStack = new CircleRenderStack();
   private final C0233 animation = new C0233(60.0F, 33.0) {
      @Override
      protected void m_560d077c(double var1) {
         if (BooleanWidget.this.enabled) {
            BooleanWidget.this.sliderOffset = BooleanWidget.this.sliderWidth * var1;
         } else {
            BooleanWidget.this.sliderOffset = BooleanWidget.this.sliderWidth - BooleanWidget.this.sliderWidth * var1;
         }
      }
   };
   private double sliderOffset = 0.0;

   public BooleanWidget(Message var1, C0441 var2) {
      super(var1, var2);
      this.animation.m_e83888e2(C0233.anonymousdefault.f_c8bd7ffc);
   }

   public BooleanWidget(double var1, double var3, double var5, Message var7, C0441 var8) {
      super(var1, var3, var5, var7, var8);
   }

   @Override
   public void m_394ecb95(boolean var1) {
      super.m_394ecb95(var1);
      this.circleRenderStack.setScaled(var1);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      var6 = super.m_572d14e6(var1, var3, var5, var6);
      this.animation.m_d881d3e3(var5);
      double var7 = this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372() / 2.0;
      double var9 = 2.0;
      double var11 = this.f_7fd3d7b7.m_4388ac29() - this.padding * 2.0 - this.sliderWidth;
      ((QuadRenderStack)((QuadRenderStack)this.quadRenderStack.begin().glColor(Color.green))
            .drawRect(this.f_7fd3d7b7.m_a005efae() + var11, var7 - var9 / 2.0, this.f_7fd3d7b7.m_a005efae() + var11 + this.sliderOffset, var7 + var9 / 2.0)
            .glColor(Color.red))
         .drawRect(
            this.f_7fd3d7b7.m_a005efae() + var11 + this.sliderOffset,
            var7 - var9 / 2.0,
            this.f_7fd3d7b7.m_a005efae() + var11 + this.sliderWidth,
            var7 + var9 / 2.0
         )
         .end();
      ((CircleRenderStack)this.circleRenderStack.glColor(Color.white))
         .begin()
         .drawFilledCircle((float)(this.f_7fd3d7b7.m_a005efae() + var11 + this.sliderOffset), (float)var7, 5.0F)
         .end();
      return var6;
   }

   @Override
   protected void onClick(int var1) {
      if (var1 == 0) {
         this.apply(this.enabled = !this.enabled);
         this.animation.m_41e83f88();
      }
   }

   protected abstract void apply(boolean var1);

   public boolean isEnabled() {
      return this.enabled;
   }

   public void setEnabled(boolean var1) {
      this.enabled = var1;
   }

   public double getSliderWidth() {
      return this.sliderWidth;
   }

   public void setSliderWidth(double var1) {
      this.sliderWidth = var1;
   }

   public C0233 getAnimation() {
      return this.animation;
   }
}
