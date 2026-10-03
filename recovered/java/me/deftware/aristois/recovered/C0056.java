package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.world.chunk.Randomizer;

public class C0056 implements C0054 {
   public static final C0056 f_c13a777d = new C0056();

   public C0056() {
   }

   @Override
   public List<BlockPosition> m_f01e936e(Randomizer var1, BlockPosition var2, C0055 var3) {
      float var4 = var1._nextFloat() * 3.1415927F;
      float var5 = (float)var3.f_e282479e / 8.0F;
      int var6 = (int)Math.ceil((double)(((float)var3.f_e282479e / 16.0F * 2.0F + 1.0F) / 2.0F));
      double var7 = var2.getX() + Math.sin((double)var4) * (double)var5;
      double var9 = var2.getX() - Math.sin((double)var4) * (double)var5;
      double var11 = var2.getZ() + Math.cos((double)var4) * (double)var5;
      double var13 = var2.getZ() - Math.cos((double)var4) * (double)var5;
      double var15 = var2.getY() + (double)var1._nextInt(3) - 2.0;
      double var17 = var2.getY() + (double)var1._nextInt(3) - 2.0;
      int var19 = (int)(var2.getX() - Math.ceil((double)var5) - (double)var6);
      int var20 = (int)(var2.getY() - 2.0 - (double)var6);
      int var21 = (int)(var2.getZ() - Math.ceil((double)var5) - (double)var6);
      int var22 = 2 * (int)(Math.ceil((double)var5) + (double)var6);
      int var23 = 2 * (2 + var6);
      return this.m_113f695c(var1, var3, var7, var9, var11, var13, var15, var17, var19, var20, var21, var22, var23);
   }

   private List<BlockPosition> m_113f695c(
      Randomizer var1,
      C0055 var2,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      int var15,
      int var16,
      int var17,
      int var18,
      int var19
   ) {
      ArrayList var20 = new ArrayList();
      BitSet var21 = new BitSet(var18 * var19 * var18);
      double[] var22 = new double[var2.f_e282479e * 4];

      for (int var23 = 0; var23 < var2.f_e282479e; var23++) {
         float var24 = (float)var23 / (float)var2.f_e282479e;
         double var25 = this.m_1e69e97a((double)var24, var3, var5);
         double var27 = this.m_1e69e97a((double)var24, var11, var13);
         double var29 = this.m_1e69e97a((double)var24, var7, var9);
         double var31 = var1._nextDouble() * (double)var2.f_e282479e / 16.0;
         double var33 = ((Math.sin((double)(3.1415927F * var24)) + 1.0) * var31 + 1.0) / 2.0;
         var22[var23 * 4] = var25;
         var22[var23 * 4 + 1] = var27;
         var22[var23 * 4 + 2] = var29;
         var22[var23 * 4 + 3] = var33;
      }

      for (int var49 = 0; var49 < var2.f_e282479e - 1; var49++) {
         if (!(var22[var49 * 4 + 3] <= 0.0)) {
            for (int var51 = var49 + 1; var51 < var2.f_e282479e; var51++) {
               if (!(var22[var51 * 4 + 3] <= 0.0)) {
                  double var53 = var22[var49 * 4] - var22[var51 * 4];
                  double var54 = var22[var49 * 4 + 1] - var22[var51 * 4 + 1];
                  double var55 = var22[var49 * 4 + 2] - var22[var51 * 4 + 2];
                  double var56 = var22[var49 * 4 + 3] - var22[var51 * 4 + 3];
                  if (var56 * var56 > var53 * var53 + var54 * var54 + var55 * var55) {
                     if (var56 > 0.0) {
                        var22[var51 * 4 + 3] = -1.0;
                     } else {
                        var22[var49 * 4 + 3] = -1.0;
                     }
                  }
               }
            }
         }
      }

      for (int var50 = 0; var50 < var2.f_e282479e; var50++) {
         double var52 = var22[var50 * 4 + 3];
         if (!(var52 < 0.0)) {
            double var26 = var22[var50 * 4];
            double var28 = var22[var50 * 4 + 1];
            double var30 = var22[var50 * 4 + 2];
            int var32 = (int)Math.max(Math.floor(var26 - var52), (double)var15);
            int var57 = (int)Math.max(Math.floor(var28 - var52), (double)var16);
            int var34 = (int)Math.max(Math.floor(var30 - var52), (double)var17);
            int var35 = (int)Math.max(Math.floor(var26 + var52), (double)var32);
            int var36 = (int)Math.max(Math.floor(var28 + var52), (double)var57);
            int var37 = (int)Math.max(Math.floor(var30 + var52), (double)var34);

            for (int var38 = var32; var38 <= var35; var38++) {
               double var39 = ((double)var38 + 0.5 - var26) / var52;
               if (var39 * var39 < 1.0) {
                  for (int var41 = var57; var41 <= var36; var41++) {
                     double var42 = ((double)var41 + 0.5 - var28) / var52;
                     if (var39 * var39 + var42 * var42 < 1.0) {
                        for (int var44 = var34; var44 <= var37; var44++) {
                           double var45 = ((double)var44 + 0.5 - var30) / var52;
                           if (var39 * var39 + var42 * var42 + var45 * var45 < 1.0) {
                              int var47 = var38 - var15 + (var41 - var16) * var18 + (var44 - var17) * var18 * var19;
                              if (!var21.get(var47)) {
                                 var21.set(var47);
                                 if (var41 >= -64 && var41 < 320) {
                                    DoubleBlockPosition var48 = new DoubleBlockPosition((double)var38, (double)var41, (double)var44);
                                    if (!C0451.f_3c37bf88.m_1a0730f0(var48) && !C0054.m_1c39af64(var48) && C0054.m_10f75f15(var48, var1, var2.f_ff7fba00)) {
                                       var20.add(var48);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var20;
   }
}
