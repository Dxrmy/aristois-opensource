package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.world.chunk.Randomizer;

public class C0056 implements C0054 {
   public static final C0056 f_265014c5 = new C0056();

   public C0056() {
   }

   public List<BlockPosition> m_ab099dfb(Randomizer var1, BlockPosition var2, C0055 var3) {
      float var4 = var1._nextFloat() * 3.1415927F;
      float var5 = (float)var3.f_9f831d7a / 8.0F;
      int var6 = (int)C0114.bootstrap<"call",0,1>((double)(((float)var3.f_9f831d7a / 16.0F * 2.0F + 1.0F) / 2.0F));
      double var7 = var2.getX() + C0114.bootstrap<"call",1,1>((double)var4) * (double)var5;
      double var9 = var2.getX() - C0114.bootstrap<"call",1,1>((double)var4) * (double)var5;
      double var11 = var2.getZ() + C0114.bootstrap<"call",2,1>((double)var4) * (double)var5;
      double var13 = var2.getZ() - C0114.bootstrap<"call",2,1>((double)var4) * (double)var5;
      double var15 = var2.getY() + (double)var1._nextInt(3) - 2.0;
      double var17 = var2.getY() + (double)var1._nextInt(3) - 2.0;
      int var19 = (int)(var2.getX() - C0114.bootstrap<"call",0,1>((double)var5) - (double)var6);
      int var20 = (int)(var2.getY() - 2.0 - (double)var6);
      int var21 = (int)(var2.getZ() - C0114.bootstrap<"call",0,1>((double)var5) - (double)var6);
      int var22 = 2 * (int)(C0114.bootstrap<"call",0,1>((double)var5) + (double)var6);
      int var23 = 2 * (2 + var6);
      return this.m_767e80d2(var1, var3, var7, var9, var11, var13, var15, var17, var19, var20, var21, var22, var23);
   }

   private List<BlockPosition> m_767e80d2(
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
      double[] var22 = new double[var2.f_9f831d7a * 4];

      for (int var23 = 0; var23 < var2.f_9f831d7a; var23++) {
         float var24 = (float)var23 / (float)var2.f_9f831d7a;
         double var25 = this.m_4c33c511((double)var24, var3, var5);
         double var27 = this.m_4c33c511((double)var24, var11, var13);
         double var29 = this.m_4c33c511((double)var24, var7, var9);
         double var31 = var1._nextDouble() * (double)var2.f_9f831d7a / 16.0;
         double var33 = ((C0114.bootstrap<"call",1,1>((double)(3.1415927F * var24)) + 1.0) * var31 + 1.0) / 2.0;
         var22[var23 * 4] = var25;
         var22[var23 * 4 + 1] = var27;
         var22[var23 * 4 + 2] = var29;
         var22[var23 * 4 + 3] = var33;
      }

      for (int var49 = 0; var49 < var2.f_9f831d7a - 1; var49++) {
         if (!(var22[var49 * 4 + 3] <= 0.0)) {
            for (int var51 = var49 + 1; var51 < var2.f_9f831d7a; var51++) {
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

      for (int var50 = 0; var50 < var2.f_9f831d7a; var50++) {
         double var52 = var22[var50 * 4 + 3];
         if (!(var52 < 0.0)) {
            double var26 = var22[var50 * 4];
            double var28 = var22[var50 * 4 + 1];
            double var30 = var22[var50 * 4 + 2];
            int var32 = (int)C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var26 - var52), (double)var15);
            int var57 = (int)C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var28 - var52), (double)var16);
            int var34 = (int)C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var30 - var52), (double)var17);
            int var35 = (int)C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var26 + var52), (double)var32);
            int var36 = (int)C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var28 + var52), (double)var57);
            int var37 = (int)C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var30 + var52), (double)var34);

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
                                    if (!C0451.f_6cf0f98d.m_91f6dde0(var48)
                                       && !C0114.bootstrap<"call",5,1>(var48)
                                       && C0114.bootstrap<"call",6,1>(var48, var1, var2.f_66f9eacf)) {
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
