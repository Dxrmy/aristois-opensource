package me.deftware.aristois.menu.view.container;

import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0233;
import me.deftware.aristois.recovered.C0441;

public class CollapsableContainerWidget extends ContainerWidget {
   protected boolean collapsed = false;
   protected double lastHeight;
   protected double lastMin;
   protected double lastMax;
   protected double top;
   private final C0233 animation = new C0233(110.0F, 16.0) {
      protected void m_643def40(double var1) {
         double var3 = CollapsableContainerWidget.this.collapsed ? 1.0 - var1 : var1;
         C0114.bootstrap<"call",0,1>(CollapsableContainerWidget.this)
            .m_5078410c(CollapsableContainerWidget.this.top + var3 * CollapsableContainerWidget.this.lastHeight);
      }

      protected void m_c6159347() {
         C0114.bootstrap<"call",0,1>(CollapsableContainerWidget.this)
            .m_5078410c(
               CollapsableContainerWidget.this.collapsed
                  ? CollapsableContainerWidget.this.top
                  : CollapsableContainerWidget.this.top + CollapsableContainerWidget.this.lastHeight
            );
      }
   };

   public CollapsableContainerWidget(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
   }

   public boolean m_9bc24962(double var1, double var3, float var5, boolean var6) {
      this.animation.m_61a5f120(var5);
      return super.m_0812cc67(var1, var3, var5, var6);
   }

   public boolean togglePanel(boolean var1) {
      if (var1 && !this.animation.m_f6c24736()) {
         return false;
      } else {
         this.top = ((C0163)this.m_b7206ffa().get(0)).m_fd6ca281().m_fc7f45bc();
         if (!this.collapsed) {
            this.lastHeight = this.f_2d2431f4.m_fc7f45bc() - this.top;
            this.lastMin = this.getMinHeight();
            this.lastMax = this.getMaxHeight();
            this.setMaxHeight(this.f_2d2431f4.m_fc7f45bc());
            this.setMinHeight(this.f_2d2431f4.m_fc7f45bc());
            if (!var1) {
               this.f_2d2431f4.m_5078410c(this.top);
            }
         } else {
            this.setMinHeight(this.lastMin);
            this.setMaxHeight(this.lastMax);
            if (!var1) {
               this.f_2d2431f4.m_5078410c(this.top + this.lastHeight);
            }
         }

         this.collapsed = !this.collapsed;
         if (var1) {
            this.animation.m_bb3577b4();
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
