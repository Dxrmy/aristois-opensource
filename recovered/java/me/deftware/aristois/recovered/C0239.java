package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;

public class C0239 {
   @SerializedName("username")
   private String f_e2ed366a;
   @SerializedName("hasLicense")
   private boolean f_d62c0b5d;
   @SerializedName("licenseType")
   private String f_0a3ed001;
   @SerializedName("expires")
   private String f_d2263460;

   public C0239() {
   }

   public boolean m_efa7610e() {
      return this.f_0a3ed001.equalsIgnoreCase(C0257.m_65d43991()) || this.f_0a3ed001.equalsIgnoreCase(C0264.m_1635bc47());
   }

   public String m_3d3a8736() {
      return this.f_e2ed366a;
   }

   public boolean m_89e0519f() {
      return this.f_d62c0b5d;
   }

   public String m_d32ebe65() {
      return this.f_0a3ed001;
   }

   public String m_3855be80() {
      return this.f_d2263460;
   }
}
