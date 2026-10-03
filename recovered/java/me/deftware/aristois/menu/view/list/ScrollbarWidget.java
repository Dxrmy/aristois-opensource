package me.deftware.aristois.menu.view.list;

import me.deftware.aristois.menu.widgets.SliderWidget;
import me.deftware.aristois.recovered.C0233;
import me.deftware.aristois.recovered.C0428;
import me.deftware.aristois.recovered.C0437;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.input.Mouse;
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
      @Override
      protected void m_560d077c(double var1) {
         ScrollbarWidget.this.setScrollerPosition(ScrollbarWidget.this.parent.getOffset() + ScrollbarWidget.this.target * var1);
      }
   };
   private final C0233 scrollbarAnimation = new C0233(60.0F, 16.0) {
      @Override
      protected void m_560d077c(double var1) {
         double var3 = ScrollbarWidget.this.hover ? var1 : 1.0 - var1;
         double var5 = ScrollbarWidget.this.scrollerWidth / 2.0;
         ScrollbarWidget.this.f_7fd3d7b7.m_6fd9bdae(var5 + var5 * var3);
      }
   };

   public ScrollbarWidget(double var1, double var3, double var5, ListWidget var7, C0441 var8) {
      super(var1, var3, 0.0, var5, var8);
      this.f_7fd3d7b7.m_6fd9bdae(this.scrollerWidth / 2.0);
      this.parent = var7;
      this.animation.m_d6ac7420(true);
   }

   @Override
   public void m_394ecb95(boolean var1) {
      this.quadRenderStack.setScaled(var1);
   }

   @Override
   public void m_1058ed9a() {
      this.scrollerWidth = this.f_02ea293d.m_b2213d56();
      this.f_7fd3d7b7.m_6fd9bdae(this.scrollerWidth / 2.0);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      if (this.shouldUseScrollbar()) {
         if (this.mouseDrag) {
            this.applyDrag(var3);
         } else {
            boolean var7 = this.f_7fd3d7b7.m_a58797d6(var1, var3) && !var6;
            if (var7 != this.hover && this.scrollbarAnimation.m_e606d819()) {
               this.scrollbarAnimation.m_ad6c7e6f(this.f_02ea293d.m_c7c6e660());
               this.hover = var7;
            } else if (this.hover && !var7 && !this.scrollbarAnimation.m_e606d819() && !this.scrollbarAnimation.m_9362a920()) {
               this.scrollbarAnimation.m_0e265701();
               this.hover = false;
            }
         }

         this.animation.m_d881d3e3(var5);
         this.scrollbarAnimation.m_d881d3e3(var5);
         if (this.animation.m_e606d819()) {
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
               .glColor(this.f_02ea293d.m_4a97268d().darker(), (float)this.f_02ea293d.m_4a97268d().getAlpha()))
            .drawRect(
               this.f_7fd3d7b7.m_a005efae(),
               this.f_7fd3d7b7.m_84808068(),
               this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29(),
               this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372()
            )
            .glColor(this.f_02ea293d.m_4a97268d(), (float)this.f_02ea293d.m_4a97268d().getAlpha()))
         .drawRect(
            this.f_7fd3d7b7.m_a005efae(),
            this.f_7fd3d7b7.m_84808068() + this.scrollerY,
            this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29(),
            this.f_7fd3d7b7.m_84808068() + this.scrollerY + this.scrollerHeight
         )
         .end();
   }

   protected boolean shouldUseScrollbar() {
      return this.parent.getMaxHeight() > 0.0;
   }

   @Override
   public void m_0eebc025(double var1, double var3) {
      if (!this.mouseDrag) {
         if (var3 < 0.0 && this.target < 0.0 || var3 > 0.0 && this.target > 0.0) {
            this.target = 0.0;
         }

         this.target = this.target + -(var3 * this.scrollMultiplier);
         this.animation.m_41e83f88();
      }
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      return this.mouseDrag = false;
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      this.mouseDrag = this.f_7fd3d7b7.m_a58797d6(var1, var3) && this.shouldUseScrollbar();
      if (this.mouseDrag && !this.scrollbarAnimation.m_e606d819() && !this.scrollbarAnimation.m_9362a920()) {
         this.scrollbarAnimation.m_f645cd93(0L);
      }

      return this.mouseDrag;
   }

   protected void applyDrag(double var1) {
      double var3 = var1 - this.f_7fd3d7b7.m_84808068();
      var3 -= this.scrollerHeight / 2.0;
      this.setScrollerPosition(var3 / ((this.parent.m_44bb072f().m_d42f3372() - this.getScrollerHeightOffset()) / this.parent.getMaxHeight()));
   }

   @Override
   public int m_3abf02d1(double var1, double var3) {
      boolean var5 = Mouse.isButtonDown(0);
      return (this.f_7fd3d7b7.m_a58797d6(var1, var3) && !var5 || this.mouseDrag) && this.shouldUseScrollbar() ? 221188 : -1;
   }

   public void setScrollerPosition(double var1) {
      this.parent.setOffset(Math.min(Math.max(0.0, var1), this.parent.getMaxHeight()));
   }

   protected void updateScrollerPosition() {
      this.scrollerHeight = SliderWidget.clamp(
         30.0,
         this.parent.m_44bb072f().m_d42f3372(),
         this.parent.m_44bb072f().m_d42f3372() * (this.parent.m_44bb072f().m_d42f3372() / (this.parent.getMaxHeight() + this.parent.m_44bb072f().m_d42f3372()))
      );
      this.scrollerY = (this.parent.m_44bb072f().m_d42f3372() - this.getScrollerHeightOffset()) / this.parent.getMaxHeight() * this.parent.getOffset();
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
