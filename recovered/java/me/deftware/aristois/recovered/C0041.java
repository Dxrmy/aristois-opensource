package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0041 extends C0001 {
   public C0041() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0264.m_83f6dd00())
               .then(
                  ((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0264.m_56c1229f())
                        .then(RequiredArgumentBuilder.argument(C0264.m_0d6ae39b(), IntegerArgumentType.integer()).executes(var0 -> {
                           int var1 = IntegerArgumentType.getInteger(var0, C0264.m_0d6ae39b());
                           Minecraft.getMinecraftGame().getGameChat().remove(var1);
                           return 1;
                        })))
                     .then(LiteralArgumentBuilder.literal(C0264.m_65d43991()).executes(var0 -> {
                        m_1058ed9a();
                        return 1;
                     }))
               )
         );
   }

   public static void m_1058ed9a() {
      Minecraft.getMinecraftGame()
         .getGameChat()
         .remove(
            var0 -> var0.startsWith(C0264.m_5fa6dd07())
                  || var0.startsWith(C0264.m_e07cee76())
                  || var0.startsWith(C0264.m_c6614274())
                  || var0.startsWith(C0253.m_44418b5d())
                  || var0.startsWith(C0253.m_813e3509())
         );
   }
}
