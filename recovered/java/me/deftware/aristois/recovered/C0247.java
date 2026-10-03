package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;

public class C0247 {
   private static final C0219<C0247> f_f4994d2e = new C0219<>(C0247.class, C0256.m_23f794da());
   @SerializedName("name")
   private String f_0aac940d;

   public C0247() {
   }

   public C0247 m_21360efc(String var1) {
      this.f_0aac940d = var1;
      return this;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof String) {
         return this.f_0aac940d.equalsIgnoreCase((String)var1);
      } else {
         return var1 instanceof C0247 ? this.f_0aac940d.equalsIgnoreCase(((C0247)var1).m_3d3a8736()) : false;
      }
   }

   public static C0219<C0247> m_ee0ef813() {
      return f_f4994d2e;
   }

   public String m_3d3a8736() {
      return this.f_0aac940d;
   }

   public void m_a11708c5(String var1) {
      this.f_0aac940d = var1;
   }
}
