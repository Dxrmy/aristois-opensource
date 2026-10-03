package me.deftware.aristois.recovered;

import me.deftware.client.framework.render.batching.font.FontRenderStack;

public abstract class C0428 implements C0194, C0445, C0444, C0442, C0441.anonymouscatch, C0443 {
   protected C0165 f_ecdaef4d;
   protected C0163 f_a02a43ba;
   protected C0441 f_8977a028;
   protected C0425[] f_77aabeb5;
   protected C0426[] f_d44a9447;
   protected boolean f_e07dabcf = false;
   protected C0153 f_65f94d17;
   protected String f_6b0c86b4;
   protected C0094<?> f_dfd85aa1 = null;
   protected FontRenderStack f_a6de628b;

   public C0428(double var1, double var3, double var5, double var7, C0441 var9) {
      this.f_ecdaef4d = new C0165(var1, var3, var5, var7);
      this.f_8977a028 = var9;
      this.f_a6de628b = var9.m_4aa3f6de();
   }

   public void m_48b4b9e3(C0163 var1) {
      this.f_a02a43ba = var1;
      this.f_ecdaef4d.m_b772f454(var1.m_fd6ca281());
   }

   public void m_5e8b61b6(C0425... var1) {
      this.f_77aabeb5 = var1;
   }

   public void m_ff5b1808(C0426... var1) {
      this.f_d44a9447 = var1;
   }

   public C0165 m_64effff1() {
      return this.f_ecdaef4d;
   }

   public C0163 m_dc1d6e80() {
      return this.f_a02a43ba;
   }

   public C0441 m_9d182a67() {
      return this.f_8977a028;
   }

   public C0425[] m_6688b007() {
      return this.f_77aabeb5;
   }

   public C0426[] m_a6219bf3() {
      return this.f_d44a9447;
   }

   public boolean m_43fd3006() {
      return this.f_e07dabcf;
   }

   public void m_e307ff31(boolean var1) {
      this.f_e07dabcf = var1;
   }

   public C0153 m_df23f495() {
      return this.f_65f94d17;
   }

   public void m_1bc7dc2b(C0153 var1) {
      this.f_65f94d17 = var1;
   }

   public String m_e587325e() {
      return this.f_6b0c86b4;
   }

   public void m_7d6917ef(String var1) {
      this.f_6b0c86b4 = var1;
   }

   public C0094<?> m_4aa13764() {
      return this.f_dfd85aa1;
   }

   public void m_44e91820(C0094<?> var1) {
      this.f_dfd85aa1 = var1;
   }

   public void m_d11d9cac(FontRenderStack var1) {
      this.f_a6de628b = var1;
   }
}
