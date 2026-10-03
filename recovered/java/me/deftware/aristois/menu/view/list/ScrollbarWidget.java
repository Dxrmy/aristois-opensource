package me.deftware.aristois.menu.view.list;

import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0233;
import me.deftware.aristois.recovered.C0428;
import me.deftware.aristois.recovered.C0437;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public class ScrollbarWidget extends C0428 implements C0437 {
   protected final QuadRenderStack quadRenderStack = new QuadRenderStack();
   protected final ListWidget parent;
   protected double scrollerHeight = 35.0;
   protected double scrollerWidth = 10.0;
   protected double scrollerY = 0.0;
   protected boolean mouseDrag = false;
   protected boolean hover = false;
   private double scrollMultiplier = 1.5;
   private double target = 0.0;
   private final C0233 animation = new C0233(140.0F, 35.0) {
      protected void m_7db92dd8(double var1) {
         ScrollbarWidget.this.setScrollerPosition(ScrollbarWidget.this.parent.getOffset() + C0114.bootstrap<"call",0,1>(ScrollbarWidget.this) * var1);
      }
   };
   private final C0233 scrollbarAnimation = new C0233(60.0F, 16.0) {
      protected void m_f2a1630d(double var1) {
         double var3 = ScrollbarWidget.this.hover ? var1 : 1.0 - var1;
         double var5 = ScrollbarWidget.this.scrollerWidth / 2.0;
         C0114.bootstrap<"call",0,1>(ScrollbarWidget.this).m_b9e3750e(var5 + var5 * var3);
      }
   };

   public ScrollbarWidget(double var1, double var3, double var5, ListWidget var7, C0441 var8) {
      super(var1, var3, 0.0, var5, var8);
      this.f_bc6bca18.m_b9e3750e(this.scrollerWidth / 2.0);
      this.parent = var7;
      this.animation.m_6a0b904b(true);
   }

   public void m_5b6f7ad4(boolean var1) {
      this.quadRenderStack.setScaled(var1);
   }

   public void m_ffb478dd() {
      this.scrollerWidth = this.f_2c057b52.m_f88faaa9();
      this.f_bc6bca18.m_b9e3750e(this.scrollerWidth / 2.0);
   }

   public boolean m_788c4140(double var1, double var3, float var5, boolean var6) {
      if (this.shouldUseScrollbar()) {
         if (this.mouseDrag) {
            this.applyDrag(var3);
         } else {
            boolean var7 = this.f_bc6bca18.m_263d91ea(var1, var3) && !var6;
            if (var7 != this.hover && this.scrollbarAnimation.m_f6c24736()) {
               this.scrollbarAnimation.m_a596028a(this.f_2c057b52.m_7455b727());
               this.hover = var7;
            } else if (this.hover && !var7 && !this.scrollbarAnimation.m_f6c24736() && !this.scrollbarAnimation.m_79e29869()) {
               this.scrollbarAnimation.m_02f7cd79();
               this.hover = false;
            }
         }

         this.animation.m_61a5f120(var5);
         this.scrollbarAnimation.m_61a5f120(var5);
         if (this.animation.m_f6c24736()) {
            this.target = 0.0;
         }

         this.renderScrollbar(var1, var3, var5);
      } else {
         this.parent.setOffset(0.0);
      }

      return var6 || this.mouseDrag;
   }

   protected double getScrollerHeightOffset() {
      return this.scrollerHeight;
   }

   protected void renderScrollbar(double var1, double var3, float var5) {
      this.updateScrollerPosition();
      ((QuadRenderStack)((QuadRenderStack)this.quadRenderStack
               .begin()
               .glColor(this.f_2c057b52.m_ad013bce().darker(), (float)this.f_2c057b52.m_ad013bce().getAlpha()))
            .drawRect(
               this.f_bc6bca18.m_14f8bc2c(),
               this.f_bc6bca18.m_5a998971(),
               this.f_bc6bca18.m_14f8bc2c() + this.f_bc6bca18.m_830cb294(),
               this.f_bc6bca18.m_5a998971() + this.f_bc6bca18.m_fc7f45bc()
            )
            .glColor(this.f_2c057b52.m_ad013bce(), (float)this.f_2c057b52.m_ad013bce().getAlpha()))
         .drawRect(
            this.f_bc6bca18.m_14f8bc2c(),
            this.f_bc6bca18.m_5a998971() + this.scrollerY,
            this.f_bc6bca18.m_14f8bc2c() + this.f_bc6bca18.m_830cb294(),
            this.f_bc6bca18.m_5a998971() + this.scrollerY + this.scrollerHeight
         )
         .end();
   }

   protected boolean shouldUseScrollbar() {
      return this.parent.getMaxHeight() > 0.0;
   }

   public void m_fa6274fd(double var1, double var3) {
      if (!this.mouseDrag) {
         if (var3 < 0.0 && this.target < 0.0 || var3 > 0.0 && this.target > 0.0) {
            this.target = 0.0;
         }

         this.target = this.target + -(var3 * this.scrollMultiplier);
         this.animation.m_bb3577b4();
      }
   }

   public boolean m_7046391a(double var1, double var3, int var5) {
      return this.mouseDrag = false;
   }

   public boolean m_a46118f7(double var1, double var3, int var5) {
      this.mouseDrag = this.f_bc6bca18.m_263d91ea(var1, var3) && this.shouldUseScrollbar();
      if (this.mouseDrag && !this.scrollbarAnimation.m_f6c24736() && !this.scrollbarAnimation.m_79e29869()) {
         this.scrollbarAnimation.m_c791de3f(0L);
      }

      return this.mouseDrag;
   }

   protected void applyDrag(double var1) {
      double var3 = var1 - this.f_bc6bca18.m_5a998971();
      var3 -= this.scrollerHeight / 2.0;
      this.setScrollerPosition(var3 / ((this.parent.m_a0d63011().m_fc7f45bc() - this.getScrollerHeightOffset()) / this.parent.getMaxHeight()));
   }

   public int m_56b0b1e2(double var1, double var3) {
      boolean var5 = C0114.bootstrap<"call",0,1>(0);
      return (this.f_bc6bca18.m_263d91ea(var1, var3) && !var5 || this.mouseDrag) && this.shouldUseScrollbar() ? 221188 : -1;
   }

   public void setScrollerPosition(double var1) {
      this.parent.setOffset(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(0.0, var1), this.parent.getMaxHeight()));
   }

   protected void updateScrollerPosition() {
      this.scrollerHeight = C0114.bootstrap<"call",0,1>(
         30.0,
         this.parent.m_a0d63011().m_fc7f45bc(),
         this.parent.m_a0d63011().m_fc7f45bc() * (this.parent.m_a0d63011().m_fc7f45bc() / (this.parent.getMaxHeight() + this.parent.m_a0d63011().m_fc7f45bc()))
      );
      this.scrollerY = (this.parent.m_a0d63011().m_fc7f45bc() - this.getScrollerHeightOffset()) / this.parent.getMaxHeight() * this.parent.getOffset();
   }

   public QuadRenderStack getQuadRenderStack() {
      return this.quadRenderStack;
   }

   public ListWidget getParent() {
      return this.parent;
   }

   public double getScrollerHeight() {
      return this.scrollerHeight;
   }

   public double getScrollerWidth() {
      return this.scrollerWidth;
   }

   public void setScrollerHeight(double var1) {
      this.scrollerHeight = var1;
   }

   public void setScrollerWidth(double var1) {
      this.scrollerWidth = var1;
   }

   public double getScrollerY() {
      return this.scrollerY;
   }

   public boolean isMouseDrag() {
      return this.mouseDrag;
   }

   public boolean isHover() {
      return this.hover;
   }

   public double getScrollMultiplier() {
      return this.scrollMultiplier;
   }

   public double getTarget() {
      return this.target;
   }

   public void setScrollMultiplier(double var1) {
      this.scrollMultiplier = var1;
   }

   public void setTarget(double var1) {
      this.target = var1;
   }

   public C0233 getAnimation() {
      return this.animation;
   }

   public C0233 getScrollbarAnimation() {
      return this.scrollbarAnimation;
   }
}
