package me.deftware.aristois.recovered;

public abstract class C0233 {
   private C0233.anonymousdefault f_5023f0f4 = C0233.anonymousdefault.f_b15acc18;
   private boolean f_bc90e8d8 = false;
   private boolean f_5247162e = true;
   private float f_95865140;
   private float f_e2301e7f;
   private double f_4002e993;
   private double f_f628a848 = 2.0;
   private long f_ebe7b400;
   private long f_515b028f;
   private float f_ec8eb098;

   public C0233(float var1, double var2) {
      this.f_4002e993 = var2;
      this.f_ec8eb098 = 1000.0F / var1;
      this.f_ebe7b400 = 0L;
   }

   public void m_d881d3e3(float var1) {
      long var2 = System.nanoTime() / 1000000L;
      this.f_e2301e7f = (float)(var2 - this.f_ebe7b400) / this.f_ec8eb098;
      this.f_ebe7b400 = var2;
      this.f_95865140 = this.f_95865140 + this.f_e2301e7f;
      int var4 = (int)this.f_95865140;
      this.f_95865140 -= (float)var4;

      for (int var5 = 0; var5 < Math.min(10, var4); var5++) {
         this.m_1058ed9a();
      }
   }

   protected void m_1058ed9a() {
      if (this.m_9362a920() && !this.f_5247162e) {
         if (this.f_f628a848 <= 2.0) {
            this.f_f628a848 = this.f_f628a848 + 1.0 / this.f_4002e993;
            if (this.f_f628a848 <= 1.0) {
               this.m_560d077c(this.f_bc90e8d8 ? this.f_5023f0f4.m_d945de47(this.f_f628a848) : this.f_5023f0f4.m_461db524(this.f_f628a848));
            } else if (this.f_f628a848 <= 2.0 && this.f_bc90e8d8) {
               this.m_560d077c(1.0 - this.f_5023f0f4.m_d945de47(this.f_f628a848 - 1.0));
            }
         }

         if (this.f_f628a848 > 2.0) {
            this.f_5247162e = true;
            this.m_e02771ba();
         }
      }
   }

   public boolean m_9362a920() {
      return this.f_515b028f < System.currentTimeMillis();
   }

   public void m_0e265701() {
      this.f_f628a848 = 3.0;
      this.f_5247162e = true;
   }

   public void m_41e83f88() {
      this.m_ad6c7e6f(0L);
   }

   public void m_ad6c7e6f(long var1) {
      this.f_5247162e = false;
      this.f_f628a848 = 0.0;
      this.f_515b028f = System.currentTimeMillis() + var1;
   }

   public boolean m_e606d819() {
      return this.f_f628a848 >= 2.0;
   }

   protected abstract void m_560d077c(double var1);

   protected void m_e02771ba() {
   }

   public C0233.anonymousdefault m_e1a2b137() {
      return this.f_5023f0f4;
   }

   public boolean m_275ab222() {
      return this.f_bc90e8d8;
   }

   public boolean m_f21a055b() {
      return this.f_5247162e;
   }

   public float m_077e1665() {
      return this.f_95865140;
   }

   public float m_36b717a2() {
      return this.f_e2301e7f;
   }

   public double m_20206c69() {
      return this.f_4002e993;
   }

   public double m_036bd5c5() {
      return this.f_f628a848;
   }

   public long m_8adc505c() {
      return this.f_ebe7b400;
   }

   public long m_1993b0ec() {
      return this.f_515b028f;
   }

   public float m_72795264() {
      return this.f_ec8eb098;
   }

   public void m_e83888e2(C0233.anonymousdefault var1) {
      this.f_5023f0f4 = var1;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_bc90e8d8 = var1;
   }

   public void m_394ecb95(boolean var1) {
      this.f_5247162e = var1;
   }

   public void m_35bea3d9(float var1) {
      this.f_95865140 = var1;
   }

   public void m_180537c9(float var1) {
      this.f_e2301e7f = var1;
   }

   public void m_7c9e279f(double var1) {
      this.f_4002e993 = var1;
   }

   public void m_ddfd9367(double var1) {
      this.f_f628a848 = var1;
   }

   public void m_e12f1e31(long var1) {
      this.f_ebe7b400 = var1;
   }

   public void m_f645cd93(long var1) {
      this.f_515b028f = var1;
   }

   public void m_fad9e546(float var1) {
      this.f_ec8eb098 = var1;
   }

   public static enum anonymousdefault {
      f_c8bd7ffc,
      f_b15acc18,
      f_e9e57bbe;

      private anonymousdefault() {
      }

      public double m_d945de47(double var1) {
         switch (this) {
            case f_c8bd7ffc:
               return 1.0 - Math.pow(1.0 - var1, 4.0);
            case f_b15acc18:
               return Math.sqrt(1.0 - Math.pow(var1 - 1.0, 2.0));
            case f_e9e57bbe:
               return var1;
            default:
               throw new RuntimeException(C0261.m_812ab029());
         }
      }

      public double m_461db524(double var1) {
         switch (this) {
            case f_c8bd7ffc:
               return var1 < 0.5 ? 8.0 * var1 * var1 * var1 * var1 : 1.0 - Math.pow(-2.0 * var1 + 2.0, 4.0) / 2.0;
            case f_b15acc18:
               return var1 < 0.5 ? (1.0 - Math.sqrt(1.0 - Math.pow(2.0 * var1, 2.0))) / 2.0 : (Math.sqrt(1.0 - Math.pow(-2.0 * var1 + 2.0, 2.0)) + 1.0) / 2.0;
            case f_e9e57bbe:
               return var1;
            default:
               throw new RuntimeException(C0261.m_812ab029());
         }
      }
   }
}
