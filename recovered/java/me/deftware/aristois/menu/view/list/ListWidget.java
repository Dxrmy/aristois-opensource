package me.deftware.aristois.menu.view.list;

import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.SliderWidget;
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
      this.scrollbar.m_e0dc32f6(new C0425[]{C0425.f_112499ce, C0425.f_480e521b});
      this.scrollbar.m_ec141b95(new C0426[]{C0426.f_f7a0f908});
      this.scrollbar.m_facdcfcf(this);
      this.m_cb54a800(new C0163[]{this.scrollbar});
   }

   @Override
   public void m_0e265701() {
      this.maxHeight = this.getWidgetStream().filter(var0 -> !(var0 instanceof ScrollbarWidget)).mapToDouble(var0 -> var0.m_44bb072f().m_d42f3372()).sum()
         - this.f_7fd3d7b7.m_d42f3372();
      super.m_0e265701();
   }

   public Stream<C0163> getWidgetStream() {
      return this.children.stream().filter(this::shouldDrawChild);
   }

   public boolean isAtTop() {
      return this.offset == 0.0;
   }

   public void adjust() {
      C0165 var1 = this.children.get(this.children.size() - 1).m_44bb072f();
      double var2 = var1.m_84808068() + var1.m_d42f3372();
      double var4 = this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372();
      if (!this.isAtTop() && var2 < var4) {
         double var6 = var4 - var2;
         this.offset -= var6;
      }
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      if (this.f_a54daaa0) {
         var1 = this.getEmulatedMouseX();
         var3 = this.getEmulatedMouseY();
      }

      return super.m_572d14e6(var1, var3, var5, var6);
   }

   protected double getEmulatedMouseX() {
      return this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29() / 2.0;
   }

   protected double getScrollOffset() {
      return this.children.get(1).m_44bb072f().m_d42f3372();
   }

   protected double getEmulatedMouseY() {
      double var1 = this.getSelectedIndexPosition(this.selectedIndex) - this.getScrollOffset() / 2.0;
      if (this.scrollbar.shouldUseScrollbar()) {
         var1 -= this.offset;
      }

      return var1;
   }

   protected double getSelectedIndexPosition(int var1) {
      return this.f_7fd3d7b7.m_84808068() + this.getScrollOffset() * (double)(var1 + 1);
   }

   @Override
   public boolean m_82e0832a(int var1, int var2, int var3) {
      if (this.f_a54daaa0) {
         if (var1 == 265 || var1 == 264) {
            this.setSelectedIndex(this.selectedIndex + (var1 == 265 ? -1 : 1));
            this.emulateScroll(var1);
         } else if (var1 == 262 || var1 == 257 || var1 == 335) {
            double var4 = this.getEmulatedMouseX();
            double var6 = this.getEmulatedMouseY();
            double var8 = var1 == 262 ? 0.0 : 1.0;
            this.m_8407b1bf(var4, var6, (int)var8);
            this.m_a2722fba(var4, var6, (int)var8);
         }
      }

      return super.m_82e0832a(var1, var2, var3);
   }

   protected void emulateScroll(int var1) {
      double var2 = this.getScrollOffset();
      double var4 = this.getSelectedIndexPosition(this.selectedIndex - (var1 == 265 ? 1 : 0)) - this.offset;
      if (this.scrollbar.shouldUseScrollbar()
         && (var4 > this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372() && var1 == 264 || var4 < this.f_7fd3d7b7.m_84808068() && var1 == 265)) {
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
      boolean var8 = this.scrollbar.m_44bb072f().m_a58797d6(var1, var3);
      var6 = super.drawChildren(var1, var3, var5, var6 || this.scrollbar.isMouseDrag() || var8);
      if (var6 && !var6 && var8) {
         var6 = false;
      }

      return this.scrollbar.m_572d14e6(var1, var3, var5, var6);
   }

   @Override
   protected void applyBoundsUpdates(C0163 var1) {
      var1.m_44bb072f().m_f8b16cfb(0.0, this.childY);
      if (!(var1 instanceof ScrollbarWidget)) {
         this.childY = this.childY + var1.m_44bb072f().m_d42f3372();
      }

      super.applyBoundsUpdates(var1);
      if (!(var1 instanceof ScrollbarWidget) && this.scrollbar.shouldUseScrollbar() && (this.offsetForScrollbar || var1 instanceof C0445.anonymouscatch)) {
         var1.m_44bb072f().m_6fd9bdae(var1.m_44bb072f().m_4388ac29() - this.scrollbar.m_44bb072f().m_4388ac29());
      }
   }

   @Override
   public void m_0eebc025(double var1, double var3) {
      if (this.f_7fd3d7b7.m_a58797d6(this.mouseX, this.mouseY)) {
         this.scrollbar.m_0eebc025(var1, var3);
      }

      super.m_0eebc025(var1, var3);
   }

   public int getMaxSelectionIndex() {
      return (int)this.getWidgetStream().count();
   }

   public void setSelectedIndex(int var1) {
      this.selectedIndex = (int)SliderWidget.clamp(0.0, (double)(this.getMaxSelectionIndex() - 2), (double)var1);
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
