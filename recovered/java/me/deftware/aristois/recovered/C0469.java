package me.deftware.aristois.recovered;

public class C0469 {
   private String f_2e9fee66;
   private String f_7a1383b2;
   private String f_c5a4d6c4;

   public C0469(String var1, String var2) {
      this.f_2e9fee66 = var1;
      this.f_7a1383b2 = var2;
      this.f_c5a4d6c4 = var2.toLowerCase();
   }

   public String m_8d7dbe31() {
      return this.f_2e9fee66;
   }

   public boolean m_9362a920() {
      return this.f_2e9fee66.indexOf(64) >= 0;
   }

   public boolean m_89e0519f() {
      return this.f_2e9fee66.indexOf(43) >= 0;
   }

   public String m_d32ebe65() {
      return this.f_7a1383b2;
   }

   @Override
   public String toString() {
      return this.m_8d7dbe31() + this.m_d32ebe65();
   }

   public boolean m_828a75ae(String var1) {
      return var1.toLowerCase().equals(this.f_c5a4d6c4);
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 instanceof C0469) {
         C0469 var2 = (C0469)var1;
         return var2.f_c5a4d6c4.equals(this.f_c5a4d6c4);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return this.f_c5a4d6c4.hashCode();
   }

   public int m_9168937b(Object var1) {
      if (var1 instanceof C0469) {
         C0469 var2 = (C0469)var1;
         return var2.f_c5a4d6c4.compareTo(this.f_c5a4d6c4);
      } else {
         return -1;
      }
   }
}
