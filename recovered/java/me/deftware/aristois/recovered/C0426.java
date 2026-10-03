package me.deftware.aristois.recovered;

public enum C0426 {
   f_e23d4507,
   f_eabcfd17,
   f_974a55e6;

   private C0426() {
   }

   public void m_365f77b3(C0163 var1, C0163 var2) {
      switch (this) {
         case f_e23d4507:
            var1.m_fd6ca281().m_b9e3750e(var2.m_fd6ca281().m_830cb294());
            var1.m_fd6ca281().m_5078410c(var2.m_fd6ca281().m_fc7f45bc());
            break;
         case f_974a55e6:
            var1.m_fd6ca281().m_b9e3750e(var2.m_fd6ca281().m_830cb294());
            break;
         case f_eabcfd17:
            double var3 = C0114.bootstrap<"call",0,1>(var2.m_fd6ca281().m_5a998971() - var1.m_fd6ca281().m_5a998971());
            var1.m_fd6ca281().m_5078410c(var2.m_fd6ca281().m_fc7f45bc() - var3);
      }
   }
}
