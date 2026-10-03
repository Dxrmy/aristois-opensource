package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;

public class C0247 {
   private static final C0219<C0247> f_adfcac59 = new C0219<>(C0247.class, C0252.bootstrap<"get",55834574903>());
   @SerializedName("name")
   private String f_1b81c16b;

   public C0247() {
   }

   public C0247 m_fa4eac04(String var1) {
      this.f_1b81c16b = var1;
      return this;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof String) {
         return this.f_1b81c16b.equalsIgnoreCase((String)var1);
      } else {
         return var1 instanceof C0247 ? this.f_1b81c16b.equalsIgnoreCase(((C0247)var1).m_cd751ed2()) : false;
      }
   }

   public static C0219<C0247> m_8e6cc60d() {
      return f_adfcac59;
   }

   public String m_cd751ed2() {
      return this.f_1b81c16b;
   }

   public void m_bc6e3984(String var1) {
      this.f_1b81c16b = var1;
   }
}
