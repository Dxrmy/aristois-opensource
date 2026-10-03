package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.block.Block;

public class C0423 {
   private static final List<Block> f_ba350994 = C0207.m_2290cbf8(BlockRegistry.INSTANCE, C0259.m_ec4ef19a(), C0256.m_56d4c1c7());
   private final List<Vector3d> f_4fcf0554 = new ArrayList<>();
   private final Vector3d f_2c3f0483;
   private final Vector3d f_e6de17e1;

   public void m_1058ed9a() {
   }

   public List<Vector3d> m_e5a9f586(double var1, int var3) {
      ArrayList var4 = new ArrayList();
      double var5 = var1 / (double)var3;

      for (int var7 = 1; var7 <= var3; var7++) {
         Vector3d var8 = m_710c5c50(this.f_2c3f0483, this.f_e6de17e1, var5 * (double)var7);
         var8 = var8.floor();
         var4.add(m_8f7ee5a2(var8));
      }

      return var4;
   }

   public static Vector3d m_710c5c50(Vector3d var0, Vector3d var1, double var2) {
      return var0.add(var1.getX() * var2, var1.getY() * var2, var1.getZ() * var2);
   }

   public static Vector3d m_8f7ee5a2(Vector3d var0) {
      while (!m_0f5f600f(var0)) {
         var0 = var0.add(0.0, 1.0, 0.0);
      }

      return var0;
   }

   public static boolean m_8030b52d(Vector3d var0) {
      return m_0f5f600f(var0) && m_0f5f600f(var0.add(0.0, 1.0, 0.0));
   }

   public static boolean m_0f5f600f(Vector3d var0) {
      return m_d553f392(m_73206229(var0));
   }

   public static boolean m_d553f392(Block var0) {
      return var0.isAir() || f_ba350994.contains(var0);
   }

   public static Block m_73206229(Vector3d var0) {
      return ClientWorld.getClientWorld()._getBlockFromPosition(new DoubleBlockPosition(var0.getX(), var0.getY(), var0.getZ()));
   }

   public C0423(Vector3d var1, Vector3d var2) {
      this.f_2c3f0483 = var1;
      this.f_e6de17e1 = var2;
   }

   public List<Vector3d> m_ed46fa58() {
      return this.f_4fcf0554;
   }
}
