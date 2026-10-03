package me.deftware.aristois.services.types.baritone;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import me.deftware.aristois.services.Registry;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.CommandResult;
import me.deftware.client.framework.command.EMCModCommand;

public class BaritoneCommand extends EMCModCommand {
   private final BaritoneService service = Registry.Baritone.getService();

   public BaritoneCommand() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(
                                 "baritone"
                              )
                              .executes(c -> {
                                 this.service.sendCommand("help");
                                 return 1;
                              }))
                           .then(
                              LiteralArgumentBuilder.literal("mine")
                                 .then(RequiredArgumentBuilder.argument("block", StringArgumentType.greedyString()).executes(c -> {
                                    CommandResult r = new CommandResult(c);
                                    this.service.sendCommand("mine " + r.getString("block"));
                                    return 1;
                                 }))
                           ))
                        .then(
                           LiteralArgumentBuilder.literal("goto")
                              .then(
                                 RequiredArgumentBuilder.argument("x", IntegerArgumentType.integer())
                                    .then(RequiredArgumentBuilder.argument("z", IntegerArgumentType.integer()).executes(c -> {
                                       CommandResult r = new CommandResult(c);
                                       this.service.sendCommand("goto " + r.getInteger("x") + " " + r.getInteger("z"));
                                       return 1;
                                    }))
                              )
                        ))
                     .then(LiteralArgumentBuilder.literal("stop").executes(c -> {
                        this.service.sendCommand("stop");
                        return 1;
                     })))
                  .then(LiteralArgumentBuilder.literal("help").executes(c -> {
                     this.service.sendCommand("help");
                     return 1;
                  })))
               .then(RequiredArgumentBuilder.argument("other_command", StringArgumentType.greedyString()).executes(c -> {
                  CommandResult r = new CommandResult(c);
                  if (!this.service.sendCommand(r.getString("other_command"))) {
                     throw new SimpleCommandExceptionType(() -> "Unknown Baritone Command: " + r.getString("other_command").split("\\s")[0]).create();
                  } else {
                     return 1;
                  }
               }))
         )
         .registerAlias("b");
   }
}
