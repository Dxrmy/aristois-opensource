package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.main.bootstrap.Bootstrap;

public class C0023 extends C0001 {
   public C0023() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_88726494())
                  .then(LiteralArgumentBuilder.literal(C0253.m_27479cfa()).executes(var0 -> {
                     C0454 var1 = C0242.m_fc1b642c().m_a88b18cc();
                     if (var1 != null && var1.m_8d50206e()) {
                        try {
                           var1.f_f16b38e7.close();
                        } catch (Throwable var3) {
                        }
                     } else {
                        C0064.m_7853c016().m_ee04ba1b(C0253.m_d9b37a36()).m_1058ed9a();
                     }

                     return 1;
                  })))
               .then(
                  LiteralArgumentBuilder.literal(C0253.m_23f794da())
                     .then(RequiredArgumentBuilder.argument(C0253.m_cc27b633(), StringArgumentType.greedyString()).executes(var0 -> {
                        String var1 = m_34e7ac0f(StringArgumentType.getString(var0, C0253.m_cc27b633()));
                        String var2 = Bootstrap.EMCSettings.getPrimitive(C0253.m_df6e621c(), C0253.m_56242a84());
                        if (var1.equals(var2)) {
                           m_333019c8(String.format(C0253.m_9e27f038(), var1));
                        } else {
                           Main.getConfig().putPrimitive(C0253.m_af41331f(), var1);
                           Main.getConfig().save();
                           m_a11708c5(C0253.m_f257bcca() + var1);
                        }

                        return 1;
                     }))
               )
         );
   }

   protected static String m_34e7ac0f(String var0) {
      if (var0.startsWith(C0264.m_c04d8f6e()) && var0.endsWith(C0264.m_c04d8f6e())) {
         var0 = var0.substring(1, var0.length() - 1);
      }

      return var0;
   }
}
