package me.deftware.aristois.menu.view.list;

import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0165;
import me.deftware.aristois.recovered.C0425;
import me.deftware.aristois.recovered.C0426;
import me.deftware.aristois.recovered.C0441;
import me.deftware.aristois.recovered.C0442;
import me.deftware.aristois.recovered.C0444;
import me.deftware.aristois.recovered.C0445;

public class ListWidget extends ContainerWidget implements C0444, C0442 {
   private double offset = 0.0;
   private final ScrollbarWidget scrollbar;
   protected boolean offsetForScrollbar = false;
   protected Predicate<C0163> filter = null;
   protected int selectedIndex = 0;
   private double childY;

   public ListWidget(C0441 var1) {
      this(0.0, 0.0, 0.0, 0.0, var1);
   }

   public ListWidget(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.setStencil(true);
      this.setBorder(0.0);
      this.scrollbar = new ScrollbarWidget(0.0, 0.0, 0.0, this, var9);
      this.scrollbar.m_ddfc24dd(new C0425[]{C0425.f_ddff7994, C0425.f_d199628e});
      this.scrollbar.m_76f88ed1(new C0426[]{C0426.f_eabcfd17});
      this.scrollbar.m_73a69d71(this);
      this.m_2fe952ac(new C0163[]{this.scrollbar});
   }

   public void m_87882ef9() {
      this.maxHeight = this.getWidgetStream().filter(var0 -> !(var0 instanceof ScrollbarWidget)).mapToDouble(var0 -> var0.m_fd6ca281().m_fc7f45bc()).sum()
         - this.f_01701ee4.m_fc7f45bc();
      super.m_5af6401b();
   }

   public Stream<C0163> getWidgetStream() {
      return this.children.stream().filter(this::shouldDrawChild);
   }

   public boolean isAtTop() {
      return this.offset == 0.0;
   }

   public void adjust() {
      C0165 var1 = this.children.get(this.children.size() - 1).m_fd6ca281();
      double var2 = var1.m_5a998971() + var1.m_fc7f45bc();
      double var4 = this.f_01701ee4.m_5a998971() + this.f_01701ee4.m_fc7f45bc();
      if (!this.isAtTop() && var2 < var4) {
         double var6 = var4 - var2;
         this.offset -= var6;
      }
   }

   public boolean m_83e9d7c4(double var1, double var3, float var5, boolean var6) {
      if (this.f_6bde22ac) {
         var1 = this.getEmulatedMouseX();
         var3 = this.getEmulatedMouseY();
      }

      return super.m_0812cc67(var1, var3, var5, var6);
   }

   protected double getEmulatedMouseX() {
      return this.f_01701ee4.m_14f8bc2c() + this.f_01701ee4.m_830cb294() / 2.0;
   }

   protected double getScrollOffset() {
      return this.children.get(1).m_fd6ca281().m_fc7f45bc();
   }

   protected double getEmulatedMouseY() {
      double var1 = this.getSelectedIndexPosition(this.selectedIndex) - this.getScrollOffset() / 2.0;
      if (this.scrollbar.shouldUseScrollbar()) {
         var1 -= this.offset;
      }

      return var1;
   }

   protected double getSelectedIndexPosition(int var1) {
      return this.f_01701ee4.m_5a998971() + this.getScrollOffset() * (double)(var1 + 1);
   }

   public boolean m_f740f834(int var1, int var2, int var3) {
      if (this.f_6bde22ac) {
         if (var1 == 265 || var1 == 264) {
            this.setSelectedIndex(this.selectedIndex + (var1 == 265 ? -1 : 1));
            this.emulateScroll(var1);
         } else if (var1 == 262 || var1 == 257 || var1 == 335) {
            double var4 = this.getEmulatedMouseX();
            double var6 = this.getEmulatedMouseY();
            double var8 = var1 == 262 ? 0.0 : 1.0;
            this.m_79b66435(var4, var6, (int)var8);
            this.m_4d207f83(var4, var6, (int)var8);
         }
      }

      return super.m_480a8f0c(var1, var2, var3);
   }

   protected void emulateScroll(int var1) {
      double var2 = this.getScrollOffset();
      double var4 = this.getSelectedIndexPosition(this.selectedIndex - (var1 == 265 ? 1 : 0)) - this.offset;
      if (this.scrollbar.shouldUseScrollbar()
         && (var4 > this.f_01701ee4.m_5a998971() + this.f_01701ee4.m_fc7f45bc() && var1 == 264 || var4 < this.f_01701ee4.m_5a998971() && var1 == 265)) {
         this.scrollbar.setScrollerPosition(this.offset + (var1 == 265 ? -var2 : var2));
      }
   }

   @Override
   protected boolean shouldDrawChild(C0163 var1) {
      if (var1 instanceof ScrollbarWidget) {
         return true;
      } else {
         return this.filter != null ? this.filter.test(var1) : true;
      }
   }

   @Override
   protected boolean drawChildren(double var1, double var3, float var5, boolean var6) {
      if (this.filter == null) {
         this.adjust();
      }

      this.childY = -this.offset;
      boolean var8 = this.scrollbar.m_a8b3253d().m_263d91ea(var1, var3);
      var6 = super.drawChildren(var1, var3, var5, var6 || this.scrollbar.isMouseDrag() || var8);
      if (var6 && !var6 && var8) {
         var6 = false;
      }

      return this.scrollbar.m_788c4140(var1, var3, var5, var6);
   }

   @Override
   protected void applyBoundsUpdates(C0163 var1) {
      var1.m_fd6ca281().m_1e49f000(0.0, this.childY);
      if (!(var1 instanceof ScrollbarWidget)) {
         this.childY = this.childY + var1.m_fd6ca281().m_fc7f45bc();
      }

      super.applyBoundsUpdates(var1);
      if (!(var1 instanceof ScrollbarWidget) && this.scrollbar.shouldUseScrollbar() && (this.offsetForScrollbar || var1 instanceof C0445.anonymouscatch)) {
         var1.m_fd6ca281().m_b9e3750e(var1.m_fd6ca281().m_830cb294() - this.scrollbar.m_a8b3253d().m_830cb294());
      }
   }

   public void m_5b4b4c35(double var1, double var3) {
      if (this.f_01701ee4.m_263d91ea(this.mouseX, this.mouseY)) {
         this.scrollbar.m_fa6274fd(var1, var3);
      }

      super.m_15d8ac14(var1, var3);
   }

   public int getMaxSelectionIndex() {
      return (int)this.getWidgetStream().count();
   }

   public void setSelectedIndex(int var1) {
      this.selectedIndex = (int)C0114.bootstrap<"call",0,1>(0.0, (double)(this.getMaxSelectionIndex() - 2), (double)var1);
   }

   public void setOffset(double var1) {
      this.offset = var1;
   }

   public void setOffsetForScrollbar(boolean var1) {
      this.offsetForScrollbar = var1;
   }

   public void setFilter(Predicate<C0163> var1) {
      this.filter = var1;
   }

   public void setChildY(double var1) {
      this.childY = var1;
   }

   public double getOffset() {
      return this.offset;
   }

   public ScrollbarWidget getScrollbar() {
      return this.scrollbar;
   }

   public boolean isOffsetForScrollbar() {
      return this.offsetForScrollbar;
   }

   public Predicate<C0163> getFilter() {
      return this.filter;
   }

   public int getSelectedIndex() {
      return this.selectedIndex;
   }

   public double getChildY() {
      return this.childY;
   }
}
