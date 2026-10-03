package me.deftware.aristois.services.types.baritone;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.aristois.recovered.C0012;
import me.deftware.aristois.recovered.C0244;
import me.deftware.aristois.services.Registry;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.CommandResult;
import me.deftware.client.framework.command.EMCModCommand;

public class BaritoneGotoCommand extends EMCModCommand {
   private final BaritoneService service = Registry.Baritone.getService();

   public BaritoneGotoCommand() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set((LiteralArgumentBuilder)LiteralArgumentBuilder.literal("goto").then(RequiredArgumentBuilder.argument("point", new C0012()).executes(c -> {
            CommandResult r = new CommandResult(c);
            C0244 point = (C0244)r.getCustom("point", C0244.class);
            this.service.sendCommand(String.format("goto %s %s %s", point.m_93e58820(), point.m_aa5acfd6(), point.m_b0090208()));
            return 1;
         })));
   }
}
