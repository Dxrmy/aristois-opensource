package me.deftware.aristois.recovered;

import java.util.UUID;

public class C0159 extends C0162 {
   private final C0230 f_0ee675b9;
   private C0230.anonymouscatch f_2a4fd9b9 = C0230.anonymouscatch.f_bce9cc23;

   public C0159(int var1, int var2, int var3, UUID var4) {
      super(var1, var2, var3, var3, null);
      this.f_0ee675b9 = C0224.m_3d9368ca(var4);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      if (this.f_0ee675b9.m_c0b2fa8c(this.f_2a4fd9b9)) {
         this.f_0ee675b9
            .m_d4d15bd2(
               (int)this.f_bbc4d1c1.m_a005efae(),
               (int)this.f_bbc4d1c1.m_84808068(),
               (int)this.f_bbc4d1c1.m_4388ac29(),
               (int)this.f_bbc4d1c1.m_d42f3372(),
               this.f_2a4fd9b9
            );
      }

      return var6;
   }

   public void m_cb2d1e27(C0230.anonymouscatch var1) {
      this.f_2a4fd9b9 = var1;
   }
}
