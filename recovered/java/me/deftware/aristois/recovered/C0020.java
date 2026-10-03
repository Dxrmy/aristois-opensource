package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;

public class C0020 extends C0001 {
   public C0020() {
   }

   public static void m_427b4082(double var0, double var2, double var4) {
      EntityPlayer var6 = (EntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      double var7 = var0 + 0.5 - var6.getPosX();
      double var9 = var2 + 0.5 - (var6.getPosY() + var6.getEyeHeight());
      double var11 = var4 + 0.5 - var6.getPosZ();
      double var13 = C0114.bootstrap<"call",2,1>(var7 * var7 + var11 * var11);
      float var15 = (float)C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var11, var7)) - 90.0F;
      float var16 = (float)(-C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var9, var13)));
      C0114.bootstrap<"call",5,1>(var15, var16);
   }

   private static void m_15b344e3(float var0, float var1) {
      EntityPlayer var2 = (EntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      var2.setPositionAndRotation(var2.getPosX(), var2.getPosY(), var2.getPosZ(), var0, var1);
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934659>())
                     .then(
                        C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934660>())
                           .then(
                              C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934661>(), C0114.bootstrap<"call",1,1>())
                                 .then(
                                    C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934662>(), C0114.bootstrap<"call",1,1>())
                                       .then(
                                          C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934663>(), C0114.bootstrap<"call",1,1>())
                                             .executes(
                                                var0 -> {
                                                   C0114.bootstrap<"call",1,1>(
                                                      C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934661>()),
                                                      C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934662>()),
                                                      C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934663>())
                                                   );
                                                   C0114.bootstrap<"call",4,1>(
                                                      C0114.bootstrap<"call",3,1>(
                                                         C0252.bootstrap<"get",8589934681>(),
                                                         new Object[]{
                                                            C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934661>())),
                                                            C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934662>())),
                                                            C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934663>()))
                                                         }
                                                      )
                                                   );
                                                   return 1;
                                                }
                                             )
                                       )
                                 )
                           )
                     ))
                  .then(
                     C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934664>())
                        .then(
                           C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934665>(), C0114.bootstrap<"call",3,1>())
                              .then(
                                 C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934666>(), C0114.bootstrap<"call",3,1>())
                                    .executes(
                                       var0 -> {
                                          C0114.bootstrap<"call",1,1>(
                                             C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934665>()),
                                             C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934666>())
                                          );
                                          C0114.bootstrap<"call",2,1>()
                                             .m_5de8d0b8(
                                                C0252.bootstrap<"get",8589934680>(),
                                                C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934665>())),
                                                C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934666>()))
                                             )
                                             .m_66e721c0();
                                          return 1;
                                       }
                                    )
                              )
                        )
                  ))
               .then(
                  ((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(
                                       C0252.bootstrap<"get",8589934667>()
                                    )
                                    .then(
                                       C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934668>())
                                          .executes(
                                             var0 -> {
                                                C0114.bootstrap<"call",2,1>(
                                                   ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).getRotationYaw(),
                                                   90.0F
                                                );
                                                C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",8589934679>());
                                                return 1;
                                             }
                                          )
                                    ))
                                 .then(
                                    C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934669>())
                                       .executes(
                                          var0 -> {
                                             C0114.bootstrap<"call",2,1>(
                                                ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).getRotationYaw(),
                                                -90.0F
                                             );
                                             C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",8589934678>());
                                             return 1;
                                          }
                                       )
                                 ))
                              .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934670>()).executes(var0 -> {
                                 C0114.bootstrap<"call",0,1>(90.0F, 0.0F);
                                 C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934677>());
                                 return 1;
                              })))
                           .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934671>()).executes(var0 -> {
                              C0114.bootstrap<"call",0,1>(-90.0F, 0.0F);
                              C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934676>());
                              return 1;
                           })))
                        .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934672>()).executes(var0 -> {
                           C0114.bootstrap<"call",0,1>(-180.0F, 0.0F);
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934675>());
                           return 1;
                        })))
                     .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934673>()).executes(var0 -> {
                        C0114.bootstrap<"call",5,1>(0.0F, 0.0F);
                        C0114.bootstrap<"call",6,1>(C0252.bootstrap<"get",8589934674>());
                        return 1;
                     }))
               )
         );
   }
}
