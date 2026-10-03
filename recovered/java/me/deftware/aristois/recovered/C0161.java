package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.gui.widgets.SelectableList;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;

public abstract class C0161<T extends ListItem> extends SelectableList<T> implements C0163 {
   private final C0165 f_f329a6f7;
   private final int f_b1e2a57f;
   private T f_677b372a;
   private long f_b0674c2a = 0L;

   public C0161(List<T> var1, int var2, int var3, int var4, int var5, int var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.f_f329a6f7 = new C0165((double)var5, (double)var4, (double)var2, (double)var3);
      this.f_b1e2a57f = var6;
   }

   public void m_866e2d01() {
   }

   public boolean m_f1420f34(double var1, double var3, float var5, boolean var6) {
      return false;
   }

   public boolean m_7b3a8162(double var1, double var3, int var5) {
      if (C0114.bootstrap<"call",0,1>() - this.f_b0674c2a < 250L && this.f_677b372a != null && this.f_677b372a == this.getSelectedItem()) {
         this.m_88b4df2f(this.f_677b372a);
         return true;
      } else {
         this.f_b0674c2a = C0114.bootstrap<"call",0,1>();
         return false;
      }
   }

   public boolean m_1791f0f2(double var1, double var3, int var5) {
      if (var3 > this.f_f329a6f7.m_5a998971() && var3 < this.f_f329a6f7.m_5a998971() + this.f_f329a6f7.m_fc7f45bc()) {
         this.f_677b372a = (T)this.getSelectedItem();
      } else {
         this.f_677b372a = null;
      }

      return false;
   }

   protected void m_43cb3572() {
   }

   protected void m_88b4df2f(T var1) {
   }

   public C0165 m_377a4c9b() {
      return this.f_f329a6f7;
   }

   public int m_d2eb0f5a() {
      return this.f_b1e2a57f;
   }
}
