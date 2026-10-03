package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.camera.GameCamera;
import me.deftware.client.framework.render.gl.GLX;

public class C0235 {
   public static final int f_e4ac2bf2 = 16;
   public static final int f_1da93a6b = -149;
   public static final float f_466827c2 = 1.55F;
   public static final float f_3feb81d4 = 0.01F;
   private Color f_6e92465f;
   private Color f_97cdc6f3;
   private final RenderStack<?> f_ed9ca953;
   private float f_d7705e48 = -0.6F;
   private float f_17edafce = 120.0F;

   public C0235(RenderStack<?> var1) {
      this.f_ed9ca953 = var1;
   }

   public void m_51867dfb(double var1, double var3, double var5) {
      GameCamera var7 = Minecraft.getMinecraftGame().getCamera();
      double var8 = var1 - var7._getRenderPosX() + 0.5;
      double var10 = var3 + 1.0 + 1.5 - var7._getRenderPosY();
      double var12 = var5 - var7._getRenderPosZ() + 0.5;
      GLX.INSTANCE.translate(var8, var10, var12);
   }

   public void m_4d0be663(Entity var1, float var2) {
      GameCamera var3 = Minecraft.getMinecraftGame().getCamera();
      double var4 = var1.getLastTickPosX() + (var1.getPosX() - var1.getLastTickPosX()) * (double)var2 - var3._getRenderPosX();
      double var6 = var1.getLastTickPosY() + (var1.getPosY() - var1.getLastTickPosY()) * (double)var2 - var3._getRenderPosY() + (double)var1.getHeight() + 0.5;
      double var8 = var1.getLastTickPosZ() + (var1.getPosZ() - var1.getLastTickPosZ()) * (double)var2 - var3._getRenderPosZ();
      GLX.INSTANCE.translate(var4, var6, var8);
   }

   public void m_1058ed9a() {
      GameCamera var1 = Minecraft.getMinecraftGame().getCamera();
      GLX.INSTANCE.rotate(-var1._getRotationYaw(), 0.0F, 1.0F, 0.0F);
      GLX.INSTANCE.rotate(var1._getRotationPitch(), 1.0F, 0.0F, 0.0F);
   }

   public void m_83bfd21c(float var1, float var2, float var3, float var4) {
      this.f_ed9ca953.glColor(this.f_6e92465f, this.f_17edafce);
      this.m_a46e03ec(7, var1, var2, var3, var4, this.f_d7705e48);
      this.f_ed9ca953.glColor(this.f_97cdc6f3, 180.0F);
      this.m_a46e03ec(3, var1, var2, var3, var4, this.f_d7705e48 + 0.01F);
   }

   public void m_b3f5ba69(Message var1, int var2, int var3, float var4) {
      this.m_9dcf0c73(var1, var2, var3, var4, this.f_d7705e48 + 0.01F);
   }

   public void m_9dcf0c73(Message var1, int var2, int var3, float var4, float var5) {
      int var6 = FontRenderer.getStringWidth(var1);
      int var7 = FontRenderer.getFontHeight();
      GLX.INSTANCE.push();
      GLX.INSTANCE.translate((float)var2, (float)var3, var5);
      GLX.INSTANCE.scale(var4, var4, 1.0F);
      FontRenderer.drawStringWithShadow(var1, -(var6 / 2), -(var7 / 2), 16777215);
      GLX.INSTANCE.pop();
   }

   public void m_a46e03ec(int var1, float var2, float var3, float var4, float var5, float var6) {
      this.f_ed9ca953.begin(var1);
      this.f_ed9ca953.vertex((double)(var2 + var4), (double)var3, (double)var6).next();
      this.f_ed9ca953.vertex((double)var2, (double)var3, (double)var6).next();
      this.f_ed9ca953.vertex((double)var2, (double)(var3 + var5), (double)var6).next();
      this.f_ed9ca953.vertex((double)(var2 + var4), (double)(var3 + var5), (double)var6).next();
      if (var1 == 3) {
         this.f_ed9ca953.vertex((double)(var2 + var4), (double)var3, (double)var6).next();
      }

      this.f_ed9ca953.end();
   }

   public void m_9c021b2e(Color var1, Color var2) {
      this.f_6e92465f = var1;
      this.f_97cdc6f3 = var2;
   }

   public void m_d881d3e3(float var1) {
      this.f_d7705e48 = var1;
   }

   public void m_35bea3d9(float var1) {
      this.f_17edafce = var1;
   }

   public void m_b728afce() {
      this.f_d7705e48 += 0.01F;
   }

   public void m_0e265701() {
      this.f_d7705e48 -= 0.01F;
   }
}
