package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;

public class C0175<T extends ListItem> extends C0176<T> {
   protected final T f_3b8da397;

   public C0175(C0174<T> var1, T var2) {
      super(var1, (Class<T>)var2.getClass());
      this.f_3b8da397 = (T)var2;
   }

   @Override
   protected void m_1058ed9a() {
      this.f_5422a71b = C0254.m_d0e43f69();
      this.f_edfc67ab = C0254.m_19faa493();
      super.m_1058ed9a();
   }

   @Override
   protected void m_ae2c9744() {
      this.m_8e694704(this.f_3b8da397);
      this.goBack();
   }

   @Override
   protected C0156 m_1d566344() {
      return new C0156((double)((float)getScaledWidth() / 2.0F - (float)this.f_fba5d8e6 / 2.0F), 60.0, this)
         .m_482c862d(this.m_26cd5a7e(this.f_62f64964, this.f_3b8da397))
         .m_6da7ba87(20.0F);
   }
}
