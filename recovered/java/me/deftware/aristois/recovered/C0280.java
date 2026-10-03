package me.deftware.aristois.recovered;

public class C0280 extends C0288<C0280> {
   private boolean f_332a0509 = false;
   private boolean f_b4213fac = false;
   private final Runnable f_b4b962b3;
   private final long f_54a9f1fc;

   public C0280(Runnable var1, long var2) {
      this.f_b4b962b3 = var1;
      this.f_54a9f1fc = var2;
   }

   public C0280 m_81bdd14b() {
      this.f_332a0509 = true;
      return this;
   }

   public C0280 m_79eeb654() {
      this.f_b4213fac = true;
      this.f_b4b962b3.run();
      this.f_ae2cc37b = System.currentTimeMillis();
      return this;
   }

   public C0280 m_70aa5488() {
      if (this.f_ae2cc37b + this.f_54a9f1fc < System.currentTimeMillis()) {
         this.f_332a0509 = true;
         this.m_23674f64();
      }

      return this;
   }

   @Override
   public boolean m_f7b07982() {
      return this.f_332a0509;
   }

   @Override
   public boolean m_9362a920() {
      return this.f_b4213fac;
   }
}
