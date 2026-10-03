package me.deftware.aristois.menu.view.container;

import java.awt.Color;
import java.util.List;
import java.util.stream.Collectors;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
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
      this.m_1058ed9a();
      double var7 = var4 - this.f_7fd3d7b7.m_d42f3372();
      if (var7 < 5.0) {
         var7 = var4;
      }

      this.f_7fd3d7b7.m_f8b16cfb(var2, var7);
      this.parentBounds = var1;
      this.parentY = var1.m_84808068();
      this.parent = var6;
      List var9 = var6 instanceof C0150 ? ((C0150)var6).m_ed46fa58() : ((C0440)var6).m_98dc1191();
      var9.add(this);
   }

   @Override
   public void m_1058ed9a() {
      this.recalculate();
      super.m_1058ed9a();
   }

   @Override
   public void close() {
      if (this.isOpen()) {
         List var1 = this.parent instanceof C0150 ? ((C0150)this.parent).m_ed46fa58() : ((C0440)this.parent).m_98dc1191();
         var1.remove(this);
      }
   }

   public boolean isOpen() {
      if (this.parent != null) {
         List var1 = this.parent instanceof C0150 ? ((C0150)this.parent).m_ed46fa58() : ((C0440)this.parent).m_98dc1191();
         return var1.contains(this);
      } else {
         return false;
      }
   }

   public void recalculate() {
      List var1 = ((ListWidget)this.children.get(0)).getWidgetStream().collect(Collectors.toList());
      double var2 = ((ListWidget)this.children.get(0)).getChildrenHeight(this.f_02ea293d.m_197b2fc8(), var1);
      this.m_44bb072f().m_61ade8f3(var2);
   }

   @Override
   protected Color getBackgroundColor() {
      return this.f_02ea293d.m_ac758c94();
   }

   @Override
   public void m_0e265701() {
      super.m_0e265701();
      if (this.parentY != this.parentBounds.m_84808068()) {
         this.close();
      }
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      if (this.f_7fd3d7b7.m_a58797d6(var1, var3)) {
         return super.m_8407b1bf(var1, var3, var5);
      } else {
         if (var5 == 0 || !this.parentBounds.m_a58797d6(var1, var3)) {
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
         this.listWidget.m_ec141b95(new C0426[]{C0426.f_c285454f, C0426.f_f7a0f908});
         this.listWidget.setRenderBackground(false);
         this.listWidget.setStencil(true);
         this.contextMenu.m_cb54a800(new C0163[]{this.listWidget});
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
         var3.m_ec141b95(new C0426[]{C0426.f_c285454f});
         this.listWidget.m_cb54a800(new C0163[]{var3});
         return this;
      }

      public ContextMenu build() {
         return this.contextMenu;
      }
   }
}
