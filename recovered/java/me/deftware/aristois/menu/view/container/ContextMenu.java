package me.deftware.aristois.menu.view.container;

import java.awt.Color;
import java.util.List;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0150;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0165;
import me.deftware.aristois.recovered.C0424;
import me.deftware.aristois.recovered.C0426;
import me.deftware.aristois.recovered.C0440;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.message.Message;

public class ContextMenu extends ContainerWidget {
   private Object parent;
   private C0165 parentBounds;
   private double parentY;

   public ContextMenu(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
   }

   public void open(C0165 var1, double var2, double var4, Object var6) {
      this.m_1d4f9fac();
      double var7 = var4 - this.f_a6bf74ab.m_fc7f45bc();
      if (var7 < 5.0) {
         var7 = var4;
      }

      this.f_a6bf74ab.m_1e49f000(var2, var7);
      this.parentBounds = var1;
      this.parentY = var1.m_5a998971();
      this.parent = var6;
      List var9 = var6 instanceof C0150 ? ((C0150)var6).m_dcccdb46() : ((C0440)var6).m_eddfd516();
      var9.add(this);
   }

   public void m_1d4f9fac() {
      this.recalculate();
      super.m_1a604be5();
   }

   @Override
   public void close() {
      if (this.isOpen()) {
         List var1 = this.parent instanceof C0150 ? ((C0150)this.parent).m_dcccdb46() : ((C0440)this.parent).m_eddfd516();
         var1.remove(this);
      }
   }

   public boolean isOpen() {
      if (this.parent != null) {
         List var1 = this.parent instanceof C0150 ? ((C0150)this.parent).m_dcccdb46() : ((C0440)this.parent).m_eddfd516();
         return var1.contains(this);
      } else {
         return false;
      }
   }

   public void recalculate() {
      List var1 = ((ListWidget)this.children.get(0)).getWidgetStream().collect(C0114.bootstrap<"call",0,1>());
      double var2 = ((ListWidget)this.children.get(0)).getChildrenHeight(this.f_7e70c07c.m_2c697834(), var1);
      this.m_a7b7deb2().m_5078410c(var2);
   }

   @Override
   protected Color getBackgroundColor() {
      return this.f_7e70c07c.m_8a513671();
   }

   public void m_f2d21732() {
      super.m_5af6401b();
      if (this.parentY != this.parentBounds.m_5a998971()) {
         this.close();
      }
   }

   public boolean m_7258474a(double var1, double var3, int var5) {
      if (this.f_a6bf74ab.m_263d91ea(var1, var3)) {
         return super.m_00a883b1(var1, var3, var5);
      } else {
         if (var5 == 0 || !this.parentBounds.m_263d91ea(var1, var3)) {
            this.close();
         }

         return false;
      }
   }

   public static class ContextBuilder implements C0424<ContextMenu, ContextMenu.ContextBuilder> {
      private final ContextMenu contextMenu;
      private final ListWidget listWidget;
      private final C0441 theme;

      public ContextBuilder(double var1, C0441 var3) {
         this.contextMenu = new ContextMenu(0.0, 0.0, 200.0, 0.0, this.theme = var3);
         this.listWidget = new ListWidget(0.0, 0.0, var1, 0.0, var3);
         this.listWidget.m_43380922(new C0426[]{C0426.f_974a55e6, C0426.f_eabcfd17});
         this.listWidget.setRenderBackground(false);
         this.listWidget.setStencil(true);
         this.contextMenu.m_bef6f0d7(new C0163[]{this.listWidget});
      }

      public ContextMenu.ContextBuilder button(Message var1, final Runnable var2) {
         ButtonWidget var3 = new ButtonWidget(var1, this.theme) {
            @Override
            protected void onClick(int var1) {
               if (var1 == 0) {
                  var2.run();
               }
            }
         };
         var3.m_e61ee212(new C0426[]{C0426.f_974a55e6});
         this.listWidget.m_2fe952ac(new C0163[]{var3});
         return this;
      }

      public ContextMenu build() {
         return this.contextMenu;
      }
   }
}
