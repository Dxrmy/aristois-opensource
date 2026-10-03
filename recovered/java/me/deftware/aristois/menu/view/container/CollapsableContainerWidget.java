package me.deftware.aristois.menu.view.container;

import me.deftware.aristois.recovered.C0233;
import me.deftware.aristois.recovered.C0441;

public class CollapsableContainerWidget extends ContainerWidget {
   protected boolean collapsed = false;
   protected double lastHeight;
   protected double lastMin;
   protected double lastMax;
   protected double top;
   private final C0233 animation = new C0233(110.0F, 16.0) {
      @Override
      protected void m_560d077c(double var1) {
         double var3 = CollapsableContainerWidget.this.collapsed ? 1.0 - var1 : var1;
         CollapsableContainerWidget.this.f_7fd3d7b7.m_61ade8f3(CollapsableContainerWidget.this.top + var3 * CollapsableContainerWidget.this.lastHeight);
      }

      @Override
      protected void m_e02771ba() {
         CollapsableContainerWidget.this.f_7fd3d7b7
            .m_61ade8f3(
               CollapsableContainerWidget.this.collapsed
                  ? CollapsableContainerWidget.this.top
                  : CollapsableContainerWidget.this.top + CollapsableContainerWidget.this.lastHeight
            );
      }
   };

   public CollapsableContainerWidget(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      this.animation.m_d881d3e3(var5);
      return super.m_572d14e6(var1, var3, var5, var6);
   }

   public boolean togglePanel(boolean var1) {
      if (var1 && !this.animation.m_e606d819()) {
         return false;
      } else {
         this.top = this.m_98dc1191().get(0).m_44bb072f().m_d42f3372();
         if (!this.collapsed) {
            this.lastHeight = this.f_7fd3d7b7.m_d42f3372() - this.top;
            this.lastMin = this.getMinHeight();
            this.lastMax = this.getMaxHeight();
            this.setMaxHeight(this.f_7fd3d7b7.m_d42f3372());
            this.setMinHeight(this.f_7fd3d7b7.m_d42f3372());
            if (!var1) {
               this.f_7fd3d7b7.m_61ade8f3(this.top);
            }
         } else {
            this.setMinHeight(this.lastMin);
            this.setMaxHeight(this.lastMax);
            if (!var1) {
               this.f_7fd3d7b7.m_61ade8f3(this.top + this.lastHeight);
            }
         }

         this.collapsed = !this.collapsed;
         if (var1) {
            this.animation.m_41e83f88();
         }

         return true;
      }
   }

   public boolean isCollapsed() {
      return this.collapsed;
   }

   public void setCollapsed(boolean var1) {
      this.collapsed = var1;
   }

   public double getLastHeight() {
      return this.lastHeight;
   }

   public double getLastMin() {
      return this.lastMin;
   }

   public double getLastMax() {
      return this.lastMax;
   }

   public double getTop() {
      return this.top;
   }

   public C0233 getAnimation() {
      return this.animation;
   }
}
