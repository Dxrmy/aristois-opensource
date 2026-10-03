package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.chunk.Randomizer;

public interface C0054 {
   List<BlockPosition> m_e0905a96(Randomizer var1, BlockPosition var2, C0055 var3);

   default double m_f12790b0(double var1, double var3, double var5) {
      return var3 + var1 * (var5 - var3);
   }

   default int m_14e8f24c(Randomizer var1, int var2) {
      return C0114.bootstrap<"call",0,1>((var1._nextFloat() - var1._nextFloat()) * (float)var2);
   }

   static boolean m_e1216b1c(BlockPosition var0, Randomizer var1, float var2) {
      if (var2 != 0.0F && (var2 == 1.0F || !(var1._nextFloat() >= var2))) {
         ClientWorld var3 = C0114.bootstrap<"call",1,1>();

         for (EnumFacing var7 : C0114.bootstrap<"call",2,1>()) {
            if (var3._getBlockFromPosition(var0.offset(var7)).isAir() && var2 != 1.0F) {
               return false;
            }
         }

         return true;
      } else {
         return true;
      }
   }

   static boolean m_5221c14e(BlockPosition var0) {
      return C0114.bootstrap<"call",1,1>()._getBlockFromPosition(var0).isLiquid();
   }
}
