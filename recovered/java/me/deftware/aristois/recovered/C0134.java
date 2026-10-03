package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;

public class C0134 {
   @SerializedName("uuid")
   private UUID f_f63c2942;
   @SerializedName("username")
   private String f_cb37d908;
   @SerializedName("properties")
   private C0134.anonymousthis f_de562be3;
   @SerializedName("signature")
   private C0134.anonymousdefault f_8d35de48;

   public boolean m_efa7610e() {
      return this.f_de562be3 != null && this.f_de562be3.f_1dd09754;
   }

   public boolean m_9362a920() {
      return this.f_de562be3 != null && this.f_de562be3.f_4f8d4a8d;
   }

   public C0134() {
   }

   public UUID m_d230268a() {
      return this.f_f63c2942;
   }

   public String m_d32ebe65() {
      return this.f_cb37d908;
   }

   public C0134.anonymousthis m_772cf437() {
      return this.f_de562be3;
   }

   public C0134.anonymousdefault m_1b54fc03() {
      return this.f_8d35de48;
   }

   public void m_43a0cbf2(UUID var1) {
      this.f_f63c2942 = var1;
   }

   public void m_256015fc(String var1) {
      this.f_cb37d908 = var1;
   }

   public void m_df7bd384(C0134.anonymousthis var1) {
      this.f_de562be3 = var1;
   }

   public void m_cfd81537(C0134.anonymousdefault var1) {
      this.f_8d35de48 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0134)) {
         return false;
      } else {
         C0134 var2 = (C0134)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else {
            UUID var3 = this.m_d230268a();
            UUID var4 = var2.m_d230268a();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               String var5 = this.m_d32ebe65();
               String var6 = var2.m_d32ebe65();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  C0134.anonymousthis var7 = this.m_772cf437();
                  C0134.anonymousthis var8 = var2.m_772cf437();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     C0134.anonymousdefault var9 = this.m_1b54fc03();
                     C0134.anonymousdefault var10 = var2.m_1b54fc03();
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

   protected boolean m_22ad6203(Object var1) {
      return var1 instanceof C0134;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      UUID var3 = this.m_d230268a();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      String var4 = this.m_d32ebe65();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      C0134.anonymousthis var5 = this.m_772cf437();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      C0134.anonymousdefault var6 = this.m_1b54fc03();
      return var2 * 59 + (var6 == null ? 43 : var6.hashCode());
   }

   @Override
   public String toString() {
      return C0264.m_73708dd3()
         + this.m_d230268a()
         + C0257.m_37c08c9d()
         + this.m_d32ebe65()
         + C0264.m_96ba50d4()
         + this.m_772cf437()
         + C0264.m_88726494()
         + this.m_1b54fc03()
         + C0257.m_9e27f038();
   }

   public static class anonymousdefault {
      @SerializedName("timestamp")
      protected String f_ce4f2d1a;
      @SerializedName("data")
      protected String f_8fc7f074;

      public anonymousdefault() {
      }

      public String m_8d7dbe31() {
         return this.f_ce4f2d1a;
      }

      public String m_3d3a8736() {
         return this.f_8fc7f074;
      }
   }

   public static class anonymousthis {
      @SerializedName("banned")
      private boolean f_1dd09754;
      @SerializedName("donor")
      private boolean f_4f8d4a8d;
      @SerializedName("prefix")
      private String f_1401ffbe;

      public anonymousthis() {
      }

      public boolean m_efa7610e() {
         return this.f_1dd09754;
      }

      public boolean m_9362a920() {
         return this.f_4f8d4a8d;
      }

      public String m_e07cee76() {
         return this.f_1401ffbe;
      }

      public void m_d6ac7420(boolean var1) {
         this.f_1dd09754 = var1;
      }

      public void m_394ecb95(boolean var1) {
         this.f_4f8d4a8d = var1;
      }

      public void m_256015fc(String var1) {
         this.f_1401ffbe = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0134.anonymousthis)) {
            return false;
         } else {
            C0134.anonymousthis var2 = (C0134.anonymousthis)var1;
            if (!var2.m_22ad6203(this)) {
               return false;
            } else if (this.m_efa7610e() != var2.m_efa7610e()) {
               return false;
            } else if (this.m_9362a920() != var2.m_9362a920()) {
               return false;
            } else {
               String var3 = this.m_e07cee76();
               String var4 = var2.m_e07cee76();
               return var3 == null ? var4 == null : var3.equals(var4);
            }
         }
      }

      protected boolean m_22ad6203(Object var1) {
         return var1 instanceof C0134.anonymousthis;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         var2 = var2 * 59 + (this.m_efa7610e() ? 79 : 97);
         var2 = var2 * 59 + (this.m_9362a920() ? 79 : 97);
         String var3 = this.m_e07cee76();
         return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      }

      @Override
      public String toString() {
         return C0264.m_7f74d855() + this.m_efa7610e() + C0264.m_b89b7876() + this.m_9362a920() + C0264.m_a33fab52() + this.m_e07cee76() + C0257.m_9e27f038();
      }
   }
}
