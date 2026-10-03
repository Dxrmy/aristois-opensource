package me.deftware.aristois.recovered;

import me.deftware.aristois.menu.view.container.CollapsableContainerWidget;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.ModButton;
import me.deftware.client.framework.message.Message;

public class C0430 extends CollapsableContainerWidget {
   protected ListWidget f_1a711060;

   public C0430(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.setDraggable(true);
      this.setResizable(true);
      this.setRenderShadow(true);
      this.setScissor(true);
   }

   public void m_992e0c64(C0446 var1) {
      this.addTitle(Message.of(C0266.m_8ccfdf29()), var1x -> {
         if (var1x == 1 && this.togglePanel(true)) {
            this.getTitle().getArrow().m_1058ed9a();
         }
      });
      this.title.setDrawIcon(true);
      C0234 var2 = C0228.f_12b529e0;
      this.title.setIconU(var2.m_a73ee2be(9));
      this.title.setIconV(var2.m_8cb6f232(9));
      this.setMinHeight(this.title.m_44bb072f().m_d42f3372() * 2.0 + 30.0);
      this.setMaxHeight(800.0);
      this.f_1a711060 = new ListWidget(this.f_02ea293d);
      this.f_1a711060.m_ec141b95(new C0426[]{C0426.f_c285454f, C0426.f_f7a0f908});
      this.f_1a711060.m_44bb072f().m_f8b16cfb(0.0, this.getTitle().m_44bb072f().m_d42f3372());
      this.f_1a711060.setRenderBackground(false);
      this.f_1a711060.setFilter(var0 -> var0 instanceof ModButton ? ((ModButton)var0).getMod().isPinned() : false);
      this.m_cb54a800(new C0163[]{this.f_1a711060});
   }

   public ListWidget m_1375bd37() {
      return this.f_1a711060;
   }
}
