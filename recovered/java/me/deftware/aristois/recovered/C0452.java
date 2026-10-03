package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;

public class C0452 extends EMCModCommand {
   public C0452() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder().set(LiteralArgumentBuilder.literal(C0258.m_760db7bb()));
   }
}
