package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;

public class C0239 {
   @SerializedName("username")
   private String f_b0c7bcf4;
   @SerializedName("hasLicense")
   private boolean f_562cacd6;
   @SerializedName("licenseType")
   private String f_56f85ad2;
   @SerializedName("expires")
   private String f_4dddb880;

   public C0239() {
   }

   public boolean m_1e7a8e12() {
      return this.f_56f85ad2.equalsIgnoreCase(C0252.bootstrap<"get",128>()) || this.f_56f85ad2.equalsIgnoreCase(C0252.bootstrap<"get",4294967311>());
   }

   public String m_ffde172f() {
      return this.f_b0c7bcf4;
   }

   public boolean m_0fdbf221() {
      return this.f_562cacd6;
   }

   public String m_44ec4e9e() {
      return this.f_56f85ad2;
   }

   public String m_69b1f5a8() {
      return this.f_4dddb880;
   }
}
