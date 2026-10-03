package me.deftware.aristois.recovered;

import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;

public class C0452 extends EMCModCommand {
   public C0452() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder().set(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",60129542189>()));
   }
}
