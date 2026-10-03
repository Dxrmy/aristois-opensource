package me.deftware.aristois.recovered;

import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.CollapsableContainerWidget;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.TextBoxWidget;
import me.deftware.client.framework.message.Message;

public class C0435 extends CollapsableContainerWidget {
   protected TextBoxWidget f_3f42ec57;
   protected ListWidget f_571e47d7;

   public C0435(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.setDraggable(true);
      this.setResizable(true);
      this.setRenderShadow(true);
      this.setScissor(true);
   }

   public void m_992e0c64(C0446 var1) {
      this.addTitle(Message.of(C0261.m_62895921()), var1x -> {
         if (var1x == 1 && this.togglePanel(true)) {
            this.getTitle().getArrow().m_1058ed9a();
         }
      });
      this.title.setDrawIcon(true);
      this.title.setIconU(0);
      this.title.setIconV(2 * this.title.getAtlas().m_5b3d3148());
      this.setMinHeight(this.title.m_44bb072f().m_d42f3372() * 2.0 + 30.0);
      this.setMaxHeight(800.0);
      this.f_3f42ec57 = new TextBoxWidget(this.f_02ea293d) {
         @Override
         protected void apply(String var1) {
         }

         @Override
         protected void process() {
            super.process();
            if (C0435.this.f_571e47d7 != null) {
               C0435.this.f_571e47d7.setOffset(0.0);
            }
         }
      };
      this.f_3f42ec57.setShadowText(C0267.m_1616e137());
      this.f_3f42ec57.m_ec141b95(new C0426[]{C0426.f_c285454f});
      this.f_3f42ec57.setTextAlign(C0427.f_26bd24ae);
      this.f_3f42ec57.m_44bb072f().m_f8b16cfb(0.0, this.getTitle().m_44bb072f().m_d42f3372());
      this.f_3f42ec57.m_c7a3618c(new RectTooltip(this.f_3f42ec57, this.f_02ea293d, Message.of(C0262.m_8ccfdf29())));
      this.m_cb54a800(new C0163[]{this.f_3f42ec57});
      this.f_571e47d7 = new ListWidget(this.f_02ea293d);
      this.f_571e47d7.m_ec141b95(new C0426[]{C0426.f_c285454f, C0426.f_f7a0f908});
      this.f_571e47d7.m_44bb072f().m_f8b16cfb(0.0, this.getTitle().m_44bb072f().m_d42f3372() + this.f_3f42ec57.m_44bb072f().m_d42f3372());
      this.f_571e47d7.setRenderBackground(false);
      this.f_571e47d7.setFilter(var1x -> !this.f_3f42ec57.getText().isEmpty() && var1x.m_828a75ae(this.f_3f42ec57.getText()));
      this.m_cb54a800(new C0163[]{this.f_571e47d7});
   }

   public ListWidget m_1375bd37() {
      return this.f_571e47d7;
   }
}
