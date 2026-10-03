package me.deftware.aristois.recovered;

import java.awt.Color;

public class C0166 {
   private float f_9fa36fc1;
   private float f_9d881954;
   private float f_65a3af9c;
   private float f_aa4a5195;

   public C0166(Color var1) {
      float[] var2 = new float[3];
      C0114.bootstrap<"call",0,1>(var1.getRed(), var1.getGreen(), var1.getBlue(), var2);
      this.f_9fa36fc1 = var2[0];
      this.f_9d881954 = var2[1];
      this.f_65a3af9c = var2[2];
      this.f_aa4a5195 = (float)var1.getAlpha() / 255.0F;
   }

   public Color m_5b89869c() {
      int var1 = C0114.bootstrap<"call",0,1>(this.f_9fa36fc1, this.f_9d881954, this.f_65a3af9c);
      float var2 = (float)(var1 >> 16 & 0xFF) / 255.0F;
      float var3 = (float)(var1 >> 8 & 0xFF) / 255.0F;
      float var4 = (float)(var1 & 0xFF) / 255.0F;
      return new Color(var2, var3, var4, this.f_aa4a5195);
   }

   public float[] m_4ba17468(C0165 var1) {
      return new float[]{(float)((double)this.f_9d881954 * var1.m_830cb294()), (float)((double)this.f_65a3af9c * var1.m_fc7f45bc())};
   }

   public float m_465cf460(C0165 var1) {
      return (float)((double)this.f_9fa36fc1 * var1.m_830cb294());
   }

   public float m_b3f9c1e7(C0165 var1) {
      return (float)((double)this.f_aa4a5195 * var1.m_fc7f45bc());
   }

   public static float[] m_a82ee51a(C0165 var0, float var1, float var2) {
      return new float[]{(float)(((double)var2 - var0.m_5a998971()) / var0.m_fc7f45bc()), (float)(((double)var1 - var0.m_14f8bc2c()) / var0.m_830cb294())};
   }

   public static float m_d342b1d7(C0165 var0, float var1) {
      return (float)(((double)var1 - var0.m_14f8bc2c()) / var0.m_830cb294());
   }

   public static float m_1749176f(C0165 var0, float var1) {
      return (float)(((double)var1 - var0.m_5a998971()) / var0.m_fc7f45bc());
   }

   public void m_320c5fb0(float var1) {
      this.f_9fa36fc1 = C0114.bootstrap<"call",1,1>(0.0F, 1.0F, var1);
   }

   public void m_efd91349(float var1) {
      this.f_9d881954 = C0114.bootstrap<"call",0,1>(0.0F, 1.0F, var1);
   }

   public void m_1e16d95c(float var1) {
      this.f_65a3af9c = C0114.bootstrap<"call",0,1>(0.0F, 1.0F, var1);
   }

   public void m_d0e6d123(float var1) {
      this.f_aa4a5195 = C0114.bootstrap<"call",0,1>(0.0F, 1.0F, var1);
   }

   public static float m_8fca39a8(float var0, float var1, float var2) {
      return C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(var0, var2), var1);
   }

   public float m_4aa4ec3c() {
      return this.f_9fa36fc1;
   }

   public float m_2fede234() {
      return this.f_9d881954;
   }

   public float m_b801f681() {
      return this.f_65a3af9c;
   }

   public float m_d5422ff5() {
      return this.f_aa4a5195;
   }

   public C0166(float var1, float var2, float var3, float var4) {
      this.f_9fa36fc1 = var1;
      this.f_9d881954 = var2;
      this.f_65a3af9c = var3;
      this.f_aa4a5195 = var4;
   }
}
