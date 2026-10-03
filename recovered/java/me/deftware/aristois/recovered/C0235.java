package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.camera.GameCamera;
import me.deftware.client.framework.render.gl.GLX;

public class C0235 {
   public static final int f_52466849 = 16;
   public static final int f_f378f5c2 = -149;
   public static final float f_89840c5c = 1.55F;
   public static final float f_542c9fdc = 0.01F;
   private Color f_04385b8b;
   private Color f_c0429434;
   private final RenderStack<?> f_24144ac3;
   private float f_34b208e0 = -0.6F;
   private float f_7059365d = 120.0F;

   public C0235(RenderStack<?> var1) {
      this.f_24144ac3 = var1;
   }

   public void m_1a9869f9(double var1, double var3, double var5) {
      GameCamera var7 = C0114.bootstrap<"call",0,1>().getCamera();
      double var8 = var1 - var7._getRenderPosX() + 0.5;
      double var10 = var3 + 1.0 + 1.5 - var7._getRenderPosY();
      double var12 = var5 - var7._getRenderPosZ() + 0.5;
      GLX.INSTANCE.translate(var8, var10, var12);
   }

   public void m_869ae6af(Entity var1, float var2) {
      GameCamera var3 = C0114.bootstrap<"call",0,1>().getCamera();
      double var4 = var1.getLastTickPosX() + (var1.getPosX() - var1.getLastTickPosX()) * (double)var2 - var3._getRenderPosX();
      double var6 = var1.getLastTickPosY() + (var1.getPosY() - var1.getLastTickPosY()) * (double)var2 - var3._getRenderPosY() + (double)var1.getHeight() + 0.5;
      double var8 = var1.getLastTickPosZ() + (var1.getPosZ() - var1.getLastTickPosZ()) * (double)var2 - var3._getRenderPosZ();
      GLX.INSTANCE.translate(var4, var6, var8);
   }

   public void m_bbaf6fd7() {
      GameCamera var1 = C0114.bootstrap<"call",0,1>().getCamera();
      GLX.INSTANCE.rotate(-var1._getRotationYaw(), 0.0F, 1.0F, 0.0F);
      GLX.INSTANCE.rotate(var1._getRotationPitch(), 1.0F, 0.0F, 0.0F);
   }

   public void m_fc6a6527(float var1, float var2, float var3, float var4) {
      this.f_24144ac3.glColor(this.f_04385b8b, this.f_7059365d);
      this.m_c8a71e0f(7, var1, var2, var3, var4, this.f_34b208e0);
      this.f_24144ac3.glColor(this.f_c0429434, 180.0F);
      this.m_c8a71e0f(3, var1, var2, var3, var4, this.f_34b208e0 + 0.01F);
   }

   public void m_e6245666(Message var1, int var2, int var3, float var4) {
      this.m_95033f97(var1, var2, var3, var4, this.f_34b208e0 + 0.01F);
   }

   public void m_95033f97(Message var1, int var2, int var3, float var4, float var5) {
      int var6 = C0114.bootstrap<"call",1,1>(var1);
      int var7 = C0114.bootstrap<"call",2,1>();
      GLX.INSTANCE.push();
      GLX.INSTANCE.translate((float)var2, (float)var3, var5);
      GLX.INSTANCE.scale(var4, var4, 1.0F);
      C0114.bootstrap<"call",3,1>(var1, -(var6 / 2), -(var7 / 2), 16777215);
      GLX.INSTANCE.pop();
   }

   public void m_c8a71e0f(int var1, float var2, float var3, float var4, float var5, float var6) {
      this.f_24144ac3.begin(var1);
      this.f_24144ac3.vertex((double)(var2 + var4), (double)var3, (double)var6).next();
      this.f_24144ac3.vertex((double)var2, (double)var3, (double)var6).next();
      this.f_24144ac3.vertex((double)var2, (double)(var3 + var5), (double)var6).next();
      this.f_24144ac3.vertex((double)(var2 + var4), (double)(var3 + var5), (double)var6).next();
      if (var1 == 3) {
         this.f_24144ac3.vertex((double)(var2 + var4), (double)var3, (double)var6).next();
      }

      this.f_24144ac3.end();
   }

   public void m_22393fbb(Color var1, Color var2) {
      this.f_04385b8b = var1;
      this.f_c0429434 = var2;
   }

   public void m_bde31b64(float var1) {
      this.f_34b208e0 = var1;
   }

   public void m_3bd6a2e1(float var1) {
      this.f_7059365d = var1;
   }

   public void m_eb726812() {
      this.f_34b208e0 += 0.01F;
   }

   public void m_739bd448() {
      this.f_34b208e0 -= 0.01F;
   }
}
