package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.box.BoundingBox;
import me.deftware.client.framework.math.vector.Vector3d;

public class C0218 {
   public C0218() {
   }

   public static float[] m_46b5ed05(Vector3d var0, Vector3d var1) {
      double var2 = var1.getX() - var0.getX();
      double var4 = var1.getY() - var0.getY();
      double var6 = var1.getZ() - var0.getZ();
      double var8 = C0114.bootstrap<"call",0,1>(var2 * var2 + var6 * var6);
      float var10 = (float)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var6, var2)) - 90.0F;
      float var11 = (float)(-C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var4, var8)));
      return new float[]{C0114.bootstrap<"call",3,1>(var10), C0114.bootstrap<"call",3,1>(var11)};
   }

   public static void m_a851bc0a(Entity var0, Entity var1, Runnable var2) {
      BoundingBox var3 = var1.getBoundingBox();
      Vector3d var4 = var3.getCenter();
      C0114.bootstrap<"call",4,1>(var0, var4, var2);
   }

   public static void m_32f0c7f9(Entity var0, Vector3d var1, Runnable var2) {
      float[] var3 = C0114.bootstrap<"call",5,1>(var0.getEyesPos(), var1);
      if (var2 != null) {
         C0271.f_e53f9422.m_13afcfef(var3[0], var3[1], 1, var2);
      } else {
         var0.setRotationYaw(var3[0]);
         var0.setRotationPitch(var3[1]);
      }
   }

   public static float m_b3337afc(float var0) {
      float var1 = var0 % 360.0F;
      if (var1 >= 180.0F) {
         var1 -= 360.0F;
      }

      if (var1 < -180.0F) {
         var1 += 360.0F;
      }

      return var1;
   }

   public static Vector3d m_d3753e84(float[] var0) {
      return C0114.bootstrap<"call",6,1>(var0[1], var0[0]);
   }

   public static Vector3d m_7405f1e7(float var0, float var1) {
      float var2 = var0 * 0.017453292F;
      float var3 = -var1 * 0.017453292F;
      double var4 = C0114.bootstrap<"call",7,1>((double)var3);
      double var6 = C0114.bootstrap<"call",8,1>((double)var3);
      double var8 = C0114.bootstrap<"call",7,1>((double)var2);
      double var10 = C0114.bootstrap<"call",8,1>((double)var2);
      return new Vector3d(var6 * var8, -var10, var4 * var8);
   }
}
