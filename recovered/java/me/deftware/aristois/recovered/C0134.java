package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;

public class C0134 {
   @SerializedName("uuid")
   private UUID f_b8d7024a;
   @SerializedName("username")
   private String f_03c08df6;
   @SerializedName("properties")
   private C0134.anonymousthis f_cbf83211;
   @SerializedName("signature")
   private C0134.anonymousdefault f_b882ef76;

   public boolean m_2ca4efdc() {
      return this.f_cbf83211 != null && C0114.bootstrap<"call",0,1>(this.f_cbf83211);
   }

   public boolean m_e59637a2() {
      return this.f_cbf83211 != null && C0114.bootstrap<"call",0,1>(this.f_cbf83211);
   }

   public C0134() {
   }

   public UUID m_d4ce5adf() {
      return this.f_b8d7024a;
   }

   public String m_e52927c8() {
      return this.f_03c08df6;
   }

   public C0134.anonymousthis m_3d959bd5() {
      return this.f_cbf83211;
   }

   public C0134.anonymousdefault m_4af4c328() {
      return this.f_b882ef76;
   }

   public void m_f07c164e(UUID var1) {
      this.f_b8d7024a = var1;
   }

   public void m_6c1c535d(String var1) {
      this.f_03c08df6 = var1;
   }

   public void m_ac8cb263(C0134.anonymousthis var1) {
      this.f_cbf83211 = var1;
   }

   public void m_1a1de287(C0134.anonymousdefault var1) {
      this.f_b882ef76 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0134)) {
         return false;
      } else {
         C0134 var2 = (C0134)var1;
         if (!var2.m_a09ac62a(this)) {
            return false;
         } else {
            UUID var3 = this.m_d4ce5adf();
            UUID var4 = var2.m_d4ce5adf();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               String var5 = this.m_e52927c8();
               String var6 = var2.m_e52927c8();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  C0134.anonymousthis var7 = this.m_3d959bd5();
                  C0134.anonymousthis var8 = var2.m_3d959bd5();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     C0134.anonymousdefault var9 = this.m_4af4c328();
                     C0134.anonymousdefault var10 = var2.m_4af4c328();
                     return var9 == null ? var10 == null : var9.equals(var10);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_a09ac62a(Object var1) {
      return var1 instanceof C0134;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      UUID var3 = this.m_d4ce5adf();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      String var4 = this.m_e52927c8();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      C0134.anonymousthis var5 = this.m_3d959bd5();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      C0134.anonymousdefault var6 = this.m_4af4c328();
      return var2 * 59 + (var6 == null ? 43 : var6.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",4294967347>()
         + this.m_d4ce5adf()
         + C0252.bootstrap<"get",109>()
         + this.m_e52927c8()
         + C0252.bootstrap<"get",4294967348>()
         + this.m_3d959bd5()
         + C0252.bootstrap<"get",4294967349>()
         + this.m_4af4c328()
         + C0252.bootstrap<"get",59>();
   }

   public static class anonymousdefault {
      @SerializedName("timestamp")
      protected String f_d5d7002f;
      @SerializedName("data")
      protected String f_f86b38aa;

      public anonymousdefault() {
      }

      public String m_822eb083() {
         return this.f_d5d7002f;
      }

      public String m_ff31934f() {
         return this.f_f86b38aa;
      }
   }

   public static class anonymousthis {
      @SerializedName("banned")
      private boolean f_ab86c9fc;
      @SerializedName("donor")
      private boolean f_be0ba219;
      @SerializedName("prefix")
      private String f_ac05ad9d;

      public anonymousthis() {
      }

      public boolean m_791df234() {
         return this.f_ab86c9fc;
      }

      public boolean m_dbd2e1fa() {
         return this.f_be0ba219;
      }

      public String m_edab534e() {
         return this.f_ac05ad9d;
      }

      public void m_28a9495b(boolean var1) {
         this.f_ab86c9fc = var1;
      }

      public void m_7231ef72(boolean var1) {
         this.f_be0ba219 = var1;
      }

      public void m_596775a5(String var1) {
         this.f_ac05ad9d = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0134.anonymousthis)) {
            return false;
         } else {
            C0134.anonymousthis var2 = (C0134.anonymousthis)var1;
            if (!var2.m_f4e36bf3(this)) {
               return false;
            } else if (this.m_791df234() != var2.m_791df234()) {
               return false;
            } else if (this.m_dbd2e1fa() != var2.m_dbd2e1fa()) {
               return false;
            } else {
               String var3 = this.m_edab534e();
               String var4 = var2.m_edab534e();
               return var3 == null ? var4 == null : var3.equals(var4);
            }
         }
      }

      protected boolean m_f4e36bf3(Object var1) {
         return var1 instanceof C0134.anonymousthis;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         var2 = var2 * 59 + (this.m_791df234() ? 79 : 97);
         var2 = var2 * 59 + (this.m_dbd2e1fa() ? 79 : 97);
         String var3 = this.m_edab534e();
         return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      }

      @Override
      public String toString() {
         return C0252.bootstrap<"get",4294967344>()
            + this.m_791df234()
            + C0252.bootstrap<"get",4294967345>()
            + this.m_dbd2e1fa()
            + C0252.bootstrap<"get",4294967346>()
            + this.m_edab534e()
            + C0252.bootstrap<"get",59>();
      }
   }
}
