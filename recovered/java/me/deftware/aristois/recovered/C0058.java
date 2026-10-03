package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.chunk.Randomizer;

public class C0058 implements C0054 {
   public static final C0058 f_3dfc769b = new C0058();

   public C0058() {
   }

   public List<BlockPosition> m_88d02457(Randomizer var1, BlockPosition var2, C0055 var3) {
      ArrayList var4 = new ArrayList();
      int var5 = var3.f_9f831d7a;
      int var6 = var1._nextInt(var5 + 1);
      ClientWorld var7 = C0114.bootstrap<"call",0,1>();

      for (int var8 = 0; var8 < var6; var8++) {
         var5 = C0114.bootstrap<"call",1,1>(var8, 7);
         double var9 = (double)this.m_a83c6f95(var1, var5) + var2.getX();
         double var11 = (double)this.m_a83c6f95(var1, var5) + var2.getY();
         double var13 = (double)this.m_a83c6f95(var1, var5) + var2.getZ();
         DoubleBlockPosition var15 = new DoubleBlockPosition(var9, var11, var13);
         if (!var7._getBlockFromPosition(var15).isAir() && C0114.bootstrap<"call",2,1>(var15, var1, var3.f_66f9eacf)) {
            var4.add(var15);
         }
      }

      return var4;
   }
}
