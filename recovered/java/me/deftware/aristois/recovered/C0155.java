package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;

public class C0155 implements C0163 {
   private C0165 f_23bdfbc7;
   private C0150 f_1e8d4a39;
   private List<C0163> f_6da3b759 = new ArrayList<>();
   private final float f_875818e9;
   private boolean f_2b9c2225 = true;

   public C0155(float var1, C0150 var2) {
      this(0, 0, 0.0F, var1, var2);
   }

   public C0155(int var1, int var2, float var3, float var4, C0150 var5) {
      this.f_1e8d4a39 = var5;
      this.f_23bdfbc7 = new C0165((double)var1, (double)var2, (double)var3, 20.0);
      this.f_875818e9 = var4;
   }

   public C0155 m_5d3ed1f2(C0163... var1) {
      for (C0163 var5 : var1) {
         if (var5 != null) {
            this.f_1e8d4a39.m_ef389a68(var5);
            this.f_6da3b759.add(var5);
         }
      }

      return this;
   }

   public C0155 m_342503a4(boolean var1) {
      this.f_2b9c2225 = var1;
      return this;
   }

   public void m_09d59c73() {
      double var1 = this.f_23bdfbc7.m_830cb294() / (double)this.f_6da3b759.size();
      double var3 = this.f_23bdfbc7.m_14f8bc2c() - this.f_23bdfbc7.m_830cb294() / 2.0;
      double var5 = 0.0;

      for (C0163 var8 : this.f_6da3b759) {
         double var9 = var3;
         if (var5 > 0.0 || !this.f_2b9c2225) {
            if (var5 == (double)(this.f_6da3b759.size() - 1) && this.f_2b9c2225) {
               var9 = var3 + var1 - (double)this.f_875818e9;
            } else {
               var9 = var3 + (var1 / 2.0 - (double)(this.f_875818e9 / 2.0F));
            }
         }

         var8.m_fd6ca281().m_1e49f000(var9, this.f_23bdfbc7.m_5a998971());
         var8.m_6b155392();
         var5++;
         var3 += var1;
      }
   }

   public boolean m_81d499e9(double var1, double var3, float var5, boolean var6) {
      return var6;
   }

   public C0165 m_37294eec() {
      return this.f_23bdfbc7;
   }

   public C0150 m_cbe24a93() {
      return this.f_1e8d4a39;
   }

   public List<C0163> m_39d23fd4() {
      return this.f_6da3b759;
   }

   public float m_b96e1284() {
      return this.f_875818e9;
   }

   public boolean m_4d60f9f3() {
      return this.f_2b9c2225;
   }

   public void m_43dde65a(C0165 var1) {
      this.f_23bdfbc7 = var1;
   }

   public void m_f4bbec3d(C0150 var1) {
      this.f_1e8d4a39 = var1;
   }

   public void m_22705626(List<C0163> var1) {
      this.f_6da3b759 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0155)) {
         return false;
      } else {
         C0155 var2 = (C0155)var1;
         if (!var2.m_12b8687c(this)) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_b96e1284(), var2.m_b96e1284()) != 0) {
            return false;
         } else if (this.m_4d60f9f3() != var2.m_4d60f9f3()) {
            return false;
         } else {
            C0165 var3 = this.m_37294eec();
            C0165 var4 = var2.m_37294eec();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               C0150 var5 = this.m_cbe24a93();
               C0150 var6 = var2.m_cbe24a93();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  List var7 = this.m_39d23fd4();
                  List var8 = var2.m_39d23fd4();
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

   protected boolean m_12b8687c(Object var1) {
      return var1 instanceof C0155;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + C0114.bootstrap<"call",0,1>(this.m_b96e1284());
      var2 = var2 * 59 + (this.m_4d60f9f3() ? 79 : 97);
      C0165 var3 = this.m_37294eec();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      C0150 var4 = this.m_cbe24a93();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      List var5 = this.m_39d23fd4();
      return var2 * 59 + (var5 == null ? 43 : var5.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",25769803880>()
         + this.m_37294eec()
         + C0252.bootstrap<"get",25769803881>()
         + this.m_cbe24a93()
         + C0252.bootstrap<"get",25769803882>()
         + this.m_39d23fd4()
         + C0252.bootstrap<"get",25769803883>()
         + this.m_b96e1284()
         + C0252.bootstrap<"get",25769803884>()
         + this.m_4d60f9f3()
         + C0252.bootstrap<"get",59>();
   }
}
