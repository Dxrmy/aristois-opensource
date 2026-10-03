package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;

public class C0155 implements C0163 {
   private C0165 f_8b831b02;
   private C0150 f_64ea6f04;
   private List<C0163> f_45933d63 = new ArrayList<>();
   private final float f_c55c9c64;
   private boolean f_d1ee55b7 = true;

   public C0155(float var1, C0150 var2) {
      this(0, 0, 0.0F, var1, var2);
   }

   public C0155(int var1, int var2, float var3, float var4, C0150 var5) {
      this.f_64ea6f04 = var5;
      this.f_8b831b02 = new C0165((double)var1, (double)var2, (double)var3, 20.0);
      this.f_c55c9c64 = var4;
   }

   public C0155 m_2ee4da8d(C0163... var1) {
      for (C0163 var5 : var1) {
         if (var5 != null) {
            this.f_64ea6f04.m_4f7d4126(var5);
            this.f_45933d63.add(var5);
         }
      }

      return this;
   }

   public C0155 m_349cddee(boolean var1) {
      this.f_d1ee55b7 = var1;
      return this;
   }

   @Override
   public void m_1058ed9a() {
      double var1 = this.f_8b831b02.m_4388ac29() / (double)this.f_45933d63.size();
      double var3 = this.f_8b831b02.m_a005efae() - this.f_8b831b02.m_4388ac29() / 2.0;
      double var5 = 0.0;

      for (C0163 var8 : this.f_45933d63) {
         double var9 = var3;
         if (var5 > 0.0 || !this.f_d1ee55b7) {
            if (var5 == (double)(this.f_45933d63.size() - 1) && this.f_d1ee55b7) {
               var9 = var3 + var1 - (double)this.f_c55c9c64;
            } else {
               var9 = var3 + (var1 / 2.0 - (double)(this.f_c55c9c64 / 2.0F));
            }
         }

         var8.m_44bb072f().m_f8b16cfb(var9, this.f_8b831b02.m_84808068());
         var8.m_1058ed9a();
         var5++;
         var3 += var1;
      }
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      return var6;
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_8b831b02;
   }

   public C0150 m_55eb6a5c() {
      return this.f_64ea6f04;
   }

   public List<C0163> m_b720541d() {
      return this.f_45933d63;
   }

   public float m_7ffacf09() {
      return this.f_c55c9c64;
   }

   public boolean m_275ab222() {
      return this.f_d1ee55b7;
   }

   public void m_9ee17df4(C0165 var1) {
      this.f_8b831b02 = var1;
   }

   public void m_7b543eda(C0150 var1) {
      this.f_64ea6f04 = var1;
   }

   public void m_1793329a(List<C0163> var1) {
      this.f_45933d63 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0155)) {
         return false;
      } else {
         C0155 var2 = (C0155)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else if (Float.compare(this.m_7ffacf09(), var2.m_7ffacf09()) != 0) {
            return false;
         } else if (this.m_275ab222() != var2.m_275ab222()) {
            return false;
         } else {
            C0165 var3 = this.m_44bb072f();
            C0165 var4 = var2.m_44bb072f();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0150 var5 = this.m_55eb6a5c();
               C0150 var6 = var2.m_55eb6a5c();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  List var7 = this.m_b720541d();
                  List var8 = var2.m_b720541d();
                  return var7 == null ? var8 == null : var7.equals(var8);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_22ad6203(Object var1) {
      return var1 instanceof C0155;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + Float.floatToIntBits(this.m_7ffacf09());
      var2 = var2 * 59 + (this.m_275ab222() ? 79 : 97);
      C0165 var3 = this.m_44bb072f();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      C0150 var4 = this.m_55eb6a5c();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      List var5 = this.m_b720541d();
      return var2 * 59 + (var5 == null ? 43 : var5.hashCode());
   }

   @Override
   public String toString() {
      return C0267.m_2dc36b02()
         + this.m_44bb072f()
         + C0267.m_4cbaf16f()
         + this.m_55eb6a5c()
         + C0267.m_678c4ddb()
         + this.m_b720541d()
         + C0267.m_1672ac4d()
         + this.m_7ffacf09()
         + C0267.m_e9a52709()
         + this.m_275ab222()
         + C0257.m_9e27f038();
   }
}
