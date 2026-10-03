package me.deftware.aristois.recovered;

import me.deftware.client.framework.render.batching.font.FontRenderStack;

public abstract class C0428 implements C0194, C0445, C0444, C0442, C0441.anonymouscatch, C0443 {
   protected C0165 f_7fd3d7b7;
   protected C0163 f_bbba86c8;
   protected C0441 f_02ea293d;
   protected C0425[] f_0076d3e2;
   protected C0426[] f_58772717;
   protected boolean f_a54daaa0 = false;
   protected C0153 f_d340a97e;
   protected String f_8c564866;
   protected C0094<?> f_2334429f = null;
   protected FontRenderStack f_360de984;

   public C0428(double var1, double var3, double var5, double var7, C0441 var9) {
      this.f_7fd3d7b7 = new C0165(var1, var3, var5, var7);
      this.f_02ea293d = var9;
      this.f_360de984 = var9.m_d996e5c5();
   }

   @Override
   public void m_facdcfcf(C0163 var1) {
      this.f_bbba86c8 = var1;
      this.f_7fd3d7b7.m_8d8487f4(var1.m_44bb072f());
   }

   @Override
   public void m_e0dc32f6(C0425... var1) {
      this.f_0076d3e2 = var1;
   }

   @Override
   public void m_ec141b95(C0426... var1) {
      this.f_58772717 = var1;
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_7fd3d7b7;
   }

   @Override
   public C0163 m_4b7a3f6e() {
      return this.f_bbba86c8;
   }

   @Override
   public C0441 m_519f75ae() {
      return this.f_02ea293d;
   }

   @Override
   public C0425[] m_47e0d826() {
      return this.f_0076d3e2;
   }

   @Override
   public C0426[] m_15a3a860() {
      return this.f_58772717;
   }

   @Override
   public boolean m_f21a055b() {
      return this.f_a54daaa0;
   }

   @Override
   public void m_d6ac7420(boolean var1) {
      this.f_a54daaa0 = var1;
   }

   @Override
   public C0153 m_75885561() {
      return this.f_d340a97e;
   }

   @Override
   public void m_c7a3618c(C0153 var1) {
      this.f_d340a97e = var1;
   }

   public String m_3d3a8736() {
      return this.f_8c564866;
   }

   public void m_a11708c5(String var1) {
      this.f_8c564866 = var1;
   }

   public C0094<?> m_42d188d9() {
      return this.f_2334429f;
   }

   public void m_876939c7(C0094<?> var1) {
      this.f_2334429f = var1;
   }

   public void m_b3d7bc43(FontRenderStack var1) {
      this.f_360de984 = var1;
   }
}
