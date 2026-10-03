package me.deftware.aristois.recovered;

public enum C0426 {
   f_166ad6c3,
   f_f7a0f908,
   f_c285454f;

   private C0426() {
   }

   public void m_28c3e3ec(C0163 var1, C0163 var2) {
      switch (this) {
         case f_166ad6c3:
            var1.m_44bb072f().m_6fd9bdae(var2.m_44bb072f().m_4388ac29());
            var1.m_44bb072f().m_61ade8f3(var2.m_44bb072f().m_d42f3372());
            break;
         case f_c285454f:
            var1.m_44bb072f().m_6fd9bdae(var2.m_44bb072f().m_4388ac29());
            break;
         case f_f7a0f908:
            double var3 = Math.abs(var2.m_44bb072f().m_84808068() - var1.m_44bb072f().m_84808068());
            var1.m_44bb072f().m_61ade8f3(var2.m_44bb072f().m_d42f3372() - var3);
      }
   }
}
