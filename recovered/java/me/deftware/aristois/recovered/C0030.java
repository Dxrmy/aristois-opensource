package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.network.packets.CPacketChatMessage;

public class C0030 extends C0001 {
   public C0030() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901896>())
               .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",12884901897>(), C0114.bootstrap<"call",1,1>()).executes(var0 -> {
                  String var1 = C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",12884901897>());
                  new CPacketChatMessage(var1).sendPacket();
                  return 1;
               }))
         );
   }
}
