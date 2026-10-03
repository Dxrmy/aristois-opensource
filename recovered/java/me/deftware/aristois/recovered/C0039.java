package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0039 extends C0001 {
   private static final List<Class<?>> f_69b4145d = Arrays.asList(File.class, Runnable.class, C0245.class);

   public C0039() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_2e834348())
               .then(
                  ((RequiredArgumentBuilder)((RequiredArgumentBuilder)RequiredArgumentBuilder.argument(C0264.m_0425f2ec(), new C0004(true))
                           .then(
                              ((RequiredArgumentBuilder)((RequiredArgumentBuilder)RequiredArgumentBuilder.argument(C0264.m_d0da63e8(), new C0011())
                                       .then(
                                          RequiredArgumentBuilder.argument(C0266.m_e07cee76(), new C0010())
                                             .executes(
                                                var1 -> this.m_b94f6c5b(
                                                      (C0217.anonymousthis)var1.getArgument(C0264.m_0425f2ec(), AbstractMod.class),
                                                      (C0094<?>)var1.getArgument(C0264.m_d0da63e8(), C0094.class),
                                                      StringArgumentType.getString(var1, C0266.m_e07cee76())
                                                   )
                                             )
                                       ))
                                    .executes(var0 -> {
                                       C0094 var1 = (C0094)var0.getArgument(C0264.m_d0da63e8(), C0094.class);
                                       if (!var1.m_e606d819() && !f_69b4145d.contains(var1.m_01d9ec36())) {
                                          C0064.m_b79f2e94().m_2c2620fc(C0266.m_88937f2b()).m_ee04ba1b(C0266.m_e9914bd3()).m_1058ed9a();
                                       } else {
                                          var1.m_a4e51be1().m_b9cf1f73(var1);
                                       }

                                       return 1;
                                    }))
                                 .then(
                                    LiteralArgumentBuilder.literal(C0253.m_733bff3d())
                                       .executes(var1 -> this.m_ed6f6f94((C0092)var1.getArgument(C0264.m_d0da63e8(), C0094.class)))
                                 )
                           ))
                        .then(
                           LiteralArgumentBuilder.literal(C0253.m_733bff3d())
                              .executes(var1 -> this.m_ed6f6f94((C0092)var1.getArgument(C0264.m_0425f2ec(), AbstractMod.class)))
                        ))
                     .executes(var0 -> {
                        C0064.m_b79f2e94().m_2c2620fc(C0266.m_88937f2b()).m_ee04ba1b(C0266.m_396f9431()).m_1058ed9a();
                        return 1;
                     })
               )
         )
         .registerAlias(C0266.m_7b0db73e());
   }

   private <T extends C0092 & C0217.anonymousthis> int m_ed6f6f94(T var1) {
      C0064.m_13c9ffeb().m_2c2620fc(C0266.m_056a389d() + ((C0217.anonymousthis)var1).m_6f1f396d()).m_f41992de(var1.m_6fc98322()).m_1058ed9a();
      return 1;
   }

   private int m_b94f6c5b(C0217.anonymousthis var1, C0094<?> var2, String var3) {
      return C0217.m_7a4f2a3d(
         () -> {
            if (!var2.m_1a28c037(var3)) {
               throw new Exception(C0266.m_5fa6dd07());
            } else {
               Message var2x = new Builder()
                  .append(C0266.m_5f1ab561(), Appearance.of(DefaultColors.GRAY))
                  .append(var2.m_6f1f396d(), Appearance.of(DefaultColors.YELLOW))
                  .append(C0266.m_28b2c020(), Appearance.of(DefaultColors.GRAY))
                  .append(var3, Appearance.of(DefaultColors.GREEN))
                  .build();
               C0064.m_13c9ffeb().m_2c2620fc(C0266.m_45aaaba8()).m_f41992de(var2x).m_1058ed9a();
               return 1;
            }
         }
      );
   }
}
