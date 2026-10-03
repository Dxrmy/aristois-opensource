package me.deftware.aristois.recovered;

public class C0229 implements C0230 {
   public static final C0229 f_60968b94 = new C0229(C0261.m_9bf0a29a());
   private static final String f_accb7edb = C0261.m_bcef2112();
   protected C0148 f_9662a9a2;
   protected C0148 f_2b541673;
   protected final String f_29b700f2;

   public C0229(String var1) {
      this.f_29b700f2 = var1;
      this.m_fd4438d8();
   }

   protected void m_fd4438d8() {
      this.f_9662a9a2 = new C0148(String.format(C0261.m_1b17f04f(), C0261.m_bcef2112(), this.f_29b700f2));
      this.f_2b541673 = new C0148(String.format(C0261.m_114677c2(), C0261.m_bcef2112(), this.f_29b700f2));
   }

   @Override
   public boolean m_c0b2fa8c(C0230.anonymouscatch var1) {
      switch (var1) {
         case f_431eb11f:
            return this.f_9662a9a2.isReady();
         case f_bce9cc23:
            return this.f_2b541673.isReady();
         default:
            throw new RuntimeException(C0261.m_fac478b2());
      }
   }

   @Override
   public void m_d4d15bd2(int var1, int var2, int var3, int var4, C0230.anonymouscatch var5) {
      switch (var5) {
         case f_431eb11f:
            this.f_9662a9a2.bind().draw(var1, var2, var3, var4).unbind();
            break;
         case f_bce9cc23:
            this.f_2b541673.bind().draw(var1, var2, var3, var4).unbind();
      }
   }

   @Override
   public int m_79bbc2da() {
      return this.f_9662a9a2.getTextureWidth();
   }

   @Override
   public int m_037208cc() {
      return this.f_9662a9a2.getTextureHeight();
   }

   public String m_d32ebe65() {
      return this.f_29b700f2;
   }
}
