package me.deftware.aristois.recovered;

import me.deftware.aristois.menu.view.container.CollapsableContainerWidget;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.ModButton;

public class C0430 extends CollapsableContainerWidget {
   protected ListWidget f_e971bfa6;

   public C0430(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.setDraggable(true);
      this.setResizable(true);
      this.setRenderShadow(true);
      this.setScissor(true);
   }

   public void m_d24b6a6b(C0446 var1) {
      this.addTitle(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901988>()), var1x -> {
         if (var1x == 1 && this.togglePanel(true)) {
            this.getTitle().getArrow().m_dcc9a738();
         }
      });
      this.title.setDrawIcon(true);
      C0234 var2 = C0228.f_1a35892e;
      this.title.setIconU(var2.m_a41b5737(9));
      this.title.setIconV(var2.m_28584246(9));
      this.setMinHeight(this.title.m_cb4e693c().m_fc7f45bc() * 2.0 + 30.0);
      this.setMaxHeight(800.0);
      this.f_e971bfa6 = new ListWidget(this.f_cba2b7f0);
      this.f_e971bfa6.m_43380922(new C0426[]{C0426.f_974a55e6, C0426.f_eabcfd17});
      this.f_e971bfa6.m_a0d63011().m_1e49f000(0.0, this.getTitle().m_cb4e693c().m_fc7f45bc());
      this.f_e971bfa6.setRenderBackground(false);
      this.f_e971bfa6.setFilter(var0 -> var0 instanceof ModButton ? ((ModButton)var0).getMod().isPinned() : false);
      this.m_ccb3f261(new C0163[]{this.f_e971bfa6});
   }

   public ListWidget m_7a902567() {
      return this.f_e971bfa6;
   }
}
