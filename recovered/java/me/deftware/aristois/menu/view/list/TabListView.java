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
      this.list.m_43380922(new C0426[]{C0426.f_eabcfd17});
      this.list.m_a0d63011().m_b9e3750e(80.0);
      this.m_18a04dc1(new C0163[]{this.list});
   }

   public ContainerWidget addTab(Message var1) {
      ContainerWidget var2 = new ContainerWidget(this.list.m_a0d63011().m_830cb294(), 0.0, 0.0, 0.0, this.f_fb78b4ff);
      var2.m_d8d42c9a(new C0426[]{C0426.f_974a55e6, C0426.f_eabcfd17});
      var2.m_a0598045(this);
      this.tabs.add(var2);
      final int var3 = this.tabs.size() - 1;
      ButtonWidget var4 = new ButtonWidget(var1, this.f_fb78b4ff) {
         @Override
         protected void onClick(int var1) {
            TabListView.this.selectedIndex = var3;
         }
      };
      var4.m_e61ee212(new C0426[]{C0426.f_974a55e6});
      this.list.m_2fe952ac(new C0163[]{var4});
      return var2;
   }

   public void m_13e180dc() {
      super.m_1a604be5();
      this.tabs.forEach(C0163::m_6b155392);
   }

   @Override
   protected boolean drawChildren(double var1, double var3, float var5, boolean var6) {
      var6 = super.drawChildren(var1, var3, var5, var6);
      return this.tabs.get(this.selectedIndex).m_0812cc67(var1, var3, var5, false);
   }

   public boolean m_a3a1845a(double var1, double var3, int var5) {
      return this.tabs.get(this.selectedIndex).m_c8af97e4(var1, var3, var5) ? true : super.m_c8af97e4(var1, var3, var5);
   }

   public boolean m_7df454e0(double var1, double var3, int var5) {
      boolean var6 = super.m_00a883b1(var1, var3, var5);
      return this.tabs.get(this.selectedIndex).m_00a883b1(var1, var3, var5);
   }

   public void m_c9dafa9f() {
      super.m_5af6401b();
      this.tabs.get(this.selectedIndex).m_5af6401b();
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
