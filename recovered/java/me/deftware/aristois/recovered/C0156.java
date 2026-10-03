package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;

public class C0156 implements C0163 {
   private C0165 f_97a88586;
   private C0150 f_fd4cfa34;
   private List<C0163> f_2a240313 = new ArrayList<>();
   private boolean f_51e9ece7 = false;
   private boolean f_7a2ac17b = false;
   private float f_7ff35e7d = 5.0F;

   public C0156(double var1, double var3, C0150 var5) {
      this.f_fd4cfa34 = var5;
      this.f_97a88586 = new C0165(var1, var3, 0.0, 0.0);
   }

   public C0156 m_a411e7ce(C0163... var1) {
      for (C0163 var5 : var1) {
         this.f_fd4cfa34.m_ef389a68(var5);
         this.f_2a240313.add(var5);
         this.f_97a88586.m_b9e3750e(var5.m_fd6ca281().m_830cb294());
      }

      this.f_97a88586
         .m_5078410c(
            (double)(
               (float)this.f_2a240313.stream().mapToInt(var0 -> (int)var0.m_fd6ca281().m_fc7f45bc()).sum() + this.f_7ff35e7d * (float)this.f_2a240313.size()
            )
         );
      return this;
   }

   public C0156 m_af550b13() {
      this.f_7a2ac17b = true;
      return this;
   }

   public C0156 m_8391599b(float var1) {
      this.f_7ff35e7d = var1;
      return this;
   }

   public C0156 m_9df446d7() {
      this.f_51e9ece7 = true;
      return this;
   }

   public void m_26be492e() {
      double var1 = this.f_97a88586.m_5a998971();
      if (this.f_51e9ece7) {
         var1 -= this.f_97a88586.m_fc7f45bc() / 2.0;
      }

      for (C0163 var4 : this.f_2a240313) {
         double var5 = this.f_97a88586.m_14f8bc2c();
         if (this.f_7a2ac17b) {
            var5 -= var4.m_fd6ca281().m_830cb294();
         }

         var4.m_fd6ca281().m_1e49f000(var5, var1);
         var4.m_6b155392();
         var1 += var4.m_fd6ca281().m_fc7f45bc() + (double)this.f_7ff35e7d;
      }
   }

   public boolean m_814c3a76(double var1, double var3, float var5, boolean var6) {
      return var6;
   }

   public C0165 m_d591a691() {
      return this.f_97a88586;
   }

   public C0150 m_3951903f() {
      return this.f_fd4cfa34;
   }

   public List<C0163> m_d6e2fc50() {
      return this.f_2a240313;
   }

   public boolean m_466d2f7b() {
      return this.f_51e9ece7;
   }

   public boolean m_56a368d5() {
      return this.f_7a2ac17b;
   }

   public float m_83a934c2() {
      return this.f_7ff35e7d;
   }

   public void m_10f5ddff(C0165 var1) {
      this.f_97a88586 = var1;
   }

   public void m_e82ec345(C0150 var1) {
      this.f_fd4cfa34 = var1;
   }

   public void m_e49ce543(List<C0163> var1) {
      this.f_2a240313 = var1;
   }

   public void m_a0d0c4e5(boolean var1) {
      this.f_51e9ece7 = var1;
   }

   public void m_f9ed70b0(boolean var1) {
      this.f_7a2ac17b = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0156)) {
         return false;
      } else {
         C0156 var2 = (C0156)var1;
         if (!var2.m_0093cc76(this)) {
            return false;
         } else if (this.m_466d2f7b() != var2.m_466d2f7b()) {
            return false;
         } else if (this.m_56a368d5() != var2.m_56a368d5()) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_83a934c2(), var2.m_83a934c2()) != 0) {
            return false;
         } else {
            C0165 var3 = this.m_d591a691();
            C0165 var4 = var2.m_d591a691();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0150 var5 = this.m_3951903f();
               C0150 var6 = var2.m_3951903f();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  List var7 = this.m_d6e2fc50();
                  List var8 = var2.m_d6e2fc50();
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

   protected boolean m_0093cc76(Object var1) {
      return var1 instanceof C0156;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + (this.m_466d2f7b() ? 79 : 97);
      var2 = var2 * 59 + (this.m_56a368d5() ? 79 : 97);
      var2 = var2 * 59 + C0114.bootstrap<"call",0,1>(this.m_83a934c2());
      C0165 var3 = this.m_d591a691();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      C0150 var4 = this.m_3951903f();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      List var5 = this.m_d6e2fc50();
      return var2 * 59 + (var5 == null ? 43 : var5.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",25769803885>()
         + this.m_d591a691()
         + C0252.bootstrap<"get",25769803881>()
         + this.m_3951903f()
         + C0252.bootstrap<"get",25769803882>()
         + this.m_d6e2fc50()
         + C0252.bootstrap<"get",25769803886>()
         + this.m_466d2f7b()
         + C0252.bootstrap<"get",25769803887>()
         + this.m_56a368d5()
         + C0252.bootstrap<"get",25769803888>()
         + this.m_83a934c2()
         + C0252.bootstrap<"get",59>();
   }
}
