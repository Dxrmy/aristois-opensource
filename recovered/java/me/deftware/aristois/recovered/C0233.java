package me.deftware.aristois.recovered;

public abstract class C0233 {
   private C0233.anonymousdefault f_f349702d = C0233.anonymousdefault.f_be178d18;
   private boolean f_c49dc127 = false;
   private boolean f_e8bb4155 = true;
   private float f_219ad2dc;
   private float f_6c1b324a;
   private double f_69be6268;
   private double f_5e916dd2 = 2.0;
   private long f_5bfc6133;
   private long f_f1e8de73;
   private float f_6e2ec8d1;

   public C0233(float var1, double var2) {
      this.f_69be6268 = var2;
      this.f_6e2ec8d1 = 1000.0F / var1;
      this.f_5bfc6133 = 0L;
   }

   public void m_61a5f120(float var1) {
      long var2 = C0114.bootstrap<"call",0,1>() / 1000000L;
      this.f_6c1b324a = (float)(var2 - this.f_5bfc6133) / this.f_6e2ec8d1;
      this.f_5bfc6133 = var2;
      this.f_219ad2dc = this.f_219ad2dc + this.f_6c1b324a;
      int var4 = (int)this.f_219ad2dc;
      this.f_219ad2dc -= (float)var4;

      for (int var5 = 0; var5 < C0114.bootstrap<"call",1,1>(10, var4); var5++) {
         this.m_190c7727();
      }
   }

   protected void m_190c7727() {
      if (this.m_79e29869() && !this.f_e8bb4155) {
         if (this.f_5e916dd2 <= 2.0) {
            this.f_5e916dd2 = this.f_5e916dd2 + 1.0 / this.f_69be6268;
            if (this.f_5e916dd2 <= 1.0) {
               this.m_d070a77e(this.f_c49dc127 ? this.f_f349702d.m_66568d49(this.f_5e916dd2) : this.f_f349702d.m_dcd2a2cd(this.f_5e916dd2));
            } else if (this.f_5e916dd2 <= 2.0 && this.f_c49dc127) {
               this.m_d070a77e(1.0 - this.f_f349702d.m_66568d49(this.f_5e916dd2 - 1.0));
            }
         }

         if (this.f_5e916dd2 > 2.0) {
            this.f_e8bb4155 = true;
            this.m_aba20313();
         }
      }
   }

   public boolean m_79e29869() {
      return this.f_f1e8de73 < C0114.bootstrap<"call",0,1>();
   }

   public void m_02f7cd79() {
      this.f_5e916dd2 = 3.0;
      this.f_e8bb4155 = true;
   }

   public void m_bb3577b4() {
      this.m_a596028a(0L);
   }

   public void m_a596028a(long var1) {
      this.f_e8bb4155 = false;
      this.f_5e916dd2 = 0.0;
      this.f_f1e8de73 = C0114.bootstrap<"call",2,1>() + var1;
   }

   public boolean m_f6c24736() {
      return this.f_5e916dd2 >= 2.0;
   }

   protected abstract void m_d070a77e(double var1);

   protected void m_aba20313() {
   }

   public C0233.anonymousdefault m_6912143e() {
      return this.f_f349702d;
   }

   public boolean m_32e9c27f() {
      return this.f_c49dc127;
   }

   public boolean m_122d6961() {
      return this.f_e8bb4155;
   }

   public float m_f4536bb8() {
      return this.f_219ad2dc;
   }

   public float m_af722891() {
      return this.f_6c1b324a;
   }

   public double m_f4becd01() {
      return this.f_69be6268;
   }

   public double m_fbc7bd89() {
      return this.f_5e916dd2;
   }

   public long m_c358fa15() {
      return this.f_5bfc6133;
   }

   public long m_17dfa685() {
      return this.f_f1e8de73;
   }

   public float m_916eca6b() {
      return this.f_6e2ec8d1;
   }

   public void m_fae54ac4(C0233.anonymousdefault var1) {
      this.f_f349702d = var1;
   }

   public void m_6a0b904b(boolean var1) {
      this.f_c49dc127 = var1;
   }

   public void m_7adf7912(boolean var1) {
      this.f_e8bb4155 = var1;
   }

   public void m_c640086b(float var1) {
      this.f_219ad2dc = var1;
   }

   public void m_1e2629d5(float var1) {
      this.f_6c1b324a = var1;
   }

   public void m_13aa06ec(double var1) {
      this.f_69be6268 = var1;
   }

   public void m_ce14c099(double var1) {
      this.f_5e916dd2 = var1;
   }

   public void m_8a2ca2b1(long var1) {
      this.f_5bfc6133 = var1;
   }

   public void m_c791de3f(long var1) {
      this.f_f1e8de73 = var1;
   }

   public void m_d8f67499(float var1) {
      this.f_6e2ec8d1 = var1;
   }

   public static enum anonymousdefault {
      f_805d07d6,
      f_be178d18,
      f_e79129df;

      private anonymousdefault() {
      }

      public double m_66568d49(double var1) {
         switch (this) {
            case f_805d07d6:
               return 1.0 - C0114.bootstrap<"call",0,1>(1.0 - var1, 4.0);
            case f_be178d18:
               return C0114.bootstrap<"call",1,1>(1.0 - C0114.bootstrap<"call",0,1>(var1 - 1.0, 2.0));
            case f_e79129df:
               return var1;
            default:
               throw new RuntimeException(C0252.bootstrap<"get",17179869265>());
         }
      }

      public double m_dcd2a2cd(double var1) {
         switch (this) {
            case f_805d07d6:
               return var1 < 0.5 ? 8.0 * var1 * var1 * var1 * var1 : 1.0 - C0114.bootstrap<"call",0,1>(-2.0 * var1 + 2.0, 4.0) / 2.0;
            case f_be178d18:
               return var1 < 0.5
                  ? (1.0 - C0114.bootstrap<"call",1,1>(1.0 - C0114.bootstrap<"call",0,1>(2.0 * var1, 2.0))) / 2.0
                  : (C0114.bootstrap<"call",1,1>(1.0 - C0114.bootstrap<"call",0,1>(-2.0 * var1 + 2.0, 2.0)) + 1.0) / 2.0;
            case f_e79129df:
               return var1;
            default:
               throw new RuntimeException(C0252.bootstrap<"get",17179869265>());
         }
      }
   }
}
