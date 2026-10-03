package me.deftware.aristois.recovered;

public class C0083 implements C0084 {
   private long f_c04fb8b2 = 0L;
   private long f_149f4257;

   public C0083(long var1) {
      this.f_149f4257 = var1;
   }

   @Override
   public boolean m_efa7610e() {
      if (this.f_c04fb8b2 + this.f_149f4257 < System.currentTimeMillis()) {
         this.f_c04fb8b2 = System.currentTimeMillis();
         return true;
      } else {
         return false;
      }
   }

   public void m_ad6c7e6f(long var1) {
      this.f_149f4257 = var1;
   }
}
