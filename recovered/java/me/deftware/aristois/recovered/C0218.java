package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.box.BoundingBox;
import me.deftware.client.framework.math.vector.Vector3d;

public class C0218 {
   public C0218() {
   }

   public static float[] m_9a6f1709(Vector3d var0, Vector3d var1) {
      double var2 = var1.getX() - var0.getX();
      double var4 = var1.getY() - var0.getY();
      double var6 = var1.getZ() - var0.getZ();
      double var8 = Math.sqrt(var2 * var2 + var6 * var6);
      float var10 = (float)Math.toDegrees(Math.atan2(var6, var2)) - 90.0F;
      float var11 = (float)(-Math.toDegrees(Math.atan2(var4, var8)));
      return new float[]{m_9036e749(var10), m_9036e749(var11)};
   }

   public static void m_1878c38f(Entity var0, Entity var1, Runnable var2) {
      BoundingBox var3 = var1.getBoundingBox();
      Vector3d var4 = var3.getCenter();
      m_7805b8c6(var0, var4, var2);
   }

   public static void m_7805b8c6(Entity var0, Vector3d var1, Runnable var2) {
      float[] var3 = m_9a6f1709(var0.getEyesPos(), var1);
      if (var2 != null) {
         C0271.f_15eacd20.m_6696523b(var3[0], var3[1], 1, var2);
      } else {
         var0.setRotationYaw(var3[0]);
         var0.setRotationPitch(var3[1]);
      }
   }

   public static float m_9036e749(float var0) {
      float var1 = var0 % 360.0F;
      if (var1 >= 180.0F) {
         var1 -= 360.0F;
      }

      if (var1 < -180.0F) {
         var1 += 360.0F;
      }

      return var1;
   }

   public static Vector3d m_b07d9977(float[] var0) {
      return m_638f7bc6(var0[1], var0[0]);
   }

   public static Vector3d m_638f7bc6(float var0, float var1) {
      float var2 = var0 * 0.017453292F;
      float var3 = -var1 * 0.017453292F;
      double var4 = Math.cos((double)var3);
      double var6 = Math.sin((double)var3);
      double var8 = Math.cos((double)var2);
      double var10 = Math.sin((double)var2);
      return new Vector3d(var6 * var8, -var10, var4 * var8);
   }
}
