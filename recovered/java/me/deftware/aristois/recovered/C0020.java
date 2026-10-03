package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Objects;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0020 extends C0001 {
   public C0020() {
   }

   public static void m_51867dfb(double var0, double var2, double var4) {
      EntityPlayer var6 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      double var7 = var0 + 0.5 - var6.getPosX();
      double var9 = var2 + 0.5 - (var6.getPosY() + var6.getEyeHeight());
      double var11 = var4 + 0.5 - var6.getPosZ();
      double var13 = Math.sqrt(var7 * var7 + var11 * var11);
      float var15 = (float)Math.toDegrees(Math.atan2(var11, var7)) - 90.0F;
      float var16 = (float)(-Math.toDegrees(Math.atan2(var9, var13)));
      m_35086e37(var15, var16);
   }

   private static void m_35086e37(float var0, float var1) {
      EntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      var2.setPositionAndRotation(var2.getPosX(), var2.getPosY(), var2.getPosZ(), var0, var1);
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_9d6ca6d0())
                     .then(
                        LiteralArgumentBuilder.literal(C0253.m_87c16989())
                           .then(
                              RequiredArgumentBuilder.argument(C0253.m_b0896de7(), DoubleArgumentType.doubleArg())
                                 .then(
                                    RequiredArgumentBuilder.argument(C0253.m_593ecbab(), DoubleArgumentType.doubleArg())
                                       .then(
                                          RequiredArgumentBuilder.argument(C0253.m_17d51275(), DoubleArgumentType.doubleArg())
                                             .executes(
                                                var0 -> {
                                                   m_51867dfb(
                                                      DoubleArgumentType.getDouble(var0, C0253.m_b0896de7()),
                                                      DoubleArgumentType.getDouble(var0, C0253.m_593ecbab()),
                                                      DoubleArgumentType.getDouble(var0, C0253.m_17d51275())
                                                   );
                                                   m_a11708c5(
                                                      String.format(
                                                         C0253.m_1b17f04f(),
                                                         DoubleArgumentType.getDouble(var0, C0253.m_b0896de7()),
                                                         DoubleArgumentType.getDouble(var0, C0253.m_593ecbab()),
                                                         DoubleArgumentType.getDouble(var0, C0253.m_17d51275())
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
                     LiteralArgumentBuilder.literal(C0253.m_00ba16c2())
                        .then(
                           RequiredArgumentBuilder.argument(C0253.m_d1f7b79f(), FloatArgumentType.floatArg())
                              .then(
                                 RequiredArgumentBuilder.argument(C0253.m_a29090eb(), FloatArgumentType.floatArg())
                                    .executes(
                                       var0 -> {
                                          m_35086e37(FloatArgumentType.getFloat(var0, C0253.m_d1f7b79f()), FloatArgumentType.getFloat(var0, C0253.m_a29090eb()));
                                          C0064.m_13c9ffeb()
                                             .m_ecf8e7ae(
                                                C0253.m_0425f2ec(),
                                                FloatArgumentType.getFloat(var0, C0253.m_d1f7b79f()),
                                                FloatArgumentType.getFloat(var0, C0253.m_a29090eb())
                                             )
                                             .m_1058ed9a();
                                          return 1;
                                       }
                                    )
                              )
                        )
                  ))
               .then(
                  ((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(
                                       C0253.m_b2dd5137()
                                    )
                                    .then(LiteralArgumentBuilder.literal(C0253.m_91e95cb4()).executes(var0 -> {
                                       m_35086e37(Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).getRotationYaw(), 90.0F);
                                       m_a11708c5(C0253.m_d0da63e8());
                                       return 1;
                                    })))
                                 .then(LiteralArgumentBuilder.literal(C0253.m_1616e137()).executes(var0 -> {
                                    m_35086e37(Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).getRotationYaw(), -90.0F);
                                    m_a11708c5(C0253.m_e8fd0250());
                                    return 1;
                                 })))
                              .then(LiteralArgumentBuilder.literal(C0253.m_6dc2a812()).executes(var0 -> {
                                 m_35086e37(90.0F, 0.0F);
                                 m_a11708c5(C0253.m_16315846());
                                 return 1;
                              })))
                           .then(LiteralArgumentBuilder.literal(C0253.m_e7934778()).executes(var0 -> {
                              m_35086e37(-90.0F, 0.0F);
                              m_a11708c5(C0253.m_a55b07ff());
                              return 1;
                           })))
                        .then(LiteralArgumentBuilder.literal(C0253.m_d0e43f69()).executes(var0 -> {
                           m_35086e37(-180.0F, 0.0F);
                           m_a11708c5(C0253.m_19faa493());
                           return 1;
                        })))
                     .then(LiteralArgumentBuilder.literal(C0253.m_812ab029()).executes(var0 -> {
                        m_35086e37(0.0F, 0.0F);
                        m_a11708c5(C0253.m_11f0c704());
                        return 1;
                     }))
               )
         );
   }
}
