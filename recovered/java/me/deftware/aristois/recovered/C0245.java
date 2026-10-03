package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;

public class C0245 {
   @SerializedName("keyCode")
   private int f_e825ee4d;
   @SerializedName("modifier")
   private int f_6726a744 = 0;
   @SerializedName("displayName")
   private String f_8e989364;
   private Runnable f_63fd61ce;

   public C0245() {
      this(-1);
   }

   public C0245(int var1) {
      this.f_e825ee4d = var1;
   }

   public void m_3500412e(int var1) {
      this.f_e825ee4d = var1;
      if (this.f_63fd61ce != null) {
         this.f_63fd61ce.run();
      }
   }

   public void m_4adc9538(int var1) {
      this.f_6726a744 = var1;
      if (this.f_63fd61ce != null) {
         this.f_63fd61ce.run();
      }
   }

   public void m_fce13178() {
      this.m_3500412e(-1);
      this.m_4adc9538(0);
   }

   @Override
   public String toString() {
      if (this.f_e825ee4d < 0) {
         return C0252.bootstrap<"get",17179869299>();
      } else {
         String var1 = this.f_6726a744 != 0
            ? C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(this.f_6726a744).toLowerCase()) + C0252.bootstrap<"get",55834574905>()
            : "";
         if (this.m_9be89837()) {
            return var1 + C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",55834574906>(), new Object[]{C0114.bootstrap<"call",2,1>(this.f_e825ee4d)});
         } else if (this.f_8e989364 != null && !this.f_8e989364.isEmpty()) {
            return var1 + this.f_8e989364;
         } else {
            String var2 = C0114.bootstrap<"call",1,1>(
               C0114.bootstrap<"call",4,1>(this.f_e825ee4d).replace(C0252.bootstrap<"get",4294967381>(), C0252.bootstrap<"get",70>()).toLowerCase()
            );
            return this.f_e825ee4d == -1 ? C0252.bootstrap<"get",17179869299>() : var1 + var2;
         }
      }
   }

   public boolean m_9bec5cd2() {
      return this.f_e825ee4d != -1 || this.f_6726a744 != 0;
   }

   public boolean m_9be89837() {
      return this.f_e825ee4d < 7;
   }

   public boolean m_a3b35090(int var1) {
      return this.m_9be89837()
         ? C0114.bootstrap<"call",0,1>(this.f_e825ee4d) && var1 == this.f_6726a744
         : C0114.bootstrap<"call",1,1>(this.f_e825ee4d) && var1 == this.f_6726a744;
   }

   public int m_6978c604() {
      return this.f_e825ee4d;
   }

   public int m_0c53f85c() {
      return this.f_6726a744;
   }

   public String m_fa69616d() {
      return this.f_8e989364;
   }

   public Runnable m_46edb596() {
      return this.f_63fd61ce;
   }

   public void m_1943e8ec(String var1) {
      this.f_8e989364 = var1;
   }

   public void m_1990ab66(Runnable var1) {
      this.f_63fd61ce = var1;
   }
}
