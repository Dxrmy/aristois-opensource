package me.deftware.aristois.menu.view.container;

import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0428;
import me.deftware.aristois.recovered.C0437;
import me.deftware.aristois.recovered.C0441;

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
      this.minWidth = this.f_feb528bb.m_830cb294();
      this.minHeight = this.f_feb528bb.m_fc7f45bc();
      this.maxWidth = this.minWidth * 3.0;
      this.maxHeight = this.minHeight * 3.0;
   }

   public boolean m_c50ec0f2(double var1, double var3, float var5, boolean var6) {
      this.mouseX = var1;
      this.mouseY = var3;
      return this.update(var6);
   }

   public boolean m_07141b75(double var1, double var3, int var5) {
      this.dragging = this.resizeLeft = this.resizeRight = this.resizeBottom = false;
      return false;
   }

   public boolean m_0099f3c3(double var1, double var3, int var5) {
      if (var5 == 0) {
         if (this.f_feb528bb.m_25a0ff0c(this.draggableBorder).m_263d91ea(var1, var3)) {
            if (!this.draggable) {
               return false;
            }

            this.dragging = true;
            this.x2 = this.f_feb528bb.m_14f8bc2c() - var1;
            this.y2 = this.f_feb528bb.m_5a998971() - var3;
         } else if (this.resizable) {
            this.resizeLeft = this.f_feb528bb.m_4469d4c1(this.border).m_263d91ea(var1, var3);
            this.resizeRight = this.f_feb528bb.m_2880a42d(this.border).m_263d91ea(var1, var3);
            this.resizeBottom = this.f_feb528bb.m_6e88c212(this.border).m_263d91ea(var1, var3);
            if (this.resizeLeft) {
               this.oldWidth = this.f_feb528bb.m_830cb294() + this.f_feb528bb.m_14f8bc2c();
            }
         }
      }

      return var5 == 0 && (this.dragging || this.resizeLeft || this.resizeRight || this.resizeBottom);
   }

   protected boolean update(boolean var1) {
      if (this.dragging) {
         double var2 = this.x2 + this.mouseX;
         double var4 = this.y2 + this.mouseY;
         this.f_feb528bb
            .m_1e49f000(
               (double)((float)(var2 > -1.0 ? var2 : this.f_feb528bb.m_14f8bc2c())), (double)((float)(var4 > -1.0 ? var4 : this.f_feb528bb.m_5a998971()))
            );
      } else {
         if (this.resizeBottom) {
            this.f_feb528bb
               .m_5078410c(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(this.mouseY - this.f_feb528bb.m_5a998971(), this.minHeight), this.maxHeight));
         }

         if (this.resizeLeft) {
            double var6 = this.oldWidth - this.mouseX;
            if (var6 <= this.maxWidth && var6 >= this.minWidth) {
               this.f_feb528bb.m_b9e3750e(var6);
               this.f_feb528bb.m_6894765d(this.f_feb528bb.m_14f8bc2c() + (this.mouseX - this.f_feb528bb.m_14f8bc2c()));
            }
         } else if (this.resizeRight) {
            this.f_feb528bb
               .m_b9e3750e(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(this.mouseX - this.f_feb528bb.m_14f8bc2c(), this.minWidth), this.maxWidth));
         }
      }

      return var1 || this.dragging || this.resizeBottom || this.resizeLeft || this.resizeRight;
   }

   protected int getModificationCursor(double var1, double var3) {
      boolean var5 = C0114.bootstrap<"call",0,1>(0);
      if (!this.f_feb528bb.m_25a0ff0c(this.draggableBorder).m_263d91ea(var1, var3) && this.resizable) {
         if (this.resizeLeft
            || this.f_feb528bb.m_4469d4c1(this.border).m_263d91ea(var1, var3) && !var5
            || this.resizeRight
            || this.f_feb528bb.m_2880a42d(this.border).m_263d91ea(var1, var3) && !var5) {
            return 221189;
         }

         if (this.resizeBottom || this.f_feb528bb.m_6e88c212(this.border).m_263d91ea(var1, var3) && !var5) {
            return 221190;
         }
      }

      return -1;
   }

   public int m_ba20b599(double var1, double var3) {
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
