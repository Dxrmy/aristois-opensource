package me.deftware.aristois.recovered;

import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.CollapsableContainerWidget;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.TextBoxWidget;

public class C0435 extends CollapsableContainerWidget {
   protected TextBoxWidget f_52d4516e;
   protected ListWidget f_a7ece461;

   public C0435(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.setDraggable(true);
      this.setResizable(true);
      this.setRenderShadow(true);
      this.setScissor(true);
   }

   public void m_7d5d6794(C0446 var1) {
      this.addTitle(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869307>()), var1x -> {
         if (var1x == 1 && this.togglePanel(true)) {
            this.getTitle().getArrow().m_dcc9a738();
         }
      });
      this.title.setDrawIcon(true);
      this.title.setIconU(0);
      this.title.setIconV(2 * this.title.getAtlas().m_5f2752be());
      this.setMinHeight(this.title.m_cb4e693c().m_fc7f45bc() * 2.0 + 30.0);
      this.setMaxHeight(800.0);
      this.f_52d4516e = new TextBoxWidget(this.f_7bd0c585) {
         @Override
         protected void apply(String var1) {
         }

         @Override
         protected void process() {
            super.process();
            if (C0435.this.f_a7ece461 != null) {
               C0435.this.f_a7ece461.setOffset(0.0);
            }
         }
      };
      this.f_52d4516e.setShadowText(C0252.bootstrap<"get",25769803853>());
      this.f_52d4516e.m_4103fcee(new C0426[]{C0426.f_974a55e6});
      this.f_52d4516e.setTextAlign(C0427.f_f7cee513);
      this.f_52d4516e.m_bc27aa02().m_1e49f000(0.0, this.getTitle().m_cb4e693c().m_fc7f45bc());
      this.f_52d4516e.m_e65aeff9(new RectTooltip(this.f_52d4516e, this.f_7bd0c585, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",34359738468>())));
      this.m_05e2d5ab(new C0163[]{this.f_52d4516e});
      this.f_a7ece461 = new ListWidget(this.f_7bd0c585);
      this.f_a7ece461.m_43380922(new C0426[]{C0426.f_974a55e6, C0426.f_eabcfd17});
      this.f_a7ece461.m_a0d63011().m_1e49f000(0.0, this.getTitle().m_cb4e693c().m_fc7f45bc() + this.f_52d4516e.m_bc27aa02().m_fc7f45bc());
      this.f_a7ece461.setRenderBackground(false);
      this.f_a7ece461.setFilter(var1x -> !this.f_52d4516e.getText().isEmpty() && var1x.m_1f0afaa9(this.f_52d4516e.getText()));
      this.m_05e2d5ab(new C0163[]{this.f_a7ece461});
   }

   public ListWidget m_eaadae0d() {
      return this.f_a7ece461;
   }
}
