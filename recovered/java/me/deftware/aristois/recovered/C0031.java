package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.minecraft.ServerDetails;

public class C0031 extends C0001 {
   public C0031() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(
                           C0252.bootstrap<"get",12884901898>()
                        )
                        .executes(var1 -> {
                           this.m_17a66855();
                           return 1;
                        }))
                     .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901899>()).executes(var0 -> {
                        C0114.bootstrap<"call",0,1>()._disconnect();
                        return 1;
                     })))
                  .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901900>()).executes(var0 -> {
                     if (C0114.bootstrap<"call",0,1>().getLastConnectedServer() != null) {
                        C0114.bootstrap<"call",1,1>()._disconnect();
                        C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",0,1>().getLastConnectedServer());
                     } else {
                        C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",12884901907>());
                     }

                     return 1;
                  })))
               .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967296>()).executes(var1 -> {
                  this.m_17a66855();
                  return 1;
               }))
         );
   }

   private void m_17a66855() {
      if (C0114.bootstrap<"call",0,1>()._isSinglePlayer()) {
         C0114.bootstrap<"call",1,1>().m_77a7bc18(C0252.bootstrap<"get",12884901901>()).m_66e721c0();
      } else {
         try {
            ServerDetails var1 = C0114.bootstrap<"call",0,1>().getConnectedServer();
            if (var1 == null) {
               throw new Exception(C0252.bootstrap<"get",12884901902>());
            }

            C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",12884901903>() + C0114.bootstrap<"call",2,1>());
            C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",12884901904>() + var1._getAddress());
            C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",12884901905>() + var1._getMotd());
         } catch (Exception var2) {
            C0114.bootstrap<"call",4,1>().m_77a7bc18(C0252.bootstrap<"get",12884901906>()).m_66e721c0();
         }
      }
   }
}
