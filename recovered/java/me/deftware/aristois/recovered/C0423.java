package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.block.Block;

public class C0423 {
   private static final List<Block> f_b5afd926 = C0114.bootstrap<"call",0,1>(
      BlockRegistry.INSTANCE, new String[]{C0252.bootstrap<"get",42949673084>(), C0252.bootstrap<"get",55834574885>()}
   );
   private final List<Vector3d> f_5b4a8c0a = new ArrayList<>();
   private final Vector3d f_2289f530;
   private final Vector3d f_84474922;

   public void m_f4a51dde() {
   }

   public List<Vector3d> m_c330436f(double var1, int var3) {
      ArrayList var4 = new ArrayList();
      double var5 = var1 / (double)var3;

      for (int var7 = 1; var7 <= var3; var7++) {
         Vector3d var8 = C0114.bootstrap<"call",0,1>(this.f_2289f530, this.f_84474922, var5 * (double)var7);
         var8 = var8.floor();
         var4.add(C0114.bootstrap<"call",1,1>(var8));
      }

      return var4;
   }

   public static Vector3d m_d8318434(Vector3d var0, Vector3d var1, double var2) {
      return var0.add(var1.getX() * var2, var1.getY() * var2, var1.getZ() * var2);
   }

   public static Vector3d m_fa8f7093(Vector3d var0) {
      while (!C0114.bootstrap<"call",2,1>(var0)) {
         var0 = var0.add(0.0, 1.0, 0.0);
      }

      return var0;
   }

   public static boolean m_7c9fc603(Vector3d var0) {
      return C0114.bootstrap<"call",0,1>(var0) && C0114.bootstrap<"call",0,1>(var0.add(0.0, 1.0, 0.0));
   }

   public static boolean m_03446c4f(Vector3d var0) {
      return C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var0));
   }

   public static boolean m_ae240ab7(Block var0) {
      return var0.isAir() || f_b5afd926.contains(var0);
   }

   public static Block m_439c95d7(Vector3d var0) {
      return C0114.bootstrap<"call",0,1>()._getBlockFromPosition(new DoubleBlockPosition(var0.getX(), var0.getY(), var0.getZ()));
   }

   public C0423(Vector3d var1, Vector3d var2) {
      this.f_2289f530 = var1;
      this.f_84474922 = var2;
   }

   public List<Vector3d> m_fff2514a() {
      return this.f_5b4a8c0a;
   }
}
