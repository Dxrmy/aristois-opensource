package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.network.packets.CPacketChatMessage;

public class C0030 extends C0001 {
   public C0030() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_8d7dbe31())
               .then(RequiredArgumentBuilder.argument(C0266.m_1d87ef21(), StringArgumentType.greedyString()).executes(var0 -> {
                  String var1 = StringArgumentType.getString(var0, C0266.m_1d87ef21());
                  new CPacketChatMessage(var1).sendPacket();
                  return 1;
               }))
         );
   }
}
