package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;

public class C0156 implements C0163 {
   private C0165 f_131db3b8;
   private C0150 f_291fb464;
   private List<C0163> f_c4c6f5e8 = new ArrayList<>();
   private boolean f_234b1338 = false;
   private boolean f_6ca73bf4 = false;
   private float f_d06225d0 = 5.0F;

   public C0156(double var1, double var3, C0150 var5) {
      this.f_291fb464 = var5;
      this.f_131db3b8 = new C0165(var1, var3, 0.0, 0.0);
   }

   public C0156 m_482c862d(C0163... var1) {
      for (C0163 var5 : var1) {
         this.f_291fb464.m_4f7d4126(var5);
         this.f_c4c6f5e8.add(var5);
         this.f_131db3b8.m_6fd9bdae(var5.m_44bb072f().m_4388ac29());
      }

      this.f_131db3b8
         .m_61ade8f3(
            (double)(
               (float)this.f_c4c6f5e8.stream().mapToInt(var0 -> (int)var0.m_44bb072f().m_d42f3372()).sum() + this.f_d06225d0 * (float)this.f_c4c6f5e8.size()
            )
         );
      return this;
   }

   public C0156 m_46cac79a() {
      this.f_6ca73bf4 = true;
      return this;
   }

   public C0156 m_6da7ba87(float var1) {
      this.f_d06225d0 = var1;
      return this;
   }

   public C0156 m_4dd9e5a9() {
      this.f_234b1338 = true;
      return this;
   }

   @Override
   public void m_1058ed9a() {
      double var1 = this.f_131db3b8.m_84808068();
      if (this.f_234b1338) {
         var1 -= this.f_131db3b8.m_d42f3372() / 2.0;
      }

      for (C0163 var4 : this.f_c4c6f5e8) {
         double var5 = this.f_131db3b8.m_a005efae();
         if (this.f_6ca73bf4) {
            var5 -= var4.m_44bb072f().m_4388ac29();
         }

         var4.m_44bb072f().m_f8b16cfb(var5, var1);
         var4.m_1058ed9a();
         var1 += var4.m_44bb072f().m_d42f3372() + (double)this.f_d06225d0;
      }
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      return var6;
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_131db3b8;
   }

   public C0150 m_be36bae0() {
      return this.f_291fb464;
   }

   public List<C0163> m_a2a4e197() {
      return this.f_c4c6f5e8;
   }

   public boolean m_f21a055b() {
      return this.f_234b1338;
   }

   public boolean m_f0e7dcaa() {
      return this.f_6ca73bf4;
   }

   public float m_36b717a2() {
      return this.f_d06225d0;
   }

   public void m_9ee17df4(C0165 var1) {
      this.f_131db3b8 = var1;
   }

   public void m_7b543eda(C0150 var1) {
      this.f_291fb464 = var1;
   }

   public void m_1793329a(List<C0163> var1) {
      this.f_c4c6f5e8 = var1;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_234b1338 = var1;
   }

   public void m_394ecb95(boolean var1) {
      this.f_6ca73bf4 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0156)) {
         return false;
      } else {
         C0156 var2 = (C0156)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else if (this.m_f21a055b() != var2.m_f21a055b()) {
            return false;
         } else if (this.m_f0e7dcaa() != var2.m_f0e7dcaa()) {
            return false;
         } else if (Float.compare(this.m_36b717a2(), var2.m_36b717a2()) != 0) {
            return false;
         } else {
            C0165 var3 = this.m_44bb072f();
            C0165 var4 = var2.m_44bb072f();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0150 var5 = this.m_be36bae0();
               C0150 var6 = var2.m_be36bae0();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  List var7 = this.m_a2a4e197();
                  List var8 = var2.m_a2a4e197();
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
      return var1 instanceof C0156;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + (this.m_f21a055b() ? 79 : 97);
      var2 = var2 * 59 + (this.m_f0e7dcaa() ? 79 : 97);
      var2 = var2 * 59 + Float.floatToIntBits(this.m_36b717a2());
      C0165 var3 = this.m_44bb072f();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      C0150 var4 = this.m_be36bae0();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      List var5 = this.m_a2a4e197();
      return var2 * 59 + (var5 == null ? 43 : var5.hashCode());
   }

   @Override
   public String toString() {
      return C0267.m_37c08c9d()
         + this.m_44bb072f()
         + C0267.m_4cbaf16f()
         + this.m_be36bae0()
         + C0267.m_678c4ddb()
         + this.m_a2a4e197()
         + C0267.m_1472ab32()
         + this.m_f21a055b()
         + C0267.m_a5b24d28()
         + this.m_f0e7dcaa()
         + C0267.m_a9b6ecd9()
         + this.m_36b717a2()
         + C0257.m_9e27f038();
   }
}
