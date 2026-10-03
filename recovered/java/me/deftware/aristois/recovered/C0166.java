package me.deftware.aristois.recovered;

import java.awt.Color;

public class C0166 {
   private float f_0a925639;
   private float f_68076908;
   private float f_04e431bf;
   private float f_2c25a57a;

   public C0166(Color var1) {
      float[] var2 = new float[3];
      Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), var2);
      this.f_0a925639 = var2[0];
      this.f_68076908 = var2[1];
      this.f_04e431bf = var2[2];
      this.f_2c25a57a = (float)var1.getAlpha() / 255.0F;
   }

   public Color m_1eb3a72b() {
      int var1 = Color.HSBtoRGB(this.f_0a925639, this.f_68076908, this.f_04e431bf);
      float var2 = (float)(var1 >> 16 & 0xFF) / 255.0F;
      float var3 = (float)(var1 >> 8 & 0xFF) / 255.0F;
      float var4 = (float)(var1 & 0xFF) / 255.0F;
      return new Color(var2, var3, var4, this.f_2c25a57a);
   }

   public float[] m_256c8d7c(C0165 var1) {
      return new float[]{(float)((double)this.f_68076908 * var1.m_4388ac29()), (float)((double)this.f_04e431bf * var1.m_d42f3372())};
   }

   public float m_cc777dd6(C0165 var1) {
      return (float)((double)this.f_0a925639 * var1.m_4388ac29());
   }

   public float m_33038309(C0165 var1) {
      return (float)((double)this.f_2c25a57a * var1.m_d42f3372());
   }

   public static float[] m_24754b34(C0165 var0, float var1, float var2) {
      return new float[]{(float)(((double)var2 - var0.m_84808068()) / var0.m_d42f3372()), (float)(((double)var1 - var0.m_a005efae()) / var0.m_4388ac29())};
   }

   public static float m_99ce45d4(C0165 var0, float var1) {
      return (float)(((double)var1 - var0.m_a005efae()) / var0.m_4388ac29());
   }

   public static float m_445d0468(C0165 var0, float var1) {
      return (float)(((double)var1 - var0.m_84808068()) / var0.m_d42f3372());
   }

   public void m_d881d3e3(float var1) {
      this.f_0a925639 = m_5472ad7f(0.0F, 1.0F, var1);
   }

   public void m_35bea3d9(float var1) {
      this.f_68076908 = m_5472ad7f(0.0F, 1.0F, var1);
   }

   public void m_180537c9(float var1) {
      this.f_04e431bf = m_5472ad7f(0.0F, 1.0F, var1);
   }

   public void m_fad9e546(float var1) {
      this.f_2c25a57a = m_5472ad7f(0.0F, 1.0F, var1);
   }

   public static float m_5472ad7f(float var0, float var1, float var2) {
      return Math.min(Math.max(var0, var2), var1);
   }

   public float m_b7fbb877() {
      return this.f_0a925639;
   }

   public float m_f3107a2c() {
      return this.f_68076908;
   }

   public float m_ec7fb983() {
      return this.f_04e431bf;
   }

   public float m_4fa7ddfe() {
      return this.f_2c25a57a;
   }

   public C0166(float var1, float var2, float var3, float var4) {
      this.f_0a925639 = var1;
      this.f_68076908 = var2;
      this.f_04e431bf = var3;
      this.f_2c25a57a = var4;
   }
}
