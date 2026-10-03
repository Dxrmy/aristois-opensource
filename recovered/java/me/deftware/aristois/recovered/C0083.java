package me.deftware.aristois.recovered;

public class C0083 implements C0084 {
   private long f_3c57056a = 0L;
   private long f_110ff112;

   public C0083(long var1) {
      this.f_110ff112 = var1;
   }

   public boolean m_4c4741b3() {
      if (this.f_3c57056a + this.f_110ff112 < C0114.bootstrap<"call",0,1>()) {
         this.f_3c57056a = C0114.bootstrap<"call",0,1>();
         return true;
      } else {
         return false;
      }
   }

   public void m_60828e76(long var1) {
      this.f_110ff112 = var1;
   }
}
