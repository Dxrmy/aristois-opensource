package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.gui.widgets.SelectableList;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;

public abstract class C0161<T extends ListItem> extends SelectableList<T> implements C0163 {
   private final C0165 f_2b5eb537;
   private final int f_dc92beeb;
   private T f_95d0cfd1;
   private long f_d6ab14c5 = 0L;

   public C0161(List<T> var1, int var2, int var3, int var4, int var5, int var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.f_2b5eb537 = new C0165((double)var5, (double)var4, (double)var2, (double)var3);
      this.f_dc92beeb = var6;
   }

   @Override
   public void m_1058ed9a() {
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      return false;
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      if (System.currentTimeMillis() - this.f_d6ab14c5 < 250L && this.f_95d0cfd1 != null && this.f_95d0cfd1 == this.getSelectedItem()) {
         this.m_21355db3(this.f_95d0cfd1);
         return true;
      } else {
         this.f_d6ab14c5 = System.currentTimeMillis();
         return false;
      }
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      if (var3 > this.f_2b5eb537.m_84808068() && var3 < this.f_2b5eb537.m_84808068() + this.f_2b5eb537.m_d42f3372()) {
         this.f_95d0cfd1 = (T)this.getSelectedItem();
      } else {
         this.f_95d0cfd1 = null;
      }

      return false;
   }

   protected void m_b728afce() {
   }

   protected void m_21355db3(T var1) {
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_2b5eb537;
   }

   public int m_f34ec3cf() {
      return this.f_dc92beeb;
   }
}
