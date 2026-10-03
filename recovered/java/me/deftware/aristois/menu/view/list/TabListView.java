package me.deftware.aristois.menu.view.list;

import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0426;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.message.Message;

public class TabListView extends ContainerWidget {
   protected int selectedIndex = 0;
   protected List<ContainerWidget> tabs = new ArrayList<>();
   protected ListWidget list;

   public TabListView(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.list = new ListWidget(var9);
      this.list.m_ec141b95(new C0426[]{C0426.f_f7a0f908});
      this.list.m_44bb072f().m_6fd9bdae(80.0);
      this.m_cb54a800(new C0163[]{this.list});
   }

   public ContainerWidget addTab(Message var1) {
      ContainerWidget var2 = new ContainerWidget(this.list.m_44bb072f().m_4388ac29(), 0.0, 0.0, 0.0, this.f_02ea293d);
      var2.m_ec141b95(new C0426[]{C0426.f_c285454f, C0426.f_f7a0f908});
      var2.m_facdcfcf(this);
      this.tabs.add(var2);
      final int var3 = this.tabs.size() - 1;
      ButtonWidget var4 = new ButtonWidget(var1, this.f_02ea293d) {
         @Override
         protected void onClick(int var1) {
            TabListView.this.selectedIndex = var3;
         }
      };
      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      this.list.m_cb54a800(new C0163[]{var4});
      return var2;
   }

   @Override
   public void m_1058ed9a() {
      super.m_1058ed9a();
      this.tabs.forEach(C0163::m_1058ed9a);
   }

   @Override
   protected boolean drawChildren(double var1, double var3, float var5, boolean var6) {
      var6 = super.drawChildren(var1, var3, var5, var6);
      return this.tabs.get(this.selectedIndex).m_572d14e6(var1, var3, var5, false);
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      return this.tabs.get(this.selectedIndex).m_a2722fba(var1, var3, var5) ? true : super.m_a2722fba(var1, var3, var5);
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      boolean var6 = super.m_8407b1bf(var1, var3, var5);
      return this.tabs.get(this.selectedIndex).m_8407b1bf(var1, var3, var5);
   }

   @Override
   public void m_0e265701() {
      super.m_0e265701();
      this.tabs.get(this.selectedIndex).m_0e265701();
   }

   public int getSelectedIndex() {
      return this.selectedIndex;
   }

   public void setSelectedIndex(int var1) {
      this.selectedIndex = var1;
   }

   public List<ContainerWidget> getTabs() {
      return this.tabs;
   }

   public ListWidget getList() {
      return this.list;
   }
}
