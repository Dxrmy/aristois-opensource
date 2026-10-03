package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;

public class C0175<T extends ListItem> extends C0176<T> {
   protected final T f_ff09dcc8;

   public C0175(C0174<T> var1, T var2) {
      super(var1, (Class<T>)var2.getClass());
      this.f_ff09dcc8 = (T)var2;
   }

   protected void m_7e3ca619() {
      this.f_30dad891 = C0252.bootstrap<"get",21474836560>();
      this.f_a0ba2912 = C0252.bootstrap<"get",21474836563>();
      super.m_3c3121cd();
   }

   protected void m_d8095515() {
      this.m_bca724d6(this.f_ff09dcc8);
      this.goBack();
   }

   protected C0156 m_75b46ef2() {
      return new C0156((double)((float)C0114.bootstrap<"call",0,1>() / 2.0F - (float)this.f_dfaa91a2 / 2.0F), 60.0, this)
         .m_a411e7ce(this.m_199917f0(this.f_c50e67ae, this.f_ff09dcc8))
         .m_8391599b(20.0F);
   }
}
