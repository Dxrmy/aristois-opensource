package me.deftware.aristois.menu.view.container;

import me.deftware.aristois.recovered.C0428;
import me.deftware.aristois.recovered.C0437;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.input.Mouse;

public abstract class ModifiableWidget extends C0428 implements C0437 {
   protected boolean dragging = false;
   protected boolean resizable = false;
   protected boolean draggable = false;
   protected double border = 10.0;
   protected double draggableBorder = 30.0;
   protected double minWidth;
   protected double minHeight;
   protected double maxHeight;
   protected double maxWidth;
   protected boolean resizeLeft = false;
   protected boolean resizeRight = false;
   protected boolean resizeBottom = false;
   protected int cursor = -1;
   protected double mouseX = 0.0;
   protected double mouseY = 0.0;
   protected double x2 = 0.0;
   protected double y2 = 0.0;
   protected double oldWidth;

   public ModifiableWidget(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.minWidth = this.f_7fd3d7b7.m_4388ac29();
      this.minHeight = this.f_7fd3d7b7.m_d42f3372();
      this.maxWidth = this.minWidth * 3.0;
      this.maxHeight = this.minHeight * 3.0;
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      this.mouseX = var1;
      this.mouseY = var3;
      return this.update(var6);
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      this.dragging = this.resizeLeft = this.resizeRight = this.resizeBottom = false;
      return false;
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      if (var5 == 0) {
         if (this.f_7fd3d7b7.m_4b9c6d2e(this.draggableBorder).m_a58797d6(var1, var3)) {
            if (!this.draggable) {
               return false;
            }

            this.dragging = true;
            this.x2 = this.f_7fd3d7b7.m_a005efae() - var1;
            this.y2 = this.f_7fd3d7b7.m_84808068() - var3;
         } else if (this.resizable) {
            this.resizeLeft = this.f_7fd3d7b7.m_f516a783(this.border).m_a58797d6(var1, var3);
            this.resizeRight = this.f_7fd3d7b7.m_c3f845f3(this.border).m_a58797d6(var1, var3);
            this.resizeBottom = this.f_7fd3d7b7.m_95fe5030(this.border).m_a58797d6(var1, var3);
            if (this.resizeLeft) {
               this.oldWidth = this.f_7fd3d7b7.m_4388ac29() + this.f_7fd3d7b7.m_a005efae();
            }
         }
      }

      return var5 == 0 && (this.dragging || this.resizeLeft || this.resizeRight || this.resizeBottom);
   }

   protected boolean update(boolean var1) {
      if (this.dragging) {
         double var2 = this.x2 + this.mouseX;
         double var4 = this.y2 + this.mouseY;
         this.f_7fd3d7b7
            .m_f8b16cfb(
               (double)((float)(var2 > -1.0 ? var2 : this.f_7fd3d7b7.m_a005efae())), (double)((float)(var4 > -1.0 ? var4 : this.f_7fd3d7b7.m_84808068()))
            );
      } else {
         if (this.resizeBottom) {
            this.f_7fd3d7b7.m_61ade8f3(Math.min(Math.max(this.mouseY - this.f_7fd3d7b7.m_84808068(), this.minHeight), this.maxHeight));
         }

         if (this.resizeLeft) {
            double var6 = this.oldWidth - this.mouseX;
            if (var6 <= this.maxWidth && var6 >= this.minWidth) {
               this.f_7fd3d7b7.m_6fd9bdae(var6);
               this.f_7fd3d7b7.m_dadc1f5d(this.f_7fd3d7b7.m_a005efae() + (this.mouseX - this.f_7fd3d7b7.m_a005efae()));
            }
         } else if (this.resizeRight) {
            this.f_7fd3d7b7.m_6fd9bdae(Math.min(Math.max(this.mouseX - this.f_7fd3d7b7.m_a005efae(), this.minWidth), this.maxWidth));
         }
      }

      return var1 || this.dragging || this.resizeBottom || this.resizeLeft || this.resizeRight;
   }

   protected int getModificationCursor(double var1, double var3) {
      boolean var5 = Mouse.isButtonDown(0);
      if (!this.f_7fd3d7b7.m_4b9c6d2e(this.draggableBorder).m_a58797d6(var1, var3) && this.resizable) {
         if (this.resizeLeft
            || this.f_7fd3d7b7.m_f516a783(this.border).m_a58797d6(var1, var3) && !var5
            || this.resizeRight
            || this.f_7fd3d7b7.m_c3f845f3(this.border).m_a58797d6(var1, var3) && !var5) {
            return 221189;
         }

         if (this.resizeBottom || this.f_7fd3d7b7.m_95fe5030(this.border).m_a58797d6(var1, var3) && !var5) {
            return 221190;
         }
      }

      return -1;
   }

   @Override
   public int m_3abf02d1(double var1, double var3) {
      return this.getModificationCursor(var1, var3);
   }

   public boolean isDragging() {
      return this.dragging;
   }

   public boolean isResizable() {
      return this.resizable;
   }

   public boolean isDraggable() {
      return this.draggable;
   }

   public void setResizable(boolean var1) {
      this.resizable = var1;
   }

   public void setDraggable(boolean var1) {
      this.draggable = var1;
   }

   public double getBorder() {
      return this.border;
   }

   public double getDraggableBorder() {
      return this.draggableBorder;
   }

   public double getMinWidth() {
      return this.minWidth;
   }

   public double getMinHeight() {
      return this.minHeight;
   }

   public double getMaxHeight() {
      return this.maxHeight;
   }

   public double getMaxWidth() {
      return this.maxWidth;
   }

   public void setBorder(double var1) {
      this.border = var1;
   }

   public void setDraggableBorder(double var1) {
      this.draggableBorder = var1;
   }

   public void setMinWidth(double var1) {
      this.minWidth = var1;
   }

   public void setMinHeight(double var1) {
      this.minHeight = var1;
   }

   public void setMaxHeight(double var1) {
      this.maxHeight = var1;
   }

   public void setMaxWidth(double var1) {
      this.maxWidth = var1;
   }

   public boolean isResizeLeft() {
      return this.resizeLeft;
   }

   public boolean isResizeRight() {
      return this.resizeRight;
   }

   public boolean isResizeBottom() {
      return this.resizeBottom;
   }

   public int getCursor() {
      return this.cursor;
   }
}
