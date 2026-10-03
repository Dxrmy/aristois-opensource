package me.deftware.aristois.recovered;

public class C0280 extends C0288<C0280> {
   private boolean f_07947ca3 = false;
   private boolean f_73df34fe = false;
   private final Runnable f_ddf98df1;
   private final long f_b8f79e41;

   public C0280(Runnable var1, long var2) {
      this.f_ddf98df1 = var1;
      this.f_b8f79e41 = var2;
   }

   public C0280 m_d7d55d49() {
      this.f_07947ca3 = true;
      return this;
   }

   public C0280 m_6a86ba49() {
      this.f_73df34fe = true;
      this.f_ddf98df1.run();
      this.f_ee6ec1e0 = C0114.bootstrap<"call",0,1>();
      return this;
   }

   public C0280 m_4cdf7572() {
      if (this.f_ee6ec1e0 + this.f_b8f79e41 < C0114.bootstrap<"call",0,1>()) {
         this.f_07947ca3 = true;
         this.m_db7f89b4();
      }

      return this;
   }

   public boolean m_ac80b914() {
      return this.f_07947ca3;
   }

   public boolean m_4e5bf44f() {
      return this.f_73df34fe;
   }
}
