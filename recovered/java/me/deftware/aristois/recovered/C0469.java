package me.deftware.aristois.recovered;

public class C0469 {
   private String f_e0ae6d69;
   private String f_fa6ee591;
   private String f_8b619f7e;

   public C0469(String var1, String var2) {
      this.f_e0ae6d69 = var1;
      this.f_fa6ee591 = var2;
      this.f_8b619f7e = var2.toLowerCase();
   }

   public String m_e9d1d980() {
      return this.f_e0ae6d69;
   }

   public boolean m_3c73add0() {
      return this.f_e0ae6d69.indexOf(64) >= 0;
   }

   public boolean m_4a258b9d() {
      return this.f_e0ae6d69.indexOf(43) >= 0;
   }

   public String m_1c498a6a() {
      return this.f_fa6ee591;
   }

   @Override
   public String toString() {
      return this.m_e9d1d980() + this.m_1c498a6a();
   }

   public boolean m_9ce7ae49(String var1) {
      return var1.toLowerCase().equals(this.f_8b619f7e);
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof C0469) {
         C0469 var2 = (C0469)var1;
         return var2.f_8b619f7e.equals(this.f_8b619f7e);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return this.f_8b619f7e.hashCode();
   }

   public int m_2c36323a(Object var1) {
      if (var1 instanceof C0469) {
         C0469 var2 = (C0469)var1;
         return var2.f_8b619f7e.compareTo(this.f_8b619f7e);
      } else {
         return -1;
      }
   }
}
