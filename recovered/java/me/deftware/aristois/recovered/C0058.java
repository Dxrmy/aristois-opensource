package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.chunk.Randomizer;

public class C0058 implements C0054 {
   public static final C0058 f_0c7a8cb0 = new C0058();

   public C0058() {
   }

   @Override
   public List<BlockPosition> m_f01e936e(Randomizer var1, BlockPosition var2, C0055 var3) {
      ArrayList var4 = new ArrayList();
      int var5 = var3.f_e282479e;
      int var6 = var1._nextInt(var5 + 1);
      ClientWorld var7 = ClientWorld.getClientWorld();

      for (int var8 = 0; var8 < var6; var8++) {
         var5 = Math.min(var8, 7);
         double var9 = (double)this.m_b84bbeb1(var1, var5) + var2.getX();
         double var11 = (double)this.m_b84bbeb1(var1, var5) + var2.getY();
         double var13 = (double)this.m_b84bbeb1(var1, var5) + var2.getZ();
         DoubleBlockPosition var15 = new DoubleBlockPosition(var9, var11, var13);
         if (!var7._getBlockFromPosition(var15).isAir() && C0054.m_10f75f15(var15, var1, var3.f_ff7fba00)) {
            var4.add(var15);
         }
      }

      return var4;
   }
}
