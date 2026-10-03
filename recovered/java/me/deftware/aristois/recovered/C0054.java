package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.chunk.Randomizer;

public interface C0054 {
   List<BlockPosition> m_f01e936e(Randomizer var1, BlockPosition var2, C0055 var3);

   default double m_1e69e97a(double var1, double var3, double var5) {
      return var3 + var1 * (var5 - var3);
   }

   default int m_b84bbeb1(Randomizer var1, int var2) {
      return Math.round((var1._nextFloat() - var1._nextFloat()) * (float)var2);
   }

   static boolean m_10f75f15(BlockPosition var0, Randomizer var1, float var2) {
      if (var2 != 0.0F && (var2 == 1.0F || !(var1._nextFloat() >= var2))) {
         ClientWorld var3 = ClientWorld.getClientWorld();

         for (EnumFacing var7 : EnumFacing.values()) {
            if (var3._getBlockFromPosition(var0.offset(var7)).isAir() && var2 != 1.0F) {
               return false;
            }
         }

         return true;
      } else {
         return true;
      }
   }

   static boolean m_1c39af64(BlockPosition var0) {
      return ClientWorld.getClientWorld()._getBlockFromPosition(var0).isLiquid();
   }
}
