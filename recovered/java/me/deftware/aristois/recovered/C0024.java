package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;

public class C0024 extends C0001 {
   public C0024() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_88937f2b())
               .then(RequiredArgumentBuilder.argument(C0253.m_396f9431(), StringArgumentType.greedyString()).executes(var0 -> {
                  print(C0197.m_683b6390(StringArgumentType.getString(var0, C0253.m_396f9431()), C0257.m_d1f7b79f()));
                  return 1;
               }))
         );
   }
}
